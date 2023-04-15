package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 单词计划 Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Getter
@Setter
@Schema(name = "WordPlan", description = "单词计划 Form")
public class WordPlanForm {

    @Schema(description = "新单词数")
    private Integer newNums;

    @Schema(description = "复习单词数")
    private Integer reviewNums;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "new word id")
    private Long newWordId;
}
