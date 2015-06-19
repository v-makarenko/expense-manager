package ru.fes.services.common;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ru.fes.dto.expenses.*;
import ru.fes.dto.user.UserDto;
import ru.fes.entities.common.User;
import ru.fes.entities.expenses.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by VMakarenko on 4/25/2015.
 */
@ApplicationScoped
public class MapperService {

    private MapperFactory mapperFactory;

    @PostConstruct
    public void init(){
        mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Expense.class, ExpenseDto.class)
                .byDefault().register();

        mapperFactory.classMap(Category.class, CategoryDto.class)
                .field("parent.id","parentId")
//                .customize(new CustomMapper<Category, CategoryDto>() {
//                    @Override
//                    public void mapAtoB(Category category, CategoryDto categoryDto, MappingContext context) {
//                        categoryDto.setChildren(category.getChildren().stream().map(item -> map(item.getChildren(), CategoryDto.class)
//                        ).collect(Collectors.toList()));
//                    }
//
//                    @Override
//                    public void mapBtoA(CategoryDto categoryDto, Category category, MappingContext context) {
//                        category.setChildren(categoryDto.getChildren().stream().map(item -> {
//                            return map(item.getChildren(), Category.class);
//                        }).collect(Collectors.toList()));
//                    }
//                })
                .byDefault().register();
        mapperFactory.classMap(UserDto.class, User.class)
                .byDefault().register();
        mapperFactory.classMap(ValutaDto.class, Valuta.class)
                .byDefault().register();
        mapperFactory.classMap(AccountDto.class, Account.class)
                .byDefault().register();
        mapperFactory.classMap(AccountTypeDto.class, AccountType.class)
                .byDefault().register();

    }

    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    public<E,D> D map(E from, Class<D> toClass){
        return mapperFactory.getMapperFacade().map(from, toClass);
    }
    public<E,D> List<D> map(List<E> from, final Class<D> toClass) {
        return from.parallelStream()
                .map(item -> map(item, toClass))
                .collect(Collectors.toList());
    }
}
