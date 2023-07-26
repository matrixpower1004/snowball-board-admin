# 패스트캠퍼스 Toy Project III : Admin 게시판 

## 관리자 게시판 체크 리스트
  1. 관리자 회원 권한 관리
      - [ ]  회원의 role 변경 가능해야 함
  2. 관리자 회원 Email 전송 관리
      - [ ]  회원에게 email 전송 가능해야 함
  3. 관리자 게시글 CRUD 관리
      - [x]  게시글 목록보기,
      - [ ]  삭제하기, 숨기기/보이기, 블랙리스트(욕설) 등록 가능해야 함 (수정, 상세보기는 구현할 필요 없음)
  4. 관리자 게시글 통계 관리
      - [x]  유저의 게시글 수, 댓글 수를 볼 수 있고,
      - [x]  댓글수가 많은 유저 순, 게시글수가 많은 유저 순으로 정렬가능해야 함
  5. 관리자 블랙리스트 고객 등록/해제
      - [x]  게시글 신고목록 페이지 구현,
      - [ ]  해당 페이지에서 블랙리스트 고객 등록 및 해제 가능

체크 되어 있는 기능 외에는 UI 및 기능 미구현 상태입니다.

## 사용 언어 및 기술 스택
- Java 17
- Gradle
- Lombok
- Junit, AssertJ
- Springboot 2.7.13
- MyBatis 3
- Thymeleaf
- Spring Security

## 개발환경
- IntelliJ IDEA
- H2 DB

## 협업 툴
- Github Project
- Slack
- Zoom
## DB Table
```sql
-- status : Current Status of User. TRUE(Activated) / FALSE(UnActivated)
-- role : BLACK, BEGINNER, EXPERT, ADMIN
CREATE TABLE `user_tb`
(
    `id`           BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_account` VARCHAR(15)                           NOT NULL UNIQUE,
    `user_name`    VARCHAR(10)                           NOT NULL,
    `password`     VARCHAR(72)                           NOT NULL,
    `email`        VARCHAR(30)                           NOT NULL,
    `nick_name`    VARCHAR(10)                           NOT NULL UNIQUE,
    `user_status`  BOOLEAN     DEFAULT TRUE              NOT NULL,
    `user_role`    VARCHAR(20) DEFAULT 'BEGINNER'        NOT NULL,
    `created_at`   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`   TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL
) DEFAULT CHARSET = utf8mb4;


-- post(게시판)
CREATE TABLE `post`
(
    `id`          BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id`     BIGINT                              NOT NULL,
    `title`       VARCHAR(255)                        NOT NULL,
    `content`     TEXT                                NOT NULL,
    `blind_state` BOOLEAN   DEFAULT false, -- ture면 게시글 블라인드 상태
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user_tb (id)
) DEFAULT CHARSET = utf8mb4;


-- 게시글 신고 게시판. 하나의 게시글은 한 유저가 한 번만 신고할 수 있다.
create table `report_board`
(
    `id`             bigint primary key auto_increment,
    `post_id`        bigint       not null comment '신고 대상 게시글',
    `report_type`    varchar(20)  not null comment '신고 유형 : 욕설, 비방, 음란, 스팸,광고',
    `reporter_id`    bigint       not null comment '신고자 id',
    `report_img_url` varchar(255) not null comment '증거 스크린샷',
    `report_date`    timestamp    not null default now() comment '신고 일자',
    FOREIGN KEY (post_id) REFERENCES post (id),
    FOREIGN KEY (reporter_id) REFERENCES user_tb (id),
    UNIQUE (post_id, reporter_id)
) DEFAULT CHARSET = utf8mb4;


-- comment(댓글)
CREATE TABLE `comment`
(
    `id`         BIGINT PRIMARY KEY AUTO_INCREMENT,
    `post_id`    BIGINT                              NOT NULL,
    `user_id`    BIGINT                              NOT NULL,
    `content`    VARCHAR(50)                         NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES post (id),
    FOREIGN KEY (user_id) REFERENCES user_tb (id)
) DEFAULT CHARSET = utf8mb4;


-- REPLY (대댓글)
CREATE TABLE `reply`
(
    `id`         BIGINT PRIMARY KEY AUTO_INCREMENT,
    `comment_id` BIGINT      NOT NULL,
    `user_id`    BIGINT      NOT NULL,
    `content`    VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (comment_id) REFERENCES comment(id),
    FOREIGN KEY (user_id) REFERENCES user_tb (id)
) DEFAULT CHARSET = utf8mb4;
```
### 테스트용 더미 데이터는 애플리케이션 시작 시 자동으로 insert 됩니다.
## ERD
![Image](https://github.com/matrixpower1004/snowball-board-admin/assets/104916288/1c872b8a-aeea-4372-b95b-e495141b2143)
## 팀원 역할 분담
- 팀장 : [이지상] (https://github.com/matrixpower1004)
  * 프로젝트 셋업
  * 신고 게시판, 게시판, 댓글(대댓글) DB 테이블 설계
  * Admin 기능
- 팀원 : [배종윤] (https://github.com/jy-b)
  * Spring Security 설정
  * 유저 DB 테이블 설계
  * 유저 기능(가입, 로그인)
  * 유저 등업 배치 처리
- 팀원 : [박민기] (https://github.com/Coding9nt), [박성욱] (https://github.com/gosuuk)
  * 유저 게시판, 댓글, 대댓글 기능
## 프로젝트 후기
- 팀장 : 이지상
  * 멀티 모듈 프로젝트라는 개념을 알지 못해서 중간에 프로젝트 자체를 완전히 분리하는 시행 착오를 겪은 점이 아쉬웠습니다.
  * 

  
