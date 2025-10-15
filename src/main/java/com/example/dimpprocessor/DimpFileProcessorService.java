package com.example.dimpprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DimpFileProcessorService {

    private static final Logger logger = LoggerFactory.getLogger(DimpFileProcessorService.class);

    // Repositories (omitted for brevity)
    @Autowired private Dim0000Repository dim0000Repository; @Autowired private Dim0001Repository dim0001Repository; @Autowired private Dim0005Repository dim0005Repository; @Autowired private Dim0006Repository dim0006Repository; @Autowired private Dim0100Repository dim0100Repository; @Autowired private Dim0105Repository dim0105Repository; @Autowired private Dim0200Repository dim0200Repository; @Autowired private Dim0201Repository dim0201Repository; @Autowired private Dim0300Repository dim0300Repository; @Autowired private Dim0600Repository dim0600Repository; @Autowired private Dim0700Repository dim0700Repository; @Autowired private Dim0990Repository dim0990Repository; @Autowired private Dim1001Repository dim1001Repository; @Autowired private Dim1100Repository dim1100Repository; @Autowired private Dim1110Repository dim1110Repository; @Autowired private Dim1115Repository dim1115Repository; @Autowired private Dim1120Repository dim1120Repository; @Autowired private Dim1200Repository dim1200Repository; @Autowired private Dim1220Repository dim1220Repository; @Autowired private Dim1500Repository dim1500Repository; @Autowired private Dim1600Repository dim1600Repository; @Autowired private Dim1990Repository dim1990Repository; @Autowired private Dim9001Repository dim9001Repository; @Autowired private Dim9900Repository dim9900Repository; @Autowired private Dim9990Repository dim9990Repository; @Autowired private Dim9999Repository dim9999Repository;


    // Line counters
    private int block0Lines, block1Lines, block9Lines, totalLines;

    // Stateful context holders
    private String currentCodCliente;
    private Date currentDtOp;
    private String currentCodMcapt;
    private String currentCnpjAdqui;

    public void processFile(String filePath) throws IOException, ParseException {
        // Reset counters and context
        block0Lines = 0; block1Lines = 0; block9Lines = 0; totalLines = 0;
        currentCodCliente = null; currentDtOp = null; currentCodMcapt = null; currentCnpjAdqui = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                String[] fields = line.split("[|]");
                String recordType = fields[1];

                if (recordType.startsWith("0")) block0Lines++;
                if (recordType.startsWith("1")) block1Lines++;
                if (recordType.startsWith("9")) block9Lines++;

                switch (recordType) {
                    case "1100":
                        currentCodCliente = fields[3]; // Capture context
                        processDim1100(fields);
                        break;
                    case "1110":
                        currentCodMcapt = fields[2]; // Capture context
                        currentDtOp = new SimpleDateFormat("yyyyMMdd").parse(fields[3]); // Capture context
                        currentCnpjAdqui = fields[6]; // Capture context
                        processDim1110(fields);
                        break;
                    case "1115":
                        processDim1115(fields); // Use context
                        break;
                    // Other cases (omitted for brevity)
                    case "0000": processDim0000(fields); break; case "0001": processDim0001(fields); break; case "0005": processDim0005(fields); break; case "0006": processDim0006(fields); break; case "0100": processDim0100(fields); break; case "0105": processDim0105(fields); break; case "0200": processDim0200(fields); break; case "0201": processDim0201(fields); break; case "0300": processDim0300(fields); break; case "0600": processDim0600(fields); break; case "0700": processDim0700(fields); break; case "0990": processDim0990(fields); break; case "1001": processDim1001(fields); break; case "1120": processDim1120(fields); break; case "1200": processDim1200(fields); break; case "1220": processDim1220(fields); break; case "1500": processDim1500(fields); break; case "1600": processDim1600(fields); break; case "1990": processDim1990(fields); break; case "9001": processDim9001(fields); break; case "9900": processDim9900(fields); break; case "9990": processDim9990(fields); break; case "9999": processDim9999(fields); break;
                }
            }
        }
    }

    private void processDim1115(String[] fields) {
        Dim_1115 dim1115 = new Dim_1115();

        // Set context from stateful fields
        dim1115.setCodCliente(currentCodCliente);
        dim1115.setDtOp(currentDtOp);
        dim1115.setCodMcapt(currentCodMcapt);
        dim1115.setCnpjAdqui(currentCnpjAdqui);

        // Set fields from current line
        dim1115.setReg(fields[1]);
        dim1115.setNsu(fields[2]);
        if (fields.length > 3) dim1115.setCodAut(fields[3]);
        if (fields.length > 4) dim1115.setIdTransac(fields[4]);
        if (fields.length > 5) dim1115.setIndSplit(fields[5]);
        if (fields.length > 6) dim1115.setBandeira(fields[6]);
        if (fields.length > 7) dim1115.setHora(fields[7]);
        if (fields.length > 8) dim1115.setValor(Double.parseDouble(fields[8].replace(',', '.')));
        if (fields.length > 9) dim1115.setNatOper(fields[9]);
        if (fields.length > 10) dim1115.setGeo(fields[10]);
        if (fields.length > 11) dim1115.setIndNatJur(fields[11]);
        if (fields.length > 12) dim1115.setIndTpPix(fields[12]);
        dim1115Repository.save(dim1115);
    }

    // ... other processing methods (omitted for brevity) ...
    private void processDim0001(String[] fields) { Dim_0001 dim0001 = new Dim_0001(); dim0001.setReg(fields[1]); dim0001.setIndMov(fields[2]); dim0001Repository.save(dim0001); }
    private void processDim0990(String[] fields) { int expectedCount = Integer.parseInt(fields[2]); if (expectedCount != block0Lines) { logger.warn("Block 0 integrity warning: Expected {} lines, but found {} lines.", expectedCount, block0Lines); } Dim_0990 dim0990 = new Dim_0990(); dim0990.setReg(fields[1]); dim0990.setQtdLin0(expectedCount); dim0990Repository.save(dim0990); }
    private void processDim1001(String[] fields) { Dim_1001 dim1001 = new Dim_1001(); dim1001.setReg(fields[1]); dim1001.setIndMov(fields[2]); dim1001Repository.save(dim1001); }
    private void processDim1990(String[] fields) { int expectedCount = Integer.parseInt(fields[2]); if (expectedCount != block1Lines) { logger.warn("Block 1 integrity warning: Expected {} lines, but found {} lines.", expectedCount, block1Lines); } Dim_1990 dim1990 = new Dim_1990(); dim1990.setReg(fields[1]); dim1990.setQtdLin1(expectedCount); dim1990Repository.save(dim1990); }
    private void processDim9001(String[] fields) { Dim_9001 dim9001 = new Dim_9001(); dim9001.setReg(fields[1]); dim9001.setIndMov(fields[2]); dim9001Repository.save(dim9001); }
    private void processDim9900(String[] fields) { Dim_9900 dim9900 = new Dim_9900(); dim9900.setReg(fields[1]); dim9900.setRegBlc(fields[2]); dim9900.setQtdRegBlc(Integer.parseInt(fields[3])); dim9900Repository.save(dim9900); }
    private void processDim9990(String[] fields) { int expectedCount = Integer.parseInt(fields[2]); if (expectedCount != block9Lines) { logger.warn("Block 9 integrity warning: Expected {} lines, but found {} lines.", expectedCount, block9Lines); } Dim_9990 dim9990 = new Dim_9990(); dim9990.setReg(fields[1]); dim9990.setQtdLin9(expectedCount); dim9990Repository.save(dim9990); }
    private void processDim9999(String[] fields) { int expectedCount = Integer.parseInt(fields[2]); if (expectedCount != totalLines) { logger.warn("Total File integrity warning: Expected {} lines, but found {} lines.", expectedCount, totalLines); } Dim_9999 dim9999 = new Dim_9999(); dim9999.setReg(fields[1]); dim9999.setQtdLin(expectedCount); dim9999Repository.save(dim9999); }
    private void processDim0000(String[] fields) throws ParseException { Dim_0000 dim0000 = new Dim_0000(); dim0000.setReg(fields[1]); dim0000.setCodVer(fields[2]); dim0000.setCodFin(fields[3]); dim0000.setUfFisco(fields[4]); dim0000.setCnpj(fields[5]); dim0000.setNome(fields[6]); dim0000.setDtIni(new SimpleDateFormat("yyyyMMdd").parse(fields[7])); dim0000.setDtFin(new SimpleDateFormat("yyyyMMdd").parse(fields[8])); dim0000.setTpAmb(fields[9]); dim0000.setMesVal(fields[10]); dim0000Repository.save(dim0000); }
    private void processDim0005(String[] fields) { Dim_0005 dim0005 = new Dim_0005(); dim0005.setReg(fields[1]); dim0005.setFant(fields[2]); dim0005.setEndereco(fields[3]); dim0005.setCep(fields[4]); dim0005.setCodMun(fields[5]); dim0005.setUf(fields[6]); dim0005.setNomeResp(fields[7]); dim0005.setFone(fields[8]); dim0005.setEmail(fields[9]); dim0005Repository.save(dim0005); }
    private void processDim0006(String[] fields) { Dim_0006 dim0006 = new Dim_0006(); dim0006.setReg(fields[1]); dim0006.setNomeTec(fields[2]); dim0006.setFone(fields[3]); dim0006.setEmail(fields[4]); dim0006Repository.save(dim0006); }
    private void processDim0100(String[] fields) { Dim_0100 dim0100 = new Dim_0100(); dim0100.setReg(fields[1]); dim0100.setCodCliente(fields[2]); dim0100.setCnpj(fields[3]); dim0100.setCpf(fields[4]); dim0100.setnFant(fields[5]); dim0100.setEndereco(fields[6]); dim0100.setCep(fields[7]); dim0100.setCodMun(fields[8]); dim0100.setUf(fields[9]); dim0100.setNomeResp(fields[10]); dim0100.setFoneCont(fields[11]); dim0100.setEmailCont(fields[12]); dim0100.setDtCreden(fields[13]); dim0100.setIndSub(fields[14]); dim0100Repository.save(dim0100); }
    private void processDim0105(String[] fields) { Dim_0105 dim0105 = new Dim_0105(); dim0105.setReg(fields[1]); dim0105.setCnpj(fields[2]); dim0105.setNome(fields[3]); dim0105.setQtd(Integer.parseInt(fields[4])); dim0105Repository.save(dim0105); }
    private void processDim0200(String[] fields) { Dim_0200 dim0200 = new Dim_0200(); dim0200.setReg(fields[1]); dim0200.setCodMcapt(fields[2]); dim0200.setNumLog(fields[3]); dim0200.setTipoTecn(fields[4]); dim0200.setTermProp(fields[5]); if (fields.length > 6) { dim0200.setMarca(fields[6]); } dim0200Repository.save(dim0200); }
    private void processDim0201(String[] fields) { Dim_0201 dim0201 = new Dim_0201(); dim0201.setReg(fields[1]); dim0201.setCodCliente(fields[2]); dim0201Repository.save(dim0201); }
    private void processDim0300(String[] fields) { Dim_0300 dim0300 = new Dim_0300(); dim0300.setReg(fields[1]); dim0300.setCodIpPar(fields[2]); dim0300.setCnpj(fields[3]); dim0300.setNome(fields[4]); dim0300.setEndereco(fields[5]); dim0300.setCep(fields[6]); dim0300.setCodMun(fields[7]); dim0300.setUf(fields[8]); dim0300.setNomeResp(fields[9]); dim0300.setFoneCont(fields[10]); dim0300.setEmailCont(fields[11]); dim0300Repository.save(dim0300); }
    private void processDim0600(String[] fields) throws ParseException { Dim_0600 dim0600 = new Dim_0600(); dim0600.setReg(fields[1]); dim0600.setTpAutoriz(fields[2]); dim0600.setCnpj(fields[3]); dim0600.setTpTransac(fields[4]); dim0600.setnFant(fields[5]); dim0600.setEndereco(fields[6]); dim0600.setCep(fields[7]); dim0600.setCodMun(fields[8]); dim0600.setUf(fields[9]); dim0600.setNomeResp(fields[10]); dim0600.setFoneCont(fields[11]); dim0600.setEmailCont(fields[12]); dim0600.setDtIniAut(new SimpleDateFormat("yyyyMMdd").parse(fields[13])); dim0600.setDtFimAut(new SimpleDateFormat("yyyyMMdd").parse(fields[14])); dim0600Repository.save(dim0600); }
    private void processDim0700(String[] fields) { Dim_0700 dim0700 = new Dim_0700(); dim0700.setReg(fields[1]); dim0700.setIdProc(fields[2]); dim0700Repository.save(dim0700); }
    private void processDim1100(String[] fields) throws ParseException { Dim_1100 dim1100 = new Dim_1100(); dim1100.setReg(fields[1]); dim1100.setCodIpPar(fields[2]); dim1100.setCodCliente(fields[3]); dim1100.setIndComex(fields[4]); dim1100.setIndExtemp(fields[5]); dim1100.setDtIni(new SimpleDateFormat("yyyyMMdd").parse(fields[6])); dim1100.setDtFin(new SimpleDateFormat("yyyyMMdd").parse(fields[7])); dim1100.setValor(Double.parseDouble(fields[8].replace(',', '.'))); dim1100.setQtd(Integer.parseInt(fields[9])); dim1100Repository.save(dim1100); }
    private void processDim1110(String[] fields) throws ParseException { Dim_1110 dim1110 = new Dim_1110(); dim1110.setReg(fields[1]); dim1110.setCodMcapt(fields[2]); dim1110.setDtOp(new SimpleDateFormat("yyyyMMdd").parse(fields[3])); dim1110.setValor(Double.parseDouble(fields[4].replace(',', '.'))); dim1110.setQtd(Integer.parseInt(fields[5])); dim1110.setCnpjAdqui(fields[6]); dim1110Repository.save(dim1110); }
    private void processDim1200(String[] fields) throws ParseException { Dim_1200 dim1200 = new Dim_1200(); dim1200.setReg(fields[1]); dim1200.setCodIpPar(fields[2]); dim1200.setCodCliente(fields[3]); dim1200.setCodMcapt(fields[4]); dim1200.setNsu(fields[5]); dim1200.setCodAut(fields[6]); dim1200.setIdTransac(fields[7]); dim1200.setDtOp(new SimpleDateFormat("yyyyMMdd").parse(fields[8])); dim1200.setDtCanc(new SimpleDateFormat("yyyyMMdd").parse(fields[9])); dim1200.setTipoCanc(fields[10]); dim1200.setVlOrig(Double.parseDouble(fields[11].replace(',', '.'))); dim1200.setVlCanc(Double.parseDouble(fields[12].replace(',', '.'))); dim1200Repository.save(dim1200); }
    private void processDim1220(String[] fields) { Dim_1220 dim1220 = new Dim_1220(); dim1220.setReg(fields[1]); dim1220.setUfDest(fields[2]); dim1220.setChaveNf(fields[3]); dim1220.setCnpjDest(fields[4]); dim1220.setCpfDest(fields[5]); dim1220.setIdDest(fields[6]); dim1220Repository.save(dim1220); }
    private void processDim1500(String[] fields) { Dim_1500 dim1500 = new Dim_1500(); dim1500.setReg(fields[1]); dim1500.setCodIpPar(fields[2]); dim1500.setCodCliente(fields[3]); dim1500.setIndComex(fields[4]); dim1500.setIndExtemp(fields[5]); dim1500.setPeriodo(fields[6]); dim1500.setValor(Double.parseDouble(fields[7].replace(',', '.'))); dim1500.setQtd(Integer.parseInt(fields[8])); dim1500.setCodMcapt(fields[9]); dim1500.setNatOper(fields[10]); dim1500.setIndNatJur(fields[11]); dim1500.setIndTpPix(fields[12]); dim1500Repository.save(dim1500); }
    private void processDim1600(String[] fields) { Dim_1600 dim1600 = new Dim_1600(); dim1600.setReg(fields[1]); dim1600.setCodIpPar(fields[2]); dim1600.setCodCliente(fields[3]); dim1600.setPeriodo(fields[4]); dim1600.setVlCanc(Double.parseDouble(fields[5].replace(',', '.'))); dim1600.setNatOper(fields[6]); dim1600.setCodMcapt(fields[7]); dim1600Repository.save(dim1600); }

    private void processDim1120(String[] fields) {
        Dim_1120 dim1120 = new Dim_1120();
        dim1120.setReg(fields[1]);
        dim1120.setUfDest(fields[2]);
        if (fields.length > 3) dim1120.setChaveNf(fields[3]);
        if (fields.length > 4) dim1120.setCnpjDest(fields[4]);
        if (fields.length > 5) dim1120.setCpfDest(fields[5]);
        if (fields.length > 6) dim1120.setIdDest(fields[6]);
        if (fields.length > 7) dim1120.setChaveNfse(fields[7]);
        if (fields.length > 8) dim1120.setChaveDce(fields[8]);
        if (fields.length > 9) dim1120.setUfOrigem(fields[9]);
        if (fields.length > 10) dim1120.setCnpjOrigem(fields[10]);
        if (fields.length > 11) dim1120.setIdPedido(fields[11]);
        dim1120Repository.save(dim1120);
    }

}
