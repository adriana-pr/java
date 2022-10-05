package lab_1;

import java.util.Objects;

public class Workout {
    private int id;
    private String name;
    private float price;
    private String date;
    private String time;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


    public int getId() {
        return id;
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
            assert (price > 0) : "Price should be more than zero";
            newWorkout.price = price;
            return this;
        }

        public Builder setDate(String date) {
            newWorkout.date = date;
            return this;
        }

        public Builder setTime(String time) {
            newWorkout.time = time;
            return this;
        }

        public Workout build() {
            return newWorkout;
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + date + " " + time;
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
