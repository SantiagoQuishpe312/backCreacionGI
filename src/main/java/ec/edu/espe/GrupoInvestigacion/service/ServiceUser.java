package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dao.DaoUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.mapper.UserMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceUser implements IServiceUser {
    @Autowired
    private DaoUser daoUser;

    @Autowired
    private UserMapper userMapper;

    @Override
    public DtoUser find(Long id) {
        return userMapper.toDto(daoUser.findById(id).orElse(new ModelUser()));
    }

    @Override
    public DtoUser findByUser(String user){
        return userMapper.toDto(daoUser.findByUser(user).orElse(new ModelUser()));
    }
    @Override
    public List<DtoUser> findAll() {
        return daoUser.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoUser dtoUser){
        ModelUser modelUser=userMapper.toEntity(dtoUser);
        ModelUser createdEntity=daoUser.save(modelUser);
        return createdEntity.getIdUser();
    }

}
