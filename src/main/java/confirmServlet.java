import java.io.IOException;  
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class confirmServlet extends HttpServlet {  
	//Set<Account> acc = new HashSet<Account>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
    	response.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");  
        String password=request.getParameter("password"); 
        String confirmpassword=request.getParameter("comfirmpassword"); 
        String email=request.getParameter("email");
        
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity u = new Entity("User", name);
        u.setProperty("userName", name);
        u.setProperty("passWord", password);
        u.setProperty("userEmail", email);
        ds.put(u);
        //request.getRequestDispatcher("login.jsp").include(request, response);

        
       // u.getKey().getName();
        //com.google.appengine.api.datastore.Key k = KeyFactory.createKey("User", name);
       // request.getRequestDispatcher("confirm.jsp").include(request, response);  
        if(!password.equals(confirmpassword)){

            out.println("<br/>registration successful");  
            request.getRequestDispatcher("login.jsp").include(request, response); 
        }

        else{   
        	out.println("<h3>Enter correct password</h3>");
        	request.getRequestDispatcher("confirm.jsp").forward(request, response);

        }  
        out.close();

    }  
}  
