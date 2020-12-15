package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.CitiesMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Cities;
import com.shop.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Cities> findAll() {
        return citiesMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Cities> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Cities> citiess = (Page<Cities>) citiesMapper.selectAll();
        return new PageResult<Cities>(citiess.getTotal(),citiess.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Cities> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return citiesMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Cities> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Cities> citiess = (Page<Cities>) citiesMapper.selectByExample(example);
        return new PageResult<Cities>(citiess.getTotal(),citiess.getResult());
    }

    /**
     * 根据Id查询
     * @param city_id
     * @return
     */
    public Cities findById(String cityId) {
        return citiesMapper.selectByPrimaryKey(cityId);
    }

    /**
     * 新增
     * @param cities
     */
    public void add(Cities cities) {
        citiesMapper.insert(cities);
    }

    /**
     * 修改
     * @param cities
     */
    public void update(Cities cities) {
        citiesMapper.updateByPrimaryKeySelective(cities);
    }

    /**
     *  删除
     * @param city_id
     */
    public void delete(String cityId) {
        citiesMapper.deleteByPrimaryKey(cityId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Cities.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 城市ID
            if(searchMap.get("cityId")!=null && !"".equals(searchMap.get("cityId"))){
                criteria.andLike("cityId","%"+searchMap.get("cityId")+"%");
            }
            // 城市名称
            if(searchMap.get("city")!=null && !"".equals(searchMap.get("city"))){
                criteria.andLike("city","%"+searchMap.get("city")+"%");
            }
            // 省份ID
            if(searchMap.get("provinceId")!=null && !"".equals(searchMap.get("provinceId"))){
                criteria.andLike("provinceId","%"+searchMap.get("provinceId")+"%");
            }


        }
        return example;
    }

}
