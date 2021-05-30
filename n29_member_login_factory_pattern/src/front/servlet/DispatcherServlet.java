package front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;
import controller.ModelAndView;
public class DispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //command 값을 받아온다.
      String command = request.getParameter("command");
      //ModelAndView mv = null ;
      
      Controller controller = ControllerFactory.getInstance().createController(command);
      try{
         ModelAndView mv = controller.execute(request, response);
         if(mv.isRedirect()){
            response.sendRedirect(mv.getPath());
         }else{
            request.getRequestDispatcher(mv.getPath()).forward(request, response);
         }
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}