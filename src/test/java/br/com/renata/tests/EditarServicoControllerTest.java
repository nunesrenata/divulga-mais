package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.EditarServicoController;

public class EditarServicoControllerTest {

    private EditarServicoController controller;

    @BeforeEach
    public void setUp() {

        controller = new EditarServicoController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveAbrirTelaEditarServico() {

        ModelAndView model = controller.editar(1);

        assertNotNull(model);

        assertEquals("admin/editar-servico", model.getViewName());

    }

    @Test
    public void viewEditarNaoPodeSerNula() {

        ModelAndView model = controller.editar(1);

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewEditarNaoPodeEstarVazia() {

        ModelAndView model = controller.editar(1);

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void modelNaoPodeSerNuloAoEditar() {

        ModelAndView model = controller.editar(1);

        assertNotNull(model.getModel());

    }

    @Test
    public void deveAtualizarServico() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "1");
        request.addParameter("nome", "Sistema Web");
        request.addParameter("descricao", "Descrição");
        request.addParameter("valor", "2500");
        request.addParameter("foto", "foto.jpg");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);

        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }

    @Test
    public void deveAtualizarServicoComFotoVazia() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "2");
        request.addParameter("nome", "Landing Page");
        request.addParameter("descricao", "Descrição");
        request.addParameter("valor", "1200");
        request.addParameter("foto", "");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);
        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }

    @Test
    public void deveAtualizarServicoComValorDecimal() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "3");
        request.addParameter("nome", "API");
        request.addParameter("descricao", "Integração");
        request.addParameter("valor", "1599.90");
        request.addParameter("foto", "api.jpg");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAtualizarServicoComNomeGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "4");
        request.addParameter("nome",
                "Sistema Completo de Gestão Empresarial");
        request.addParameter("descricao", "Descrição");
        request.addParameter("valor", "4500");
        request.addParameter("foto", "erp.jpg");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAtualizarServicoComDescricaoGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "5");
        request.addParameter("nome", "Sistema");

        request.addParameter("descricao",
                "Descrição bastante extensa para validar o funcionamento do controller durante a atualização.");

        request.addParameter("valor", "900");
        request.addParameter("foto", "foto.jpg");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);

    }

    @Test
    public void deveRetornarRedirectAposAtualizacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "6");
        request.addParameter("nome", "Teste");
        request.addParameter("descricao", "Teste");
        request.addParameter("valor", "100");
        request.addParameter("foto", "");

        ModelAndView model = controller.atualizar(request);

        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }

    @Test
    public void deveAtualizarServicoComValorZero() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("idServico", "7");
        request.addParameter("nome", "Teste");
        request.addParameter("descricao", "Teste");
        request.addParameter("valor", "0");
        request.addParameter("foto", "");

        ModelAndView model = controller.atualizar(request);

        assertNotNull(model);
        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }
    
    @Test
    public void deveExcluirServico() {

        ModelAndView model = controller.excluir(1);

        assertNotNull(model);

        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }

    @Test
    public void deveRetornarRedirectAoExcluir() {

        ModelAndView model = controller.excluir(2);

        assertEquals("redirect:/servicos/consulta", model.getViewName());

    }

    @Test
    public void viewExcluirNaoPodeSerNula() {

        ModelAndView model = controller.excluir(3);

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewExcluirNaoPodeEstarVazia() {

        ModelAndView model = controller.excluir(4);

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void deveCriarNovoModelAndViewAoExcluir() {

        ModelAndView model1 = controller.excluir(5);

        ModelAndView model2 = controller.excluir(5);

        assertNotSame(model1, model2);

    }

    @Test
    public void deveRetornarMesmoNomeDaViewAoExcluir() {

        ModelAndView model1 = controller.excluir(6);

        ModelAndView model2 = controller.excluir(7);

        assertEquals(model1.getViewName(), model2.getViewName());

    }

}
