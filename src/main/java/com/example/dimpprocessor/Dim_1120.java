package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_1120 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String ufDest;
    private String chaveNf;
    private String cnpjDest;
    private String cpfDest;
    private String idDest;
    private String chaveNfse;
    private String chaveDce;
    private String ufOrigem;
    private String cnpjOrigem;
    private String idPedido;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getUfDest() { return ufDest; }
    public void setUfDest(String ufDest) { this.ufDest = ufDest; }
    public String getChaveNf() { return chaveNf; }
    public void setChaveNf(String chaveNf) { this.chaveNf = chaveNf; }
    public String getCnpjDest() { return cnpjDest; }
    public void setCnpjDest(String cnpjDest) { this.cnpjDest = cnpjDest; }
    public String getCpfDest() { return cpfDest; }
    public void setCpfDest(String cpfDest) { this.cpfDest = cpfDest; }
    public String getIdDest() { return idDest; }
    public void setIdDest(String idDest) { this.idDest = idDest; }
    public String getChaveNfse() { return chaveNfse; }
    public void setChaveNfse(String chaveNfse) { this.chaveNfse = chaveNfse; }
    public String getChaveDce() { return chaveDce; }
    public void setChaveDce(String chaveDce) { this.chaveDce = chaveDce; }
    public String getUfOrigem() { return ufOrigem; }
    public void setUfOrigem(String ufOrigem) { this.ufOrigem = ufOrigem; }
    public String getCnpjOrigem() { return cnpjOrigem; }
    public void setCnpjOrigem(String cnpjOrigem) { this.cnpjOrigem = cnpjOrigem; }
    public String getIdPedido() { return idPedido; }
    public void setIdPedido(String idPedido) { this.idPedido = idPedido; }
}