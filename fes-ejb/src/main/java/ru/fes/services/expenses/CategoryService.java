package ru.fes.services.expenses;

import ru.fes.dao.impl.expenses.CategoryDao;
import ru.fes.dto.expenses.CategoryDto;
import ru.fes.entities.common.User;
import ru.fes.entities.expenses.Category;
import ru.fes.services.common.MapperService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Stateless
public class CategoryService {

    @Inject
    private CategoryDao dao;

    @Inject
    private MapperService mapperService;

    public void addDefaultForUser(User user){

    }

    public List<CategoryDto> getAll(){
        return mapperService.map(dao.findActive(), CategoryDto.class);
    }
}
