package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MilitaryBase {
    private String MilitaryBaseName;
    private List<Soldier>SoldierList;

    public void setMilitaryBaseName(String MilitaryBaseName) {
        this.MilitaryBaseName = MilitaryBaseName;
    }

    public String getMilitaryBaseName() {
        return MilitaryBaseName;
    }

    public List<Soldier> getSoldierList() {
        return SoldierList;
    }

    public void setSoldierList(List<Soldier> list_1) {
        this.SoldierList = SoldierList;
    }

    public MilitaryBase(Builder bld) {
        this.MilitaryBaseName = bld.MilitaryBaseName;
        this.SoldierList = bld.SoldierList;
    }

    public static class Builder {

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "MilitaryBase name must start with capital letter")
        private String MilitaryBaseName;
        private List<Soldier>SoldierList;

        public Builder() {
            MilitaryBaseName = "";
            Soldier a = new Soldier();
            SoldierList = new ArrayList<Soldier>();
            SoldierList.add(a);
        }

        public Builder withMilitaryBaseName(String name){
            this.MilitaryBaseName = name;
            return this;
        }

        public Builder withSoldierList(List<Soldier> list){
            this.SoldierList = list;
            return this;
        }

        public void validate(MilitaryBase MilitaryBasey) {
            ValidatorFactory fct = Validation.buildDefaultValidatorFactory();
            Validator validator = fct.getValidator();
            Set<ConstraintViolation<MilitaryBase.Builder>> constraintViolationSet = validator.validate(this);

            String err = new String();
            err = "";

            for (var cv : constraintViolationSet) {
                err += "Error on (" + cv.getInvalidValue() + ") with message: " + cv.getMessage() + "\n";
            }

            if (err != "") {
                throw new IllegalArgumentException(err);
            }
        }

        public MilitaryBase build() {
            MilitaryBase MilitaryBase = new MilitaryBase(this);
            validate(MilitaryBase);
            return MilitaryBase;
        }

    }

    @Override
    public String toString() {
        return "MilitaryBase{" +
                "MilitaryBaseName='" + MilitaryBaseName + '\'' +
                ", SoldierList=" + SoldierList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilitaryBase MilitaryBase = (MilitaryBase) o;
        return MilitaryBaseName.equals(MilitaryBase.MilitaryBaseName) && SoldierList.equals(MilitaryBase.SoldierList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MilitaryBaseName, SoldierList);
    }
}
