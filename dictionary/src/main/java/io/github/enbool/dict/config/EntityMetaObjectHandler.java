package io.github.enbool.dict.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.enbool.dict.context.UserContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

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

        if(Objects.nonNull(UserContext.getUserIdSafely())){
            String user = UserContext.getUserSafely();
            this.strictInsertFill(metaObject, CREATED_BY, String.class, user);
            this.strictInsertFill(metaObject, UPDATED_BY, String.class, user);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long now = Instant.now().toEpochMilli();

        if (metaObject.getValue(UPDATED_TIME) == null) {
            metaObject.setValue(UPDATED_TIME, now);
        }
        if (Objects.nonNull(UserContext.getUserIdSafely())) {
            this.strictUpdateFill(metaObject, UPDATED_BY, String.class, UserContext.getUserSafely());
        }
    }
}
