package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    boolean isExistUser(String fName, String lName);
    void dropTable();
    User getUserByCar(String carName, String carSeries);
}
