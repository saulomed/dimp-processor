package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0990 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private int qtdLin0;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public int getQtdLin0() { return qtdLin0; }
    public void setQtdLin0(int qtdLin0) { this.qtdLin0 = qtdLin0; }
}