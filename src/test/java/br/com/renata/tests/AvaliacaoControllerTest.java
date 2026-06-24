package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.AvaliacaoController;

public class AvaliacaoControllerTest {

    private AvaliacaoController controller;

    @BeforeEach
    public void setUp() {

        controller = new AvaliacaoController();

    }

    @Test
    public void deveSalvarAvaliacaoComSucesso() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Renata");

        request.addParameter("telefone", "21999999999");

        request.addParameter("nota", "5");

        request.addParameter("comentario", "Excelente atendimento.");

        ModelAndView model = controller.salvar(request);

        assertNotNull(model);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveRetornarRedirectAoSalvar() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Maria");

        request.addParameter("telefone", "21988888888");

        request.addParameter("nota", "4");

        request.addParameter("comentario", "Muito bom.");

        ModelAndView model = controller.salvar(request);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveAdicionarMensagemSucessoNaSessao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "João");

        request.addParameter("telefone", "21977777777");

        request.addParameter("nota", "5");

        request.addParameter("comentario", "Ótimo serviço.");

        controller.salvar(request);

        HttpSession session = request.getSession();

        assertNotNull(session.getAttribute("mensagem_sucesso_avaliacao"));

    }

    @Test
    public void deveAceitarNotaMinima() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Carlos");

        request.addParameter("telefone", "");

        request.addParameter("nota", "1");

        request.addParameter("comentario", "Regular.");

        ModelAndView model = controller.salvar(request);

        assertNotNull(model);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveAceitarNotaMaxima() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Ana");

        request.addParameter("telefone", "");

        request.addParameter("nota", "5");

        request.addParameter("comentario", "Perfeito.");

        ModelAndView model = controller.salvar(request);

        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveAceitarTelefoneVazio() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Pedro");

        request.addParameter("telefone", "");

        request.addParameter("nota", "3");

        request.addParameter("comentario", "Bom.");

        ModelAndView model = controller.salvar(request);

        assertNotNull(model);

    }
    
    @Test
    public void deveSalvarComentarioGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Fernanda");
        request.addParameter("telefone", "21988887777");
        request.addParameter("nota", "4");

        String comentario = "Excelente atendimento. Excelente atendimento. "
                + "Excelente atendimento. Excelente atendimento.";

        request.addParameter("comentario", comentario);

        ModelAndView model = controller.salvar(request);

        assertNotNull(model);
        assertEquals("redirect:/", model.getViewName());

    }

    @Test
    public void deveRetornarModelAndViewNaoNuloAoConsultarAvaliacoes() {

        ModelAndView model = controller.consultarAvaliacoes();

        assertNotNull(model);

    }

    @Test
    public void deveRetornarViewConsultaAvaliacoes() {

        ModelAndView model = controller.consultarAvaliacoes();

        assertEquals("admin/consulta-avaliacoes", model.getViewName());

    }

    @Test
    public void devePossuirObjetoAvaliacoesNoModelQuandoConsultar() {

        ModelAndView model = controller.consultarAvaliacoes();

        assertNotNull(model.getModel());

    }

    @Test
    public void modelNaoDeveSerNuloNaConsulta() {

        ModelAndView model = controller.consultarAvaliacoes();

        assertNotNull(model);

        assertNotNull(model.getModel());

    }

    @Test
    public void viewNaoPodeEstarVaziaNaConsulta() {

        ModelAndView model = controller.consultarAvaliacoes();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void deveCriarSessaoAoSalvarAvaliacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "José");
        request.addParameter("telefone", "");
        request.addParameter("nota", "5");
        request.addParameter("comentario", "Muito satisfeito.");

        controller.salvar(request);

        assertNotNull(request.getSession(false));

    }

    @Test
    public void deveRetornarSempreRedirectAoSalvar() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("nome", "Cliente");
        request.addParameter("telefone", "21911111111");
        request.addParameter("nota", "2");
        request.addParameter("comentario", "Pode melhorar.");

        ModelAndView model = controller.salvar(request);

        assertEquals("redirect:/", model.getViewName());

    }

}
