package enums;

public enum ErrorMsg {
    USER_LOCKED_OUT("Epic sadface: Sorry, this user has been locked out."),
    USERNAME_REQUIRED("Epic sadface: Username is required"),
    PASSWORD_REQUIRED("Epic sadface: Password is required");

    public final String displayName;

    ErrorMsg(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
