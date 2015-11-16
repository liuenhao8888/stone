package com.stone.site.sevice;


import java.util.List;

import org.springframework.stereotype.Service;

import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.base.system.Status;
import com.stone.site.model.Catalog;
import com.stone.site.model.CatalogList;

@Service("catalogService")
public class CatalogServiceImpl extends MybatisBaseServiceImpl implements ICatalogService {

	@Override
	public CatalogList listCatalog() {
		CatalogList cl = new CatalogList();
		Catalog c = new Catalog();c.setPid(0);c.setStatus(Status.display);
		List<Catalog> pList = this.getIbatisBaseDao().selectObjects("com.stone.site.mapper.CatalogMapper.list",c);
		for(Catalog pc : pList){
			Catalog cc = new Catalog();cc.setPid(pc.getId());cc.setStatus(Status.display);
			List<Catalog> subs = this.getIbatisBaseDao().selectObjects("com.stone.site.mapper.CatalogMapper.list",cc);
			cl.getCatalogs().add(pc);
			cl.getSubCatalogs().add(subs);
		}
		return cl;
	}
	

}
