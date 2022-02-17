package uz.webbrain.appgreenshop.dto.dto.request;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:22 PM
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private String name;
    private Long parentId;
}
