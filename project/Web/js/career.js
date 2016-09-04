	$(function(){
		var dialog,form,
		firmnm=$("#firmnm"),
		enterdt=$("#enterdt"),
		outerdt=$("#outerdt"),
		position=$("#position"),
		worknm=$("#worknm"),
		allFields=$([]).add(firmnm).add(enterdt).add(outerdt).add(position).add(worknm),
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
		
		
		function InsertCareer(){
			var valid=true;
			
			allFields.removeClass( "ui-state-errors" );
			if(valid){
				var d = $("#career").serialize();
				
				$.ajax({
					url:"StaffServlet?command=careerInsertAction",
					data:d,
					type:'post',
					dataType: 'json',
					success:function(data){
						$("#usersss tbody").append(
								"<tr class="+data.careernum+">"+
								"<td>"+data.careernum+"</td>"+
								"<td>"+data.firmnm+"</td>"+
								"<td>"+data.enterdt+"</td>"+
								"<td>"+data.outerdt+"</td>"+
								"<td>"+data.position+"</td>"+
								"<td>"+data.worknm+"</td>"+
								"<td width='50px'><button id='delete-user' onclick='deleteUser("+
										data.careernum
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
		dialog=$("#userss-career").dialog({
			autoOpen:false,
			height:300,
			width:500,
			modal:true,
			
			buttons:{
				"경력 추가": InsertCareer,
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
		$("#career").button().on("click",function(){
			event.preventDefault();
			//dialog.dialog("open");
		});
		$("#create-career").button().on("click",function(){
			dialog.dialog("open");
		})
		function deleteUser(careernum){
			url="StaffServlet?command=careerDeleteAction&careernum="+careernum;
			delno="."+careernum;
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

