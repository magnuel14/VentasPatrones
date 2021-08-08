/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica4.ventas;

/**
 *
 * @author magnuel
 */
public class Singleton_NumeroFactura {

    private static Singleton_NumeroFactura instancia;
    // ----------------------------------------

    public String NumeroFacturaSingleton() {
        String numOrden = "";
        String cadena = "fact#";
        int numRandom = (int)(Math.random()*100+1);
        numOrden += cadena + numRandom;
        return numOrden;
    }

    // ----------------------------------------
    public static Singleton_NumeroFactura getInstancia() {
        instancia.NumeroFacturaSingleton();
        return instancia;
    }
}
