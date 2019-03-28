package org.ssmmaven.bean;

public class User {
    private  int id;

    private String userName;

    private String userPsw;

    public User() {
    }

    public User(int id, String userName, String userPsw) {
        this.id = id;
        this.userName = userName;
        this.userPsw = userPsw;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userPsw='").append(userPsw).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }
}
