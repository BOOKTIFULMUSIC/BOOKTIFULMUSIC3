<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, com.web.jsp.allSearch.model.vo.*"%>
<%@page import="com.web.jsp.book.model.vo.PageInfo"%>
<% 
ArrayList<AllSearch> bList = (ArrayList<AllSearch>)request.getAttribute("bList");
ArrayList<AllSearch> mList = (ArrayList<AllSearch>)request.getAttribute("mList");
PageInfo bpi = (PageInfo)request.getAttribute("bpi");
PageInfo mpi = (PageInfo)request.getAttribute("mpi");
String keyword = (String)request.getAttribute("keyword");

int bListCount = bpi.getListCount();
int bcurrentPage = bpi.getCurrentPage();
int bmaxPage = bpi.getMaxPage();
int bstartPage = bpi.getStartPage();
int bendPage = bpi.getEndPage();

int mListCount = mpi.getListCount();
int mcurrentPage = mpi.getCurrentPage();
int mmaxPage = mpi.getMaxPage();
int mstartPage = mpi.getStartPage();
int mendPage = mpi.getEndPage();

%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllSearchList</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/allSearch.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
#numberList button{
	border:none;
	background: rgb(227, 233, 255);
	border-radius: 10px;
	padding:10px;
}

#numberList button:hover{
    cursor: pointer;
    color: rgb(105,140,255);
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="content">
        <div class="section">
            <p id="page_logo"><b>BOOKTIFUL<br>MUSIC</b></p>
            <div class="search_menu">
                <input type="radio" id="tab1" name="tabs" checked><label class="result"for="tab1"><p>도서 검색 결과</p></label>
                <input type="radio" id="tab2" name="tabs"><label class="result" for="tab2"><p>음원 검색 결과</p></label>         
 
                <section id="search_box1">
                    <% if(bListCount > 0) {%>
                    <p id="greeting">검색하신 키워드 <strong>"<%=keyword%>"</strong>에 대한 도서 검색결과가 총 <strong><%=bListCount%></strong>건이 있습니다.</p>
                    <table id="bookList_info">
                        <tr>
                            <th>번호</th>
                            <th>도서 정보</th>
                            <th>♥좋아요</th>
                            <th>도서 리뷰</th>
                            <th>가격</th>
                        </tr>
                    </table>
                    <table>
                    	<% for(AllSearch ab : bList) {%>
                        <tr id="bookList">
                            <td><%=ab.getbRnum()%></td>
                            <td><a href="../view/Music_Info.html"><img src="${pageContext.request.contextPath}/resources/images/book/<%= ab.getbImage()%>" alt=""></a></td>
                            <td>
                                <ul>
                                    <li style="font-size: 14pt; color: black;"><a href="../view/Music_Info.html">&nbsp;&nbsp;&nbsp;&nbsp;<%=ab.getbTitle()%></a></li>
                                    <li style="font-size: 14pt; color: lightgray;">&nbsp;&nbsp;&nbsp;&nbsp;<%=ab.getPublisher()%></li>
                                </ul>
                            </td>
                            <td><label onclick="like(this);" id="heart">♥</label><label><%=ab.getbLikeCount()%></label></td>
                            <td><a href="리뷰창"><%=ab.getbReview()%></a></td>
                            <td><label onclick="streaming(this);"><strong><%=ab.getBprice()%></strong></label></td>
                        </tr>
                     	<%} %>
                    </table>
                    <br><br><br>
			        <div id="numberList" style="text-align: center;">                    
                     			<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&bcurrentPage=1'"><<</button>
								<%  if(bcurrentPage <= 1){  %>
								<button disabled><</button>
								<%  }else{ %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&bcurrentPage=<%=bcurrentPage - 1 %>'"><</button>
								<%  } %>
								
								<% for(int p = bstartPage; p <= bendPage; p++){
										if(p == bcurrentPage){	
								%>
									<button disabled><%= p %></button>
								<%      }else{ %>
									<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&bcurrentPage=<%= p %>'"><%= p %></button>
								<%      } %>
								<% } %>
									
								<%  if(bcurrentPage >= bmaxPage){  %>
								<button disabled>></button>
								<%  }else{ %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&bcurrentPage=<%=bcurrentPage + 1 %>'">></button>
								<%  } %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&bcurrentPage=<%=bmaxPage%>'">>></button>
					</div>
                    <%}else {%>
                    	<p id="greeting">검색하신 키워드 <strong>"<%=keyword%>"</strong>에 대한 도서 정보가 없습니다.</p>
                    <%} %>
                </section>
                
                <section id="search_box2">
                	<% if(mListCount > 0) {%> 
                    <p id="greeting">검색하신 키워드 <strong>"<%=keyword%>"</strong>에 대한 음원 검색결과가 총 <strong><%=mListCount%></strong>건이 있습니다.</p>
                    <table id="musicList_info">
                        <tr>
                            <th>번호</th>
                            <th>곡 정보</th>
                            <th>♥좋아요</th>
                            <th>곡 리뷰</th>
                            <th>듣기</th>
                        </tr>
                    </table>
                    <table>
                    	<%for(AllSearch am : mList) {%>
                        <tr id="musicList">
                            <td><%=am.getmRnum()%></td>
                            <td><a href="../view/Music_Info.html"><img src="${pageContext.request.contextPath}/resources/images/music/<%=am.getmImage()%>" alt=""></a></td>
                            <td>
                                <ul>
                                    <li style="font-size: 14pt; color: black;"><a href="../view/Music_Info.html"><%=am.getmName()%></a></li>
                                    <li style="font-size: 14pt; color: lightgray;"><%=am.getmArtist()%></li>
                                </ul>
                            </td>
                            <td><label onclick="like(this);" id="heart">♥</label><label><%=am.getmLikeCount()%></label></td>
                            <td><a href="리뷰창"><%=am.getaReview()%></a></td>
                            <td><label onclick="streaming(this);">▶</label></td>
                        </tr>
                        <%} %>
                    </table>
                    <br><br><br>
                    <div id="numberList" style="text-align: center;">
                    			<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&mcurrentPage=1'"><<</button>
								<%  if(mcurrentPage <= 1){  %>
								<button disabled><</button>
								<%  }else{ %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&mcurrentPage=<%=mcurrentPage - 1 %>'"><</button>
								<%  } %>
								
								<% for(int p = mstartPage; p <= mendPage; p++){
										if(p == mcurrentPage){	
								%>
									<button disabled><%= p %></button>
								<%      }else{ %>
									<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&mcurrentPage=<%= p %>'"><%= p %></button>
								<%      } %>
								<% } %>
									
								<%  if(mcurrentPage >= mmaxPage){  %>
								<button disabled>></button>
								<%  }else{ %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&mcurrentPage=<%=mcurrentPage + 1 %>'">></button>
								<%  } %>
								<button onclick="location.href='<%= request.getContextPath() %>/allsearchList.do?keyword=<%=keyword%>&mcurrentPage=<%=mmaxPage%>'">>></button>     
					</div>
                    <%}else{%>
                    	<p id="greeting">검색하신 키워드 <strong>"<%=keyword%>"</strong>에 대한 음원 정보가 없습니다.</p>
                    <%} %>
                </section>
            </div>
        </div> 
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>