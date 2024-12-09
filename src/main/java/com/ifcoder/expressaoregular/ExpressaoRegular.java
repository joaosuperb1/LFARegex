
package com.ifcoder.expressaoregular;

import java.util.List;

public class ExpressaoRegular {

    /*' ' (espaço), '\t' TAB, '\n' new line, '\r' volta o cursos para o inicio da linha, 
    '\f' avanço de pagina, '\v' vertical TAB - (usado em configuraçoes de impressora)*/
    
    public String BRANCO, BRANCOS;
    public String DIGITO, DIGITOS;
    public String TIPO;
    public String LETRA, LETRAS;
    public String IDENT;
    public String EXPONENCIAL;
    public String REAL;
    public String INTEIRO;
    public String NUMEROS;
    public String ATRIBUICAO;
    public String ASSINATURA_FUNCAO;
    public String PARAMETROS_FUNCAO;
    public String CONDICIONAL;
    public String EXPRESSAO_MATEMATICA;
    

    /**
     * *****************************************
     * Trabalho 02
     *
     * Faças as Expressoes Regulares para reconhecer: 1. Assinatura de funções
     * ex: void funcao1(int a, float b) ex: String funcao2()
     *
     * 2. Parametros de funções ex: int a, float b ex: float media, String nome
     *
     * 3. Condicional ex: if(ano < 1990) ex: if(3*a != 4+t)
     *
     * 4. Expressão matemática ex: 3+media/3 ex: -4+beta*media[1].x ex: soma(a,
     * b)/4*vetor[5].idade
     *
     * OBS_1: Muitos erros ocorrem por falta de parenteses em torno da
     * expressão, logo use e abuse dos parenteses, eles nunca serão demais.
     *
     * OBS_2: A cada nova Expressao Regualar feita, teste-a.
     * ******************************************
     */
    
    public ExpressaoRegular() {
        //' ' (espaço), '\t' TAB, '\n' new line, '\r' volta o cursos para o inicio da linha, '\f' avanço de pagina, '\v' vertical TAB - (usado em configuraçoes de impressora)
        BRANCO = "(\\s)"; // [ \t\n\r\f\v] onde
        BRANCOS = BRANCO + "*";
        DIGITO = "([0-9])";
        DIGITOS = DIGITO + "*";
        TIPO = "(void|int|float|double|String|char)";
        LETRA = "([A-Za-z])";
        LETRAS = LETRA + "*";
        IDENT = "([A-Za-z_][A-Za-z0-9_]*)";
        //O Identificador acha nome de variavel, funções etc... Não aceita um numero ou caracter especial no inicio.
        EXPONENCIAL = "(E(\\+|-)" + DIGITOS + ")";
        REAL = "(\\-?" + DIGITOS + "\\.?" + DIGITOS + EXPONENCIAL+")";
        INTEIRO = "("+DIGITOS + EXPONENCIAL + "?)";
        NUMEROS = "(" + INTEIRO + "|" + REAL + ")";
        ATRIBUICAO = IDENT + BRANCOS + "=" + BRANCOS + REAL;
        
        // Expressão Regular com os macros
        //"\\w+\\s+\\w+\\s*\\((\\s*\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*)?\\s*\\)"
        //\\w+(uma palavra) \\s+(espaço em branco)\\w+(mais uma palavra)...
        ASSINATURA_FUNCAO = "\\b" + TIPO + "\\b\\s+" + IDENT + "\\s*\\(" + 
        "(\\s*" + TIPO + "\\s+" + IDENT + "(\\s*,\\s*" + TIPO + "\\s+" + IDENT + ")*)?\\s*\\)";

        
        // regex para Parametro "\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*"
        PARAMETROS_FUNCAO = IDENT + BRANCOS + IDENT + "(" + BRANCOS + "," + 
        BRANCOS + IDENT + BRANCOS + IDENT + ")*";
        
        // regex para condicional "if\\s*\\(.*\\)"
        CONDICIONAL = CONDICIONAL = "if" + BRANCOS + "\\(" + BRANCOS + 
        EXPRESSAO_MATEMATICA + BRANCOS + "[<>=!]+" + BRANCOS + 
        EXPRESSAO_MATEMATICA + BRANCOS + "\\)";

        // regex para expressao matematica "[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?(\\s*[-+*/]\\s*[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?)*"
        EXPRESSAO_MATEMATICA = "(" + IDENT + "|\\[" + NUMEROS + "\\]|" + NUMEROS + ")" + "(" + 
                BRANCOS + "[+\\-*/]" + BRANCOS + "(" + IDENT + "|\\[" + NUMEROS + "\\]|" + 
                NUMEROS + ")" + ")*";
        // (variavel ou numero)+ espaco em branco Operador (variavel ou numero)+
        
    }
   
}