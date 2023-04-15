package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * actor Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Actor", description = "actor Form")
public class ActorForm {

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
}
