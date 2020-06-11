package lab4;

public class Clothes {
    private String name;
    private String type;
    private int size;
    private String material;

    /**
     *
     * @param name - name of piece of clothing
     * @param type - which part clothing is
     * @param size - measure for all clothing
     * @param material -what current product consist of
     */

    public Clothes(String name, String type, int size, String material) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.material = material;
}

    public String getName() {return name; }

    public int getSize() { return size; }


    public String toString() {
        return "Cloth{" +
                "name= " + name +
                ", type= " + type +
                ", size= " + size +
                ", material= " + material + '}';

    }
}
