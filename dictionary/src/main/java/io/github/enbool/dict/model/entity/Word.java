package io.github.enbool.dict.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 17:01
 */
@Data
@TableName(value = "word", autoResultMap = true)
@Schema(description = "单词")
public class Word extends BaseEntity {
    @Schema(description = "单词")
    private String name;
    @Schema(description = "中文")
    private String translate;
    @Schema(description = "美式音标")
    private String us;
    @Schema(description = "美式发音")
    private String usAudio;
    @Schema(description = "英式音标")
    private String uk;
    @Schema(description = "英式发音")
    private String ukAudio;
    @Schema(description = "多媒体URL")
    private String media;
    @Schema(description = "内容")
    private String content;
    @Schema(description = "排序")
    private Integer rank;
    @Schema(description = "字典ID")
    private Long dictionaryId;

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            return this.name.equals(((Word) obj).getName());
        }
        return false;
    }
}
