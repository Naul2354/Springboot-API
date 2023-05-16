package AuroraTech.Co.AuroraContent.Repository;

import AuroraTech.Co.AuroraContent.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
