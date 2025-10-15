package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0201 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String codCliente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getCodCliente() { return codCliente; }
    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
}