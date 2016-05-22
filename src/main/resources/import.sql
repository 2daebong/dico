insert into tb_user VALUES ('testUser1', 'hellow hellow my home town is LA', 'pwd0101', '010-0000-0001', now(), null);
insert into tb_user VALUES ('testUser2', '한글로쳐도 주소가 될까요?한글로쳐도 주소가 될까요?', 'pwd0102', '010-0000-0002', now(), null);
insert into tb_user VALUES ('adminUser1', '주소없옹', 'abcd', '010-2049-1202', now(), null);
insert into tb_user VALUES ('adminUser2', '주소없옹2', 'abcd2', '010-2011-1212', now(), null);

insert into tb_shop (address, phone_number, regist_ymdt, shop_name, update_ymdt, admin_user) VALUES ('주소test', '01020309283', now(), 'bojungdong', null, 'testUser1');
insert into tb_shop (address, phone_number, regist_ymdt, shop_name, update_ymdt, admin_user) VALUES ('helloaddress', '01012341234', now(), 'sinlim', null, 'testUser2');

insert into tb_product (desc_text, image_url, price, product_category, product_name, product_name_kr, regist_ymdt, shop_no, update_ymdt, stock, unit) VALUES ('상품 설명%0A 상품설명2', 'http://sunvalley.web.hanbiz.kr/data/file/32/32f9160ff58be0298edd3a4598a407b9.JPG', 190, 'VEGETABLE', 'goguma', '고구마', now(), 1, null, 1, '묶음(5개)');
insert into tb_product (desc_text, image_url, price, product_category, product_name, product_name_kr, regist_ymdt, shop_no, update_ymdt, stock, unit) VALUES ('상품 설명%0A 상품설명2', 'http://dimg.donga.com/wps/NEWS/IMAGE/2014/10/01/66875372.2.jpg', 510, 'FRUIT', 'apple', '사과', now(), 1, null, 3, '개');
insert into tb_product (desc_text, image_url, price, product_category, product_name, product_name_kr, regist_ymdt, shop_no, update_ymdt, stock, unit) VALUES ('상품 설명%0A 상품설명2', 'http://cfile24.uf.tistory.com/image/2613B2435111C4270C6799', 1230, 'VEGETABLE', 'daepa', '대파', now(), 2, null, 0, '단');
insert into tb_product (desc_text, image_url, price, product_category, product_name, product_name_kr, regist_ymdt, shop_no, update_ymdt, stock, unit) VALUES ('상품 설명%0A 상품설명2', 'http://cfile28.uf.tistory.com/image/2574D53B53BBECAB1B92BF', 9112, 'FRUIT', 'mango', '마늘', now(), 2, null, 100, '개');

-- insert into tb_product_stock (product_no, stock) VALUES (1, 2);
-- insert into tb_product_stock (product_no, stock) VALUES (2, 1);
-- insert into tb_product_stock (product_no, stock) VALUES (3, 5);
-- insert into tb_product_stock (product_no, stock) VALUES (4, 100);


-- insert into tb_mapping_shop_admin (shop_no, user_id) VALUES (1,'adminUser1');
-- insert into tb_mapping_shop_admin (shop_no, user_id) VALUES (2, 'adminUser2');