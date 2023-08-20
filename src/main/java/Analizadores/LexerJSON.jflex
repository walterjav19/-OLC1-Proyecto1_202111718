package analizadores;
import java_cup.runtime.Symbol; 
import java.util.ArrayList;
import java.util.List;

%%

%{
    //public List<Errores.ErrorLexico> ErroresLexicos = new ArrayList<Errores.ErrorLexico>();
    public List<Symbol> T_SIMBOLOS = new ArrayList<Symbol>();
    public List<Errores.ErrorLexico> ErroresLexicos = new ArrayList<Errores.ErrorLexico>();
%}
 
%class LexicoJSON
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yychar = 0; 
    
%init} 

InputCharacter=[^\r\n]
any=[^!]
LineTerminator= \r|\n|\r\n
BLANCOS=[ \r\t]+
DD=[0-9]+("."[  |0-9]+)?
MENOSCOMILLAS = [^"\\\""]* "\\\""
cadena="\"" {MENOSCOMILLAS}* [^\"]* {MENOSCOMILLAS}* "\""
comentariosimple="//" {InputCharacter}* {LineTerminator}?
comentariomultilinea="/*" {any}* "*/"



%%


"{" {T_SIMBOLOS.add(new Symbol(TokenJson.BRAIZQ,yyline,yychar, yytext()));
    return new Symbol(TokenJson.BRAIZQ,yyline,yychar, yytext());}
 
"}" {T_SIMBOLOS.add(new Symbol(TokenJson.BRADER,yyline,yychar, yytext()));
    return new Symbol(TokenJson.BRADER,yyline,yychar, yytext());} 

":" {T_SIMBOLOS.add(new Symbol(TokenJson.DOSPTO,yyline,yychar, yytext()));
    return new Symbol(TokenJson.DOSPTO,yyline,yychar, yytext());}

"," {T_SIMBOLOS.add(new Symbol(TokenJson.COMA,yyline,yychar, yytext()));
    return new Symbol(TokenJson.COMA,yyline,yychar, yytext());}


\n {yychar=0;}

{cadena} {T_SIMBOLOS.add(new Symbol(TokenJson.CADENA,yyline,yychar, yytext()));
          return new Symbol(TokenJson.CADENA,yyline,yychar, yytext());}

{DD} {T_SIMBOLOS.add(new Symbol(TokenJson.DECIMAL,yyline,yychar, yytext()));
      return new Symbol(TokenJson.DECIMAL,yyline,yychar, yytext());}

{comentariosimple} {/*Ignorar Espacios Comentarios*/}
{BLANCOS} {/*Ignorar Espacios en Blanco*/}
{comentariomultilinea} {/*Ignorar Espacios*/} 

. {
    Errores.ErrorLexico err=new Errores.ErrorLexico(yytext(),yyline,yychar);
    ErroresLexicos.add(err);
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}