package ua.kiev.minaeva.ssml;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ua.kiev.minaeva.ssml.element.AbstractSSMLElement;
import ua.kiev.minaeva.ssml.element.SSMLElementContract;
import ua.kiev.minaeva.ssml.element.TextElement;
import ua.kiev.minaeva.ssml.parser.*;
import ua.kiev.minaeva.ssml.visitor.PrintingVisitor;
import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

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

    private final static String ssmlFromGoogle = """
            <speak>
                      Here are <say-as interpret-as="characters">SSML</say-as> samples.
                      I can pause <break time="3s"/>.
                      I can play a sound
                      <audio src="https://www.example.com/MY_MP3_FILE.mp3">didn't get your MP3 audio file</audio>.
                      I can speak in cardinals. Your number is <say-as interpret-as="cardinal">10</say-as>.
                      Or I can speak in ordinals. You are <say-as interpret-as="ordinal">10</say-as> in line.
                      Or I can even speak in digits. The digits for ten are <say-as interpret-as="characters">10</say-as>.
                      I can also substitute phrases, like the <sub alias="World Wide Web Consortium">W3C</sub>.
                      Finally, I can speak a paragraph with two sentences.
                      <p><s>This is sentence one.</s><s>This is sentence two.</s></p>
            </speak>
            """;

    private final static String ssmlFromChatGpt = """
            <speak>
                Hello, <break time="500ms"/> and welcome to SSML parsing.
                <prosody rate="slow">This is a slow rate speaking.</prosody>
            </speak>
            """;

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
        parsingStrategies.put("voice", new VoiceTagParser());
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

    public void traverseNodes(Node node, AbstractSSMLElement parent) {
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

    private void parseElement(Node currentNode, AbstractSSMLElement parent) {
        Element element = (Element) currentNode;
        String tagName = element.getTagName();
        TagParser parser = parsingStrategies.get(tagName);

        if (parser != null) {
            parser.parse(element, parent);
        } else {
            System.out.println("Unknown tag " + tagName);
        }
    }

    private void parseText(Node currentNode, AbstractSSMLElement parent) {
        String textContent = currentNode.getTextContent().trim();
        TextElement textElement = new TextElement(parent, textContent);
        parent.addChild(textElement);
    }

    @Test
    void parseChatGPTString() {
        SSMLDocument ssmlDocument = handleParsing(ssmlFromChatGpt);
        printDocument(ssmlDocument);
    }

    @Test
    void parseGoogleString() {
        SSMLDocument ssmlDocument = handleParsing(ssmlFromGoogle);
        printDocument(ssmlDocument);
    }

    private void printDocument(SSMLDocument document) {
        SSMLElementVisitor visitor = new PrintingVisitor();
        document.getRoot().accept(visitor);
        for (SSMLElementContract child : document.getRoot().getChildren()) {
            child.accept(visitor);
        }
    }
}
