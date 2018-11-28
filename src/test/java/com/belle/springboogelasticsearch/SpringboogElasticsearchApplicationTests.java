package com.belle.springboogelasticsearch;

import com.belle.springboogelasticsearch.domain.EsBlog;
import com.belle.springboogelasticsearch.repository.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboogElasticsearchApplicationTests {

	@Autowired
	private EsBlogRepository esBlogRepository;

	@Before
	public void initRepository(){
		//清除所有数据
		esBlogRepository.deleteAll();
		//初始化数据
		esBlogRepository.save(new EsBlog("登黄鹤楼","王之涣的登黄鹤楼","白日依山尽，黄河入海流，欲穷千里目，更上一层楼。"));
		esBlogRepository.save(new EsBlog("相思","王维的相思","红豆生南国，春来发几枝，愿君多采撷，此物最相思。"));
		esBlogRepository.save(new EsBlog("静夜思","李白的静夜思","床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
	}

	@Test
	public void contextLoads() {
		Pageable pageable = new PageRequest(0,20);
		String title = "思";
		String summary = "相思";
		String content = "相思";

		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);

		for (EsBlog blog : page.getContent()){
			System.out.println(blog.toString());
		}
	}

}
