/**
 * 
 */
$(document).ready(function(){
	var result = "<c:out value='${result}'/>";
	
	/*
	var category = $(".asideCategory a");
	category.on("click", function(){
		category.not($(this)).removeClass("choiceCategory");
		$(this).addClass("choiceCategory");
	})
	*/
	
	// 글쓰기 버튼 클릭
	$("#regBtn").on("click", function(){
		self.location="/question/register";
	});
	
	// 페이징 이벤트 처리
	var actionForm = $("#actionForm");
	$(".paginateBtn a").on("click", function(e){
		e.preventDefault();
		console.log("click");
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	})
	
	// 조회 페이지로 이동 이벤트
	$(".pagingMove").on("click", function(e){
		e.preventDefault();
		// 조회 페이지로 가면 actionForm에서 bno값을 같이 들고간다
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		// 조회 페이지로 가기 위한 링크
		actionForm.attr("action","/question/get");
		actionForm.submit();
	})
	
	// 검색
	var searchForm = $("#searchForm");
	var search = $("#search");
	
	$("#searchForm img").on("click", function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색 종류를 선택하세요");
			return false;
		}
		
		if(!search.val()){
			alert("키워드를 입력하세요");
			return false;
		}
		searchForm.submit();
	})
		
})

