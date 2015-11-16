package com.stone.site.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogList {
	
	
	private List<Catalog> catalogs = new ArrayList<Catalog>();;
	private List<List<Catalog>> subCatalogs = new ArrayList<List<Catalog>>();

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public List<List<Catalog>> getSubCatalogs() {
		return subCatalogs;
	}

	public void setSubCatalogs(List<List<Catalog>> subCatalogs) {
		this.subCatalogs = subCatalogs;
	}

}
