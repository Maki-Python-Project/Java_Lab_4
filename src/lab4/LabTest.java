package lab4;

import org.testng.annotations.Test;

public class LabTest {
    @Test
    public void SoldierNameTest() {
        new Soldier.Builder().withName("Eugen").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void SoldierNameFailTest() {
        new Soldier.Builder().withName("eugen").build();
    }

    @Test
    public void SoldierSurNameTest() {
        new Soldier.Builder().withSurname("Grod").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void SoldierSurNameFailTest() {
        new Soldier.Builder().withSurname("grod").build();
    }

    @Test
    public void SoldierMiddleNameTest() {
        new Soldier.Builder().withMiddleName("Volodumurovich").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void SoldierMiddleNameFailTest() {
        new Soldier.Builder().withMiddleName("volodumurobich").build();
    }

    @Test
    public void SoldierAgeTest() {
        new Soldier.Builder().withAge(23).build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void SoldierAgeFailTest() {
        new Soldier.Builder().withAge(-5).build();
    }
}
