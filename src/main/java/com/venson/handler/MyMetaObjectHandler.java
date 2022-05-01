package com.venson.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert");
//        this.setFieldValByName("createTime", new Date(), metaObject);
//        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.strictInsertFill(metaObject,"createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject,"version",Integer.class,1);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start updating updateTime");
//        this.setFieldValByName("updateTime", new Date(), metaObject);
        MetaObjectHandler updateTime = this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        System.out.println(updateTime);
//        this.updateFill(metaObject);
        System.out.println(LocalDateTime.now());
    }
}
