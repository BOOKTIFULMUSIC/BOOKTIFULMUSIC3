<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.jsp.Member.model.vo.*" import="com.web.jsp.Music.model.vo.*" import="java.util.*" %>


<%@page import="com.web.jsp.book.model.vo.PageInfo"%>
<% ArrayList<Music> list = (ArrayList<Music>)request.getAttribute("list");

String genre = (String)request.getAttribute("genre");

PageInfo pi = (PageInfo)request.getAttribute("pi");
int listCount = pi.getListCount();
int currentPage = pi.getCurrentPage();
int maxPage = pi.getMaxPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>BOOKTIFULMUSIC</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/music_like.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="content">
			<div id="sub_menu">
				<ul>
					<li><a onclick="MusicGenre()">|&nbsp;장르</a></li>
					<li><a onclick="MusicLike()">좋아요</a></li>
					<li><a onclick="MusicReview()">|&nbsp;리뷰</a></li>
				</ul>
			</div>

			<div id="title">
			<p style="text-align: center;">좋아요 순 음원보기</p>
			</div>

			<div id="section">
				<div id="imgbox">
					<ul id="listOne">
                        	<% for(Music mu : list) { %>
                            <li><a onclick="MusicInfo()"> 
                            <img src="${pageContext.request.contextPath}/resources/images/music/<%=mu.getMusicImage()%>" >
                                    <span>
                                        <p style="color: black;"><%= mu.getMusicNm() %></p>
                                        <p id="Artist" name="Artist" style="color: #757575;">
                                        <b><%= mu.getMusicArtist() %></b>&nbsp;&nbsp;|&nbsp;&nbsp;
                                        <b class="fas fa-heart">♥</b><%= mu.getLikeMusic() %></p>
                                    </span>
                            	</a>
                            </li>
                            <% } %>
                        </ul>
				</div>
            </div>
        </div>
	
	
	<div id="total" style="margin-bottom:120px;">
             <div id="numberList">
					<%  if(currentPage <= 1){  %>
					<button disabled><</button>
					<%  }else{ %>
							<button onclick="location.href='<%= request.getContextPath() %>/mLikeList.mo?currentPage=<%=currentPage - 1 %>'"><</button>
					<%  } %>
					
					<% for(int p = startPage; p <= endPage; p++){
							if(p == currentPage){	
					%>
						<button disabled><%= p %></button>
					<%      }else{ %>
							<button onclick="location.href='<%= request.getContextPath() %>/mLikeList.mo?currentPage=<%= p %>'"><%=p %></button>
					<%      } %>
					<% } %>
						
					<%  if(currentPage >= maxPage){  %>
					<button disabled>></button>
					<%  }else{ %>
							<button onclick="location.href='<%= request.getContextPath() %>/mLikeList.mo?currentPage=<%=currentPage + 1 %>'">></button>
					<%  } %>
             </div>
             <div id="musicLike_search">
                 <select class="search_tool">
                     <option value="제목순">제목순</option>
                     <option value="별점순">별점순</option>
                     <option value="판매순">판매순</option>
                 </select> <input class="searchinput" type="search" placeholder="검색어를 입력해주세요">
                 <input class="search_tool" type="button" value="검색">
             </div>
        </div>
        </div>
        <script>
		       function MusicGenre(){
				location.href="/BOOKTIFULMUSIC/mGenreList.mo";
			}
		       function MusicLike(){
				location.href="/BOOKTIFULMUSIC/mLikeList.mo";
			}
		       function MusicReview(){
				location.href="/BOOKTIFULMUSIC/mReviewList.mo";
			}
        	function MusicInfo(){
        		location.href="/BOOKTIFULMUSIC/mSelectOne.mo";
        	}
        </script>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>