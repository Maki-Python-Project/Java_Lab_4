package lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Soldier soldier1 = new Soldier.Builder().withSurname("Prustypa").withName("Taras").withMiddleName("Stepanovuch").withAge(20).build();
        Soldier soldier2 = new Soldier.Builder().withSurname("Slusar").withName("Mukola").withMiddleName("Olegovuch").withAge(23).build();
        Soldier soldier3 = new Soldier.Builder().withSurname("Lutvunyk").withName("Ivan").withMiddleName("Mukolaevuch").withAge(26).build();
        Soldier soldier4 = new Soldier.Builder().withSurname("Bien").withName("Olexandre").withMiddleName("Muhaulovuch").withAge(22).build();
        Soldier soldier5 = new Soldier.Builder().withSurname("Cherenchyk").withName("Rostuslav").withMiddleName("Andriuovuch").withAge(20).build();

        List<Soldier> soldiers = new ArrayList<Soldier>();
        soldiers.add(soldier1);
        soldiers.add(soldier2);
        soldiers.add(soldier3);
        soldiers.add(soldier4);
        soldiers.add(soldier5);

        MilitaryBase militaryBase = new MilitaryBase.Builder().withMilitaryBaseName("A3290").withSoldierList(soldiers).build();
    }
}
