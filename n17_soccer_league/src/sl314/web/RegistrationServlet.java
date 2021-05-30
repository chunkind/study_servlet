package sl314.web;

// Business Logic Component imports
import sl314.domain.RegisterService;
import sl314.domain.League;
import sl314.domain.Player;
// Servlet imports
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// Support classes
import sl314.util.Status;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Iterator;

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
      generateErrorResponse(request, response);
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
      generateErrorResponse(request, response);
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
      generateErrorResponse(request, response);
      return;
    }

    // Now delegate the real work to the RegisterService object
    try {
      registerSvc.register(league, player, division);

    // Catch any error and send it to the 'Error Page' View
    } catch (Exception e) {
      status.addException(e);
      generateErrorResponse(request, response);
      return;
    }

    // The registration process was successful,
    // generate the 'Thank You' View
    generateThankYouResponse(request, response);
    // This user's session is complete.
    session.invalidate();
  }

  /**
   * This method implements the 'Thank You' View.
   */
  public void generateThankYouResponse(HttpServletRequest request,
                                       HttpServletResponse response)
         throws IOException {
    // Retrieve the HttpSession object
    HttpSession session = request.getSession();

    // Specify the content type is HTML
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    League league = (League) session.getAttribute("league");
    Player player = (Player) session.getAttribute("player");

    // Generate the HTML response
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Registration: Thank You</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='white'>");
    out.println("<TABLE BORDER='0' WIDTH='600'>");
    out.println("<TR>");
    out.println("  <TD COLSPAN='2' BGCOLOR='#CCCCFF' ALIGN='center'>");
    out.println("    <H3>Registration: Thank You</H3>");
    out.println("  </TD>");
    out.println("</TR>");
    out.println("</TABLE>");
    out.println();
    out.println("<BR>");
    out.println("Thank you, " + player.getName() + ", for registering");
    out.println("in the <B>" + league.getTitle() + "</B> league.");
    out.println();
    out.println("</BODY>");
    out.println("</HTML>");
  }

  /**
   * This method implements the 'Form Errors' View.
   */
  public void generateErrorResponse(HttpServletRequest request,
                                    HttpServletResponse response)
         throws IOException {

    // Retrieve the status object from the reques tobject
    Status status = (Status) request.getAttribute("status");

    // Specify the content type is HTML
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Generate the HTML response
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Registration: Form Errors</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='white'>");
    out.println("<TABLE BORDER='0' WIDTH='600'>");
    out.println("<TR>");
    out.println("  <TD COLSPAN='2' BGCOLOR='#CCCCFF' ALIGN='center'>");
    out.println("    <H3>Registration: Form Errors</H3>");
    out.println("  </TD>");
    out.println("</TR>");
    out.println("</TABLE>");
    out.println();
    out.println("<BR>");
    out.println("There were problems processing your request:");
    out.println("<FONT COLOR='red'>");
    out.println("<UL>");
    Iterator errors = status.getExceptions();
    while ( errors.hasNext() ) {
      Exception ex = (Exception) errors.next();
      out.println("  <LI> " + ex.getMessage());
    }
    out.println("</UL>");
    out.println("</FONT>");
    out.println("Please, back up and try again.");
    out.println("</BODY>");
    out.println("</HTML>");
  }
}
