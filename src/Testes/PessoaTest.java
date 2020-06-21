package Testes;

import Classes.Pessoa;
import Enums.Sexo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PessoaTest {
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa("Gabriela", 22, 53, 1.54, Sexo.FEMININO);
    }

    @Test
    void verificaSePessoaNaoENula() {
        assertNotNull(pessoa);
    }

    @Test
    void verificaRetornoGetK() {
        assertEquals(pessoa.getK(), 2);
    }

    @Test
    void verificaRetornoGetS() {
        assertEquals(pessoa.getS(), 0);
    }

}