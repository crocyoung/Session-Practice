package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class buyServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get ID
		String id = request.getParameter("id");
		String[] bookNames = {"商品1","商品2","商品3","商品4","商品5"};
		
		// get book name
		String bookName = bookNames[Integer.parseInt(id)-1];
		
		// check if  the book  is in the cart in Session
		HashMap<String, Integer> cart = (HashMap<String, Integer>)request.getSession().getAttribute("cart");
		
		// add into shopping cart
		if(cart == null)
		{
			cart = new HashMap<String, Integer>();  // if null   new a cart
			cart.put(bookName, 1);
		}
		else
		{
			if(cart.containsKey(bookName))
			{
				cart.put(bookName, cart.get(bookName)+1);
			}
			else // add（key）
			{
				cart.put(bookName, 1);
			}
		}
		
		// save this into session
        HttpSession session = request.getSession();		
        session.setAttribute("cart", cart);
        
        // send a message to user
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println(bookName+"is saved in shopping cart. continue shopping, please click: "+"<a href='/Session/products.jsp'>continue shopping</a>");
		

		
	}



}
