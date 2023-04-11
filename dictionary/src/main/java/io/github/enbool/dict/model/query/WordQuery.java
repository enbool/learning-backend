package io.github.enbool.dict.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: criteria for querying word
 * @Author: wumin2
 * @Date: 2023/4/11 19:00
 */
@Schema(description = "criteria for querying word")
@Data
public class WordQuery {
    @Schema(description = "word name, like '%name%'")
    private String name;
    @Schema(description = "word description, like '%description%'")
    private String description;
    @Schema(description = "dictionary id")
    private Long dictionaryId;
}
