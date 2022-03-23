package lt.viko.eif.bstonkute.praktinis;

public class Main {
    public static void main(String args[]) {
        Transformer transformer = new Transformer();
        Project project = transformer.transformToObjectFromFile("projectData.xml");
        System.out.println(project);
        transformer.transformToXmlFile(project, "projectData.xml");
    }
}
