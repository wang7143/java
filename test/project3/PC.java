package test.project3;

public class PC implements Equipment{

    private String model; 
    private String display;

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }
    
}