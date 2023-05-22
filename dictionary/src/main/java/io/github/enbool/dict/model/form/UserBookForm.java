package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *  Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Getter
@Setter
@Schema(name = "UserBook", description = "Form")
public class UserBookForm {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "book id")
    private Long bookId;
}
