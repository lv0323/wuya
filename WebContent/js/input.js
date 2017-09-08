var input = {
	
	aImg:[],
	imgNum:0,
		
	init:function(){
		$('.m-imgs').on('click','a',function(e){
			var oImg = $(this).parent().parent();
			var subjectID = oImg.attr('subjectID');
			var smallSubjectID = oImg.attr('smallSubjectID');
			oImg.remove();
			input.answer(subjectID,smallSubjectID);
		}) 

		$('.m-imgs img').each(function(){
			input.resetImg(this)
		})
		
		$('.m-imgs').on('mousedown',function(e){
			e.stopPropagation();
			var disX,disY,pX,pY;
			var target=$(e.target).parent();
			var index=$(e.target).parent().parent().index();
			var oAdd=$(e.target).parent().parent().siblings('.u-drag');
			var oImgs=$(e.target).parent().parent().parent().find('.u-img')
			if(e.target.tagName.toLowerCase()==='img'){
				var src=$(e.target).clone();
		        disX=e.pageX-target.position().left;
		        disY=e.pageY-target.position().top;
		        pX=target.position().left;
		        pY=target.position().top;
		        oAdd.append(src);
		        $(document).on('mousemove',function(e){
		            oAdd.show().css({'left':pX,'top':pY});
		            var l=e.pageX-disX;
		            var t=e.pageY-disY;
		            var maxL=target.parent().parent().width()-target.width();
		            var maxT=target.parent().parent().height()-target.height();
		            
		            l=l<0?0:l;
		            l=l>maxL?maxL:l;
		            t=t<0?0:t;
		            t=t>maxT?maxT:t;
		            oAdd.css({left:l,top:t});
		            oImgs.removeClass('cur');
		            var oNear=input.getNearest(oAdd,oImgs);
		            if(oNear){
		            	$(oNear).addClass('cur');
		            }
		        })
		        $(document).on('mouseup',function(){
		        	var temp;
		        	var oNear = input.getNearest(oAdd,oImgs);
		        	var oSrc=oAdd.find('img');
		        	if(oNear){
		        		temp=$(oNear).find('img');
		        		$(oNear).removeClass('cur').find('img').replaceWith(oSrc);
		        		target.find('img').replaceWith(temp);
		        	}
		        	oAdd.html('').hide();
		        	$(document).off();
					
		        	//提交试题答案 submit
		        	var oImg = target.parent();
		        	var subjectID = oImg.attr('subjectID');
		        	var smallSubjectID = oImg.attr('smallSubjectID');
		        	input.answer(subjectID,smallSubjectID); 
		        })
		        
			}else if (e.target.className==='iconfont') {
				var key=$(e.target).parent().parent().index();
				input.aImg.splice(key,1);
				
			}else if (e.target.className==='u-preview') {
				e.stopPropagation();
				
				//TODO 点击的时候维护aImgs数组 
				
				var imgs = $(e.target).parent().parent().parent().find('img');
				input.aImg = [];
				for(var i= 0;i<imgs.length;i++){
					input.aImg.push(imgs.eq(i).attr('src'));
				}
				console.log(input.aImg);
				input.imgNum = $(e.target).parent().parent().index();
				input.loadImg();
				$.blockUI({ 
		            message: $('#imgLoop'), 
		            css: { 
		                width:'640px',
		                height:'640px',
		                border:0,
		                backgroundColor:'transparent'
		            }
		        });
		        $('.blockUI.blockMsg').css({
		        	"position":"absolute",
		        	"top":( $(window).height() -640 ) / 2+$(window).scrollTop() + "px",
		        	"left":( $(window).width() - 640 ) / 2+$(window).scrollLeft() + "px"      	
		        });
		        $('#imgClosed').click(function(){$.unblockUI();})
			}
			return false;
		})
		$('#f-lBtn').click(function(){
			if(input.imgNum <= 0){
				return;
			}
			input.imgNum--;
			input.loadImg();
		})
		
		$('#f-rBtn').click(function(){
			if(input.imgNum >= input.aImg.length-1){
				return;
			}
			input.imgNum++;
			input.loadImg();
		})
	},
	
	getDis:function(obj1,obj2){
		var a=obj1.position().left-obj2.position().left;
		var b=obj1.position().top-obj2.position().top;
		return Math.sqrt(a*a+b*b);
	},
	
	checkCollision:function(obj1,obj2){
		var l1=obj1.position().left;
		var r1=obj1.position().left+obj1.width();
		var t1=obj1.position().top;
		var b1=obj1.position().top+obj1.height();

		var l2=obj2.position().left;
		var r2=obj2.position().left+obj2.width();
		var t2=obj2.position().top;
		var b2=obj2.position().top+obj2.height();

	    if(l1>r2 || r1<l2 || t1>b2 || b1<t2){
	    	return false;
	    }else{
	    	return true;
	    }
	},
	
	getNearest:function(obj1,obj2){
		var iMin=3000,iMinIndex=-1;
		$.each(obj2,function(i){
			if(input.checkCollision(obj1,$(obj2.get(i)))){
				var dis=input.getDis(obj1,$(obj2.get(i)));
				if(iMin>dis){
					iMin=dis;
					iMinIndex=i;
				}
			}
		})
		if(iMinIndex===-1){
			return null;
		}else{
			return obj2.get(iMinIndex);
		}
	},
	
	resetImg:function(obj){
		obj.onload = function(){
			var ratio1=$(obj).width()/$(obj).height(),ratio2=220/168;
			if(ratio1<ratio2){
				$(obj).attr('width',220);
			}else {
				$(obj).attr('height',168)
			}		
		} 
	},
	
	
	fileSelected:function(subjectID,smallSubjectID) {
		var len = $('#imgs_'+smallSubjectID).find('img').length;
		if(len >=6 ){
			testing.tips('最多只能传六张！！！');
			return;
		}
	    var file = $('#fileToUpload_'+smallSubjectID)[0].files[0];
	    
	    if (file) {
	      input.ajaxFileUpload(subjectID,smallSubjectID);
	    }
	},
	
	ajaxFileUpload:function(subjectID,smallSubjectID){ 
	    $.ajaxFileUpload({
	    		type:'post', 
	    		data:{id:'',name:'',location:'testing'},  
	            url: ctx+'/common/upload', //用于文件上传的服务器端请求地址
	            secureuri: false, //是否需要安全协议，一般设置为false
	            fileElementId: 'fileToUpload_'+smallSubjectID, //文件上传域的ID
	            dataType: 'json', //返回值类型 一般设置为json
	            success: function (res, status){  //服务器成功响应处理函数
	                if(res.success){
	                	var data = res.result;
	                	input.insertImageView(data,subjectID,smallSubjectID);
	                }
	            },
	            error: function (data, status, e){//服务器响应失败处理函数
	                
	            }
	        }
	    )
	    return false;
	},
	
	insertImageView:function(data,subjectID,smallSubjectID){
		//1.
		var html = '<li class="u-img">'+
		'<div class="thumbnail">'+
		'<a href="javascript:;" class="iconfont">&#xe600;</a>'+
		'<img src="'+data.url+'" alt="">'+
		'<a href="javascript:;" class="u-preview">预览</a>'+
		'</div>'+
		'</li>'
		
		$(html).insertBefore($('#imgs_'+smallSubjectID).find('.u-add:first'));
		
		//2.	
	    var imgs = $('.m-imgs img');
		var img = imgs.eq(imgs.length-1);
		input.resetImg(img[0])
		input.answer(subjectID,smallSubjectID);
	},
	
	loadImg:function(){
	    $('#imgWrap').addClass('loading');
	    $('#imgWrap img').remove();
	    var oTemp=$('<img />');
	    var oNew=new Image();
	    oNew.onload=function(){
	    	$('#imgWrap').removeClass('loading');
	    	$(oTemp).attr('src',this.src);
	    	$('#imgWrap').append(oTemp);
	        if($(oTemp).width()>640 || $(oTemp).height()>640){
	        	if($(oTemp).width()/$(oTemp).height()<1){
	        		$(oTemp).attr('height',640);
	        	}else{
	        		$(oTemp).attr('width',640);
	        	}
	        }
	    }
	    oNew.src=input.aImg[input.imgNum];
	},
	
	//回答主观题
	answer:function(subjectID,smallSubjectID){
		var subject = SubjectLib.getCurrentSubject(subjectID, smallSubjectID);
		var userAnswer = [];
		$('#imgs_'+smallSubjectID).find('.u-img').each(function(){
			var src = $(this).find('img').attr('src');
			var item = {};
			item.url=src;
			item.text = '';
			userAnswer.push(item);
		});
		var answer = testing.buildAnswer(subject,JSON.stringify(userAnswer));
		AppUtils.doPost(testing.baseApi+'/testing/answer',answer,function(res){
			if(!res.success){
				AppUtils.alert('提交失败'); 
			}else{
				input.markFinish(subjectID);
				testing.updateUserAnswers(subject.smallSubjectID,userAnswer); 
			}
		})
	},
	
	//将完成的试题标记高亮
	markFinish:function(subjectID){
		var len = $('.m-imgs').find('img').length;
		if(len > 0){
			$('#x_'+subjectID).addClass('active');
		}else{
			$('#x_'+subjectID).removeClass('active');
		}
	}
} 