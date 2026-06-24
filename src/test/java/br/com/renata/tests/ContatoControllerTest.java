package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.ContatoController;

public class ContatoControllerTest {

    private ContatoController controller;

    @BeforeEach
    public void setUp() {

        controller = new ContatoController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveEnviarContatoComSucesso() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Renata");
        request.addParameter("email", "renata@email.com");
        request.addParameter("telefone", "21999999999");
        request.addParameter("mensagem", "Olá.");

        ModelAndView model = controller.enviarContato(request);

        assertNotNull(model);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveRetornarRedirectAoEnviarContato() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Maria");
        request.addParameter("email", "maria@email.com");
        request.addParameter("telefone", "");
        request.addParameter("mensagem", "Mensagem.");

        ModelAndView model = controller.enviarContato(request);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveCriarSessao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Pedro");
        request.addParameter("email", "pedro@email.com");
        request.addParameter("telefone", "");
        request.addParameter("mensagem", "Teste.");

        controller.enviarContato(request);

        assertNotNull(request.getSession(false));

    }

    @Test
    public void deveAdicionarMensagemSucessoNaSessao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "João");
        request.addParameter("email", "joao@email.com");
        request.addParameter("telefone", "21988888888");
        request.addParameter("mensagem", "Mensagem enviada.");

        controller.enviarContato(request);

        HttpSession session = request.getSession();

        assertNotNull(session.getAttribute("mensagem_sucesso_contato"));

    }

    @Test
    public void deveAceitarTelefoneVazio() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Carlos");
        request.addParameter("email", "carlos@email.com");
        request.addParameter("telefone", "");
        request.addParameter("mensagem", "Contato.");

        ModelAndView model = controller.enviarContato(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarMensagemGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Fernanda");
        request.addParameter("email", "fernanda@email.com");
        request.addParameter("telefone", "21977777777");

        String mensagem =
                "Mensagem muito grande para validar o funcionamento do controller "
              + "durante o envio de contatos pelo formulário do sistema.";

        request.addParameter("mensagem", mensagem);

        ModelAndView model = controller.enviarContato(request);

        assertNotNull(model);
        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveConsultarContatos() {

        ModelAndView model = controller.consultarContatos();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewConsultaContatos() {

        ModelAndView model = controller.consultarContatos();

        assertEquals("admin/consulta-contatos", model.getViewName());

    }

    @Test
    public void modelNaoPodeSerNuloNaConsulta() {

        ModelAndView model = controller.consultarContatos();

        assertNotNull(model.getModel());

    }

    @Test
    public void viewConsultaNaoPodeSerVazia() {

        ModelAndView model = controller.consultarContatos();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void viewConsultaDeveConterAdmin() {

        ModelAndView model = controller.consultarContatos();

        assertTrue(model.getViewName().contains("admin"));

    }

    @Test
    public void deveRetornarModelAndViewNaConsulta() {

        ModelAndView model = controller.consultarContatos();

        assertNotNull(model);

    }
    
}