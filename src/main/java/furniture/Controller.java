package furniture;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/furniture")
public class Controller {

    @Autowired
    private FurnitureRepository furnitureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;


    @RequestMapping("/categories")
    public List<Category> getAllCatgories() {
        return categoryRepository.findAll();
    }

    @RequestMapping("/all")
    public List<Furniture> getAllItems() {
        List<Furniture> list = furnitureRepository.findAll();
        return list;
    }

    @RequestMapping("/subcat")
    public List<SubCategory> getSubCatAll() {
        return subCategoryRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Furniture> findItemById(@PathVariable("id")Integer id){
        Optional<Furniture> f1=furnitureRepository.findById(id);
        return f1;
    }

    @RequestMapping("/cat/{categoryID}")
    public List<Furniture> findAllByCategory(@PathVariable("categoryID")Integer categoryID){
        Category category=new Category();
        category=categoryRepository.findByCategoryID(categoryID);
        return furnitureRepository.findByCategory(category);
    }
    @RequestMapping("/subCat/{subCatId}")
    public List<Furniture> findAllBySubCaregoryId(@PathVariable("subCatId")Integer subCategoryId){
        SubCategory subcategory=new SubCategory();
        subcategory=subCategoryRepository.findBySubCategoryId(subCategoryId);
        return furnitureRepository.findBySubCategory(subcategory);
    }

}
