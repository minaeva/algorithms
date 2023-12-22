package ua.kiev.minaeva.ssml.model;

import java.util.List;
import java.util.Map;

public interface SSMLElementContract {

    void setParent(SSMLElementContract element);

    SSMLElementContract getParent();

    void addChild(SSMLElementContract element);

    List<SSMLElementContract> getChildren();

    void addAttribute(String name, String value);

    String getAttribute(String key);

    Map<String, String> getAttributes();

    String getTagName();

}
