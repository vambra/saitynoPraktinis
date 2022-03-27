package lt.viko.eif.bstonkute.praktinis;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JAXB transformer class, transforms object from/to xml.
 *
 * @author Brigita Stonkutė
 */
public class Transformer {

    private static JAXBContext jaxbContext = null;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Projects.class);

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Performs JAXB transformation from XML file to Projects object.
     *
     * @param fileName filename of the source XML file
     * @return object {@link Projects} created from the XML file
     */
    public Projects transformToObjectFromFile(String fileName) {
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Path filePath = Path.of(fileName);
            String actual = Files.readString(filePath);
            StringReader reader = new StringReader(actual);
            Projects projects = (Projects) unmarshaller.unmarshal(reader);
            return projects;
        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Performs JAXB transformation from XML string to Projects object.
     *
     * @param xmlString XML string to turn into object
     * @return object {@link Projects} created from the XML file
     */
    public Projects transformToObjectFromString(String xmlString) {
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            Projects projects = (Projects) unmarshaller.unmarshal(reader);
            return projects;

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Performs JAXB transformation from Projects object to a formatted XML file.
     *
     * @param projects  object to turn into an XML file
     * @param fileName file to which to export the XML string
     */
    public void transformToXmlFile(Projects projects, String fileName) {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(projects, xmlWriter);
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(xmlWriter.toString());
            fileWriter.close();

        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Performs JAXB transformation from Project object to an unformatted XML string.
     *
     * @param projects object to turn into an XML string
     * @return formatted XML string
     */
    public String transformToXmlString(Projects projects) {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // <-- formats string
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(projects, xmlWriter);
            return xmlWriter.toString();

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
