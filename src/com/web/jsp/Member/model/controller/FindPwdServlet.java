package com.web.jsp.Member.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.web.jsp.Member.exception.MemberException;
import com.web.jsp.Member.model.service.MemberService;
import com.web.jsp.Member.model.vo.Member;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/mFindPwd.me")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("name2");
		String userId = request.getParameter("name3");
		String email = request.getParameter("email2");
		
				
		Member m = new Member(userName,email,userId,null);
		MemberService ms = new MemberService();
		
		JSONObject result = new JSONObject();
		
		try {
			m = ms.findPwd(m);
			result.put("userPwd", m.getUserPwd());
			response.setContentType("application/json");
			response.getWriter().print(result.toJSONString());
			System.out.println("서블릿 비밀번호" + result);
			
			
		}catch(MemberException e) {
			request.setAttribute("msg", "비밀번호 찾기에 실패하였습니다.");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
