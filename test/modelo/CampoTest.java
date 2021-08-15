package modelo;

import excecao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CampoTest {
    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoRealDistancia() {
        Campo vizinhoEsquerda = new Campo(3, 2);
        Campo vizinhoDireita = new Campo(4, 4);
        Campo naoVizinho = new Campo(0, 0);

        boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
        boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
        boolean resultadoNaoVizinho = campo.adicionarVizinho(naoVizinho);
        assertTrue(resultadoEsquerda);
        assertTrue(resultadoDireita);
        assertFalse(resultadoNaoVizinho);
    }

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testAbrirCampo() {
        assertFalse(campo.abrir());
    }

    @Test
    void TestAbrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }
}