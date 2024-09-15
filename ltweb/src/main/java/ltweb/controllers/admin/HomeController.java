package ltweb.controllers.admin;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb.models.UserModel;

@WebServlet(urlPatterns = "/admin/home")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("account");
		if (session != null && session.getAttribute("account") != null) {
			req.setAttribute("phone", user.getPhone());
			req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(session.getAttribute("account") != null) {
			session.removeAttribute("account");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}
}