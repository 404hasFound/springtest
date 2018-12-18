<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>500错误页面</title>
		<meta name="description" content="500错误页面" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.min.css" id="main-ace-style" />
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-rtl.min.css" />
	</head>
	<body class="no-skin">
		<div class="error-container">
			<div class="well">
				<h1 class="grey lighter smaller">
					<span class="blue bigger-125"><i class="ace-icon fa fa-sitemap"></i>500</span>服务器出错了
				</h1>
				<hr>
				<h3 class="lighter smaller">我们正在努力
					<i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>中...
				</h3>
				<div>
					<div class="space"></div>
					<h4 class="smaller">可能发生的原因</h4>
					<ul class="list-unstyled spaced inline bigger-110 margin-15">
						<li>
							<i class="ace-icon fa fa-hand-o-right blue"></i>网络异常
						</li>
						<li>
							<i class="ace-icon fa fa-hand-o-right blue"></i>系统异常:${exception }
						</li>
						<li>
							<i class="ace-icon fa fa-hand-o-right blue"></i>系统升级失败
						</li>
					</ul>
				</div>
				<hr>
				<div class="space"></div>
				<div class="center">
					<a href="javascript:history.back()" class="btn btn-grey">
						<i class="ace-icon fa fa-arrow-left"></i>返回
					</a>
					<a href="<%=request.getContextPath()%>/home" class="btn btn-primary">
						<i class="ace-icon fa fa-home"></i>主页
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
