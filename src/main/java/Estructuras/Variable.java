
package Estructuras;

import analizadores.LexicoJSON;
import analizadores.SintacticoJSON;
import java.io.FileReader;

public class Variable {
        public static Object BuscarVariable(String name,String name_variable){
            SintacticoJSON pars;
            try {
                LexicoJSON lex=new LexicoJSON(new FileReader(name));
                pars=new SintacticoJSON(lex);
                pars.parse();
                Object variable=pars.t_variables.get(name_variable);
                return variable;
            } catch (Exception ex) {
                return null;
            }
        }
        
    public static String formatCodeWithIndentation(String input) {
    String[] lines = input.split("\n");
    int totalLines = lines.length;
    StringBuilder formattedCode = new StringBuilder();

    for (int i = 0; i < totalLines; i++) {
        formattedCode.append("    ").append(lines[i]);
        if (i < totalLines - 1) {
            formattedCode.append("\n");
        }
    }

    return formattedCode.toString();
}
    

        

        

}
