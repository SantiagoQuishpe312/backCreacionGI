package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoArea;
import ec.edu.espe.GrupoInvestigacion.dao.DaoLine;
import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLineGetArea;
import ec.edu.espe.GrupoInvestigacion.mapper.AreaMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.LineMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import ec.edu.espe.GrupoInvestigacion.model.ModelLine;
import ec.edu.espe.GrupoInvestigacion.model.ModelRol;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceLine implements IServiceLine {
    @Autowired
    private DaoLine daoLine;

    @Autowired
    private DaoArea daoArea;

    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private AreaMapper areaMapper;

    public ServiceLine(DaoLine daoLine, DaoArea daoArea, LineMapper lineMapper){
        this.daoLine=daoLine;
        this.daoArea=daoArea;
        this.lineMapper=lineMapper;
    }
    @Override
    public DtoLine find(Long id) {
        System.out.println("id: "+id);
        return lineMapper.toDto(daoLine.findById(id).orElse(new ModelLine()));
    }

    @Override
    public List<DtoLine> findAll() {
        return daoLine.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(lineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoLine dtoLine){
        ModelLine modelLine=lineMapper.toEntity(dtoLine);
        ModelLine createdEntity=daoLine.save(modelLine);
        return createdEntity.getId();
    }

    @Override
    public DtoLineGetArea findAreaByLine(Long id) {
        Optional <ModelArea> modelArea=daoLine.findLineAreaById(id);
        DtoLineGetArea dtoLineGetArea=new DtoLineGetArea();
        if (!modelArea.isEmpty()){
            dtoLineGetArea.setArea(daoLine.findLineAreaById(id).map(areaMapper::toDto).orElse(new DtoArea()));
            dtoLineGetArea.setLine(daoLine.findById(id).map(lineMapper::toDto).orElse(new DtoLine()));
            return dtoLineGetArea;
        }
        throw new RuntimeException("No se encontraron resultados");
    }

    @Override
    public List<DtoLineGetArea> findAllAreaByLine(Long id) {
        return daoLine.findAllLinesAreas()  // Encuentra todas las líneas con sus áreas asociadas
                .orElse(new ArrayList<>())      // Si no hay resultados, retorna una lista vacía
                .stream()                       // Inicia el stream de la lista de resultados
                .map(line -> {                  // Mapea cada línea con su respectiva área
                    DtoLineGetArea dto = new DtoLineGetArea();
                    dto.setLine(lineMapper.toDto(line)); // Mapea la línea al DTO
                    dto.setArea(areaMapper.toDto(line.getModelArea())); // Mapea el área asociada al DTO
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void update(DtoLine dtoLine){
        ModelLine existingEntity=daoLine.findById(dtoLine.getIdLinea()).orElse(null);
        if(existingEntity!=null){
            ModelLine updatedEntity=lineMapper.toEntity(dtoLine);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoLine.save(existingEntity);
        }
    }

    @Override
    public List<DtoLine> findLineByArea(Long id) {
        return daoLine.findLineByArea(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(lineMapper::toDto)
                .collect(Collectors.toList());
    }

    private String[] getNullPropertyNames(Object source) {
        try {
            final BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
            final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            final Set<String> emptyNames = new HashSet<>();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                final Object propertyValue = propertyDescriptor.getReadMethod().invoke(source);
                if (propertyValue == null) {
                    emptyNames.add(propertyDescriptor.getName());
                }
            }
            String[] result = new String[emptyNames.size()];
            return emptyNames.toArray(result);
        } catch (Exception e) {
            return new String[0];
        }
    }
}
