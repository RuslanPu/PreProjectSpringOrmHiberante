package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
      return query.getResultList();
   }

   public boolean isExistUser(String fName,String lName) {
      return listUsers()
              .stream()
              .anyMatch((e) -> e.getFirstName().equals(fName) && e.getLastName().equals(lName));
   }

   @Override
   public void dropTable() {
      sessionFactory.getCurrentSession().createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
   }

   @Override
   public User getUserByCar(String carName, String carSeries) {
      if (isExistCar(carName,carSeries)) {
            List<Car> listCar= new ArrayList<>();
            listCar = listCar().stream()
                    .filter((e)->e.getName().equals(carName) && e.getSeries().equals(carSeries))
                    .collect(Collectors.toList());
            Long carId = listCar.get(0).getId();

         List listUser = new ArrayList<>();
           listUser = sessionFactory.getCurrentSession().createQuery("FROM User WHERE car_id = :paramId")
                 .setParameter("paramId", carId)
                 .list();
         return (User) listUser.get(0);

      }
      return null;
   }

   @Override
   public boolean isExistCar(String carName, String carSeries) {
      return listCar().stream()
              .anyMatch((e) -> e.getName().equals(carName) && e.getSeries().equals(carSeries));
   }

   @Override
   public List<Car> listCar() {
      Query query=sessionFactory.getCurrentSession().createQuery("FROM Car");
      return query.getResultList();
   }


}
