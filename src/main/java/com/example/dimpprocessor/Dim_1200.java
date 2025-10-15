package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Dim_1200 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codIpPar;
    private String codCliente;
    private String codMcapt;
    private String nsu;
    private String codAut;
    private String idTransac;
    private Date dtOp;
    private Date dtCanc;
    private String tipoCanc;
    private Double vlOrig;
    private Double vlCanc;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodIpPar() { return codIpPar; }
    public void setCodIpPar(String codIpPar) { this.codIpPar = codIpPar; }
    public String getCodCliente() { return codCliente; }
    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
    public String getCodMcapt() { return codMcapt; }
    public void setCodMcapt(String codMcapt) { this.codMcapt = codMcapt; }
    public String getNsu() { return nsu; }
    public void setNsu(String nsu) { this.nsu = nsu; }
    public String getCodAut() { return codAut; }
    public void setCodAut(String codAut) { this.codAut = codAut; }
    public String getIdTransac() { return idTransac; }
    public void setIdTransac(String idTransac) { this.idTransac = idTransac; }
    public Date getDtOp() { return dtOp; }
    public void setDtOp(Date dtOp) { this.dtOp = dtOp; }
    public Date getDtCanc() { return dtCanc; }
    public void setDtCanc(Date dtCanc) { this.dtCanc = dtCanc; }
    public String getTipoCanc() { return tipoCanc; }
    public void setTipoCanc(String tipoCanc) { this.tipoCanc = tipoCanc; }
    public Double getVlOrig() { return vlOrig; }
    public void setVlOrig(Double vlOrig) { this.vlOrig = vlOrig; }
    public Double getVlCanc() { return vlCanc; }
    public void setVlCanc(Double vlCanc) { this.vlCanc = vlCanc; }
}