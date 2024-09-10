package a.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/trangchu"})
public class bController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7664464526545381298L; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String ten1 = req.getParameter("ten");
		String ho1 = req.getParameter("ho");
		
		req.setAttribute("fname", ten1);
		req.setAttribute("lname", ho1);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
		rd.forward(req, resp);
//		PrintWriter printW = resp.getWriter();
//		printW.println(ho1 + " " + ten1);
//		printW.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
