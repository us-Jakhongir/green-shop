package uz.webbrain.appgreenshop.enums;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/17/2022
 * Time: 7:41 PM
 */
public enum PlantSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String description;

    PlantSize(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PlantSize getSize(String size){
        for(PlantSize plantSize : values()){
            if(plantSize.getDescription().equals(size)){
                return plantSize;
            }
        }
        throw new IllegalArgumentException(size + " is not a valid plant size");
    }
}
