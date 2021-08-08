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
public class ClienteInterface {

    private List<Cliente> listaclientes = new ArrayList<>();

    public List<Cliente> getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(List<Cliente> listaclientes) {
        this.listaclientes = listaclientes;
    }

    public void agregarCliente(Cliente cliente) {
        listaclientes.add(cliente);
    }

    public void removerProducto(Cliente cliente) {
        listaclientes.remove(cliente);
    }

    public void printCliente() {
        for (Cliente cli : listaclientes) {
            System.out.println("\n Id:" + cli.getId_cliente() + "\n"
                    + "\n Nombre y Apellido: " + cli.getNombre() + " " + cli.getApellido()
                    + "\n Cedula:" + cli.getCedula()
                    + "\n Direccion: " + cli.getDireccion());

        }

    }

    public void BuscarClienteNombreApellido(String nombre, String apellido) {
        if (nombre != "" && apellido != "") {
            for (int x = 0; x < listaclientes.size(); x++) {
                Cliente clienteB = listaclientes.get(x);
                if (clienteB.getApellido().equals(apellido) && clienteB.getNombre().equals(nombre)) {

                    System.out.println("\nNombre y Apellido: " + clienteB.getNombre() + " " + clienteB.getApellido()
                            + "\n Cedula:" + clienteB.getCedula()
                            + "\n Direccion: " + clienteB.getDireccion());
                    break; // Terminar ciclo, pues ya lo encontramos

                }

            }
        } else {
            System.out.println("Los caracteres de busqueda estan vacios");
        }

    }

    public void BuscarClienteCedula(String cedula) {
        if (cedula != "") {
            for (int x = 0; x < listaclientes.size(); x++) {
                Cliente clienteB = listaclientes.get(x);
                if (clienteB.getCedula().equals(cedula)) {

                    System.out.println("\nNombre y Apellido: " + clienteB.getNombre() + " " + clienteB.getApellido()
                            + "\n Cedula:" + clienteB.getCedula()
                            + "\n Direccion: " + clienteB.getDireccion());
                    break; // Terminar ciclo, pues ya lo encontramos
                }
            }
        } else {
            System.out.println("Los caracteres de busqueda estan vacios");
        }
    }

}
