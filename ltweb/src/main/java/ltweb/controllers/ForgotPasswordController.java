package ltweb.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltweb.services.implement.userServiceimplement;

@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		userServiceimplement service = new userServiceimplement();
		String alertMsg = "";
		if (!service.checkExistEmail(email)) {
			alertMsg = "Email không tồn tại!";
		}
		else {
			String newPassword = service.RandomPassword();
			alertMsg = "Mật khẩu mới của bạn là " + newPassword;
			service.updatePassword(newPassword, email);
		}
		req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
}
