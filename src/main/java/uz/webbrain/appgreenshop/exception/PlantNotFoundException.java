package uz.webbrain.appgreenshop.exception;

public class PlantNotFoundException extends RuntimeException{
    public PlantNotFoundException(String message) {
        super(message);
    }
}
