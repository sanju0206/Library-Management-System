<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add books</title>
</head>
<body>
	<center>
		<h2>Add Book</h2>
		<form action="AddBookServlet" method="get">
			BOOK_ID : <input type="text" name="BID" /> <br> <br>
			BOOK_NAME : <input type="text" name="BOOKNAME" /> <br> <br>
			AUTHOR: <input type="text" name="AUTHOR" /> <br> <br>
			PUBLISHER: <input type="text" name="PUBLISHER" /> <br> <br>
			Price: <input type="text" name="PRICE" /> <br> <br>
			Availability: <input type="text" name="BOOKSTATUS" /> <br> <br>
			NO_OF_BOOKS: <input type="text" name="count" /> <br> <br>
			<input type="submit" value="Add Book" /> <input type="reset"
				value="Reset">
		</form>
	</center>
</body>
</html>