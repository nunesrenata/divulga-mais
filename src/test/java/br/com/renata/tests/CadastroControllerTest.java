package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.CadastroController;

public class CadastroControllerTest {

    private CadastroController controller;

    @BeforeEach
    public void setUp() {

        controller = new CadastroController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveAbrirTelaCadastro() {

        ModelAndView model = controller.cadastro();

        assertNotNull(model);

        assertEquals("admin/cadastro-servico", model.getViewName());

    }

    @Test
    public void viewCadastroNaoPodeSerNula() {

        ModelAndView model = controller.cadastro();

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewCadastroNaoPodeEstarVazia() {

        ModelAndView model = controller.cadastro();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void viewDeveConterAdmin() {

        ModelAndView model = controller.cadastro();

        assertTrue(model.getViewName().contains("admin"));

    }

    @Test
    public void deveCadastrarServicoComSucesso() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Site Institucional");
        request.addParameter("descricao_servico", "Criação de site.");
        request.addParameter("valor_servico", "1200");
        request.addParameter("foto_servico", "https://teste.com/foto.jpg");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

        assertEquals("admin/cadastro-servico", model.getViewName());

    }

    @Test
    public void modelAndViewNaoPodeSerNuloAoCadastrar() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Landing Page");
        request.addParameter("descricao_servico", "Descrição");
        request.addParameter("valor_servico", "500");
        request.addParameter("foto_servico", "");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarFotoVazia() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Consultoria");
        request.addParameter("descricao_servico", "Consultoria especializada");
        request.addParameter("valor_servico", "850");
        request.addParameter("foto_servico", "");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);
        assertEquals("admin/cadastro-servico", model.getViewName());

    }

    @Test
    public void deveAceitarValorDecimal() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Desenvolvimento");
        request.addParameter("descricao_servico", "Sistema Web");
        request.addParameter("valor_servico", "1999.99");
        request.addParameter("foto_servico", "foto.png");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarNomeGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico",
                "Serviço Completo de Desenvolvimento de Sistemas Web");

        request.addParameter("descricao_servico", "Descrição completa.");

        request.addParameter("valor_servico", "3500");

        request.addParameter("foto_servico", "imagem.jpg");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarDescricaoGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Sistema");

        request.addParameter("descricao_servico",
                "Descrição muito grande para validar o comportamento do controller durante o cadastro do serviço.");

        request.addParameter("valor_servico", "1000");

        request.addParameter("foto_servico", "foto.jpg");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

    }

    @Test
    public void deveAdicionarMensagemSucessoQuandoCadastroForRealizado() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "API REST");
        request.addParameter("descricao_servico", "Integração");
        request.addParameter("valor_servico", "800");
        request.addParameter("foto_servico", "api.png");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model.getModel());

    }

    @Test
    public void deveRetornarMesmoNomeDaViewNoCadastro() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Teste");
        request.addParameter("descricao_servico", "Teste");
        request.addParameter("valor_servico", "10");
        request.addParameter("foto_servico", "");

        ModelAndView model = controller.cadastrarServico(request);

        assertEquals("admin/cadastro-servico", model.getViewName());

    }

    @Test
    public void deveTratarErroQuandoValorForInvalido() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome_servico", "Erro");
        request.addParameter("descricao_servico", "Teste");
        request.addParameter("valor_servico", "abc");
        request.addParameter("foto_servico", "");

        ModelAndView model = controller.cadastrarServico(request);

        assertNotNull(model);

        assertEquals("admin/cadastro-servico", model.getViewName());

        assertTrue(model.getModel().containsKey("mensagem_erro"));

    }

}