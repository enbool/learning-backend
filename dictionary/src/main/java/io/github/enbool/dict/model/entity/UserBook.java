package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.enbool.dict.model.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wumin
 * @since 2023-04-15 23:14:53
 */
@Getter
@Setter
@TableName("user_book")
@Schema(name = "UserBook", description = "")
public class UserBook extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "book id")
    private Long bookId;
}
