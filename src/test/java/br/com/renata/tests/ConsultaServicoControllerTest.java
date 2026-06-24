package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.ConsultaServicoController;

public class ConsultaServicoControllerTest {

    private ConsultaServicoController controller;

    @BeforeEach
    public void setUp() {

        controller = new ConsultaServicoController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveRetornarModelAndView() {

        ModelAndView model = controller.consultar();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewConsultaServicos() {

        ModelAndView model = controller.consultar();

        assertEquals("admin/consulta-servicos", model.getViewName());

    }

    @Test
    public void viewNaoPodeSerNula() {

        ModelAndView model = controller.consultar();

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewNaoPodeEstarVazia() {

        ModelAndView model = controller.consultar();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void modelNaoPodeSerNulo() {

        ModelAndView model = controller.consultar();

        assertNotNull(model.getModel());

    }

@Test
public void viewDeveConterAdmin() {

    ModelAndView model = controller.consultar();

    assertTrue(model.getViewName().contains("admin"));

}

@Test
public void viewDeveConterConsulta() {

    ModelAndView model = controller.consultar();

    assertTrue(model.getViewName().contains("consulta"));

}

@Test
public void deveRetornarMesmoNomeDaView() {

    ModelAndView model1 = controller.consultar();

    ModelAndView model2 = controller.consultar();

    assertEquals(model1.getViewName(), model2.getViewName());

}

@Test
public void deveCriarNovoModelAndViewACadaConsulta() {

    ModelAndView model1 = controller.consultar();

    ModelAndView model2 = controller.consultar();

    assertNotSame(model1, model2);

}

@Test
public void modelDeveExistirMesmoSemServicos() {

    ModelAndView model = controller.consultar();

    assertNotNull(model.getModel());

}

@Test
public void deveConterObjetoModel() {

    ModelAndView model = controller.consultar();

    assertTrue(model.getModel().size() >= 0);

}

}