package cn.yuehai.item.service;

import cn.yuehai.common.enums.ExceptionEnum;
import cn.yuehai.common.exception.YhException;
import cn.yuehai.common.vo.PageResult;
import cn.yuehai.item.mapper.BrandMapper;
import cn.yuehai.item.pojo.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName BrandService
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\15 0015 9:48
 * @Version 1.0
 **/
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows,
                                              String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNoneBlank(key)){
            example.createCriteria().orLike("name","%"+key+"%").
                    orEqualTo("letter",key.toUpperCase());
        }
        //排序
        if (StringUtils.isNoneBlank(key)){
            String orderByClause = sortBy + (desc? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)){
            throw new YhException(ExceptionEnum.BRAND_NOT_FOUND);
        }

        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(brandList);
        return new PageResult<Brand>(info.getTotal(),0L+info.getPages(),brandList);
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (count != 1){
            throw new YhException(ExceptionEnum.BRAND_NOT_FOUND);
        }

        for (Long cid :
                cids) {
            count = brandMapper.insertCategoryAndBrand(cid,brand.getId());
            if (count != 1){
                throw new YhException(ExceptionEnum.BRAND_SAVE_ERROR);
            }
        }
    }
}
