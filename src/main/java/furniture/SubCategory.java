package furniture;
import javax.persistence.*;
@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int subCategoryId;
    private int categoryId;
    private String name;
    public SubCategory(){}



    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
