package cn.yuehai.item.service;

import cn.yuehai.common.enums.ExceptionEnum;
import cn.yuehai.common.exception.YhException;
import cn.yuehai.item.mapper.SpecGroupMapper;
import cn.yuehai.item.mapper.SpecParamMapper;
import cn.yuehai.item.pojo.SpecGroup;
import cn.yuehai.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName SpecificationService
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\17 0017 9:50
 * @Version 1.0
 **/
@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupbyCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> list = specGroupMapper.select(specGroup);

        if (CollectionUtils.isEmpty(list)){
            throw new YhException(ExceptionEnum.SPECGROUP_NOT_FOUND);
        }
        return list;
    }

    public List<SpecParam> queryParamByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> list = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(list)){
            throw new YhException(ExceptionEnum.SPECGROUP_NOT_FOUND);
        }
        return list;
    }
}
