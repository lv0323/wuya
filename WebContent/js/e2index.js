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

function Verify() {
    var user = document.getElementById("txtUser");
    var pwd = document.getElementById("txtPwd");
    if (user != null && user.value == "")
    {
        alert("请输入邮箱")
        return false;
    }

    if (pwd != null && pwd.value == "") {
        alert("请输入密码")
        return false;
    }

    if (HasBad(pwd.value)) //密码包含危险字符
    {
        return false;
    }

    var btn = document.getElementById("loginBtn");
    if (btn != null)
        btn.value = "登录中...";

    return true;
}

function TimeTick(second) {
    var tip = document.getElementById("TimeTip");
    if (tip == null)
        return;
    tip.innerHTML = second.toString() + "%";
    if (second >= 100) {
        second = 70;
        //u2go1();
        //return;
    }
    setTimeout("TimeTick(" + (second + 1) + ")", 150);
}
//TimeTick(1); //计数