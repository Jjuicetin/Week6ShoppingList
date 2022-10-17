
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author justin
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession(); //create session
         String username = (String) session.getAttribute("username"); //username session
         String action = request.getParameter("action");
     
          //if user presses logout link, kill session and direct back to register.
         if(action != null && action.equals("logout")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
         
                //if there is a exsisting session send them to SHOP LIST
              if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
              }
               else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         HttpSession session = request.getSession(); //create session
         String action = request.getParameter("action");
         String username = request.getParameter("username");
         ArrayList<String> itemList;
         
         
       
        if(session.getAttribute("itemList") == null){
               itemList = new ArrayList<>();
        }
       else{
              itemList = (ArrayList<String>) session.getAttribute("items");
        }
        
        
        
        if (action.equals("register")){
            session.setAttribute("username", username);
            session.setAttribute("itemList", itemList);
            //arraylist
        }
        if(action.equals("add")){
            String item = request.getParameter("items");
            itemList.add(item);
            session.setAttribute("itemList", itemList);
        }
        if(action.equals("delete")){
            String item = request.getParameter("items");
            itemList.remove(item);
             session.setAttribute("itemList", itemList);
                 
        }
        //max length of list
        int counter = itemList.size();
        
        
        
        
        
        
        
        
        
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

   
}
