package business;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Admin {

    @Id
    private String adminID;

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminid) {
        this.adminID = adminid;
    }

    @Basic
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    private String passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
