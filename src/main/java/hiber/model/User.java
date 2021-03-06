package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")

public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   private Long id;


   @Column(name = "name")
   private String firstName;


   @Column(name = "last_name")
   private String lastName;


   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name="car_id", unique = true, nullable = false, updatable = false)
   private Car car;





   public User() {}



   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }



   public Car getCar() { return this.car; }

   public void setCar(Car car) {
      this.car = car;
   }



   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(id, user.id) &&
              Objects.equals(firstName, user.firstName) &&
              Objects.equals(lastName, user.lastName);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName);
   }

   @Override
   public String toString() {
      String carName;
      String carSeries;
      if (car!=null) {
        carName = car.getName();
        carSeries = car.getSeries();
      } else {
        carName = "haven't car";
        carSeries = "haven't car";
      }
      return "User" +
              "id = " + id +
              ", firstName = '" + firstName + '\'' +
              ", lastName = '" + lastName + '\'' +
              ", email = '" + email + '\'' +
              ", car { = " + carName +  " " + carSeries + '}' +
              '\n';
   }
}
