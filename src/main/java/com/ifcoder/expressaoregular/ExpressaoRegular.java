package com.ifcoder.expressaoregular;

public class ExpressaoRegular {

    public static final String BRANCO = "(\\s)";
    public static final String BRANCOS = BRANCO + "*";
    public static final String DIGITO = "([0-9])";
    public static final String DIGITOS = DIGITO + "+";
    public static final String TIPO = "(void|int|float|double|String|char)";
    public static final String LETRA = "([A-Za-z])";
    public static final String IDENT = "[A-Za-z_][A-Za-z0-9_]*";
    public static final String NUMEROS = "(" + DIGITOS + ")";
    public static final String OPERADORES_RELACIONAIS = "(==|!=|<=|>=|<|>|=!)";
    public static final String OPERADORES_MATEMATICOS = "(\\+|\\-|\\*|\\/|%)";

    // Assinatura de função
    public static final String ASSINATURA_FUNCAO = "\\b" + TIPO + "\\b\\s+" + IDENT + "\\s*\\(" +
            "(\\s*" + TIPO + "\\s+" + IDENT + "(\\s*,\\s*" + TIPO + "\\s+" + IDENT + ")*)?\\s*\\)";

    // Parâmetros da função
    public static final String PARAMETROS_FUNCAO = TIPO + BRANCOS + IDENT +
            "(\\s*,\\s*" + TIPO + BRANCOS + IDENT + ")*";

    // Condicional (if/else)
    public static final String CONDICIONAL = "if" + BRANCOS + "\\(" +
            // Parte esquerda da comparação
            "(" +
                // Aceita uma expressão matemática
                "(" + IDENT + "|" + DIGITOS + ")" +
                // Permite operações matemáticas
                "(" + BRANCOS + OPERADORES_MATEMATICOS + BRANCOS +
                "(" + IDENT + "|" + DIGITOS + "))*" +
            ")" +
            // Operador relacional
            BRANCOS + OPERADORES_RELACIONAIS + BRANCOS +
            // Parte direita da comparação
            "(" +
                "(" + IDENT + "|" + DIGITOS + ")" +
                "(" + BRANCOS + OPERADORES_MATEMATICOS + BRANCOS +
                "(" + IDENT + "|" + DIGITOS + "))*" +
            ")" +
            BRANCOS + "\\)" +
            "(\\s*\\{.*?\\})" +  // Espera as chaves obrigatórias
            "(\\s*else\\s*\\{.*?\\})?";  // Bloco 'else' opcional

    // Expressão matemática
    public static final String EXPRESSAO_MATEMATICA =
            "(" + IDENT + "|" + NUMEROS + "|\\(" + IDENT + "\\))" +
            "(" + BRANCOS + OPERADORES_MATEMATICOS + BRANCOS +
            "(" + IDENT + "|" + NUMEROS + "|\\(" + IDENT + "\\)))" +
            "*";

    public boolean validarCondicional(String expressao) throws ChavesFaltandoException {
        // Exibe a expressão que falhou
        if (!expressao.matches(CONDICIONAL)) {
            System.out.println("\n Expressão inválida: " + expressao);

            // Verifica se falta abertura ou fechamento de chaves
            if (!expressao.contains("{") || !expressao.contains("}")) {
                throw new ChavesFaltandoException("❌ Erro: Chaves faltando no bloco do if ou else.\n");
            }

            // Verifica se o bloco else está corretamente formatado
            if (expressao.contains("else") && (!expressao.contains("{") || !expressao.contains("}"))) {
                throw new ChavesFaltandoException("❌ Erro: Bloco do 'else' não está entre chaves.\n");
            }

            return false;
        }

        return true; // Retorna true se a expressão for válida
    }
}