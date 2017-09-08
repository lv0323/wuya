/**
 * 华宾专属js，其他人勿动，切记切记
 */
var noefunc={
	showpanel:function(){
		var iW=0;
		$('#siftBtn').click(function(){
			iW=$('.ui-layout-west').width()+10;
            $('#siftPanel').css('width',iW);
		 	if($(this).hasClass('active')){
		 		$(this).removeClass('active');
		 		$('#siftPanel').animate({left:-iW+'px'},'fast');
		 	}else
		 	{
		 		$(this).addClass('active');
		 		$('#siftPanel').animate({left:'0'},'fast');
		 	}
		 })
		 $('#aSearch').click(function(){
		 	$('#siftBtn').removeClass('active');                          		 	                   
		 	$('#siftPanel').animate({left:-iW+'px'},'fast');
		 })
	},
	
	/**
	 * a是最外层的className
	 * b是下拉框ul的属性
	 * c是选中的取值
	 * d是自定义属性
	 * @author 华滨
	 */
	selt : function(a, b, c, d,func) {
		if($(a).find(c).siblings('input').val() == ''){
			$(a).find(c).addClass('ft');
		 	$(a).find(b+' a:first').addClass('ft');
		}   
		$(a).click(function(event) {
			event.stopPropagation();
			$(this).find(b).toggle();
			$(this).parent().siblings().find(".opt").hide();
		});
		
		$(document).click(
				function(event) {
					var eo = $(event.target);
					if ($(a).is(":visible") && eo.attr("class") != c
							&& !eo.parent(b).length)
						$(b).hide();
				});
		/* 赋值给文本框 */
		$(b).find("a").click(function() {
			var value1 = $(this).text();
			var title1 = $(this).attr('title')
			var value2 = $(this).attr(d);
			
			
			$(this).parent().parent().siblings(c).text($.trim(value1));
			$(this).parent().parent().siblings(c).attr('title',$.trim(title1));
			$(this).parent().parent().siblings('input').val(value2);
			
			if($(a).find(c).siblings('input').val() == ''){
				if($(this).parent().index()===0){
					$(this).parent().parent().siblings(c).addClass('ft');
				}else{
					$(this).parent().parent().siblings(c).removeClass('ft');
				}
			}
			
			if(func){
				func();	
			}
		})
	},
	
	seltBox : function(a, b, c, d,func) {
		if($(a).find(c).siblings('input').val() == ''){
			$(a).find(c).addClass('ft');
		 	$(a).find(b+' a:first').addClass('ft');
		}
		$(a).click(function(event) {
			event.stopPropagation();
			event.preventDefault();
			/*$(".selt-box").removeClass('z6');
			$(this).addClass('z6');*/
			$(".selt-box").not($(this)).find(b).hide();
			$(this).find(b).toggle();
			$(this).parent().siblings().find(b).hide();
		});
		
		$(document).click(
			function(event) {
				var eo = $(event.target);
				if ($(a).is(":visible") && eo.attr("class") != c
					&& !eo.parent(a).find(b).length)
				$(a).find(b).hide();
		});
		
		/* 赋值给文本框 */
		$(a).find(b).find("a").click(function() {
			var value1 = $(this).text();
			var title1 = $(this).attr('title');
			var value2 = $(this).attr(d);
			

			$(this).parent().parent().siblings(c).text(value1);
			$(this).parent().parent().siblings(c).attr('title',title1);
			$(this).parent().parent().siblings('input').val(value2).attr("valuename",title1);
			
			if($(this).parent().parent().siblings('input').val() === ''){
				if($(this).parent().index()===0){
					$(this).parent().parent().siblings(c).addClass('ft');
				}else{
					$(this).parent().parent().siblings(c).removeClass('ft');
				}
			}else{
				$(this).parent().parent().siblings(c).removeClass('ft');
			}
			
			
			if(func){
				func(value2, title1);
			}
		})
	},
	
	intSelect:function(a,b,c,d,f,func){
		   
		   /**
		   var flag=true;
		   $(a).find(c).val(f);
		   **/
		
	       $(a).click(function(event){   
				event.stopPropagation();
				event.preventDefault();
			    $(this).find(c).focus();
				$(this).find(b).toggle();
				$(this).parent().siblings().find(b).hide();
			});
			$(document).click(function(event){
				var eo=$(event.target);
				if($(a).is(":visible") && eo.attr("class")!=c && !eo.parent(b).length)
				$(b).hide();		
				
				/**
				if($(a).find(c).val()==''){
					$(a).find(c).val(f).css('color','#999');
					flag=true;
				}
				**/

			});
		    $(a).find(c).click(function (e) {
				e.stopPropagation();
				if($(this).is(':focus')){
					/**
					if(flag){
						$(this).val('');
						$(this).css('color','#333');
						flag=false;
					}
					**/
					
					$(this).parent().find(b).show();
					var $self=$(this);
					$(this).keyup(function (e) {
						if($(this).siblings(b).has('li') && $(this).val()!=''){
							$(this).siblings(b).find('li:first').addClass('bg');
						} else if(e.keyCode===8){
							if($(this).val() === ''){
								$(this).siblings(b).show().find('li').removeClass('bg')
							}
						} else {
							$(this).siblings(b).find('li').removeClass('bg');
						}
					})
					$(this).keydown(function (e) {
						if(e.keyCode===13 && $(this).siblings(b).find('li:first').hasClass('bg')){
							var val=$(this).siblings(b).find('li:first').text();
							val = $.trim(val);
						    $(this).val(val).parent().find(b).hide();
						    
						    var obj =  $(this).siblings(b).find("a"); 
						    var value1 = $(obj).text();
							var title1 = $(obj).attr('title');
							var value2 = $(obj).attr(d);
							
							obj.parent().parent().siblings(c).val(value1).css('color','#333');
							obj.parent().parent().siblings(c).attr('title',title1);
							obj.parent().parent().siblings('.qk').val(value2).attr("valuename",title1);
							
							if(func){
								func(value2, title1);
							}
						}
					})
					
					
					}else{
					$self.siblings(b).find('li').removeClass('bg');
					$self.parent().find(b).hide();
				}
			})
			/*赋值给文本框*/
			$(a).find(b).find("a").click(function(){
				var value1 = $(this).text();
				var title1 = $(this).attr('title');
				var value2 = $(this).attr(d);
				
				$(this).parent().parent().siblings(c).val(value1).css('color','#333');
				$(this).parent().parent().siblings(c).attr('title',title1);
				$(this).parent().parent().siblings('.qk').val(value2).attr("valuename",title1);
				
				if(func){
					func(value2, title1);
				}
			})

	 },
	 
	 intDragSelect : function(a,b,c,d,f,func2){
		 $(a).click(function(event){   
				event.stopPropagation();
				event.preventDefault();
			    $(this).find(c).focus();
				$(this).find(b).show();
			});
			$(document).click(function(event){
				var eo=$(event.target);
				if($(a).is(":visible") && eo.attr("class")!=c && !eo.parent(b).length)
				$(b).hide();									  
			});
		    $(a).find(c).click(function (e) {
				e.stopPropagation();
				if($(this).is(':focus')){
					$(this).parent().find(b).show();
					var $self=$(this);
					$(this).keyup(function (e) {
						$(this).val($.trim($(this).val()));
						if($(this).siblings(b).has('li') && $(this).val()!=''){
							$(this).siblings(b).find('li:first').addClass('bg');
						}else {
							$(this).siblings(b).find('li').removeClass('bg');
						}
					})
					$(this).keydown(function (e) {
						if(e.keyCode===13 && $(this).siblings(b).find('li:first').hasClass('bg')){
							
						    var val=$(this).siblings(b).find('li:first').text();
							val = $.trim(val);
						    $(this).val(val).parent().find(b).hide();
						    
						    var obj =  $(this).siblings(b).find("a"); 
						    var value1 = $(obj).text();
							var title1 = $(obj).attr('title');
							var value2 = $(obj).attr(d);
							$(this).siblings('.qk').val(value2).attr("valuename",title1);
						   if(func2){
								func2(value2, title1);
							}
						   
						}
					})
				}else{
					$self.siblings(b).find('li').removeClass('bg');
					$self.parent().find(b).hide();
				}
			})
			/*赋值给文本框*/
			$(b).find("a").click(function(e){
				e.stopPropagation();
				var value1 = $(this).text();
				var title1 = $(this).attr('title');
				var value2 = $(this).attr(d);
				
				$(this).parents(b).siblings(c).val(value1).css('color','#333');
				$(this).parents(b).siblings(c).attr('title',title1);
				$(this).parents(b).siblings('.qk').val(value2).attr("valuename",title1);
				$(b).hide();
				if(func2){
					func2(value2, title1);
				}
				
				
			 })
			
			$('#drag').on('mousedown',function(e){
				e.stopPropagation();
				var disX=e.clientX-$(this).position().left;
				var disY=e.clientY-$(this).position().top;

				$(document).on('mousemove',function(e){
					e.preventDefault();
					var l=e.clientX-disX,
					    t=e.clientY-disY,
					l=l<80?80:l;
					$('#drag').css('left',l+'px');
					$('#drag').parent().css({width:l+10+'px',height:t+'px'});
				})
				$(document).on('mouseup',function(e){
					e.stopPropagation();
					$(document).off('mouseup');
					$(document).off('mousemove');
				})
				return false;
			})
		 
	 },
	 
    selectMenu:function(id,callback){
        $('.selt-menu').hover(function(){
            $(this).find('.menu').show();
        },function(){
            $(this).find('.menu').hide();
        })
        
        $('.selt-menu').find('.menu a').click(function(){
	        $('.m-txt').html($(this).html());
	        var value1=$(this).attr(id);
	        $('#hidden_prjID').val(value1);
	        if(callback){
	            callback();
	        }
        })
    },
	showHide : function(callback){
		 $('.listView').find(".para").each(function(){
			 $(this).bind("click",function(){
				 var _this = $(this);
				 $('.listView').each(function(){
					 $(this).removeClass("active");
				 });
				 $(_this).parent().parent().addClass("active");
				 if($(_this).next().is(':visible')){
				 		$(_this).next().hide();
				 	}else{
				 		$(_this).next().show();
				 	}
				 if(callback){
			 			callback($(_this));
			 		}
			 });
		 });
	},
	showHideOne : function(subjectID,callback){
		 $(".listView[subject='"+subjectID+"']").find(".para").each(function(){
			 $(this).bind("click",function(){
				 var _this = $(this)
				 if($(_this).next().is(':visible')){
				 		$(_this).next().hide();
				 	}else{
				 		$(_this).next().show();
				 		if(callback){
				 			callback($(_this));
				 		}
				 	}
			 });
		 });
	},
	
	placeholder:function(){
		$('input,textarea').placeholder();
	},
	
	getVal : function(_gParamArr,name){
		var w = -1;
		var arrLen = _gParamArr.length;
		if(arrLen>0){
			for(var i=0;i<_gParamArr.length;i++){
				var aJson = _gParamArr[i];
				if(aJson.col==name){
					return aJson.value;
				}
			}
		}
		return "";
	},
	setVal : function(_gParamArr,name,val,op){
		_gParamArr = noefunc.regArr(_gParamArr,{name:name,value:val,op:op});
		return _gParamArr;
	},
	//验证数组中对象是否存在，存在就删除
	regArr : function(_gParamArr,cfgJson){
		var w = -1;
		var arrLen = _gParamArr.length;
		if(arrLen>0){
			for(var i=0;i<_gParamArr.length;i++){
				var aJson = _gParamArr[i];
				if(aJson.col==cfgJson.name){
					w = i;
					break;
				}
			}
			if(w!=-1){
				_gParamArr = noefunc.arrdel(_gParamArr,w);
			}
			_gParamArr = noefunc.setArr(_gParamArr,cfgJson)
		}else{
			_gParamArr = noefunc.setArr(_gParamArr,cfgJson)
		}
		return _gParamArr;
	},
	setArr : function(_gParamArr,cfgJson){
		if(cfgJson.value!=""){
			_gParamArr[_gParamArr.length] = {
				col:  cfgJson.name,
				value:[cfgJson.value],
				type:cfgJson.op
			}
		}
		return _gParamArr;
	},
	getVal : function(_gParamArr,name){
		var w = -1;
		var arrLen = _gParamArr.length;
		if(arrLen>0){
			for(var i=0;i<_gParamArr.length;i++){
				var aJson = _gParamArr[i];
				if(aJson.col==name){
					return aJson.value;
				}
			}
		}
		return "";
	},
	arrdel : function(arr,n){
		//prototype为对象原型，注意这里为对象增加自定义方法的方法。
	  if(n<0)  //如果n<0，则不进行任何操作。
	    return arr;
	  else
	    return arr.slice(0,n).concat(arr.slice(n+1,arr.length));
	    /**//*
	       concat方法：返回一个新数组，这个新数组是由两个或更多数组组合而成的。
	       　　　　　　这里就是返回this.slice(0,n)/this.slice(n+1,this.length)
	      　　　　　　组成的新数组，这中间，刚好少了第n项。
	       slice方法： 返回一个数组的一段，两个参数，分别指定开始和结束的位置。
	    */
	},
	 //显示搜索框
	showSearch:function(func){
		AppUtils.bindEnter("searchInt",function(){
			if(func){
				func();
			}
		})
		$('#zoomSearch').click(function(e){
			$(this).parent().parent().addClass('active');
			//$(this).parent().parent().find('input').focus();
			e.stopPropagation();
		});
		$('#searchInt').blur(function(){
			if($.trim($(this).val())==""){
				$(this).parent().parent().parent().removeClass('active');
			}
			if(func){
				func();
			}
		})
		$('#searchInt').click(function(e){
			e.stopPropagation();
		})
		$(document).click(function(){
			if($('#searchInt').val()==""){
				$('#searchInt').parent().parent().parent().removeClass('active');	
			}
		})
		$('.zoom-btn').click(function(e){
			if($.trim($('#searchInt').val())==""){
				$('#searchInt').parent().parent().parent().removeClass('active');
			}
			if(func){
				func();
			}
			e.stopPropagation();
		});
	},
	//从func.js中提取，为解决日期控件冲突
	//模拟弹框1 info：提示信息    suretext：确认框文字  canceltext：true or false     
	modifyAlert:function(info,suretext,canceltext,callBack,closeCallBack){
	   	   if($('#note')){
	   	   	  $('#note').remove();
	   	   }
	   	   var str='';
	   	   if(canceltext){
	   	   	 str='<a class="btn btn-e">取消</a>';
	   	   }else{
	   	   	 str='';
	   	   }
	   	   var cont='<div id="note" class="hd-dialog"><div class="hd-warnCont">'+info+'</div><div class="btn-block"><a class="btn btn-o">'+suretext+'</a>'+str+'</div></div>';
	   	   $(cont).appendTo('body');
	   	   $.blockUI({ 
		   			message: $('#note'),
		   			css: { 
		   				width: '380px',
		   			    border:'1px solid #a6c9e2',
		   			    textAlign:'left'
		   		    },
		   		    onBlock: function() {
		   		    	if(callBack){
		   		    		//callBack();
		   		    	}
		            } 
			});
		   $('.blockUI.blockMsg').center();
	       $('.btn-o').click(function(){
	           $.unblockUI({  
	               onUnblock : function(){ 
	            	   if(callBack){
		   		    		callBack();
		   		       }
	            	   if($('#note')){
	            		   $('#note').remove();
	            	   }
	               }  
	           });
	       });
	       $('.btn-e').click(function(){
	           $.unblockUI({
	        	   onUnblock : function(){ 
	        		   if(closeCallBack){
	            		   closeCallBack();
	            	   }
	            	   if($('#note')){
	            		   $('#note').remove();
	            	   }
	               }
	           });
	       });
	   	   
	   },
	   /**
		 * 文件上传
		 */
		uploadFile : function(config) {
			var g_config = {
						objID : '#file_upload',
						height : '20',
						width : '100',
						debug : false,
						swf : "/static/js/lib/uploadify/uploadify.swf",
						method : 'post',
						multi :  false,
						fileObjName : 'fileAttach',
						fileTypeExts : '*.doc; *.ppt;*.xls;*.xlsx;*.pdf;*.mp4;',
						fileTypeDesc : '*.doc; *.ppt;*.xls;*.xlsx;*.pdf;*.mp4;',
						auto : true,
						formData : {},
						removeCompleted : true,
						fileSizeLimit : 9999999,
						uploadSuccess : function(file, data, response){},
						onUploadStart : function(file){}
				};
				jQuery.extend(g_config, config);
				
				var butHeight = 0;
				var butDivHeight = 0;
				
				var cfg = {
						'height' : g_config.height,
						'width' : g_config.width,
						'debug' : g_config.debug,
						'swf' : ctx + g_config.swf,
						'multi' :  g_config.multi,
						// 后端处理action
						'uploader' : g_config.uploadUrl,
						'method' : g_config.method,
						'formData' : g_config.formData,
						'fileObjName' : g_config.fileObjName, // 文件上传name
						'fileTypeExts' : g_config.fileTypeExts,
						'fileTypeDesc' : g_config.fileTypeDesc,
						'auto' : g_config.auto, // 文件选中后是否自动提交
						"removeTimeout" : 0,
						"successTimeout" : 120,
						'overrideEvents' : [ 'onSelectError', 'onDialogClose' ],
						// 文件上传完毕后消息框是否自动消失，默认true
						removeCompleted : g_config.removeCompleted,
						// 文件上传完毕后消息框消失延迟时间,默认3 仅removeCompleted=true生效
						// removeTimeout : 3,
						// 文件上传大小限制
						fileSizeLimit : g_config.fileSizeLimit,
						// 文件队列传输完毕 queueDate [uploadsSuccessful,uploadsErrored]
						onQueueComplete : function(queueData) {
//							alert('文件队列传输完毕:' + queueData.uploadsSuccessful
//									+ 'fail:' + queueData.uploadsErrored)
						},
						onUploadComplete : function(file){
							$(""+g_config.objID).css({height: g_config.height,overflow: ''});
							if($(".pop_b").size() > 0){
								$(".pop_b").children().first().css("display","inline-block");
							}
						},
						onSelectError : function(file , errorCode, errorMsg){
							if(errorCode == "-110"){
								alert("该文件已超过最大上传大小(" + this.settings.fileSizeLimit + ")");
							}else if(errorCode == "-130"){
								alert("该文件不是指定上传类型");
							}else{
								alert("文件上传失败, 错误代码为" + errorCode);
							}
						},
						// 文件上传开始时出发
						onUploadStart : function(file){
							if($(".pop_b").size() > 0){
								$(".pop_b").children().first().css("display","none");
							}
							
							$(""+g_config.objID + "-queue").find(".cancel").css("display", "none");
							$(""+g_config.objID).css({height: 0,overflow: 'hidden'});
							g_config.onUploadStart(file);
						},
						// 单文件传输成功
						onUploadSuccess : function(file, data, response) {
							//alert('singleSuccess,fileName:' + file.name);
							$('#' + file.id).find('.data').html(' 上传完毕');
							g_config.uploadSuccess(file, data, response);
							//alert('文件上传成功');
						},
						// 单文件传输失败
						onUploadError : function(file, errorCode, errorMsg,
								errorString) {
							// eg:The file mozjs.dll errorCode -200 errorCode
							// -200
							// errorMsg 302 errorString HTTP Error (302)
							alert('单文件传输失败 ' + file.name + ' errorCode '
									+ errorCode + ' errorCode ' + errorCode
									+ ' errorMsg ' + errorMsg + ' errorString '
									+ errorString);
						},
						onCancel : function(file){
							
						},
						// 按钮显示名称
						buttonText : "请选择文件"
					}
				
				$(""+g_config.objID).uploadify(cfg);
				
		},
		// 销毁附件对象
		destroyFileUpload : function(objDiv) {
			$(objDiv).uploadify('destroy');
		},
		// 批量销毁附件对象
		destroyBatchFileUpload : function(batchObjDiv) {
			var divArr = batchObjDiv.split(",");
			for ( var i = 0; i < divArr.length; i++) {
				noefunc.destroyFileUpload(divArr[i]);
			}
		},
		// 验证是否安装flash插件
	   flashChecker: function() {  
		    var hasFlash = 0;//是否安装了flash  
		    var flashVersion = 0;//flash版本  
		    if(document.all) {
		        var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');  
		        if(swf) {  
		            hasFlash = 1;  
		            VSwf = swf.GetVariable("$version");  
		            flashVersion = parseInt(VSwf.split(" ")[1].split(",")[0]);  
		        }  
		    } else {  
		        if(navigator.plugins && navigator.plugins.length > 0) {  
		            var swf = navigator.plugins["Shockwave Flash"];  
		            if(swf) {  
		                hasFlash = 1;  
		                var words = swf.description.split(" ");  
		                for(var i = 0; i < words.length; ++i) {  
		                    if(isNaN(parseInt(words[i]))) continue;  
		                    flashVersion = parseInt(words[i]);  
		                }  
		            }  
		        }  
		    }  
		    return {  
		        f: hasFlash,  
		        v: flashVersion  
		    };  
		},
		//万人测折叠菜单
		foldMenu:function(){
			$('.hd-block h2').on('click',function(){
				if($(this).parent().hasClass('active')){
					$(this).parent().removeClass('active');
				}else{
					$(this).parent().addClass('active');
					$(this).parent().siblings().removeClass('active');
				}
				return false;
			})
		},
		//退出登录
	   logOut:function(){
	   	$('#user1').hover(function(){
	   		if($(this).hasClass('active')){
	   			$(this).removeClass('active');
	   			$(this).find('i').html('&#xe6e1;');
	   		}else{
	   			$(this).addClass('active');
	   			$(this).find('i').html('&#xe6e2;');
	   		}
	   	})
	   },
	   modifyPlaceholder:function(obj,val){
	   	     var oInput=$(obj);
	         var bBtn = true;
	         $(obj).val(val);
			 $(oInput).focus(function(){
				  if(bBtn){
					  $(this).val('');
					  $(this).css('color','#333');
					  bBtn = false;
				  }
				  $(this).select();
			 });
			 $(oInput).blur(function(){
				if($(this).val()==''){
				   $(this).val(val);
				   $(this).css('color','#999');
				   bBtn = true;
				}				  
			 });
	   },
	 //面板伸缩
		unfold:function(){
			$('#es-btn').click(function(){
				if($(this).parent().hasClass('active')){
					$(this).removeClass('active');
					$(this).parent().removeClass('active');
					$('.mc-2,.mc-3,.mc-7,.mc-10,.mc-11').removeClass('active');
				}else{
					$(this).addClass('active');
					$(this).parent().addClass('active');
					$('.mc-2,.mc-3,.mc-7,.mc-10,.mc-11').addClass('active');
				}
			})
		}
}
