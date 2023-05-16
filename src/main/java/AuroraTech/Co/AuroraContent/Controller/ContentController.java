package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
//import AuroraTech.Co.AuroraContent.Service.ContentService;
import AuroraTech.Co.AuroraContent.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/{id}")
    public Content getContentById(@RequestParam(value = "id") Integer id) {
        return contentRepository.findById(id).orElse(null);
    }


    @GetMapping() //giong nhu select * From bla bla
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @PostMapping()
    public Content createContent(@RequestBody Content content) {
        content.setCreatedTime(LocalDateTime.now());
        content.setStatus(1);
        return contentRepository.save(content);
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable(value = "id") Integer id,
                                 @RequestBody Content contentDetails) {
        Content content = contentRepository.findById(id).orElse(null);
        if (content != null) {
            content.setTitle(contentDetails.getTitle());
            content.setContent(contentDetails.getContent());
            content.setStatus(contentDetails.getStatus());
            content.setCategory(contentDetails.getCategory());
//            content.setUpdatedTime(new Date());
            return contentRepository.save(content);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable(value = "id") Integer id) {
        Content content = contentRepository.findById(id).orElse(null);
        if (content != null) {
            contentRepository.delete(content);
        }
    }
}


