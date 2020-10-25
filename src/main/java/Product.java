public class Product implements Item {

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
}

class Widget extends Product{
    public Widget(String Name, String Manufacturer, ItemType type) {
        super(Name, Manufacturer, type);
    }
}