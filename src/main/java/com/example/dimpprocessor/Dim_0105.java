package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0105 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String cnpj;
    private String nome;
    private Integer qtd;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Integer getQtd() { return qtd; }
    public void setQtd(Integer qtd) { this.qtd = qtd; }
}