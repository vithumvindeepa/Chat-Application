package model;

public class UserName {
    private String USERNAME;

    public UserName() {
    }

    public UserName(String USERNAME) {
        this.setUSERNAME(USERNAME);
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "USERNAME='" + USERNAME + '\'' +
                '}';
    }
}

