package com.ifcoder.expressaoregular;

import java.util.List;

public class ConferirER {

    private final ExpressaoRegular ER = new ExpressaoRegular();

    public void confere(String exp, String sentenca) {
        if (exp == null || exp.isEmpty()) {
            System.err.println("❌ Erro: Expressão regular inválida ou vazia.\n");
            System.out.println();
            return;
        }
        if (sentenca == null || sentenca.isEmpty()) {
            System.err.println("❌ Erro: Sentença vazia.\n");
            System.out.println();
            return;
        }

        try {
            // Verificando se a sentença corresponde à expressão regular
            if (sentenca.matches(exp)) {
                System.out.println("✅ W:" + sentenca + "'........ ACEITA!");

                // Exibindo a expressão antes de detectar o erro de divisão por zero
                if (sentenca.contains("/0")) {
                    System.err.println(" Expressão: " + sentenca);
                    throw new ArithmeticException("🚫 ERRO MATEMÁTICO: Divisão por zero detectada.");
                }
                
            } else {
                // Justificativa para expressões inválidas
                System.err.println("❌ W:" + sentenca + "'........ REJEITADA.");
                justificarErro(sentenca, exp);  // Justificativa
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Erro ao processar a expressão regular: " + e.getMessage() + "\n");
            System.out.println();
        }
    }

    private void justificarErro(String sentenca, String exp) {
        if (sentenca.matches(".*[^a-zA-Z0-9_].*")) {
            System.err.println(" Erro de sintaxe: Caractere inválido encontrado na expressão.");
            System.out.println();
        } else if (sentenca.contains("++") || sentenca.contains("--")) {
            System.err.println(" Erro de operação: Operadores de incremento/decremento não permitidos.");
            System.out.println();
        } else if (sentenca.matches("[0-9]+[a-zA-Z]+.*")) {
            System.err.println(" Erro de formato: Números não podem preceder letras.");
            System.out.println();
        } else {
            System.err.println(" Erro desconhecido ao validar a expressão.");
            System.out.println();
        }
    }

    // Método para testar múltiplas expressões
    public void testarExpressoes(String tipo, List<String> entradas) {
        if (tipo == null || tipo.isEmpty()) {
            System.err.println("❌ Erro: Tipo de expressão não fornecido.\n");
            return;
        }
        
        System.out.println("🔍 Testando expressões regulares...\n");

        for (String entrada : entradas) {
            if (entrada == null || entrada.isEmpty()) {
                System.err.println(" Erro: Sentença de entrada vazia.\n");
                continue;
            }

            switch (tipo) {
                case "ASSINATURA_FUNCAO":
                    confere(ExpressaoRegular.ASSINATURA_FUNCAO, entrada);
                    break;

                case "PARAMETROS_FUNCAO":
                    confere(ExpressaoRegular.PARAMETROS_FUNCAO, entrada);
                    break;

                case "CONDICIONAL":
                    try {
                        if (ER.validarCondicional(entrada)) {
                            System.out.println(" Condicional válida: " + entrada);
                        } else {
                            System.err.println("❌ Condicional inválida: " + entrada +"\n");
                        }
                    } catch (ChavesFaltandoException e) {
                        System.err.println("❌ Erro: " + e.getMessage() + "\n");
                    }
                    break;

                case "EXPRESSAO_MATEMATICA":
                    confere(ExpressaoRegular.EXPRESSAO_MATEMATICA, entrada);
                    break;

                default:
                    System.err.println("❌ Erro: Tipo desconhecido -> " + tipo + "\n");
                    break;
            }
        }
        
        System.out.println();
    }
}
