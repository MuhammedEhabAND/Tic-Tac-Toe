package tictactoe.model;

import java.io.Serializable;

public class UserData implements Serializable {
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
