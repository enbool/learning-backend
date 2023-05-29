DROP TABLE IF EXISTS actor;
CREATE TABLE actor(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `name` VARCHAR(32) NOT NULL   COMMENT '名称' ,
    `character` VARCHAR(1024)    COMMENT '特点' ,
    `type` VARCHAR(32)    COMMENT '类型;TEACHER,ACCOMPANIST' ,
    `prompts` TEXT(65535)    COMMENT 'prompts' ,
    `status` VARCHAR(32) NOT NULL   COMMENT '状态;ACTIVE,INACTIVE' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '演员';

DROP TABLE IF EXISTS article;
CREATE TABLE article(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `topic` VARCHAR(128) NOT NULL   COMMENT '主题' ,
    `chapter` VARCHAR(128)    COMMENT '章节' ,
    `content` TEXT(65535)    COMMENT '内容' ,
    `orders` INT(10)    COMMENT '排序' ,
    `book_id` BIGINT(20)    COMMENT 'book id' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '文章';


CREATE INDEX idx_book_id ON article(book_id);

DROP TABLE IF EXISTS bill;
CREATE TABLE bill(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `operate_type` VARCHAR(32) NOT NULL   COMMENT '账单变动类型;GAIN,CONSUME' ,
    `incident` VARCHAR(1024)    COMMENT '事件JSON' ,
    `amount` BIGINT(20) NOT NULL   COMMENT '数额' ,
    `balance` BIGINT(20)    COMMENT '余额' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` VARCHAR(1024) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '算力账单';


CREATE INDEX idx_user_id_operate_type ON bill(user_id,operate_type);

DROP TABLE IF EXISTS book;
CREATE TABLE book(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `name` VARCHAR(32) NOT NULL   COMMENT '名称' ,
    `description` VARCHAR(1024)    COMMENT '说明' ,
    `price` BIGINT(20) NOT NULL   COMMENT '价格' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '书籍';


CREATE INDEX idx_name ON book(name);

DROP TABLE IF EXISTS computility;
CREATE TABLE computility(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `balance` BIGINT(20) NOT NULL   COMMENT '余额' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '算力值';


CREATE UNIQUE INDEX uk_user_id ON computility(user_id);

DROP TABLE IF EXISTS dictionary;
CREATE TABLE dictionary(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `name` VARCHAR(32) NOT NULL   COMMENT '字典名' ,
    `image` VARCHAR(128)    COMMENT '图片' ,
    `number` INT(10)    COMMENT '单词数量' ,
    `author` VARCHAR(32)    COMMENT '词典作者' ,
    `description` VARCHAR(128)    COMMENT '说明' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '字典';


CREATE INDEX idx_name ON dictionary(name);

DROP TABLE IF EXISTS new_word;
CREATE TABLE new_word(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `word_name` VARCHAR(32) NOT NULL   COMMENT '单词' ,
    `repeat_counter` INT(10) NOT NULL   COMMENT '当前学习需要重复的次数' ,
    `review_counter` INT(10) NOT NULL   COMMENT '复习次数' ,
    `last_time` BIGINT(20) NOT NULL   COMMENT '上次学习时间' ,
    `status` VARCHAR(32) NOT NULL   COMMENT '状态;LEARNING, LEARNED' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `word_id` BIGINT(20) NOT NULL   COMMENT 'word id' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '生词本';


CREATE UNIQUE INDEX uk_user_word ON new_word(user_id,word_id);

DROP TABLE IF EXISTS price;
CREATE TABLE price(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `operate_type` VARCHAR(32) NOT NULL   COMMENT '账单变动类型;GAIN,CONSUME' ,
    `incident_type` VARCHAR(32) NOT NULL   COMMENT '事件类型;NEW_USER, FRIEND_CLICK,RECHARGE' ,
    `amount` BIGINT(20) NOT NULL   COMMENT '数额' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '服务价格表';

DROP TABLE IF EXISTS user_actor;
CREATE TABLE user_actor(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `actor_id` BIGINT(20) NOT NULL   COMMENT 'actor id' ,
    `expire_at` BIGINT(20)    COMMENT '失效时间' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = 'user_actor';


CREATE UNIQUE INDEX uk_user_actor ON user_actor(user_id,actor_id);

DROP TABLE IF EXISTS user_book;
CREATE TABLE user_book(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `book_id` BIGINT(20) NOT NULL   COMMENT 'book id' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';


CREATE UNIQUE INDEX uk_user_book ON user_book(user_id,book_id);

DROP TABLE IF EXISTS word;
CREATE TABLE word(
    `id` BIGINT NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `name` BIGINT(20) NOT NULL   COMMENT '单词' ,
    `content` TEXT(65535) NOT NULL   COMMENT '内容' ,
    `translate` VARCHAR(128)    COMMENT '中文' ,
    `us` VARCHAR(32)    COMMENT '美式音标' ,
    `us_audio` VARCHAR(128)    COMMENT '美式发音' ,
    `uk` VARCHAR(32)    COMMENT '英式音标' ,
    `uk_audio` VARCHAR(128)    COMMENT '英式发音' ,
    `media` VARCHAR(128)    COMMENT '多媒体URL' ,
    `rank` INT(10)    COMMENT '排序' ,
    `dictionary_id` BIGINT(20) NOT NULL   COMMENT '字典ID' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '单词';


CREATE UNIQUE INDEX uk_name_dictionary_id ON word(name,dictionary_id);
CREATE INDEX idx_dictionary_id ON word(dictionary_id);

DROP TABLE IF EXISTS word_plan;
CREATE TABLE word_plan(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `new_nums` INT(10) NOT NULL   COMMENT '新单词数' ,
    `review_nums` INT(10) NOT NULL   COMMENT '复习单词数' ,
    `user_id` BIGINT(20) NOT NULL   COMMENT '用户id' ,
    `new_word_id` BIGINT(20) NOT NULL   COMMENT 'new word id' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '单词计划';


CREATE UNIQUE INDEX uk_user_new_word ON word_plan(user_id,new_word_id);

DROP TABLE IF EXISTS user;
CREATE TABLE user(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    `username` VARCHAR(128) NOT NULL   COMMENT '用户名' ,
    `password` VARCHAR(128) NOT NULL   COMMENT '密码' ,
    `email` VARCHAR(128) NOT NULL   COMMENT '邮箱' ,
    `phone` VARCHAR(32) NOT NULL   COMMENT '手机号' ,
    `avatar` TEXT(65535)    COMMENT '头像' ,
    `nickname` VARCHAR(128)    COMMENT '昵称' ,
    `gender` VARCHAR(32)    COMMENT '性别;UNKNOWN, MALE, FEMALE' ,
    `enabled` TINYINT(1) NOT NULL   COMMENT '是否启用' ,
    `user_type` VARCHAR(32) NOT NULL   COMMENT '用户类型;ADMIN, USER' ,
    `user_info` TEXT(65535)    COMMENT '用户信息' ,
    `created_by` VARCHAR(128) NOT NULL   COMMENT '创建人' ,
    `created_time` BIGINT(20) NOT NULL   COMMENT '创建时间' ,
    `updated_by` VARCHAR(128) NOT NULL   COMMENT '更新人' ,
    `updated_time` BIGINT(20) NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户';




CREATE UNIQUE INDEX uk_email ON user(email);
CREATE UNIQUE INDEX uk_phone ON user(phone);
CREATE UNIQUE INDEX uk_username ON user(username);

INSERT INTO `user` (`username`, `password`, `email`, `phone`, `avatar`, `nickname`, `gender`, `enabled`, `user_type`, `user_info`, `created_by`, `created_time`, `updated_by`, `updated_time`) VALUES ('admin', '$2a$10$MRk3mcbxU8rzPSrL3FT3XO7UGUHmTkIQp9soAunxSaQT7D5vUwVOS', 'enbool@163.com', '15100600246', '', 'administrator', 'MALE', 1, 'ADMIN', NULL, '1:admin', 1684814245200, '1:admin', 1684814245200);