import java.io.File;
import java.io.IOException;  
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       
        String name=request.getParameter("name");  
        String password=request.getParameter("password"); 
       
        //String confirmpassword=request.getParameter("password"); 
        DatastoreService dataStore =DatastoreServiceFactory.getDatastoreService();
        Key employeeKey = KeyFactory.createKey("User", name);
        try {
        	Entity e = dataStore.get(employeeKey);
        	String username=(String)e.getProperty("userName");
        	String passwordDb=(String)e.getProperty("passWord");
        	System.out.println("PASSWORD DB VALUE IS="+passwordDb);
        	System.out.println("user DB VALUE IS="+username);

        
        if(name.equals(username)&&password.equals(passwordDb)){  
        request.getRequestDispatcher("loginsuccess.jsp").include(request, response);  
        out.println("<br/>Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
        //ImageIO.read(new File("image/newimage.jpg"));
        //request.getRequestDispatcher("newimage.jpg").include(request, response);  
        }  
        else{  
            out.println("<br/>Sorry, username or password error!");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  
        }catch (EntityNotFoundException e) {
        	// TODO Auto-generated catch block

            out.println("your not registered");
        	System.out.println("I GOT EXCEPTION");
        	
        }
        out.close();  
    }  
}  
