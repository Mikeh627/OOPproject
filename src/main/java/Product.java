public abstract class Product implements Item {

    private String Name, Manufacturer;
    private int ID;
    private ItemType type;

    public Product(String Name, String Manufacturer, ItemType type)
    {
        this.Name = Name;
        this.Manufacturer = Manufacturer;
        this.type = type;
    } // end constructor

    public String toString() {
        return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer +
                "\n" + "Type: " + type;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public ItemType getType() {
        return type;
    }
    public void setType(ItemType type) {
        this.type = type;
    }
}

class Widget extends Product{
    public Widget(String Name, String Manufacturer, ItemType type) {
        super(Name, Manufacturer, type);
    }
}