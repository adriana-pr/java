package lab_1;

import java.util.List;
import java.util.Objects;

public class FitnessRoom {
    private int id;
    private String address;
    private String phoneNumber;
    private List<Workout> workouts;
    private List<Coach> coachs;

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static class Builder {
        private FitnessRoom newFitnessRoom;


        public Builder() {
            newFitnessRoom = new FitnessRoom();
        }

        public Builder setId(int id) {
            newFitnessRoom.id = id;
            return this;
        }

        public Builder setAddress(String address) {
            newFitnessRoom.address = address;
            return this;
        }

        public Builder setWotkouts(List<Workout> wotkouts) {
            newFitnessRoom.workouts = wotkouts;
            return this;
        }

        public Builder setCoachs(List<Coach> coachs) {
            newFitnessRoom.coachs = coachs;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            newFitnessRoom.phoneNumber = phoneNumber;
            return this;
        }

        public FitnessRoom build() {
            return newFitnessRoom;
        }
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id= " + id +
                " address= " + address +
                " phoneNumber= " + phoneNumber +
                " wotkouts= " + workouts +
                " coachs= " + coachs + " }";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;
        FitnessRoom newFitnessRoom = (FitnessRoom) o;

        return Objects.equals(id, newFitnessRoom.id)
                && Objects.equals(address, newFitnessRoom.address)
                && Objects.equals(phoneNumber, newFitnessRoom.phoneNumber);
    }

    public int hashCode() {
        return Objects.hash(id, address, phoneNumber);
    }
}
