package lab_1;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lab_2.TXTSerializer;

import java.util.Objects;
import java.util.Set;

public class Coach implements TXTSerializer<Coach>{

    @Min(value = 0, message = "but id must be more than 0")
    private int id;
    @Size(min = 3, max=70, message = "but length name must be between 3 and 70")
    private String fullName;
    @Pattern(regexp = "^\\+(\\d[()]?){12}$", message = "Phone number is incorrect")
    private String phoneNumber;
    private String address;
    private String workout;

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

    public String getWorkout() {
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

        public Builder setWorkout(String workout) {
            newCoach.workout = workout;
            return this;
        }
        public Coach build()  {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Coach>> violations = validator.validate(newCoach);
            StringBuilder errors = new StringBuilder();
            for(ConstraintViolation<Coach> violation:violations){
                errors.append(violation.getPropertyPath()+" = "+violation.getInvalidValue()+" - "+violation.getMessage());
            }
            if(!errors.isEmpty()){
                try {
                    throw  new IllegalAccessException(errors.toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return newCoach;
        }
    }

    @Override
    public String toString() {
        return "Coach{"+
                "id= "+id +
                " fullName= " + fullName +
                " phoneNumber= " + phoneNumber +
                " address= " + address +
                " workout= " + workout+ " }";
    }

    public String toStringTXT() {
        return "{"+
                "id="+id +
                ", fullName=" + fullName +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", workout=" + workout+ ", }";
    }
    public Coach fromStringTXT( String line,Class<Coach> generic) {
        String[] valueFromTXT = line.split(",");
        String[] value = new String[valueFromTXT.length];
        int i=0;
        for(String v : valueFromTXT){
            if(v.indexOf('=')!=-1)
                value[i++]=v.substring(v.indexOf('=')+1, v.length());
        }
        Coach coach = new Coach();
        coach.id= Integer.parseInt(value[0]);
        coach.fullName = value[1];
        coach.phoneNumber = value[2];
        coach.address = value[3];
        coach.workout = value[4];
        return coach;
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
