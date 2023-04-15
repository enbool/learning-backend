package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * user_actor Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "UserActor", description = "user_actor Form")
public class UserActorForm {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "actor id")
    private Long actorId;

    @Schema(description = "失效时间")
    private Long expireAt;
}
