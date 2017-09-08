/// <reference path="jquery-1.4.2.min.js" />
/// <reference path="ToolX3.js" />

var u2Mobile = "";

//页面加载完成
$(function () {

    //$("[DataField='StudentCode']").blur(function() {
    //$(".error[for='" + objId + "'] span").html(msg);
    //$(this).parent().addClass("inp2"); //从父级找tip元素
    //$("span.ts cite.info[for='" + thisid + "']").show();    

    $("#txtUser").blur(function () {
        var v = $(this).val();
        if (u2Mobile=="") //修改手机后刷新图片验证码
        {
            u2Mobile = v; 
        }
        else
        {
            if (u2Mobile != v) {
                u2Mobile = v;
                RefreshImage(); //自动刷新
            }
        }

        checkUser($(this), true);
    });

    //$("#txtVCode").keyup(function () { 
    $("#txtVCode").blur(function () { //防止chrome无法输入
        var obj = $(this);
        var v = obj.val();
        //if (v.length >= 2)

        var resultUser = checkUser($("#txtUser"), false); //必须false非异步
        //alert(resultUser);
        if (resultUser)
            checkVCode($(this), true);
    });

    $("#btnSendSmsCode").click(function () {
    //$("#btnSendSmsCode").unbind('click').click(function () {    
        var result = checkUser($("#txtUser"), false); //必须false非异步       
        if (result == false)
            return false;

        $("#txtSmsCode").val("");//清除手机默认填充
        //$("#txtPwd").val("");

        result = checkVCode($("#txtVCode"), false);
        if (result == false)
        {
            alert("请先输入图片验证码");
            return false;
        }
        
        var mobile = $("#txtUser").val();
        var vCode = $("#txtVCode").val();        

        var apiUrl = "/Apis/Tools.ashx";
        var data = { "method": "U2AjaxSendSmsCode", "mobile": mobile, "vCode": vCode};

        var callback = function (result) {
            if (result == "1") {
                //okMsg(id);
                time($(".p167-insert-verification")); //倒计时
                alert("短信已发送，如果10秒内收不到短信，请检查是否被手机软件拦截");
                return true;               
            }
            else if (result == "vcode1") {               
                alert("请输入图片验证码");
                RefreshImage(); //自动刷新
                return false;
            }
            else {
                //errorMsg(id, result);
                alert(result);
                //time($(".p167-insert-verification")); //倒计时
                return false;
            }
        };

        var ajaxResult = AjaxResult(apiUrl, data); //必须同步        
        callback(ajaxResult); //必须放在callback定义后面
        return (ajaxResult == "1");
    });

    $("#txtPwd").blur(function () {
        checkPwd($(this));
    });

    //$("#txtPwd2").blur(function () {
    //    var result =checkPwd2Same() ;
    //    if(result)
    //        checkPwd($(this));
    //});

});

//检测手机、邮箱
function checkUser(obj, async) {
    var result = false;
    var v = obj.val();
    //var id = obj.attr("id");
    var id = "txtUser";

    $(".p167-find-form-tips1").hide();
    //$(".p167-find-form-tips1").animate({ right: "20", opacity: 0 }, "faster"); //隐藏

    var apiUrl = "/Apis/Tools.ashx";
    var data = { "method": "CheckUser", "user": v };
    //var callback = function (result) { afterCheckUser(result); };
    var callback = function (result) {
        if (result == "2") {
            //errorMsg(id, "该账号已存在，请 <a href='Index.aspx' class='Link'>直接登录</a>");
            //errorMsg(id, "该账号已注册");
            $(".p167-find-form-tips1").animate({ right: "56", opacity: 1 }, "faster").show(); //账号已存在
            //$(".p167-find-form-tips1").animate({ opacity: 1 }, "faster").show(); //账号已存在
            return false;
        }
        else {
            okMsg(id);
            return true;
        }
    };        

    if (IsNullOrEmpty(v) || v == obj.attr("placeholder")) {
        errorMsg(id, obj.attr("placeholder"));
        return false;
    }
    else if (IsMobile(v) == false
        //&& IsEmail(v) == false
        ) {
        errorMsg(id, "手机格式不正确");
        return false;
    }
    else if (v.toLowerCase().indexOf("@xdf.cn") > -1) {
        errorMsg(id, "新东方企业邮箱无需注册，可 <a href='Index.aspx' class='Link'>直接登录</a>");
        return false;
    }
    else {
        if (async) { //输入框异步检测
            AjaxS(apiUrl, data, callback);
        }
        else { //点击按钮同步检测
            var valid = AjaxResult(apiUrl, data); //必须同步     
            callback(valid);
            return (valid == "1");
        }
    }
    //return result;
    //var callback = function (result) { IsStudentCodeCallBack(result); };
    //IsStudentCode(v, callback); //学号
}

function checkPwd(obj) {
    var result = false;
    var v = obj.val();
    //var id = obj.attr("id");
    //alert(IsPwdStrong(v));
    var id = "txtUser";
    if (IsNullOrEmpty(v) || v == obj.attr("placeholder")) {
        errorMsg(id, obj.attr("placeholder"));
    }
    else {
        var bad = HasBad2(v); //危险字符
        if (bad != "") {
            errorMsg(id, bad);
            return false;
        }
        
        if (IsPwdStrong(v) == false) {
            errorMsg(id, "密码必须6-20位");
            return false;
        }
        
            okMsg(id);
            result = true;       
    }
    return result;
}

//验证两次密码一致
//function checkPwd2Same() {
//    var id = "txtUser";
//    if ($("#txtPwd").val() != $("#txtPwd2").val()) {
//        errorMsg(id, "两次密码不一致");
//        return false;
//    }
//    return true;
//}

//验证码
function checkVCode(obj, async) {
    var result = false;
    var v = obj.val();
    //var id = obj.attr("id");
    var id = "txtUser";

    var apiUrl = "/Apis/Tools.ashx";
    var data = { "method": "VerifyVCode", "vCode": v };
    var callback = function (result) {
        if (result != "1") {
            RefreshImage(); //自动刷新
            errorMsg(id, "验证码错误");
        }
        else {
            okMsg(id);
            result = true;
        }
    };

    if (IsNullOrEmpty(v) || v == obj.attr("placeholder")) {
        errorMsg(id, "请输入验证码");
    }
    else {
        if (async) { //输入框异步检测
            AjaxA(apiUrl, data, callback);
        }
        else { //点击按钮同步检测
            var valid = AjaxResult(apiUrl, data); //必须同步
            //alert(valid);
            callback(valid);
            return (valid == "1");
        }
    }
    return result;
}

//按钮验证
function Verify() {
    var accept = g("accept");
    if (accept != null && accept.checked == false) {
        alert("请先选中“我接受并同意《用户服务条款》”才能注册");
        return false;
    }

    var result = checkUser($("#txtUser"), false);

    //if (result)
    //    result = checkVCode($("#txtVCode"), false);

    if(result) //短信码
    {        
        var id = "txtUser";
        var obj = $("#txtSmsCode");
        var v = obj.val();
        if (IsNullOrEmpty(v) || v == obj.attr("placeholder")) {
            errorMsg(id, obj.attr("placeholder"));
            result = false;            
        }
        else
        {
            result = true;
        }       
    }

    if(result)
        result = checkPwd($("#txtPwd"));

    //if (result)
    //    result = checkPwd($("#txtPwd2"));

    //if (result)
    //    result = checkPwd2Same();  

    if (result) {
        $("#btnRegister").val("正在注册...");
        $("#btnRegister").html("正在注册...");
        gaStatBtn("注册", "左侧-立即注册");
        return true;
    }

    return false;
}


//按钮验证，设置初始密码
function VerifySetFirstPwd() {
    if (result)
        result = checkPwd($("#txtPwd"));

    if (result) {
        $("#btnSetFirstPwd").val("正在操作...");
        //gaStatBtn("注册", "左侧-立即注册");
        return true;
    }

    return false;
}


////是否学号回调方法
//function IsStudentCodeCallBack(result) {
//    if (result == "1")
//        $("#trStudentName").show();
//    else
//        $("#trStudentName").hide();
//}

//ga按钮统计，js全局变量EnableStat无效
function gaStatBtn(name, memo) {
    if (enableStat != "1") {
        //alert("未开启ga");
        return;
    }

    try {

        var timestamp = new Date().getTime();
        //晶赞 20160621
        dasp3Submit({
            pt: "regSuccPage",
            p_zp_conversion: "e15788087e57cedaadd53553a087d195",
            p_zp_convinfo: timestamp + ",100"
        });

        //_gaq.push(['_trackEvent', '登陆', 'passport.xdf.cn', '右侧-登陆']);
        _gaq.push(['_trackEvent', name, 'passport.xdf.cn', memo]);
    }
    catch (e) { }
}

//晶赞 20160621
function dasp3Submit(param) {
    window.__zp_tag_params = param;
    (function (param) {
        var c = { query: [], args: param || {} };
        c.query.push(["_setAccount", "342"]);
        c.query.push(["_setSiteID", "1"]);
        (window.__zpSMConfig = window.__zpSMConfig || []).push(c);
        var zp = document.createElement("script"); zp.type = "text/javascript"; zp.async = true;
        zp.src = ("https:" == document.location.protocol ? "https:" : "http:") + "//cdn.zampda.net/s.js";
        var s = document.getElementsByTagName("script")[0]; s.parentNode.insertBefore(zp, s);
    })(window.__zp_tag_params);
}
