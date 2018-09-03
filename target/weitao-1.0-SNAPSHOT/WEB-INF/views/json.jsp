<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/1
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
    function requestJson() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/baby',
            contentType:'application/json;charset=utf-8',
            data:'{"uId":1}',
        success:function (data) {
            alert(data);
        }
        });
    }
    function reponseJson() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/json',
            contentType:'application/x-www-form-urlencoded;charset=utf-8',
            data:'uId=1&uAddress=马士兵',
            success:function (data) {
                alert(data);
            }
        });
    }
</script>
</head>
<body>
当前用户:${username},
<c:if>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
</c:if>
<input type="button" onclick="requestJson()" value="json-json">
<input type="button" onclick="reponseJson()" value="key-json">
</body>
</html>
