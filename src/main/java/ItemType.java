// Enum that holds our product type values and their "codes"
public enum ItemType{
    AUDIO ("AU"),
    VISUAL ("VI"),
    AUDIO_MOBILE ("AM"),
    VISUAL_MOBILE ("VM");

    public final String code;
    ItemType(String code){
        this.code = code;
    }
    public String getCode() { return code; }
}