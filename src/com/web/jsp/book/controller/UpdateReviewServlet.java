package com.web.jsp.book.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.jsp.book.model.service.BookService;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/updateReview.bo")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
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
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rText = request.getParameter("rText");
		BookService bs = new BookService();
		
		int result = bs.updateReview(rno,rText);
		
		HashMap<String,String> resultMap = new HashMap<String,String>();
		if (result > 0){
			resultMap.put("result","success");
		}else{
			resultMap.put("result","error");
		}
		
		new Gson().toJson(resultMap, response.getWriter());
		
	}

}
