package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class PElement extends AbstractSSMLElement {

    public PElement(AbstractSSMLElement parent) {
        super("p", parent);
       }

    @Override
    public String getTagName() {
        return "p";
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

}
