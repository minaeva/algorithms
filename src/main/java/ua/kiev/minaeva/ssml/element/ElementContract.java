package ua.kiev.minaeva.ssml.element;

import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

import java.util.List;
import java.util.Map;

public interface ElementContract {

    void setParent(ElementContract element);

    ElementContract getParent();

    void addChild(ElementContract element);

    List<ElementContract> getChildren();

    void addAttribute(String name, String value);

    String getAttribute(String key);

    Map<String, String> getAttributes();

    String getTagName();

    void accept(SSMLElementVisitor visitor);
}
