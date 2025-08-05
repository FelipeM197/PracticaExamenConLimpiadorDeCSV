/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.persona;
import vista.formulario;

/**
 *
 * @author P5E003-O
 */
public class controladorPersonas implements ActionListener{
    private persona persona;
    private formulario vista;
    public controladorPersonas(persona persona, formulario vista){
        this.persona = persona;
        this.vista = vista;
        
        vista.getBotonGuardar().addActionListener(this);
        vista.getBotonLimpiar().addActionListener(this);
        vista.getBotonMostrar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vista.getBotonGuardar()){
            this.guardarDatosCSV();
        }else if(e.getSource() == vista.getBotonMostrar()){
            this.mostrarDatosTabla();
        }else if(e.getSource() == vista.getBotonLimpiar()){
            persona.limpiarCSV();
            this.mostrarDatosTabla();
        }
    }
    
    
    public void iniciarPrograma(){
        vista.setVisible(true);
        vista.setTitle("ola");
    }
    
    public void mostrarDatosTabla(){
        ArrayList<persona> Datos = persona.mostrarDato();
        String[] columnas = {"Nombre", "Edad"};
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        
        for(persona p: Datos){
            Object[] datosPersonas = {p.getNombre(), p.getEdad()};
            tabla.addRow(datosPersonas);
            
            
        }
        vista.getTablaDatos().setModel(tabla);
    }
    
    public void guardarDatosCSV(){
        String nombre = vista.getTxtNombre().getText();
        int edad = Integer.parseInt(vista.getTxtEdad().getText());
        
        persona.guardarDatos(new persona(nombre, edad));
    }
    


    
}
