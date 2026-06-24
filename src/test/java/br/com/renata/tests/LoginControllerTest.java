package br.com.renata.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.renata.controller.LoginController;

public class LoginControllerTest {

    private LoginController controller;

    @BeforeEach
    public void setUp() {

        controller = new LoginController();

    }

    @Test
    public void deveInstanciarController() {

        assertNotNull(controller);

    }

    @Test
    public void deveAbrirTelaLogin() {

        ModelAndView model = controller.abrirLogin();

        assertNotNull(model);

        assertEquals("site/login", model.getViewName());

    }

    @Test
    public void viewLoginNaoPodeSerNula() {

        ModelAndView model = controller.abrirLogin();

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewLoginNaoPodeEstarVazia() {

        ModelAndView model = controller.abrirLogin();

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void deveAutenticarComParametros() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "teste@email.com");
        request.addParameter("senha", "123456");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void modelNaoPodeSerNuloNaAutenticacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "admin@email.com");
        request.addParameter("senha", "123");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarEmailVazio() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "");
        request.addParameter("senha", "123");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarSenhaVazia() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "teste@email.com");
        request.addParameter("senha", "");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarEmailESenhaVazios() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "");
        request.addParameter("senha", "");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarEmailGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email",
                "usuario.muito.grande@dominioextremamentegrande.com.br");

        request.addParameter("senha", "123456");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void deveAceitarSenhaGrande() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "admin@email.com");

        request.addParameter("senha",
                "1234567890123456789012345678901234567890");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }

    @Test
    public void modelNaoPodeSerNuloComDadosInvalidos() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "x");
        request.addParameter("senha", "y");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model);

    }
    
    @Test
    public void viewLoginNaoPodeSerNulaNaAutenticacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "teste@email.com");
        request.addParameter("senha", "123");

        ModelAndView model = controller.autenticar(request);

        assertNotNull(model.getViewName());

    }

    @Test
    public void viewNaoPodeEstarVaziaNaAutenticacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "teste@email.com");
        request.addParameter("senha", "123");

        ModelAndView model = controller.autenticar(request);

        assertFalse(model.getViewName().isEmpty());

    }

    @Test
    public void deveRetornarModelAndViewEmTodasAsChamadas() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "usuario@email.com");
        request.addParameter("senha", "senha");

        ModelAndView model1 = controller.autenticar(request);
        ModelAndView model2 = controller.autenticar(request);

        assertNotNull(model1);
        assertNotNull(model2);

    }

    @Test
    public void deveCriarNovoModelAndViewACadaAutenticacao() {

        MockHttpServletRequest request = new MockHttpServletRequest();

        request.addParameter("email", "usuario@email.com");
        request.addParameter("senha", "123");

        ModelAndView model1 = controller.autenticar(request);
        ModelAndView model2 = controller.autenticar(request);

        assertNotSame(model1, model2);

    }

    @Test
    public void modelNaoPodeSerNuloAoAbrirLogin() {

        ModelAndView model = controller.abrirLogin();

        assertNotNull(model.getModel());

    }

    @Test
    public void viewDeveConterLogin() {

        ModelAndView model = controller.abrirLogin();

        assertTrue(model.getViewName().contains("login"));

    }

}