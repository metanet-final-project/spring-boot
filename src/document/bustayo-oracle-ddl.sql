--회원
create table member(
 id number primary key,
 login_id varchar2(20) unique not null,
 name varchar2(20) not null,
 password varchar2(200) not null,
 phone varchar2(20) unique not null,
 role varchar2(20),
 email varchar2(50) unique not null,
 birth date not null
);

--비회원
create table non_member(
 id number primary key,
 phone varchar2(20) unique not null,
 birth date not null
);


--알림
create table notice(
 id number primary key,
 title varchar2(100) not null,
 contents varchar2(200) not null,
 register_date date
);



--쪽지함
create table notebox(
 id number primary key,
 member_id number constraint notebox_member_id_fk references member(id) unique not null,
 notice_num number constraint notebox_notice_num_fk references notice(id)
);



--운송회사
create table company(
 id number primary key,
 name varchar2(20) not null,
 phone varchar2(20)
);


--터미널
create table terminal(
 id number primary key,
 name varchar2(20) not null,
 location varchar2(200)
);


--버스
create table bus(
 id number primary key,
 bus_num varchar2(20),
 company_id number constraint bus_company_id_fk references company(id) not null,
 grade varchar2(20) not null
);


--노선
create table route(
 id number primary key,
 start_id number constraint route_departure_point_fk references terminal(id) not null,
 end_id number constraint route_destination_fk references terminal(id) not null,
 travel_time number
);


--관심노선
create table myroute(
 id number primary key,
 route_id number constraint favorite_route_id_fk references route(id) not null,
 member_id number constraint favorite_route_member_id_fk references member(id) not null
);

--배차
create table schedule(
 id number,
 route_id number,
 start_time date not null,
 end_time date not null,
 bus_id number constraint schedule_bus_num_fk references bus(id) not null,
 price number not null,
 CONSTRAINT pk_schedule PRIMARY KEY(id, route_id),
 CONSTRAINT schedule_route_id_fk FOREIGN KEY(route_id) REFERENCES route(id)
);




--예매대기
create table waiting(
 id number primary key,
 waiting_num number not null unique,
 schedule_id number not null, --constraint wating_schedule_id_fk references schedule(id) not null,
 route_id number not null, --constraint wating_route_id_fk references route(id) not null,
 member_id number constraint waiting_member_id_fk references member(id) not null,
 state varchar2(20),
 CONSTRAINT waiting_schedule_id_fk FOREIGN KEY(schedule_id, route_id) REFERENCES schedule(id, route_id)
);

--연령그룹
create table age(
 id number primary key,
 name varchar2(20) not null unique
);


--결제
create table pay(
 id number primary key,
 card_number number not null,
 card_expiration varchar2(20) not null,
 card_password number not null,
 birth date not null,
 totalprice number
);


--예매
create table booking(
 id number primary key,
 pay_id number constraint booking_pay_id_fk references pay(id),
 member_id number constraint booking_member_id_fk references member(id),
 non_member_id number constraint booking_non_member_id_fk references non_member(id),
 schedule_id number not null, --constraint wating_schedule_id_fk references schedule(id) not null,
 route_id number not null, --constraint wating_route_id_fk references route(id) not null,
 age_id number constraint booking_age_fk references age(id) not null,
 seat_num number not null,
 state varchar2(20) not null,
 price number,
 CONSTRAINT booking_fk FOREIGN KEY(schedule_id, route_id) REFERENCES schedule(id, route_id)

);
