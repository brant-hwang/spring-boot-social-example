<@layout.extends name="layouts/base.ftl">
	<@layout.put block="contents">
		<div class="ax-panel good">
			<div class="ax-panel-heading">
				Login
			</div>
			<div class="ax-panel-body">
				<form action="/login/authenticate" method="POST">
					<input type="text" name="username" value="" class="ax-inp lg" />
					<div style="height:5px"></div>
					<input type="password" name="password" value="" class="ax-inp lg" />
					<input type="submit" value="Login" class="ax-btn lg good" />
				</form>
			</div>
		</div>

		<br/>

		<h3>Sign in with</h3>

		<ul class="ax-item-group">
			<a class="ax-item" onclick="document.linkedin.submit();"><i class="axi axi-linkedin-square"></i> LinkedIn</a>
			<a class="ax-item" onclick="document.facebook.submit();"><i class="axi axi-facebook-square"></i> Facebook</a>
			<a class="ax-item" onclick="document.twitter.submit();"><i class="axi axi-twitter-square"></i> Twitter</a>
			<a class="ax-item" onclick="document.kakao.submit();"><i class="axi axi-ion-chatbubble"></i> Kakao</a>
			<a class="ax-item" onclick="document.github.submit();"><i class="axi axi-github-square"></i> Github</a>
		</ul>

		<div class="links">
			<a class="ax" href="https://www.axisj.com">https://www.axisj.com</a>, <a class="ax" href="https://github.com/axisj">https://github.com/axisj</a>
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
	</@layout.put>
</@layout.extends>

