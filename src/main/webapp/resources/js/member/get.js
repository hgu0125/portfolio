/**
 * 
 */
$(document).ready(function(){
	var memberForm = $(".memberForm");
	
	$("#removeBtn").on("click", function(){
		var rec = confirm("정말 탈퇴하시겠습니까?");
		
		if(rec){
			alert("정상적으로 탈퇴되었습니다.");
			memberForm.attr("action","/member/remove");
			memberForm.submit();
		}else if(!rec){
			return false;
		}
	})
	
})

