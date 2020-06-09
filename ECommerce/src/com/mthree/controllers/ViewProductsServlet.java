 package com.mthree.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mthree.daos.ProductDAO;
import com.mthree.models.Product;

/**
 * Servlet implementation class ViewProductsServlet
 */
@WebServlet("/ViewProductsServlet")
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	    ProductDAO dao = new ProductDAO();
	    
	    List<Product> products = dao.getAllProducts();
	    
	    
	    HttpSession session = request.getSession(true);
	    
	    session.setAttribute("productList", products);
	    
	    session.setAttribute("cartSize",dao.findCartSize());
	    
	    
	    response.sendRedirect(request.getContextPath()+"/view_products.jsp");
	    
	    
	    
	    
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
