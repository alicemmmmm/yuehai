package cn.yuehai.item.controller;

import cn.yuehai.item.pojo.SpecGroup;
import cn.yuehai.item.pojo.SpecParam;
import cn.yuehai.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SpecificationController
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\17 0017 9:50
 * @Version 1.0
 **/
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specService;

    @GetMapping("groups/{cid}")//http://api.leyou.com/api/item/spec/groups/76
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid){

        return ResponseEntity.ok(specService.queryGroupbyCid(cid));
    }

    @GetMapping("params") //http://api.leyou.com/api/item/spec/params?gid=15
    public ResponseEntity<List<SpecParam>> queryParamByGid(@RequestParam("gid") Long gid){
        return ResponseEntity.ok(specService.queryParamByGid(gid));
    }
}
