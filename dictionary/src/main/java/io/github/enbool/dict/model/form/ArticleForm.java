package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文章 Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Article", description = "文章 Form")
public class ArticleForm {

    @Schema(description = "主题")
    private String topic;

    @Schema(description = "章节")
    private String chapter;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "排序")
    private Integer orders;

    @Schema(description = "book id")
    private Long bookId;
}
