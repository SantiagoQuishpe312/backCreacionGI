package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoRol;
import ec.edu.espe.GrupoInvestigacion.dao.DaoUser;
import ec.edu.espe.GrupoInvestigacion.dao.DaoUserRol;
import ec.edu.espe.GrupoInvestigacion.dto.DtoReqGetAcademicDom;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUserGetRol;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUserRol;
import ec.edu.espe.GrupoInvestigacion.mapper.UserRolMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.UserMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.RolMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ServiceUserRol implements IServiceUserRol {
    @Autowired
    private DaoUserRol daoUserRol;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRolMapper userRolMapper;
    @Autowired
    private RolMapper rolMapper;
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private DaoRol daoRol;

    @Autowired
    public ServiceUserRol(DaoUserRol daoUserRol,UserRolMapper userRolMapper){
        this.daoUserRol=daoUserRol;
        this.userRolMapper=userRolMapper;
    }
    @Override
    public List<DtoUserRol> find(Long id) {
        return daoUserRol.findByIdEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(userRolMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteRol(Long userId, Long rolId) {
        Optional<ModelUserRol> userRolOptional = daoUserRol.findByuserRol(userId, rolId);
        if (userRolOptional.isPresent()) {
            daoUserRol.delete(userRolOptional.get());
        } else {
            throw new RuntimeException("No se encontró el rol para el usuario");
        }
    }
    @Override
     public DtoUserGetRol findByUsername(String username) {
        Optional<List<ModelRol>> modelRol = daoUserRol.findByUsername(username);
        DtoUserGetRol dtoUserGetRol = new DtoUserGetRol();
        if (!modelRol.isEmpty()) {
            dtoUserGetRol.setUsuario(daoUser.findByUser(username).map(userMapper::toDto).orElse(new DtoUser()));
            dtoUserGetRol.setRoles(modelRol.get().stream().map(rolMapper::toDto).collect(Collectors.toList()));
            return dtoUserGetRol;
        }
        throw new RuntimeException("No se encontraron roles para el usuario");
    }

    @Override
    public List<DtoUserRol> findAll() {
        return daoUserRol.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(userRolMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoUserRol dtoUserRol){
        Long userId=dtoUserRol.getIdUsuario();
        Long rolId=dtoUserRol.getIdRoles();
        ModelUser modelUser=daoUser.findByIdEnable(userId).orElse(new ModelUser());
        ModelRol modelRol=daoRol.findByIdRol(rolId).orElse(new ModelRol());
        ModelUserRol modelUserRol=userRolMapper.toEntity(dtoUserRol);
        ModelUserRolId id=new ModelUserRolId();
        id.setModelRol(modelRol);
        id.setModelUser(modelUser);
        modelUserRol.setId(id);
        daoUserRol.save(modelUserRol);
        return userId;
    }

}
