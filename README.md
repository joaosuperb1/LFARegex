# LFA14_ExpressaoRegular

# Expressão Regular
- Este projeto é um exemplo prático sobre expressões regulares da disciplina LFA
- Perceba que estamos usando o método match da classe String e nada mais.
    - Com isso temos nas mãos um podereso regex (reconhecedor de expressões regulares)

# Maven
- Por ser um projeto Maven (gerenciador de dependencias atual) fique atento a algumas configurações no arquivo POM.xml
- Todas as dependencias que seu projeto serão colocadas neste arquivo XML 
- Caso necessite de alguma outra busque no repositorio central 
- https://search.maven.org/ ou https://mvnrepository.com/

# Atividade DESAFIO
 - Faças as Expressoes Regulares para reconhecer: 
 1. Assinatura de funções
    - ex: void funcao1(int a, float b) ex: String funcao2()
     
 2. Parametros de funções 
    - ex: int a, float b ex: float media, String nome
     
 3. Condicional 
    - ex: if(ano < 1990) ex: if(3*a != 4+t)
     
 4. Expressão matemática 
    - ex: 3+media/3 ex: -4+beta*media[1].x ex: soma(a,
    b)/4*vetor[5].idade
    
 - OBS_1: Muitos erros ocorrem por falta de parenteses em torno da expressão, logo use e abuse dos parenteses, eles nunca serão demais.
     
 - OBS_2: A cada nova Expressao Regualar feita, teste-a.