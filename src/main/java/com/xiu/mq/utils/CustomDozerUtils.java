package com.xiu.mq.utils;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

/**
 * 对象深度拷贝工具
 */
public class CustomDozerUtils{
	
    public static void copy(Object source,Object target){
    	Mapper mapper = DozerBeanMapperBuilder.create()
    			.withMappingBuilder(new BeanMappingBuilder() {
    				protected void configure() {
	    					mapping(source.getClass(), target.getClass(),TypeMappingOptions.oneWay(),TypeMappingOptions.mapNull(false),TypeMappingOptions.mapEmptyString(false));
    					}
    					}
    			)
    			.build();
        mapper.map(source,target);
    }
}