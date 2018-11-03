package entiy;

public class User {
    private int userid;
    private String username;
    private String pwd;
    private int type_;

    public User() {
    }

    public User(int userid, String username, String pwd, int type_) {
        this.userid = userid;
        this.username = username;
        this.pwd = pwd;
        this.type_ = type_;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type_=" + type_ +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType_() {
        return type_;
    }

    public void setType_(int type_) {
        this.type_ = type_;
    }
}
