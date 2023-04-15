package io.github.enbool.dict.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 算力值 VO
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Computility", description = "算力值 VO")
public class ComputilityVO {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "余额")
    private Long balance;
}
