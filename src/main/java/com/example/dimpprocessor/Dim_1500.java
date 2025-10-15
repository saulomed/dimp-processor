package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_1500 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codIpPar;
    private String codCliente;
    private String indComex;
    private String indExtemp;
    private String periodo;
    private Double valor;
    private Integer qtd;
    private String codMcapt;
    private String natOper;
    private String indNatJur;
    private String indTpPix;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodIpPar() { return codIpPar; }
    public void setCodIpPar(String codIpPar) { this.codIpPar = codIpPar; }
    public String getCodCliente() { return codCliente; }
    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
    public String getIndComex() { return indComex; }
    public void setIndComex(String indComex) { this.indComex = indComex; }
    public String getIndExtemp() { return indExtemp; }
    public void setIndExtemp(String indExtemp) { this.indExtemp = indExtemp; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Integer getQtd() { return qtd; }
    public void setQtd(Integer qtd) { this.qtd = qtd; }
    public String getCodMcapt() { return codMcapt; }
    public void setCodMcapt(String codMcapt) { this.codMcapt = codMcapt; }
    public String getNatOper() { return natOper; }
    public void setNatOper(String natOper) { this.natOper = natOper; }
    public String getIndNatJur() { return indNatJur; }
    public void setIndNatJur(String indNatJur) { this.indNatJur = indNatJur; }
    public String getIndTpPix() { return indTpPix; }
    public void setIndTpPix(String indTpPix) { this.indTpPix = indTpPix; }
}