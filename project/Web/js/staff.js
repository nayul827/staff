$(function() {
	$("#tabs").tabs({
		event:"mouseover"
	});

	$("#intd","$outdt").datepicker();

	$("#indt").datepicker("option", "maxDate", $("#outdt").val());
	$("#indt").datepicker("option", "onClose", function ( selectedDate ) {
	    $("#outdt").datepicker( "option", "minDate", selectedDate );
	});

	$("#outdt").datepicker("option", "minDate", $("#indt").val());
	$("#outdt").datepicker("option", "onClose", function ( selectedDate ) {
	    $("#indt").datepicker( "option", "maxDate", selectedDate );
	});
	
	
	var dialog, form, 
	emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
	,memnm = $("#memnm"), 
	mememail = $("#mememail"), 
	mempwd = $("#mempwd"), 
	allFields = $([]).add(memnm).add(mememail).add(mempwd), tips = $(".validateTips");
	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}
	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips("Length of " + n + " must be between " + min
					+ " and " + max + ".");
			return false;
		} else {
			return true;
		}
	}
	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	function addUser() {
		var valid = true;
		allFields.removeClass("ui-state-error");
		valid = valid && checkLength(memnm, "username", 3, 16);
		valid = valid && checkLength(mememail, "email", 6, 80);
		valid = valid && checkLength(mempwd, "password", 5, 16);
		valid = valid
				&& checkRegexp(
						memnm,
						/^[a-z가-힣]([가-힣0-9a-z_\s])+$/i,
						"Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");

		valid = valid
				&& checkRegexp(mememail, emailRegex, "eg. ui@jquery.com");
		valid = valid
				&& checkRegexp(mempwd, /^([0-9a-zA-Z])+$/,
						"Password field only allow : a-z 0-9");
		
		if(valid){
			var d = $("#sss").serialize();
			
			$.ajax({
				url:"MemberServlet?command=MemberInsertAction",
				data: d,
				type:'post',
				success:function(json){
					data=JSON.parse(json);
					$("#users tbody").prepend(
							"<tr class="+data.no+">"+
							"<td>"+data.no+"</td>"+
							"<td>"+data.memnm+"</td>"+
							"<td>"+data.mememail+"</td>"+
							"<td>"+data.mempwd+"</td>"+
							"<td width='50px'><button id='delete-user' onclick='deleteUser("+
									data.no
									+");'>삭제</button></td>"+
									"</tr>");
				}
			});
		dialog.dialog("close");
		}
		return valid;
	}		
	/*	if (valid) {
			$("#sss").submit();
			dialog.dialog("close");
		}
	*/
	
	/*	
		if(valid){
			$.ajax({
				url:"MemberServlet?command=MemberInsertAction",
						data:"memnm="+memnm.val()+'&mememail='+mememail.val()+'&mempwd='+mempwd.val(),
						type:'post',
						success:function(result){
							window.location.reload(true);
						}
			});
			dialog.dialog("close");
		}*/
		

	dialog = $("#dialog-form").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			"Create an account" : addUser,
			Cancel : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit",function(event){
		event.preventDefault();
		addUser();
	});
	$("#create-user").button().on("click", function() {
		dialog.dialog("open");
	});

function deleteUser(no){
	url="MemberServlet?command=delete&no="+no;
	delmno="."+no;
	$.ajax({
		type:"get",
		url:url,
		success:function(msg){
		$("tr").remove(delmno);
			alert("정삭 삭제 되었습니다.");
		}
	});
};
});


