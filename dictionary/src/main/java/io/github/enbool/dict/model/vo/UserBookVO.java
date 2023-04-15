package io.github.enbool.dict.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *  VO
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Getter
@Setter
@Schema(name = "UserBook", description = " VO")
public class UserBookVO {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "book id")
    private Long bookId;
}
