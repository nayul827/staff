<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript">
       function previewImage(targetObj, previewId) {

        var preview = document.getElementById(previewId); //div id   
        var ua = window.navigator.userAgent;

        if (ua.indexOf("MSIE") > -1) {//ie일때

            targetObj.select();

            try {
                var src = document.selection.createRange().text; // get file full path 
                var ie_preview_error = document
                        .getElementById("ie_preview_error_" + previewId);

                if (ie_preview_error) {
                    preview.removeChild(ie_preview_error); //error가 있으면 delete
                }

                var img = document.getElementById(previewId); //이미지가 뿌려질 곳 

                img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
                        + src + "', sizingMethod='scale')"; 
            } catch (e) {
                if (!document.getElementById("ie_preview_error_" + previewId)) {
                    var info = document.createElement("<p>");
                    info.id = "ie_preview_error_" + previewId;
                    info.innerHTML = "a";
                    preview.insertBefore(info, null);
                }
            }
        } else { //ie가 아닐때
            var files = targetObj.files;
            for ( var i = 0; i < files.length; i++) {

                var file = files[i];

                var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
                if (!file.type.match(imageType))
                    continue;

                var prevImg = document.getElementById("prev_" + previewId); //이전에 미리보기가 있다면 삭제
                if (prevImg) {
                    preview.removeChild(prevImg);
                }

                var img = document.createElement("img");
                img.id = "prev_" + previewId;
                img.classList.add("obj");
                img.file = file;
                img.style.width = '50px'; //기본설정된 div의 안에 뿌려지는 효과를 주기 위해서 div크기와 같은 크기를 지정해준다.
                img.style.height = '50px';
                
                preview.appendChild(img);

                if (window.FileReader) { // FireFox, Chrome, Opera 확인.
                    var reader = new FileReader();
                    reader.onloadend = (function(aImg) {
                        return function(e) {
                            aImg.src = e.target.result;
                        };
                    })(img);
                    reader.readAsDataURL(file);
                } else { // safari is not supported FileReader
                    //alert('not supported FileReader');
                    if (!document.getElementById("sfr_preview_error_"
                            + previewId)) {
                        var info = document.createElement("p");
                        info.id = "sfr_preview_error_" + previewId;
                        info.innerHTML = "not supported FileReader";
                        preview.insertBefore(info, null);
                    }
                }
            }
        }
    }
</script>



<style type="text/css">
<style>
/* UI Object */
#wrap{width:100%}
#header{width:100%;background:#FFBB00;border-radius: 5px;border:3px solid #C98500; align: center}
#container{_display:inline-block;width:100%;background:#FAECC5}
#container:after{display:block;clear:both;content:''}
.snb{float:left;width:180px;margin-right:-200px; text-align: center; height: 200px;background:#E5D85C;border:2px solid black}
#content{margin-left:200px; height: 100%; width: 100%}
#footer{width:100%}



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

.middle{
	margin: auto;
	text-align: center;
}
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
<h2 style="font-family: fantasy; letter-spacing:-1px; text-align:center;"><font face="나눔바른고딕">프로젝트 이력 등록</font></h2>

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
<form name="pic" action="picUpdate.jsp" method="post">
<input type="file" onchange="previewImage(this,'previewId')">
<div id='previewId'  style='width: 50px; height: 50px; color: black; font-size: 9pt; border: 2px solid black; position: absolute; left: 300px; top: 200px;'>>
</form>
</div>
	<style>
		table,tr,th{border:1px solid white}
	</style>
	<table width="800" cellpadding="0" cellspacing="0" border="0" align="center">
			<tr valign="top">
				<th width = 100 bgcolor = "#BDBDBD">사번</th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left">110</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA"><label for="my_id" >이름</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left"><input type="text" name="user_name" id="my_name"/></th>
			</tr>
			
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">등록일</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left"><input type="text" name="user_re" id="my_re"/></th>
			</tr>
			
			<tr>
				<th width = 100 bgcolor = "#EAEAEA">성별</th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<input type="radio" name="chk_info" value="male">남
					<input type="radio" name="chk_info" value="female">여
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">생년월일</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left">
					<input type="text" name="user_year" id="my_year" size="10"/>년
					<input type="text" name="user_month" id="my_month" size="5"/>월
					<input type="text" name="user_day" id="my_day" size="5"/>일
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA">부서</th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<select name="post">
						<option value="개발부">개발부</option>
						<option value="인사부">인사부</option>
						<option value="기타">등등</option>
					</select>
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD">직급</th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left">
					<select name="level">
						<option value="사장">사장</option>
						<option value="부장">부장</option>
						<option value="사원">사원</option>
					</select>
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA"><label for="my_re">입사일</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<input type="text" name="user_year" id="my_year" size="10"/>년
					<input type="text" name="user_month" id="my_month" size="5"/>월
					<input type="text" name="user_day" id="my_day" size="5"/>일
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">퇴사일</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left">
					<input type="text" name="user_year" id="my_year" size="10"/>년
					<input type="text" name="user_month" id="my_month" size="5"/>월
					<input type="text" name="user_day" id="my_day" size="5"/>일
				</th>
			</tr>
			
			<tr>
				<th width = 100 bgcolor = "#EAEAEA"><label for="my_re">우편번호</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<input type="text" name="user_year" id="my_year" size="10"/>-
					<input type="text" name="user_month" id="my_month" size="10"/> 
					<input type="submit" value="검색">
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">주소</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left"><input type="text" name="user_address" id="my_address"/></th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA"><label for="my_re">상세주소</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left"><input type="text" name="user_address" id="my_address"/></th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">급여</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left"><input type="text" name="user_pay" id="my_pay"/></th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#EAEAEA" align = "up"><label for="my_re">비고</label></th>
				<th width = 400 bgcolor = "#BDBDBD" align = "left">
					<textarea rows="5" cols="30" name="contents"></textarea>
				</th>
			</tr>
		
			<tr>
				<th width = 100 bgcolor = "#BDBDBD"><label for="my_re">등록일</label></th>
				<th width = 400 bgcolor = "#EAEAEA" align = "left">
					<input type="text" name="user_year" id="my_year" size="10"/>년
					<input type="text" name="user_month" id="my_month" size="5"/>월
					<input type="text" name="user_day" id="my_day" size="5"/>일
				</th>
			</tr>
	</table>
	<div class="middle">
		<input type="submit" value="수정"  >
		<input type="reset" value="취소">
	</div>
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