package model;

/**
 *
 * @author Admin
 */
public class Admin {
    private  int id;
    private String password;
    private  String sQues;
    private String ans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsQues() {
        return sQues;
    }

    public void setsQues(String sQues) {
        this.sQues = sQues;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    
    
}
