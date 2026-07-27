public class ContaBancaria {
    String titular;
    int numerodeconta;
    double saldo;

    public ContaBancaria(String titular, int numerodeconta, double saldo) {
        this.titular = titular;
        this.numerodeconta = numerodeconta;
        this.saldo = saldo;
    }

    public void sacar(double saldo){
        this.saldo = this.saldo-saldo;

    }

    public void depositar(double saldo){
        this.saldo = this.saldo+saldo;

    }

    public double exibirsaldo(){
        System.out.println(saldo);
        return saldo;
    }

    public static void main(String[] args) {
        ContaBancaria b1 = new ContaBancaria("Jose", 234, 200);

        b1.sacar(100);

        b1.depositar(300);

        System.out.println("O saldo é: " + b1.exibirsaldo());

    }
}
