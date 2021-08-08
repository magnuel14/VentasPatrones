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
public class ProductoSimple extends ProductoAbstracto {

    protected String marca;

    public ProductoSimple(String marca, String nombre, String codigo, double precio) {
        super(nombre, codigo, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    

}
