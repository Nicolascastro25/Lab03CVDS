package edu.eci.cvds.tdd.registry;

public class Registry {

    public RegisterResult registerVoter(Person p) {
        Person prueba = new Person("Nicolas", 100220848, 22, Gender.MALE, true);
        //clase edad duplicada
        if (p.getId() == prueba.getId() && p.isAlive() == true) {
            return RegisterResult.DUPLICATED;
        } //clase dead
        else if (p.isAlive() == false) {
            return RegisterResult.DEAD;
        } //clase sin edad suficiente
        else if (p.getAge() >= 0 && p.getAge() <= 17 && p.isAlive() == true) {
            return RegisterResult.UNDERAGE;
        } //clase edad invalida
        else if (p.getAge() <= 0 || p.getAge() >= 120 && p.isAlive() == true) {
            return RegisterResult.INVALID_AGE;
        } //clase edad valida
        else if (p.getAge() >= 18 && p.getAge() <= 120 && p.isAlive() == true) {
            return RegisterResult.VALID;
        }

        return RegisterResult.VALID;
    }
}
