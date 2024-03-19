package starter.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesValues{
    public String filePath;
    public ReadPropertiesValues(String filePath) {
        this.filePath=filePath;
    }
    public String readProperty(String propKey) throws Exception {
        String propVal="";
        try {
            int check=0;
            while(check==0) {
                File readPropFile = new File(filePath);
                if(readPropFile.exists()) {
                    Properties prop = new Properties();
                    FileInputStream fis = new FileInputStream(readPropFile);
                    prop.load(fis);
                    propVal=prop.getProperty(propKey);
                    check=1;
                }
                else {
                    check=0;
                }
            }

        }catch (Exception e) {
    System.out.print("Exception in readProperty: "+e.getMessage());
        }
        return propVal;
    }
}
