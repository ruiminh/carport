package business.entities;

public class Material {

    private int idMaterial;
    private String description;
    private String helpText;
    private double pricePerUnit;
    private int length;
    private int width;
    private int variation;


    public Material(int idMaterial, String description, String helpText, double pricePerUnit, int length, int width, int variation) {
        this.idMaterial = idMaterial;
        this.description = description;
        this.helpText = helpText;
        this.pricePerUnit = pricePerUnit;
        this.length = length;
        this.width = width;
        this.variation = variation;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getDescription() {
        return description;
    }

    public String getHelpText() {
        return helpText;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getVariation() {
        return variation;
    }
}
