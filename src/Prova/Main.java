package Prova;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Main {

    public static void questao1(RandomAccessFile arq1, OutputStream arq2) throws IOException {
        arq1.seek(arq1.length() - 100);
        int cont = 1;
        byte[] registro = new byte[100];
        try {
            while (arq1.getFilePointer() > -1) {
                int c = arq1.read(registro);
                arq2.write(registro);
                cont++;
                arq1.seek(arq1.length() - 100 * cont);
            }
        } catch (IOException IO) {
            arq1.close();
            arq2.close();
        }
    }

    public static void questao2(RandomAccessFile arq1, RandomAccessFile arq2) throws IOException {
        Registro reg = new Registro();
        while (arq1.getFilePointer() < arq1.length()) {
            reg.leRegistro(arq1);
            if (reg.getEmail().trim().endsWith("@gmail.com")) {
                reg.escreveRegistro(arq2);
            }
        }
    }

    public static void questao3(RandomAccessFile arqDe, RandomAccessFile arqOr, RandomAccessFile Saida) throws IOException {
        Registro registroArqDes = new Registro();
        registroArqDes.leRegistro(arqDe);
        Registro registroArqOrd = new Registro();
        long Dir = (arqOr.length() / 100) - 1;
        long Esq = 0;
        long Mei;
        while (arqDe.getFilePointer() < arqDe.length()) {
            while (Dir >= Esq) {
                Mei = (Dir + Esq) / 2;
                arqOr.seek(Mei * 100);
                registroArqOrd.leRegistro(arqOr);
                if (registroArqOrd.getChave().equals(registroArqDes.getChave())) {
                    registroArqOrd.escreveRegistro(Saida);
                    break;
                } else {
                    if (Integer.parseInt(registroArqOrd.getChave()) > Integer.parseInt(registroArqDes.getChave())) {
                        Dir = Mei - 1;
                    } else {
                        Esq = Mei + 1;
                    }
                }
            }
            registroArqDes.leRegistro(arqDe);
            Dir = (arqOr.length() / 100) - 1;
            Esq = 0;
        }

    }

    public static void main(String[] args) throws Exception {
        RandomAccessFile arq1 = new RandomAccessFile("Data.dat", "r");
        RandomAccessFile arq3 = new RandomAccessFile("DataDes.dat", "r");
        //RandomAccessFile arq4 = new RandomAccessFile("Resp2.dat", "rw");
        RandomAccessFile arq5 = new RandomAccessFile("Resp3.dat", "rw");
        //OutputStream arq2 = new FileOutputStream("Resp1.dat");
        //questao1(arq1, arq2);
        //questao2(arq3, arq4);
        questao3(arq3, arq1, arq5);
    }
}
