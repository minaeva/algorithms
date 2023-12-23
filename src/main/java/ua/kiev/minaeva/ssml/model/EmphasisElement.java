package ua.kiev.minaeva.ssml.model;

public class EmphasisElement extends AbstractSSMLElement {

    private String level;

    public EmphasisElement(AbstractSSMLElement parent, String level) {
        super("emphasis", parent);
        this.level = level;
    }

    @Override
    public String getTagName() {
        return "emphasis";
    }

    @Override
    public void addAttribute(String key, String value) {
        if (key.equals("level")) {
            this.level = value;
        } else {
            super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        if (key.equals("level")) {
            return this.level;
        }
        return super.getAttribute(key);
    }

    public String getLevel() {
        return level;
    }
}
