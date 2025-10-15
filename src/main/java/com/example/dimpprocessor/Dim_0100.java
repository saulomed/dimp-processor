package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0100 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codCliente;
    private String cnpj;
    private String cpf;
    private String nFant;
    private String endereco;
    private String cep;
    private String codMun;
    private String uf;
    private String nomeResp;
    private String foneCont;
    private String emailCont;
    private String dtCreden;
    private String indSub;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodCliente() { return codCliente; }
    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getnFant() { return nFant; }
    public void setnFant(String nFant) { this.nFant = nFant; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getCodMun() { return codMun; }
    public void setCodMun(String codMun) { this.codMun = codMun; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getNomeResp() { return nomeResp; }
    public void setNomeResp(String nomeResp) { this.nomeResp = nomeResp; }
    public String getFoneCont() { return foneCont; }
    public void setFoneCont(String foneCont) { this.foneCont = foneCont; }
    public String getEmailCont() { return emailCont; }
    public void setEmailCont(String emailCont) { this.emailCont = emailCont; }
    public String getDtCreden() { return dtCreden; }
    public void setDtCreden(String dtCreden) { this.dtCreden = dtCreden; }
    public String getIndSub() { return indSub; }
    public void setIndSub(String indSub) { this.indSub = indSub; }
}
