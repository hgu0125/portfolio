/**
 * 
 */
// 자바의 클래스처럼 메서드를 가지는 객체(모듈)
var replyService = (function(){ // replyService라는 변수에 저장된 익명함수

	// 댓글 추가 함수
	function add(reply, callback, error){
		console.log("add reply..........");
		
		$.ajax({
			type : "post",
			url : "/replies/new",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	// 댓글 목록 함수
	function getList(param, callback, error){
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
				function(data){
					if(callback){
						callback(data.replyCnt, data.list);
					}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	// 댓글 삭제 함수
	function remove(rno, callback, error){
		$.ajax({
			type : "delete",
			url : "/replies/" + rno,
			success : function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	// 댓글 수정 함수
	function update(reply, callback, error){
		console.log("RNO: " + reply.rno);
		
		$.ajax({
			type : "put",
			url : "/replies/" + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	// 댓글 상세내용 함수
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	// 댓글 시간처리
	function displayTime(timeValue){
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		var str = "";
		
		if(gap < (1000 * 60 * 60 * 24)){
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			
			return [(hh > 9 ? "" : "0") + hh, ":", (mi > 9 ? "" : "0") + mi].join("");
		}else{
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return[(mm > 9 ? "" : "0") + mm, "/", (dd > 9 ? "" : "0") + dd].join("");
		}
	};
	
	return {
		add:add,
		get : get,
		getList : getList,
		remove : remove,
		update : update,
		displayTime : displayTime
	};

})();

