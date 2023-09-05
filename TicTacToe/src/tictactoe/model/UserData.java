package tictactoe.model;

public class UserData {
    public UserData(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    String UserName;
}
