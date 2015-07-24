<!DOCTYPE html>
<html>
<head>
	<title>Base Layout</title>
	<@layout.block name="head">
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

			.ax-sample-header{
				text-align: center;
				margin: 20px auto;
			}
			.ax-sample-header .ax-logo{
				background: url("https://www.axisj.com/ko/portal/images/ax-logo-axisj.png") center center;
				height: 150px;
			}
			.ax-sample-header H1 {
				font-size: 16px;
			}


			.container{
				width: 320px;
				margin: 100px auto;
			}

			.links{
				padding: 20px;
				font-size: 12px;
				text-align: center;
			}
		</style>
	</@layout.block>
</head>
<body>
	<div class="container">
		<div class="ax-sample-header">
			<div class="ax-logo"></div>
			<h1 class="ax info">AXISJ SAMPLE CODES</h1>
		</div>

		<@layout.block name="contents">
		</@layout.block>
	</div>
<@layout.block name="footer">
</@layout.block>
</body>
</html>