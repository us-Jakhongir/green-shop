package uz.webbrain.appgreenshop.utils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/18/2022
 * Time: 10:13 PM
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "0", value = "Sahifa indeksi (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", defaultValue = "20", value = "Har bitta sahifadagi elementlar soni"),
        @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query", value = "Sort qilish criteria si formar: property(,asc|desc)", allowMultiple = true)})
public @interface ApiPageable {
}
