<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>
	<title>提示</title>
	<style type='text/css'>
	*{margin:0px;padding:0px;cursor:default;font-size:12px;font-family:Tahoma;}
	html, body, .page {width:100%;height:100%;}
	.page {position:relative;min-width:500px;min-height:270px;display:table;overflow:hidden;}
	.container {*position:absolute;width:100%;top:50%; left:0px;display:table-cell;vertical-align:middle;}
	.main {position:relative;top:-50%;margin:0px auto;width:500px;height:270px;}
	.infobox {position:relative;width:100%;height:100%;}
	.infobox-shadow {position:absolute;top:8px;left:8px;z-index:1;width:100%;height:100%;background:#000;filter:Alpha(opacity=20);opacity:0.2;}
	.infobox-texts {position:absolute;top:0;left:0;z-index:1;width:100%;height:100%;background:#FFF;border:1px red solid;}
	.it-title {width:97%;height:32px;line-height:32px;margin:0px auto;font-size:17px;color:#000;font-weight:bold;border-bottom:1px #444 solid;overflow:hidden;}
	.it-memo {width:97%;height:250px;overflow:auto;line-height:25px;margin:10px auto;color:#444;}
	.it-memo p {font-size:15px;}
	</style>
</head>
<body>
	<div class='page'>
		<div class='container'>
			<div class='main'>
				<div class='infobox'>
					<div class='infobox-shadow'></div>
					<div class='infobox-texts'>
						<div class='it-title'>请不要使用非法的URL地址访问</div>
						<div class='it-memo'>
							<p style='text-indent:12px;'>最可能的原因是：</p>
							<p style='text-indent:24px;'>• 您正在试图非法攻击。</p>
							<p style='text-indent:24px;'>• 您访问的URL地址是不被允许的。</p>
							<p style='text-indent:12px;margin-top:15px;'></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>