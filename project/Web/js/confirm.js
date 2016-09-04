$("#confirm").on("submit",function(){
	var d=$(this).serialize();
	
	$.ajax({
		url:"staffUpdate.jsp",
		type:"post",
		data:d,
		success:function(data){
			alert("확인");
		}
	})
})