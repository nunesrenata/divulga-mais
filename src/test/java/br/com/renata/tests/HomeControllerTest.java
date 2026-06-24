package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.HomeController;

public class HomeControllerTest {

    private HomeController controller;

    @BeforeEach
    public void setUp() {

        controller = new HomeController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveRetornarModelAndView() {

        ModelAndView model = controller.home();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewHome() {

        ModelAndView model = controller.home();

        assertEquals("site/home", model.getViewName());

    }

    @Test
    public void viewNaoPodeSerNula() {

        ModelAndView model = controller.home();

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewNaoPodeEstarVazia() {

        ModelAndView model = controller.home();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void modelNaoPodeSerNulo() {

        ModelAndView model = controller.home();

        assertNotNull(model.getModel());

    }

    @Test
    public void viewDeveConterSite() {

        ModelAndView model = controller.home();

        assertTrue(model.getViewName().contains("site"));

    }

    @Test
    public void viewDeveConterHome() {

        ModelAndView model = controller.home();

        assertTrue(model.getViewName().contains("home"));

    }

    @Test
    public void deveRetornarMesmoNomeDaView() {

        ModelAndView model1 = controller.home();
        ModelAndView model2 = controller.home();

        assertEquals(model1.getViewName(), model2.getViewName());

    }

    @Test
    public void deveCriarNovoModelAndViewACadaChamada() {

        ModelAndView model1 = controller.home();
        ModelAndView model2 = controller.home();

        assertNotSame(model1, model2);

    }

    @Test
    public void modelDeveExistirNaHome() {

        ModelAndView model = controller.home();

        assertNotNull(model.getModel());

    }

    @Test
    public void devePossuirObjetoModel() {

        ModelAndView model = controller.home();

        assertTrue(model.getModel().size() >= 0);

    }

}