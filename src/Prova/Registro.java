package Prova;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Registro {
    private String chave;
    private String nome;
    private String email;
    private String telefone;
    
    public void leRegistro(RandomAccessFile RFA) throws IOException{
        byte chave[] = new byte[8];
        byte nome[] = new byte[40];
        byte email[] = new byte[40];
        byte telefone[] = new byte[11];
        RFA.readFully(chave);
        RFA.readFully(nome);
        RFA.readFully(email);
        RFA.readFully(telefone);
        RFA.readByte();
        Charset encode = Charset.forName("ISO-8859-1");
        this.chave = new String(chave, encode);
        this.nome = new String(nome, encode);
        this.email = new String(email, encode);
        this.telefone = new String(telefone, encode);
    }
    
    public void escreveRegistro(RandomAccessFile RFA) throws IOException{
        Charset encode = Charset.forName("ISO-8859-1");
        RFA.write(chave.getBytes(encode));
        RFA.write(nome.getBytes(encode));
        RFA.write(email.getBytes(encode));
        RFA.write(telefone.getBytes(encode));
        RFA.writeByte('\n');
    }
    
    public String getChave() {
        return chave;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
