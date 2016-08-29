<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>Insert title here</title>
<style type="text/css">

<style>
/* UI Object */
#wrap{width:100%}
#header{width:100%}
#container{_display:inline-block;width:100%}
#container:after{display:block;clear:both;content:''}
.snb{float:left;width:180px;margin-right:-200px; text-align: center; height: 200px;}
#content{margin-left:200px; height: 100%;}
#footer{width:100%}

/* Layout Color - 실제 서비스 적용 후 아래 코드는 삭제 하세요 */
div{margin:0 0 10px;padding:10px 0;color:#2d2c2d;font-family:Tahoma;font-size:14px;font-weight:bold}
#wrap{width:auto;margin:0;padding:10px;border:1px solid #bdbdbd;background:#f7f7f7}
#header{margin-top:10px}
#header,#container{width:auto;padding:10px;border:2px solid #bfbfbf;background:#e5e5e5}
.snb,#content{margin-top:10px;border:1px solid #bdbdbd;background:#fff;text-align:left;}


/* sub*/
#menu {width:200px; height:400px; background:url(/data/201011/IJ12908740279361/back.gif); margin:0 auto; position:relative;}

#menu ul {margin:0; padding:0; list-style:none; white-space:nowrap; text-align:left; background:url(/data/201011/IJ12908740279361/opaque.png); padding:1px 1px 0 1px;}

#menu li {margin:0; padding:0; list-style:none;}
#menu li {display:inline-block; display:inline;}
#menu ul {position:absolute; left:-9999px;}
#menu ul.level1 {position:absolute; left:0; top:60px;}

#menu a {display:block; font:normal 11px verdana,arial,sans-serif; color:#000; line-height:22px; text-decoration:none;padding:0 20px 0 10px; border-bottom:1px solid #ddd;} 

#menu ul li:hover > ul {visibility:visible; left:100%; margin-top:-24px; margin-left:-1px;}

#menu a:hover ul,
#menu a:hover a:hover ul, 
#menu a:hover a:hover a:hover ul {left:100%; visibility:visible;}
#menu a:hover ul ul, 
#menu a:hover a:hover ul ul {left:-9999px;}

#menu li a:hover {background:#868ea1;} 
#menu li:hover > a {background:#868ea1;}
#menu li a.fly {background: url(/data/201011/IJ12908740279361/arrow.gif) no-repeat right top;}
#menu li a.fly:hover {background:#868ea1 url(/data/201011/IJ12908740279361/arrow.gif) no-repeat right top;} 
#menu li:hover > a.fly {background:#868ea1 url(/data/201011/IJ12908740279361/arrow.gif) no-repeat right top;}
#menu table {position:absolute; left:99%; height:0; width:0; border-collapse:collapse; margin-top:-7px; margin-left:-1px;}


/*하단*/
#footer{width:auto;padding:10px;border:2px solid #bfbfbf;background:#e5e5e5}
/* //UI Object */
</style>

</head>

<body>


<!--ui object -->
<div id="wrap">
<p></p>


<!--header -->
<div id="header">
<h1 style="font-family:돋움;letter-spacing:-1px; text-align:center">사원 정보 관리 시스템</h1>
</div>
<!--//header -->


<!--container -->
<div id="container">
<h2 style="font-family: fantasy; letter-spacing:-1px; text-align:center;">프로젝트 이력 등록</h2>

<!--snb -->
<div class="snb">
<div id="menu">
	<ul class="level1">
	
		<li><a class="fly" href="#url">개인 프로젝트 이력관리<!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
			<ul>
				<li><a href="#url">프로젝트 이력 목록</a></li>
				<li><a href="#url">프로젝트 이력 등록</a></li>
			</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		<li><a class="fly" href="#url">개인 정보 관리<!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
			<ul>
				<li><a href="#url">사원 정보 목록</a></li>
				<li><a href="#url">사원 정보 수정</a></li>
			</ul>
		<li><a href="#url">공지사항</a></li>
	</ul>
</div>

</div>
<!--//snb -->


<!--content -->
<div id="content">
<form method="post" name="log_f">
	<style>
		table,tr,th{border:1px solid white}
	</style>
	

	<table width="800" cellpadding="0" cellspacing="0" border="0" align="center">
			<tr valign="top">
				<th width = 100 >사번</th>
				<th width = 400  align = "left">110</th>
			</tr>	
			<tr valign="top">
				<th width = 100 bgcolor = "#6A5ACD"><label for="userid" >이름</label></th>
				<th width = 400 bgcolor = "skyblue" align = "left"><input type="text" name="username" id="username"/></th>
			</tr>
			
			<tr>
				<th width = 100 bgcolor = "skyblue"><label for="userre">등록일</label></th>
				<th width = 400 bgcolor = "#6A5ACD" align = "left"><input type="text" name="userre" id="userre"/></th>
			</tr>
			<tr>
				<th width = 100 bgcolor = "skyblue"><label for="userpro">프로젝트명</label></th>
				<th width = 400 bgcolor = "#6A5ACD" align = "left"><input type="text" name="userre" id="userre"/></th>
			</tr>		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA"><label for="userdate">기간</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<input type="text" name="useryear" id="useryear" size="10"/>년
					<input type="text" name="usermonth" id="usermonth" size="5"/>월
					<input type="text" name="userday" id="userday" size="5"/>일          ~
				</th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<input type="text" name="useryear" id="useryear" size="10"/>년
					<input type="text" name="usermonth" id="usermonth" size="5"/>월
					<input type="text" name="userday" id="userday" size="5"/>일 
				</th>
			</tr>
			<tr>
				<th width = 100 bgcolor = "#EAEAEA" align = "up"><label for="userskill">사용스킬</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<textarea rows="5" cols="30" name="contents"></textarea>
				</th>
			</tr>
				<tr>
				<th width = 100 bgcolor = "#EAEAEA" align = "up"><label for="usercontent">상세내용</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<textarea rows="5" cols="30" name="contents"></textarea>
				</th>
			</tr>
			<tr>
				<th width = 100 bgcolor = "skyblue"><label for="userwork">수행역할</label></th>
				<th width = 400 bgcolor = "#6A5ACD" align = "left"><input type="text" name="userre" id="userre"/></th>
			</tr>			
	</table>			
</form>	
</div>
<!--//content -->
</div>


<!--//container -->
<!--footer -->
<div id="footer">
<p></p>
</div>
<!--//footer -->
</div>
<!--//ui object -->
</body>
</html>

