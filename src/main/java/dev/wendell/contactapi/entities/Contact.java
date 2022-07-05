package dev.wendell.contactapi.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "CAMPO NOME OBRIGATÓRIO")
    @Size(min=3 ,max = 100, message = "CAMPO NOME DEVE CONTER NO MÁXIMO 100 CARACTERES")
    private String nome;
    @Size(max=10, message = "CAMPO RAMAL_INTERNO DEVE CONTER NO MÁXIMO 10 CARACTERES")
    @Column(name = "ramal_interno")
    private String ramalInterno;
    @Size(max = 16, message = "CAMPO RAMAL_EXTERNO DEVE CONTER NO MÁXIMO 16 CARACTERES")
    @Column(name = "ramal_externo")
    private String ramalExterno;
    @Size(max = 16, message = "CAMPO CORPORATIVO DEVE CONTER NO MÁXIMO 16 CARACTERES")
    private String corporativo;
    @Email(message = "EMAIL INVÁLIDO")
    @Size(max = 100, message = "CAMPO EMAIL DEVE CONTER NO MÁXIMO 100 CARACTERES")
    private String email;
    @NotBlank(message = "CAMPO SETOR OBRIGATÓRIO")
    @Size(min=3 ,max = 100, message = "CAMPO SETOR DEVE CONTER NO MÁXIMO 100 CARACTERES")
    private String setor;
    @Size(max = 255)
    @Column(name = "imagem_url")
    private String imagemUrl;

    private boolean status;

    public Contact() {
    }

    public Contact(Long id, String nome, String ramalInterno, String ramalExterno, String email, String corporativo, String setor, String imagemUrl, boolean status) {
        this.id = id;
        this.nome = nome;
        this.ramalInterno = ramalInterno;
        this.ramalExterno = ramalExterno;
        this.email = email;
        this.corporativo = corporativo;
        this.setor = setor;
        this.imagemUrl = imagemUrl;
        this.status = status;
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
