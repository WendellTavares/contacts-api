package dev.wendell.contactapi.dtos;

import dev.wendell.contactapi.entities.Contact;

import java.io.Serializable;

public class ContactDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String ramalInterno;
    private String ramalExterno;
    private String email;
    private String corporativo;
    private String setor;
    private String imagemUrl;
    private boolean status;

    public ContactDTO() { }

    public ContactDTO(Contact obj) {
        id = obj.getId();
        nome = obj.getNome();
        ramalInterno = obj.getRamalInterno();
        ramalExterno = obj.getRamalExterno();
        email = obj.getEmail();
        corporativo = obj.getCorporativo();
        setor = obj.getSetor();
        imagemUrl = obj.getImagemUrl();
        status = obj.isStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRamalInterno() {
        return ramalInterno;
    }

    public void setRamalInterno(String ramalInterno) {
        this.ramalInterno = ramalInterno;
    }

    public String getRamalExterno() {
        return ramalExterno;
    }

    public void setRamalExterno(String ramalExterno) {
        this.ramalExterno = ramalExterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCorporativo() {
        return corporativo;
    }

    public void setCorporativo(String corporativo) {
        this.corporativo = corporativo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
