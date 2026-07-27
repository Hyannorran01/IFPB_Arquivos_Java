public class TipoTriangulo {
    public static String classificar(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {return "Identificado que um lado é menor ou igual a Zero, logo, não se trata de um triângulo";}
        if ((a + b) <= c || (a + c) <= b || (b + c) <= a) {return "A soma dos lados tem que ser maior que o terceiro, senão não é triângulo";}


        if (a == b && b == c) {
            return "Triângulo Equilátero";
        } else if (a == b || a == c || b == c) {
            return "Triângulo Isósceles";
        } else {
            return "Triângulo Escaleno";
        }
    }
}

