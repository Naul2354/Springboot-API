package AuroraTech.Co.AuroraContent.Pagination;

import AuroraTech.Co.AuroraContent.Model.Content;
import AuroraTech.Co.AuroraContent.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class PaginationContentController {

    private static final int ITEMS_PER_PAGE = 10;
    private static final int TOTAL_PAGES = 5;
    @Autowired
    private  ContentRepository contentRepository;


    @GetMapping("/")
        public List<Content> getContentsByPage(@RequestParam (value = "page")int pageNumber){
            int pageIndex = pageNumber -1;

            List<Content> pageContents = contentRepository.findAll(PageRequest.of(pageIndex,ITEMS_PER_PAGE)).getContent();

            return pageContents;
        }
    }





