/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica4.ventas;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author magnuel
 */
public class OrdenDeVenta {

    private String id_orden;
    private Date fecha = new Date();
    private boolean estado;

    private List<ProductoAbstracto> productos = new ArrayList<>();

    public OrdenDeVenta() {
       
       
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<ProductoAbstracto> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoAbstracto> productos) {
        this.productos = productos;
    }

    public double getPrecio() {
        double precio = 0d;
        for (ProductoAbstracto flag : productos) {
            precio += flag.getPrecio();
        }
        return precio;
    }

    public void agregarProducto(ProductoAbstracto producto) {
        productos.add(producto);
    }

    public void removerProducto(ProductoAbstracto producto) {
        productos.remove(producto);
    }

    public String Verificarestado(boolean estado) {
        String flag = "";
        if (estado == true) {
            flag += "Orden Cancelada";
            return flag;
        } else {
            flag += "Borrador,la orden sera archivada";
            return flag;
        }
    }
    public void printNumOrden(String numOrden){
        
        System.out.println("\n Factura #: "+numOrden
                +"\n ============================================= ");
    }

    public void printOrden() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        SimpleDateFormat fechaF = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        System.out.println("\n Fecha:" + fechaF.format(fecha)
                + "\n Productos:\n");

        for (ProductoAbstracto prod : productos) {
            System.out.println(prod.getNombre() + "\t $ " + formater.format(prod.getPrecio()));

        }
        System.out.println("Total: " + formater.format(getPrecio())
                + "\n Estado:" + Verificarestado(estado)
                + "\n =============================================");

    }

}
