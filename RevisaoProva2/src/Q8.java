public class Q8 {
    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();
        Animal a3 = new Animal();


        a1.fazeracao();
        a2.fazeracao();
        a3.fazeracao();
    }
}

class Animal{
    public Animal fazeracao(){
        System.out.println("Barulho");
        return this;
    }
}

class Gato extends Animal{
    public Gato fazeracao() {
        System.out.println("Miaauu");
        return this;
    }
}

class  Cachorro extends Animal{
    public Cachorro fazeracao() {
        System.out.println("AUUUUU");
        return this;
    }
}



