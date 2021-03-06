package com.web.jsp.book.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.jsp.book.model.service.BookService;
import com.web.jsp.book.model.vo.Book;

/**
 * Servlet implementation class BookDetail
 */
@WebServlet("/bSelectOne.bo")
public class BookDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      Long bno = Long.parseLong(request.getParameter("bno"));
      
      BookService bs = new BookService();
      
      HashMap<String,Object> b = bs.selectOne(bno);
      request.setAttribute("b", b);
      request.getRequestDispatcher("views/book/bookDetail.jsp").forward(request, response);
   }   

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}