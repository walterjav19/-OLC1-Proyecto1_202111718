/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generadores;

import java.io.File;


public class LexerJSON {
    public static void generarLexer(String ruta){
        File archivo=new File(ruta);
        jflex.Main.generate(archivo);
        
    }
    public static void main(String[] args) {
        String ruta="src/main/java/Analizadores/LexerJSON.jflex";
        generarLexer(ruta);
    }
    
}
