package ua.kiev.minaeva.ssml.element;


import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class SpeakElement extends AbstractElement {

    public SpeakElement() {
        super("speak", null);
    }

    @Override
    public String getTagName() {
        return "speak";
    }

    @Override
    public ElementContract getParent() {
        return null;
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

}
