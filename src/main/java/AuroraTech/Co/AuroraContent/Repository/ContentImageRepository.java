package AuroraTech.Co.AuroraContent.Repository;

import AuroraTech.Co.AuroraContent.Model.ContentImage;
import AuroraTech.Co.AuroraContent.Model.ContentImageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentImageRepository extends JpaRepository<ContentImage, ContentImageId> {
//    List<ContentImage> findByContentId(int contentId);
}
