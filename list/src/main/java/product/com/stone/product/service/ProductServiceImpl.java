package com.stone.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.stone.base.service.MybatisBaseServiceImpl;
import com.stone.product.mapper.ProductExtendMapper;
import com.stone.product.mapper.ProductMapper;
import com.stone.product.mapper.TProductStandardMapper;
import com.stone.product.model.Product;
import com.stone.product.model.ProductExtend;
import com.stone.product.model.TProductStandard;

@Service("productService")
public class ProductServiceImpl extends MybatisBaseServiceImpl implements
		IProductService {

	protected static final Logger log = Logger
			.getLogger(ProductServiceImpl.class);

	// 两种例外
	// 1.unchecked 默认回滚事务(RuntimeException)
	// 2.checked 默认不回滚事务(Exception)
	// 开启事务.并设置unchecked例外不回滚
	// @Transactional(propagation = Propagation.REQUIRED, noRollbackFor =
	// RuntimeException.class)
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addProduct(Product product, HttpServletRequest rqs)
			throws Exception {
		// TODO Auto-generated method stub
		// 插入商品基本信息
		ProductMapper pm = this.getMapper(ProductMapper.class);
		pm.insert(product);

		// 插入商品扩展信息
		List<ProductExtend> extList = toProductExtends(product.getId(), rqs);
		ProductExtendMapper pxm = this.getMapper(ProductExtendMapper.class);
		if (extList.size() > 0) {
			pxm.insertList(extList);
		} else {
			log.warn("*****  商品没有任何扩展属性       ******");
		}

		// 插入商品规格信息
		List<TProductStandard> stdList = product.getStdList();
		for (TProductStandard ps : stdList) {
			ps.setProductId(product.getId());
			ps.setCategoryId(product.getCid());
		}
		TProductStandardMapper psm = this
				.getMapper(TProductStandardMapper.class);
		if (stdList.size() > 0) {
			psm.insertList(stdList);
		} else {
			log.warn("*****  商品没有任何规格属性       ******");
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateProduct(Product product, HttpServletRequest rqs)
			throws Exception {

		// 更新商品基本信息
		ProductMapper pm = this.getMapper(ProductMapper.class);
		pm.updateByPrimaryKeySelective(product);

		// 更新商品扩展信息
		ProductExtendMapper pxm = this.getMapper(ProductExtendMapper.class);
		pxm.updateList(toProductExtends(product.getId(), rqs));

		// 更新商品规格信息
		TProductStandardMapper psm = this
				.getMapper(TProductStandardMapper.class);

		List<TProductStandard> newList = new ArrayList<TProductStandard>();
		List<TProductStandard> oldList = new ArrayList<TProductStandard>();
		List<TProductStandard> list = product.getStdList();
		for (TProductStandard std : list) {
			std.setProductId(product.getId());
			std.setCategoryId(product.getCid());
			if (std.getId() > 0) {
				oldList.add(std);
			} else {
				newList.add(std);
			}
		}
		psm.deleteByProductId(product.getId());
		if (newList.size() > 0) {
			psm.insertList(newList);
		}
		if (oldList.size() > 0) {
			psm.insertListWithId(oldList);
		}

	}

	@SuppressWarnings("unchecked")
	private List<ProductExtend> toProductExtends(int productId,
			HttpServletRequest rqs) {
		List<ProductExtend> list = new ArrayList<ProductExtend>();
		Map<String, String[]> m = rqs.getParameterMap();
		for (Entry<String, String[]> entry : m.entrySet()) {
			String k = entry.getKey();
			if (k.startsWith("ext")) {
				String str = Arrays.toString(entry.getValue());
				str = str.substring(1, str.length() - 1);
				ProductExtend ext = new ProductExtend();
				ext.setProductId(productId);
				ext.setTemplateId(Integer.parseInt(k.substring(3)));
				StringBuffer sb = new StringBuffer();
				String[] arr = str.split(",");
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i].trim()).append(",");
				}
				str = sb.toString();
				ext.setValue(str.substring(0, str.length() - 1));
				list.add(ext);
				log.info(ext.getValue());
			}

		}
		return list;
	}

	@Override
	public Product getById(int id) throws Exception {

		ProductMapper pm = this.getMapper(ProductMapper.class);
		Product t = pm.selectByPrimaryKey(id);

		ProductExtendMapper pxm = this.getMapper(ProductExtendMapper.class);
		List<Map> extList = pxm.selectByProductId(id);
		// JSONArray arr = JSONArray.fromObject(list);

		TProductStandardMapper psm = this
				.getMapper(TProductStandardMapper.class);
		List<Map> stdList = psm.selectByProductId(id);

		return null;
	}

}
