package lab_1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lab_2.TXTSerializer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

public class Workout implements TXTSerializer<Workout>,Comparable<Workout> {
    @Min(value = 1, message = "but id must be more than 0")
    private int id;
    @Size(min = 3, max=70, message = "but length name must be between 3 and 70")

    private String name;
    private float price;
    private LocalDate date;
    private LocalTime time;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }


    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Workout o) {
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        }
        else {
            return (int) (this.price - o.price);
        }
    }


    public static class Builder {
        private Workout newWorkout;


        public Builder() {
            newWorkout = new Workout();
        }

        public Builder setId(int id) {
            newWorkout.id = id;
            return this;
        }

        public Builder setName(String name) {
            newWorkout.name = name;
            return this;
        }

        public Builder setPrice(float price) {
            newWorkout.price = price;
            return this;
        }

        public Builder setDate(LocalDate date) {
            newWorkout.date = date;
            return this;
        }

        public Builder setTime(LocalTime time) {
            newWorkout.time = time;
            return this;
        }

        public Workout build() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Workout>> violations = validator.validate(newWorkout);
            StringBuilder errors = new StringBuilder();
            for(ConstraintViolation<Workout> violation:violations){
                errors.append(violation.getPropertyPath()+" = "+violation.getInvalidValue()+" - "+violation.getMessage());
            }
            if(!errors.isEmpty()){
                try {
                    throw  new IllegalAccessException(errors.toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return newWorkout;
        }
    }

    @Override
    public String toString() {
        return "Workout{"+
                " id="+id +
                ", name=" + name +
                ", price=" + price +
                ", date=" + date +
                ", time=" + time+ ", }";
    }

    public String toStringTXT() {
        return "{ "+
                " id="+id +
                ", name=" + name +
                ", price=" + price +
                ", date=" + date +
                ", time=" + time+ ", }";
    }

    public Workout fromStringTXT( String line,Class<Workout> generic) {
        String[] valueFromTXT = line.split(" ");
        String[] value = new String[valueFromTXT.length];
        int i=0;
        for(String v : valueFromTXT){
            if(v.indexOf('=')!=-1)
                value[i++]=v.substring(v.indexOf('=')+1,v.indexOf(','));
        }
        Workout workout = new Workout();
        workout.id= Integer.parseInt(value[0]);
        workout.name = value[1];
        workout.price = Float.parseFloat(value[2]);
        workout.date = LocalDate.parse(value[3]);
        workout.time = LocalTime.parse(value[4]);
        return workout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;
        Workout newWorkout = (Workout) o;

        return Objects.equals(id, newWorkout.id)
                && Objects.equals(name, newWorkout.name)
                && Objects.equals(price, newWorkout.price)
                && Objects.equals(time, newWorkout.time);
    }

    public int hashCode() {
        return Objects.hash(id, name, price, time);
    }

}
