package Prova;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;
public class Gerador {
    
    public static int[] BubbleSort(int[] vetor){
        for (int i = 0; i < vetor.length-1; i++) {
            int aux;
            if (vetor[i] > vetor[i + 1]) {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                i = -1;
            }
        }
        return vetor;
    }
    
    public static void main(String[] args) throws Exception {
        String[] Nomes1 = {"Matheus", "Bernardo", "Lucas", "Daniel", "Pedro", "Julia", "Yasmin", "Rafaela", "Luan", "Vinicius"};
        String[] Nomes2 = {"Souza", "Peixoto", "Carvalho", "Silva", "Andrews", "Cid", "Simões", "Nascimento", "Cardozo", "Gratz"};
        String[] Emails = {"@yahoo.com", "@gmail.com", "@hotmail.com", "@outlook.com", "@cefet.com"};
        String[] DDD = {"33", "21", "24", "22", "24", "51", "11", "32"};
        OutputStream OS = new FileOutputStream("DataDes.dat");
        Random Rand = new Random();
        
        byte[] Nome = new byte[40];
        byte[] Email = new byte[40];
        
        int[] Chaves = new int[15];
        for (int i = 0; i < Chaves.length; i++) {
            Chaves[i] = (Rand.nextInt(89999999) + 10000000);
        }
        
        Chaves = BubbleSort(Chaves);
        
        for (int i = 0; i < 15; i++) {
            OS.write((Integer.toString(Chaves[i]).getBytes()));

            String nome = (Nomes1[Rand.nextInt(10)] + " " + Nomes2[Rand.nextInt(10)]);

            char[] auxNome = nome.toCharArray();
            for (int C = 0; C < auxNome.length; C++) {
                Nome[C] = (byte) auxNome[C];
            }
            for (int C = auxNome.length; C < 40; C++) {
                Nome[C] = ' ';
            }
            OS.write(Nome);
            
            String email = (nome.substring(0, nome.indexOf(" ")) + "-" + nome.substring(nome.indexOf(" ") + 1, nome.length()) + Emails[Rand.nextInt(5)]);
            char[] auxEm = email.toCharArray();
            for (int C = 0; C < auxEm.length; C++) {
                Email[C] = (byte) auxEm[C];
            }
            for (int C = auxEm.length; C < 40; C++) {
                Email[C] = ' ';
            }
            OS.write(Email);
            
            String telefone = (DDD[Rand.nextInt(8)] + "9" + (Rand.nextInt(89999999) + 10000000));
            OS.write(telefone.getBytes());
            OS.write('\n');
        }
    }
}
