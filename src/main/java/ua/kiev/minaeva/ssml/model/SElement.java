package ua.kiev.minaeva.ssml.model;

public class SElement extends AbstractSSMLElement {

    public SElement(AbstractSSMLElement parent) {
        super("s", parent);
       }

    @Override
    public String getTagName() {
        return "s";
    }

}
