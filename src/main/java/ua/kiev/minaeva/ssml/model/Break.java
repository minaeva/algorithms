package ua.kiev.minaeva.ssml.model;

public class Break extends AbstractSSMLElement {

    private String time;
    private String strength;

    public Break(AbstractSSMLElement parent, String time, String strength) {
        super("break", parent);
        this.time = time;
        this.strength = strength;
    }

    @Override
    public String getTagName() {
        return "break";
    }

    @Override
    public void addAttribute(String key, String value) {
        switch (key) {
            case "time":
                this.time = value;
                break;
            case "strength":
                this.strength = value;
                break;
            default:
                super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "time" -> this.time;
            case "strength" -> this.strength;
            default -> super.getAttribute(key);
        };
    }

    public String getTime() {
        return time;
    }

    public String getStrength() {
        return strength;
    }
}
