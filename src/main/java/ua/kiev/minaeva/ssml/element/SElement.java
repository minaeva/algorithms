package ua.kiev.minaeva.ssml.element;


import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class SElement extends AbstractElement {

    public SElement(AbstractElement parent) {
        super("s", parent);
       }

    @Override
    public String getTagName() {
        return "s";
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

}
