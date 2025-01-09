package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.*;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroupGetData;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.mapper.*;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceInvGroup implements IServiceInvGroup {
    @Autowired
    private DaoInvGroup daoInvGroup;
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private DaoInvMember daoInvMember;
    @Autowired
    private DaoInvGroup_Area daoArea;
    @Autowired
    private DaoInvGroup_Line daoLine;

    @Autowired
    private DaoCreationReq daoCreationReq;
    @Autowired
    private InvGroupMapper invGroupMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AcademicDomainMapper academicDomainMapper;
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private DaoInvGroup_AcademicDomain daoAcademicDomain;
    @Autowired

    public ServiceInvGroup(DaoInvGroup daoInvGroup, DaoUser daoUser,InvGroupMapper invGroupMapper, DaoCreationReq daoCreationReq){
        this.daoInvGroup=daoInvGroup;
        this.daoUser=daoUser;
        this.invGroupMapper=invGroupMapper;
        this.daoCreationReq=daoCreationReq;
    }
    @Override
    public DtoInvGroup find(Long id) {
        return invGroupMapper.toDto(daoInvGroup.findByIdEnable(id).orElse(new ModelInvGroup()));
    }

    public DtoInvGroup findByUser(Long id){
        return invGroupMapper.toDto(daoInvGroup.findByIdUser(id).orElse(new ModelInvGroup()));
    }
    @Override
    public List<DtoInvGroup> findAll() {
        return daoInvGroup.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoInvGroup dtoInvGroup){
        ModelInvGroup modelInvGroup=invGroupMapper.toEntity(dtoInvGroup);
        ModelInvGroup createdEntity=daoInvGroup.save(modelInvGroup);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoInvGroup dtoInvGroup) {
        ModelInvGroup existingEntity = daoInvGroup.findByIdEnable(dtoInvGroup.getIdGrupoInv()).orElse(null);
        if (existingEntity != null) {
            ModelInvGroup updatedEntity = invGroupMapper.toEntity(dtoInvGroup);
            ModelUser modelUser = daoUser.findByIdEnable(existingEntity.getModelUser().getIdUser()).orElse(null);
            System.out.println("No se encontró el usuario con ID: " + updatedEntity.getModelUser().getIdUser());

            if (modelUser != null) {
                ModelUser modelUse=daoUser.findByIdEnable(updatedEntity.getModelUser().getIdUser()).orElse(null);
                updatedEntity.setModelUser(modelUse);
            }

            BeanUtils.copyProperties(updatedEntity, existingEntity, getNullPropertyNames(updatedEntity));
            daoInvGroup.save(existingEntity);
        }
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

    @Override
    public DtoInvGroupGetData findAllData(Long id){
        Optional<ModelInvGroup> modelInvGroup=daoInvGroup.findByIdEnable(id);
        Optional<List<ModelUser>> modelUser=daoInvMember.findMembersInfoByGroup(id);
        Optional<List<ModelArea>> modelAreas=daoArea.findArea(id);
        Optional<List<ModelAcademicDomain>> modelAcademicDomains=daoAcademicDomain.findAcademicDomain(id);
        Optional<List<ModelLine>> modelLines=daoLine.findLine(id);
        DtoInvGroupGetData dtoInvGroupGetData=new DtoInvGroupGetData();
        if(!modelInvGroup.isEmpty()){
            dtoInvGroupGetData.setInvGroup(modelInvGroup.map(invGroupMapper::toDto).orElse(new DtoInvGroup()));
            dtoInvGroupGetData.setLine(modelLines.orElse(new ArrayList<>()).stream().map(lineMapper::toDto).collect(Collectors.toList()));
       dtoInvGroupGetData.setArea(modelAreas.orElse(new ArrayList<>()).stream().map(areaMapper::toDto).collect(Collectors.toList()));
       dtoInvGroupGetData.setAcademicDomain(modelAcademicDomains.orElse(new ArrayList<>()).stream().map(academicDomainMapper::toDTO).collect(Collectors.toList()));
       dtoInvGroupGetData.setUsers(modelUser.orElse(new ArrayList<>()).stream().map(userMapper::toDto).collect(Collectors.toList()));
      dtoInvGroupGetData.setCoordinador(daoUser.findByIdEnable(modelInvGroup.get().getModelUser().getIdUser()).map(userMapper::toDto).orElse(new DtoUser()));
       return dtoInvGroupGetData;
    }
        throw new RuntimeException("No se encontraron datos");
}}
