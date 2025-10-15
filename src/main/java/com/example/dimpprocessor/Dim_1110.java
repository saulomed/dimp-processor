package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dim_1110 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codMcapt;
    private Date dtOp;
    private Double valor;
    private Integer qtd;
    private String cnpjAdqui;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodMcapt() { return codMcapt; }
    public void setCodMcapt(String codMcapt) { this.codMcapt = codMcapt; }
    public Date getDtOp() { return dtOp; }
    public void setDtOp(Date dtOp) { this.dtOp = dtOp; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Integer getQtd() { return qtd; }
    public void setQtd(Integer qtd) { this.qtd = qtd; }
    public String getCnpjAdqui() { return cnpjAdqui; }
    public void setCnpjAdqui(String cnpjAdqui) { this.cnpjAdqui = cnpjAdqui; }
}
