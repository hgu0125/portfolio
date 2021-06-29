/**
 * 
 */
$(document).ready(function(){
	var memberForm = $(".memberForm");
	$(".memberModify").on("click", function(e){
		e.preventDefault();
		memberForm.append("<input type='hidden' name='id' value='"+$(this).attr("href")+"'>");
		memberForm.attr("action","/member/get");
		memberForm.submit();
	})
})