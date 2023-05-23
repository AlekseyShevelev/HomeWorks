public class Notebook {
    private String model;
    private String vendor;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    
    public Notebook(String model, String vendor, int ram, int hdd, String os, String color) {
        this.model = model;
        this.vendor = vendor;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null) {
            throw new IllegalStateException("Название модели не может быть null");
        }
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram <= 0) {
            throw new IllegalStateException("Объем оперативной памяти должен быть положительным числом.");
        }
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        if (ram <= 0) {
            throw new IllegalStateException("Объем жесткого диска должен быть положительным числом.");
        }
        this.hdd = hdd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s %s (RAM-%d/HDD-%d/%s)", vendor, model, ram, hdd, os);
    }
}