package ua.kiev.minaeva.ssml.model;

public class Voice extends AbstractSSMLElement {

    private String gender;
    private String variant;
    private String language;
    private String required;
    private String ordering;

    @Override
    public String getTagName() {
        return "voice";
    }

    public Voice(AbstractSSMLElement parent, String gender, String variant,
                 String language, String required, String ordering) {
        super("voice", parent);
        this.gender = gender;
        this.variant = variant;
        this.language = language;
        this.required = required;
        this.ordering = ordering;
    }

    @Override
    public void addAttribute(String name, String value) {
        switch (name) {
            case "gender":
                this.gender = value;
                break;
            case "variant":
                this.variant = value;
                break;
            case "language":
                this.language = value;
                break;
            case "required":
                this.required = value;
            case "ordering":
                this.ordering = value;
                break;
            default:
                System.out.println("Unknown tag " + name);
        }
    }

    @Override
    public String getAttribute(String name) {
        return switch (name) {
            case "gender" -> this.gender;
            case "variant" -> this.variant;
            case "language" -> this.language;
            case "required" -> this.required;
            case "ordering" -> this.ordering;
            default -> {
                System.out.println("Unknown tag " + name);
                yield null;
            }
        };
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
