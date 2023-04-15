package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.enbool.dict.model.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 生词本
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@TableName("new_word")
@Schema(name = "NewWord", description = "生词本")
public class NewWord extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Schema(description = "单词")
    private String wordName;

    @Schema(description = "当前学习需要重复的次数")
    private Integer repeatCounter;

    @Schema(description = "复习次数")
    private Integer reviewCounter;

    @Schema(description = "上次学习时间")
    private Long lastTime;

    @Schema(description = "状态;LEARNING, LEARNED")
    private String status;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "word id")
    private Long wordId;
}
