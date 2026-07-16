import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * ===========================================================
 *               Document Editor - Low Level Design
 * ===========================================================
 * This project demonstrates a simple Document Editor using
 * Object-Oriented Design Principles.
 *
 * Features:
 * 1. Add Text
 * 2. Add Images
 * 3. Add New Lines
 * 4. Add Tab Spaces
 * 5. Render Document
 * 6. Save Document to a File
 *
 * Design Highlights:
 * - Uses Interface for abstraction.
 * - Follows Open/Closed Principle.
 * - Uses Dependency Inversion through Persistence interface.
 * ===========================================================
 */


/*------------------------------------------------------------
 * Interface representing any element that can be placed
 * inside the document.
 *
 * Every document element must know how to render itself.
 *-----------------------------------------------------------*/
interface DocumentElement {

    // Returns the String representation of the element.
    String render();
}


/*------------------------------------------------------------
 * Represents a simple text inside the document.
 *-----------------------------------------------------------*/
class TextElement implements DocumentElement {

    // Stores the text content.
    private String text;

    // Constructor
    public TextElement(String text) {
        this.text = text;
    }

    // Returns the text exactly as it is.
    @Override
    public String render() {
        return text;
    }
}


/*------------------------------------------------------------
 * Represents an image inside the document.
 * Only stores the image path in this example.
 *-----------------------------------------------------------*/
class ImageElement implements DocumentElement {

    // Path of the image
    private String imagePath;

    // Constructor
    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    // Returns a placeholder representation of the image.
    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}


/*------------------------------------------------------------
 * Represents a line break.
 *-----------------------------------------------------------*/
class NewLineElement implements DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}


/*------------------------------------------------------------
 * Represents a tab space.
 *-----------------------------------------------------------*/
class TabSpaceElement implements DocumentElement {

    @Override
    public String render() {
        return "\t";
    }
}


/*------------------------------------------------------------
 * Document class
 *
 * Responsibility:
 * Stores all document elements and renders the complete
 * document.
 *-----------------------------------------------------------*/
class Document {

    // List containing every document element.
    private List<DocumentElement> documentElements = new ArrayList<>();


    // Adds a new element to the document.
    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }


    // Combines the rendered output of all elements.
    public String render() {

        StringBuilder result = new StringBuilder();

        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }

        return result.toString();
    }
}


/*------------------------------------------------------------
 * Persistence Interface
 *
 * Provides abstraction for saving a document.
 * Different storage mechanisms can implement this interface.
 *-----------------------------------------------------------*/
interface Persistence {

    void save(String data);
}


/*------------------------------------------------------------
 * Saves the document into a text file.
 *-----------------------------------------------------------*/
class FileStorage implements Persistence {

    @Override
    public void save(String data) {

        try {

            // Creates (or overwrites) the file.
            FileWriter outFile = new FileWriter("document.txt");

            // Writes the rendered document.
            outFile.write(data);

            // Close the file.
            outFile.close();

            System.out.println("Document saved to document.txt");

        } catch (IOException e) {

            System.out.println("Error: Unable to write the document.");

        }
    }
}


/*------------------------------------------------------------
 * Placeholder implementation for database storage.
 *
 * Can later be replaced with JDBC/MySQL/MongoDB etc.
 *-----------------------------------------------------------*/
class DBStorage implements Persistence {

    @Override
    public void save(String data) {

        // Future implementation
        System.out.println("Saving document into database...");

    }
}


/*------------------------------------------------------------
 * DocumentEditor
 *
 * Acts as the controller between the client and document.
 *
 * Responsibilities:
 * - Add document elements
 * - Render document
 * - Save document
 *-----------------------------------------------------------*/
class DocumentEditor {

    // Document being edited.
    private Document document;

    // Storage mechanism.
    private Persistence storage;

    // Cache to avoid rendering repeatedly.
    private String renderedDocument = "";


    // Constructor Dependency Injection
    public DocumentEditor(Document document, Persistence storage) {

        this.document = document;
        this.storage = storage;

    }


    // Adds text into the document.
    public void addText(String text) {

        document.addElement(new TextElement(text));

    }


    // Adds an image.
    public void addImage(String imagePath) {

        document.addElement(new ImageElement(imagePath));

    }


    // Adds a new line.
    public void addNewLine() {

        document.addElement(new NewLineElement());

    }


    // Adds a tab space.
    public void addTabSpace() {

        document.addElement(new TabSpaceElement());

    }


    // Generates the complete document.
    // Uses cached version if already rendered.
    public String renderDocument() {

        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }

        return renderedDocument;

    }


    // Saves the rendered document.
    public void saveDocument() {

        storage.save(renderDocument());

    }

}


/*------------------------------------------------------------
 * Client Class
 *
 * Demonstrates how the document editor is used.
 *-----------------------------------------------------------*/
public class DocumentEditorClient {

    public static void main(String[] args) {

        // Create a document object.
        Document document = new Document();

        // Choose storage implementation.
        Persistence persistence = new FileStorage();

        // Create editor.
        DocumentEditor editor =
                new DocumentEditor(document, persistence);


        // Build the document.

        editor.addText("Hello, world!");

        editor.addNewLine();

        editor.addText("This is a real-world document editor example.");

        editor.addNewLine();

        editor.addTabSpace();

        editor.addText("Indented text after a tab space.");

        editor.addNewLine();

        editor.addImage("picture.jpg");


        // Display the rendered document.
        System.out.println(editor.renderDocument());


        // Save the document into a file.
        editor.saveDocument();

    }
}