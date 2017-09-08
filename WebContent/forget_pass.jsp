<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"><meta charset="UTF-8"><title>
	无涯通行证 登录
</title><link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <style type="text/css">
        .icoRight { display: none; }
        /* 最外层div用icoError会自动隐藏 */
        .p139-input2 { width: 240px; }
        .p167-find-form input.p139-input2 { width: 316px; }
        .p167-find-form input.p139-input-n { height: 52px; line-height: 52px; padding-left: 0; }
    </style>

    

<link rel="icon" href="http://passport.xdf.cn/favicon.ico" type="image/x-icon">  
<link rel="shortcut icon" href="http://passport.xdf.cn/favicon.ico" type="image/x-icon">  

<style id="weel__float-action-button--css">@font-face {font-family: 'weel-translate';src: url("moz-extension://69e88323-2d77-431a-bef0-1d353269f711/fonts/weel-translate.ttf") format("truetype"), url("moz-extension://69e88323-2d77-431a-bef0-1d353269f711/fonts/weel-translate.woff") format("woff");font-weight: normal;font-style: normal;}weel{box-sizing:border-box;display:block}weel *,weel :after,weel :before{box-sizing:inherit}weel#weel__float-action-button{-webkit-transition:visibility .25s ease,opacity .25s ease;transition:visibility .25s ease,opacity .25s ease;left:0;top:0;position:fixed;z-index:999999}weel#weel__float-action-button._on{visibility:visible!important;opacity:1!important}weel#weel__float-action-button--container{box-shadow:0 1px 2px rgba(97,97,97,.65);cursor:default;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;border:1px solid #ebebeb;border-radius:4px;background-color:#fafafa;height:28px;width:28px;position:relative}weel#weel__float-action-button--icon{font-family:weel-translate!important;font-style:normal;font-weight:400;font-variant:normal;text-transform:none;line-height:1;background-size:cover;color:#3e84f4;height:20px;width:20px;margin:auto;left:-1px;bottom:0;right:0;top:-1px;position:absolute;font-size:20px}weel#weel__float-action-button--icon:before{content:"\e927"}</style><style id="weel__float-action-panel--css">@font-face {font-family: 'weel-translate';src: url("moz-extension://69e88323-2d77-431a-bef0-1d353269f711/fonts/weel-translate.ttf") format("truetype"), url("moz-extension://69e88323-2d77-431a-bef0-1d353269f711/fonts/weel-translate.woff") format("woff");font-weight: normal;font-style: normal;}weel{box-sizing:border-box;display:block}weel *,weel :after,weel :before{box-sizing:inherit}weel#weel__float-action-panel{-webkit-transition:visibility .25s ease,opacity .25s ease;transition:visibility .25s ease,opacity .25s ease;width:24px;padding:12px 0;left:0;top:0;z-index:999999;position:fixed}weel#weel__float-action-panel:after,weel#weel__float-action-panel:before{content:"";border:10px solid transparent;border-bottom-color:#fff;height:0;width:0;margin:auto;left:0;right:0;top:0;position:absolute;display:block}weel#weel__float-action-panel:before{-webkit-filter:blur(1px);filter:blur(1px);border-width:12px;border-bottom-color:hsla(0,0%,48%,.24);top:-10px;z-index:1}weel#weel__float-action-panel:after{top:-6px;z-index:2}weel#weel__float-action-panel._reverse:before{-webkit-filter:blur(1px);filter:blur(1px);border-width:12px;border-bottom-color:transparent;border-top-color:hsla(0,0%,48%,.24);bottom:-10px;top:auto;z-index:1}weel#weel__float-action-panel._reverse:after{border-bottom-color:transparent;border-top-color:#fff;top:auto;bottom:-6px;z-index:2}weel#weel__float-action-panel._no-arrow:after,weel#weel__float-action-panel._no-arrow:before{display:none}weel#weel__float-action-panel._on{visibility:visible!important;opacity:1!important}weel#weel__float-action-panel--container{box-shadow:0 1px 2px rgba(97,97,97,.65);border:1px solid #ebebeb;border-radius:2px;background-color:#fff;width:220px;z-index:2;position:relative}weel#weel__float-action-panel--i-voice:before{content:"\e050"}weel#weel__float-action-panel--i-copy:before{content:"\e14d"}weel#weel__float-action-panel--i-copy,weel#weel__float-action-panel--i-voice{cursor:default;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;font-family:weel-translate!important;font-style:normal;font-weight:400;font-variant:normal;text-transform:none;line-height:1;height:24px;width:24px;color:#666;line-height:24px;margin-left:0;position:absolute;overflow:hidden}weel#weel__float-action-panel--i-copy:hover,weel#weel__float-action-panel--i-voice:hover{color:#3e84f4}weel#weel__float-action-panel--i-copy:active,weel#weel__float-action-panel--i-voice:active{color:gray}weel#weel__float-action-panel--output-stream-result{background-color:#fff;padding:16px}weel#weel__float-action-panel--output-stream-result._on{display:block}weel#weel__float-action-panel--output-stream-explain,weel#weel__float-action-panel--output-stream-phonetic{position:relative}weel#weel__float-action-panel--output-stream-explain._on,weel#weel__float-action-panel--output-stream-phonetic._on{display:block}weel#weel__float-action-panel--output-stream-explain-plain,weel#weel__float-action-panel--output-stream-phonetic-plain{font-size:14px;line-height:1.35;padding-top:4px;text-indent:24px;padding-right:16px;width:100%}weel#weel__float-action-panel--output-stream-phonetic{color:#999;margin-bottom:6px}weel#weel__float-action-panel--output-stream-explain-plain{font-weight:600}weel#weel__float-action-panel--output-stream-explain-plain+textarea{opacity:0;height:0;width:100%;border:none;position:absolute}weel#weel__float-action-panel--output-stream-explain-detail{max-height:120px;overflow-x:hidden;overflow-y:auto;border-top:1px solid #f5f5f5;font-size:12px;line-height:1.75;padding-top:8px;margin:8px 0;color:#4d4d4d;display:none}weel#weel__float-action-panel--output-stream-explain-detail._on{display:block}</style></head>

<body style="min-height: 800px;">

    <form name="form1" method="post" action="forgetPwd.aspx" id="form1">
<div>
<input name="__VIEWSTATE" id="__VIEWSTATE" value="wn51KVOJE6bA7/Y3BVRpHmERSRvsYeT1elgPLUtk83dQHmaaWJaRoRD1NVwXS9drmSYXi6XQhdYi08KIpRduLV/kboKQyivBhGUizY4TKiEgpQi5v7Nb7CZ9CH8=" type="hidden">
</div>

<div>

	<input name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="6l0EYvQbpa75ESV8C/jseafu1YtwKFgi2pjPl6O8rXP+XTdgLyvqRnFl4MR9UfyVyTiwl6qjXfR+sOclL/fVvrytdv5G+QpCgIoEmi1sWCjOCmSLD/JBWdl5EpcnM1GCEczXI8ElwThw3N/2KEQUgUWvlg8Ufg0nxQkR7Rex2MAaTqSjl2QSue6H3/qf77aEpHyWlu41RjG/3x/u6BqLhOY4PYJCA+dlhpsCCIVa50PW11N0QC3XIYpikVM=" type="hidden">
</div>

        
        <script src="${pageContext.request.contextPath}/js/m2pc_m2.js"></script>
        

        <div class="p167-nav">
            <div class="p167-nav-in">
                <a href="http://passport.xdf.cn/i/m2pc/logo.aspx" target="_blank" class="p167-nav-in-left"></a>
                <span class="p167-nav-in-right"><a href="http://passport.xdf.cn/i/m2pc/index.aspx" class="toplink1">登录</a><span class="p167-nav-in-right-s">|</span><a href="http://passport.xdf.cn/i/m2pc/register.aspx" class="p167-nav-in-right-register toplink2">注册</a></span>
            </div>
        </div>

        


        <div class="p167-permit" style="margin-bottom: 0; position: relative;">

            <div class="icoError" id="txtUserIcon" style="position: absolute; top: -85px; left: 0;">
                <i></i><span id="txtUserTip"></span>
            </div>

            <h1>无涯通行证 忘记密码</h1>
            <div class="p167-find-form">

                

                <input name="txtUser" maxlength="50" id="txtUser" class="p139-input" placeholder="请输入用户名" type="text">
                <input name="" maxlength="50" id="txtUser" class="p139-input" placeholder="请输入绑定邮箱" type="text">

                <!-- 验证码 -->
                <div id="trVCode" class="p167-permit-phone" style="border-bottom: 1px solid #ebebeb;">
                    <table>
                        <tbody><tr>
                            <td style="width: 247px;">
                                <input name="txtVCode" maxlength="5" id="txtVCode" class="p139-input p139-input-n" placeholder="请输入图片验证码" style="width:120px;" type="text">
                            </td>
                            <td>
                                <span class="captcha-img">
                                    <img id="Image1" class="x-vcode-img" onclick="RefreshImage()" title="看不清楚？换张图片" src="${pageContext.request.contextPath}/images/ValidateCode.jpg" style="border-width:0px;cursor: pointer; vertical-align: top; width: 68px; height: 40px;" align="middle">
                                </span>
                            </td>
                        </tr>
                    </tbody></table>
                </div>

                <!-- 短信码、邮箱码 -->

                <input name="txtPwd" maxlength="20" id="txtPwd" class="p139-input" placeholder="请输入新密码至少6位" type="password">


            </div>
            <a id="btnLogin" href="javascript:clickbtnNext();" class="p167-bind-btn">重置密码</a>
            
        </div>

        <!--<a href="studentMobileName.aspx" class="p167-passport">
            <span>老生登录</span><i></i>
        </a>-->

        <!--20160825改S-->
        <div class="p167-passportbox">
            <a href="http://passport.xdf.cn/i/m2pc/index.aspx" class="p167-passport p167-passportleft" style="display: inline;">
                <span>通行证登录</span>
                <i></i>
            </a>
            <a href="http://passport.xdf.cn/i/m2pc/studentMobileName.aspx" class="p167-passport" style="display: inline;">
                <span>管理员登录</span>
                <i></i>
            </a>
        </div>
        <style type="text/css">
            .p167-permit { padding: 10px 40px 36px 40px; }
            .p167-passportbox { text-align: center; margin-top: 40px; }
            .p167-passportleft { border-right: 1px solid #bebebe; padding-right: 10px; margin-right: 4px; }
            .p167-passportbox { text-align: center; margin-top: 40px; }
            .p167-passportleft { border-right: 1px solid #bebebe; padding-right: 10px; margin-right: 10px; }
            .p121-messege { margin-bottom: 15px; color: #999; margin-top: -20px; }
        </style>
        <!--20160825改E-->

        <div class="p167-footer">
            <p>Copyright Neworiental Corporation, All Rights Reserved</p>
            <p>© 无涯 版权所有</p>
        </div>




        <div style="display: none;">
            <input name="btnNext" value="下一步" id="btnNext" type="submit">
            
            
            <input name="btnSendSmsEmailCode" id="btnSendSmsEmailCode" value="获取短信码邮箱码" type="button">
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
        <script src="${pageContext.request.contextPath}/js/p167.js"></script>

        <script src="${pageContext.request.contextPath}/js/ToolX3.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/V92m2pcForgetPwd.js" type="text/javascript"></script>
        <script type="text/javascript">
            function RefreshImage() {
                RefreshImageById("Image1");
            }

            //function clickGetSmsCode() {
            //    $("#btnSendSmsCode").click();
            //}

            function clickGetSmsEmailCode() {
                $("#btnSendSmsEmailCode").click();
            }

            function clickbtnNext() {
                if (Verify())
                    $("#btnNext").click();
            }
        </script>

        <script type="text/javascript">
            var enableStat = "0"; //ga统计js全局变量
        </script>
        


    </form>


<weel style="visibility: hidden; opacity: 0;" id="weel__float-action-button" data-check-aim="false" data-api-src="google" data-lang-from="en" data-lang-to="zh"><weel id="weel__float-action-button--container"><weel id="weel__float-action-button--icon"></weel></weel></weel><weel style="visibility: hidden; opacity: 0;" id="weel__float-action-panel"><weel id="weel__float-action-panel--container"><weel id="weel__float-action-panel--output-stream"><weel id="weel__float-action-panel--output-stream-result"><weel id="weel__float-action-panel--output-stream-result-word"><weel id="weel__float-action-panel--output-stream-phonetic"><weel id="weel__float-action-panel--i-voice"></weel><weel id="weel__float-action-panel--output-stream-phonetic-plain">&nbsp;</weel></weel><weel id="weel__float-action-panel--output-stream-explain"><weel id="weel__float-action-panel--i-copy"></weel><weel id="weel__float-action-panel--output-stream-explain-plain">&nbsp;</weel><textarea></textarea><weel id="weel__float-action-panel--output-stream-explain-detail">&nbsp;</weel></weel></weel></weel></weel></weel></weel></body></html>