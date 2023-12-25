package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class SubElement extends AbstractElement {

    private String alias;

    public SubElement(AbstractElement parent, String alias) {
        super("sub", parent);
        this.alias = alias;
    }

    @Override
    public void addAttribute(String key, String value) {
        if (key.equals("alias")) {
            this.alias = value;
        } else {
            super.addAttribute(key, value);
        }
    }

    @Override
    public String getAttribute(String key) {
        if (key.equals("alias")) {
            return this.alias;
        }
        return super.getAttribute(key);
    }

    @Override
    public String getTagName() {
        return "sub";
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

}
