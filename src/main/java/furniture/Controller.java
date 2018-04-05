package furniture;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
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

    @RequestMapping("/furniture")
    public List<Furniture> getAllItems() {
        List<Furniture> list = furnitureRepository.findAll();
        return list;
    }

    @RequestMapping("/subcat")
    public List<SubCategory> getSubCatAll() {
        return subCategoryRepository.findAll();
    }
}
