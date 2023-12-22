package ua.kiev.minaeva.ssml;

import org.w3c.dom.Element;

public class VoiceTagParser implements TagParser {

    @Override
    public void parse(Element element) {
        String voiceName = element.getAttribute("name");
        System.out.println("Voice " + voiceName);
    }
}
