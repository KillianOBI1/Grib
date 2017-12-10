package parseur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParsingGrib {
  private final String input = "ressources/TLLsOTxTsoSYmtRzKDl0e75I4HAjqqDApv_.grb";
  private final String output = "ressources/Result.txt";
  Grib b;
  
  public ParsingGrib() {
    super();
  }
  
  /**
   * Re a grib.
   * @return the content of the Grib file.
   */
  public byte[] readFile() {
    try {
      Path p = Paths.get(this.input);
      return Files.readAllBytes(p);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Parsing the grib.
   * @param b the byte tab
   */
  public void parseByte(byte[] b) {
    for (byte e : b) {
      System.out.println(e);
    }
  }
  
  /**
   * Export the result of the grib reader.
   */
  public void exportByte() {
    try {
      Path path = Paths.get(this.output);
      Files.write(path,this.readFile());
      File f = new File("ressources/resultToString.txt");
      FileWriter fw = new FileWriter(f);
      for (byte b : this.readFile()) {
        String r = b + "";
        fw.write(r);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
