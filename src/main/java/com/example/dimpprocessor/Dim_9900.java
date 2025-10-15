package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_9900 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String regBlc;
    private int qtdRegBlc;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getRegBlc() { return regBlc; }
    public void setRegBlc(String regBlc) { this.regBlc = regBlc; }
    public int getQtdRegBlc() { return qtdRegBlc; }
    public void setQtdRegBlc(int qtdRegBlc) { this.qtdRegBlc = qtdRegBlc; }
}