var rdfunc={
	//面板伸缩
	unfold:function(){
		$('#es-btn').click(function(){
			if($(this).parent().hasClass('active')){
				$(this).removeClass('active');
				$(this).parent().removeClass('active');
				$('.mc-2').removeClass('active');
				$('.mc-3').removeClass('active');
				$('.mc-7').removeClass('active');
			}else{
				$(this).addClass('active');
				$(this).parent().addClass('active');
				$('.mc-2').addClass('active');
				$('.mc-3').addClass('active');
				$('.mc-7').addClass('active');
			}
		})
	},
	//设分下拉框
	setMark:function(){
		$('.s-mark').hover(function(){
			$(this).addClass('active');
			$(this).find('.s-box').show();
		},function(){
			$(this).removeClass('active');
			$(this).find('.s-box').hide();
		});
		$('.s-sure').click(function(){
			$(this).parent().hide();
		})
	},
	//切换学科
	showDiabox:function(main,sub){
		var time=null;
		$(main+','+sub).mouseover(function(e){
			clearTimeout(time);
			$(main).removeClass('out').addClass('active');
	        $(sub).css('display','block');
	        e.stopPropagation();
		});
		$(main+','+sub).mouseout(function(e){
			time=setTimeout(function(){
				$(main).removeClass('active').addClass('out');
	        	$(sub).css('display','none');
	        },800);
	        e.stopPropagation();
		})
	},
	//切换学科
	showPartSubjectDiabox:function(main,sub,paperID){
		var time=null;
		$(main+','+sub).mouseover(function(e){
			editPaper.showcart(time,main,sub,paperID);
			e.stopPropagation();
		});
		$(main+','+sub).mouseout(function(e){
			time=setTimeout(function(){
				$(main).removeClass('active').addClass('out');
	        	$(sub).css('display','none');
	        },800);
	        e.stopPropagation();
		})
	},
	//上下题按钮位置
	setPos:function(){
		var pos=1010+($(window).width()-1000)/2;
		$('#pnBtns').css('left',pos);
		$(window).resize(function(){
			    pos=1010+($(window).width()-1000)/2;
		        $('#pnBtns').css('left',pos);
		})
	},
	//显示题型面板
	showPanel:function(){
		var panelHeight=$('#tPanel').height();
		$('#tPanel').css('top',-panelHeight);
		$('#showPanel').click(function(e){
			e.stopPropagation();
			panelHeight=$('#tPanel').height();
			if($(this).hasClass('active')){
				$(this).removeClass('active');
				$('#tPanel').animate({top:-panelHeight},500);
			}else{
				$(this).addClass('active');
				$('#tPanel').animate({top:40},500);
			}
		});
		$('#tPanel').click(function(e){
			e.stopPropagation();
		});
		$(document).click(function(){
			panelHeight=$('#tPanel').height();
			if($('#showPanel').hasClass('active')){
				$('#showPanel').removeClass('active');
				$('#tPanel').animate({top:-panelHeight},500);
			}
		})
		$('.t-num a').click(function(){
			panelHeight=$('#tPanel').height();
			$('#showPanel').removeClass('active');
			$('#tPanel').animate({top:-panelHeight},500);
		})
	},
	
	//题型切换
	oTabSwitch:function(){
		$('.test-tabs a').click(function(){
			$('.test-tabs a').removeClass('active');
			$(this).addClass('active');
			var num=$(this).index();
			$('.t-num').hide();
			$('.t-num').eq(num).show();
		})
	},
	//下拉框选中
	optSelected:function(){
		$('.dropdown').hover(function(){
			$(this).find('ul').show();
		},function(){
			$(this).find('ul').hide();
		})
		$('.dropdown li a').click(function(){
			$(this).parent().parent().hide().siblings('.orderBy').html($(this).html());
		})
	},
	//表格行变色
	changeColor:function(obj){
		$(obj+' tr').hover(function(){
			$(this).css('background-color','#FFFDF3');
		},function(){
			$(this).css('background-color','#ffffff');
		})
	},
	//隐藏答案
	aswHide:function(func1){
		$('.collapse').on('click',function(){
            if($(this).closest('.hd-test').has('.hd-branches').length){
            	if($(this).hasClass('active')){
            		$(this).removeClass('active');
            		$(this).find('span').html('展开');
            		$(this).closest('.hd-test').find('.hd-branches').hide();
            		$(this).closest('.hd-test').find('.hd-cont').removeClass('active');
            		$(this).closest('.hd-test').find('.hd-cont').siblings('.hd-asw').hide();
            	}else{
            		$(this).addClass('active');
            		$(this).find('span').html('收起');
            		$(this).closest('.hd-test').find('.hd-branches').show();
            		$(this).closest('.hd-test').find('.hd-cont').addClass('active');
            		$(this).closest('.hd-test').find('.hd-cont').siblings('.hd-asw').show();
            	}
            }
            else{
            	if($(this).hasClass('active')){
					$(this).removeClass('active');
					$(this).find('span').html('展开');
					$(this).closest('.hd-test').find('.hd-asw').hide();
					$(this).closest('.hd-test').find('.hd-cont').removeClass('active');
				}else{
					$(this).addClass('active');
					$(this).find('span').html('收起');
					$(this).closest('.hd-test').find('.hd-asw').show();
					$(this).closest('.hd-test').find('.hd-cont').addClass('active');
				}
            }
            if(func1){
        		func1($(this).parent().parent().parent());
    		}
		});
		$('.hd-cont').on('click',function(){
			if($(this).closest('.hd-test').has('.hd-branches').length){
				if($(this).next('.hd-branches').is(':visible')){
					$(this).removeClass('active').parent().find('.collapse').removeClass('active');
            		$(this).parent().find('.collapse span').html('展开');
            		$(this).siblings('.hd-asw').hide();
					$(this).next('.hd-branches').hide();
				}else{
					$(this).addClass('active').parent().find('.collapse').addClass('active');
            		$(this).parent().find('.collapse span').html('收起');
            		$(this).siblings('.hd-asw').show();
					$(this).next('.hd-branches').show();
				}
			}
			else{
				if($(this).hasClass('active')){
					$(this).removeClass('active').parent().find('.collapse').removeClass('active');
            		$(this).parent().find('.collapse span').html('展开');
					$(this).parent().find('.hd-asw').hide();
				}else{
					$(this).addClass('active').parent().find('.collapse').addClass('active');
            		$(this).parent().find('.collapse span').html('收起');
					$(this).parent().find('.hd-asw').show();
				}
			}
			if(func1){
				func1($(this).parent());
    		}
		})
		$('.hd-branch').on('click',function(){
			if($(this).find('.hd-asw').is(":visible")){
				$(this).find('.hd-asw').hide();
			}else{
				$(this).find('.hd-asw').show();
			}
		})
		$('.hd-branch .input_num').on('click',function(e){
			e.stopPropagation();
		});
		$('.hd-test').on('click',function(){
			$('.hd-test').removeClass('active');
			$(this).addClass('active');
		});
	},
	addHandler:function(obj,handler,fn){
		if(obj.attachEvent)
    	{
    		obj.attachEvent('on'+handler,fn);
    	}
    	else
    	{
    		obj.addEventListener(handler,fn,false);
    	}
	},
	removeHandler:function(obj,handler,fn){
		if(obj.detachEvent)
    	{
    		obj.detachEvent('on'+handler,fn);
    	}
    	else
    	{
    		obj.removeEventListener(handler,fn,false);
    	}
	},
	//diy滚动条  dIn:内部div dOut:外部div  sOut:滚动条外部   sIn:滚动条内部
	modifyBar:function(dOut,dIn,sOut,sIn){
        var showScrollBar=function(){
        	var n=$('.pbf').length;
        	for(var i=0;i<n;i++){
        	(function(x){
                var a=$(dOut)[x],b=$(dIn)[x],c=$(sOut)[x],d=$(sIn)[x];
				
					c.style.display='block';
					function mousewheel(ev)
					{
						var ev=ev||window.event;
						var bDown=true;
						bDown=ev.wheelDelta?ev.wheelDelta<0:ev.detail>0;
						if(bDown)
						{
							setTop(d.offsetTop+30);
						}
						else
						{
							setTop(d.offsetTop-30);
						}
						if(ev.preventDefault)
						{
							ev.preventDefault();
						}
						return false;
					}					
					rdfunc.addHandler(c,'mousewheel',mousewheel);
					rdfunc.addHandler(c,'DOMMouseScroll',mousewheel);
					rdfunc.addHandler(a,'mousewheel',mousewheel);
					rdfunc.addHandler(a,'DOMMouseScroll',mousewheel);
					d.onmousedown=function(ev)
					{
						var ev=ev||window.event;
						var disY=ev.clientY-d.offsetTop;

						document.onmousemove=function(ev)
						{
							var ev=ev||window.event;
							var t=ev.clientY-disY;
							setTop(t);
							ev.returnValue=false;
						}
						document.onmouseup=function ()
						{
							document.onmousemove=null;
							document.onmouseup=null;
						};
                        return false;
					};

					function setTop(t)
					{
						if(t<0)
						{
							t=0;
						}
						else if(t>c.offsetHeight-d.offsetHeight)
						{
							t=c.offsetHeight-d.offsetHeight;
						}
						d.style.top=t+'px';
						var scale=t/(c.offsetHeight-d.offsetHeight);
						b.style.top=-(b.offsetHeight-a.offsetHeight)*scale+'px';
					};
				
        	})(i)
        }
        };
        showScrollBar();
	},
	sBar:function(dOut,dIn,sOut,n){
		var a=$(dOut)[n],b=$(dIn)[n],c=$(sOut)[n];
		if(b.offsetHeight-a.offsetHeight<=0){
			c.style.display='none';
			a.style.top=0;
		}else{
			c.style.display='block';
		}
		$(window).resize(function(){
			if(b.offsetHeight-a.offsetHeight<=0){
				c.style.display='none';
			}else{
				c.style.display='block';
			}
		})
	},
	//限时更多搜索条件
	showMore:function(){
		$('.showMore').click(function(){
            if($(this).parent().parent().hasClass('active')){
            	$(this).find('span').html('更多');
            	$(this).find('i').html('&#xe6e2;')
            	$(this).parent().parent().removeClass('active')
            }else{
            	$(this).find('span').html('隐藏');
            	$(this).find('i').html('&#xe6e1;')
            	$(this).parent().parent().addClass('active')
            }
		})
	},
 //显示搜索框
	showSearchNew:function(){
		$('#zoomSearch').click(function(){
			$(this).parent().parent().addClass('active');
			$(this).parent().parent().find('input').focus();
		});
		$('#searchInt').blur(function(){
			$(this).parent().parent().parent().removeClass('active');
		})
	},
 
 //筛选菜单
   siftMenu:function(){
	   $('.hd-sel').hover(function(){
	   	  	$(this).addClass('active');
	   	  	var l=$(this).parent().width()-$(this).position().left-12,w=0;
	   	  	$(this).find('em').each(function(){
	   	  		w+=$(this).width()+15;
	   	  	});
	   	  	if(l>w+30){
	   	  		$(this).find('.hd-opt').css('width',w+30);
	   	  	}else{
	   	  		$(this).find('.hd-opt').css('width',l);
	   	  	}
	   	  	$(this).find('.iconfont').html('&#xe6e1;')
	   	  	
	   	  },function(){
	   	  	$(this).find('.iconfont').html('&#xe6e2;')
	   	  	$(this).removeClass('active');
	   	  })
   },
	//隐藏部分内容
	sectionToggle:function(){
		$('.collapse-all').click(function(){
			if($(this).closest('.hd-testgroup').hasClass('active')){
				$(this).removeClass('active');
				$(this).find('span').html('收起');
				$(this).closest('.hd-testgroup').removeClass('active');
			}else{
				$(this).addClass('active');
				$(this).find('span').html('展开');
				$(this).closest('.hd-testgroup').addClass('active');
			}
		})
	},
	//
	insertMask:function(id){
        var maskObj=document.getElementById(id);
        var disX=rdfunc.getCoords(maskObj).left;
        var disY=rdfunc.getCoords(maskObj).top;
        var mask=document.createElement('div');
        mask.id='mask';
        mask.style.position='absolute';
        mask.style.left=disX+'px';
        mask.style.top=disY+'px';
        mask.style.width=maskObj.offsetWidth+'px';
        mask.style.height=maskObj.offsetHeight+'px';
        var imgNode=document.createElement('img');
        imgNode.src='img/loading.gif';
        imgNode.style.width='50px';
        imgNode.style.height='50px';
        imgNode.style.top=(maskObj.offsetHeight-50)/2+'px';
        mask.appendChild(imgNode);
        document.body.appendChild(mask);
   },
   delMask:function(){
    	if(document.getElementById('mask')){
    		var mask=document.getElementById('mask');
    		document.body.removeChild(mask);
    	}
   },
   getCoords:function(el){
	  var box = el.getBoundingClientRect(),
	  doc = el.ownerDocument,
	  body = doc.body,
	  html = doc.documentElement,
	  clientTop = html.clientTop || body.clientTop || 0,
	  clientLeft = html.clientLeft || body.clientLeft || 0,
	  top  = box.top  + (self.pageYOffset || html.scrollTop  ||  body.scrollTop ) - clientTop,
	  left = box.left + (self.pageXOffset || html.scrollLeft ||  body.scrollLeft) - clientLeft
	  return { 'top': top, 'left': left };
	},
	//数字上下变化
	numScroll:function(num){
			$('#s-num').animate({top:40,opacity:0},200,function(){
				$('#s-num').html(num);
				$('#s-num').animate({top:0,opacity:1},200);
			})
	},
   //飞入购物车
   flyToCart:function(obj,num){
   	    var self=this;
	   	var carPosX=$('#myCart').offset().left;
	   	var carPosY=$('#myCart').offset().top;
		var btnPosX=$(obj).offset().left;
		var btnPosY=$(obj).offset().top;
		var newBox=$('<div class="new-item"><div>')
		newBox.css({position:'absolute',left:btnPosX+'px',top:btnPosY+'px'});
		$('body').append(newBox);
		newBox.animate({left:carPosX,top:carPosY},800,function(){
			newBox.remove();
			self.numScroll(num);
		});
   	 	
   },
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
   //模拟弹框2 titletext:题目文字  info：提示信息    suretext：确认框文字  canceltext：true or false   
   modifyDialog:function(titletext,info,suretext,canceltext,callBack,closeCallBack){
   	   if($('#warn')){
   	   	  $('#warn').remove();
   	   }
   	   var str='';
   	   if(canceltext){
   	   	 str='<button class="btn btn-e">取消</button>';
   	   }else{
   	   	 str='';
   	   }
   	   var cont='<div id="warn" class="hd-dialog"><h3 class="hd-diaTit zx-diaTit">'+titletext+'<a class="closeWin" href="javascript:;">×</a></h3><div class="hd-warnCont">'+info+'</div><div class="btn-block"><button class="btn btn-s">'+suretext+'</button>'+str+'</div></div>';
   	   $(cont).appendTo('body');
   	   $.blockUI({ 
	   			message: $('#warn'),
	   			css: { 
	   				width: '380px',
	   			    border:'1px solid #a6c9e2',
	   			    textAlign:'left'
	   		    },
	   		    onBlock: function() {
	   		    	if(callBack){
	   		    		callBack();
	   		    	}
	            } 
		});
	   $('.blockUI.blockMsg').center();
       $('.btn-s').click(function(){
           $.unblockUI({  
               onUnblock : function(){ 
            	   if(closeCallBack){
            		   closeCallBack();
            	   }
            	   if($('#warn')){
            		   $('#warn').remove();
            	   }
               }  
           });
       });
       $('.btn-e,.closeWin').click(function(){
           $.unblockUI();
       });
   	   
   },
	//模拟复选框
	modifyCheckbox:function(){
		$('.a-checkbox').click(function(){
			if($(this).hasClass('active'))
			{
				$(this).removeClass('active');
			}else{
				$(this).addClass('active');
			}
		})
		$('.hd-subtree a').click(function(){
			$(this).parent().find('a').removeClass('active');
			$(this).addClass('active');
		})
	},
	//预览试卷划过变色
	paperColor:function(){
		$('.paper-level1').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).parent().addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).parent().removeClass('active');
		})
		$('.paper-typetit').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).parent().addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).parent().removeClass('active');
		})
		$('.paper-item').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).removeClass('active');
		})
	},
	//表单限时下拉菜单
   showLoadMenu:function(){
   	$('.hd-load').hover(function(){
   		$(this).addClass('active');
   	},function(){
   		$(this).removeClass('active');
   	})
   },
 //试卷预览页面解析显隐
	previewHide:function(){
		$('.paper-itemtit,.paper-itemcont').on('click',function(){
			if($(this).parent().find('.hd-asw').is(":visible")){
				$(this).parent().find('.hd-asw').hide();
			}else {
				$(this).parent().find('.hd-asw').show();
			}
		})
		$('.paper-item .hd-cont').on('click',function(){
			if($(this).parent().find('.hd-branches').is(":visible")){
				$(this).parent().find('.hd-branches').hide();
				$(this).siblings('.hd-asw').hide();
			}else {
				$(this).parent().find('.hd-branches').show();
				$(this).siblings('.hd-asw').show();
			}
		})
		$('.hd-branch').on('click',function(){
			if($(this).find('.hd-asw').is(":visible")){
				$(this).find('.hd-asw').hide();
			}else{
				$(this).find('.hd-asw').show();
			}
		})
	},
	//预览试卷划过变色
	paperColor:function(){
		$('.paper-level1').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).parent().addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).parent().removeClass('active');
		})
		$('.paper-typetit').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).parent().addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).parent().removeClass('active');
		})
		$('.paper-item').hover(function(){
			$(this).find('.paper-btns').show();
			$(this).addClass('active');
		},function(){
			$(this).find('.paper-btns').hide();
			$(this).removeClass('active');
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
	   //根据宽度显示
   toggleWidth:function(){
   		function throttle(method,context){
	 	    clearTimeout(method.tId);
		 	method.tId=setTimeout(function(){
		 		method.call(context);
		 	},100)
		 }
		 function addLess(){
		 	var width=$(window).width();
		 	var height=$(window).height()-190;
		 	if(width<1300){
		 		$('.mc-1,.mc-2,.mc-3,.mc-7,.mc-9').removeClass('active');
		 		$('.mid-wrap').addClass('less');
		 	}else{
		 		$('.mid-wrap').removeClass('less');
		 		if($(".mc-1").hasClass("active")){
		 			$('.mc-1,.mc-2,.mc-3,.mc-7,.mc-9,.mc-10,.mc-11').addClass('active');
		 		}else{
		 			$('.mc-1,.mc-2,.mc-3,.mc-7,.mc-9,.mc-10,.mc-11').removeClass('active');
		 		}
		 	}
		 	$('#contHeight').css('max-height',height);
		 };
		 addLess();
		 function resizeDiv(){
		 	addLess();
		 }
		 $(window).resize(function(){
		 	throttle(resizeDiv);
		 })			 				 
   },
   //点击加背景
   addBg:function(){
   	$('.hd-test').on('click',function(){
   		$('.hd-test').removeClass('active');
   		$(this).addClass('active');
   	})
   },
   //返回顶部
   goTop:function(){
   	$('.mc-3 .lScb2,.mc-3 .ms').css('top',0);
   }
}
