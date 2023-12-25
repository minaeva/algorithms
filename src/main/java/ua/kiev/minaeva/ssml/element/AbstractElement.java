package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractElement implements ElementContract {

    private String tagName;
    private ElementContract parent;
    private final List<ElementContract> children = new ArrayList<>();
    private final Map<String, String> attributes = new HashMap<>();

    @Override
    public void setParent(ElementContract element) {
        this.parent = element;
    }

    @Override
    public ElementContract getParent() {
        return this.parent;
    }

    @Override
    public void addChild(ElementContract element) {
        this.children.add(element);
    }

    @Override
    public List<ElementContract> getChildren() {
        return new ArrayList<>(this.children);
    }

    @Override
    public void addAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    @Override
    public String getAttribute(String key) {
        return this.attributes.get(key);
    }

    @Override
    public Map<String, String> getAttributes() {
        return new HashMap<>(this.attributes);
    }

    @Override
    public String getTagName() {
        return this.tagName;
    }

    public abstract void accept(SSMLElementVisitor visitor);

    public AbstractElement() {
    }

    public AbstractElement(String tagName, AbstractElement parent) {
        this.tagName = tagName;
        this.parent = parent;
    }
}
