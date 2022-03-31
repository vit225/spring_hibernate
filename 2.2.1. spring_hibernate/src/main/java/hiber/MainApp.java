package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Василий", "Петров", "vasiliy@mail.ru");
      User user2 = new User("Иван", "Иванов", "ivan@mail.ru");
      User user3 = new User("Степан", "Андреев", "stepan@mail.ru");

      Car car1 = new Car("Toyota", 323);
      Car car2 = new Car("Nissan", 25);
      Car car3 = new Car("Mazda", 67);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getUserByCar("Toyota", 323));

      context.close();
   }
}
