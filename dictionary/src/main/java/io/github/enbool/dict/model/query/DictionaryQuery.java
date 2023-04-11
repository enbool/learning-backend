package io.github.enbool.dict.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: criteria for querying dictionary
 * @Author: wumin2
 * @Date: 2023/4/10 10:58
 */
@Schema(description = "criteria for querying dictionary")
@Data
public class DictionaryQuery {
    @Schema(description = "dictionary name, like '%name%'")
    private String name;
    @Schema(description = "dictionary author")
    private String author;
}
