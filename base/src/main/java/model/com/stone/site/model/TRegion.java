package com.stone.site.model;

import java.io.Serializable;

public class TRegion implements Serializable {
    /**
     * t_region.ID
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Long id;

    /**
     * t_region.PRENAME
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private String prename;

    /**
     * t_region.CNAME
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private String cname;

    /**
     * t_region.AREACODE
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Integer areacode;

    /**
     * t_region.VERSION
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Integer version;

    /**
     * t_region.GRADE
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private int grade;

    /**
     * t_region.ORDERNUM
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Integer ordernum;

    /**
     * t_region.ISLEAF
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Integer isleaf;

    /**
     * t_region.PARENTID
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Long parentid;

    /**
     * t_region.SHOP_ID
     * @ibatorgenerated 2015-04-09 08:15:10
     */
    private Integer shopId;
    
    
    

    private long codeLimit;

    private static int unitNum = 3 ;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    
    

	
	public static int getUnitNum() {
		return unitNum;
	}

	public static void setUnitNum(int unitNum) {
		TRegion.unitNum = unitNum;
	}

	public void setCodeLimit(long codeLimit) {
		this.codeLimit = codeLimit;
	}

	public long getCodeLimit() {
		return codeLimit = generateSubCodeLimit();
	}




	/**
	 * 生成新的兄弟编码
	 * @return
	 */
	public long generateNewSiblingCode() {
		String codeStr = new Long(id).toString();
		int power = codeStr.length()-unitNum;
		for(int i=power; i>1;i-=unitNum){
			double divisor = Math.pow(10, i);
			if (id % divisor == 0) {
				double code2 =(id/divisor+1)*divisor;
				return Double.valueOf(code2).longValue();
			}
		}
		return id+1;
	}

	/**
	 * 生成子区域编码边界值
	 * 若无子区域即本身就是最底级则返回0
	 * @return
	 */
	public long generateSubCodeLimit() {
		String codeStr = new Long(id).toString();
		int power = codeStr.length()-unitNum;
		for(int i=power; i>1;i-=unitNum){
			double divisor = Math.pow(10, i);
			if (id % divisor == 0) {
				double id2 =(id/divisor+1)*divisor;
				return Double.valueOf(id2).longValue();
			}
		}
		return 0;
	}
	/**
	 * 生成新子编码
	 * 若无子区域即本身就是最底级则返回0
	 * @return
	 */
	public long generateNewSubCode() {
		String codeStr = new Long(id).toString();
		int power = codeStr.length()-unitNum;
		for(int i=power; i>1;i-=unitNum){
			double divisor = Math.pow(10, i);
			if (id % divisor == 0) {
				double id2 = id+divisor/Math.pow(10, unitNum);
				return Double.valueOf(id2).longValue();
			}
		}
		return 0;
	}
	

	/**
	 * 生成父区域编码值
	 * 
	 * @return
	 */
	public long generateParentCode() {
		if (grade == 1)
			return 0;
		int prefixNum = unitNum * (grade - 1);
		String codeStr = new Long(id).toString();
		long id2 = Long.valueOf(codeStr.substring(0, prefixNum));
		id2 = Double.valueOf(id2 * Math.pow(10, codeStr.length()-prefixNum)).longValue();
		return id2;
	}

}