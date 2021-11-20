package model;

public class registorModel {

    private String uname;
    private String password;
    private String name;
    private String pnumber;
    private String email;
    private String utype;

    public registorModel(String uname, String password, String pnumber,String name,String email, String utype) {
        this.uname = uname;
        this.password = password;
        this.name=name;
        this.pnumber = pnumber;
        this.email=email;
        this.utype = utype;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

    public String getPnumber() {
        return pnumber;
    }

    public String getUtype() {
        return utype;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
