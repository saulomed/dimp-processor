package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0005 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String fant;
    private String endereco;
    private String cep;
    private String codMun;
    private String uf;
    private String nomeResp;
    private String fone;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getFant() { return fant; }
    public void setFant(String fant) { this.fant = fant; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getCodMun() { return codMun; }
    public void setCodMun(String codMun) { this.codMun = codMun; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getNomeResp() { return nomeResp; }
    public void setNomeResp(String nomeResp) { this.nomeResp = nomeResp; }
    public String getFone() { return fone; }
    public void setFone(String fone) { this.fone = fone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
