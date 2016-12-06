package ua.com.int_shop.validation.customerValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.int_shop.dao.CustomerDao;
import ua.com.int_shop.entity.Customer;
import ua.com.int_shop.validation.Validator;

/**
 * Created by OlehB9 on 05.12.2016.
 */

@Component("customerValidator")
public class CustomerValidator implements Validator {

    @Autowired
    private CustomerDao customerDao;

    public void validate(Object object) throws Exception{
        Customer customer = (Customer) object;

        if(customer.getName().isEmpty()){
            throw new CustomerValidationException(ValidationMessages.EMPTY_NAME_FIELD);
        }
        if(customerDao.customerExistsByLogin(customer.getLogin()) == true){
            throw new CustomerValidationException(ValidationMessages.LOGIN_ALREADY_EXIST);
        }
        if(customerDao.customerExistsByEmail(customer.getEmail()) == true){
            throw new CustomerValidationException(ValidationMessages.EMAIL_ALREADY_EXIST);
        }
        if(customer.getPassword().isEmpty()){
            throw new CustomerValidationException(ValidationMessages.EMPTY_PASSWORD_FIELD);
        }
        if(customer.getEmail().isEmpty()){
            throw new CustomerValidationException(ValidationMessages.EMPTY_EMAIL_FIELD);
        }

    }

}
