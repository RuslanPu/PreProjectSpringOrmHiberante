package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sound.midi.SysexMessage;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car5 = new Car("car5","series5");
      User user5 = new User("User5","LastName5","user5@mail.ru");
      user5.setCar(car5);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(user5);

      List<User> users = userService.listUsers();

      User user6 = userService.getUserByCar("car5","series5");

      for (User user : users) {
         System.out.println(user.toString());

      }
      System.out.println("UserByCar "+user6.toString());
      System.out.println("UserByCar notExistCar "+userService.getUserByCar("car6","series6"));
      context.close();
   }
}
