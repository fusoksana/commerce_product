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

    @OneToMany(fetch = FetchType.LAZY,mappedBy="categoryId")
    private List<SubCategory> subCategories = new ArrayList<>();

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }


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
