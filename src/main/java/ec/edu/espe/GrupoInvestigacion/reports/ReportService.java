package ec.edu.espe.GrupoInvestigacion.reports;

import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;

@Service
public class ReportService {
    public byte[] generarReport(String reportName) throws JRException {
        //carga el reporte
        InputStream reportSteam=this.getClass().getResourceAsStream("/reports/"+reportName+".jasper");
        Map<String, Object>params=null;
        JasperPrint jasperPrint= JasperFillManager.fillReport(reportSteam,params,new JREmptyDataSource());
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
