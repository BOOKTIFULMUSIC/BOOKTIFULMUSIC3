package com.web.jsp.allSearch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.jsp.allSearch.model.service.AllSearchService;
import com.web.jsp.allSearch.model.vo.AllSearch;

/**
 * Servlet implementation class AllSearchServlet
 */
@WebServlet("/allsearchList.do")
public class AllSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		ArrayList<AllSearch> bList = new ArrayList<AllSearch>();
		ArrayList<AllSearch> mList = new ArrayList<AllSearch>();
		
		AllSearchService ass = new AllSearchService();
		
		// 도서 검색 결과 페이징 처리
		int bstartPage;
		int bendPage;
		int bmaxPage;
		int bcurrentPage;
		int blimit;
		
		// 처음 접속 시 페이지는 1페이지 부터 시작한다.
		bcurrentPage = 1;
		// 글 개수 및 페이지 수 10개로 제한
		blimit = 10;
		
		if(request.getParameter("bcurrentPage") != null) {
			bcurrentPage = Integer.parseInt(request.getParameter("bcurrentPage"));
		}
		
		int blistCount = ass.getSearchbListCount(keyword);
		
		// 총 253개, 페이지 수--> 26개
		// 만약 전체 게시글 수가 13개
		// 페이지는 1,2
		bmaxPage = (int)((double)blistCount/blimit+0.9);
		
		// 시작 페이지와 마지막 페이지 계산
		// 1~10
		bstartPage = ((int)((double)bcurrentPage/blimit+0.9)-1)*blimit+1;
		bendPage = bstartPage + blimit -1;
		
		if(bendPage > bmaxPage) {
			bendPage = bmaxPage;
		}
		
		// 음원 검색 결과 페이징 처리
		int mstartPage;
		int mendPage;
		int mmaxPage;
		int mcurrentPage;
		int mlimit;
		
		// 처음 접속 시 페이지는 1페이지 부터 시작한다.
		mcurrentPage = 1;
		// 글 개수 및 페이지 수 10개로 제한
		mlimit = 10;
		
		if(request.getParameter("mcurrentPage") != null) {
			mcurrentPage = Integer.parseInt(request.getParameter("mcurrentPage"));
		}
		
		int mlistCount = ass.getSearchmListCount(keyword);
		
		// 총 253개, 페이지 수--> 26개
		// 만약 전체 게시글 수가 13개
		// 페이지는 1,2
		mmaxPage = (int)((double)mlistCount/mlimit+0.9);
		
		// 시작 페이지와 마지막 페이지 계산
		// 1~10
		mstartPage = ((int)((double)mcurrentPage/mlimit+0.9)-1)*mlimit+1;
		mendPage = mstartPage + mlimit -1;
		
		if(mendPage > mmaxPage) {
			mendPage = mmaxPage;
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
