package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.enbool.dict.model.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 单词计划
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Getter
@Setter
@TableName("word_plan")
@Schema(name = "WordPlan", description = "单词计划")
public class WordPlan extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Schema(description = "新单词数")
    private Integer newNums;

    @Schema(description = "复习单词数")
    private Integer reviewNums;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "new word id")
    private Long newWordId;
}
