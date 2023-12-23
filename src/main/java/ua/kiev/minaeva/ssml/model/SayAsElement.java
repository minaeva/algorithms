package ua.kiev.minaeva.ssml.model;

public class SayAsElement extends AbstractSSMLElement {

    private String interpretAs;
    private String format;
    private String detail;

    public SayAsElement(AbstractSSMLElement parent, String interpretAs, String format, String detail) {
        super("say-as", parent);
        this.interpretAs = interpretAs;
        this.format = format;
        this.detail = detail;
    }

    @Override
    public String getTagName() {
        return "say-as";
    }

    @Override
    public void addAttribute(String key, String value) {
        switch (key) {
            case "interpretAs" -> this.interpretAs = value;
            case "format" -> this.format = value;
            case "detail" -> this.detail = value;
            default -> super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "interpretAs" -> this.interpretAs;
            case "format" -> this.format;
            case "detail" -> this.detail;
            default -> super.getAttribute(key);
        };
    }

    public String getInterpretAs() {
        return interpretAs;
    }

    public String getFormat() {
        return format;
    }

    public String getDetail() {
        return detail;
    }
}
