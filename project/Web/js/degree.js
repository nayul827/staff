	$(function(){
		var dialog,form,
		finaldegree=$("#finaldegree"),
		collegenm=$("#collegenm"),
		major=$("#major"),
		entrandt=$("#entrandt"),
		gradudt=$("#gradudt"),
		allFields=$([]).add(finaldegree).add(collegenm).add(major).add(entrandt).add(gradudt),
		tips=$(".validateTipss");
		function updateTips(t){
			tips
			.text(t)
			.addClass("ui-state-highlights");
			setTimeout(function(){
				tips.removeClass("ui-state-highlights",1500);
			},500);
		}
		function checkLength(o,n,min,max){
			if(o.val().length>max||o.val().length<min){
				o.addClass("ui-state-errors");
				updateTips("Leng of" +n +"must be betwneeen"+
						min+"~"+max+".");
				return false;
			}else{
				return true;
			}
		}
		function checkRegexp(o,regexp,n){
			if(!(regexp.test(o.val()))){
				o.addClass("ui-state-errors");
				updateTips(n);
				return false;
			}else{
				return true;
			}
		}
		
		
		function InsertDegree(){
			var valid=true;
			
			allFields.removeClass( "ui-state-errors" );
			if(valid){
				var d = $("#degree").serialize();
				
				$.ajax({
					url:"StaffServlet?command=degreeInsertAction",
					data:d,
					type:'post',
					dataType: 'json',
					success:function(data){
						$("#userss tbody").append(
								"<tr class="+data.degreenum+">"+
								"<td>"+data.degreenum+"</td>"+
								"<td>"+data.finaldegree+"</td>"+
								"<td>"+data.collegenm+"</td>"+
								"<td>"+data.major+"</td>"+
								"<td>"+data.entrandt+"</td>"+
								"<td>"+data.gradudt+"</td>"+
								"<td width='50px'><button id='delete-user' onclick='deleteUser("+
										data.degreenum
										+");'>삭제</button></td>"+
											"</tr>");
						alert("등록완료");
					}
					,error:function(e){
						alert("잘못 되었습니다");
					}
				});
			}
			return valid;			
	}
		dialog=$("#userss-degree").dialog({
			autoOpen:false,
			height:300,
			width:500,
			modal:true,
			
			buttons:{
				"경력 추가": InsertDegree,
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
			InsertDegree();
		});
		$("#degree").button().on("click",function(){
			event.preventDefault();
			//dialog.dialog("open");
		});
		$("#create-degree").button().on("click",function(){
			dialog.dialog("open");
		})
		function deleteUsers(degreenum){
			url="StaffServlet?command=degreeDeleteAction&degreenum="+degreenum;
			delno="."+degreenum;
			$.ajax({
				type:"post",
				url: url,
				success:function(msg){
				$("tbody").remove(delno);
					alert("정상 삭제 되었습니다.");
				}
			});
		};
});

