<%@page language="java" pageEncoding="utf-8"%>
<%@include file="../include/page_top.jsp"%>
<div class="row">
	<div class="error-container">
		<div class="well">
			<h1 class="grey lighter smaller">
				<span class="blue bigger-125"><i class="ace-icon fa fa-sitemap"></i>权限不足</span>无法访问此页面
			</h1>
			<hr>
			<h3 class="lighter smaller">抱歉，您无权访问此页面</h3>
			<div>
				<div class="space"></div>
				<h4 class="smaller">您可以尝试以下方法</h4>
				<ul class="list-unstyled spaced inline bigger-110 margin-15">
					<li>
						<i class="ace-icon fa fa-hand-o-right blue"></i>退出系统重新打开
					</li>
					<li>
						<i class="ace-icon fa fa-hand-o-right blue"></i>咨询管理员是否有此权限
					</li>
				</ul>
			</div>
			<hr>
			<div class="space"></div>
			<div class="center">
				<a href="javascript:history.back()" class="btn btn-grey">
					<i class="ace-icon fa fa-arrow-left"></i>返回
				</a>
				<a href="<%=request.getContextPath()%>/index.html" class="btn btn-primary">
					<i class="ace-icon fa fa-home"></i>主页
				</a>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/page_bottom.jsp"%>
