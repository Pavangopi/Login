import java.io.IOException;  
import java.io.PrintWriter;
import java.util.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
    	try{
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
    	response.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");  
        String password=request.getParameter("password"); 
        String confirmpassword=request.getParameter("comfirmpassword"); 
    
    	
        String email=request.getParameter("email");
       
        	/*   try {
        	      InternetAddress emailAddr = new InternetAddress(email);
        	      emailAddr.validate();
        	   } catch (AddressException ex) {
               	out.println("<script type=\"text/javascript\">");
         	   out.println("alert('invalid email ');");
         	   out.println("</script>");
        	   }
        	   */
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        if(name!=null && password!=null && email!=null){
        Entity u = new Entity("User", name);
        u.setProperty("userName", name);
        u.setProperty("passWord", password);
        u.setProperty("userEmail", email);
        ds.put(u);
        }
        //request.getRequestDispatcher("login.jsp").include(request, response);

        
       // u.getKey().getName();
        //com.google.appengine.api.datastore.Key k = KeyFactory.createKey("User", name);
       // request.getRequestDispatcher("confirm.jsp").include(request, response);  
        if(!password.equals(confirmpassword)){
        	//out.println("<center>");
            //out.println("<br/>registration successful");  
            //out.println("</center>");
        	out.println("<script type=\"text/javascript\">");
        	   out.println("alert('Registration successful');");
        	   out.println("</script>");
            request.getRequestDispatcher("login.jsp").include(request, response); 
        }

        else{   
        	out.println("<h3>Enter correct password</h3>");
        	request.getRequestDispatcher("confirm.jsp").forward(request, response);

        }  
    	
        out.close();
        }catch (Exception e) {
        	// TODO Auto-generated catch block
    	   PrintWriter out=response.getWriter(); 
    	   
        	out.println("<center>");
            out.println("Please  enter valided details");
            out.println("</center>");
        	System.out.println("I GOT EXCEPTION");
        	
        }
   

    }  
} 