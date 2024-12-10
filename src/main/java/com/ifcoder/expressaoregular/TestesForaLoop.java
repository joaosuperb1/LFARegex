package com.ifcoder.expressaoregular;

import java.util.Arrays;
import java.util.List;

public class TestesForaLoop {
    private final ConferirER conferirER;

    public TestesForaLoop(ConferirER conferirER) {
        this.conferirER = conferirER;
    }

    public void executarTestes() {
        System.out.println("\nExecutando testes adicionais fora do loop...\n");

        // Testando Assinaturas de Funções
        List<String> assinaturas = Arrays.asList(
            "void funcao1(int a, float b)",
            "String funcao2()",
            "int soma(int x, int y)",
            "1 soma int"
        );
        conferirER.testarExpressoes("ASSINATURA_FUNCAO", assinaturas);

        // Testando Parâmetros de Função
        List<String> parametros = Arrays.asList(
            "int a, float b",
            "float media, String nome",
            "double x, int y, char z",
            "float 1"
        );
        conferirER.testarExpressoes("PARAMETROS_FUNCAO", parametros);

        // Testando Condicionais (if/else)
        List<String> condicionais = Arrays.asList(
            "if(ano < 1990)",
            "if(3*a != 4+t){}",
            "if(a == b){}",
            "(a : b)if"
        );
        conferirER.testarExpressoes("CONDICIONAL", condicionais);

        // Testando Expressões Matemáticas
        List<String> expressoesMatematicas = Arrays.asList(
            "3+media/3",
            "-4+beta*media[1].x",
            "soma(a, b)/4*vetor[5].idade",
            "1/0"
        );
        conferirER.testarExpressoes("EXPRESSAO_MATEMATICA", expressoesMatematicas);
    }
}


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

        
        /*
        //regex de assinatura de funções
    public String regexAssinaturaFuncao() {
        return "\\w+\\s+\\w+\\s*\\((\\s*\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*)?\\s*\\)";
    }

    //regex de parametros de funções
    public String regexParametrosFuncao() {
        return "\\w+\\s+\\w+(\\s*,\\s*\\w+\\s+\\w+)*";
    }

    //regez de condicionais
    public String regexCondicional() {
        return "if\\s*\\(.*\\)";
    }

    //regez de expressões matemáticas
    public String regexExpressaoMatematica() {
        return "[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?(\\s*[-+*///]\\s*[-+]?\\w+(\\[\\d+\\](\\.\\w+)?|\\(.*?\\))?)*";
    //}
        

    /*
    public void testarExpressao(String descricao, String regex, List<String> exemplos) {
        System.out.println("Testando: " + descricao);
        for (String exemplo : exemplos) {
            if (exemplo.matches(regex)) {
                if (exemplo.contains("/0")) { // Aqui eu corrijo o problema da divisão por 0
                    System.err.println("ERRO MATEMÁTICO: " + exemplo + " (Divisão por zero)");
                } else{
                    System.out.println("ACEITA: " + exemplo);
                }
            } else {
                System.err.println("REJEITADA: " + exemplo);
            }
        }
        System.out.println();
    }
    
    */
