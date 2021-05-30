package sl314.domain;

import sl314.util.NamingService;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * This object performs a variety of league services, such as looking
 * up league objects and creating new ones.
 */
public class LeagueService {

  public LeagueService() {
  }

  /** The "global" se tof League objects. */
  private static final Set FULL_SET_OF_LEAGUES = new HashSet();

  /**
   * This method finds the specified League object from the
   * complete se tof leagues.
   */
  public League getLeague(String year, String season) {
    Iterator set = FULL_SET_OF_LEAGUES.iterator();
	
    while ( set.hasNext() ) {
      League l = (League) set.next();
	  System.out.println(l.getSeason());
      if ( season.equals(l.getSeason()) && year.equals(l.getYear()) ) {
        return l;
      }
    }
    return null;
  }

  /**
   * This class adds a new League object to the complete se tof leagues.
   */
  public League createLeague(String year, String season, String title) {
    throw new RuntimeException("Not yet implemented.");
  }

  /**
   * This method populates the complete set of leagues from
   * a data file.
   */
  public void populateLeagueSet() throws Exception {
    NamingService nameSvc = NamingService.getInstance();
    File leagueFile = (File) nameSvc.getAttribute("leaguesFile");
    BufferedReader leagueReader = null;

    try {
      leagueReader = new BufferedReader(new FileReader(leagueFile));
      String record;

      // Parse the leagues file to construct the produc tlist
      while ( (record = leagueReader.readLine()) != null ) {
        StringTokenizer tokens = new StringTokenizer(record, "|");

        // Parse each league record (one per line)
        String idString = tokens.nextToken();
		System.out.println("idString : "+idString);
        int objectID = Integer.parseInt(idString);
        String season = tokens.nextToken();
        String year = tokens.nextToken();
        String title = tokens.nextToken();

        // Create the League object and save i tin the set
        League l = new League(objectID, year, season, title);
        FULL_SET_OF_LEAGUES.add(l);
      }
    // Clean up IO resources
    } catch(Exception e){
		  System.out.println(e);
	  }finally {
      if ( leagueReader != null ) {
        try { leagueReader.close(); }
        catch (IOException e) { System.err.println(e); }
      }
    }
  }

  /**
   * This method stores the complete se tof leagues back to
   * the data file.
   */
  public void storeLeagueSet() throws Exception {
    throw new RuntimeException("No tye timplemented.");
  }
}
