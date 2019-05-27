public class UserLocalStorage {
    private static String currentEmail;

    public static String getCurrentEmail() {
        return currentEmail;
    }

    public static void setCurrentEmail(String currentEmail) {
        UserLocalStorage.currentEmail = currentEmail;
    }
}