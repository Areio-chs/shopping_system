package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.EvaluationMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Evaluation;
import com.shop.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Evaluation> findAll() {
        return evaluationMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Evaluation> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Evaluation> evaluations = (Page<Evaluation>) evaluationMapper.selectAll();
        return new PageResult<Evaluation>(evaluations.getTotal(),evaluations.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Evaluation> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return evaluationMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Evaluation> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Evaluation> evaluations = (Page<Evaluation>) evaluationMapper.selectByExample(example);
        return new PageResult<Evaluation>(evaluations.getTotal(),evaluations.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Evaluation findById(String id) {
        return evaluationMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param evaluation
     */
    public void add(Evaluation evaluation) {
        evaluationMapper.insert(evaluation);
    }

    /**
     * 修改
     * @param evaluation
     */
    public void update(Evaluation evaluation) {
        evaluationMapper.updateByPrimaryKeySelective(evaluation);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        evaluationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Evaluation.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 商品id
            if(searchMap.get("goodsId")!=null && !"".equals(searchMap.get("goodsId"))){
                criteria.andLike("goodsId","%"+searchMap.get("goodsId")+"%");
            }
            // 订单号
            if(searchMap.get("orderDetailId")!=null && !"".equals(searchMap.get("orderDetailId"))){
                criteria.andLike("orderDetailId","%"+searchMap.get("orderDetailId")+"%");
            }
            // 内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }
            // 图片
            if(searchMap.get("img")!=null && !"".equals(searchMap.get("img"))){
                criteria.andLike("img","%"+searchMap.get("img")+"%");
            }

            // 星级
            if(searchMap.get("grade")!=null ){
                criteria.andEqualTo("grade",searchMap.get("grade"));
            }

        }
        return example;
    }

}
