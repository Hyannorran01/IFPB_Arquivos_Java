import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Q1 {

    public static void main(String[] args) throws DataFormatException, DataInvalidaException {
        try {
            Usuario usuario1 = new Usuario(LocalDate.of(2001, 9, 30));
            Usuario usuario2 = new Usuario(LocalDate.of(2030, 3, 30));
            Usuario usuario3 = new Usuario(LocalDate.of(2000, 03, 12));
            usuario1.TestarIdade();
            usuario2.TestarIdade();
            usuario3.TestarIdade();
        } catch (DataInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (DataFormatException z) {
            System.out.println("Formato não valido");
        }
    }
}
class Usuario{
    LocalDate dataNascimento;


    public Usuario(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public void TestarIdade() throws DataInvalidaException, DataFormatException {
        if (dataNascimento.isAfter(LocalDate.now())){
            throw new DataInvalidaException("Essa data de nascimento não é valida");
        }
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/M/yyyy");
        dataNascimento.format(formatador);
        System.out.println("A data é: " + dataNascimento.format(formatador));
        Period dataCalculada = Period.between(dataNascimento,LocalDate.now());

        System.out.println("Data ok!, voce possui a exata idade: " + dataCalculada.getYears() + "Anos");
    }
}


class DataInvalidaException extends Exception{
    public DataInvalidaException(String mensagem){
        super(mensagem);
    }
}
