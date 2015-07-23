<!DOCTYPE html>
<html>
<head>
	<title>Login page</title>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<link rel="stylesheet" type="text/css" href="http://ax5.io/src/css/jellyfish/ax5.css" id="ax5-theme">
	<link rel="stylesheet" type="text/css" href="http://cdn.axisj.com/axicon/axicon.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="http://ax5.io/pub/ax5.min.js"></script>
	<script type="text/javascript" src="http://ax5.io/pub/ui/all.min.js"></script>

	<style>
		html{
			margin: 0px; padding: 0px;
		}
		body{
			margin: 0px; padding: 0px;
		}

		.container{
			max-width: 480px;
			min-width: 320px;
			margin: 100px auto;
		}
		
		.links{
			padding: 20px;
			font-size: 12px;
			text-align: center;
		}
	</style>

</head>

<body>
	<div class="container">

		<div class="ax-panel good">
			<div class="ax-panel-heading">
				Login
			</div>
			<div class="ax-panel-body">
				<form action="/login/authenticate" method="POST">
					<input type="text" name="username" value="" class="ax-inp lg" />
					<div style="height:5px"></div>
					<input type="password" name="password" value="" class="ax-inp lg" />
					<input type="submit" value="login" class="ax-btn lg good" />
				</form>
			</div>
		</div>

		<br/>

		<div class="ax-panel">
			<div class="ax-panel-heading">
				Sign in with
			</div>
			<div class="ax-panel-body">

				<button class="ax-btn basic" onclick="document.linkedin.submit();">LinkedIn</button>
				<button class="ax-btn basic" onclick="document.facebook.submit();">Facebook</button>
				<button class="ax-btn basic" onclick="document.twitter.submit();">Twitter</button>
				<div style="height:5px"></div>
				<button class="ax-btn basic" onclick="document.kakao.submit();">Kakao</button>
				<button class="ax-btn basic" onclick="document.github.submit();">Github</button>

			</div>
		</div>


		<div class="links">
			<a class="ax" href="https://www.axisj.com">https://www.axisj.com</a>, <a class="ax" href="https://github.com/axisj">https://github.com/axisj</a>
		</div>


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

</body>
</html>