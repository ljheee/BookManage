<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑Book</title>
</head>
<body>
<h1>编辑Book </h1>
<!--注意路径，此处写edit  -->
<form action="edit" method="post">
	<div>
		<label>编号 </label>
		<input type="text" name="id" value="${b.id}" />
	</div>
	<div>
		<label>书名 </label>
		<input type="text" name="title" value="${b.title}" />
	</div>
	<div>
		<label>作者 </label>
		<input type="text" name="author" value="${b.author}"  />
	</div>
	<div>
		<label>价格 </label>
		<input type="text" name="price" placeholder="整型价格" value="${b.price}"  />
	</div>
	
	<input type="submit" value="更新" />
	
</form>
</body>
</html>