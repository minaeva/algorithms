package ua.kiev.minaeva.ssml.model;

public class SSMLDocument {

    private final AbstractSSMLElement root = new SpeakElement();

    public SSMLDocument() {
    }

    public AbstractSSMLElement getRoot() {
        return root;
    }

}
