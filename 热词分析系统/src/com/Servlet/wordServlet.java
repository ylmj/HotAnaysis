package com.Servlet;
import com.alibaba.fastjson.JSONObject;
import com.dao.KeyDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class wordServlet
 * @WebServlet("/wordServlet")
 */

public class wordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//����content���ַ���ʽ
		String content = request.getParameter("content");//����content
		//System.out.println("��ȡ��������:"+content);
		JSONObject json = new JSONObject();//����һ��json
		KeyDao wordDao = new KeyDao();//���÷���
        String explain = wordDao.loadKeyCon(content);//
        json.put("explain",explain);//�൱�ڶ���һ��json�����ԣ�����ֵ����ȡ������explain
        response.setCharacterEncoding("utf-8");//�ַ����ĸ�ʽ
        response.getWriter().write(json.toJSONString());//���ش�

	}

}
