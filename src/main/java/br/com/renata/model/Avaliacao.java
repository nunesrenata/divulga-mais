package br.com.renata.model;

import jakarta.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String comentario;
    private int nota;

    public Avaliacao() {}

    public Long getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public String getComentario() { return comentario; }
    public int getNota() { return nota; }

    public void setId(Long id) { this.id = id; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setNota(int nota) { this.nota = nota; }
}