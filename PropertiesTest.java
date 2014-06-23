import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args)
         throws Exception {

      // set up new properties object from file "myProperties.txt"
      FileInputStream propFile =
            new FileInputStream( System.getProperty("user.home") + "/Documents/myProperties.txt");
      Properties p = new Properties(System.getProperties());
      p.load(propFile);

      p.list(System.out);

   }
}
