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
.snb,#content{margin-top:10px;border:1px solid #bdbdbd;background:#fff;text-align:center}


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
#menu{
}
/* 테이블*/
#natable {
	margin: 0 auto;
}

table a:link {
	color: #666;
	font-weight: bold;
	text-decoration:none;
}
table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
table a:active,
table a:hover {
	color: #bd5a35;
	text-decoration:underline;
}
table {
	font-family:Arial, Helvetica, sans-serif;
	color:#666;
	font-size:12px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	margin:20px;
	border:#ccc 1px solid;

	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;

	-moz-box-shadow: 0 1px 2px #d1d1d1;
	-webkit-box-shadow: 0 1px 2px #d1d1d1;
	box-shadow: 0 1px 2px #d1d1d1;
}
table th {
	padding:15px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;

	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
	background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
}
table th:first-child{
	text-align: left;
	padding-left:20px;
}
table tr:first-child th:first-child{
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table tr:first-child th:last-child{
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table tr{
	text-align: center;
	padding-left:20px;
}
table tr td:first-child{
	text-align: left;
	padding-left:20px;
	border-left: 0;
}
table tr td {
	padding:12px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table tr.even td{
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table tr:last-child td{
	border-bottom:0;
}
table tr:last-child td:first-child{
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table tr:last-child td:last-child{
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
table tr:hover td{
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
}

/*등록 버튼*/
.button {
  display: inline-block;
  vertical-align: top;
  padding: 10px 25px;
  font-family: inherit;
  font-size: 15px;
  color: #111;
  text-align: center;
  text-decoration: none;
  text-shadow: 0 0 2px rgba(255, 255, 255, 1);
  background-color: #ccc;
  background-clip: padding-box;
  border: 1px solid;
  border-color: #202020 #1a1a1a #111;
  border-radius: 2px;
  background-image: -webkit-linear-gradient(top, #efefef, #777);
  background-image: -moz-linear-gradient(top, #efefef, #777);
  background-image: -o-linear-gradient(top, #efefef, #777);
  background-image: linear-gradient(to bottom, #efefef, #777);
  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0 1px 1px rgba(0, 0, 0, 0.3);
  box-shadow: inset 0 1px rgba(255, 255, 255, 0.09), 0px 1px 1px rgba(0, 0, 0, 0.2);
}
.button:hover {
  background-color: #aaaaaa;
  background-image: -webkit-linear-gradient(top, #ccc, #555);
  background-image: -moz-linear-gradient(top, #ccc, #555);
  background-image: -o-linear-gradient(top, #ccc, #555);
  background-image: linear-gradient(to bottom, #ccc, #555);
}
.button:active, .button.active {
  background-color: #b42f32;
  border-color: #1c1c1c #202020 #222;
  -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.09);
  box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.09);
}
.rounded {border-radius:100em!important;}

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
<h2 style="font-family: fantasy; letter-spacing:-1px; text-align:center;">프로젝트 이력 목록</h2>

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
	<div>
		<span>
			<label for="userid" >ID</label>
			<input type="text" name="userid" id="userid"/><br>
			<label for="userre">등록일</label>
			<input type="text" name="userre" id="userre"/>
			<label for="userre-">~</label>
			<input type="text" name="userre-" id="userre-"/>
		</span>
	</div>
	<div >
			<label for="userpro" >프로젝트명</label>
			<input type="text" name="userpro" id="userpro" />	
			<input type="submit" value="조회"/>
	</div>		
	

<a class="button rounded" href="http://localhost:8888/ch01/ch01/layout2.jsp">등록</a>	

<table id="natable" cellspacing='0'>
	<tr>
		<th>순번</th>
		<th>ID</th>
		<th>프로젝트명</th>
		<th>등록일</th>
	</tr>
    
	<tr>
		<td>1</td>
		<td>모인성</td>
		<td>김나율</td>
		<td>천생연분</td>
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




