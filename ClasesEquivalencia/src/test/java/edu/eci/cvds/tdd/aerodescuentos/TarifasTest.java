/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.tdd.aerodescuentos;

import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jaime Castro
 */
public class TarifasTest {

    private CalculadorDescuentos calculador = new CalculadorDescuentos();
    private double tarifa;

    /*
    * Clase de prueba descuento para pasajeros con edad inferior a 18 años y billete con antelación superior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia1() {
        tarifa = calculador.calculoTarifa(2000, 22, 16);
        Assert.assertTrue(tarifa == 1600.0);
    }

    /*
    * Clase de prueba descuento para pasajeros con edad inferior a 18 años y billete con antelación inferior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia2() {
        tarifa = calculador.calculoTarifa(2000, 17, 16);
        Assert.assertTrue(tarifa == 1900.0);
    }

    /*
    * Clase de prueba descuento para pasajeros con edad superior a 18 años e inferior a 65 años y billete con antelación superior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia3() {
        tarifa = calculador.calculoTarifa(2000, 24, 25);
        Assert.assertTrue(tarifa == 1700.0);
    }

    /*
    * Clase de prueba descuento para pasajeros con edad superior a 18 años e inferior a 65 años y billete con antelación inferior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia4() {
        tarifa = calculador.calculoTarifa(2000, 5, 30);
        Assert.assertTrue(tarifa == 2000.0);
    }

    /*
    * Clase de prueba descuento para pasajeros con edad superior a 65 años y billete con antelación superior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia5() {
        tarifa = calculador.calculoTarifa(2000, 29, 69);
        Assert.assertTrue(tarifa == 1540.0);
    }

    /*
    * Clase de prueba descuento para pasajeros con edad superior a 65 años y billete con antelación inferior a 20 días
     */
    @Test
    public void DeberiaAplicarDescuentoClaseEquivalencia6() {
        tarifa = calculador.calculoTarifa(2000, 10, 66);
        Assert.assertTrue(tarifa == 1840.0);
    }

    /*
    * Clase de prueba deberia lanzarse excepcion si la tarifa es negativa
    * @throws tarifa negativa
     */
    @Test
    public void DeberiaLanzarExcepcionTarifaNegativa() {
        try {
            tarifa = calculador.calculoTarifa(-2000, 5, 30);
        } catch (Exception ex) {

        }

    }

    /*
    * Clase de prueba deberia lanzarse excepcion si la antelacion de compra es negativa
    * @throws antelacion negativa
     */
    @Test
    public void DeberiaLanzarExcepcionDiasAntelacionNegativos() {
        try {
            tarifa = calculador.calculoTarifa(2000, -5, 30);
        } catch (Exception ex) {

        }

    }

    /*
    * Clase de prueba deberia lanzarse excepcion si la edad del pasajero es negativa
    * @throws edad negativa
     */
    @Test
    public void DeberiaLanzarExcepcionEdadNegativa() {
        try {
            tarifa = calculador.calculoTarifa(2000, 5, -30);
        } catch (Exception ex) {

        }

    }
}
