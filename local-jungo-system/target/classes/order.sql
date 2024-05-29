create table order_tb (
id int auto_increment primary key,
order_num varchar(20),
image varchar(20),
pro_name varchar(20),
pro_content varchar(512),
price int,
checkYN varchar(5),
status varchar(20),
memo varchar(512),
order_name varchar(10),
order_phone varchar(20),
order_address varchar(100),
order_date varchar(40)
return_price int
);

alter table order_tb convert to charset utf8;

alter table order_tb modify column checkYN varchar(5) default 'N';
alter table order_tb modify column image varchar(40);

ALTER TABLE order_tb AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE order_tb SET id = @COUNT:=@COUNT+1;

insert into order_tb (order_num, pro_name, pro_content, price, status, memo, order_name, order_phone, order_address, order_date, checkYN)
values ('20181019_123123',
			'������', '�������˴ϴ��˴ϴ��˴ϴ�', 80000, 
			'������', '', '�����', '010-1111-1111', '�泲 ���ֽ� ĥ�ϵ�', now(), 'N');
insert into order_tb (order_num, image, pro_name, pro_content, price, status, memo, order_name, order_phone, order_address, order_date, checkYN)
values ('20181020_456123', '20181020_456123_1234',
			'�ƺ�', '�ƺ� ���Ⱦƿ�', 150000, 
			'������', '', '�����', '010-1234-1234', '�泲 ���ֽ� ��ŵ�', now(), 'N');
insert into order_tb (order_num, image, pro_name, pro_content, price, status, memo, order_name, order_phone, order_address, order_date, checkYN)
values ('20181020_123456', '20181019_123123_1111',
			'������', '�������˴ϴ��˴ϴ��˴ϴ�', 80000, 
			'������', '', '�輼��', '010-4444-1111', '�泲 ���ֽ� õ����', now(), 'N');
insert into order_tb (order_num, image, pro_name, pro_content, price, status, memo, order_name, order_phone, order_address, order_date, checkYN)
values ('20181020_456444', '20181020_456123_8564',
			'��Ʈ��', '�ƺ� ���Ⱦƿ�', 150000, 
			'������', '', '���籹', '010-5555-4597', '�泲 ���ֽ� �ϴ뵿', now(), 'N');