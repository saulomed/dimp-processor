package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_1600 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codIpPar;
    private String codCliente;
    private String periodo;
    private Double vlCanc;
    private String natOper;
    private String codMcapt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodIpPar() { return codIpPar; }
    public void setCodIpPar(String codIpPar) { this.codIpPar = codIpPar; }
    public String getCodCliente() { return codCliente; }
    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public Double getVlCanc() { return vlCanc; }
    public void setVlCanc(Double vlCanc) { this.vlCanc = vlCanc; }
    public String getNatOper() { return natOper; }
    public void setNatOper(String natOper) { this.natOper = natOper; }
    public String getCodMcapt() { return codMcapt; }
    public void setCodMcapt(String codMcapt) { this.codMcapt = codMcapt; }
}