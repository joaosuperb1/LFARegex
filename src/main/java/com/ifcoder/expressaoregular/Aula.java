
package com.ifcoder.expressaoregular;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jose
 */
public class Aula {

    public static void main(String[] args) {
        /*ExpressaoRegular ER = new ExpressaoRegular();

        //Teste 1, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511200021");
        
        //Teste 2, expressão regular: DIGITOS
        ER.confere(ER.DIGITOS, "000511200021ADAF");
        
        //Teste 3, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "ASDFEAFdafsafdsf");

        //Teste 4, expressão regular: LETRAS
        ER.confere(ER.LETRAS, "ASDFEAFdafsafdsf4565");
                
        //Teste 5, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "Altura1");

        //Teste 6, expressão regular: IDENT (nome de variável, função e classes)
        ER.confere(ER.IDENT, "1Altura");
                
        
        //Teste 7, expressão regular: REAL
        ER.confere(ER.REAL, "123.908777E+30");
        
        //Teste 8, expressão regular: REAL
        ER.confere(ER.REAL, "0.17E-5");
        
        //Teste 9, expressão regular: ATRIBUICAO
        ER.confere(ER.ATRIBUICAO, "media=-123.908777E+30");
        
        ER.confere(ER.INTEIRO, "10");*/      
        
        Aula aula1 = new Aula();
        
        // Vetor com possiveis assinaturas de funções
        List<String> assinaturas = Arrays.asList(
            "void funcao1(int a, float b)",
            "String funcao2()",
            "int soma(int x, int y)",
            "1 soma int"
        );
        String regexAssinatura = aula1.regexAssinaturaFuncao();
        aula1.testarExpressao("Assinatura de Funções", regexAssinatura, assinaturas);

        // Vetor com parametros de funções
        List<String> parametros = Arrays.asList(
            "int a, float b",
            "float media, String nome",
            "double x, int y, char z",
            "float 1"
        );
        String regexParametros = aula1.regexParametrosFuncao();
        aula1.testarExpressao("Parâmetros de Funções", regexParametros, parametros);

        // Vetor com Condicionais
        List<String> condicionais = Arrays.asList(
            "if(ano < 1990)",
            "if(3*a != 4+t)",
            "if(a == b)",
            "(a : b)if"
        );
        String regexCondicional = aula1.regexCondicional();
        aula1.testarExpressao("Condicional", regexCondicional, condicionais);

        // Vetor com possiveis expressões matemática
        List<String> expressoesMatematicas = Arrays.asList(
            "3+media/3",
            "-4+beta*media[1].x",
            "soma(a, b)/4*vetor[5].idade",
            "1/0" // Tratar erro /0
            // Faz sentido do ponto de vista linguistico porem do ponto de vista matemático não faz.
        );
        String regexExpressaoMatematica = aula1.regexExpressaoMatematica();
        aula1.testarExpressao("Expressão Matemática", regexExpressaoMatematica, expressoesMatematicas);
    }

    //regex de assinatura de funções
    public String regexAssinaturaFuncao() {
        return "\\w+\\s+\\w+\\s*\\((\\s*\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*)?\\s*\\)";
    }

    //regex de parâmetros de funções
    public String regexParametrosFuncao() {
        return "\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*";
    }

    //regez de condicionais
    public String regexCondicional() {
        return "if\\s*\\(.*\\)";
    }

    //regez de expressões matemáticas
    public String regexExpressaoMatematica() {
        return "[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?(\\s*[-+*/]\\s*[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?)*";
    }

    //testar regex
    public void testarExpressao(String descricao, String regex, List<String> exemplos) {
        System.out.println("Testando: " + descricao);
        for (String exemplo : exemplos) {
            if (exemplo.matches(regex)) {
                System.out.println("ACEITA: " + exemplo);
            } else {
                System.err.println("REJEITADA: " + exemplo);
            }
        }
        System.out.println();
    }
}
