package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class ProsodyElement extends AbstractElement {

    private String rate;
    private String pitch;

    public ProsodyElement(AbstractElement parent, String rate, String pitch) {
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
            case "rate" -> this.rate = value;
            case "pitch" -> this.pitch = value;
            default -> super.addAttribute(key, value);
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

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getRate() {
        return rate;
    }

    public String getPitch() {
        return pitch;
    }
}
