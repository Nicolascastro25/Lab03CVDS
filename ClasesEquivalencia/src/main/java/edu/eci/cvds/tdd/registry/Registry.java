package edu.eci.cvds.tdd.registry;

public class Registry {
    public RegisterResult registerVoter(Person p) {
		Person prueba = new Person("Nicolas", 1000225263, 22, Gender.MALE , true);
		//clase dead
		if(p.isAlive()==false){
			return RegisterResult.DEAD;
		}
		//clase sin edad suficiente
		else if(p.getAge >= 0 && p.getAge <= 17 && p.isAlive()==true){
			return RegisterResult.UNDERAGE;
		}
		//clase edad invalida
		else if(p.getAge <= 0 || p.getAge >= 120 && p.isAlive()==true){
			return RegisterResult.INVALID_AGE;
		}
		//clase edad valida
		else if(p.getAge >= 18 && p.getAge <= 120 && p.isAlive()==true){
			return RegisterResult.VALID;
		}
		//clase edad duplicada
		else if (p.getId()==prueba.getId() && p.isAlive()==true){
			return RegisterResult.DUPLICATED;
		}
        return RegisterResult.VALID;
    }
}