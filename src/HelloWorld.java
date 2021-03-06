

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String requestUri = request.getRequestURI();
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello World from frisrt servlet");

		out.println("<form action='" + requestUri + "' method='post'>");
		out.println("<input type='text' name='name' />");
		out.println("<input type='submit' value='submit' />");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		//取得這個servlet的 init-param
		String secretName = getInitParameter("name");
		System.out.println(" init name= "+secretName);
		
		if(name.equals(secretName))
		{
			//把內容轉向另外一個頁面去繼續做處理
	 		request.getRequestDispatcher("/WEB-INF/Secret.html").forward(request, response);
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("Hello: " + name);
		
		//取得context-param
		out.println(getServletContext().getInitParameter("message"));
		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();
	}
	

}
