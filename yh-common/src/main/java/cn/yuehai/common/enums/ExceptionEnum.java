package cn.yuehai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"商品没有查到"),
    BRAND_NOT_FOUND(404,"品牌没有查到"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    CATEGORY_BRAND_SAVE_ERROR(500,"新增品牌分类中间表失败"),
    UPLOAD_ERROR(500,"文件上传失败"),
    INVALID_FILE_TYPE(400,"无效的文件类型"),
    SPECGROUP_NOT_FOUND(404,"商品规格组没查到"),
    SPECPARAM_NOT_FOUND(404,"商品规格参数没查到"),
    ;
    private int code;
    private String msg;
}
