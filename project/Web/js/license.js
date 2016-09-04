
	$(function(){
		var dialog,form,
		emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
		licensenm=$("#licensenm"),
		getdt=$("#getdt"),
		licenseoffice=$("#licenseoffice"),
		allFields=$([]).add(licensenm).add(getdt).add(licenseoffice),
		tips=$(".validateTips");
		function updateTips(t){
			tips
			.text(t)
			.addClass("ui-state-highlight");
			setTimeout(function(){
				tips.removeClass("ui-state-highlight",1500);
			},500);
		}
		function checkLength(o,n,min,max){
			if(o.val().length>max||o.val().length<min){
				o.addClass("ui-state-error");
				updateTips("Leng of" +n +"must be betwneeen"+
						min+"~"+max+".");
				return false;
			}else{
				return true;
			}
		}
		function checkRegexp(o,regexp,n){
			if(!(regexp.test(o.val()))){
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			}else{
				return true;
			}
		}
		
		
		function InsertLicense(){
			var valid=true;
			
			allFields.removeClass( "ui-state-error" );
			if(valid){
				var d = $("#sss").serialize();
				
				$.ajax({
					url:"StaffServlet?command=licenseInsertAction",
					data:d,
					type:'post',
					dataType: 'json',
					success:function(data){
						$("#users tbody").append(
								"<tr class="+data.licensenum+">"+
								"<td>"+data.licensenum+"</td>"+
								"<td>"+data.licensenm+"</td>"+
								"<td>"+data.getdt+"</td>"+
								"<td>"+data.licenseoffice+"</td>"+
								"<td width='50px'><button id='delete-user' onclick='deleteUser("+
										data.licensenum
										+");'>삭제</button></td>"+
											"</tr>");
						alert("성공");
					}
					,error:function(e){
						alert("잘못 되었습니다");
					}
				});
			}
			return valid;			
	}
		dialog=$("#users-contain").dialog({
			autoOpen:false,
			height:300,
			width:500,
			modal:true,
			
			buttons:{
				"자격 증 추가": InsertLicense,
				"취소 ":function(){
					dialog.dialog("close");
				}
			},
			close:function(){
			//	allFields.removeClass("ui-state-error");
			}
		});
		form=dialog.find("form").on("submit",function(event){
			event.preventDefault();
			InsertLicense();
		});
		$("#sss").button().on("click",function(){
			event.preventDefault();
			//dialog.dialog("open");
		});
		
		$("#create-user").button().on("click",function(){
			dialog.dialog("open");
		})
});


	function deleteUser(licensenum){
		alert("안옴");
		url="StaffServlet?command=licenseDeleteAction&licensenum="+licensenum;
		delno="."+licensenum;
		$.ajax({
			type:"post",
			url: url,
			success:function(msg){
				data = JSON.parse(msg);
				if(data.msg=="success"){
					$("tr").remove(delno);
					alert("정상 삭제 되었습니다.");		
				}else{
					alert("삭제에 실패하였습니다.")
				}
			}
		});
	};