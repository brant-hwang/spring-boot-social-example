<@layout.extends name="layouts/base.ftl">
	<@layout.put block="contents">
		<div class="ax-panel warning">
			<div class="ax-panel-heading">
				Error
			</div>
			<div class="ax-panel-body">
				<h2>${message}</h2>
			</div>
		</div>

		<div style="padding:10px;text-align: right;">
			<button class="ax-btn lg" onclick="location.href = '/';"><i class="axi axi-restore"></i> 돌아가기</button>
		</div>
	</@layout.put>
</@layout.extends>

