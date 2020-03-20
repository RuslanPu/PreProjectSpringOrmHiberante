package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   boolean isExistUser(String fName,String lName);
   void dropTable();
   User getUserByCar(String carName, String carSeries);
   boolean isExistCar(String carName, String carSeries);
   List<Car> listCar();

}
