package cn.yuehai.item.mapper;

import cn.yuehai.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BrandMapper extends Mapper<Brand> {
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
}
