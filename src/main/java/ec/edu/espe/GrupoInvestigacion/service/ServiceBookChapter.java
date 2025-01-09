package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoBookChapter;
import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;
import ec.edu.espe.GrupoInvestigacion.mapper.BookChapterMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelBookChapter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceBookChapter implements IServiceBookChapter{
@Autowired
    private DaoBookChapter daoBookChapter;
@Autowired
    private BookChapterMapper bookChapterMapper;
@Override
    public DtoBookChapter find(Long id){
    return bookChapterMapper.toDto(daoBookChapter.findByIdEnable(id).orElse(new ModelBookChapter()));
}
@Override
    public List<DtoBookChapter> findAll(){
    return daoBookChapter.findAllEnable().orElseGet(ArrayList::new).stream().map(bookChapterMapper::toDto).collect(Collectors.toList());
}
@Override
    public Long save(DtoBookChapter dtoBookChapter){
    ModelBookChapter modelBookChapter=bookChapterMapper.toEntity(dtoBookChapter);
    ModelBookChapter createdEntity=daoBookChapter.save(modelBookChapter);
    return createdEntity.getId();
}
@Override
public void update(DtoBookChapter dtoBookChapter){
    ModelBookChapter existingEntity=daoBookChapter.findByIdEnable(dtoBookChapter.getIdInformeActividades()).orElse(null);
    if(existingEntity!=null){
        ModelBookChapter updatedEntity=bookChapterMapper.toEntity(dtoBookChapter);
        BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
        daoBookChapter.save(existingEntity);
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
}
