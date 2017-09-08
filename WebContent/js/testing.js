var testing = {
	
	mode: '',//模式(answer,view)
	pageIndex : 0,
	pages : {},
	pageCount : 0,
	subjects : {},
	testID : '',
	paperID : '',
	paperTotalTime : 0,
	paperTestTime : 0,
	timer : null,
	baseApi : ctx+'/testprocess',
	userAnswers : [],
	t:0,
	player:null,
	moduleCode:'',
	paperType:'',
	clientType:'',
	ext:'',
	flagEnter:0,
	lastAnswerTime:new Date().getTime(),  
	showTime:0,
	paperTotalTime:0,
	skin:'',
	currentSubjects:{},//当前页面的试题
	
	genUUID:function(){
		var d = new Date().getTime();
		var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		  var r = (d + Math.random()*16)%16 | 0;
		  d = Math.floor(d/16);
		  return (c=='x' ? r : (r&0x3|0x8)).toString(16);
		});
		return uuid;
	},

	resetImages:function(){
		
	    testing.baseResetImages('.test .stem img',673);
	    testing.baseResetImages('.test .opts img',646);
	    testing.baseResetImages('.test-parse img',603);
	    testing.baseResetImages('.test-main img',603);
	},
	
	baseResetImages:function(elem,width){
		$(elem).each(function(){
			if($(this).width()>width){
				$(this).width(width);
			}
		});
	},
	
	loadSubject : function(smallSubjectID, callbackfunc){
		var page = testing.pages[testing.pageIndex]; 
		if(page == null || page == undefined){
			return;
		}
		
		if(testing.player){
			try{
				testing.player.pause();
			}catch(e){
				
			}
		}
		
		var req = {};
		req.mode = testing.mode;
		req.testID = testing.testID;
		req.paperID = testing.paperID;
		req.ids = page.subjects;
		req.tplType = page.tplType;
		req.userAnswers = testing.userAnswers;
		req.paperTestTime = testing.paperTestTime;
		req.paperType = testing.paperType;
		
		AppUtils.doPost(testing.baseApi+'/testing/loadSubject',req,function(res){
			$('#paperContainer').html(res.gridHTML);
			testing.resetImages();
			
			testing.showSubjectIndex(); 
			
			if(testing.mode == 'view'){
				testing.adjustScroll(smallSubjectID);
			}
			
			if(testing.mode == 'answer'){
				if(testing.pageIndex == testing.pageCount-1){
					$('#nextBtn').html('<span></span>完成');
				}else{
					$('#nextBtn').html('<span></span>下一页');
				}
			}
			
			testing.checkImagesLoad('.wl img');
			
			if(callbackfunc){
				callbackfunc();
			}
			
		});
	},
	
	checkImagesLoad:function(elem){
		var len = $(elem).length;
		if(len > 0){
			$(elem).each(function(index){
				$(this)[0].onload=function(){
					this.style.background='none';
				}
			})
		}
	},
	
	adjustScroll: function(smallSubjectID){
		if(smallSubjectID != undefined && smallSubjectID != null && smallSubjectID != ""){
			//$('#subject_'+smallSubjectID)[0].scrollIntoView();
			var h = $('#subject_'+smallSubjectID).offset().top;
			$(window).scrollTop(h);
		}
	},
	
	showSubjectIndex:function(){
		$('.subjectNum').each(function(index){
			var subjectID = $(this).attr('subjectID');
			var subjectIndex = testing.subjects.indexOf(subjectID);
			$(this).siblings().text('Q'+(subjectIndex+1));
		});	
	},
	
	//获得答题所用的时间
	getUsedTime:function(){
		var lastAnswerTime = testing.lastAnswerTime;
		var nowTime = new Date().getTime();
		var usedTime = nowTime - lastAnswerTime;
		testing.lastAnswerTime = nowTime;
		return usedTime;
	},
	
	answer:function(obj){
		var $li = $(obj);
		var $ul = $li.parent();
		
		var req = {};
		req.testID = testing.testID;
		req.pageIndex = testing.pageIndex;
		req.paperTestTime = testing.paperTestTime;
		req.usedTime = testing.getUsedTime();
		
		req.subjectTplType = $li.attr('subjectTplType');
		req.partID = $li.attr('partID');
		req.partIndex = $li.attr('partIndex');
		req.subjectID = $li.attr('subjectID');
		req.subjectIndex = $li.attr('subjectIndex');
		req.smallSubjectID = $li.attr('smallSubjectID');
		req.smallSubjectIndex = $li.attr('smallSubjectIndex');
		req.subjectAnswer = $li.attr('subjectAnswer');
		req.subjectScore = $li.attr('subjectScore');
		req.userAnswer = testing.getUserAnswer($ul);
		
		AppUtils.doPost(testing.baseApi+'/testing/answer',req,function(res){
			if(!res.success){
				testing.tips('提交失败'); 
			}else{
				if(res.result == -1){
					testing.tips('测评已经提交,不能再修改答案');
					return;
				}
				testing.updateUserAnswers(req.smallSubjectID, req.userAnswer);
			}
		})
	},
	
	//回答填空题
	answerTianKong:function(obj){
		var req = {};
		
		var req = {};
		req.testID = testing.testID;
		req.pageIndex = testing.pageIndex;
		req.paperTestTime = testing.paperTestTime;
		req.usedTime = testing.getUsedTime();
		
		req.subjectTplType = obj.attr('subjectTplType');
		req.partID = obj.attr('partID');
		req.partIndex = obj.attr('partIndex');
		req.subjectID = obj.attr('subjectID');
		req.subjectIndex = obj.attr('subjectIndex');
		req.smallSubjectID = obj.attr('smallSubjectID');
		req.smallSubjectIndex = obj.attr('smallSubjectIndex');
		req.subjectAnswer = obj.attr('subjectAnswer');
		req.subjectScore = obj.attr('subjectScore');
		req.userAnswer = obj.attr('userAnswer');
		req.zkIndex = obj.attr('zkIndex');
		
		
		AppUtils.doPost(testing.baseApi+'/testing/answer',req,function(res){
			if(!res.success){
				testing.tips('提交失败'); 
			}else{
				if(res.result == -1){
					testing.tips('测评已经提交,不能再修改答案');
					return;
				}
				testing.updateUserAnswers(req.smallSubjectID, req.userAnswer); 
				testing.markTianKongFinish(obj.attr('subjectID')); 
			}
		})
	},
	
	
	//构建试题答案
	buildAnswer:function(subject,userAnswer){
		var answer = {};
		
		answer.testID = testing.testID;
		answer.pageIndex = testing.pageIndex;
		answer.paperTestTime = testing.paperTestTime;
		answer.usedTime = testing.getUsedTime();
		answer.userAnswer = userAnswer;
		
		answer.subjectTplType = subject.subjectTplType;
		answer.partID = subject.partID;
		answer.partIndex = subject.partIndex;
		answer.subjectID = subject.subjectID;
		answer.subjectIndex = subject.subjectIndex;
		answer.smallSubjectID = subject.smallSubjectID;
		answer.smallSubjectIndex = subject.smallSubjectIndex;
		answer.subjectAnswer = subject.subjectAnswer;
		answer.subjectScore = subject.subjectScore;
		
		return answer;
	},
	
	//new dev model
	updateUserAnswers:function(smallSubjectID,userAnswer){
		var flagFind = false;
		for(var i=0;i<testing.userAnswers.length;i++){
			var item = testing.userAnswers[i];
			if(item.smallSubjectID == smallSubjectID){
				item.userAnswer = userAnswer;
				flagFind = true;
			}
		}
		
		if(!flagFind){
			var item = {'smallSubjectID':smallSubjectID,'userAnswer':userAnswer};
			testing.userAnswers.push(item);
		}
	},
	
	//获得用户答案
	getUserAnswer:function(obj){
		var userAnswer = '';
		obj.find('.active').each(function(){
			var $i = $(this).find('i');
			userAnswer = userAnswer + $i.attr('optTitle');
		});
		return userAnswer;
	},
	
	//上一题
	prev : function() {
		if(testing.mode == "view" || testing.mode == "preview"){ 
			//TODO
			$('#fixed-menu li').removeClass('active'); 
		}
		
		if(testing.pageIndex > 0){
			testing.pageIndex--;
			testing.loadSubject();
		}else{
			testing.firstTips();
		}
		
		$('#fixed-menu').removeClass('ifixed');
		
		$(window).scrollTop(0);
	},
	
	//下一题
	next : function() {
		
		if(testing.mode == "view" || testing.mode == "preview"){ 
			//TODO
			$('#fixed-menu li').removeClass('active'); 
		}
		
		if(testing.pageIndex < testing.pageCount-1){
			testing.pageIndex++;
			testing.loadSubject();
		}else{
			if(testing.mode == "view" || testing.mode == "preview"){ 
				testing.lastTips();
				$(window).scrollTop(0);
				return;
			}
			
			testing.finishTips();
		}
		
		$('#fixed-menu').removeClass('ifixed');
		
		$(window).scrollTop(0);
	},
	
	//测评模式的试题跳转
	switchSubject:function(obj,subjectID){
		testing.locatePageIndex(subjectID);
		
		if($('#subject_'+subjectID).length == 0 ){
			
			testing.loadSubject(undefined, function(){
				//TODO fixed
				//$('#fixed-menu').removeClass('ifixed');
				if($('#subject_'+subjectID)[0]){
					$('#subject_'+subjectID)[0].scrollIntoView();
					var y=$(window).scrollTop();
					if(y>=testing.t){
						$('#fixed-menu').addClass('ifixed');
					}else{
						$('#fixed-menu').removeClass('ifixed');
					}
				}
			});
			
		}else{
			if($('#subject_'+subjectID)[0]){
				$('#subject_'+subjectID)[0].scrollIntoView();
			}
		}
	},
	
	//预览模式的试题跳转
	switchSubject2:function(obj,subjectID){
		$(obj).parent().find('li').removeClass('active');
		$(obj).addClass('active');
		testing.locatePageIndex(subjectID);
		
		if($('#subject_'+subjectID).length == 0 ){
			
			testing.loadSubject(undefined, function(){
				
				//$('#fixed-menu').removeClass('ifixed');
				if($('#subject_'+subjectID)[0]){
					$('#subject_'+subjectID)[0].scrollIntoView();
					var y=$(window).scrollTop();
					//alert(testing.t);
					if(y>=testing.t){
						$('#fixed-menu').addClass('ifixed');
					}else{
						$('#fixed-menu').removeClass('ifixed');
					}
				}
				
			});
			
		}else{
			
			
			if($('#subject_'+subjectID)[0]){
				$('#subject_'+subjectID)[0].scrollIntoView();
			}
			
		}
		
	},
	
	
	//将做过的试题标记为高亮
	switchFromSubject:function(subjectID,smallSubjectID){
		//$("#x_" + subjectID).parent().find('li').removeClass('active');
		if($('.test-main').length == 0 ){
			//都是单题
			var len = $("#subject_"+smallSubjectID).find('.active').length;
			if(len > 0){
				$("#x_" + subjectID).addClass('active');
			}else{
				$("#x_" + subjectID).removeClass('active');
			}
		}else{
			//含有大题
			var len1 = $('.subjectItem').length;
			var len2 = 0;
			
			$('.subjectItem').each(function(){
				if($(this).find('.active').length > 0){
					len2 = len2 + 1;
				}
			});
			
			if(len2 >= len1){
				$("#x_" + subjectID).addClass('active');
			}else{
				$("#x_" + subjectID).removeClass('active');
			}
		}
	},
	
	//将做过的填空题标记为高亮 
	markTianKongFinish:function(subjectID,smallSubjectID){
		var activeFlag = true;
		$("#subject_"+subjectID).find('.u-cloze').each(function(){
			var content = $(this).val(); 
			if(content == ''){
				activeFlag = false;
			}
		});
		if(!activeFlag){
			$("#x_" + subjectID).removeClass('active');
		}else{
			$("#x_" + subjectID).addClass('active'); 
		}
	},
	
	//定位试题的页码
	locatePageIndex : function(subjectID){
		for(index in testing.pages){
			var page = testing.pages[index];
			if(page.subjects && page.subjects.indexOf(subjectID) >= 0){
				testing.pageIndex = index;
			}
		}
	},
	
	/**
	 * 开始一个新的测评
	 */
	newTest:function(){
		var uuid = testing.genUUID();
		var href = window.location.href;
		window.location.href = href.replace(testing.testID,uuid);
	},
	
	/**
	 * 继续测试
	 */
	conTest:function(){
		testing.countDown();
		$.unblockUI();
	},
	
	countDown : function(){
		if(testing.showTime == 1 && testing.paperTestTime == 0){
			return;
		}
		
		if(testing.timer){
			//清除定时器
			clearInterval(testing.timer);
		}
		
		if(testing.showTime == 1){
			testing.timer = setInterval(function(){
				testing.paperTestTime = testing.paperTestTime - 1;
				$("#countDownText").text(AppUtils.formatSeconds(testing.paperTestTime));
				$.cookie('paperTestTime_'+testing.testID, testing.testID+'_'+testing.paperTestTime,{expires:30}); 
				if(testing.mode == 'answer'){
					if(testing.paperTestTime == 0){
						clearInterval(testing.timer);
						testing.postFinish(function(res){
							testing.timeTips(function(){
								var url = res.result;
								window.location.href = ctx+'/'+url;
							});
						});
					}
				}else{
					if(testing.paperTestTime == 0){
						clearInterval(testing.timer);
					}
				}
			},1000);
		}else{
			testing.timer = setInterval(function(){
				testing.paperTestTime = testing.paperTestTime + 1;
				$("#countDownText").text(AppUtils.formatSeconds(testing.paperTestTime));
				$.cookie('paperTestTime_'+testing.testID, testing.testID+'_'+testing.paperTestTime,{expires:30}); 
			},1000);
		}
	},
	
	pause : function(obj){
		//1.
		$.blockUI({
			message: $('#pause'),
			css: { 
				width: '490px',
			    border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        	testing.countDown();
        	$('#pauseIcon').html('&#xe602;');
        	
        	/**
        	 * 如果已经播放,则开始后继续播放
        	 */
        	testing.playAudio();
        	
        })
		
        //3.
		$(obj).siblings().removeClass('active');
		$(obj).addClass('active'); 
		clearInterval(testing.timer);
		
		$('#pauseIcon').html('&#xe603;');
		
		testing.pauseAudio();
	},
	
	start : function(obj){
		$(obj).siblings().removeClass('active');
		$(obj).addClass('active');
		testing.countDown();
	},
	
	firstTips:function(){
		$.blockUI({
			message: $('#firstTips'),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        })
	},
	
	lastTips:function(){
		$.blockUI({
			message: $('#lastTips'),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        })
	},
	
	finishTips:function(){
		testing.pauseAudio();
		
		$.blockUI({
			message: $('#finishTips'),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        	testing.playAudio();
        })
	},
	
	
	conTips:function(){
		$.blockUI({
			message: $('#conTips'),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        })
	},
	
	
	tips:function(msg){
		var html = '<div id="firstTips" style="display:none;" class="errortip">'
			+'<img src="'+testing.skin+'/img/error.jpg" width="160" />'
			+'<p>'+msg+'</p>'
			+'<div class="btns">'
			+'<a href="javascript:;" class="btn btn-o closeWin">关闭</a>'
			+'</div>'
			+'</div>';
		
		$.blockUI({
			message: $(html),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	$.unblockUI();
        })
	},
	
	timeTips:function(callBack){
		
		$(window).scrollTop(0);
		
		$.blockUI({
			message: $('#timeTips'),
			css: { 
				width: '490px',
				border:0,
			    borderRadius:'5px',
			    textAlign:'center'
		    }
		});
		
		//2.
		$('.blockUI.blockMsg').center();
        $('.closeWin').click(function(){
        	if(callBack){
        		callBack();
        	}
        	$.unblockUI();
        })
	},
	
	finish:function(){
		testing.postFinish(function(res){
			var url = res.result;
			window.location.href = ctx+'/'+url;
		});
	},
	
	postFinish:function(callBack){ 
		var req = {};
		req.testId = testing.testID;
		req.paperId = testing.paperID;
		req.moduleCode = testing.moduleCode;
		req.clientType = testing.clientType;
		req.paperType = testing.paperType;
		req.ext = testing.ext;
		
		if(testing.showTime == 1){
			//显示倒计时
			req.userTotalTime = testing.paperTotalTime - testing.paperTestTime;
			if(req.userTotalTime < 0){
				req.userTotalTime = testing.paperTotalTime;
			}
		}else{
			//不显示倒计时
			req.userTotalTime = testing.paperTestTime;
		}
		
		
		AppUtils.doPost(ctx+'/testprocess/testing/finish',req,function(res){
			if(res.success){
				if(res.result == -1){
					testing.tips('测评已经提交,不能重复提交');
					return;
				}
				if(callBack){
					callBack(res);
				}
			}
		});
	},
	
	playAudio:function(){
		/**
    	 * 如果已经播放,则开始后继续播放
    	 */
    	if(testing.player){
    		if($('.scrubber .progress').width() > 0){
    			try{
    				testing.player.play();
    			}catch(e){
    				
    			}
    		}
    	}
	},
	
	pauseAudio:function(){
		if(testing.player){
			try{
				testing.player.pause();
			}catch(e){
				
			}
		}
	}
	
}