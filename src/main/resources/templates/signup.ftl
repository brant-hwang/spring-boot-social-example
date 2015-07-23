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
		html {
			margin: 0px;
			padding: 0px;
		}

		body {
			margin: 0px;
			padding: 0px;
		}

		.ax-sample-header {
			text-align: center;
			margin: 20px auto;
		}

		.ax-sample-header .ax-logo {
			background: url("https://www.axisj.com/ko/portal/images/ax-logo-axisj.png") center center;
			height: 150px;
		}

		.ax-sample-header H1 {
			font-size: 16px;
		}

		.container {
			width: 320px;
			margin: 100px auto;
		}

		.links {
			padding: 20px;
			font-size: 12px;
			text-align: center;
		}
	</style>

</head>

<body>
<div class="container">

	<div class="ax-sample-header">
		<div class="ax-logo"></div>
		<h1 class="ax info">AXISJ SAMPLE CODES</h1>
	</div>

<#if user??>
	<div class="ax-panel info">
		<div class="ax-panel-heading">
			Sign Up page
		</div>
		<div class="ax-panel-body">
			<form name="test" action="/signup" method="POST">
				<div style="padding:5px;">email</div>
				<input class="ax-inp" style="width:100%;" type="text" name="email" value="${user.email!""}" required/><br/>
				<div style="padding:5px;">firstName</div>
				<input class="ax-inp" style="width:100%;" type="text" name="firstName" value="${user.firstName!""}"/><br/>
				<div style="padding:5px;">lastName</div>
				<input class="ax-inp" style="width:100%;" type="text" name="lastName" value="${user.lastName!""}"/><br/>
				<div style="padding:5px;">password</div>
				<input class="ax-inp" style="width:100%;" type="password" name="password" value="" required/>

				<div style="height:10px"></div>

				<div style="text-align: center;">
					<input type="submit" value="submit" class="ax-btn lg good"/>
				</div>

			</form>
		</div>
	</div>
<#else>
	<div class="ax-panel warning">
		<div class="ax-panel-heading">
			Error
		</div>
		<div class="ax-panel-body">
			예상치 못한 에러가 발생되었습니다. 로그를 확인해주세요.
		</div>
	</div>
</#if>


</body>
</html>