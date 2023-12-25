package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class PElement extends AbstractElement {

    public PElement(AbstractElement parent) {
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
