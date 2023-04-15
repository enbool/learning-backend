package io.github.enbool.dict.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 算力账单 Form
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Bill", description = "算力账单 Form")
public class BillForm {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "账单变动类型;GAIN,CONSUME")
    private String operateType;

    @Schema(description = "事件JSON")
    private String incident;

    @Schema(description = "数额")
    private Long amount;

    @Schema(description = "余额")
    private Long balance;
}
