
package Errores;


public class ErrorLexico {
    public String Lexema;
    public String Descripcion="Caracter No Reconocido por el Lenguaje";
    public int Linea;
    public int Columna;
    
    public ErrorLexico(String Lexema, int Linea, int Columna) {
        this.Lexema = Lexema;
        this.Linea = Linea;
        this.Columna = Columna;
    }
    
}
