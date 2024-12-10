package com.ifcoder.expressaoregular;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ConferirER conferirER = new ConferirER();
        TestesForaLoop testes = new TestesForaLoop(conferirER); // Instancia compartilhada
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
            int opcao;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
            } catch (InputMismatchException e) {
                System.err.println("Erro: Opcao invalida! Digite um numero.");
                scanner.nextLine(); // Limpar buffer do scanner
                continue;
            }

            switch (opcao) {
                case 0 -> {
                    continuar = false;
                    System.out.println("Saindo...");
                    testes.executarTestes(); // Executar testes adicionais
                }
                case 1 -> executarTeste(conferirER, ExpressaoRegular.DIGITOS, "Digite digitos (ex: '12345'):", scanner);
                case 2 -> executarTeste(conferirER, ExpressaoRegular.IDENT, "Digite identificadores (ex: 'variavel1'):", scanner);
                case 3 -> executarTeste(conferirER, ExpressaoRegular.ASSINATURA_FUNCAO, "Digite assinatura de funcao (ex: 'int soma(int a, int b)'):", scanner);
                case 4 -> executarTeste(conferirER, ExpressaoRegular.EXPRESSAO_MATEMATICA, "Digite expressao matematica (ex: '3+5*2'):", scanner);
                case 5 -> executarTeste(conferirER, ExpressaoRegular.CONDICIONAL, "Digite condicional (ex: 'if(a == b){}'):", scanner);
                default -> System.err.println("Opcao invalida! Escolha uma opcao valida.");
            }
        }
    }
    private static void executarTeste(ConferirER conferirER, String regex, String mensagem, Scanner scanner) {
    System.out.println(mensagem);
    String entrada = scanner.nextLine();

    // Verifica se a entrada está vazia
    if (entrada.trim().isEmpty()) {
        System.err.println("Erro: Entrada vazia. Tente novamente.");
        return;
    }

    conferirER.confere(regex, entrada); // Validação com a expressão regular
}
}
