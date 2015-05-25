package ru.fes.services.expenses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fes.dao.impl.expenses.ValutaDao;
import ru.fes.dto.expenses.ValutaDto;
import ru.fes.entities.expenses.Valuta;
import ru.fes.services.common.MapperService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
public class ExpenseCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseCategoryService.class);
    @PersistenceContext
    EntityManager em;

    @Inject
    ValutaDao dao;

    @Inject
    MapperService mapperService;



    public List<Valuta> getAll() {
        return dao.findAll();
    }
    public List<Valuta> getAllHierarchical() {
        return dao.findAll();
    }


    public void update(ValutaDto dto) {
        dao.update(mapperService.map(dto, Valuta.class));
    }

    public void create(ValutaDto dto) {
        dao.insert(mapperService.map(dto, Valuta.class));
    }

    public void delete(UUID id) {
        Valuta valuta =
                em.getReference(Valuta.class, id);
        if (valuta != null) {
            em.remove(valuta);
        } else {
            throw new RuntimeException("Wrong id!");
        }
    }
}
