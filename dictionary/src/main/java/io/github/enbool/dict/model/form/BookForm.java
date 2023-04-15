package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 书籍 Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Book", description = "书籍 Form")
public class BookForm {

    @Schema(description = "名称")
    private String name;

    @Schema(description = "说明")
    private String description;

    @Schema(description = "价格")
    private Long price;
}
