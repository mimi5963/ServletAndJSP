package Collection;

import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) {
        Properties pro = new Properties();

        try {
            pro.load(PropertiesEx.class.getResourceAsStream("Properties.properties"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        //주어진 키에 대한 값 읽기
        String driver = pro.getProperty("diver");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String admin = pro.getProperty("admin");

        //값 출력
        System.out.println("driver: "+ driver);
        System.out.println("url :" + url);
        System.out.println("usrname : "+username);
        System.out.println("password : "+password);
        System.out.println("admin : "+admin);



    }


}


