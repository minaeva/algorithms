package ua.kiev.minaeva.ssml.parser;

import org.w3c.dom.Element;
import ua.kiev.minaeva.ssml.model.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.model.VoiceElement;

public class VoiceTagParser implements TagParser {

    @Override
    public void parse(Element element, AbstractSSMLElement parent) {
        String genderAttribute = element.getAttribute("gender");
        String variantAttribute = element.getAttribute("variant");
        String languageAttribute = element.getAttribute("language");
        String requiredAttribute = element.getAttribute("required");
        String orderingAttribute = element.getAttribute("ordering");

        VoiceElement voiceElement = new VoiceElement(parent, genderAttribute, variantAttribute,
                languageAttribute, requiredAttribute, orderingAttribute);

        parent.addChild(voiceElement);
    }
}
