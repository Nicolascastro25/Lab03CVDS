package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    /*
	* Prueba donde se crea una persona muerta y se intenta registrar
     */
    @Test
    public void validateRegistryResultDead() {
        Person person = new Person("valentina", 1000254541, 20, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    /*
	* Prueba donde se crea una persona menor de edad y se intenta registrar
     */
    @Test
    public void validateRegistryResultUnderage() {
        Person person = new Person("Nicolas", 1000225625, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    /*
	* Prueba donde se crea una persona con edad invalida y se intenta registrar
     */
    @Test
    public void validateRegistryResultInvalidAge() {
        Person person = new Person("Santiago", 22563250, 150, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    /*
	* Prueba donde se crea una persona valida y se intenta registrar
     */
    @Test
    public void validateRegistryResultValid() {
        Person person = new Person("Laura", 56449400, 35, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    /*
	* Prueba donde se crea una persona se intenta registrar
     */
    @Test
    public void validateRegistryResultDuplicatedAdult() {
        Person person = new Person("Andres", 100220848, 52, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

