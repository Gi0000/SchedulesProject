use SchedulesProject;

CREATE TABLE Schedule
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY  NOT NULL COMMENT '할 일 식별자',
    user VARCHAR(20) NOT NULL COMMENT '이름',
    todo VARCHAR(100) NOT NULL COMMENT '할 일',
    password VARCHAR(20) NOT NULL COMMENT '비밀번호',
    createDate DATETIME NOT NULL COMMENT '생성일',
    updateDate DATETIME NOT NULL COMMENT '수정일'
);