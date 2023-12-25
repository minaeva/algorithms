package ua.kiev.minaeva.ssml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ua.kiev.minaeva.ssml.document.SSMLDocument;
import ua.kiev.minaeva.ssml.element.AbstractElement;
import ua.kiev.minaeva.ssml.element.TextElement;
import ua.kiev.minaeva.ssml.parser.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/*
<speak>: The root element of any SSML document.
<voice>: Specifies the voice to be used for the text-to-speech conversion.
<prosodyElement>: Alters aspects of speech such as pitch, rate, and volume.
<break>: Inserts a pause in the speech.
<emphasis>: Indicates emphasized speech.
<sub>: Substitutes a portion of text with something else during the synthesis.
<say-as>: Specifies how the text should be interpreted and spoken (like dates, numbers, etc.).
<audio>: Includes an audio clip.
<p> and <s>: Define paragraphs and sentences, respectively.
<phoneme>: Specifies the pronunciation of a word or phrase.
<lexicon>: Refers to an external pronunciation dictionary.
<lang>: Indicates the language of a portion of the text.
        */
public class SSMLContext {

    private Map<String, TagParser> parsingStrategies;

    public SSMLDocument handleParsing(String string) {
        prepareStrategies();
        try {
            return parseSSML(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void prepareStrategies() {
        parsingStrategies = new HashMap<>();
        parsingStrategies.put("audio", new AudioTagParser(this));
        parsingStrategies.put("break", new BreakTagParser());
        parsingStrategies.put("emphasis", new EmphasisTagParser());
        parsingStrategies.put("p", new PParser(this));
        parsingStrategies.put("prosody", new ProsodyTagParser(this));
        parsingStrategies.put("say-as", new SayAsTagParser(this));
        parsingStrategies.put("s", new SParser(this));
        parsingStrategies.put("sub", new SubParser(this));
        parsingStrategies.put("voice", new VoiceTagParser(this));
    }

    private SSMLDocument parseSSML(String ssml) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(ssml)));
        document.getDocumentElement().normalize();

        Element rootElement = document.getDocumentElement();
        SSMLDocument ssmlDocument = new SSMLDocument();
        traverseNodes(rootElement, ssmlDocument.getRoot());
        return ssmlDocument;
    }

    public void traverseNodes(Node node, AbstractElement parent) {
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);

            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                parseElement(currentNode, parent);
            } else if (currentNode.getNodeType() == Node.TEXT_NODE) {
                parseText(currentNode, parent);
            }
        }
    }

    public void parseElement(Node currentNode, AbstractElement parent) {
        Element element = (Element) currentNode;
        String tagName = element.getTagName();
        TagParser parser = parsingStrategies.get(tagName);

        if (parser != null) {
            parser.parse(element, parent);
        } else {
            System.out.println("Unknown tag " + tagName);
        }
    }

    public void parseText(Node currentNode, AbstractElement parent) {
        String textContent = currentNode.getTextContent().trim();
        TextElement textElement = new TextElement(parent, textContent);
        parent.addChild(textElement);
    }
}
