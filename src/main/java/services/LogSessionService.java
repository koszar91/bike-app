package services;


import model.User;

public class LogSessionService {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        LogSessionService.currentUser = currentUser;
    }
}
