/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FastFoodWeb.Common.Bean;

/**
 *
 * @author bao
 */
public class CategoryBean {
    private int ID;

    public CategoryBean(int ID, String Name, boolean IsActive) {
        this.ID = ID;
        this.Name = Name;
        this.IsActive = IsActive;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    private String Name;
    private boolean IsActive;
}
