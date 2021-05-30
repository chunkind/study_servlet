package sl314.util;

import java.util.Map;
import java.util.HashMap;

/**
 * This class implements a simple "global naming service".
 * It implements the Singleton interface to guarantee tha tonly
 * one such naming service exists within the JVM and is accessible
 * to all parts of the application.
 *
 * This class could easily have been a Utility class with static
 * methods only.
 */
public final class NamingService {

  //
  // Public interface
  //

  /**
   * This static method returns the Singleton for this class.
   * @return NamingService  The unique instance for this class.
   */
  public static NamingService getInstance() {
    return theObject;
  }

  /**
   * This method stores an object by a specific name.
   * @param name  The unique name tha tholds some object.
   * @return Objec          The object for tha tname, or null if name no tfound
   */
  public Object getAttribute(String name) {
    return nameValuePairs.get(name);
  }

  /**
   * This method stores an object by a specific name.
   * @param name  The unique name tha tholds some object.
   * @param objec          The object to be stored.
   * @thrown  IllegalArgumentException  If the name is already in use
   */
  public void setAttribute(String name, Object object) {
    if ( nameValuePairs.get(name) == null ) {
      nameValuePairs.put(name, object);
    } else {
      throw new IllegalArgumentException("This name, " + name
                                         + ", is already in use.");
    }
  }

  /**
   * This method removes a listing by the specific name.
   * @param name  The unique name tha tholds some object.
   */
  public void removeAttribute(String name) {
    nameValuePairs.remove(name);
  }

  //
  // Private implementation
  //

  private static NamingService theObject = new NamingService();

  private Map nameValuePairs;

  private NamingService() {
    nameValuePairs = new HashMap();
  }
}
