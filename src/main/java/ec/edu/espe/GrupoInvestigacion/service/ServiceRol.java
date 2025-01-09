package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoRol;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.dto.DtoRol;
import ec.edu.espe.GrupoInvestigacion.mapper.RolMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelRol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRol implements IServiceRol {
    @Autowired
    private DaoRol daoRol;

    @Autowired
    private RolMapper rolMapper;

    @Override
    public DtoRol find(Long id) {
        return rolMapper.toDto(daoRol.findByIdRol(id).orElse(new ModelRol()));
    }

    @Override
    public List<DtoRol> findAll() {
        return daoRol.findAllRol()
                .orElse(new ArrayList<>())
                .stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }
}
