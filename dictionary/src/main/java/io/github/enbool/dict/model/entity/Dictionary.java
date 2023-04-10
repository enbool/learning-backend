package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 17:03
 */
@Schema(description = "字典")
@Data
@TableName(value = "dictionary")
public class Dictionary extends BaseEntity {
    @Schema(description = "字典名")
    private String name;
    @Schema(description = "image")
    private String image;
    @Schema(description = "单词数量")
    private Integer number;
    @Schema(description = "词典作者")
    private String author;
    @Schema(description = "说明")
    private String description;
}
