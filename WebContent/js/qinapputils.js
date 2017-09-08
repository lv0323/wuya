var myLayout;
var AppUtils = {
	
	log:function(data){
		
	},
	
	/**
	 * 根节点必须是form标签,否则无法获得表单数据,属于获得表单的基本方法
	 */
	getFormData:function(formID,prefix){
		var data = {};
		var x = $(formID).serializeArray();
		$.each(x, function(index, field){
			if(prefix){
				var _name = field.name;
				var name = _name.substring(_name.lastIndexOf(prefix)+prefix.length);
				data[name]=field.value;
			}else{
				data[field.name]=field.value;
			}
	    });
		return data;
	},
	
	/**
	 * 获得查询表单的数据
	 */
	getQFormData:function(formID){
		return this.getFormData(formID,"q_");
	},
	
	getEFormData:function(formID){
		return this.getFormData(formID,"e_");
	},
	
	doPost:function(url,jsonData,successCallBack,errorCallBack){
		$.ajax({
			url : url,
		    type : "POST", 
		    dataType:"json",
		    contentType:'application/json;charset=UTF-8',
		    data:JSON.stringify(jsonData),
		    success : function(data) {
		    	if(data.success){
		    		if(successCallBack){
			        	successCallBack(data);
			        }
		    	}else{
		    		var errObject = data.errObject;
		    		if(errObject.errCode=='not_login'){ 
		    			//系统没有登录,拦截ajax请求后的响应
		    			window.location.href=ctx+'/sys/login';
		    		}else if(errObject.errCode=='unauthorized'){
		    			//系统没有权限,拦截ajax请求后的响应
		    			window.location.href=ctx+'/sys/unauthorized';
		    		}else{
		    			//已经登陆,按照不同的业务的错误提示进行提示
		    			AppUtils.alert(errObject.errMess);
		    		}
		    	}
		    },
		    error:function(error){
		    	var status = error.status;
		    	if(status==200){
		    		//todo
		    	}else if(status==404){
		    		AppUtils.alert(url+'没有找到');
		    	}else if(status==500){
		    		AppUtils.alert('系统异常，请联系管理员');
		    	}else{
		    		//AppUtils.alert('系统异常，请联系管理员');
		    		//window.location.href=ctx+'/sys/home/index';
		    	}
		    	if(errorCallBack){
		    		errorCallBack(error);
		    	}   
		    }
		});
	},
	
	/**
	 * 通过ajax获得页面内容后渲染到某个节点,简化了大部分只需简单渲染页面的业务
	 */
	loadGridHTML:function(url,jsonData,node,callBack){
		AppUtils.doPost(url, jsonData,
			function(data){
				$(node).html(data.gridHTML);
				if(callBack){
					callBack();
				}
			},
			function(error){
				
			}
		);
	},
	
	alert:function(msg,callBack){
		this.createConfirm('<i class="iconfont">&#xe6a4;</i>&nbsp;&nbsp;'+msg,'#14abe2','#fff',false,null,callBack);
	},
	
	
	
	warn:function(msg){
		this.createConfirm(msg,'mid');
	},
	
	error:function(msg,callBack){
		this.createConfirm('<i class="iconfont">&#xe6b6;</i>&nbsp;&nbsp;'+msg,'red','#fff',false,null,callBack);
	},
	
	confirm:function(msg,okCallBack,cancelCallBack){
		this.createConfirm('<i class="iconfont">&#xe6a3;</i>&nbsp;&nbsp;'+msg,'#14abe2','#fff',true,okCallBack,cancelCallBack);
	},
	
	showMask:function(node,msg){
		AppUtils.hideMask();
        var maskObj=$(node)[0];
        var disX=getCoords(maskObj).left;
        var disY=getCoords(maskObj).top;
        var mask=document.createElement('div');
        var waiting=document.createElement('div');
		var waitingIn=document.createElement('div');
        var msm=document.createElement('span');
		waitingIn.style.position='relative';
		waitingIn.style.left='-50%';
        msm.style.marginLeft='10px';
        waiting.style.position='absolute';
        waiting.style.display="inline-block";
        mask.id='mask';
        mask.style.left=disX+'px';
        mask.style.top=disY+'px';
        mask.style.width=maskObj.offsetWidth+'px';
        mask.style.height=maskObj.offsetHeight+$(window).scrollTop()+'px';
        var imgNode=document.createElement('img');
        imgNode.src=ctx+'/static/img/loading.gif';
        imgNode.style.width='50px';
        imgNode.style.height='50px';
        imgNode.style.verticalAlign="middle";
        waiting.style.top=(maskObj.offsetHeight-50)/2+'px';
		waiting.style.left='50%';
        waitingIn.appendChild(imgNode);
        if(msg)
        {
        	msm.innerHTML=msg;
			waitingIn.appendChild(msm);
        
        }
        waiting.appendChild(waitingIn);
        mask.appendChild(waiting);
        document.body.appendChild(mask);
        function getCoords(el){
	          var box = el.getBoundingClientRect(),
	      	  doc = el.ownerDocument,
	      	  body = doc.body,
	      	  html = doc.documentElement,
	      	  clientTop = html.clientTop || body.clientTop || 0,
	      	  clientLeft = html.clientLeft || body.clientLeft || 0,
	      	  top  = box.top  + (self.pageYOffset || html.scrollTop  ||  body.scrollTop ) - clientTop,
	      	  left = box.left + (self.pageXOffset || html.scrollLeft ||  body.scrollLeft) - clientLeft
	      	  return { 'top': top, 'left': left };
        }
    },
    
    hideMask:function(){
    	if(document.getElementById('mask')){
    		var mask=document.getElementById('mask');
    		document.body.removeChild(mask);
    	}
    },
    
    /**
     * 弹出框
     */
    showBox:function(url,jsonData,nodeId,callBack,closeCallBack,width){
       if(!nodeId){
    	   nodeId = 'XBJ_BOX';
       }
       
       if(!width){
    	   width = '650px';
       }
       var node = '#'+nodeId;
       if($(node)){
    	   $(node).remove();
       }
       $('<div id="'+nodeId+'" class="zx-dialog"></div>').appendTo('body');
       AppUtils.doPost(url, jsonData,function(res){
    	   $.blockUI({ 
	   			message: $(node),
	   			css: { 
	   				width: width,
	   			    border:'1px solid #a6c9e2',
	   			    textAlign:'left'
	   		    },
	   		    onBlock: function() {
	   		    	if(callBack){
	   		    		callBack();
	   		    	}
	            } 
		   });
    	   
    	   
    	   $(node).html(res.gridHTML);
    	   $('.blockUI.blockMsg').center();
           $('.closeWin').click(function(){
           $.unblockUI({  
                   //执行解除锁屏的回调函数  
                   onUnblock : function(){ 
                	   if(closeCallBack){
                		   closeCallBack();
                	   }
                	   if($(node)){
                		   $(node).remove();
                	   }
                   }  
               });
           })
       });	
    },
    /**
     * 悬浮窗
     */
    showFloatBox:function(url,jsonData,relId,targetNode){
    	$(targetNode).powerFloat();
    	var relNode = '#'+relId;
        if($(relNode)){
        	$(relNode).remove();
        }
        $('<div id="'+relId+'" class="target_box dn"></div>').appendTo('body');
        AppUtils.loadGridHTML(url,jsonData,relNode,function(){
        	$(targetNode).powerFloat();
        });	
     },
    
    isEmpty:function(val){
    	if(val == null || val == undefined || val == ''){
    		return true;
    	}else{
    		return false;
    	}
    },
    
    isNotEmpty:function(val){
    	return !AppUtils.isEmpty(val);
    },
    
    ph:function(){
    	$('textarea,input').placeholder({
            labelMode: true,
            labelAlpha: false,
            labelAcross: true,
            labelStyle: {
	            lineHeight: "1.8"
	        }
        });
    },
	nestLayout:function(){
		myLayout = $('body').layout({

		//	reference only - these options are NOT required because 'true' is the default
			closable:					true	// pane can open & close
		,	resizable:					true	// when open, pane can be resized 
		,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
		,	livePaneResizing:			true

		//	some resizing/toggling settings
		,	north__slidable:			true	// OVERRIDE the pane-default of 'slidable=true'
		,	north__resizable:			false	// OVERRIDE the pane-default of 'slidable=true'
		,	north__closable:			false	// OVERRIDE the pane-default of 'slidable=true'
		,   north__spacing_open:        0
		,	north__togglerLength_closed: '100%'	// toggle-button is full-width of resizer-bar
		,	north__spacing_closed:		0		// big resizer-bar when open (zero height)
		,	south__resizable:			false	// OVERRIDE the pane-default of 'resizable=true'
		,	south__spacing_open:		0		// no resizer-bar when open (zero height)
		,	south__spacing_closed:		0		// big resizer-bar when open (zero height)

		//	some pane-size settings
		,	west__size:				    300
		,	west__minSize:				100
		,	east__size:					340
		,	east__minSize:				200
		,	east__maxSize:				.5 // 50% of layout width
		,	center__minWidth:			100

		//	some pane animation settings
		,	west__animatePaneSizing:	false
		,	west__fxSpeed_size:			"fast"	// 'fast' animation when resizing west-pane
		,	west__fxSpeed_open:			100	// 1-second animation when opening west-pane
		,	west__fxName_close:			"none"	// NO animation when closing west-pane

		//	enable showOverflow on west-pane so CSS popups will overlap north pane
		,	west__showOverflowOnHover:	false

		//	enable state management
		,	stateManagement__enabled:	false // automatic cookie load & save enabled by default

		,	showDebugMessages:			true // log and/or display messages from debugging & testing code
		});

		/*
		 *	DISABLE TEXT-SELECTION WHEN DRAGGING (or even _trying_ to drag!)
		 *	this functionality will be included in RC30.80
		 */
		$.layout.disableTextSelection = function(){
			var $d	= $(document)
			,	s	= 'textSelectionDisabled'
			,	x	= 'textSelectionInitialized'
			;
			if ($.fn.disableSelection) {
				if (!$d.data(x)) // document hasn't been initialized yet
					$d.on('mouseup', $.layout.enableTextSelection ).data(x, true);
				if (!$d.data(s))
					$d.disableSelection().data(s, true);
			}
			//console.log('$.layout.disableTextSelection');
		};
		$.layout.enableTextSelection = function(){
			var $d	= $(document)
			,	s	= 'textSelectionDisabled';
			if ($.fn.enableSelection && $d.data(s))
				$d.enableSelection().data(s, false);
			//console.log('$.layout.enableTextSelection');
		};
		$(".ui-layout-resizer")
			.disableSelection() // affects only the resizer element
			.on('mousedown', $.layout.disableTextSelection ); // affects entire document
		$('.ui-layout-pane-north').css('z-index','900');
    },
    layoutHide : function(btn,direction){
    	myLayout.bindButton(btn, 'open', direction);
    },
	createConfirm:function(value,mcr,fontCr,btnBoolean,fn1,fn2){
    	var confirmWrap=document.createElement('div');
                	var confirmWrap=document.createElement('div');
                	var confirmCont=document.createElement('p');
                	var confirmBtns=document.createElement('div');
                	var confirmYes=document.createElement('button');
                	var confirmNo=document.createElement('button');
                	confirmCont.innerHTML=value;
                	if(btnBoolean==true){
                		confirmYes.innerHTML='确定';
                	    confirmNo.innerHTML='取消';
                	    confirmBtns.appendChild(confirmYes);
                	    confirmBtns.appendChild(confirmNo);
                	}else{
                	    confirmNo.innerHTML='关闭';
                	    confirmBtns.appendChild(confirmNo);
                	}
                	confirmWrap.appendChild(confirmCont);
                	
                	confirmWrap.appendChild(confirmBtns);
                	document.body.appendChild(confirmWrap);
                    confirmWrap.className='tps-confirm';
                	confirmYes.className='btn b-cr ml5';
                	confirmNo.className='btn b-cr ml5';
                	confirmBtns.className='tc';
                	confirmWrap.style.zIndex='1022';
                	confirmWrap.style.borderWidth='1px';
                	confirmWrap.style.borderStyle='solid';
                	confirmWrap.style.zIndex='1022';
                	confirmCont.style.borderBottomWidth='1px';
                	confirmCont.style.borderBottomStyle='solid';
                	confirmWrap.style.borderColor=confirmYes.style.backgroundColor=confirmNo.style.backgroundColor=confirmCont.style.borderBottomColor=confirmCont.style.color=mcr;
                	confirmYes.style.color=confirmNo.style.color=fontCr;
                	function confirmShow(){
                		document.body.removeChild(confirmWrap);
                	
                		if($('.blockMsg').html()===''){
                			$.unblockUI(); 				    		
				    	}
				    	else{
				    		$('.blockOverlay').css('z-index',1000);
				    	}
                	}
                	$(confirmWrap).center(); 
                	if($('.blockOverlay').length){
			    		$('.blockOverlay').css('z-index',1020);
			    	}
			    	else{
			    		$.blockUI({ message: null,
			    		           overlayCSS: { opacity:0 }
                                  }); 
			    	}
                	confirmYes.onclick=function(yesFn){
                		
                		confirmShow();
                		if(fn1){
                			fn1();
                		}
                		
                	};     
                	confirmNo.onclick=function(noFn){
                		
                		confirmShow();
                		if(fn2){
                			fn2();
                		}
                	}
    },
    bindEnter : function(id,func){
    	function keypressInBox(e) {
		    var code = (e.keyCode ? e.keyCode : e.which);
		    if (code == 13) { //Enter keycode                        
		        e.preventDefault();
                if(func){
                	func();
                }	
		    }
		};
    	$("#"+id).bind("keypress", {}, keypressInBox);

		
    },
    
    formatSeconds : function(value) {
		var theTime = parseInt(value);// 秒
		var theTime1 = 0;// 分
		var theTime2 = 0;// 小时
		if(theTime > 60) {
			theTime1 = parseInt(theTime/60);
			theTime = parseInt(theTime%60);
			if(theTime1 > 60) {
				theTime2 = parseInt(theTime1/60);
				theTime1 = parseInt(theTime1%60);
			}
		}
		var result = "";
		if(theTime>=10){
			result = ""+parseInt(theTime);
		}else{
			result = "0"+parseInt(theTime);
		}
		if(theTime1 >= 10){
			result = ""+parseInt(theTime1)+":"+result;
		}else{
			result = "0"+parseInt(theTime1)+":"+result;
		}
		if(theTime2 >= 10){
			result = ""+parseInt(theTime2)+":"+result;
		}else{
			result = "0"+parseInt(theTime2)+":"+result;
		}
		return result;
	}
}
