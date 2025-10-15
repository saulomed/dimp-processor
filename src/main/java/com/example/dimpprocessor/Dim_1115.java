package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dim_1115 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Context fields from parent records
    private String codCliente;
    private Date dtOp;
    private String codMcapt;
    private String cnpjAdqui;

    // Fields from the record itself
    private String reg;
    private String nsu;
    private String codAut;
    private String idTransac;
    private String indSplit;
    private String bandeira;
    private String hora;
    private Double valor;
    private String natOper;
    private String geo;
    private String indNatJur;
    private String indTpPix;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Date getDtOp() {
        return dtOp;
    }

    public void setDtOp(Date dtOp) {
        this.dtOp = dtOp;
    }

    public String getCodMcapt() {
        return codMcapt;
    }

    public void setCodMcapt(String codMcapt) {
        this.codMcapt = codMcapt;
    }

    public String getCnpjAdqui() {
        return cnpjAdqui;
    }

    public void setCnpjAdqui(String cnpjAdqui) {
        this.cnpjAdqui = cnpjAdqui;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCodAut() {
        return codAut;
    }

    public void setCodAut(String codAut) {
        this.codAut = codAut;
    }

    public String getIdTransac() {
        return idTransac;
    }

    public void setIdTransac(String idTransac) {
        this.idTransac = idTransac;
    }

    public String getIndSplit() {
        return indSplit;
    }

    public void setIndSplit(String indSplit) {
        this.indSplit = indSplit;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNatOper() {
        return natOper;
    }

    public void setNatOper(String natOper) {
        this.natOper = natOper;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getIndNatJur() {
        return indNatJur;
    }

    public void setIndNatJur(String indNatJur) {
        this.indNatJur = indNatJur;
    }

    public String getIndTpPix() {
        return indTpPix;
    }

    public void setIndTpPix(String indTpPix) {
        this.indTpPix = indTpPix;
    }
}