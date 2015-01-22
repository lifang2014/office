package com.common.design.factory.simple;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by lifang on 2015/1/11.
 */
public class ProductFactory {

    private static Product product = null;

    public static Product getProduct(String type){
        if(StringUtils.equals("A", type)){
            product = new FoodProduct();
        }else if(StringUtils.equals("B", type)){
            product = new CarProduct();
        }else{
            //expression
        }
        return product;
    }

}
