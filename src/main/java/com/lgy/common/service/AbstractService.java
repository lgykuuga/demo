package com.lgy.common.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract interface AbstractService<T> {

    /**
     * 存储记录
     * @param t
     * @return
     */
    Integer save(T t);

    /**
     * 保存所有的beans
     * @param beans
     * @return 所有的都成功返回true，有一个失败就回滚事务，返回false
     */
    Integer save(Collection<T> beans);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 直接删除记录
     * @param t
     * @return
     */
    Integer delete(T t);

    /**
     * 删除指定的beans，根据ID删除
     * @param beans
     */
    Integer delete(Collection<T> beans);

    /**
     * 根据ID删除
     * @param ids
     */
    Integer deleteByIds(String ids) ;

    /**
     * 根据id集合删除
     * @param ids
     */
    Integer deleteByIds(Collection<Long> ids);

    /**
     * 删除所有的beans
     */
    Integer deleteAll();

    /**
     * 修改一行，并且是根据t的实行全部修改
     * @param t
     */
    Integer updateColumnsAll(T t);

    /**
     * 修改一行，只修改t的属性有值的
     * @param t
     */
    Integer updateColumnsOnlyHaveValues(T t) ;

    /**
     * 根据ID查询记录
     * @param id
     */
    T findOneById(Long id);

    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 根据值查询
     * @param column
     * @param value
     * @return
     */
    T findOne(String column, String value);

    /**
     * 根据条件查询
     * @param map
     * @return
     */
    List<T> findAllByMap(Map<String, Object> map);

    /**
     * 根据单号修改
     * @param t
     * @return
     */
    Integer updateByBiid(T t);

}
