//var width = document.body.clientWidth;
//var width = screen.width;
//var url = location.href.toLowerCase();

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

var u2nojump = false;
var nojumpCK = getCookie("u2nojump");
if (nojumpCK == "1")
    u2nojump = true;

if (!u2nojump && (/android|iphone|ipad|ipod/i.test(navigator.userAgent)))
//if (width < 700)  //m2pc jump to m2    
{

    var url = document.URL.replace("/m2pc/", "/m2/");
    location.href = url;
}