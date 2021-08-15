package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CampoTest {
    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoRealDistancia1() {
        Campo vizinhoEsquerda = new Campo(3, 2);
        Campo vizinhoDireita = new Campo(4, 4);
        Campo naoVizinho = new Campo(0, 0);

        boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
        boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
        boolean resultado = campo.adicionarVizinho(naoVizinho);
        assertTrue(resultadoEsquerda);
        assertTrue(resultadoDireita);
        assertFalse(resultado);
    }
}