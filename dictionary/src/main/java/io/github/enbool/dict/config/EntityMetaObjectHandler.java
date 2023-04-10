package io.github.enbool.dict.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import io.github.enbool.dict.context.UserContextHolder;
import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.stereotype.Component;

import static io.github.enbool.dict.model.entity.BaseEntity.*;

/**
 * @author wumin
 * @Description: EntityMetaObjectHandler，会自动注入DBEntity对象
 * @date 2021年02月08日 6:25 下午
 */
@Component
public class EntityMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long now = Instant.now().toEpochMilli();

        //设置createTime和updateTime
        if (metaObject.getValue(CREATED_TIME) == null) {
            this.strictInsertFill(metaObject, CREATED_TIME, Long.class, now);
        }
        if (metaObject.getValue(UPDATED_TIME) == null) {
            this.strictInsertFill(metaObject, UPDATED_TIME, Long.class, now);
        }

        if(Objects.nonNull(UserContextHolder.getUserId())){
            this.strictInsertFill(metaObject, CREATED_BY, String.class, String.valueOf(UserContextHolder.getUserId()));
            this.strictInsertFill(metaObject, UPDATED_BY, String.class, String.valueOf(UserContextHolder.getUserId()));
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long now = Instant.now().toEpochMilli();
        Long userId = UserContextHolder.getUserId();

        if (metaObject.getValue(UPDATED_TIME) == null) {
            metaObject.setValue(UPDATED_TIME, now);
        }
        if (null != userId) {
            this.strictUpdateFill(metaObject, UPDATED_BY, String.class, String.valueOf(userId));
        }
    }
}
