package com.belle.springboogelasticsearch.repository;

import com.belle.springboogelasticsearch.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName EsBlogRepository
 * @Description EsBlog Repository 资源库 接口
 * @Author sunp
 * @Date 2018/11/28 14:18
 * @Version 0.0.1
 **/
public interface EsBlogRepository  extends ElasticsearchRepository<EsBlog,String > {
    /**
     * 分页查询博客（去重）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}
