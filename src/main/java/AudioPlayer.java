public class AudioPlayer extends Product implements MultimediaControl {
    private String supportedAudioFormats;
    private String supportedPlaylistsFormats;

    AudioPlayer(String Name, String Manufacturer, String supportedAudioFormats, String supportedPlaylistsFormats){
        super(Name, Manufacturer, ItemType.AUDIO);
        this.supportedAudioFormats = supportedAudioFormats;
        this.supportedPlaylistsFormats = supportedPlaylistsFormats;
    } // end constructor

    public String toString() {
        return super.toString() + "Supported Audio Formats: " + supportedAudioFormats + "\n"
                + "Supported Playlist Formats: " + supportedPlaylistsFormats;
    }

    public void play() {
    System.out.println("Playing");
}

    public void stop() {
    System.out.println("Stopping");
}

    public void previous() {
    System.out.println("Previous");
}

    public void next() {
    System.out.println("Next");
}
}