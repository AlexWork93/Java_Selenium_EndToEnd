package AbstractHelpers;

public enum NotificationMessages {
    Product_Added_To_Cart("Product Added To Cart"),
    THANKYOU_FOR_THE_ORDER("THANKYOU FOR THE ORDER."),
    Login_Successfully("Login Successfully"),
    Incorrect_email_or_password("Incorrect email or password.");

    private final String message;

    NotificationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
