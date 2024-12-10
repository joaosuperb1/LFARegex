/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.expressaoregular;

import static com.ifcoder.expressaoregular.ExpressaoRegular.CONDICIONAL;

/**
 * Exceção personalizada para tratar casos em que blocos de código em condicionais 
 * não estão devidamente delimitados por chaves.
 */
public class ChavesFaltandoException extends Exception {
    private static final long serialVersionUID = 1L;

    // Construtor com mensagem personalizada
    public ChavesFaltandoException(String mensagem) {
        super(mensagem);
    }

    // Construtor padrão (sem mensagem)
    public ChavesFaltandoException() {
        super("Erro: Chaves obrigatorias ausentes.");
    }
}


