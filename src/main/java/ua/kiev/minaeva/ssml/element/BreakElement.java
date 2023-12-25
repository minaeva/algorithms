package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class BreakElement extends AbstractElement {

    private String time;
    private String strength;

    public BreakElement(AbstractElement parent, String time, String strength) {
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
            case "time" -> this.time = value;
            case "strength" -> this.strength = value;
            default -> super.addAttribute(key, value);
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

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getTime() {
        return time;
    }

    public String getStrength() {
        return strength;
    }
}
