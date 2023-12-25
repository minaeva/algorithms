package ua.kiev.minaeva.ssml;

import org.junit.jupiter.api.Test;
import ua.kiev.minaeva.ssml.document.SSMLDocument;
import ua.kiev.minaeva.ssml.element.ElementContract;
import ua.kiev.minaeva.ssml.visitor.PrintingVisitor;
import ua.kiev.minaeva.ssml.visitor.SSMLElementVisitor;

public class SSMLContextTest {

    SSMLContext ssmlContext = new SSMLContext();
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

    @Test
    void parseChatGPTString() {
        SSMLDocument ssmlDocument = ssmlContext.handleParsing(ssmlFromChatGpt);
        printDocument(ssmlDocument);
    }

    @Test
    void parseGoogleString() {
        SSMLDocument ssmlDocument = ssmlContext.handleParsing(ssmlFromGoogle);
        printDocument(ssmlDocument);
    }

    private void printDocument(SSMLDocument document) {
        SSMLElementVisitor visitor = new PrintingVisitor();
        document.getRoot().accept(visitor);
        for (ElementContract child : document.getRoot().getChildren()) {
            child.accept(visitor);
        }
    }
}
