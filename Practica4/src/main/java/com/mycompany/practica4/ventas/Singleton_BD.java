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
public class Singleton_BD {

    private static Singleton_BD instancia;

    // ----------------------------------------
    private Singleton_BD() {
    }

    // ----------------------------------------
    public static Singleton_BD getInstancia() {
        if (instancia == null) {
            instancia = new Singleton_BD();
            System.out.println("\n --------");
            System.out.println("Se ha conectado la BD");
            System.out.println("\n --------");

        } else {
            System.out.println("\n --------");
            System.out.println("Ya esta conectado a la BD");
            System.out.println("\n --------");

        }
        return instancia;
    }
}
