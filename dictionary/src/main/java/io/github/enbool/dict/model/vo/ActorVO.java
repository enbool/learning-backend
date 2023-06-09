package io.github.enbool.dict.model.vo;

import io.github.enbool.dict.model.entity.Actor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * actor VO
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@NoArgsConstructor
@Getter
@Setter
@Schema(name = "Actor", description = "actor VO")
public class ActorVO {

    @Schema(description = "名称")
    private String name;

    @Schema(description = "特点")
    private String character;

    @Schema(description = "类型;TEACHER,ACCOMPANIST")
    private String type;

    @Schema(description = "prompts")
    private String prompts;

    @Schema(description = "状态;ACTIVE,INACTIVE")
    private String status;

    public ActorVO(Actor actor) {
        this.name = actor.getName();
        this.character = actor.getCharacter();
    }
}
