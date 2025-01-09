package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvMember;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;

import java.util.List;

public interface IServiceInvMember {
    public List<DtoInvMember> findAll();

    public DtoInvGroup findByUsername(String id);

    public DtoInvMember find(Long id);
    public List<DtoInvMember> findGroup(Long id);
    public List<DtoUser> findInfoMembersByGroup(Long id);
    void deleteUser(Long userId, Long groupId);

    Long save(DtoInvMember dtoInvMember);
}
