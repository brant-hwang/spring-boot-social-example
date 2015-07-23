<!DOCTYPE html>
<html>
<head>
	<title>Login page</title>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>

<body>
<div class="container">

	<h2>Login page</h2>

	<p>Sign in with: </p>

	<table style="border-collapse: separate; border-spacing: 2px">
		<tr>
			<td><a href="javascript:document.linkedin.submit()" class="ml btn btn-block btn-social btn-sm btn-linkedin"><i
					class="fa fa-linkedin"></i>LinkedIn</a></td>
			<td><a href="javascript:document.facebook.submit()" class="ml btn btn-block btn-social btn-sm btn-facebook"><i
					class="fa fa-facebook"></i>Facebook</a></td>
		</tr>
		<tr>
			<td><a href="javascript:document.twitter.submit()" class="ml btn btn-block btn-social btn-sm btn-twitter"><i
					class="fa fa-twitter"></i>Twitter</a></td>
			<td><a href="javascript:document.kakao.submit()" class="ml btn btn-block btn-social btn-sm btn-github"><i
					class="fa fa-github"></i>Kakao</a></td>
		</tr>
		<tr>
			<td><a href="javascript:document.github.submit()" class="ml btn btn-block btn-social btn-sm btn-github"><i
					class="fa fa-github"></i>Github</a></td>
		</tr>
	</table>
</div>
<!-- /.container -->
<form action="/auth/facebook" name="facebook">
	<input type="hidden" name="scope" value="email,user_friends"/>
</form>
<form action="/auth/linkedin" name="linkedin">
</form>
<form action="/auth/twitter" name="twitter">
	<input type="hidden" name="scope" value="email"/>
</form>
<form action="/auth/kakao" name="kakao">
</form>
<form action="/auth/github" name="github">
	<input type="hidden" name="scope" value="email"/>
</form>
<br/><br/>

<form action="/login/authenticate" method="POST">
	<input type="text" name="username" value=""/><br/>
	<input type="password" name="password" value=""/>
	<input type="submit" value="login"/>
</form>
</body>
</html>