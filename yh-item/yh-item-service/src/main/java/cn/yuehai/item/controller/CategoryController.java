package cn.yuehai.item.controller;

import cn.yuehai.item.pojo.Category;
import cn.yuehai.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author LiHongBin
 * @Date 2020\7\14 0014 8:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> findCategoryByPid(
            @RequestParam(value = "pid",defaultValue = "0") Long pid,
            HttpServletRequest request){

        List<Category> categoryList = categoryService.findCategoryByPid(pid);

        //没有查到返回404
        String origin = request.getHeader("origin");
        return ResponseEntity.ok(categoryList);
    }

}
