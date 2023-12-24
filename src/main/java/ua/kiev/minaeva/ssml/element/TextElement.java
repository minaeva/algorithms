package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

import java.util.Collections;
import java.util.List;

public class TextElement extends AbstractSSMLElement {

    private final String textContent;

    public TextElement(AbstractSSMLElement parent, String textContent) {
        super("text", parent);
        this.textContent = textContent;
    }

    @Override
    public String getTagName() {
        return "text";
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public void addChild(SSMLElementContract element) {
        throw new UnsupportedOperationException("Text nodes cannot have children.");
    }

    @Override
    public void addAttribute(String name, String value) {
        throw new UnsupportedOperationException("Text nodes cannot have attributes.");
    }

    @Override
    public List<SSMLElementContract> getChildren() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void accept(SSMLElementVisitor visitor) {
        visitor.visit(this);
    }

}