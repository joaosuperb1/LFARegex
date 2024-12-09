/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.expressaoregular;

import java.util.List;


public class ConferirER {
           public void confere(String exp, String sentenca) {
        if (exp == null || exp.isEmpty()) { 
            System.err.println("Expressao regular invalida ou vazia.");
            return;
        }
        if ((sentenca == null) || sentenca.isEmpty()) {
            System.err.println("Sentenca vazia.");
            return;
        }
        try {
            if (sentenca.contains("/0")) {
                throw new ArithmeticException("ERRO MATEMATICO: Divisao por zero detectada.");
            }

            if (sentenca.matches(exp)) {
                System.out.println("W:'" + sentenca + "'........ ACEITA!");
            } else {
                System.err.println("W:'" + sentenca + "'........ rejeitada.");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao processar a expressao regular: " + e.getMessage());
        }
    }

    public void confereTrecho(String exp, List<String> exemplos) { 
    if (exemplos == null || exemplos.isEmpty()) {
        System.err.println("A lista de exemplos esta vazia ou e nula.");
        return;
    }
    System.out.println("Testando expressoes regulares...");
    for (String exemplo : exemplos) { /* itera por cada sentença */
        confere(exp, exemplo); /*testa cada sentença na expressão regular */
    }
    System.out.println();
}
    
}
