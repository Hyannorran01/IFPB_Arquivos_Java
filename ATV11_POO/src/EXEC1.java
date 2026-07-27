public class EXEC1 {
 //superclasse
    class Veiculo{


        public Veiculo GetVeiculo(){
            return this;
        }


    }
//Subclasses
    class  Carro extends Veiculo{
        @Override
        public Carro GetVeiculo(){
            return this;
        }
    }

     class Moto extends Veiculo{
        @Override
        public Moto GetVeiculo(){
            return this;
        }
    }

}


