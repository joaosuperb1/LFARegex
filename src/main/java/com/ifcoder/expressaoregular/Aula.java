
package com.ifcoder.expressaoregular;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author jose
 */
public class Aula {

    public static void main(String[] args) {
        
        ExpressaoRegular ER = new ExpressaoRegular();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Testar Digitos");
            System.out.println("2. Testar Identificadores");
            System.out.println("3. Testar Assinatura de Funcao");
            System.out.println("4. Testar Expressao Matematica");
            System.out.println("5. Testar Condicional");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 0) {
                continuar = false;
                System.out.println("Saindo...");
            } else {
                switch (opcao) {
                        case 1 -> System.out.println("Formato esperado: Digitos (somente numeros). Exemplo: '12345'");
                        case 2 -> System.out.println("Formato esperado: Identificadores (letras seguidas de letras ou numeros). Exemplo: 'variavel1'");
                        case 3 -> System.out.println("Formato esperado: Assinatura de funcao. Exemplo: 'int soma(int a, int b)'");
                        case 4 -> System.out.println("Formato esperado: Expressoes matematicas com operadores como +, -, *, /");
                        case 5 -> System.out.println("Formato esperado: Condicionais. Exemplo: 'if(a == b)'");
                        default -> { System.err.println("Opcao invalida!");
                        continue;
                    }
                    }
                System.out.print("Digite a sentenca para testar: ");
                String sentenca = scanner.nextLine();

                switch (opcao) {
                    case 1 -> ER.confere(ER.DIGITOS, sentenca);
                    case 2 -> ER.confere(ER.IDENT, sentenca);
                    case 3 -> ER.confere(ER.ASSINATURA_FUNCAO, sentenca);
                    case 4 -> ER.confere(ER.EXPRESSAO_MATEMATICA, sentenca);
                    case 5 -> ER.confere(ER.CONDICIONAL, sentenca);
                    default -> System.err.println("Opcao invalida!");
                }
            }
        }

        scanner.close();
        
        ER.confere(ER.ASSINATURA_FUNCAO, "void funcao1(int a, float b)");
        
        // Vetor com possiveis assinaturas de funções
        List<String> assinaturas = Arrays.asList(
            "void funcao1(int a, float b)",
            "String funcao2()",
            "int soma(int x, int y)",
            "1 soma int"
        );
        ER.confereTrecho(ER.ASSINATURA_FUNCAO, assinaturas);
        
        // Vetor com parametros de funções
        List<String> parametros = Arrays.asList(
            "int a, float b",
            "float media, String nome",
            "double x, int y, char z",
            "float 1"
        );
        ER.confereTrecho(ER.PARAMETROS_FUNCAO, parametros);

        // Vetor com Condicionais
        List<String> condicionais = Arrays.asList(
            "if(ano < 1990)",
            "if(3*a != 4+t)",
            "if(a == b)",
            "(a : b)if"
        );
        ER.confereTrecho(ER.CONDICIONAL,condicionais);
        
        // Vetor com possiveis expressões matemática
        List<String> expressoesMatematicas = Arrays.asList(
            "3+media/3",
            "-4+beta*media[1].x",
            "soma(a, b)/4*vetor[5].idade",
            "1/0" // Tratar erro /0
            // Faz sentido do ponto de vista linguistico porem do ponto de vista matemático não faz.
        );
        ER.confereTrecho(ER.EXPRESSAO_MATEMATICA, expressoesMatematicas);
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