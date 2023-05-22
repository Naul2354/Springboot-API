package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
//import AuroraTech.Co.AuroraContent.Service.ContentService;
import AuroraTech.Co.AuroraContent.Repository.ContentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://20.187.126.190:9999")
@RestController
@RequestMapping("/api/content")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
    @Autowired
    private ContentRepository contentRepository;
    @GetMapping("/")
    public ResponseEntity<?> getContentById(@RequestParam("id") Integer id) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isPresent()) {
            Content content = optionalContent.get();
            return ResponseEntity.ok(content);
        } else {
            String message = "Content not found with id = " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
//    @GetMapping("/")
//    public Content getContentById(@RequestParam("id") Integer id) {
//        return contentRepository.findById(id).orElse(null);
//    }

    @GetMapping()
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


