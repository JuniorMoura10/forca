package br.com.pwa;

import java.util.Scanner;

public class Forca {

    public static void main(String[] args) {
        //Jogo da Forca
        String palavraChave = "bicicleta";
        String letrasUsadas = "";
        String palavraAdivinhada = "";
        int MAX_TENTATIVAS = 10;

        // fazendo os traços para a palavra
        for(int i = 0; i < palavraChave.length(); i++){
            palavraAdivinhada += "_";

            // contando as tentativas (for sem condição de término)
            for(int tentativas = 0; ; tentativas++){
                //criando a condição de término
                if(tentativas == MAX_TENTATIVAS){
                    System.out.printf("Foram 10 tentativas... A palavra era %s", palavraChave);
                    System.exit(0);
                }

                //mostrando a rodada atual e pedindo a próxima letra
                System.out.printf("Rodada %d. Até agora adivinhada: %s.%n Qual a sua próxima letra?%n", tentativas, palavraAdivinhada);

                //usando a classe Scanner para entrada do usuário pegando apenas uma letra
                char letraTentada = new Scanner(System.in).next().charAt(0);
                //verificando se a letra já foi usada ou não
                if(letrasUsadas.indexOf(letraTentada) >= 0){
                    System.out.printf("Você já tentou a letra %c%n.", letraTentada);
                }else{
                    letrasUsadas +=letraTentada;

                    if(palavraChave.indexOf(letraTentada) >=0){
                        palavraAdivinhada = "";

                        //Verifica se a palavarChave possui a letra. se possuir, faz a substituição. caso o contrário, mantém o traço.
                        for(int j = 0; j < palavraChave.length(); j++){
                            palavraAdivinhada += letrasUsadas.indexOf(palavraChave.charAt(j)) >= 0 ? palavraChave.charAt(j) : "_";
                        }

                        //Verificando se o jogo continua ou terminou
                        if(palavraAdivinhada.contains("_")){
                            System.out.printf("Muito bom! %s existe na palavra. Ainda existem letras escondidas.%n", letraTentada);
                        }else{
                            System.out.printf("Parabéns! A palavra era %s", palavraAdivinhada);
                            System.exit(0);
                        }
                    }else{
                        System.out.printf("Infelizmente, a letra %c não existe na palavra", letraTentada);
                    }
                }
            }
        }
    }
}
