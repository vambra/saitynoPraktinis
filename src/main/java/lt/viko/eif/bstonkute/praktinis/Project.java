package lt.viko.eif.bstonkute.praktinis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class for storing information about a project - character name, character source material name,
 * project due date, start and finish dates, budget of the project,
 * list of components (see class {@link Component}), list of conventions (see class {@link Convention}).
 *
 * @author Brigita Stonkutė
 */
@XmlRootElement
@XmlType(propOrder = {"character", "source", "dueDate", "startDate", "finishDate", "budget", "componentList", "conventionList"})
public class Project {
    private String character;
    private String source;
    private String dueDate;
    private String startDate;
    private String finishDate;
    private Float budget;
    private List<Component> componentList;
    private List<Convention> conventionList;

    /**
     * Class constructor that takes no parameters.
     */
    public Project() {
        // empty constructor for error prevention
    }

    /**
     * Gets the character name.
     *
     * @return character name
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Sets the character name.
     *
     * @param character character name
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * Gets the source name of the character.
     *
     * @return source name of the character
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source name of the character.
     *
     * @param source source name of the character
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the due date of the project.
     *
     * @return due date of the project
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the project.
     *
     * @param dueDate due date of the project
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the start date of the project.
     *
     * @return start date of the project
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the project.
     *
     * @param startDate start date of the project
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the finish date of the project.
     *
     * @return finish date of the project
     */
    public String getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the finish date of the project.
     *
     * @param finishDate finish date of the project
     */
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Gets the budget of the project.
     *
     * @return budget of the project
     */
    public Float getBudget() {
        return budget;
    }

    /**
     * Sets the budget of the project
     *
     * @param budget budget of the project
     */
    public void setBudget(Float budget) {
        this.budget = budget;
    }

    /**
     * Gets the list of components (see class {@link Component}).
     *
     * @return list of components
     */
    @XmlElementWrapper(name = "componentList")
    @XmlElement(name = "component")
    public List<Component> getComponentList() {
        return componentList;
    }

    /**
     * Sets the list of components (see class {@link Component}).
     *
     * @param componentList list of components
     */
    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    /**
     * Gets the list of conventions (see class {@link Convention}).
     *
     * @return list of conventions
     */
    @XmlElementWrapper(name = "conventionList")
    @XmlElement(name = "convention")
    public List<Convention> getConventionList() {
        return conventionList;
    }

    /**
     * Sets the list of conventions (see class {@link Convention}).
     *
     * @param conventionList list of conventions
     */
    public void setConventionList(List<Convention> conventionList) {
        this.conventionList = conventionList;
    }

    /**
     * Custom override of the toString() method, containing all the Project class and dependant class data.
     *
     * @return formatted data string
     */
    @Override
    public String toString() {
        String str = String.format("%s : %s", character, source);
        str += String.format("\n\tDue:\t%s", dueDate);
        str += String.format("\n\tStart:\t%s", startDate);
        str += String.format("\n\tFinish:\t%s", finishDate);
        str += String.format("\n\tBudget:\t%.2f EUR", budget);
        if (componentList != null && componentList.size() > 0) {
            str += "\n\tComponents:";
            for (Component comp : componentList) {
                str += comp.toString();
            }
        }
        if (conventionList != null && conventionList.size() > 0) {
            str += "\n\tConventions: ";
            for (Convention con : conventionList) {
                str += con.toString();
            }
        }
        return str;
    }
}