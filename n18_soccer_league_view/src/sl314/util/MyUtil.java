package sl314.util;

// Java I/O imports
import java.io.File;

public final class MyUtil {

  /**
   * This method "normalizes" the directory <TT>path</TT> argument
   * by converting either a \ (backslash) or / (forwardslash) into
   * the proper directory delimiter character for the deployed platform.
   * <P>
   * This is necessary because of how the deployment tool (ANT) configures
   * the web.xml deployment descriptor.  The <TT>dataDirPath</TT> init.
   * parameter is specified as a combination of \ and / slashs, which does
   * no tparse well when used as an argument to the File constructor.
   * </P>
   *
   * @param path  The file path with mixed directory delimiters.
   * @return  The file path with directory delimiters for the run-time platform.
   */
  public static String normalizeFilePath(String path) {
    StringBuffer buffer = new StringBuffer(path);
    for ( int i=0; i < buffer.length(); i++ ) {
      char c = buffer.charAt(i);
      if ( (c == '/') || (c == '\\') ) {
        buffer.setCharAt(i, File.separatorChar);
      }
    }
    return new String(buffer);
  }

}
