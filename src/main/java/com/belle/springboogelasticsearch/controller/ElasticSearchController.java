package com.belle.springboogelasticsearch.controller;

import com.belle.springboogelasticsearch.domain.EsBlog;
import com.belle.springboogelasticsearch.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ElasticSearchController
 * @Description ES 学习
 * @Author sunp
 * @Date 2018/11/28 14:16
 * @Version 0.0.1
 **/
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    private EsBlogRepository blogRepository;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title") String title,
                             @RequestParam(value = "summary") String summary,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "pageIndex",defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){

        Pageable pageable  = new PageRequest(pageIndex,pageSize);
        Page<EsBlog> page = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        return  page.getContent();
    }
}
