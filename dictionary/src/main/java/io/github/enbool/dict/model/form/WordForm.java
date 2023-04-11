package io.github.enbool.dict.model.form;

import io.github.enbool.dict.model.entity.Word;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Form Object for Word
 * @Author: wumin2
 * @Date: 2023/4/11 19:13
 */
@Data
@NoArgsConstructor
@Schema(description = "Form Object for Word")
public class WordForm {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "单词")
    private String name;
    @Schema(description = "内容")
    private String content;

    public Word convert() {
        Word word = new Word();
        word.setId(this.id);
        word.setName(this.name);
        word.setContent(this.content);
        return word;
    }
}
