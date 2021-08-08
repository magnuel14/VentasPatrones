/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica4.ventas;

import com.mycompany.practica4.ventas.Singleton_NumeroFactura;
import com.mycompany.practica4.ventas.Singleton_BD;

/**
 *
 * @author magnuel
 */
public class Main {

    public static void main(String[] args) {
// singleton id_orden
        Singleton_NumeroFactura id_orden1 = new Singleton_NumeroFactura();
//producto simple
        ProductoSimple ram4gb = new ProductoSimple("KingStone", "Memoria RAM 4GB", "01", 20);
        ProductoSimple ram8gb = new ProductoSimple("KingStone", "Memoria RAM 8GB", "02", 40);

        ProductoSimple disk500gb = new ProductoSimple("Addta", "Disco Duro 500GB", "03", 50);
        ProductoSimple disk1tb = new ProductoSimple("Addta", "Disco Duro 1TB", "04", 100);

        ProductoSimple cpuAMD = new ProductoSimple("AMD", "AMD phenon", "05", 120);
        ProductoSimple cpuIntel = new ProductoSimple("Intel", "Intel i7", "06", 130);

        ProductoSimple smallCabinete = new ProductoSimple("ExCom", "Gabinete Pequeño", "07", 50);
        ProductoSimple bigCabinete = new ProductoSimple("ExCom", "Gabinete Grande", "08", 100);

        ProductoSimple monitor20inch = new ProductoSimple("HP", "Monitor 20'", "09", 150);
        ProductoSimple monitor30inch = new ProductoSimple("HP", "Monitor 30'", "10", 200);

        ProductoSimple simpleMouse = new ProductoSimple("Genius", "Raton Simple", "11", 15);
        ProductoSimple gammerMouse = new ProductoSimple("Alien", "Raton Gammer", "12", 30);

//cliente
        Cliente cliente1 = new Cliente(1, "Manuel", "Vicente", "1105219248", "San Cayetano Bajo");
        Cliente cliente2 = new Cliente(2, "Rebeca", "Montero", "1105219241", "El Paraiso");
        Cliente cliente3 = new Cliente(3, "Jack", "Rojas", "1105219242", "Amaluza");
        Cliente cliente4 = new Cliente(4, "Mario", "Lopez", "1105219243", "Las Palmas");

//Computadora para Gammer que incluye 8gb de ram,disco de 1tb, procesador Intel i7
//gabinete grande,monitor de 30' y un mouse gammer.
        ProductoComposite gammerPC = new ProductoComposite("Gammer PC");
        gammerPC.addProucto(ram8gb);
        gammerPC.addProucto(disk1tb);
        gammerPC.addProucto(cpuIntel);
        gammerPC.addProucto(bigCabinete);
        gammerPC.addProucto(monitor30inch);
        gammerPC.addProucto(gammerMouse);

//Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon
//gabinete chico,monitor de 20' y un mouse simple.
        ProductoComposite homePC = new ProductoComposite("Casa PC");
        homePC.addProucto(ram4gb);//
        homePC.addProucto(disk500gb);
        homePC.addProucto(cpuAMD);
        homePC.addProucto(smallCabinete);
        homePC.addProucto(monitor20inch);
        homePC.addProucto(simpleMouse);

//Paque compuesto de dos paquetes, El paquete Gammer PC y Home PC
        ProductoComposite pc2x1 = new ProductoComposite("Paquete PC Gammer + Casa");
        pc2x1.addProucto(gammerPC);
        pc2x1.addProucto(homePC);
//clientes
        ClienteInterface cliente = new ClienteInterface();
        cliente.agregarCliente(cliente1);
        cliente.agregarCliente(cliente2);
        cliente.agregarCliente(cliente3);
        cliente.agregarCliente(cliente4);

        for (int num = 1; num <= 3; num++) {
            Singleton_BD.getInstancia();
        }
//orden 1
        String i_orden1 = id_orden1.NumeroFacturaSingleton();
        OrdenDeVenta gammerOrder = new OrdenDeVenta();
        gammerOrder.setId_orden(i_orden1);
        gammerOrder.printNumOrden(i_orden1);
        String nomCl1 = "Manuel";
        String apeCl1 = "Vicente";
        cliente.BuscarClienteNombreApellido(nomCl1, apeCl1);
        gammerOrder.agregarProducto(gammerPC);
        gammerOrder.setEstado(true);
        gammerOrder.printOrden();

//orden 2
        String i_orden2 = id_orden1.NumeroFacturaSingleton();
        OrdenDeVenta homeOrder = new OrdenDeVenta();
        homeOrder.setId_orden(i_orden2);
        homeOrder.printNumOrden(i_orden2);
        String ceducli2 = "1105219241";
        cliente.BuscarClienteCedula(ceducli2);
        homeOrder.agregarProducto(homePC);
        homeOrder.setEstado(false);
        homeOrder.printOrden();

//orden 3
        String i_orden3 = id_orden1.NumeroFacturaSingleton();
        OrdenDeVenta comboOrder = new OrdenDeVenta();
        comboOrder.setId_orden(i_orden3);
        comboOrder.printNumOrden(i_orden3);
        String nomCl3 = "Jack";
        String apeCl3 = "Rojas";
        cliente.BuscarClienteNombreApellido(nomCl3, apeCl3);
        comboOrder.agregarProducto(pc2x1);
        homeOrder.setEstado(true);
        comboOrder.printOrden();

//orden4
        String i_orden4 = id_orden1.NumeroFacturaSingleton();
        OrdenDeVenta clienteOrder = new OrdenDeVenta();
        clienteOrder.setId_orden(i_orden4);
        clienteOrder.printNumOrden(i_orden4);
        String ceducli4 = "1105219243";
        cliente.BuscarClienteCedula(ceducli4);
        clienteOrder.agregarProducto(homePC);
        clienteOrder.agregarProducto(ram8gb);
        clienteOrder.agregarProducto(ram4gb);
        clienteOrder.agregarProducto(monitor30inch);
        clienteOrder.agregarProducto(gammerMouse);
        clienteOrder.setEstado(true);
        clienteOrder.printOrden();
    }
}
