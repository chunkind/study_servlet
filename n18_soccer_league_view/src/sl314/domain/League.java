package sl314.domain;

/**
 * This domain object represents a player in a sports league.
 * The data attributes are all package-private to allow access to them
 * in the {@link RegisterService} class.
 */
public class League {

  int objectID;
  String year;
  String season;
  String title;

  League(int objectID, String year, String season, String title) {
    this.objectID = objectID;
    this.year = year;
    this.season = season;
    this.title = title;
  }

  public String getYear() {
    return year;
  }
  public String getSeason() {
    return season;
  }
  public String getTitle() {
    return title;
  }

  public String toString() {
    return title;
  }
}
