<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 7/03/14
  Time: 06:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="formLogin" name="formLogin" action="<c:url value="/j_spring_security_check"/>" method="post">
    <table width="77%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="35%" class="texto_azul">Nombre:</td>
            <td width="65%"><input name="j_username" type="text" class="campo_azul" id="j_username"/></td>
        </tr>
        <tr>
            <td class="texto_azul">Contrase&ntilde;a:</td>
            <td><input name="j_password" type="password" class="campo_azul" id="j_password" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input name="btnAceptar" type="submit" class="ui-state-default ui-corner-all" id="btnAceptar" value="   Aceptar   " /></td>
        </tr>
    </table>
</form>
</body>
</html>
