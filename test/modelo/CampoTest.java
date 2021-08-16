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

    @Test
    void testeAbrirComVizinhos() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);

        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbrirComVizinhos2() {
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 1);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }

    @Test
    void testObjetivoAlcancado(){
        Campo campo = new Campo(3, 4);
        assertFalse(campo.objetivoAlcancado());
    }

    @Test
    void testMinasNaVizinhanca() {
        campo.minasNaVizinhanca();
    }
    @Test
    void testReiniciar() {
        campo.reiniciar();
    }
}