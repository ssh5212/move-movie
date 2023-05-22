-- 현재 AutoCommit 값 확인
SELECT @@AUTOCOMMIT;

-- AutoCommit 설정
SET AUTOCOMMIT = 1;

-- AutoCommit 해제
SET AUTOCOMMIT = 0;


-- select
select * from user;
select * from bucket;
select * from bucket_detail_list;
select * from my_bucket_list;
commit;

-- insert 
insert into bucket(bucket_title, bucket_content, user_pk) values("test_title", "test_content", 2);
INSERT INTO bucket_detail_list(bucket_pk,spot_pk) VALUES(3, 17003);
INSERT INTO my_bucket_list(bucket_pk, spot_pk, user_pk) VALUES(3,17003,2);


-- test

-- bucket
update bucket set bucket_heart = bucket_heart+ 1 where bucket_pk = 2;
delete from bucket where bucket_pk = 2;

-- bucket_detail_list
select * from bucket_detail_list;
select * from bucket_detail_list where bucket_pk = 3;
select * from bucket_detail_list where spot_pk = 17000;
insert into bucket_detail_list(bucket_pk, spot_pk) values (3, 18000);

-- my_bucket_list
insert into my_bucket_list(bucket_pk, spot_pk, user_pk) 
VALUES(3,17003,2);

select * from my_bucket_list;
select * from my_bucket_list where user_pk = 2 and bucket_pk = 3;

update my_bucket_list set checked = 1 
where 
bucket_pk = 3 and
spot_pk = 17000 and
user_pk = 2;

delete from my_bucket_list
where 
bucket_pk = 3 and
spot_pk = 17000 and
user_pk = 2;