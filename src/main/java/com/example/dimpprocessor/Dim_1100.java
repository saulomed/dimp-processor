package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dim_1100 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codIpPar;
    private String codCliente;
    private String indComex;
    private String indExtemp;
    private Date dtIni;
    private Date dtFin;
    private Double valor;
    private Integer qtd;

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
    public Date getDtIni() { return dtIni; }
    public void setDtIni(Date dtIni) { this.dtIni = dtIni; }
    public Date getDtFin() { return dtFin; }
    public void setDtFin(Date dtFin) { this.dtFin = dtFin; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Integer getQtd() { return qtd; }
    public void setQtd(Integer qtd) { this.qtd = qtd; }
}
