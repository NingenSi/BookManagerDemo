create table t_user(
    userid number(5) primary key,
    username varchar2(30),
    pwd varchar2(30),
    type_ number(1)
)

create table t_book(
    bookid number(10) primary key,
    bookname varchar2(30),
    author varchar2(30),
    publish varchar2(30),
    price number(6,2),
    description_ varchar2(100)
)

create sequence t_userid_sq;
create sequence t_bookid_sq;
insert into t_user values(t_userid_sq.nextval,'admin','admin',1);
insert into t_user values(t_userid_sq.nextval,'lsj','lsj',0);

insert into t_book values
(t_bookid_sq.nextval,'颈椎病预防手册','可达鸭','精灵球出版社',100.00,'可以有效预防颈椎病');
insert into t_book values
(t_bookid_sq.nextval,'颈椎病治疗手册','跳跳虎','精灵球出版社',120.00,'可以有效治疗颈椎病');

insert into t_book values
(t_bookid_sq.nextval,'颈椎病康复手册','跳跳虎','精灵球出版社',170.00,'加快颈椎病康复');
insert into t_book values
(t_bookid_sq.nextval,'中医宝典：药材与化学','咸鱼拌粉丝','相约出版社',70.00,'探讨药材与化学的关系');
insert into t_book values
(t_bookid_sq.nextval,'中西结合：主西辅中','荔枝','相约出版社',65.00,'中西药搭配指南');
insert into t_book values
(t_bookid_sq.nextval,'dota技能数据分析','幻真','猪场出版社',54.00,'各种英雄数据对比，更有效掌握比赛');
insert into t_book values
(t_bookid_sq.nextval,'星际争霸毒奶历史','黄旭东','猪场出版社',80.00,'记录着各种神奇毒奶传奇');
insert into t_book values
(t_bookid_sq.nextval,'光速之上','帅羊','红茶馆出版社',67.00,'充满科幻的超光速体验');
insert into t_book values
(t_bookid_sq.nextval,'宫廷斗争','小温','红茶馆出版社',48.00,'科普各种宫斗技巧');
insert into t_book values
(t_bookid_sq.nextval,'谈笑间灰飞烟灭：中途岛战役','霜落','红茶馆出版社',110.00,'重现残酷的中途岛战役');
insert into t_book values
(t_bookid_sq.nextval,'七十二魔神柱','喵卡','公国出版社',120.00,'七十二柱魔神柱的真正主人，是地狱七君主之一的大魔王贝利尔。');
insert into t_book values
(t_bookid_sq.nextval,'艾泽拉斯编年史','命美','暴雪出版社',78.00,'艾泽拉斯国家地理');
insert into t_book values
(t_bookid_sq.nextval,'燃烧军团','基尔加丹','暴雪出版社',174.00,'发布燃烧军团的内部消息');
insert into t_book values
(t_bookid_sq.nextval,'洛丹伦沦陷','吉安娜','暴雪出版社',76.00,'真是记录洛丹伦战役');
