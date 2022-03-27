package lt.viko.eif.bstonkute.praktinis;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Wrapper class for Project objects (see {@link Project}).
 *
 * @author Brigita Stonkutė
 */
@XmlRootElement(name = "projectList")
public class Projects {
    private List<Project> projectList;

    /**
     * Class constructor that takes no parameters.
     */
    public Projects() {
        // empty constructor for error prevention
    }

    /**
     * Class constructor that takes a list of Project objects as a parameter (see {@link Project}).
     *
     * @param projectList list of Project objects
     */
    public Projects(List<Project> projectList) {
        this.projectList = projectList;
    }

    /**
     * Gets the list of projects (see class {@link Project}).
     *
     * @return list of projects
     */
    @XmlElement(name = "project")
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * Sets the list of projects (see class {@link Project}).
     *
     * @param projectList list of projects
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    /**
     * Custom override of the toString() method, containing all the {@link Project} objects' data.
     *
     * @return formatted data string
     */
    @Override
    public String toString() {
        String str = "";
        if (projectList != null && projectList.size() > 0) {
            for (Project project : projectList) {
                str += project.toString() + "\n\n";
            }
        }
        return str;
    }
}
