package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.ServicoController;

public class ServicoControllerTest {

    private ServicoController controller;

    @BeforeEach
    public void setUp() {

        controller = new ServicoController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveRetornarModelAndView() {

        ModelAndView model = controller.servicos();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewServicos() {

        ModelAndView model = controller.servicos();

        assertEquals("site/servicos", model.getViewName());

    }

    @Test
    public void viewNaoPodeSerNula() {

        ModelAndView model = controller.servicos();

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewNaoPodeEstarVazia() {

        ModelAndView model = controller.servicos();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void modelNaoPodeSerNulo() {

        ModelAndView model = controller.servicos();

        assertNotNull(model.getModel());

    }

    @Test
    public void viewDeveConterSite() {

        ModelAndView model = controller.servicos();

        assertTrue(model.getViewName().contains("site"));

    }

    @Test
    public void viewDeveConterServicos() {

        ModelAndView model = controller.servicos();

        assertTrue(model.getViewName().contains("servicos"));

    }

    @Test
    public void deveRetornarMesmoNomeDaView() {

        ModelAndView model1 = controller.servicos();
        ModelAndView model2 = controller.servicos();

        assertEquals(model1.getViewName(), model2.getViewName());

    }

    @Test
    public void deveCriarNovoModelAndViewACadaChamada() {

        ModelAndView model1 = controller.servicos();
        ModelAndView model2 = controller.servicos();

        assertNotSame(model1, model2);

    }

}