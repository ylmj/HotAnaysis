package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
/*@WebServlet("/RegisterServlet")*/
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		 String html_head = "<html>\n" +
	                "<head>\n" +
	                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
	                "    <title>Title</title>\n" +
	                "</head>\n" +
	                "<body>\n";
	        String html_tail = "</body>\n" +
	                "</html>";
		if(ud.addUser(username, pwd))
		{
			response.sendRedirect("user/index.html");
		}
		else
		{
			PrintWriter writer=response.getWriter();
			writer.println(html_head + "<script>alert('该用户名已存在');history.go(-1);</script>" + html_tail);
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
