package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 선택하지 않고 넘어오면 error/error.html 페이지로 이동하고 선택하고 넘어오면
		 * "해당 페이지는 RedirectServlet2 입니다" 를 출력.
		 */
		String choose = request.getParameter("choose");
		if (choose == null) { // 선택하지 않고 넘어오면
			response.sendRedirect("http://www.google.co.kr");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<h2><b>해당 페이지는 RedirectServlet2 입니다</b></h2>");
			out.close();
		}
	}
}
