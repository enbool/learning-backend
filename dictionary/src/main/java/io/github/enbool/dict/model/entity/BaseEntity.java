package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.github.enbool.dict.constants.ProjectConstants;
import io.github.enbool.dict.utils.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 数据库基础实体类
 * @Author: wumin2
 * @Date: 2023/4/4 16:50
 */
@Schema(description = "数据库基础实体类")
@Data
public class BaseEntity implements Serializable {
    @Schema(description = "主键")
    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "创建人")
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    @Schema(description = "创建时间")
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Long createdTime;

    @Schema(description = "更新人")
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;
    @Schema(description = "更新时间")
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private Long updatedTime;

    public static final String ID = "id";
    public static final String CREATED_BY = "createdBy";
    public static final String UPDATED_BY = "updatedBy";
    public static final String CREATED_TIME = "createdTime";
    public static final String UPDATED_TIME = "updatedTime";

    /**
     * 通过createdBy字段获取创建人id
     * @return
     */
    public Long getCreatedById(){
        if (StringUtils.isBlank(createdBy)) {
            return null;
        }

        String[] split = createdBy.split(ProjectConstants.COLON);
        if (split.length != 2) {
            return null;
        }

        return Long.parseLong(split[0]);
    }

    /**
     * 通过createdBy字段获取创建人username
     * @return
     */
    public String getCreatedByUsername(){
        if (StringUtils.isBlank(createdBy)) {
            return null;
        }

        String[] split = createdBy.split(ProjectConstants.COLON);
        if (split.length != 2) {
            return null;
        }

        return split[1];
    }

    /**
     * 通过updatedBy字段获取更新人id
     * @return
     */
    public Long getUpdatedById(){
        if (StringUtils.isBlank(updatedBy)) {
            return null;
        }

        String[] split = updatedBy.split(ProjectConstants.COLON);
        if (split.length != 2) {
            return null;
        }

        return Long.parseLong(split[0]);
    }

    /**
     * 通过updatedBy字段获取更新人username
     * @return
     */
    public String getUpdatedByUsername(){
        if (StringUtils.isBlank(updatedBy)) {
            return null;
        }

        String[] split = updatedBy.split(ProjectConstants.COLON);
        if (split.length != 2) {
            return null;
        }

        return split[1];
    }
}
