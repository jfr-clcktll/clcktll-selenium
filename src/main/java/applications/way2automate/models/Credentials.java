package applications.way2automate.models;

import org.openqa.selenium.By;

public class Credentials {

    public String username ;
    public String password ;
    public String url ;

    public Credentials(String user, String pass, String url) {

        this.username = user;
        this.password = pass;
        this.url = url;
    }
}
