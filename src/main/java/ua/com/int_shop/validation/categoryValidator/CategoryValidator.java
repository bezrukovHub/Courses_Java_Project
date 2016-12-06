package ua.com.int_shop.validation.categoryValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.int_shop.dao.CategoryDao;
import ua.com.int_shop.entity.Category;
import ua.com.int_shop.validation.Validator;

/**
 * Created by OlehB9 on 05.12.2016.
 */
@Component("categoryValidator")
public class CategoryValidator implements Validator{

    @Autowired
    private CategoryDao categoryDao;

    public void validate(Object object) throws Exception{
        Category category = (Category) object;

        if(category.getName().isEmpty()){
            throw new CategoryValidationException(CategoryValidationMessages.EMPTY_NAME_FIELD);
        }
        if(categoryDao.categoryExistsByName(category.getName()) == true){
            throw new CategoryValidationException(CategoryValidationMessages.NAME_ALREADY_EXIST);
        }

    }
}
