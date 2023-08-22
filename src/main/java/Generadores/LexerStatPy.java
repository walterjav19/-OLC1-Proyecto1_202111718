
package Generadores;

import java.io.File;


public class LexerStatPy {
    public static void generarLexer(String ruta){
        File archivo=new File(ruta);
        jflex.Main.generate(archivo);
        
    }
    
    public static void main(String[] args) {
        String ruta="src/main/java/Analizadores/LexerStatPy.jflex";
        generarLexer(ruta);
    }
}
