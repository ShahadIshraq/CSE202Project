package CommonClasses;

import java.io.Serializable;

/**
 * Created by ABIR BINDU on 12/14/2015.
 */
public class Contributor implements Serializable{
    private String name;
    private String password;

    public Contributor()
    {
        password="";
        name="";
    }
    public Contributor(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
