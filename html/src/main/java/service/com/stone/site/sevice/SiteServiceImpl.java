package com.stone.site.sevice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.site.model.Catalog;
import com.stone.site.model.Site;

@Service("siteService")
public class SiteServiceImpl extends MybatisBaseServiceImpl implements ISiteService {

	@Override
	public List listSites() {
		List<Catalog> cs = this.getIbatisBaseDao().selectObjects("com.stone.site.mapper.CatalogMapper.listSub",null);
		List list = new ArrayList();
		for(Catalog c : cs){
			Map m = new HashMap();
			List<Site> sites = this.getIbatisBaseDao().selectObjects("com.stone.site.mapper.SiteMapper.list",c.getId());
			m.put("catalog", c);
			m.put("sites", sites);
			list.add(m);
		}
		return list;
	}
}
