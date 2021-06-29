<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"></h1>
		</div>
        	<!-- /.col-lg-12 -->
          	&emsp;<label><a href="#">최신순</a></label>
          	&emsp;<label><a href="#">추천순</a></label>
          	&emsp;<label><a href="#">댓글순</a></label>
          	&emsp;<label><a href="#">스크랩순</a></label>
          	&emsp;<label><a href="#">조회순</a></label><br><br>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 목록
					<c:if test="${loginMember.id != null}">
						<button id="regBtn" type="button" class="btn btn-xs pull-right">글쓰기</button>
					</c:if>
						</div>
                        <!-- /.panel-heading -->
							<div class="panel-body">
                            	<table class="table table-striped table-bordered table-hover">
									<thead>
                                    	<tr>
                                       		<th>번호</th>
                                        	<th>제목</th>
                                        	<th>작성자</th>
                                       		<th>작성일</th>
                                        	<th>수정일</th>
                                    	</tr>
                                	</thead>  
                           			<!-- forEach list size만큼 for문 돌림 -->
                           			<c:forEach items="${list}" var="qboard"> <!-- qboard:list[i] 저장할 변수 -->
		                           		<tr>
		                           		<td><c:out value="${qboard.bno}"/></td>
		                           		<td><a class="move" href="<c:out value='${qboard.bno}'/>">
		                           			<c:out value="${qboard.title}" /> [ <c:out value="${qboard.replyCnt}" /> ]</a>
		                           		</td>
		                           		<td><c:out value="${qboard.writer}"/></td>
		                           		<!-- MM:Month, mm:minute -->
		                           		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${qboard.regdate}" /></td>
		                           		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${qboard.updateDate}"/></td>
									</tr>
                           		</c:forEach>
                            </table>
                       	<div class="row">
                            <div class="col-lg-12"> 
                            	<form id="searchForm" action="/question/list" method="get">
                            		<select name="type">
                            			<option value="T"
                            				<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목
                            			</option>
                            			<option value="C"
                            				<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용
                            			</option>
                            			<option value="W"
                            				<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자
                            			</option>
                            			<option value="TC"
                            				<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용
                            			</option>
                            			<option value="TW"
                            				<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자
                            			</option>
                            			<option value="TWC"
                            				<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목 or 내용 or 작성자
                            			</option>
                            		</select>
                            		<input type="text" name="keyword" value="<c:out value='${pageMaker.cri.keyword}'/>">
                            		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                            		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                            		<button class="btn btn-default">검색</button>
                            	</form>
                            </div>
						</div>
                        <div class="pull-right">
							<ul class="pagination">
								<c:if test="${pageMaker.prev}">
									<li class="paginate_button previous">
                            			<a href="${pageMaker.startPage-1}">Previous</a>
                            		</li>
                            	</c:if>
                            	<!-- begin 부터 end 까지 반복 -->
	                            <c:forEach var="num" begin="${pageMaker.startPage}"
	                           		end="${pageMaker.endPage}">
	                            	<li class="paginate_button ${pageMaker.cri.pageNum == num? 'active':''}">
	                            		<a href="${num}">${num}</a>
	                            	</li>
	                            </c:forEach>
	                            <c:if test="${pageMaker.next}">
	                            	<li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>
	                            </c:if>
	                        </ul>
						</div>
                        <!-- end Pagination -->
                            
<!-- modal 추가 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
							<div class="modal-body">ㅇㅅㅇ</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save changes</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
            	<!-- end panel -->
			</div>
			<!-- panel panel-default -->
		</div>
    	<!-- /.row -->
            
        <!-- 페이징 번호 클릭했을때 실행되는 form -->
        <form id="actionForm" action="/question/list" method="get">
        	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
        	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
        	<input type="hidden" name="type" value="<c:out value='${pageMaker.cri.type}'/>">
        	<input type="hidden" name="keyword" value="<c:out value='${pageMaker.cri.keyword}'/>">
        </form>

<script type="text/javascript">

	$(document).ready(function(){
		
		var result = '<c:out value="${result}"/>';
		checkModal(result);
		history.replaceState({},null,null);
		function checkModal(result){
			if(result==='' || history.state){
				return;
			}
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 "+parseInt(result)+" 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		// 글쓰기 버튼 클릭
		$("#regBtn").on("click", function(){
			self.location = "/question/register";
		});
		
		// 페이징 이벤트 처리
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e){
			e.preventDefault(); // a태그의 default 이벤트 봉인!
			console.log("click");
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		// 조회 페이지로 이동 이벤트
		$(".move").on("click", function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action","/question/get");
		actionForm.submit();
		});
		
		// 검색
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1"); // 1페이지가 되도록 처리
			e.preventDefault();
			
			searchForm.submit();
		})
	});
	
</script>

<%@ include file="../includes/footer.jsp" %>