package com.web.jsp.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.jsp.Review.model.vo.BookReview;
import com.web.jsp.book.model.service.BookService;
import com.web.jsp.book.model.vo.PageInfo;

/**
 * Servlet implementation class SelectReviewServlet
 */
@WebServlet("/selectReview.bo")
public class SelectReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		ArrayList<BookReview> list = null;
		BookService bs = new BookService();
		HashMap<String,Object> resultMap = null;
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		int buttonCount = 5;
		limit = 5;
		
		Long bno = Long.parseLong(request.getParameter("bno"));
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = bs.getReviewCount(bno);

		maxPage = (int)((double)listCount/limit+0.9);
		startPage = ((int)((double)currentPage/buttonCount+0.9)-1)*buttonCount+1;
		endPage = startPage + buttonCount -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = bs.selectReview(currentPage,limit,bno);

		String page="";
		if(list!=null) {

			endPage = startPage+limit-1;
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage,buttonCount);
			resultMap = new HashMap<String,Object>();
			resultMap.put("status","success");
			resultMap.put("pi", pi);
			resultMap.put("list", list);
		} else {
		}
		
		new Gson().toJson(resultMap, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
