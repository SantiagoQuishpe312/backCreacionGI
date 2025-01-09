package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvMember;
import ec.edu.espe.GrupoInvestigacion.dao.DaoUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvMember;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroupMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvMemberMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.UserMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInvMember implements IServiceInvMember {

    @Autowired
    private DaoInvMember daoInvMember;
    @Autowired
    private final InvMemberMapper invMemberMapper;

    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private DaoInvGroup daoInvGroup;

    @Autowired
    private InvGroupMapper invGroupMapper;



    @Autowired
    public ServiceInvMember(DaoInvMember daoInvMember, InvMemberMapper invMemberMapper, UserMapper userMapper) {
        this.daoInvMember = daoInvMember;
        this.invMemberMapper = invMemberMapper;
        this.userMapper=userMapper;
    }

    @Override
    public DtoInvMember find(Long id) {
        return invMemberMapper.toDto(daoInvMember.findByIdEnable(id).orElse(new ModelInvMember()));
    }
    @Override
    public List<DtoInvMember> findGroup(Long id){
        return daoInvMember.findByGroup(id).
                orElse(new ArrayList<>()).
                stream().
                map(invMemberMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<DtoUser> findInfoMembersByGroup(Long id) {

        return daoInvMember.findMembersInfoByGroup(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoInvMember> findAll() {
        return daoInvMember.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(invMemberMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoInvGroup findByUsername(String username) {
        Optional<ModelInvMember> modelInvGroup = daoInvMember.findByUsername(username);
        DtoInvGroup dtoInvGroup = new DtoInvGroup();
        dtoInvGroup.setNombreGrupoInv(modelInvGroup.get().getModelInvGroup().getName());
        dtoInvGroup.setIdGrupoInv(modelInvGroup.get().getModelInvGroup().getId());
        dtoInvGroup.setVision(modelInvGroup.get().getModelInvGroup().getVision());
        dtoInvGroup.setMision(modelInvGroup.get().getModelInvGroup().getMission());
        dtoInvGroup.setIdCoordinador(modelInvGroup.get().getModelUser().getIdUser());
        dtoInvGroup.setAcronimoGrupoinv(modelInvGroup.get().getModelInvGroup().getAcronym());
        dtoInvGroup.setEstadoGrupoInv(modelInvGroup.get().getModelInvGroup().getState());
        return dtoInvGroup;
    }

    @Override
    public void deleteUser(Long userId, Long groupId) {
        Optional<ModelInvMember> invMemberOptional = daoInvMember.findByuserGroup(userId,groupId);
        if (invMemberOptional.isPresent()) {
            daoInvMember.delete(invMemberOptional.get());
        } else {
            throw new RuntimeException("No se encontró el grupo para el usuario");
        }
    }
    @Override
    public Long save(DtoInvMember dtoInvMember) {
        Long userId = dtoInvMember.getIdUsuario();
        Long groupId = dtoInvMember.getIdGrupoInv();
        ModelUser modelUser = daoUser.findById(userId).orElse(new ModelUser());
        ModelInvGroup modelInvGroup = daoInvGroup.findById(groupId).orElse(new ModelInvGroup());
        ModelInvMember modelInvMember = invMemberMapper.toEntity(dtoInvMember);
        ModelInvMemberId id = new ModelInvMemberId();
        id.setModelUser(modelUser);
        id.setModelInvGroup(modelInvGroup);
        modelInvMember.setId(id);
        daoInvMember.save(modelInvMember);
        return modelUser.getIdUser();
    }
}
