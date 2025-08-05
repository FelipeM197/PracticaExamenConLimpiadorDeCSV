/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicatablas;

import controlador.controladorPersonas;
import modelo.persona;
import vista.formulario;

/**
 *
 * @author P5E003-O
 */
public class PracticaTablas {

    public static void main(String[] args) {
        
        
        formulario vista = new formulario();
        persona modelo = new persona();
        modelo.archivosPredeterminados();
        System.out.println("Hello World!");
        controladorPersonas controlador = new controladorPersonas(modelo, vista);
        
        controlador.iniciarPrograma();
        
    }
}
