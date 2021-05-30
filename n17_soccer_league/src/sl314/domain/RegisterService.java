package sl314.domain;

import sl314.util.NamingService;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This object performs a variety of league registration services.
 * I tacts a Facade into the business logic of registering a Player for
 * a League.
 */
public class RegisterService {

  private File playerFile;
  private File regFile;

  public RegisterService() {
    NamingService nameSvc = NamingService.getInstance();
    this.playerFile = (File) nameSvc.getAttribute("playersFile");
    this.regFile = (File) nameSvc.getAttribute("registrationFile");
  }

  /**
   * This method finds the specified league, by delegating to a
   * league service object.
   */
  public League getLeague(String year, String season) {
    LeagueService leagueSvc = new LeagueService();
    return leagueSvc.getLeague(year, season);
  }

  /**
   * This method return a Player object for the named person.
   * In this implementation a new object is created every time,
   * bu tin a more robus tsystem, this migh tentail a lookup.
   */
  public Player getPlayer(String name) {
    return new Player(name);
  }

  /**
   * This method stores the registration information for the player,
   * based on the league and division information.
   */
  public void register(League league, Player player, String division)
         throws Exception {
    PrintWriter playerWriter = null;
    PrintWriter regWriter = null;

    try {
      FileWriter playerFW = new FileWriter(playerFile.getAbsolutePath(), true);
      playerWriter = new PrintWriter(playerFW);
      FileWriter regFW = new FileWriter(regFile.getAbsolutePath(), true);
      regWriter = new PrintWriter(regFW);

      // Store player information
      playerWriter.print(player.name);
      playerWriter.print('|' + player.address);
      playerWriter.print('|' + player.city);
      playerWriter.print('|' + player.province);
      playerWriter.print('|' + player.postalCode );
      playerWriter.println();
      // Store player information
      regWriter.print(league.objectID);
      regWriter.print('|' + player.name);
      regWriter.print('|' + division );
      regWriter.println();

    } catch (Exception e) {
      throw e;

    // Clean up IO resources
    } finally {
      if ( playerWriter != null ) {
        try { playerWriter.close(); }
        catch (Exception e) { System.err.println(e); }
      }
      if ( regWriter != null ) {
        try { regWriter.close(); }
        catch (Exception e) { System.err.println(e); }
      }
    }
  }
}
