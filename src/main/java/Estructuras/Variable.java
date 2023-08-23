
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
        

        
 
    
      
}
