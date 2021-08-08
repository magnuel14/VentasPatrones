/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica4.ventas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magnuel
 */
public class ProductoComposite extends ProductoAbstracto {

    private List< ProductoAbstracto> productos = new ArrayList<ProductoAbstracto>();

    public ProductoComposite(String nombre) {
        super( nombre, null, 0);
    }

    
    @Override
    public double getPrecio() {
  // 0d  implica doble precisión.
        double precio = 0d;
        for (ProductoAbstracto flag : productos) {
            precio += flag.getPrecio();
        }
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        throw new UnsupportedOperationException();
    }

    public void addProucto(ProductoAbstracto producto) {
        this.productos.add(producto);
    }

    public boolean removeProduct(ProductoAbstracto producto) {
        return this.productos.remove(producto);
    }

}
