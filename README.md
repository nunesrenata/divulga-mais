# 🚀 Divulga Mais

🌐 **Acesso ao Projeto em Produção:** [divulga-mais-production.up.railway.app](https://divulga-mais-production.up.railway.app)

Sistema web desenvolvido em **Java com Spring MVC**, criado para divulgar serviços profissionais na internet por meio de uma plataforma moderna, intuitiva e responsiva.

O sistema permite que visitantes conheçam os serviços oferecidos, visualizem informações detalhadas, enviem mensagens de contato e registrem avaliações. Já a área administrativa oferece ferramentas completas para gerenciamento do conteúdo do site, proporcionando praticidade na administração dos serviços e no relacionamento com os clientes.

---

# ✨ Funcionalidades

## 👥 Área Pública

A área pública foi desenvolvida para proporcionar uma experiência agradável e interativa aos visitantes.

### Página Inicial

* Navbar responsiva e personalizada
* Hero (banner principal)
* Seção "Sobre o Profissional"
* Seção "Por que nos escolher?"
* Contadores animados de resultados
* Exibição dos serviços cadastrados
* Assistente Virtual (Chatbot IA): Interface interativa flutuante para engajamento do usuário, simulando um atendimento para tirar dúvidas rápidas
* Avaliações dos clientes
* Formulário para envio de avaliações com sistema de 1 a 5 estrelas
* Perguntas frequentes (FAQ) com respostas expansíveis
* Formulário de contato
* Rodapé personalizado com links rápidos, informações de contato e redes sociais
* Layout moderno, responsivo e adaptável para diferentes dispositivos
* Animações suaves nos formulários e elementos da interface

### Página de Serviços

* Botão "Veja mais sobre os serviços", que direciona para uma página contendo informações detalhadas sobre cada serviço
* Exibição dos serviços cadastrados com fotos personalizadas através de URL, nome, descrição e valor formatado
* Assistente Virtual (Chatbot IA): Integrado também à página de serviços para auxiliar o cliente na escolha do melhor plano

### Avaliações

Os visitantes podem:

* Informar nome e telefone
* Atribuir nota de 1 a 5 estrelas
* Escrever comentários

Todas as avaliações ficam disponíveis na página inicial.

### Contato

Formulário contendo:

* Nome
* E-mail
* Telefone
* Mensagem

---

# 🔐 Área Administrativa

A área administrativa concentra todas as funcionalidades de gerenciamento do sistema.

## Gerenciamento de Serviços

O administrador pode:

* Cadastrar novos serviços (nome, descrição, valor e URL da imagem)
* Consultar todos os serviços cadastrados
* Editar qualquer informação do serviço
* Excluir serviços

---

## Gerenciamento de Mensagens

Todas as mensagens enviadas pelo formulário de contato ficam registradas no sistema. O administrador pode:

* Visualizar todas as mensagens
* Identificar mensagens pendentes
* Marcar mensagens como respondidas
* Consultar o histórico de mensagens respondidas

---

## Gerenciamento de Avaliações

O administrador possui uma tela exclusiva para:

* Consultar todas as avaliações recebidas
* Visualizar nome do cliente, nota atribuída e comentário enviado

---

# 🌙 Modo Escuro

Todo o sistema conta com suporte ao **Dark Mode**, permitindo alternar entre o tema claro e o tema escuro por meio de um botão fixo na interface, armazenando a preferência do usuário.

---

# 🎨 Interface

O projeto foi desenvolvido priorizando uma interface moderna e organizada, contendo:

* Layout responsivo (Mobile First)
* Componentização utilizando JSP Include (Navbar e Footer)
* Cards interativos com efeitos de hover
* Uso intenso de Flexbox e CSS Grid
* Ícones vetoriais (FontAwesome)

---

# 🛠 Tecnologias Utilizadas

* **Backend:** Java, Spring MVC
* **Frontend:** JSP, JSTL, HTML5, CSS3, JavaScript
* **Banco de Dados:** PostgreSQL, JDBC
* **Infraestrutura:** Maven, Apache Tomcat
* **Utilitários:** Lombok
* **Deploy:** Railway

---

# 💾 Banco de Dados

O sistema utiliza o **PostgreSQL** como banco de dados. Principais tabelas:

* `usuario` (Acesso administrativo)
* `servico` (Catálogo de ofertas)
* `contato` (Mensagens recebidas)
* `avaliacao` (Feedback dos clientes)

---

# 📚 Arquitetura

O projeto foi desenvolvido seguindo o padrão MVC (Model-View-Controller), promovendo forte separação entre regras de negócio, acesso aos dados (DAO) e interface com o usuário (Views/JSP).

---

# 🎯 Objetivo

Desenvolver uma aplicação web completa para divulgação de serviços profissionais, aplicando de ponta a ponta os conceitos de desenvolvimento Java Web, arquitetura MVC, persistência de dados com PostgreSQL, criação de interfaces modernas com CSS avançado e deploy em nuvem.

---

# 👩‍💻 Desenvolvido por

**Renata Vitória Pereira**

Projeto desenvolvido para fins acadêmicos.
