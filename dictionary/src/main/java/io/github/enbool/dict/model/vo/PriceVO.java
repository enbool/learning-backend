package io.github.enbool.dict.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 服务价格表 VO
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:52
 */
@Getter
@Setter
@Schema(name = "Price", description = "服务价格表 VO")
public class PriceVO {

    @Schema(description = "账单变动类型;GAIN,CONSUME")
    private String operateType;

    @Schema(description = "事件类型;NEW_USER, FRIEND_CLICK,RECHARGE")
    private String incidentType;

    @Schema(description = "数额")
    private Long amount;
}
