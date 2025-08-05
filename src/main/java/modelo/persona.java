/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author P5E003-O
 */
public class persona {
    private String nombre;
    private int edad;
    private final String nombreArchivo = "personas.txt";
    
    public persona(){
        
    }
    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    
    public void guardarDatos(persona p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))){
            bw.write(p.toCSV());
            bw.newLine();
        }catch(IOException e){
            System.out.println("erroruwu");
        }
    }
    
    public void archivosPredeterminados(){
        persona p1 = new persona("Felipe", 21);
        persona p2 = new persona("Andres", 18);
        
        guardarDatos(p1);
        guardarDatos(p2);
    }
    
    public ArrayList<persona> mostrarDato(){
        ArrayList<persona> resultadosArchivo = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String linea; 
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if(datos.length == 2){
                    String nombre = datos[0];
                    int edad = Integer.parseInt(datos[1]);
                    
                    resultadosArchivo.add(new persona(nombre, edad));
                }
            }
        }catch(IOException e){
            System.out.println("Error");
        }
        return resultadosArchivo;
    }
    
    public void limpiarCSV(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, false))){
            bw.write("");
        }catch(IOException e){
            System.out.println("No funcionando");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public String toCSV(){
        return nombre + "," + edad;
    }
    
        
        
}
