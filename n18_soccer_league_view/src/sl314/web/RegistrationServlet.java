package sl314.web;

// Business Logic Componen timports
import java.io.IOException;

import javax.servlet.RequestDispatcher;
// Servlet imports
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sl314.domain.League;
import sl314.domain.Player;
import sl314.domain.RegisterService;
// Support classes
import sl314.util.Status;

public class RegistrationServlet extends HttpServlet {

  public static final String ACTION_SELECT_LEAGUE   = "SelectLeague";
  public static final String ACTION_ENTER_PLAYER    = "EnterPlayer";
  public static final String ACTION_SELECT_DIVISION = "SelectDivision";

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException {

    String action = request.getParameter("action");

    if ( action.equals(ACTION_SELECT_LEAGUE) ) {
      processSelectLeague(request, response);

    } else if ( action.equals(ACTION_ENTER_PLAYER) ) {
      processEnterPlayer(request, response);

    } else if ( action.equals(ACTION_SELECT_DIVISION) ) {
      processSelectDivision(request, response);
    }
  }

  /**
   * This method performs the "Select League" action
   */
  public void processSelectLeague(HttpServletRequest request,
                                  HttpServletResponse response)
         throws IOException {
    // Create the HttpSession object
    HttpSession session = request.getSession();

    // Create business logic objects
    RegisterService registerSvc = new RegisterService();

    // Create the status object and store it in the request for use
    // by the 'Error Page' View (if necessary)
    Status status = new Status();
    request.setAttribute("status", status);

    // Extract HTML form parameters
    String season = request.getParameter("season");
    String year = request.getParameter("year");

    // Verify 'Select League' form fields
    if ( season.equals("UNKNOWN") ) {
      status.addException(new Exception("Please select a league season."));
    }
    if ( year.equals("UNKNOWN") ) {
      status.addException(new Exception("Please select a league year."));
    }

    // Retrieve the league object
    League league = registerSvc.getLeague(year, season);
    if ( league == null ) {
      status.addException(
        new Exception("The league you selected does not yet exist;"
                      + " please select another."));
    }

    // Generate the "Error Page" response and halt
    if ( ! status.isSuccessful() ) {
    	try{
      generateErrorResponse(request, response);
    	}catch(Exception e){
    		
    	}
      return;
    }

    // Store the league object in the session
    session.setAttribute("league", league);

    // Select the next View: "Enter Player" form
    response.sendRedirect("enter_player.html");
  }

  /**
   * This method performs the "Select League" action
   */
  public void processEnterPlayer(HttpServletRequest request,
                                 HttpServletResponse response)
         throws IOException {
    // Retrieve the HttpSession object
    HttpSession session = request.getSession();

    // Create business logic objects
    RegisterService registerSvc = new RegisterService();

    // Create the status object and store i tin the reques tfor use
    // by the 'Error Page' View (if necessary)
    Status status = new Status();
    request.setAttribute("status", status);

    // Extrac tHTML form parameters
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String city = request.getParameter("city");
    String province = request.getParameter("province");
    String postalCode = request.getParameter("postalCode");

    // Verify 'Enter Player Information' form fields
    if ( (name == null) || (name.length() == 0) ) {
      status.addException(new Exception("Please enter your name."));
    }
    if (   (address == null)    || (address.length() == 0)
        || (city == null)       || (city.length() == 0)
        || (province == null)   || (province.length() == 0)
        || (postalCode == null) || (postalCode.length() == 0) ) {
      status.addException(new Exception("Please enter your full address."));
    }

    // Generate the "Error Page" response and halt
    if ( ! status.isSuccessful() ) {
    	try{
      generateErrorResponse(request, response);
    	}catch(Exception e){
    		
    	}
      return;
    }

    // Create and populate the player object
    Player player = registerSvc.getPlayer(name);
    player.setAddress(address);
    player.setCity(city);
    player.setProvince(province);
    player.setPostalCode(postalCode);

    // Store the player object in the session
    session.setAttribute("player", player);

    // Select the nex tview: "Select Division" form
    response.sendRedirect("select_division.html");
  }

  /**
   * This method performs the "Select Division" action
   */
  public void processSelectDivision(HttpServletRequest request,
                                    HttpServletResponse response)
         throws IOException {
    // Retrieve the HttpSession object
    HttpSession session = request.getSession();

    // Retrieve the domain object from the session
    League league = (League) session.getAttribute("league");
    Player player = (Player) session.getAttribute("player");

    // Create business logic objects
    RegisterService registerSvc = new RegisterService();

    // Create the status object and store i tin the reques tfor use
    // by the 'Error Page' View (if necessary)
    Status status = new Status();
    request.setAttribute("status", status);

    // Extrac tHTML form parameters
    String division = request.getParameter("division");

    // Verify 'Select Division' form fields
    if ( division.equals("UNKNOWN") ) {
      status.addException(new Exception("Please select a division."));
    }

    // If there were verification problems,
    // then generate the "Error Page" response and halt
    if ( ! status.isSuccessful() ) {
    	try{
      generateErrorResponse(request, response);
    	}catch(Exception e ){
    		
    	}
      return;
    }

    // Now delegate the real work to the RegisterService object
    try {
      registerSvc.register(league, player, division);

    // Catch any error and send it to the 'Error Page' View
    } catch (Exception e) {
      status.addException(e);
      try{
      generateErrorResponse(request, response);
      }catch(Exception ee){
    	  
      }
      return;
    }

    // The registration process was successful,
    // generate the 'Thank You' View
    try{
    generateThankYouResponse(request, response);
    }catch(Exception e){
    	
    }
    // This user's session is complete.
  }

  /**
   * This method implements the 'Thank You' View.
   * ThankYouResponse.jsp로 이동
   */
  public void generateThankYouResponse(HttpServletRequest request,
                                       HttpServletResponse response)
         throws Exception {
	  RequestDispatcher rdp = request.getRequestDispatcher("ThankYouResponse.jsp");
	  rdp.forward(request, response);
   
  }

  /**
   * This method implements the 'Form Errors' View.
   * errorRespons.jsp로 이동
   */
  public void generateErrorResponse(HttpServletRequest request,
                                    HttpServletResponse response)
         throws Exception {
	  RequestDispatcher rdp = request.getRequestDispatcher("errorRespons.jsp");
	  rdp.forward(request, response);
   
  }
}
