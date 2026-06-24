package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.AdminController;

public class AdminControllerTest {

    private AdminController controller;

    @BeforeEach
    public void setUp() {

        controller = new AdminController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveRetornarModelAndView() {

        ModelAndView model = controller.dashboard();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewDashboard() {

        ModelAndView model = controller.dashboard();

        assertEquals("admin/dashboard", model.getViewName());

    }

    @Test
    public void modelNaoPodeSerNulo() {

        ModelAndView model = controller.dashboard();

        assertNotNull(model.getModel());

    }

    @Test
    public void viewNaoPodeEstarVazia() {

        ModelAndView model = controller.dashboard();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void viewDeveConterAdmin() {

        ModelAndView model = controller.dashboard();

        assertTrue(model.getViewName().contains("admin"));

    }

    @Test
    public void viewDeveConterDashboard() {

        ModelAndView model = controller.dashboard();

        assertTrue(model.getViewName().contains("dashboard"));

    }

    @Test
    public void deveRetornarSempreMesmoNomeDaView() {

        ModelAndView model1 = controller.dashboard();
        ModelAndView model2 = controller.dashboard();

        assertEquals(model1.getViewName(), model2.getViewName());

    }

    @Test
    public void deveCriarNovoModelAndViewACadaChamada() {

        ModelAndView model1 = controller.dashboard();
        ModelAndView model2 = controller.dashboard();

        assertNotSame(model1, model2);

    }

    @Test
    public void viewNaoDeveSerNula() {

        ModelAndView model = controller.dashboard();

        assertNotNull(model.getViewName());

    }

}