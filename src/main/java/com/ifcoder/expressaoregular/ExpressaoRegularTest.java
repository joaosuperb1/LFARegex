/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.expressaoregular;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*Classe criada para tratar exceções utilizando da api Junit, o junit faz testes automatizados
para verificar se o código funciona conforme esperado em vários cenários diferentes */

public class ExpressaoRegularTest {

    private final ExpressaoRegular er = new ExpressaoRegular();

    @Test 
    public void testDigitos() {
        assertTrue("123".matches(er.DIGITOS), "Numeros devem ser aceitos");
        assertFalse("123abc".matches(er.DIGITOS), "Strings com letras nao devem ser aceitas");
    }

    @Test
    public void testIdentificador() {
        assertTrue("variavel123".matches(er.IDENT), "Identificadores validos devem ser aceitos");
        assertFalse("123variavel".matches(er.IDENT), "Identificadores nao podem comecar com numeros");
    }

    @Test
    public void testAssinaturaFuncao() {
        assertTrue("void funcao1(int a, float b)".matches(er.ASSINATURA_FUNCAO), "Assinatura de função valida");
        assertFalse("1 void funcao".matches(er.ASSINATURA_FUNCAO), "Assinaturas invalidas devem ser rejeitadas");
    }

    @Test
    public void testExpressaoMatematica() {
        assertTrue("3+5*2".matches(er.EXPRESSAO_MATEMATICA), "Expressao matematica valida");
        assertFalse("3++5".matches(er.EXPRESSAO_MATEMATICA), "Expressoes invalidas devem ser rejeitadas");
    }

    @Test
    public void testCondicional() {
        assertTrue("if(a == b)".matches(er.CONDICIONAL), "Condicional valida");
        assertFalse("(a == b)if".matches(er.CONDICIONAL), "Strings fora do padrao nao devem ser aceitas");
    }
    
    @Test
    public void testDivisaoPorZero() {
    String regex = ".*";
    String sentenca = "1/0";

    Exception exception = assertThrows(ArithmeticException.class, () -> {
        er.confere(regex, sentenca);
    });

    assertEquals("ERRO MATEMATICO: Divisao por zero detectada.", exception.getMessage());
    }

}