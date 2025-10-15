package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_1220 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String ufDest;
    private String chaveNf;
    private String cnpjDest;
    private String cpfDest;
    private String idDest;

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
}