$(function () {
    if (!placeholderSupport()) {   /*判断浏览器是否支持 placeholder*/
        $('[placeholder]').focus(function () {
            var input = $(this);
            if (input.val() == input.attr('placeholder')) {
                input.val('');
                input.removeClass('placeholder');
            }
        }).blur(function () {
            var input = $(this);
            if (input.val() == '' || input.val() == input.attr('placeholder')) {
                input.addClass('placeholder');
                input.val(input.attr('placeholder'));
            }
        }).blur();
    };
})

function placeholderSupport() {
    return 'placeholder' in document.createElement('input');
}

/*弹窗*/
$(function () {
    var oCover = $(".p167-cover");
    var oLayer = $(".p167-layer");
    var oQuestion = $(".p167-question");

    $(".p167-insert-load").click(function () {
        popUp(oCover, oLayer);
    });
    $(".p167-cover-choice a").click(function () {
        popHide(oLayer, oCover)
    });
    $(".p167-bind-tips").click(function () {
        popUp(oQuestion, oLayer);
    })
    $(".p167-question-close").click(function () {
        popHide(oLayer, oQuestion);
    })

    function popUp(obj, layer) {
        obj.css('left', ($(window).width() - obj.outerWidth()) / 2);
        obj.css('top', ($(window).height() - obj.outerHeight()) / 2);
        obj.show();
        layer.show();
    };
    function popHide(obj, layer) {
        obj.hide();
        layer.hide();
    };
})

/*footer*/
/*$(function(){ 
    $(window).on('resize scroll',function(){
    console.log($(window).height())
    console.log($("body").outerHeight())
        if(($(window).height()- $("body").outerHeight())+100> 0){
        $('.p167-footer').css("position","fixed");
    }
    else{
        $('.p167-footer').css('position','relative');
    }  
    });
})*/

/*获取验证码*/
var waitTotal = 60;
var wait = 60;
function time(o) {
    if (wait == 0) {
        o.attr("disabled", false);
        o.val("获取验证码");
        o.removeClass("active");
        $(".p167-insert-send").hide();
        wait = waitTotal;
    } else {
        o.attr("disabled", true);
        o.val("重新获取(" + wait + ")");
        o.addClass("active");
        wait--;
        setTimeout(function () {
            time(o)
        },
        1000);
    }
}

$(function () {
    /*倒计时 获取smsCode */
    //$(".p167-insert-verification").click(function () {
    //    u2ajaxSendSmsCodeOnVerify();
    //    time($(this));
    //    $(".p167-insert-send").show();
    //});

    //if (wait != waitTotal) //倒计时刷新页面时继续倒计时
    //time($(".p167-insert-verification")); //倒计时

    var o = $(".p167-insert-verification"); //刷页恢复倒计时
    o.attr("disabled", false);
    o.val("获取验证码");
    o.removeClass("active");
    $(".p167-insert-send").hide();

    /*倒计时*/
    $(".p167-find-form-verification").click(function () {
        time($(this));
    });
    //模拟checkbox
    $(".p167-find-check-like").click(function () {
        $(this).toggleClass("active");
        if ($(this).hasClass("active")) {
            $(".p167-find-check").attr("checked", true);
        } else {
            $(".p167-find-check").attr("checked", false);
        }
    });
    /*用户名已注册提示*/
    $(".p167-find-btn1").click(function () {
        if ($(".p167-find-check").is(":checked")) {
            $(".p167-find-form-tips1").animate({ right: "20", opacity: 1 }, "faster");
        }
    });

})
/*底部*/
/*$(function(){
    function a() {
        $(".p167-bind").addClass("js-main");

        $('.p167-footer').css('position', 'absolute');
        if ($(window).height() > ($(".js-main").outerHeight() + 50 +98+80- 1)) {
            console.log(1)
            $('.p167-footer').css('top', 'auto');
            $('.p167-footer').css('bottom', '0');
        } else {
            console.log(2)
            $('.p167-footer').css('top', $(".js-main").outerHeight()+98+80);
            console.log($(".js-main").outerHeight())
        }
    }
    $(window).on('resize scroll', function() {
        a();
    });
    a();

})*/

//mike 20160421
// 3、var o = $(".p167-insert-verification"); //刷页恢复倒计时

/* auto resize meng 20160422 */
//$(function () {
//    function resize() {
//        $('.p167-footer').css('position', 'fixed');
//        if ($(window).height() > 700) {
//            $('.p167-footer').css('top', 'auto');
//            $('.p167-footer').css('bottom', '0');
//        } else {
//            $('.p167-footer').attr('style', '');
//        }
//    }

//    $(window).on('resize', function () {
//        var timeout = null;
//        clearTimeout(timeout);
//        timeout = setTimeout(function () {
//            resize();
//        }, 100);
//        resize();
//    });

//    resize();
//});
