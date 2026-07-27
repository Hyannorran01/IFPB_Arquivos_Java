public abstract class FormaGeometrica {
//Metodo Abstrato
    public abstract FormaGeometrica GetForma();

    }

//subclasses com metodos abstratos
    abstract class Circulo extends FormaGeometrica {

        public abstract Circulo GetForma();
    }

    abstract class Quadrado extends FormaGeometrica{

        public abstract Quadrado GetForma();


    }
