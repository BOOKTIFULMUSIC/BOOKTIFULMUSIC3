package com.web.jsp.Review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.jsp.Member.exception.MemberException;
import com.web.jsp.Music.model.vo.Music;
import com.web.jsp.Review.model.service.ReviewService;
import com.web.jsp.Review.model.vo.MusicReview;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/mInsertReview.mo")
public class mReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String mno = request.getParameter("mno");
		String userId = request.getParameter("writer");
		String review = request.getParameter("content");
		
		MusicReview mr = new MusicReview(mno,userId,review);
		ReviewService rs = new ReviewService();
		ArrayList<MusicReview> rlist = new ArrayList<>();
		rlist = rs.selectList(mno);
		
		System.out.println("리뷰리스트" + rlist);
		int result = rs.insertReview(mr);
		
		if(result>0) {
			response.sendRedirect("views/music/MusicDetail.jsp");
			request.setAttribute("rlist", rlist);
		}else {
			request.setAttribute("msg", "리뷰 작성에 실패하였습니다.");
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
