package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.Set;

public class Soldier {
    protected String name;
    protected String surName;
    protected String middleName;
    protected int age;

    public Soldier() {
        name = new String();
        surName = new String();
        middleName = new String();
        age = 0;
    }

    private Soldier(Builder obj) {
        this.name = obj.name;
        this.surName = obj.surName;
        this.middleName = obj.middleName;
        this.age = obj.age;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public static class Builder {

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Surname must start with capital letter")
        private String surName;

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Name must start with capital letter")
        private String name;

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "MiddleName must start with capital letter")
        private String middleName;

        @Min(value = 0, message = "age can't be < 0")
        @Max(value = 100, message = "age must be between 0 and 100")
        private int age;

        public Builder() {
            surName = "Surname";
            name = "Name";
            middleName = "MiddleName";
            age = 0;

        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public void validate(Soldier anm) {
            ValidatorFactory fct = Validation.buildDefaultValidatorFactory();
            Validator validator = fct.getValidator();
            Set<ConstraintViolation<Builder>> constraintViolationSet = validator.validate(this);

            String err = new String();
            err = "";

            for (var cv : constraintViolationSet) {
                err += "Error on (" + cv.getInvalidValue() + ") with message: " + cv.getMessage() + "\n";
            }

            if (err != "") {
                throw new IllegalArgumentException(err);
            }
        }

        public Soldier build() {
            Soldier anm = new Soldier(this);
            validate(anm);
            return anm;
        }

    }

    @Override
    public String toString() {
        return surName + " " + name + " " + middleName + " " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier Soldier = (Soldier) o;
        return age == Soldier.age && Objects.equals(name, Soldier.name) && Objects.equals(surName, Soldier.surName) && Objects.equals(middleName, Soldier.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, middleName, age);
    }
}
