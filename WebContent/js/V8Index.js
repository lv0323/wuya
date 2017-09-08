/// <reference path="jquery-1.4.2.min.js" />
/// <reference path="ToolX3.js" />

//页面加载完成
$(function () {

    //文本框焦点
    //$("input[type='text']").focus(function () {
    //    var obj = $(this);
    //    if (obj.val() == obj.attr('defaultval')) {
    //        obj.val("");
    //    }
    //});

    ////文本框离开
    //$("input[type='text']").blur(function () {
    //    var obj = $(this);
    //    if (obj.val() == "") {
    //        obj.val(obj.attr("defaultval"));
    //    }
    //});

    $("#txtUser").blur(function () {
        checkUser($(this), true);
    });

    $("#txtPwd").blur(function () {
        checkPwd($(this));
    });

    ////$("#txtVCode").keyup(function () { 
    //$("#txtVCode").blur(function () { //防止chrome无法输入
    //    var obj = $(this);
    //    var v = obj.val();
    //    //if (v.length >= 2)
    //    checkVCode($(this), true);
    //});

});


//检测手机、邮箱
function checkUser(obj, async) {
    var result = false;
    var v = obj.val();
    var id = obj.attr("id");

    if (IsNullOrEmpty(v) || v == obj.attr("placeholder")) {
        //errorMsg(id, "请输入邮箱/手机");
        //errorMsg(id, "请输入邮箱/手机");
        //alert(obj.attr("placeholder"));
        errorMsg(id, obj.attr("placeholder"));
        return false;
    }
    else if (IsMobile(v) == false
        && IsEmail(v) == false) {
        errorMsg(id, "手机/邮箱格式不正确");
        return false;
    }
    else {
        okMsg(id);
        //clearMsg(id);
        return true;
    }
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

        //登陆不限制
        //if (IsPwdStrong(v) == false) {
        //    errorMsg(id, "密码必须6-20位");
        //    return false;
        //}

        okMsg(id);
        result = true;
    }
    return result;
}

//验证码
function checkVCode(obj, async) {
    var result = false;
    var v = obj.val();
    var id = obj.attr("id");

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

    if (IsNullOrEmpty(v) || v == obj.attr("defaultval")) {
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

    var result = checkUser($("#txtUser"), false);
    if (result)
        result = checkPwd($("#txtPwd"));

    //var resultVCode = checkVCode($("#txtVCode"), false); //不检测智能验证码
    if (result) {
        $("#btnLogin").val("登录中...");
        $("#btnLogin").html("登录中...");
        gaStatBtn("登陆", "右侧-登陆");
        return true;
    }

    return false;
}

//ga按钮统计，js全局变量EnableStat无效
function gaStatBtn(name, memo) {
    if (enableStat != "1") {
        //alert("未开启ga");
        return;
    }

    try {
        //_gaq.push(['_trackEvent', '登陆', 'passport.xdf.cn', '右侧-登陆']);
        _gaq.push(['_trackEvent', name, 'passport.xdf.cn', memo]);
    }
    catch (e) { }
}