package furniture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Integer> {
    List<Furniture> findByCategory(Category category);
    List<Furniture> findBySubCategory(SubCategory subCategory);

}
