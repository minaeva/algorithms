package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class SayAsElement extends AbstractElement {

    private String interpretAs;
    private String format;
    private String detail;

    public SayAsElement(AbstractElement parent, String interpretAs, String format, String detail) {
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
            case "interpret-as" -> this.interpretAs = value;
            case "format" -> this.format = value;
            case "detail" -> this.detail = value;
            default -> super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "interpret-as" -> this.interpretAs;
            case "format" -> this.format;
            case "detail" -> this.detail;
            default -> super.getAttribute(key);
        };
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
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
