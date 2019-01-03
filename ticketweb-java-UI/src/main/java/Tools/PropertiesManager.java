package Tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesManager {
	
	public static String GetValueByKeyAndFilePath(String filePath, String key) {
        Properties pps = new Properties();
        try {
            InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
            pps.load(in);
            String value = pps.getProperty(key);
//            System.out.println(key + " = " + value);
            return value;
            
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	public static String GetValueByKey(String key) {
		String filePath = "D:\\EclipseWorkspace\\zhengAlam\\src\\main\\resources\\config.properties";
        Properties pps = new Properties();
        try {
            InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
            pps.load(in);
            String value = pps.getProperty(key);
//            System.out.println(key + " = " + value);
            return value;
            
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void GetAllProperties(String filePath) throws IOException {
        Properties pps = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(filePath));
        pps.load(in);
        Enumeration<?> en = pps.propertyNames(); 
        
        while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
        
    }
    
    public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
        Properties pps = new Properties();
        
        InputStream in = new FileInputStream(filePath);
        pps.load(in);
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        pps.store(out, "Update " + pKey + " name");
    }
    public static void WriteProperties (String pKey, String pValue) throws IOException {
    	String filePath = "D:\\\\EclipseWorkspace\\\\zhengAlam\\\\src\\\\main\\\\resources\\\\config.properties";
        Properties pps = new Properties();
        
        InputStream in = new FileInputStream(filePath);
        pps.load(in);
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        pps.store(out, "Update " + pKey + " name");
    }
    
    
    public static void main(String [] args) throws IOException{
    	
    	System.out.println("   vvvvvvvvvvvvvvvvvvvvvvvvvvvv  GetValueByKeyAndFilePath  vvvvvvvv");
        String value = GetValueByKeyAndFilePath("D:\\EclipseWorkspace\\zhengAlam\\src\\main\\resources\\config.properties", "T4_login_name");
        System.out.println(value);
       
    	System.out.println("   vvvvvvvvvvvvvvvvvvvvvvvvvvvv  GetValueByKey  vvvvvvvv");
        String valueQA1 = GetValueByKey("T4_login_name");
        System.out.println(valueQA1);
        
//        System.out.println("   vvvvvvv  WriteProperties  vvvvvvvv");
//        WriteProperties("test", "test212");
        
        System.out.println("   vvvvvvvvvvvvvvvvvvvvvvvvvvvv  GetAllProperties  vvvvvvvv");
        GetAllProperties("D:\\EclipseWorkspace\\zhengAlam\\src\\main\\resources\\config.properties");
//        WriteProperties("D:\\EclipseWorkspace\\zhengAlam\\src\\main\\resources\\config.properties","test", "test212");
        
    }

}