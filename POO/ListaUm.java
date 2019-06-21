
package listaum;

import java.util.Scanner;

/**
 *
 * @author Douglas Barbosa
 */
public class ListaUm {

    static long fibonnaci(int n){
        if (n < 2) {
            return n;
        } else {
            return fibonnaci(n - 1) + fibonnaci(n - 2);
        }
    }
    static void questao1A(){
        int n = 150;
        while (n <= 300) {
            System.out.print(" " + n);
            n++;
        }
    }
    static void questao1B(){
        long soma2 = (((1+1000)*1000)/2);
        System.out.println("\n " + soma2);
    }
    static void questao1C(){
        long cont = 0;
        while (cont <= 100) {            
            if ((cont%3) == 0) {
                System.out.print(" "+cont);
            }
            cont++;
        }
    }            
    static void questao1D(){
        int fat = 1;
        long resultado = 1;
        for (int i = 1; i <= 10; i++) {
            resultado = resultado*i;
            System.out.print(" "+resultado);
        }
    }
    static void questao1E(){
        int fat2 = 1;
        long resultado2 = 1;
        for (int i = 1; i <= 40; i++) {
            resultado2 = resultado2*i;
            System.out.print(" "+resultado2);
        }
    }
    static void questao1G(){
        int x = 13;
        while (x != 1) {
            if((x%2) == 0){
                x = x/2;
            }
            else{
                x = (3*x)+1;
            }
                System.out.print(" "+x);
        }
    }
    
        static void questao2(int a){
            Scanner s = new Scanner( System.in );
            int num = s.nextInt();
            int conta=0;
            for (int i = 1; i <= num; i++) {
                if ((num%i) == 0){
                    System.out.print(i + " ");
                    conta++;
                }
            }
            if (conta<3) {
                System.out.println("\n Este número é primo.");

            }
        }
    public static void main(String[] args) {
        //Questão 1 - A
        System.out.print("Respota da 1 - A ");
        ListaUm.questao1A();
        // ----------------------------------
        
        //Questão 1 - B
        System.out.print("\nRespota da 1 - B ");
        ListaUm.questao1B();
        // ----------------------------------
        
        //Questão 1 - C
        System.out.print("\nRespota da 1 - C ");
        ListaUm.questao1C();
        //-----------------------------------
        
        //Questão 1 - D 
        System.out.print("\nRespota da 1 - D ");
        ListaUm.questao1D();
        //-----------------------------------
        
        //Questão 1 - E 
        System.out.print("\nRespota da 1 - E ");
        ListaUm.questao1E();
        //-----------------------------------
        
        //Questão 1 - F
        System.out.print("\nRespota da 1 - F ");
        for (int y = 0; y < 10; y++) {
            System.out.print(", "+ ListaUm.fibonnaci(y));
        }
        //-----------------------------------
        
        //Questão 1 - G
        System.out.print("\nRespota da 1 - G ");
        ListaUm.questao1G();
        //-----------------------------------
        
        //Questão 2
        System.out.print("\nRespota da 2 = ");
        ListaUm.questao2(13);
        //-----------------------------------
    }
}
