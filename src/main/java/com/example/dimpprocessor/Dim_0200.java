package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0200 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codMcapt;
    private String numLog;
    private String tipoTecn;
    private String termProp;
    private String marca;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodMcapt() { return codMcapt; }
    public void setCodMcapt(String codMcapt) { this.codMcapt = codMcapt; }
    public String getNumLog() { return numLog; }
    public void setNumLog(String numLog) { this.numLog = numLog; }
    public String getTipoTecn() { return tipoTecn; }
    public void setTipoTecn(String tipoTecn) { this.tipoTecn = tipoTecn; }
    public String getTermProp() { return termProp; }
    public void setTermProp(String termProp) { this.termProp = termProp; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}