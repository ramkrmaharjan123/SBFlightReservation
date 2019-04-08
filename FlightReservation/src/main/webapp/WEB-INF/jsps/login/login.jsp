<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Login</title>
</head>
<body>
<h2>Please Login</h2>
<b>${msg}</b>
<form action="login" method="post">
<pre>
User Name:<input type="text" name="email"/>
Password:<input type="password" name="password"/>

<input type="submit" value ="Login"/>
</pre>
</form>
<div><p>${loginFailMSG}</p></div>

</body>
</html>