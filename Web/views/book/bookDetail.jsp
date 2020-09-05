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
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<b id="re">review</b> <%= b.get("BREVIEWCOUNT") %></li>
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
                    <ul>
                        <li><img src="${pageContext.request.contextPath}/resources/images/icon/ICON.png"></li>
                        <li><b>USERID</b><br><p>최근 읽었던 책 중 가장 재미있었어요!!! 정말 기억에 남는 장면이 너무 많아요.</p></b>
                    </ul>
                    <ul>
                        <li><img src="${pageContext.request.contextPath}/resources/images/icon/ICON.png"></li>
                        <li><b>USERID</b><br><p>오랜만에 머리가 풀리는 기분!</p></li>
                    </ul>
                </div>
                <div id="user_review">
                    <img src="${pageContext.request.contextPath}/resources/images/icon/ICON.png">
                    <textarea id="review_text" placeholder="100자내로 리뷰를 작성해주세요." cols="80" rows="5"></textarea>
                    <input type="button" id="review_btn" name="review_btn" value="등록">
                </div>
            </div>
        </div>
        
        <%@ include file="../common/footer.jsp"%>
        <script>
        	function insertReview(){
        		
        	}
        </script>
</body>
</html>