public class MoviePlayer extends Product implements MultimediaControl {

    Screen screen;
    MonitorType monitorType;

    public MoviePlayer(String Name, String Manufacturer, Screen screen, MonitorType monitorType)
    {
        super(Name, Manufacturer, ItemType.VISUAL);
        this.screen = screen;
        this.monitorType = monitorType;
    } // end constructor

    public String toString() {
        return super.toString() + "\n" + screen + "\n" + "Monitor Type:" + monitorType;
    }

    public void play() {
        System.out.println("Playing movie");
    }

    public void stop() {
        System.out.println("Stopping movie");
    }

    public void previous() {
        System.out.println("Previous movie");
    }

    public void next() {
        System.out.println("Next movie");
    }
}
