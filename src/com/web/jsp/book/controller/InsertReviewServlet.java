package com.web.jsp.book.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.web.jsp.Member.model.vo.Member;
import com.web.jsp.book.model.service.BookService;

/**
 * Servlet implementation class InsertReview
 */
@WebServlet("/insertReview.bo")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		System.out.println(member);
		int reviewCnt = 0;
		String userId = member.getUserId();
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		hmap.put("BNO", request.getParameter("bno"));
		hmap.put("BOOK_REVIEW", request.getParameter("reviewText"));
		hmap.put("USERID", userId);
		
		BookService bs = new BookService();
		
		reviewCnt = bs.insertReview(hmap);
		
		HashMap<String,String> resultMap = new HashMap<String,String>();
		if (reviewCnt > 0) {
			resultMap.put("status", "success");
		} else {
			resultMap.put("status", "error");
		}
		
		new Gson().toJson(resultMap, response.getWriter());
		
	}

}
