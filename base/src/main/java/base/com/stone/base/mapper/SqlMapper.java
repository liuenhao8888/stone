package com.stone.base.mapper;

public interface SqlMapper {

	public Object select(Object o);

	public Object selectList(Object o);

	public void insert(Object o);

	public void delete(Object o);

	public void update(Object o);

}
