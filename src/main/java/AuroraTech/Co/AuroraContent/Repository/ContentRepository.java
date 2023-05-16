package AuroraTech.Co.AuroraContent.Repository;

import AuroraTech.Co.AuroraContent.Model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content,Integer> {
    List<Content> findByCategoryId(int categoryId);
}
