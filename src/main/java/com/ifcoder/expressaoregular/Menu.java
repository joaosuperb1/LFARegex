
package com.ifcoder.expressaoregular;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ExpressaoRegular ER = new ExpressaoRegular();
        ConferirER conferirER = new ConferirER();
        TestesForaLoop testes = new TestesForaLoop(conferirER); 
        // Passa a instância de ConferirER para TestesForaLoop
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

            while (continuar) {
            int opcao;
            try {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Testar Digitos");
                System.out.println("2. Testar Identificadores");
                System.out.println("3. Testar Assinatura de Funcao");
                System.out.println("4. Testar Expressao Matematica");
                System.out.println("5. Testar Condicional");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opcao: ");
               
               /*Captura exceção se o usuário digitar um valor não int*/
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                } catch (InputMismatchException e) {
                    System.err.println("Erro: opcao invalida! Digite um numero.");
                    scanner.nextLine(); // Limpar buffer do scanner
                    continue; /*Voltar ao menu*/
                }

                if (opcao == 0) {
                    continuar = false;
                    System.out.println("Saindo...");
                    testes.executarTestes();
                } else {
                    switch (opcao) {
                        case 1 -> System.out.println("Formato esperado: Digitos (somente numeros). Exemplo: '12345'");
                        case 2 -> System.out.println("Formato esperado: Identificadores (letras seguidas de letras ou numeros). Exemplo: 'variavel1'");
                        case 3 -> System.out.println("Formato esperado: Assinatura de funcao. Exemplo: 'int soma(int a, int b)'");
                        case 4 -> System.out.println("Formato esperado: Expressoes matematicas com operadores como +, -, *, /");
                        case 5 -> System.out.println("Formato esperado: Condicionais. Exemplo: 'if(a == b)'");
                        default -> throw new IllegalArgumentException("Opcao invalida! Escolha uma opcao valida.");
                    }

                    if (opcao >= 1 && opcao <= 5) {
                        System.out.print("Digite a sentenca para testar: ");
                        String sentenca = scanner.nextLine();

                        switch (opcao) {
                            case 1 -> conferirER.confere(ER.DIGITOS, sentenca);
                            case 2 -> conferirER.confere(ER.IDENT, sentenca);
                            case 3 -> conferirER.confere(ER.ASSINATURA_FUNCAO, sentenca);
                            case 4 -> conferirER.confere(ER.EXPRESSAO_MATEMATICA, sentenca);
                            case 5 -> conferirER.confere(ER.CONDICIONAL, sentenca);
                            default -> throw new IllegalArgumentException("Opcao invalida! Escolha uma opção valida.");
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }   
        }
    }
}


        
        