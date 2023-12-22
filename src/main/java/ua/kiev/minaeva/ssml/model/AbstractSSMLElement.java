package ua.kiev.minaeva.ssml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSSMLElement implements SSMLElementContract {

    private String tagName;
    private SSMLElementContract parent;
    private List<SSMLElementContract> children = new ArrayList<>();
    private Map<String, String> attributes = new HashMap<>();

    @Override
    public void setParent(SSMLElementContract element) {
        this.parent = element;
    }

    @Override
    public SSMLElementContract getParent() {
        return this.parent;
    }

    @Override
    public void addChild(SSMLElementContract element) {
        this.children.add(element);
    }

    @Override
    public List<SSMLElementContract> getChildren() {
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

    public AbstractSSMLElement() {
    }

    public AbstractSSMLElement(String tagName, AbstractSSMLElement parent) {
        this.tagName = tagName;
        this.parent = parent;
    }
}
