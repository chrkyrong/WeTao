/**
 * Created by hzb on 2018/10/01.
 */
//rTrim()去掉字串左边的空格
function lTrim(str) {
    if (str.charAt(0) == " ") {
        str = str.slice(1);
        str = lTrim(str);    //递归调用
    }
    return str;
}
//rTrim()去掉字串右边的空格
function rTrim(str) {
    var iLength;
    iLength = str.length;
    if (str.charAt(iLength - 1) == " ") {
        str = str.slice(0, iLength - 1);
        str = rTrim(str);    //递归调用
    }
    return str;
}
//trim()去掉字串两边的空格
function trim(str) {
    return lTrim(rTrim(str));
}
//验证名字
function checkName() {
    var name = trim($("#sAccount").val());
    if (name.length==0 || name==null){
        $("#nameCheck").html("<p style='color:red;font-size: 100%'><strong>×</strong></p>");
        $("#sAccount").focus();
        return false;
    } else {
        $("#nameCheck").html("<p style='color:green;font-size: 70%'><strong>√</strong></p>");
        return true;
    }
}
//验证密码
function checkPass() {
    var regs = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/
    var password = $("#sPassword").val();
    if (password.length<6 || password.length>10||!regs.test(password)){
        $("#passCheck").html("<p style='color:red;font-size: 100%'><strong>×</strong></p>");
        $("#sPassword").focus();
        return false;
    } else {
        $("#passCheck").html("<p style='color:green;font-size: 70%'><strong>√</strong></p>");
        return true;
    }
}
//验证确认密码
function checkRpt() {
    var password = $("#sPassword").val();
    var rpt = $("#sPassword_rpt").val();
    if (password != rpt) {
        $("#rptCheck").html("<p style='color:red;font-size: 100%'><strong>×</strong></p>");
        $("#sPassword_rpt").focus();
        return false;
    } else {
        $("#rptCheck").html("<p style='color:green;font-size: 70%'><strong>√</strong></p>");
        return true;
    }
}
//验证手机号码
function checkTel() {
    var regs = /^((1[358][0-9])|(14[57])|(17[0678])|(19[7]))\d{8}$/;
    var tel = $("#sTel").val();
    if (!regs.test(tel)) {
        $("#telCheck").html("<p style='color:red;font-size: 100%'><strong>×</strong></p>");
        $("#sTel").focus();
        return false;
    } else {
        $("#telCheck").html("<p style='color:green;font-size: 70%'><strong>√</strong></p>");
        return true;
    }
}
//验证地址
function checkAddress() {
    var province = $("#ddlProvince").find("option:selected").text();
    var city = $("#ddlCity").find("option:selected").text();
    var district = $("#ddlDistrict").find("option:selected").text();
    var address = trim($("#sAddress").val());
    if (province=="请选择省份" || city=="请选择城市" || district=="请选择地区" || address.length==0 || address==null) {
        $("#addressCheck").html("<p style='color:red;font-size: 100%'><strong>×</strong></p>");
        $("#sAddress").focus();
        return false;
    } else {
        $("#addressCheck").html("<p style='color:green;font-size: 70%'><strong>√</strong></p>");
        return true;
    }
}
function checkInfo() {
    checkName();
    checkPass();
    checkRpt();
    checkTel();
    checkAddress();
}
