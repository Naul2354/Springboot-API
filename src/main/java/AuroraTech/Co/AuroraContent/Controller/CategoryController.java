package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Category;
import AuroraTech.Co.AuroraContent.Repository.CategoryRepository;
//import AuroraTech.Co.AuroraContent.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    //Send request to Http:http://localhost:9999/api/category
    //Use Get method find Category with id
//    @GetMapping("/{id}")
////    public Category getCategoryById(@PathVariable(value = "id") Integer id) {
////        return categoryRepository.findById(id).orElse(null);
////    }
    @GetMapping("/")
    public Category getCategoryById(@RequestParam("id") Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
    //Use Get method list all Category need to find
    @GetMapping() //Use Get method to list all Category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    //Create new Category
    @PostMapping()
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
    //Update category with id and request body need
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Integer id,
                                                   @RequestBody Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryDetails.getName());
            category.setStatus(categoryDetails.getStatus());
            category = categoryRepository.save(category);
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delele category id
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable(value = "id") Integer id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.delete(category);
        }
    }
}

