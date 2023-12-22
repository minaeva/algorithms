package ua.kiev.minaeva.ssml.model;

public class Prosody extends AbstractSSMLElement {

    private String rate;
    private String pitch;

    public Prosody(AbstractSSMLElement parent, String rate, String pitch) {
        super("prosody", parent);
        this.rate = rate;
        this.pitch = pitch;
    }

    @Override
    public String getTagName() {
        return "prosody";
    }

    @Override
    public void addAttribute(String key, String value) {
        switch (key) {
            case "rate":
                this.rate = value;
                break;
            case "pitch":
                this.pitch = value;
                break;
            default:
                super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "rate" -> this.rate;
            case "pitch" -> this.pitch;
            default -> super.getAttribute(key);
        };
    }

    public String getRate() {
        return rate;
    }

    public String getPitch() {
        return pitch;
    }
}
