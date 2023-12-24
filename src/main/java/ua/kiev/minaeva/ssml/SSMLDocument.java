package ua.kiev.minaeva.ssml;

import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.element.SpeakElement;

public class SSMLDocument {

    private final AbstractSSMLElement root = new SpeakElement();

    public SSMLDocument() {
    }

    public AbstractSSMLElement getRoot() {
        return root;
    }

}
