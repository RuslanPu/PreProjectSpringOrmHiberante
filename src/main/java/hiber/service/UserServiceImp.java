package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      if(!isExistUser(user.getFirstName(),user.getLastName())){
         userDao.add(user);
      }

   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public boolean isExistUser(String fName, String lName) {
      return userDao.isExistUser(fName,lName);
   }

   @Transactional
   @Override
   public void dropTable() {
      userDao.dropTable();
   }

   @Transactional
   @Override
   public User getUserByCar(String carName, String carSeries) {
      return userDao.getUserByCar(carName,carSeries);
   }


}
