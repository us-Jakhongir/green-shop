package uz.webbrain.appgreenshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantCreateDto {
    private String name;
    private String description;
    private Long categoryId;
    private Long relatedId;
    private String size;
    private Long parentId;
    private LocalDateTime createdAt;
}
