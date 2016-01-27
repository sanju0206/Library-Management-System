<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<P align=left>
		<a href="index.jsp"><u>[BACK]</u></a>
	</P>

	<P>
	<center>

		<h2>Subscription Form</h2>
		<form action="SubscriptionForm1" method="get">
			UserID : <input type="text" name="userid" required="required"/> <br> <br>
			Name : <input type="text" name="username" required="required" /> <br> <br>
			Password : <input type="password" name="passwd" required="required"/> <br> <br>
			Confirm Password : <input type="password" name="confirmpasswd" required="required"/> <br>
			<br> Occupation : <input type="text" name="occupation" required="required"/> <br>
			<br> Email: <input type="text" name="emailid" required="required"/> <br> <br>
			Address : <input type="text" name="address" required="required"/> <br> <br> 
			<input type="submit" value="Register" />
			<input type="reset" value="Reset">
		</form>

	</center>
	</P>



</body>
</html>