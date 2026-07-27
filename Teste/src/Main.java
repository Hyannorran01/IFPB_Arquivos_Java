import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//Constantes (variáveis static e final) devem ser escritas
//com o nome todo em maiúsculas e se o nome for
//formado por diversas palavras, cada palavra deve ser
//separada por um sublinhado ( “_” );

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // gragorian calender tem a particularidade de usar a contagem do mes de 0 a 11, por isso somamos mais 1 pra o mes se formos querer ver qual numero e se for para alterar é -1 para o calendario entender

        private GregorianCalendar calendar = new GregorianCalendar();

        public int getDia() {

            return this.calendar.get( Calendar.DAY_OF_MONTH );
        }

        public void setDia( int diaDoMes ) {

            this.calendar.set( Calendar.DAY_OF_MONTH , diaDoMes);
        }

        public void setMes( int mes ) {
            if ( mes >= 1 && mes <= 12 ) {

                this.calendar.set( Calendar.MONTH , mes - 1);

            }

        }

        public int getMes() {

            return this.calendar.get( Calendar.MONTH ) + 1;
        }

    }

//Nomes de classes devem sempre começar com uma letra
//maiúscula e se eles forem compostos por mais do que
//       uma palavra, a primeira letra de cada palavra também
//deve ser escrita em maiúsculo;

