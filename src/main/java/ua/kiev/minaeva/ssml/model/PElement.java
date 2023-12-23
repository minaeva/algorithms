package ua.kiev.minaeva.ssml.model;

public class PElement extends AbstractSSMLElement {

    public PElement(AbstractSSMLElement parent) {
        super("p", parent);
       }

    @Override
    public String getTagName() {
        return "p";
    }

}
