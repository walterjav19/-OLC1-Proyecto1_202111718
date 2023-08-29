package analizadores;
import java_cup.runtime.Symbol; 
import java.util.ArrayList;
import java.util.List;

%%

%{
    
    public List<Symbol> T_SIMBOLOS = new ArrayList<Symbol>();
    public List<Errores.ErrorLexico> ErroresLexicos = new ArrayList<Errores.ErrorLexico>();
%}
 
%class LexicoStatPy
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
D=[0-9]
L=[a-zA-Z_ñÑ]
entero=[0-9]+
CHAR = ([\']([^\t\'\"\n]|(\\\")|(\\n)|(\\\')|(\\t))?[\'])|(['][\$][{](6[5-9]|[7-8][0-9]|90|9[7-9]|10[0-9]|11[0-9]|12[0-2])[}]['])


%%

"for" {T_SIMBOLOS.add(new Symbol(sym.FOR,yyline,yychar, yytext()));
       return new Symbol(sym.FOR,yyline,yychar, yytext());}

"do" {T_SIMBOLOS.add(new Symbol(sym.DO,yyline,yychar, yytext()));
       return new Symbol(sym.DO,yyline,yychar, yytext());}

"while" {T_SIMBOLOS.add(new Symbol(sym.WHILE,yyline,yychar, yytext()));
       return new Symbol(sym.WHILE,yyline,yychar, yytext());}

"break" {T_SIMBOLOS.add(new Symbol(sym.BREAK,yyline,yychar, yytext()));
       return new Symbol(sym.BREAK,yyline,yychar, yytext());}

"case" {T_SIMBOLOS.add(new Symbol(sym.CASE,yyline,yychar, yytext()));
       return new Symbol(sym.CASE,yyline,yychar, yytext());}

"switch" {T_SIMBOLOS.add(new Symbol(sym.SWITCH,yyline,yychar, yytext()));
       return new Symbol(sym.SWITCH,yyline,yychar, yytext());}

"default" {T_SIMBOLOS.add(new Symbol(sym.DEFAULT,yyline,yychar, yytext()));
       return new Symbol(sym.DEFAULT,yyline,yychar, yytext());}

"True" {T_SIMBOLOS.add(new Symbol(sym.TRUE,yyline,yychar, yytext()));
       return new Symbol(sym.TRUE,yyline,yychar, yytext());}

"False" {T_SIMBOLOS.add(new Symbol(sym.FALSE,yyline,yychar, yytext()));
       return new Symbol(sym.FALSE,yyline,yychar, yytext());}

"if" {T_SIMBOLOS.add(new Symbol(sym.IF,yyline,yychar, yytext()));
       return new Symbol(sym.IF,yyline,yychar, yytext());}

"else" {T_SIMBOLOS.add(new Symbol(sym.ELSE,yyline,yychar, yytext()));
       return new Symbol(sym.ELSE,yyline,yychar, yytext());}

"int" {T_SIMBOLOS.add(new Symbol(sym.INT,yyline,yychar, yytext()));
       return new Symbol(sym.INT,yyline,yychar, yytext());}

"double" {T_SIMBOLOS.add(new Symbol(sym.DOUBLE,yyline,yychar, yytext()));
         return new Symbol(sym.DOUBLE,yyline,yychar, yytext());}

"string" {T_SIMBOLOS.add(new Symbol(sym.STRING,yyline,yychar, yytext()));
         return new Symbol(sym.STRING,yyline,yychar, yytext());}

"char" {T_SIMBOLOS.add(new Symbol(sym.PCHAR,yyline,yychar, yytext()));
         return new Symbol(sym.PCHAR,yyline,yychar, yytext());}

"bool" {T_SIMBOLOS.add(new Symbol(sym.BOOL,yyline,yychar, yytext()));
         return new Symbol(sym.BOOL,yyline,yychar, yytext());}

"void" {T_SIMBOLOS.add(new Symbol(sym.VOID,yyline,yychar, yytext()));
        return new Symbol(sym.VOID,yyline,yychar, yytext());}

"main" {T_SIMBOLOS.add(new Symbol(sym.MAIN,yyline,yychar, yytext()));
        return new Symbol(sym.MAIN,yyline,yychar, yytext());}

"DefinirGlobales" {T_SIMBOLOS.add(new Symbol(sym.DEFGLOB,yyline,yychar, yytext()));
                   return new Symbol(sym.DEFGLOB,yyline,yychar, yytext());}

"GraficaBarras" {T_SIMBOLOS.add(new Symbol(sym.GRAFBAR,yyline,yychar, yytext()));
                   return new Symbol(sym.GRAFBAR,yyline,yychar, yytext());}

"GraficaPie" {T_SIMBOLOS.add(new Symbol(sym.GRAFPI,yyline,yychar, yytext()));
              return new Symbol(sym.GRAFPI,yyline,yychar, yytext());}

"NewValor"   {T_SIMBOLOS.add(new Symbol(sym.NEWVAL,yyline,yychar, yytext()));
              return new Symbol(sym.NEWVAL,yyline,yychar, yytext());}

"Titulo"   {T_SIMBOLOS.add(new Symbol(sym.TITULO,yyline,yychar, yytext()));
              return new Symbol(sym.TITULO,yyline,yychar, yytext());}

"EjeX"   {T_SIMBOLOS.add(new Symbol(sym.EJEX,yyline,yychar, yytext()));
              return new Symbol(sym.EJEX,yyline,yychar, yytext());}

"Valores"   {T_SIMBOLOS.add(new Symbol(sym.VALORES,yyline,yychar, yytext()));
              return new Symbol(sym.VALORES,yyline,yychar, yytext());}

"TituloY"   {T_SIMBOLOS.add(new Symbol(sym.TITULOY,yyline,yychar, yytext()));
              return new Symbol(sym.TITULOY,yyline,yychar, yytext());}

"TituloX"   {T_SIMBOLOS.add(new Symbol(sym.TITULOX,yyline,yychar, yytext()));
              return new Symbol(sym.TITULOX,yyline,yychar, yytext());}

"Console"   {T_SIMBOLOS.add(new Symbol(sym.CONSOLE,yyline,yychar, yytext()));
              return new Symbol(sym.CONSOLE,yyline,yychar, yytext());}

"Write"   {T_SIMBOLOS.add(new Symbol(sym.WRITE,yyline,yychar, yytext()));
              return new Symbol(sym.WRITE,yyline,yychar, yytext());}

">" {T_SIMBOLOS.add(new Symbol(sym.MAYOR,yyline,yychar, yytext()));
        return new Symbol(sym.MAYOR,yyline,yychar, yytext());}

"<" {T_SIMBOLOS.add(new Symbol(sym.MENOR,yyline,yychar, yytext()));
        return new Symbol(sym.MENOR,yyline,yychar, yytext());}

">=" {T_SIMBOLOS.add(new Symbol(sym.MAYORIGUAL,yyline,yychar, yytext()));
        return new Symbol(sym.MAYORIGUAL,yyline,yychar, yytext());}

"<=" {T_SIMBOLOS.add(new Symbol(sym.MENORIGUAL,yyline,yychar, yytext()));
        return new Symbol(sym.MENORIGUAL,yyline,yychar, yytext());}

"==" {T_SIMBOLOS.add(new Symbol(sym.EQUALS,yyline,yychar, yytext()));
        return new Symbol(sym.EQUALS,yyline,yychar, yytext());}

"!=" {T_SIMBOLOS.add(new Symbol(sym.NOTEQUALS,yyline,yychar, yytext()));
        return new Symbol(sym.NOTEQUALS,yyline,yychar, yytext());}

"&&" {T_SIMBOLOS.add(new Symbol(sym.AND,yyline,yychar, yytext()));
        return new Symbol(sym.AND,yyline,yychar, yytext());}

"||" {T_SIMBOLOS.add(new Symbol(sym.OR,yyline,yychar, yytext()));
        return new Symbol(sym.OR,yyline,yychar, yytext());}

"!" {T_SIMBOLOS.add(new Symbol(sym.NOT,yyline,yychar, yytext()));
        return new Symbol(sym.NOT,yyline,yychar, yytext());}


"+" {T_SIMBOLOS.add(new Symbol(sym.MAS,yyline,yychar, yytext()));
        return new Symbol(sym.MAS,yyline,yychar, yytext());}

"-" {T_SIMBOLOS.add(new Symbol(sym.MENOS,yyline,yychar, yytext()));
        return new Symbol(sym.MENOS,yyline,yychar, yytext());}

"*" {T_SIMBOLOS.add(new Symbol(sym.POR,yyline,yychar, yytext()));
        return new Symbol(sym.POR,yyline,yychar, yytext());}

"/" {T_SIMBOLOS.add(new Symbol(sym.DIVIDIDO,yyline,yychar, yytext()));
        return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());}

"(" {T_SIMBOLOS.add(new Symbol(sym.PARIZQ,yyline,yychar, yytext()));
        return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}

")" {T_SIMBOLOS.add(new Symbol(sym.PARDER,yyline,yychar, yytext()));
        return new Symbol(sym.PARDER,yyline,yychar, yytext());}

"{" {T_SIMBOLOS.add(new Symbol(sym.BRAIZQ,yyline,yychar, yytext()));
    return new Symbol(sym.BRAIZQ,yyline,yychar, yytext());}


"}" {T_SIMBOLOS.add(new Symbol(sym.BRADER,yyline,yychar, yytext()));
     return new Symbol(sym.BRADER,yyline,yychar, yytext());}

"[" {T_SIMBOLOS.add(new Symbol(sym.LLAIZQ,yyline,yychar, yytext()));
    return new Symbol(sym.LLAIZQ,yyline,yychar, yytext());}


"]" {T_SIMBOLOS.add(new Symbol(sym.LLADER,yyline,yychar, yytext()));
     return new Symbol(sym.LLADER,yyline,yychar, yytext());}


";" {T_SIMBOLOS.add(new Symbol(sym.PTOCOMA,yyline,yychar, yytext()));
     return new Symbol(sym.PTOCOMA,yyline,yychar, yytext());}

"=" {T_SIMBOLOS.add(new Symbol(sym.IGUAL,yyline,yychar, yytext()));
     return new Symbol(sym.IGUAL,yyline,yychar, yytext());}

"$" {T_SIMBOLOS.add(new Symbol(sym.DOLAR,yyline,yychar, yytext()));
     return new Symbol(sym.DOLAR,yyline,yychar, yytext());}


"," {T_SIMBOLOS.add(new Symbol(sym.COMA,yyline,yychar, yytext()));
     return new Symbol(sym.COMA,yyline,yychar, yytext());}

"." {T_SIMBOLOS.add(new Symbol(sym.PUNTO,yyline,yychar, yytext()));
     return new Symbol(sym.PUNTO,yyline,yychar, yytext());}

":" {T_SIMBOLOS.add(new Symbol(sym.DOSPTO,yyline,yychar, yytext()));
     return new Symbol(sym.DOSPTO,yyline,yychar, yytext());}

\n {yychar=0;}

{L}({L}|{D})* {T_SIMBOLOS.add(new Symbol(sym.IDENT,yyline,yychar, yytext()));
                      return new Symbol(sym.IDENT,yyline,yychar, yytext());}

{cadena} {T_SIMBOLOS.add(new Symbol(sym.CADENA,yyline,yychar, yytext()));
          return new Symbol(sym.CADENA,yyline,yychar, yytext());}

{CHAR} {T_SIMBOLOS.add(new Symbol(sym.CHAR,yyline,yychar, yytext()));
          return new Symbol(sym.CHAR,yyline,yychar, yytext());}

{entero} {T_SIMBOLOS.add(new Symbol(sym.ENTERO,yyline,yychar, yytext()));
        return new Symbol(sym.ENTERO,yyline,yychar, yytext());}

{DD} {T_SIMBOLOS.add(new Symbol(sym.DECIMAL,yyline,yychar, yytext()));
      return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}



{comentariosimple} {/*Ignorar Espacios Comentarios*/}
{BLANCOS} {/*Ignorar Espacios en Blanco*/}
{comentariomultilinea} {/*Ignorar Espacios*/} 

. {
    Errores.ErrorLexico err=new Errores.ErrorLexico(yytext(),yyline,yychar);
    ErroresLexicos.add(err);
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}
