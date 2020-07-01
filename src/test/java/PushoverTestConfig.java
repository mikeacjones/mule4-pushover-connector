public class PushoverTestConfig {
    public static String applicationToken() {
        String applicationToken = System.getenv("pushover.applicationToken");
        if (applicationToken != null) return applicationToken;
        return LocalTestCredentials.applicationToken;
    }
    public static String userToken() {
        String userToken = System.getenv("pushover.userToken");
        if (userToken != null) return userToken;
        return LocalTestCredentials.userToken;
    }
    public static String title() {
        String title = System.getenv("pushover.title");
        if (title != null) return title;
        return LocalTestCredentials.title;
    }
    public static String message() {
        String message = System.getenv("pushover.message");
        if (message != null) return message;
        return LocalTestCredentials.message;
    }
}