package lab_1;

import java.util.Objects;

public class Coach {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Workout workout;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Workout getWorkout() {
        return workout;
    }


    public static class Builder {
        private Coach newCoach;


        public Builder() {
            newCoach = new Coach();
        }

        public Builder setId(int id) {
            newCoach.id = id;
            return this;
        }

        public Builder setFullName(String fullName) {
            newCoach.fullName = fullName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            newCoach.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            newCoach.address = address;
            return this;
        }

        public Builder setWorkout(Workout workout) {
            newCoach.workout = workout;
            return this;
        }
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + phoneNumber + " " + address + " " + workout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;
        Coach newCoach = (Coach) o;

        return Objects.equals(id, newCoach.id)
                && Objects.equals(fullName, newCoach.fullName)
                && Objects.equals(phoneNumber, newCoach.phoneNumber)
                && Objects.equals(address, newCoach.address)
                && Objects.equals(workout, newCoach.workout);
    }

    public int hashCode() {
        return Objects.hash(id, fullName, phoneNumber, address, workout);
    }

}
