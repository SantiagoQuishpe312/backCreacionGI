package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoGroupRegForm {
    private Long idFormularioRegistroGrupo;
    private Long idGrupoInv;
    private Long resolucion;
    private Boolean creacionFormCheck;
    private Boolean planDesarrolloCheck;
    private Boolean sumarioCheck;
    private Boolean certificadoCategoriaCheck;
    private Boolean curriculum;
    private Boolean minimoProfesoresCheck;
    private Boolean meritosCientificosCheck;
    private Character estado;
    private String usuarioCreacionFormReg;
    private Date fechaCreacionFormReg;
    private String usuarioModificacionFormReg;
    private Date fechaModificacionFormReg;
}
