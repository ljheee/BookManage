package com.ljheee.app.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljheee.app.db.Db;
/**
 * web �齨---��Servlet��listener��filter
 * @author ljheee
 *
 */
import com.ljheee.app.entity.Book;
@WebServlet({     //ע��---����·��
		"/book",  //·��---·�ɷַ�
		"/book/save",
		"/book/remove",
		"/book/find",
		"/book/edit"
		})
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();//�������·��
		switch (path) {
		case "/book":
			showBook(request, response);
			break;
		case "/book/save":
			//����һ��������---��ַ��������ʾadd.html 
			request.getRequestDispatcher("/add.html").forward(request, response);
			break;
		case "/book/edit":
			editBook(request,response);
			break;

		default:
			break;
		}
	
	}

	private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		
		//��ѯ����
		Book b = Db.find(id);
		request.setAttribute("b", b);  //����ʱ����Ʒ����--����scope����ΧԽСԽ��
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
		
	}

	public void showBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> books = Db.find();
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/book.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getServletPath();
		switch (path) {
		case "/book/remove":
			removeBook(request,response);
			break;
		case "/book/save":
			saveBook(request, response);
			break;
			
		case "/book/edit":
			updateBook(request,response);
		
			break;
		default:
			break;
		}
	
	}

	public void saveBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Book b = new Book(title, author, price);
		Db.save(b);
		response.sendRedirect("../book");
//			request.getRequestDispatcher("/book.jsp").forward(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Book b = new Book(id,title, author, price);
		Db.update(b);
		response.sendRedirect("../book");
	}

	private void removeBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		Db.remove(id);
		response.sendRedirect("../book");//�ض���--���²�ѯ����ʾ
	}

	
	
}
