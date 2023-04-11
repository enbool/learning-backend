package io.github.enbool.dict.model.vo;

import io.github.enbool.dict.model.entity.Word;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/11 19:13
 */
@Data
@NoArgsConstructor
@Schema(description = "View Object for Word")
public class WordVO {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "单词")
    private String name;
    @Schema(description = "内容")
    private String content;

    public WordVO(Word word) {
        this.id = word.getId();
        this.name = word.getName();
        this.content = word.getContent();
    }
}
