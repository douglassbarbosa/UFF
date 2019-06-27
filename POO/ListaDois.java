import java.util.Scanner;
/**
 * @author Douglas Barbosa
 */
public class ListaDois {
    static float questao01a(){
            Scanner s = new Scanner( System.in );
            System.out.println("Informe a nota da P1");
            float p1 = s.nextFloat();
            System.out.println("Informe a nota da P2");
            float p2 = s.nextFloat();
            float media = (p1+p2)/2;
            return media;
        }
    static void questao01b(float notaFinal){
        if (notaFinal >= 6 ) {
            System.out.println("Aluno Aprovado");            
        }else{
            if(notaFinal <4) {
                System.out.println("Aluno reprovado!");
            }else{
                System.out.println("Aluno em Recuperação!");
            }
        }
    }
    static void questao02(){
        Scanner in = new Scanner(System.in); //Methodo Scanner
        String fraseNormal = in.nextLine(); //Input of the Line
        System.out.println("Nossa frase é: "+fraseNormal); //Our String normal
        StringBuffer sb = new StringBuffer(fraseNormal);
        sb.reverse();
        System.out.println("Nossa frase invertida: "+sb); //Output new String
    }
    static void questao03(){
        // Distância percorrida
        int distancia = 0;
        int x=0;
        int y=0;
        //Vetor de percurso
        int p[] = {1,2,3,2,5,1,4};
        //criar tabela com os valores 5x5
        int t[][] = {
                    {00,15,30,05,12},
                    {15,00,10,17,28},
                    {30,10,00,03,11},
                    {05,17,03,00,80},
                    {12,28,11,80,00}
        };
        //Calcular distância entre trechos
        for (int i = 0; i < 6; i++) {
            x = p[i]-1; //
            y = p[i+1]-1;
            distancia = distancia+t[x][y];
        }
        System.out.print("Distancia = "+distancia+" \n\n");
    }
    public static void main(String[] args) {
        //questao01b(questao01a());
        //questao02();
        //questao03();
    }
