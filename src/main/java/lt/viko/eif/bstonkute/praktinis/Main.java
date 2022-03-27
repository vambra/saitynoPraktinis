package lt.viko.eif.bstonkute.praktinis;

public class Main {
    public static void main(String args[]) {
        Transformer transformer = new Transformer();
        Projects projects = transformer.transformToObjectFromFile("projectData.xml");
        System.out.println(projects);
        transformer.transformToXmlFile(projects, "projectData.xml");
    }
}
