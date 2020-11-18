package data;

import lombok.Value;

public class Data {
    private Data() {

    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("selenium", "super_password");
    }

    @Value
    public static class AddInfo {
        private String title;
        private String slug;
        private String textMd;
        private String text;
    }

    public static AddInfo getAddInfo() {
        return new AddInfo("Title43565463456", "Slug43565463456", "Slug43565463456", "Slug43565463456");
    }
}
