package ConfigurationClass;

import java.io.FileReader;
import java.util.Properties;

public class ConfigurationData {
    static Properties prop;
    public static void setConfiguration(){
        try{
            String path=System.getProperty("user.dir")+"\\ConfigurationFiles\\configuration.properties";
            FileReader file=new FileReader(path);
            prop=new Properties();
            prop.load(file);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getBrowserName(){
        return(prop.getProperty("browser"));
    }
    public static String getURL(){
        return(prop.getProperty("URL"));
    }
    public static String productToBeSearch(){
        return(prop.getProperty("searchProduct"));
    }
}
