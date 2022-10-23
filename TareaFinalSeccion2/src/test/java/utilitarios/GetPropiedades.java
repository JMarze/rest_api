package utilitarios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropiedades {
    public static GetPropiedades instance = null;
    private String host;
    private String user;
    private String pwd;


    private GetPropiedades(){
        Properties properties = new Properties();
        String nameFile = "todo.propiedades";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);

        if(inputStream != null){
            try {
                properties.load((inputStream));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        host = properties.getProperty("host");
        user = properties.getProperty("user");
        pwd = properties.getProperty("pwd");
    }

    public static GetPropiedades getInstance(){
        if (instance == null)
            instance = new GetPropiedades();

        return instance;

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
