package cn.yuehai.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName SpecGroup
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\17 0017 9:47
 * @Version 1.0
 **/
@Data
@Table(name = "tb_spec_group")
public class SpecGroup {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long cid;
    private String name;
}
