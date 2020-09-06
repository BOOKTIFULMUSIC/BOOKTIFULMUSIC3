<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.jsp.book.model.vo.*" import="com.web.jsp.book.model.vo.*" import="java.util.HashMap" %>
    <% HashMap<String,Object> b = (HashMap<String,Object>)request.getAttribute("b"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>BOOK INFORMATION</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/book_detail.css">
</head>
<body>
   <%@ include file="../common/header.jsp"%>

   <div id="content">        
            <div id="info1">
                <p id="p1">BOOK INFORMATION</p>
                <img src="${pageContext.request.contextPath}/resources/images/book/<%= b.get("BIMAGE") %>" id="info_img1" alt="">
                <ul id="b_title">
                    <li><%= b.get("BTITLE") %></li>
                    <li><%= b.get("AUTHORNAME") %></li>
                    <li>&nbsp;&nbsp;|&nbsp;&nbsp;<%= b.get("PUBLISHER") %></li>
                    <li><a>#<%= b.get("BGENRE") %></a></li>
                    <li><b id="heart">♥</b> <%= b.get("BLIKECOUNT") %> </li>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<b id="re">review</b><span></span></li>
                    <li><%= b.get("PRICE") %>원</li>
                </ul>
                <dl id="b_btn">
                    <button type="button" id="likebtn" name="likebtn">♥</button>
                    <a href="../view/BuyPage.html"><input type="button" id="buybtn" name="buybtn" value="장바구니"></a>
                </dl>
            </div>
            <div id="info2">
                <p id="p2">Author</p>
                <div id="authorinfo">
                    <!-- <img src="../resource/images/book/4178687.jpg"> 이미지 있는 경우만 사용 -->
                    <div id="a_detail">
                        <p><%= b.get("AUTHORNAME") %></p> <br/>
                        <div><%= b.get("AUINFO") %></div>
                    </div>
                </div>
                <div id="bookinfo">
                    <p id="p3">Summary</p>
                    <div id="b_detail">
                        <div id="summary">
                            <%= b.get("BSTORY") %>
                        </div>
                    </div>
                </div>
            </div>
            <div id="reviews">
                <p>Reviews</p>
                <div id="add">
                    
                </div>
                <div id="total">
						<div id="numberList">
							<ul class="pagination">
								<li class="numberList_page"><a href="#"><img
										src="../resource/images/book/btn_L.gif"></a></li>
								<li class="numberList_page"><a href="#">1</a></li>
								<li class="numberList_page"><a href="#">2</a></li>
								<li class="numberList_page"><a href="#">3</a></li>
								<li class="numberList_page"><a href="#">4</a></li>
								<li class="numberList_page"><a href="#">5</a></li>
								<li class="numberList_page"><a href="#"><img
										src="../resource/images/book/btn_R.gif"></a></li>
							</ul>
						</div>
					</div>
                <div id="user_review">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/ICON.png">
                    <textarea id="review_text" placeholder="100자내로 리뷰를 작성해주세요." cols="80" rows="5"></textarea>
                    <input type="button" id="review_btn" name="review_btn" value="등록" onclick="insertReview()">
                </div>
            </div>
        </div>
        
        <%@ include file="../common/footer.jsp"%>
        <script>
        
        	$(function(){
        		getReview(1);
        	});
        	
        	function setReview(list){
        		
        		$("#add").empty();
        		list.forEach(function(item,index){
        			var $ul = $("<ul>");
            		var $imgeLi = $("<li>").append($("<img>").attr("src","${pageContext.request.contextPath}/resources/images/icon/ICON.png"));
            		var $textLi = $("<li>").append($("<b>").text(item.userId)).append($("<br>")).append($("<p>").text(item.bookReview));
            		
            		if("<%= m.getUserId() %>" == item.userId){
            			
            			var $fixInput = $("<input>").attr({"type":"button","data-rno":item.bRno}).css({"margin-right":"5px","background":"white"}).click(function(){
            				updateReview($(this).data("rno"),"update",this);
            			});
            			
            			var $delInput = $("<input>").attr({"type":"button","data-rno":item.bRno}).css({"margin-right":"5px","background":"white"}).click(function(){
            				updateReview($(this).data("rno"),"delete");
            			});
            			
            			$textLi.append($("<span>").css("float","right").append($fixInput.val("수정")).append($delInput.val("삭제")));
            		}
            		
            		
            		/* <input type="button" value="수정" style="
            		    float: right;
            		"> */
            		
            		$ul.append($imgeLi).append($textLi);
            		
            		$("#add").append($ul);
        		});
        		
        		
        		
        			/* <ul>
               	        <li><img src="${pageContext.request.contextPath}/resources/images/icon/ICON.png"></li>
                        <li><b>USERID</b><br><p>최근 읽었던 책 중 가장 재미있었어요!!! 정말 기억에 남는 장면이 너무 많아요.</p></b>
                    </ul> */
        		
        		
        	}
        	
        	function insertReview(){
        		var result = confirm("댓글을 등록하시겠나이까?");
        		
        		if(result){
	        		var params = {
	        				"reviewText" : $("#review_text").val(),
	        				"bno" : "<%= b.get("BNO") %>"
	        		}
	        		
	        		$.ajax({
	        			url:"/BOOKTIFULMUSIC/insertReview.bo",
	        			data:params,
	        			type:"POST",
	        			success: function(data) {
	        				if(data.status == 'success'){
	        					getReview(currentpage);
	        					$("#review_text").val("");
	        				}else{
	        					alert("리뷰 등록 실패");
	        				}
	        			},
	        			error: function(status) {
	        				console.log("오류");
	        			}
	        			
	        		});
        		} else {
        			
        		}	
        	}
        		var currentpage;
        		function getReview(current){
        			currentpage = current;
        			var params = {
	        				"bno" : "<%= b.get("BNO") %>",
	        				"currentPage":current
	        		}
	        		
	        		$.ajax({
	        			url:"/BOOKTIFULMUSIC/selectReview.bo",
	        			data:params,
	        			type:"POST",
	        			success: function(data) {
	        				if(data.status == 'success'){
	        					setReview(data.list);
	        					createPaging(data.pi);
	        				}
	        			},
	        			error: function(status) {
	        				console.log("오류");
	        			}
	        			
	        		});
        			
        		}
        		
        		//페이징 버튼 생성
        		function createPaging(pageInfo){
        			
        			var $pagination = $(".pagination");
        			$pagination.empty();
        			
        			var currentPage = pageInfo.currentPage;
        			var startPage = pageInfo.startPage;
        			var endPage = pageInfo.endPage;
        			var limit = pageInfo.limit;
        			var maxPage = pageInfo.maxPage;
        			$("#re").next().text(" " + pageInfo.listCount);
        			   	   
        				if(currentPage <= 1) { 
        					$pagination.append($("<li>").attr("class","numberList_page").append($("<a>").append($("<a>").text("<"))).attr("disabled",true).css("cursor","pointer"));
        				}else{ 
        					var $li = $("<li>").attr({"class":"numberList_page","onclick":"getReview(" + (currentPage - 1) + ")"});
        					$li.append($("<a>").append($("<a>").text("<"))).css("cursor","pointer");
        					$pagination.append($li);
        							
        				 } 
        				/*  for(var p= startPage; p <= endPage; p++){ */
        					 for (var p= startPage; p <= maxPage; p++) {
        						if (p == currentPage) {
        							$pagination.append($("<li>").attr("class","numberList_page").append($("<a>").text(p).css("color","rgb(105,140,255)")).attr("disabled",true));
        				 		} else { 
        					 		var $li = $("<li>").attr({"class":"numberList_page","onclick":"getReview(" + p + ")"}).append($("<a>").text(p)).css({"cursor":"pointer"});
        							 $pagination.append($li);
        				 		} 
        					 }	
        				
        				 if(currentPage >= maxPage){ 
        					 $pagination.append($("<li>").attr("class","numberList_page").append($("<a>").append($("<a>").text(">"))).attr("disabled",true).css("cursor","pointer"));					
        				 } else {
        					 var $li = $("<li>").attr({"class":"numberList_page","onclick":"getReview(" + (currentPage + 1) + ")"}).append($("<a>").append($("<a>").text(">"))).css("cursor","pointer");
        					 $pagination.append($li);
        				 } 
        		}
        				
        				
       			function updateReview(rno,flag,elm){
					
       				var url = "";
       				var confirmText = "";
       				switch(flag){
       					case "update" : url = "";confirmText="수정"; break;
       					case "delete" : url = "";confirmText="삭제"; break;
					}
       				
       				if (flag == "update" && elm != undefined) {
			       		$(elm).parent().prev().replaceWith("<textarea>" + $(elm).parent().prev().text() + "</textarea>");
       				}
       				
       				var result = confirm(confirmText + " 하시겠습니까?");
       				
       				if(result) {
       				$.ajax({
	        			url:url,
	        			data:{
	        				"rno":rno
	        			},
	        			type:"POST",
	        			success: function(data) {
	        				if(data.status == 'success'){
	        					getReview(currentpage);
	        				}
	        			},
	        			error: function(status) {
	        				console.log("오류");
	        			}
	        			
	        		});
       				}
       			}
        </script>
</body>
</html>