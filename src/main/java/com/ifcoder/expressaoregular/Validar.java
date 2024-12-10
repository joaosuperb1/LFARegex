/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.expressaoregular;

import static com.ifcoder.expressaoregular.ExpressaoRegular.CONDICIONAL;

/**
 *
 * @author cayo
 */
public class Validar {

    // Validação de condicional (if/else)
    public boolean validarCondicional(String condicional) throws ChavesFaltandoException {
        // Verifica se a expressão tem a estrutura básica de if
        if (condicional.matches("if\\s*\\(.*\\)\\s*\\{.*\\}")) {
            System.out.println("✅ Expressão condicional válida.");
            return true;
        } else {
            System.out.println("❌ Expressão condicional inválida: " + condicional);
            if (!condicional.contains("{") || !condicional.contains("}")) {
                throw new ChavesFaltandoException("Erro: Chaves faltando no bloco do if ou else. Expressão: " + condicional);
            }
            return false;
        }
    }

    // Validação de expressão matemática
    public boolean validarExpressaoMatematica(String expressao) {
        String regex = "([a-zA-Z_][a-zA-Z0-9_]*|[0-9]+)([+\\-*/^]([a-zA-Z_][a-zA-Z0-9_]*|[0-9]+))*(\\[\\d+\\])*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*";
        
        if (!expressao.matches(regex)) {
            System.out.println("❌ Justificativa: A expressão contém sintaxe inválida.");
            return false;
        }
        if (!verificarDivisaoPorZero(expressao)) {
            return false;
        }
        System.out.println("✅ Expressão matemática válida.");
        return true;
    }

    // Verificar divisão por zero
    public boolean verificarDivisaoPorZero(String expressao) {
        if (expressao.contains("/0")) {
            System.out.println("❌ Justificativa: Divisão por zero.");
            return false;
        }
        return true;
    }

    // Validação de assinatura de função
    public boolean validarAssinaturaFuncao(String assinatura) {
        String regex = "(void|[a-zA-Z_][a-zA-Z0-9_]*|[a-zA-Z_][a-zA-Z0-9_]*\\[])\\s+[a-zA-Z_][a-zA-Z0-9_]*\\(.*\\)";
        
        if (!assinatura.matches(regex)) {
            System.out.println("❌ Erro de sintaxe: Caractere inválido encontrado na expressão.");
            return false;
        }
        System.out.println("✅ Assinatura de função válida.");
        return true;
    }

    // Validação de parâmetros de função
    public boolean validarParametros(String parametros) {
        String regex = "([a-zA-Z_][a-zA-Z0-9_]*\\s+[a-zA-Z_][a-zA-Z0-9_]*)(\\s*,\\s*([a-zA-Z_][a-zA-Z0-9_]*\\s+[a-zA-Z_][a-zA-Z0-9_]*))*";
        
        if (!parametros.matches(regex)) {
            System.out.println("❌ Erro de sintaxe: Parâmetros inválidos.");
            return false;
        }
        System.out.println("✅ Parâmetros válidos.");
        return true;
    }
    
}

