
function g(id) {
    return document.getElementById(id);
}

function v(id) {
    return document.getElementById(id).value;
}

function setCookie(name, value, days, Tdom) {
    var Tdom = (Tdom) ? Tdom : "/";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=" + Tdom;
}

function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') { c = c.substring(1, c.length); }
        if (c.indexOf(nameEQ) == 0) { return c.substring(nameEQ.length, c.length); }
    }
    return null;
}


function deleteAllCookies() {
    //debugger;
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        setCookie(name, "", -1, null);
    }
}

//Js得到Url中参数
function Request(key) {
    key = key.toLowerCase();
    var url = location.href.toLowerCase();
    var keyValues = url.replace("?", "?&").split("&");
    var value = "";
    for (i = 1; i < keyValues.length; i++) {
        if (keyValues[i].indexOf(key + "=") == 0)
            value = keyValues[i].replace(key + "=", "");
    }
    return value;
}

//得到Url参数
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return r[2];
    }
    return null;
}

//设置Url参数，存在则替换
function SetUrlParam(url, pname, pvalue) {
    var strNewUrl = new String();
    var strUrl = url;
    if (strUrl.indexOf("?") != -1) {
        strUrl = strUrl.substr(strUrl.indexOf("?") + 1);
        if (strUrl.toLowerCase().indexOf(pname.toLowerCase()) == -1) {
            strNewUrl = url + "&" + pname + "=" + pvalue;
            return strNewUrl;
        }
        else {
            var aParam = strUrl.split("&");
            for (var i = 0; i < aParam.length; i++) {
                if (aParam[i].substr(0, aParam[i].indexOf("=")).toLowerCase() == pname.toLowerCase()) {
                    aParam[i] = aParam[i].substr(0, aParam[i].indexOf("=")) + "=" + pvalue;
                }
            }
            strNewUrl = url.substr(0, url.indexOf("?") + 1) + aParam.join("&");
            return strNewUrl;
        }
    }
    else {
        strUrl += "?" + pname + "=" + pvalue;
        return strUrl
    }
}

//动态设置maxLength 防止复制进入
var SetMaxLength = function (inputObj, maxLength) {
    var realMax = maxLength;
    var v = inputObj.value;
    var len = 0; //长度中文算2
    var cnAmount = 0; //中文个数
    for (i = 0; i < v.length; i++) {
        if (v.charCodeAt(i) > 256) {
            len += 2;
            cnAmount++;
            realMax--;
        }
        else {
            len++;
        }
    }
    //注意L字母必须大写
    inputObj.maxLength = realMax;
    //alert("realMax" + realMax);

    //清除复制超长文本，计算保留长度
    var remainLength = maxLength - cnAmount;
    if (remainLength < (maxLength / 2)) {
        remainLength = (maxLength / 2);
    }
    inputObj.value = v.substring(0, remainLength);
}

//中美字符计算，一个中文算2个字符
var CnLength = function (value) {
    //var v = inputObj.value;
    var v = value;
    var len = 0; //长度中文算2
    var cnAmount = 0; //中文个数
    for (i = 0; i < v.length; i++) {
        if (v.charCodeAt(i) > 256) {
            len += 2;
            cnAmount++;
        }
        else {
            len++;
        }
    }
    return len;
}

//注册用户名只允许中美双语、数字，自动清除所有其它字符
//onkeyup="NickNameRule(this);"  onblur="NickNameRule(this);"   
function NickNameRule(inputObj) {
    inputObj.value = inputObj.value.replace(/[^A-Za-z0-9\u4e00-\u9fa5]/g, '')
}

//注册用户名只允许美语、数字，自动清除所有其它字符
//onkeyup="NickNameRule(this);"  onblur="NickNameRule(this);"   
function NickNameRule0(inputObj) {
    inputObj.value = inputObj.value.replace(/[^A-Za-z0-9]/g, '')
}

//只能输入数字及 . + - e E 符号
//onkeyup="NumberRule(this);"  onblur="NumberRule(this);"   
function NumberRule(inputObj) {
    inputObj.value = inputObj.value.replace(/[^eE0-9.\-\+]/g, '')
}

//只能输入数字
//onkeyup="IntRule(this);"  onblur="IntRule(this);"   
function IntRule(inputObj) {
    inputObj.value = inputObj.value.replace(/[^\d]/g, '')
}

//Js四舍五入，默认两位小数 22.125456为22.13 而22.124456 为22.12
function R5(number) {
    var num = Math.round(number * 100) / 100;
    return num;
}

//Js验证
function IsEmail(s) {
    var pattern = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    if (!pattern.exec(s))
        return false;
    return true;
}

//是否手机号
function IsMobile(s) {
    //var pattern = /1[3|5|8]\d{9}/;
    //var pattern = /1\d{10}/;
    var pattern = /^1[3456789]\d{9}$/;
    if (!pattern.exec(s))
        return false;
    return true;
}

//是否数字开头
function IsIntStart(s) {
    //var pattern = /1[3|5|8]\d{9}/;
    //var pattern = /1\d{10}/;
    //var pattern = /^\d{1}$/;
    var pattern = /^\d{1}/;
    if (!pattern.exec(s))
        return false;
    return true;
}

//操作进度提示
function ActionTip1() {
    var tip = document.getElementById("ActionTip1");
    tip.style.display = "";
    TimeTick1(1);
}

//操作进度显示百分比
function TimeTick(second) {
    var tip = document.getElementById("TimeTip");
    tip.innerHTML = second.toString() + "%";
    if (second >= 100)
        second = 70;
    setTimeout("TimeTick(" + (second + 1) + ")", 100);
}

//操作进度显示百分比1
function TimeTick1(second) {
    var tip = document.getElementById("TimeTip1");
    tip.innerHTML = second.toString() + "%";
    if (second >= 100)
        second = 70;
    setTimeout("TimeTick1(" + (second + 1) + ")", 100);
}

//数组contains
function Contains(item, array) {
    for (i = 0; i < array.length; i++) {
        if (array[i] == item)
            return true;
    }
    return false;
}

//密码不允许包含危险字符
var badArray = ["&#", "<"];
function HasBad(source) {
    var array = badArray;
    for (i = 0; i < array.length; i++) {
        if (source.indexOf(array[i]) >= 0) {
            alert("密码不允许包含危险字符：" + array[i]);
            return true;
        }
    }
    return false;
}

function HasBad2(source) {
    var array = badArray;
    for (i = 0; i < array.length; i++) {
        if (source.indexOf(array[i]) >= 0) {
            return "密码不允许包含危险字符：" + array[i];
        }
    }
    return "";
}

//传递方法名当参数
function callMethod(methodName) {
    this.call = new Function(methodName + "();");
}

//倒计时1
function TimeTick(tipId, jumpUrl) {
    var tip = document.getElementById(tipId);
    if (tip == null) {
        alert("找不到" + tipId);
        return;
    }
    if (tipSecond <= 0) {
        window.location.href = jumpUrl; //跳转
        return;
    }
    tip.innerHTML = tipSecond.toString();
    //setTimeout("TimeTick(" + (second - 1) + ",'" + tipId + "'" + ",'" + jumpUrl + "')", 1000);
    setTimeout("TimeTick(" + "'" + tipId + "'" + ",'" + jumpUrl + "')", 1000);
    tipSecond--;
}

//倒计时2
function TimeTick2(tipId, methodName) {
    var tip = document.getElementById(tipId);
    if (tip == null) {
        alert("找不到" + tipId);
        return;
    }
    if (tipSecond <= 0) {
        //window.location.href = jumpUrl; //跳转
        new callMethod(methodName).call();
        return;
    }
    tip.innerHTML = tipSecond.toString();
    setTimeout("TimeTick2(" + "'" + tipId + "'" + ",'" + methodName + "')", 1000);
    tipSecond--;
}

//ajax异步post
function AjaxA(apiUrl, data, callBack) {
    AjaxAction(apiUrl, data, callBack, "post", true);
}
//ajax同步post
function AjaxS(apiUrl, data, callBack) {
    AjaxAction(apiUrl, data, callBack, "post", false);
}
//ajax异步get
function AjaxGetA(apiUrl, data, callBack) {
    AjaxAction(apiUrl, data, callBack, "get", true);
}
//ajax同步get
function AjaxGetS(apiUrl, data, callBack) {
    AjaxAction(apiUrl, data, callBack, "get", false);
}
//ajax调用
function AjaxAction(apiUrl, data, callBack, httpMethod, isAsync) {
    $.ajax({
        //url: "/apis/Users.ashx",
        url: apiUrl,
        type: httpMethod, //'get' 或 'post'
        //data: { "type": "1", "Code": inputValue },
        data: data,
        async: isAsync,  //true异步，false同步
        success: function (response) {
            //alert(response);            
            callBack(response);
        },
        error: function (xml, status) {
            //alert(xml.responseText);
        }
    });
}

//ajax调用
function AjaxResult(apiUrl, data)
{
    var isAsync = false; //必须同步才能返回值
    return AjaxResultAction(apiUrl, data, "post", isAsync);
}

//ajax调用
function AjaxResultAction(apiUrl, data, httpMethod, isAsync) {
    var returnValue = "-2"; //返回值
    $.ajax({
        //url: "/apis/Users.ashx",
        url: apiUrl,
        type: httpMethod, //'get' 或 'post'
        //data: { "type": "1", "Code": inputValue },
        data: data,
        async: isAsync,  //true异步，false同步
        success: function (response) {
            //alert("response：" +response);            
            //callBack(response);
            //return response;
            returnValue = response; //返回值
        },
        error: function (xml, status) {
            //alert(xml.responseText);
        }
    });
    return returnValue;
}

//是否学号
function IsStudentCode(code, callback) {
    var apiUrl = "/Apis/Tools.ashx";
    var data = { "method": "IsStudentCode", "studentCode": code };
    AjaxA(apiUrl, data, callback);
}

function IsNullOrEmpty(v)
{
    if (v == null || v == "undefined" || v == "")
        return true;
    
    return false;
}

//刷新验证码
function RefreshImageById(imgId) {
    document.getElementById(imgId).src = "/Shared/ValidateCode.aspx?type=5&abc=" + Math.random(); //刷新验证码
    $("#txtVCodeIcon").attr("class","");
    $("#txtVCodeTip").html("");
    $("#txtVCode").val("");
}

//验证码
function checkVCodeAjax(vCode, callback)
{
    var apiUrl = "/Apis/Tools.ashx";
    var data = { "method": "VerifyVCode", "vCode": vCode };
    AjaxA(apiUrl, data, callback);
}

function errorMsg(objId, msg) {
    var iconObj = $("#" + objId + "Icon"); //图标
    var tipObj = $("#" + objId + "Tip"); //文字    
    iconObj.attr("class", "icoError");   
    tipObj.html(msg);
}

function okMsg(objId) {
    var iconObj = $("#" + objId + "Icon"); //图标
    var tipObj = $("#" + objId + "Tip"); //文字    
    iconObj.attr("class", "icoRight");
    tipObj.html("");
}

function clearMsg(objId) {
    var iconObj = $("#" + objId + "Icon"); //图标
    var tipObj = $("#" + objId + "Tip"); //文字    
    iconObj.attr("class", "");
    tipObj.html("");
}

//得到顶级域名，例如test.xdf.cn/1.aspx得到xdf.cn
function getTopDomain(url) {
    if (url == null)
        return "";

    url = url.toLowerCase();
    url = url.replace("http://", "").replace("https://", "");
    url = url.split("/", 1).toString(); //testu2.xdf.cn                
    var list = url.split(".");
    var length = list.length;
    url = list[length - 2] + "." + list[length - 1]; //xdf.cn
    //alert(url);
    return url;
}

//密码必须6到15位
function IsPwdStrong(s) {
    //var pattern = /^(?![^a-zA-Z]+$)(?!\D+$)(?=.*[~!@#$%^&*()-+=]).{6,15}$/; //同时包含数字字母特殊符号
    //var pattern = /^(?![^a-zA-Z]+$)(?!\D+$).{6,15}$/; //同时包含数字字母
    //if (!pattern.exec(s))
    //    return false;
    if (s.length < 6)
        return false;
    return true;
}

//得到当前时间yyyy-MM-dd HH:MM:SS
function getNow() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}

//异步检测浏览器当前时间与服务器时间误差是否超过5分钟
function CheckTimeDiffer()
{
    var jsNow = getNow();
    var apiUrl = "/Apis/Tools.ashx";
    var data = { "method": "CheckTimeDiffer", "jsNow": jsNow };
    var callback = function (result) {
        if (result != "1") {
            //误差超过5分钟
            alert(result);
        }
        else {
            //alert(result);
        }
    };

    AjaxA(apiUrl, data, callback); //异步
}