package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
import com.util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
/*@WebServlet("/LoginServlet")*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置相应编码
				response.setContentType("utf-8");
				String username=request.getParameter("username");
				String pwd=request.getParameter("password");
				UserDao ud=new UserDao();
				HttpSession session=request.getSession();
				User user=(User)session.getAttribute("user");
				if(user==null)
				{
					user=ud.loadUser(username, pwd);
				}
				session.setAttribute("user",user);
				if(user!=null)
				{
					response.sendRedirect("index.jsp");
				}
				else
				{
					response.sendRedirect("user/index.html");
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
