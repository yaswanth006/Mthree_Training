package com.mthree.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mthree.daos.ProductDAO;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated me
    
    	
   
    	
    	HttpSession session = req.getSession(true);
	    
	    
    	int productId = Integer.parseInt(req.getParameter("productId"));

    	ProductDAO dao = new ProductDAO();
    	
    	if(dao.addToCart(productId)>0) {
    		
    		session.setAttribute("cartSize", dao.findCartSize());
    		resp.sendRedirect(req.getContextPath()+"/view_products.jsp");
    	}else {
    		resp.sendRedirect(req.getContextPath()+"/error.jsp");
    	}
    }
	
	
	
	

}
