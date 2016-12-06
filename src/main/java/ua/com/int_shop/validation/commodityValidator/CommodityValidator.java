package ua.com.int_shop.validation.commodityValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.int_shop.dao.CommodityDao;
import ua.com.int_shop.entity.Commodity;
import ua.com.int_shop.validation.Validator;

/**
 * Created by OlehB9 on 05.12.2016.
 */
@Component("commodityValidator")
public class CommodityValidator implements Validator{

    @Autowired
    private CommodityDao commodityDao;

    public void validate(Object object) throws Exception{
        Commodity commodity = (Commodity) object;

        if(commodity.getName().isEmpty()){
            throw new CommodityValidationException(CommodityValidatorMessages.EMPTY_NAME_FIELD);
        }
        if(commodityDao.commodityExistsByName(commodity.getName()) == true){
            throw new CommodityValidationException(CommodityValidatorMessages.NAME_ALREADY_EXIST);
        }
        if(commodity.getPrice() == 0){
            throw new CommodityValidationException(CommodityValidatorMessages.EMPTY_PRICE_FIELD);
        }

    }


}
