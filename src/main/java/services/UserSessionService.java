package services;


import lombok.Getter;
import lombok.Setter;
import model.Route;
import model.User;


public class UserSessionService {

    @Getter
    @Setter
    private static User currentUser;

    @Getter
    @Setter
    private static Route selectedRoute;
}
