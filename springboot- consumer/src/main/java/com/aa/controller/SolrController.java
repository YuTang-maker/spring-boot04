package com.aa.controller;

import com.aa.entity.TbItem;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试solr控制器
 *
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 19:13
 */
@RestController
public class SolrController {

	@Resource
	private SolrTemplate solrTemplate;

	// 获取solr数据
	@GetMapping(value = "/SolrList")
	public List<TbItem> getList() {
		// queryForPage page按页查询默认一页10条数据
		ScoredPage<TbItem> collection1 = solrTemplate.queryForPage("collection1", new SimpleQuery("*:*"), TbItem.class);
		return collection1.getContent();
	}

}
