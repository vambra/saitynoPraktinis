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
            jaxbContext = JAXBContext.newInstance(Project.class);

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Performs JAXB transformation from XML file to Project object.
     *
     * @param fileName filename of the source XML file
     * @return object {@link Project} created from the XML file
     */
    public Project transformToObjectFromFile(String fileName) {
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Path filePath = Path.of(fileName);
            String actual = Files.readString(filePath);
            StringReader reader = new StringReader(actual);
            Project project = (Project) unmarshaller.unmarshal(reader);
            return project;

        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Performs JAXB transformation from XML string to Project object.
     *
     * @param xmlString XML string to turn into object
     * @return object {@link Project} created from the XML file
     */
    public Project transformToObjectFromString(String xmlString) {
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            Project project = (Project) unmarshaller.unmarshal(reader);
            return project;

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Performs JAXB transformation from Project object to a formatted XML file.
     *
     * @param project  object to turn into an XML file
     * @param fileName file to which to export the XML string
     */
    public void transformToXmlFile(Project project, String fileName) {
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(project, xmlWriter);
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
     * @param project object to turn into an XML string
     * @return formatted XML string
     */
    public String transformToXmlString(Project project) {
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // <-- formats string
            StringWriter xmlWriter = new StringWriter();
            marshaller.marshal(project, xmlWriter);
            return xmlWriter.toString();

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
