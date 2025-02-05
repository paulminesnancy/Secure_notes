package secure_notes.src.main.java.com.noteapp.models;

import secure_notes.src.main.java.com.noteapp.services.CryptoService;

public class User {
    private String UserName;
    private String Salt;
    // private CryptoService UserCryptoService;

    public void User(){};

    public void setUserName(String UserName){this.UserName = UserName;}
    public void setSalt(String Salt){this.Salt = Salt;}
    public String getUserName(){return this.UserName;}
    public String getSalt(){return this.Salt;}
}
