package com.example.dimpprocessor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dim_0006 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;
    private String nomeTec;
    private String fone;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReg() { return reg; }
    public void setReg(String reg) { this.reg = reg; }
    public String getNomeTec() { return nomeTec; }
    public void setNomeTec(String nomeTec) { this.nomeTec = nomeTec; }
    public String getFone() { return fone; }
    public void setFone(String fone) { this.fone = fone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}