package services;


import model.User;


public class UserSessionService {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserSessionService.currentUser = currentUser;
    }
}
