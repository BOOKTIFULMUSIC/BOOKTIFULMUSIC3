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
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/mFindId.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("name1");
		String email = request.getParameter("email1");
		
		Member m = new Member(userName, email, null);
		MemberService ms = new MemberService();
		
		JSONObject result = new JSONObject();
		
		try {
			m = ms.findId(m);
			result.put("userId", m.getUserId());
			response.setContentType("application/json");
			response.getWriter().print(result.toJSONString());
			System.out.println("서블릿 아이디" + result);
			
			
		}catch(MemberException e) {
			request.setAttribute("msg", "아이디 찾기에 실패하였습니다.");
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
