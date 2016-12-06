package ua.com.int_shop.validation.categoryValidator;

import ua.com.int_shop.entity.Category;

/**
 * Created by OlehB9 on 05.12.2016.
 */
public class CategoryValidationException extends Exception{

    public CategoryValidationException(String msg){
        super(msg);
    }

}
