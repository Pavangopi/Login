
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
    	try{
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
        out.println("<center>");
        out.println("<br/>Happy New Year "+name+" Welcome to 2018<br/><br/>");  
        out.println("<br/>Here are 10 Best Inspirational Quotes on New Year:<br/><br/>");
       out.println("<br/>For last year's words belongs to last year's language And next year words await another voice<br/>-T.S.Eliot.Four Quartets</br>");
        out.println("<br/>Tomorrow is the first blank page of a 365-page book. Write a good one.<br/>-Brad Paisley<br/>");
       out.println("<br/>Cheers to a new year and another chance for us to get it right.<br/>-Oprah Winfrey</br>");
       out.println("<br/>We will open the book. Its pages are blank. We are going to put words on them ourselves.The book is called Opportunity and its first chapter is New Year's Day. <br/>-Edith Lovejoy Pierce<br/>");
       out.println("<br/>May the New Year bring you courage to break your resolutions early! My own plan is to swear off every kind of virtue so that I triumph even when I fall! <br/>- Aleister Crowley, Moonchild<br/>");
       out.println("<br/>The object of a New Year is not that we should have a new year. It is that we should have a new soul and a new nose; new feet, a new backbone, new ears, and new eyes. <br/>- G.K. Chesterton, A Chesterton calendar<br/>");
       out.println("<br/>In the New Year, never forget to thank to your past years because they enabled you to reach today! Without the stairs of the past, you cannot arrive at the future! <br/>- Mehmet Murat ildan<br/>");
       out.println("<br/>Let all the failures of your past year be your best guide in the New Year! <br/>- Mehmet Murat ildan<br/>");
       out.println("<br/>Dear world, I am excited to be alive in you, and I am thankful for another year. <br/>-Charlotte Eriksson<br/>");
       out.println("<br/>There is nothing magical about the flip of the calendar, but it represents a clean break, a new hope, and a blank canvas.<br/>- Jason Soroski<br/>");
       out.println("</center>");
       HttpSession session=request.getSession();  
        session.setAttribute("name",name);  
        //ImageIO.read(new File("image/newimage.jpg"));
        //request.getRequestDispatcher("newimage.jpg").include(request, response);  
        }  
        else{  
        	//out.println("<center>");
           // out.println("<br/>Sorry, username or password error!");  
           // out.println("</center>");
        	out.println("<script type=\"text/javascript\">");
        	   out.println("alert('User or password incorrect');");
        	   out.println("</script>");
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  
        }catch (EntityNotFoundException e) {
        	// TODO Auto-generated catch block
        	out.println("<center>");
            out.println("your not registered and please check your details");
            out.println("</center>");
        	System.out.println("I GOT EXCEPTION");
        	
        }
        out.close();  
        }catch (Exception e) {
        	// TODO Auto-generated catch block
    	   PrintWriter out=response.getWriter(); 
    	   
        	out.println("<center>");
            out.println("Please  enter valided data");
            out.println("</center>");
        	System.out.println("I GOT EXCEPTION");
        	
        }
   
    }  
}  

