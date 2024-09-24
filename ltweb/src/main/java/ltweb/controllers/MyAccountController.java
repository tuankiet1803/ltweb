package ltweb.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ltweb.models.UserModel;

@WebServlet(urlPatterns = { "/myaccount" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MyAccountController extends HttpServlet {

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
			req.getRequestDispatcher("/views/myaccount.jsp").forward(req, resp);
		}
		else {
		resp.sendRedirect(req.getContextPath() + "/home");
		}
	}

}
