package cn.yuehai.item.service;

import cn.yuehai.common.enums.ExceptionEnum;
import cn.yuehai.common.exception.YhException;
import cn.yuehai.item.mapper.CategoryMapper;
import cn.yuehai.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\14 0014 8:54
 * @Version 1.0
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findCategoryByPid(Long pid) {
        Category category = new Category();
        //查询使用通用mapper，由于条件不是id主键所以要封装对象中
        category.setParentId(pid);

        return categoryMapper.select(category);
    }
}
