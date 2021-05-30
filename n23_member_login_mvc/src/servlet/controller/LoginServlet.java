package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*
       * 1. 폼에 있는 값을 받아온다.
       * 2. dao 생성
       * 3. 비지니스 로직 호출하면서 dto 리턴
       * 4. 세션에 넣는다. dto를!
       * 5. 페이지이동
       */
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      MemberDAO dao = MemberDAO.getInstance();
      String path = "login_fail.jsp";
      try{
         MemberDTO rdto = dao.loginMember(id, password);
         if(rdto != null){ //디비에 아이디와 패스워드가 다 잇다
            HttpSession session = request.getSession();
            session.setAttribute("rdto", rdto);
            path = "login_ok.jsp";
         }
      }catch(Exception e){
         e.printStackTrace();
      }
      request.getRequestDispatcher(path).forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}