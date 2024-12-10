package com.ifcoder.expressaoregular;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

public class ExpressaoRegularTest {
    private final ConferirER conferirER = new ConferirER();

    @Test
    public void testDigitosValidos() {
        assertTrue("123".matches(ExpressaoRegular.DIGITOS), "Deve aceitar números simples.");
    }

    @Test
    public void testDigitosInvalidos() {
        assertFalse("123abc".matches(ExpressaoRegular.DIGITOS), "Não deve aceitar strings com letras.");
    }

    @Test
    public void testIdentificadoresValidos() {
        assertTrue("variavel123".matches(ExpressaoRegular.IDENT), "Identificadores válidos devem ser aceitos.");
    }

    @Test
    public void testIdentificadoresInvalidos() {
        assertFalse("123variavel".matches(ExpressaoRegular.IDENT), "Identificadores não podem começar com números.");
    }

    @Test
    public void testAssinaturaFuncaoValida() {
        assertTrue("void funcao1(int a, float b)".matches(ExpressaoRegular.ASSINATURA_FUNCAO), "Assinatura válida deve ser aceita.");
    }

    @Test
    public void testAssinaturaFuncaoInvalida() {
        assertFalse("1 void funcao".matches(ExpressaoRegular.ASSINATURA_FUNCAO), "Assinatura inválida deve ser rejeitada.");
    }

    @Test
    public void testExpressaoMatematicaValida() {
        assertTrue("3+5*2".matches(ExpressaoRegular.EXPRESSAO_MATEMATICA), "Expressão matemática válida.");
    }

    @Test
    public void testExpressaoMatematicaInvalida() {
        assertFalse("3++5".matches(ExpressaoRegular.EXPRESSAO_MATEMATICA), "Expressão matemática inválida deve ser rejeitada.");
    }

    @Test
    public void testCondicionalComChaves() {
        assertTrue("if(a == b) { System.out.println(a); }".matches(ExpressaoRegular.CONDICIONAL), "Condicional válida com chaves.");
    }

    @Test
    public void testCondicionalSemChaves() {
        assertThrows(ChavesFaltandoException.class, () -> {
            conferirER.confere(ExpressaoRegular.CONDICIONAL, "if(a == b) System.out.println(a);");
        }, "Deve lançar exceção quando faltar chaves.");
    }

    @Test
    public void testElseSemChaves() {
        assertThrows(ChavesFaltandoException.class, () -> {
            conferirER.confere(ExpressaoRegular.CONDICIONAL, "if(a == b) { System.out.println(a); } else System.out.println(b);");
        }, "Deve lançar exceção quando o else não tem chaves.");
    }

    @Test
    public void testCondicionalValidaComElse() {
        assertTrue("if(a == b) { System.out.println(a); } else { System.out.println(b); }".matches(ExpressaoRegular.CONDICIONAL),
                "Condicional válida com else.");
    }

    @Test
    public void testParametroFuncao() {
        assertTrue("int a, float b".matches(ExpressaoRegular.PARAMETROS_FUNCAO), "Parâmetros válidos.");
        assertFalse("123a, float".matches(ExpressaoRegular.PARAMETROS_FUNCAO), "Parâmetros inválidos.");
    }
    
    @Test
    public void testDivisaoPorZero() {
        String regex = ".*"; // Regex genérico para teste
        String sentenca = "1/0"; // Exemplo de expressão inválida
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            conferirER.confere(regex, sentenca);
        });
        assertEquals("ERRO MATEMÁTICO: Divisão por zero detectada.", exception.getMessage());
    }

    @Test
    public void testRegexNulaOuVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            conferirER.confere(null, "123");
        }, "Deve lançar exceção para regex nula.");
    }

    // Testando múltiplas expressões de uma vez
    @Test
    public void testTestarExpressoes() {
        List<String> assinaturas = Arrays.asList(
            "void funcao1(int a, float b)",
            "String funcao2()",
            "int soma(int x, int y)",
            "1 soma int"
        );
        conferirER.testarExpressoes("ASSINATURA_FUNCAO", assinaturas);

        List<String> parametros = Arrays.asList(
            "int a, float b",
            "float media, String nome",
            "double x, int y, char z",
            "float 1"
        );
        conferirER.testarExpressoes("PARAMETROS_FUNCAO", parametros);

        List<String> condicionais = Arrays.asList(
            "if(ano < 1990)",
            "if(3*a != 4+t){}",
            "if(a == b){}",
            "(a : b)if"
        );
        conferirER.testarExpressoes("CONDICIONAL", condicionais);

        List<String> expressoesMatematicas = Arrays.asList(
            "3+media/3",
            "-4+beta*media[1].x",
            "soma(a, b)/4*vetor[5].idade",
            "1/0"
        );
        conferirER.testarExpressoes("EXPRESSAO_MATEMATICA", expressoesMatematicas);
    }
}
