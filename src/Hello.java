import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class Hello extends HttpServlet implements Servlet {
       
    public Hello() {}

    private void showBaseSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageTitle = "ITSo(u)rcerers Home";
        request.setAttribute("title", pageTitle);
        Date datum = new Date();

        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>ITSo(u)rcerers Home</TITLE></HEAD>");
        out.println("<BODY>");
        out.println ("Heute: " + datum.toString());

        //request.setParameter("userName","guest");
        out.println ("Username: " + request.getParameter("userName"));
        out.println ("Attribut01 : " + request.getSession().getAttribute("MyAttribute"));

        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.setAttribute("MyAttribute", "test value");
        showBaseSite(request, response);
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
