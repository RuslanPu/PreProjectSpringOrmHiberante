package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    @Column(name="name")
    private String name;

    @Column(name="series")
    private String series;



    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }


    public Car() { };

    public Car(String name, String series) {
        this.name = name;
        this.series = series;
    }


    public Car(Long id, String name, String series) {
        this.Id = id;
        this.name = name;
        this.series = series;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(series, car.series) &&
                Objects.equals(Id, car.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, series, Id);
    }

}
