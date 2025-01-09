package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoBudgetExecute;
import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;
import ec.edu.espe.GrupoInvestigacion.dto.DtoBudgetExecute;
import ec.edu.espe.GrupoInvestigacion.mapper.BudgetExecuteMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelBookChapter;
import ec.edu.espe.GrupoInvestigacion.model.ModelBudgetExecute;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceBudgetExecute implements IServiceBudgetExecute{
    @Autowired
    private DaoBudgetExecute daoBudgetExecute;
    @Autowired
    private BudgetExecuteMapper budgetExecuteMapper;
    @Override
    public DtoBudgetExecute find(Long id){
        return budgetExecuteMapper.toDto(daoBudgetExecute.findByIdEnable(id).orElse(new ModelBudgetExecute()));
    }
    @Override
    public List<DtoBudgetExecute> findAll(){
        return daoBudgetExecute.findAllEnable().orElseGet(ArrayList::new).stream().map(budgetExecuteMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Long save(DtoBudgetExecute dtoBudgetExecute){
        ModelBudgetExecute modelBudgetExecute=budgetExecuteMapper.toEntity(dtoBudgetExecute);
        ModelBudgetExecute createdEntity=daoBudgetExecute.save(modelBudgetExecute);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoBudgetExecute dtoBudgetExecute){
        ModelBudgetExecute existingEntity=daoBudgetExecute.findByIdEnable(dtoBudgetExecute.getIdPresupuesto()).orElse(null);
        if(existingEntity!=null){
            ModelBudgetExecute updatedEntity=budgetExecuteMapper.toEntity(dtoBudgetExecute);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoBudgetExecute.save(existingEntity);
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
