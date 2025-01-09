package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dao.DaoLine;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup_Line;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Line;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroupMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroup_LineMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.LineMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInvGroupLine implements IServiceInvGroup_Line {
    @Autowired
    private DaoInvGroup_Line daoInvGroupLine;
    @Autowired
    private InvGroupMapper invGroupMapper;
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private InvGroup_LineMapper invGroupLineMapper;
    @Autowired
    private DaoLine daoLine;
    @Autowired
    private DaoInvGroup daoInvGroup;
    @Override
    public List<DtoInvGroup_Line> find(Long id) {
        return daoInvGroupLine.findByIdEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupLineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoInvGroup_Line> findAll() {
        return daoInvGroupLine.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupLineMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoInvGroup_Line dtoInvGroupLine){
        Long lineId=dtoInvGroupLine.getIdLinea();
        Long GroupId=dtoInvGroupLine.getIdGrupo();
        ModelLine modelLine=daoLine.findById(lineId).orElse(new ModelLine());
        ModelInvGroup modelInvGroup=daoInvGroup.findByIdEnable(GroupId).orElse(new ModelInvGroup());
        ModelInvGroup_Line modelInvGroupLine=invGroupLineMapper.toEntity(dtoInvGroupLine);
        ModelInvGroup_Line_Id id=new ModelInvGroup_Line_Id();
        id.setModelLine(modelLine);
        id.setModelInvGroup(modelInvGroup);
        modelInvGroupLine.setId(id);
        daoInvGroupLine.save(modelInvGroupLine);
        return lineId;
    }
    @Override
    public List<DtoLine> findByGroup(Long id){
   return daoInvGroupLine.findLine(id)
           .orElse(new ArrayList<>())
           .stream()
           .map(lineMapper::toDto)
           .collect(Collectors.toList());
    }
    @Override
    public void delete(Long groupId, Long lineId){
        Optional<ModelInvGroup_Line> invGroupLine=daoInvGroupLine.findByIds(groupId, lineId);
        if (invGroupLine.isPresent()){
            daoInvGroupLine.delete(invGroupLine.get());
        }
        else {
            throw new RuntimeException("no se encontraron datos");
        }
    }

    @Override
    @Transactional
    public void deleteByArea(Long id){
        try {
            int rowsDeleted = daoInvGroupLine.deleteByArea(id);
            if (rowsDeleted == 0) {
                throw new RuntimeException("No se encontraron líneas asociadas al área con ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar las líneas asociadas al área con ID: " + id, e);
        }    }
}
