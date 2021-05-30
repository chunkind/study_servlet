package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberDTO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO dao = MemberDAO.getInstance();	//이거 필드로 추가
	
	public static final String ACTION_ALLMEMBERSERVLET = "allMemberServlet";
    public static final String ACTION_FINDSERVLET = "findServlet";
    public static final String ACTION_IDCHECKSERVLET = "idCheckServlet";
    public static final String ACTION_LOGINSERVLET = "loginServlet";
    public static final String ACTION_LOGOUTSERVLET = "logoutServlet";
    public static final String ACTION_REGISTERSERVLET = "registerServlet";
    public static final String ACTION_UPDATESERVLET = "updateServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.Command값 받아온다.
		
		String command = request.getParameter("command");
		String path = "error.jsp";
		
		try{
			if(command.equals("find")){ //예전에 FindServlet이 동작했다.
				path = find(request, response);
			}else if(command.equals("login")){
				path = login(request, response);
			}else if(command.equals("register")){
				path = register(request, response);
			}else if(command.equals("update")){
				path = update(request, response);
			}else if(command.equals("allView")){
				path = allView(request, response);
			}else if(command.equals("logout")){
				path = logout(request, response);
			}else if(command.equals("idcheck")){
				path = idcheck(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}//doProcess
	
	public String find(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		MemberDTO rdto = dao.findMemberById(request.getParameter("id"));
		
		if(rdto != null){
			request.setAttribute("rdto", rdto);
			return "find_ok.jsp";
		}else{
			return "find_fail.jsp";
		}
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDTO rdto = dao.loginMember(id, password);
		if(rdto != null){
			HttpSession session = request.getSession();
			session.setAttribute("rdto", rdto);
			return "login_ok.jsp";
		}else{
			return "login_fail.jsp";
		}
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(id, password, name, address);
		dao.registerMember(dto);
		
		return "register_result.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberDTO dto = new MemberDTO(id, password, name, address);
		dao.updateMember(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("rdto", dto);
		
		return "update_result.jsp";
	}
	
	protected String allView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberDTO> list = dao.showAllMember();
		request.setAttribute("list", list);
		return "allView.jsp";
	}
	
	protected String idcheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO rdto = dao.findMemberById(request.getParameter("id"));
		boolean idExist = false;
		if(rdto != null){
			idExist = true;
		}
		request.setAttribute("idExist", idExist);
		return "idcheck.jsp";
	}

	protected String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("rdto") != null) {
			session.invalidate();
		}
		return "logout.jsp";
	}
}