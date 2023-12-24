package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class VoiceElement extends AbstractSSMLElement {

    private String gender;
    private String variant;
    private String language;
    private String required;
    private String ordering;

    @Override
    public String getTagName() {
        return "voice";
    }

    public VoiceElement(AbstractSSMLElement parent, String gender, String variant,
                        String language, String required, String ordering) {
        super("voice", parent);
        this.gender = gender;
        this.variant = variant;
        this.language = language;
        this.required = required;
        this.ordering = ordering;
    }

    @Override
    public void addAttribute(String key, String value) {
        switch (key) {
            case "gender" -> this.gender = value;
            case "variant" -> this.variant = value;
            case "language" -> this.language = value;
            case "required" -> this.required = value;
            case "ordering" -> this.ordering = value;
            default -> super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        return switch (key) {
            case "gender" -> this.gender;
            case "variant" -> this.variant;
            case "language" -> this.language;
            case "required" -> this.required;
            case "ordering" -> this.ordering;
            default -> super.getAttribute(key);
        };
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

    public String getGender() {
        return gender;
    }

    public String getVariant() {
        return variant;
    }

    public String getLanguage() {
        return language;
    }

    public String getRequired() {
        return required;
    }

    public String getOrdering() {
        return ordering;
    }
}
