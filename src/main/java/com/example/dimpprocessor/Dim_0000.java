package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dim_0000 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codVer;
    private String codFin;
    private String ufFisco;
    private String cnpj;
    private String nome;
    private Date dtIni;
    private Date dtFin;
    private String tpAmb;
    private String mesVal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodVer() { return codVer; }
    public void setCodVer(String codVer) { this.codVer = codVer; }
    public String getCodFin() { return codFin; }
    public void setCodFin(String codFin) { this.codFin = codFin; }
    public String getUfFisco() { return ufFisco; }
    public void setUfFisco(String ufFisco) { this.ufFisco = ufFisco; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Date getDtIni() { return dtIni; }
    public void setDtIni(Date dtIni) { this.dtIni = dtIni; }
    public Date getDtFin() { return dtFin; }
    public void setDtFin(Date dtFin) { this.dtFin = dtFin; }
    public String getTpAmb() { return tpAmb; }
    public void setTpAmb(String tpAmb) { this.tpAmb = tpAmb; }
    public String getMesVal() { return mesVal; }
    public void setMesVal(String mesVal) { this.mesVal = mesVal; }
}
