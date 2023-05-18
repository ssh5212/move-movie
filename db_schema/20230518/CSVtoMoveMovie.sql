-- SELECT * FROM dump2.`영화 로케이션 촬영 이력`;

-- select * from movemovie.sido;
-- select * from movemovie.gugun;

-- truncate
-- truncate table movemovie.sido;
-- truncate table movemovie.gugun;
-- truncate table movemovie.spot;

-- fk setting 
-- set FOREIGN_KEY_CHECKS = 0;
-- set FOREIGN_KEY_CHECKS = 1;

-- 칼럼에 AI 적용
-- alter table movemovie.sido modify sido_code int not null auto_increment;
-- alter table movemovie.gugun modify gugun_code int not null auto_increment;

-- 시도 
-- insert into movemovie.sido(sido_name) SELECT distinct 시도 FROM dump2.`영화 로케이션 촬영 이력`;

-- 시군구
-- insert into movemovie.gugun(sido_code, gugun_name)
-- select distinct sido_code, 시군구 from movemovie.sido as a right join dump2.`영화 로케이션 촬영 이력` as b on b.시도 = a.sido_name;

-- SELECT distinct 시군구 FROM dump2.`영화 로케이션 촬영 이력`;-- 
-- SELECT * from movemovie.spot; 
-- insert into movemovie.gugun(sido_code, gugun_name)


-- spot
select * from movemovie.user;
SELECT * from movemovie.spot;

-- alter table movemovie.spot modify user_pk int default 0; 
SELECT * FROM dump2.`영화 로케이션 촬영 이력`;




-- movie spot 
insert into movemovie.spot( 
    spot_name,
    spot_scene_desc,
    spot_lat,
    spot_lon,
    spot_address,
    spot_road_address,
    spot_characters,
    spot_movie_title,
    spot_filming_seq,
 	sido_code,
	gugun_code, 
    user_pk
)
select 촬영장소명, 장면설명, 위도, 경도, 지번주소, 도로명주소 , 등장인물, 작품명, 사건일련번호, sido_code, gugun_code, 0 from 
(SELECT * 
FROM dump2.`영화 로케이션 촬영 이력` as a 
inner join movemovie.gugun as b 
	on a.시군구 = b.gugun_name and a.시도 = (select sido_name from movemovie.sido  where sido_code = b.sido_code)) q;

-- 테이블 구조 ㅁㄴㅇㄹ
-- alter table movemovie.spot modify spot_scene_desc varchar(2000);
-- alter table movemovie.spot modify spot_name varchar(2000); 
-- alter table movemovie.spot modify spot_road_address varchar(2000); 
-- spot_scene_desc varchar(80) => varchar(2000)


-- 0 admin 삽입

-- INSERT INTO `movemovie`.`user`
-- (`user_pk`,
-- `user_nickname`,
-- `user_email`,
-- `user_pw`,
-- `user_name`,
-- `user_exp`,
-- `user_role`,
-- `register_time`)
-- VALUES
-- (0,-- 
-- "admin",
-- "admin",
-- "admin",
-- "admin",
-- 0,
-- 1,
-- now());


-- UPDATE `movemovie`.`user`
-- SET
-- user_pk = 0;
