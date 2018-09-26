/*
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
    return decodeURI((r[2]));
    return null;
}*/
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
  //  return unescape(r[2]);//会中文乱码
        return decodeURI((r[2]));//解决了中文乱码
    return null;
}
