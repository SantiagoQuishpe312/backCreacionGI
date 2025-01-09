package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.reports.ReportService;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import net.sf.jasperreports.engine.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;
@RestController
@CrossOrigin(origins = "*")

@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/creationRequest")

public class ReportController {
   private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> generarReporte(){
        try{

            byte[] report =reportService.generarReport("SolicitudDeCreacion");
            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition","inLine;filename=report.pdf");
            return new ResponseEntity<>(report,headers,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
}

    @GetMapping("/generate-static-report")
    public ResponseEntity<byte[]> generateStaticReport() {
        try (InputStream reportStream = getClass().getResourceAsStream("/reports/SolicitudDeCreacion.jasper")) {
            if (reportStream == null) {
                throw new FileNotFoundException("No se encontró el archivo de reporte en la ruta especificada.");
            }

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param1", "valor1"); // Si hay parámetros

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").filename("SolicitudDeCreacion.pdf").build());

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (Exception e) {
            // Log del error para depuración
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
