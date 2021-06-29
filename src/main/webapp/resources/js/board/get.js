/**
 * 
 */
$(document).ready(function() {

	var operForm = $("#operForm");
	
	// 글 추천 버튼
	$("#recBtn").on("click", function(){
		var rec = confirm("해당 글을 추천하시겠습니까?");
		
		if(rec){
			operForm.attr("action","/board/recommend");
			operForm.submit();
			
			alert("해당 글을 추천하였습니다.");
		}
	})
})