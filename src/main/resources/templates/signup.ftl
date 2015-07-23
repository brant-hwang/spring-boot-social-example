<!DOCTYPE html>
<html>
<head>
	<title>Login page</title>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>
<div class="container">
	<h2>Sign Up page</h2>

	<#if user??>
		<form name="test" action="/signup" method="POST">
			email : <input type="text" name="email" value="${user.email!""}" required/><br/>
			firstname : <input type="text" name="firstName" value="${user.firstName!""}"/><br/>
			lastName : <input type="text" name="lastName" value="${user.lastName!""}"/><br/>
			password : <input type="password" name="password" value="" required/><br/>
			<input type="submit" value="submit"/>
		</form>
	<#else>
		에러 발생 ㅠ.ㅠ
	</#if>


</body>
</html>