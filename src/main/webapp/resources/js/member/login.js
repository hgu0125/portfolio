/**
 * 
 */
$(document).ready(function(){
	$("#submit").on("click", function(){
		var id = $("#id").val();
		var pw = $("#pw").val();
		var fail = $(".loginfail");
		
		if(id == "" || pw == ""){
			fail.css({"border":"2px solid #CC3D3D",
				"fontSize":"13px","padding":"35px",
				"margin-top":"10px"});
			fail.text("입력한 아이디 또는 비밀번호가 올바르지 않습니다");
			return false;
		}
	})
	
})

