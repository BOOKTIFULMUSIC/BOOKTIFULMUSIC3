<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.jsp.Member.model.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findId</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/find_id_pwd.css" />
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>

<%@ include file="../common/header.jsp" %>

<div class="content-wrapper">
        <div id="content">
            <p id="page_logo"><b>BOOKTIFUL<br>MUSIC</b></p>
            <div class="tab-wrapper">
                <div class="tab-menu">
                    <input type="radio" id="tab1" name="tabs" checked><label for="tab1"><p>아이디 찾기</p></label>
                    <input type="radio" id="tab2" name="tabs"><label for="tab2"><p>비밀번호 찾기</p></label>
                    <section id="tab-box1">
                        <div id="box1">
                            <form id = 'find_id_form'>
                            <p id="p1">이름</p>
                            <input type="text" id="name1" placeholder=" 이름을 입력하세요.">
                            <p id="p2">이메일</p>
                            <input type="email" id="email1" placeholder=" 이메일을 입력하세요.">
                             <!-- &nbsp;&nbsp;@&nbsp;&nbsp; --> 
                            <!--                             <select id="select_email">
                                <option value="naver">@naver.com</option>
                                <option value="hanmail">@hanmail.net</option>
                                <option value="gmail">@gmail.com</option>
                                <option value="nate">@nate.com</option>
                                <option value="etc">기타</option>
                            </select> -->
                            
                            <input type="submit" id="id_find_btn1" value="아이디 찾기" onclick='findId()'>
                            </form>
                        </div>
                    </section>
                    <section id="tab-box2">
                        <div id="box2">
                        <form>
                            <p id="p1">이름</p>
                            <input type="text" id="name2" placeholder=" 이름을 입력하세요."></input>
                            <p id="p2">아이디</p>
                            <input type="text" id="name3" placeholder=" 아이디를 입력하세요.">
                            <p id="p3">이메일</p>
                             <input type="email" id="email2" placeholder=" 이메일을 입력하세요."> <!-- &nbsp;&nbsp;@&nbsp;&nbsp; --> 
<!--                             <select id="select_email">
                                <option value="naver">@naver.com</option>
                                <option value="hanmail">@hanmail.net</option>
                                <option value="gmail">@gmail.com</option>
                                <option value="nate">@nate.com</option>
                                <option value="etc">기타</option>
                            </select> -->
                            
                            <input type="submit" id="id_find_btn2" value="비밀번호 찾기">
                            </form>
                        </div>
                    </section>
                </div>
            </div>
         </div>
     </div>
            
            <%@ include file="../common/footer.jsp" %>
            
            <script>
            
     	        $('#id_find_btn1').click(function(){

    	        	$.ajax({
    					url:"/BOOKTIFULMUSIC/mFindId.me",
    					type:'get',
    					data:{
    						 name1:$('#name1').val()
    						,email1:$('#email1').val()
    					},success:function(result){
    						if(result.userId != null){
    							alert('당신의 아이디는' + result.userId +'입니다.');
    						
    						}else{
 
    						alert('해당하는 아이디가 없습니다.');
    						}
    					},error:function(request,status,error){
    						
    						console.log("--- ERROR ----");
    						console.log(request);
    						console.log(status);
    						console.log(error);
    					}
    				});
    	        	return false
    			});
     	        

            /*
          	function findId(){
        		$("#find_id_form").submit();
        		
        	} */

            </script>
            
            <script>
  	        $('#id_find_btn2').click(function(){

	        	$.ajax({
					url:"/BOOKTIFULMUSIC/mFindPwd.me",
					type:'get',
					data:{
						 name2:$('#name2').val()
						,name3:$('#name3').val()
						,email2:$('#email2').val()
					},success:function(result){
						if(result.userPwd != null){
							alert('당신의 비밀번호는' + result.userPwd +'입니다.');
						
						}else{

						alert('해당하는 비밀번호가 없습니다.');
						}
					},error:function(request,status,error){
						
						console.log("--- ERROR ----");
						console.log(request);
						console.log(status);
						console.log(error);
					}
				});
	        	return false
			});
            </script>
            
            

            
</body>
</html>