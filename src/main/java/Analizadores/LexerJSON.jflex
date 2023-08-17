
package analizadores;
import java_cup.runtime.Symbol; 

%% 
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



BLANCOS=[ \r\t]+
DD=[0-9]+("."[  |0-9]+)?
MENOSCOMILLAS = [^"\\\""]* "\\\""
cadena="\"" {MENOSCOMILLAS}* [^\"]* {MENOSCOMILLAS}* "\""




%%


"{" {return new Symbol(TokenJson.BRAIZQ,yyline,yychar, yytext());} 
"}" {return new Symbol(TokenJson.BRADER,yyline,yychar, yytext());} 
":" {return new Symbol(TokenJson.DOSPTO,yyline,yychar, yytext());}
"," {return new Symbol(TokenJson.COMA,yyline,yychar, yytext());}


\n {yychar=0;}

{cadena} {return new Symbol(TokenJson.CADENA,yyline,yychar, yytext());}
{DD} {return new Symbol(TokenJson.DECIMAL,yyline,yychar, yytext());}
{BLANCOS} {} 
 

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}