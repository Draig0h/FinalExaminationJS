package FinalExamination;

public class Laptop {
    String model;
    int ram;
    int sizeHdd;
    String os;
    String color;

    public Laptop(String model, int ram, int sizeHdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.sizeHdd = sizeHdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop: " +
                "Model='" + model + '\'' +
                ", RAM=" + ram +
                ", Size HDD=" + sizeHdd +
                ", OS='" + os + '\'' +
                ", Color='" + color + '\'';
    }
}
