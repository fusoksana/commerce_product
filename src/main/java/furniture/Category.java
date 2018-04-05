package furniture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int categoryID;
    private String categoryName;


    public Category() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
