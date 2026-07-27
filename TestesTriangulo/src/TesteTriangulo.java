import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteTriangulo {
    @Test
    public void testandoSeÉEquilatero() {
        String resultado = TipoTriangulo.classificar(3, 3, 3);
        assertEquals("Triângulo Equilátero", resultado);
    }
    @Test
    public void testandoSeÉIsosceles() {
        String resultado = TipoTriangulo.classificar(8, 8, 10);
        assertEquals("Triângulo Isósceles", resultado);
    }
    @Test
    public void testandoSeÉEscaleno() {
        String resultado = TipoTriangulo.classificar(3, 4, 5);
        assertEquals("Triângulo Escaleno", resultado);
    }
    @Test
    public void testandoSeTemLadoZero() {
        String resultado = TipoTriangulo.classificar(5, 0, 2);
        assertEquals("Identificado que um lado é menor ou igual a Zero, logo, não se trata de um triângulo", resultado);
    }
    @Test
    public void testandoSeOsLadosSãoMaiores() {
        String resultado = TipoTriangulo.classificar(1, 2, 8);
        assertEquals("A soma dos lados tem que ser maior que o terceiro, senão não é triângulo", resultado);
    }
}



