package AuroraTech.Co.AuroraContent.Repository;

import AuroraTech.Co.AuroraContent.Model.ContentImage;
import AuroraTech.Co.AuroraContent.Model.ContentImageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentImageRepository extends JpaRepository<ContentImage, ContentImageId> {
//    List<ContentImage> findByContentId(int ContentImageId);
    Optional<ContentImage> findByContentIdAndImageId(@Param("contentId") Integer contentId, @Param("imageId") Integer imageId);
}
