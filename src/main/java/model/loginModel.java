package model;

public class loginModel {

    private String uname;
    private String pass;
    private String utype;

    public loginModel(String uname, String pass, String utype) {
        this.uname = uname;
        this.pass = pass;
        this.utype = utype;

    }

    public String getUname() {
        return uname;

    }

    public String getPass() {
        return pass;
    }

    public String getUtype() {
        return utype;
    }

    @Override
    public String toString() {
        return this.uname;
    }

}
