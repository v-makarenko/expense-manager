package ru.fes.services.expenses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fes.dao.impl.expenses.AccountDao;
import ru.fes.dao.impl.expenses.CategoryDao;
import ru.fes.dto.expenses.CategoryDto;
import ru.fes.entities.expenses.Category;
import ru.fes.services.common.MapperService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 5/4/2015.
 */
@Stateless
public class CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @PersistenceContext
    EntityManager em;

    @Inject
    CategoryDao dao;

    @Inject
    MapperService mapperService;



    public List<CategoryDto> getAll() {
        return mapperService.map(dao.findAll(), CategoryDto.class);
    }


    public void update(CategoryDto dto) {
        dao.update(mapperService.map(dto, Category.class));
    }

    public void create(CategoryDto dto) {
        dao.insert(mapperService.map(dto, Category.class));
    }

    public void delete(UUID id) {
        Category category =
                em.getReference(Category.class, id);
        if (category != null) {
            em.remove(category);
        } else {
            throw new RuntimeException("Wrong id!");
        }
    }
}
