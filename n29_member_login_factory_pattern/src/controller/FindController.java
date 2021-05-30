package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;
 
public class FindController implements Controller{

   @Override
   public ModelAndView execute(HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      String id = request.getParameter("id");
      String path = "find_fail.jsp";
      MemberDTO rdto = MemberDAO.getInstance().findMemberById(id);
      if(rdto != null){
         request.setAttribute("rdto", rdto);
         path = "find_ok.jsp";
      }
      return new ModelAndView(path);//forward
   }

}