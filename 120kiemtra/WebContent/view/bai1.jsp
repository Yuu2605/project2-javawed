<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="bai1" method="post" enctype="multipart/form-data">
<input type="date" name="date"><br>
<input type="file" name="photo"><br>
<input type="checkbox" name="sothich" value=" Reading">Reading
<input type="checkbox" name="sothich" value=" Traveling">Traveling
<input type="checkbox" name="sothich" value=" Music">Music
<input type="checkbox" name="sothich" value=" Other">Other<br>
<hr width:10px>
<input type="submit">
</form>
</body>
</html>