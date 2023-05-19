package AuroraTech.Co.AuroraContent.Controller;

import AuroraTech.Co.AuroraContent.Model.Content;
import AuroraTech.Co.AuroraContent.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class PaginationContentController {

    private static final int ITEMS_PER_PAGE = 10;
    private static final int TOTAL_PAGES = 5;
    @Autowired
    private ContentRepository contentRepository;


//    @GetMapping(params = { "page", "size" })
//    public List<Content> findPaginatedContents(@RequestParam("page") int page,
//                                               @RequestParam("size") int size,
//                                               UriComponentsBuilder uriBuilder,
//                                               HttpServletResponse response) {
//        Page<Content> resultPage = contentRepository.findAll(PageRequest.of(page, size));
//
//        if (page >= resultPage.getTotalPages()) {
//            throw new MyResourceNotFoundException();
//        }
//
//        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Content>(
//            Content.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
//
//        return resultPage.getContent();
//    }


    @GetMapping("/")
    public ResponseEntity<List<Content>> getContentsByPage(@RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 10; // Number of contents per page
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Content> contentPage = contentRepository.findAll(pageable);

        List<Content> contentList = contentPage.getContent();

        if (!contentList.isEmpty()) {
            return ResponseEntity.ok(contentList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Content>> getContentsByPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Content> contentPage = contentRepository.findAll(pageable);

        List<Content> contentList = contentPage.getContent();

        if (!contentList.isEmpty()) {
            return ResponseEntity.ok(contentList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
