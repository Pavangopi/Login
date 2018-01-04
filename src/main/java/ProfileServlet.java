import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class ProfileServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        request.getRequestDispatcher("profilelogout.jsp").include(request, response);  
        String name=(String)session.getAttribute("name");  
        out.println("<center>");
        out.print("<br/>Hello, "+name+" Welcome to Profile");  
        out.println("</center>");
        }  
        else{  
        	out.println("<center>");
            out.println("<br/>Please login first");  
            out.println("</center>");
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  
        out.close();  
    }  
}  
