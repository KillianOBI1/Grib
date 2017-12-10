package src.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import ucar.ma2.Array;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

class testLibrary {

  @Test
  void test() {
    try {
      NetcdfFile ncf = NetcdfFile.open("ressources/20171209_125549_.grb"); //loading grib file
      System.out.println("Variable names are:");
      List<Variable> vars = ncf.getVariables();    //listing variables
      /*File f = new File("variablegrib.txt");
      FileWriter fw = new FileWriter(f);
      for (Variable var : vars) {
        fw.write(var.getFullName());
      }
      fw.close();*/
      String[] tab = vars.get(1).getFullName().split("/",0);
      Variable Uwind = ncf.findVariable(tab[0]+"/u-component_of_wind_height_above_ground");
      Variable Vwind = ncf.findVariable(tab[0]+"/v-component_of_wind_height_above_ground");
      Variable lat = ncf.findVariable(tab[0]+"/lat");
      Variable lon = ncf.findVariable(tab[0]+"/lon");
      Variable time = ncf.findVariable(tab[0]+"/time");
      Variable reftime = ncf.findVariable(tab[0]+"/reftime");
      Variable reftime_ISO = ncf.findVariable(tab[0]+"/reftime_ISO");
      Variable height_above_ground = ncf.findVariable(tab[0]+"/height_above_ground");
      Variable height_above_ground1 = ncf.findVariable(tab[0]+"/height_above_ground1");
      Variable Temperature_height_above_ground = ncf.findVariable(tab[0]+"/Temperature_height_above_ground");


      Array u_data = Uwind.read(); //reading variables to Array type
      Array v_data = Vwind.read();
      Array lat_data = lat.read();
      Array lon_data = lon.read();
      Array time_data = time.read();
      
      Array reftime_data = reftime.read();
      System.out.println(reftime_data);
      /*Array reftime_ISO_data = reftime_ISO.read();*/
      Array height_above_ground_data = height_above_ground.read();
      Array height_above_ground1_data = height_above_ground1.read();
      Array Temperature_height_above_ground_data = Temperature_height_above_ground.read();
     /* System.out.println("Reftime: " + reftime_data.getDouble(0));
      System.out.println("Hauteur: " + height_above_ground_data.getFloat(0));
      System.out.println("Hauteur1: " + height_above_ground1_data.getFloat(0));
      System.out.println("Interval: " + time_data.getDouble(0));*/
      System.out.println(lon_data.getSize());
      System.out.println(lat_data.getSize());
      Array [][] data = new Array[(int) lat_data.getSize()][(int) lon_data.getSize()];
      for (int i = 0; i < lat_data.getSize(); i++) { 
        for (int j = 0; j < lon_data.getSize(); j++) {
          data[i][j].setLong(0,lon_data.nextLong()); 
          data[i][j].setLong(1,lat_data.nextLong());
          data[i][j].setFloat(2,u_data.nextFloat());
          data[i][j].setFloat(3,v_data.nextFloat());
        }
      }
      
      for (int i = 0; i < lat_data.getSize(); i++) { 
        for (int j = 0; j < lon_data.getSize(); j++) {
          System .out.print("Lattitude :" + data[i][j].getLong(0));
          System .out.print("Longitude :" + data[i][j].getLong(1));
          System .out.print("U-Wind :" + data[i][j].getFloat(2));
          System .out.println("V-Wind :" + data[i][j].getFloat(3));
        }
      }
      
      /*for (int i = 0; i < lon_data.getSize(); i++) {
        for (int j = 0; j < lat_data.getSize(); j++) {
          System.out.println("Case numéro " + i);
          System.out.println("Vecteur u de vent: " + u_data.getFloat(i));
          System.out.println("Vecteur v de vent: " + v_data.getFloat(j));
          System.out.println("Longitude: " + lon_data.getFloat(i));
          System.out.println("Latitude: " + lat_data.getFloat(j));
      //  System.out.println("temperature: " + Temperature_height_above_ground_data.getFloat(i));
        }
      }*/
      ncf.close();
    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }

}
