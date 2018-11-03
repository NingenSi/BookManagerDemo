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
(t_bookid_sq.nextval,'��׵��Ԥ���ֲ�','�ɴ�Ѽ','�����������',100.00,'������ЧԤ����׵��');
insert into t_book values
(t_bookid_sq.nextval,'��׵�������ֲ�','������','�����������',120.00,'������Ч���ƾ�׵��');

insert into t_book values
(t_bookid_sq.nextval,'��׵�������ֲ�','������','�����������',170.00,'�ӿ쾱׵������');
insert into t_book values
(t_bookid_sq.nextval,'��ҽ���䣺ҩ���뻯ѧ','������˿','��Լ������',70.00,'̽��ҩ���뻯ѧ�Ĺ�ϵ');
insert into t_book values
(t_bookid_sq.nextval,'������ϣ���������','��֦','��Լ������',65.00,'����ҩ����ָ��');
insert into t_book values
(t_bookid_sq.nextval,'dota�������ݷ���','����','��������',54.00,'����Ӣ�����ݶԱȣ�����Ч���ձ���');
insert into t_book values
(t_bookid_sq.nextval,'�Ǽ����Զ�����ʷ','����','��������',80.00,'��¼�Ÿ������涾�̴���');
insert into t_book values
(t_bookid_sq.nextval,'����֮��','˧��','���ݳ�����',67.00,'�����ƻõĳ���������');
insert into t_book values
(t_bookid_sq.nextval,'��͢����','С��','���ݳ�����',48.00,'���ո��ֹ�������');
insert into t_book values
(t_bookid_sq.nextval,'̸Ц��ҷ�������;��ս��','˪��','���ݳ�����',110.00,'���ֲп����;��ս��');
insert into t_book values
(t_bookid_sq.nextval,'��ʮ��ħ����','����','����������',120.00,'��ʮ����ħ�������������ˣ��ǵ����߾���֮һ�Ĵ�ħ����������');
insert into t_book values
(t_bookid_sq.nextval,'������˹����ʷ','����','��ѩ������',78.00,'������˹���ҵ���');
insert into t_book values
(t_bookid_sq.nextval,'ȼ�վ���','�����ӵ�','��ѩ������',174.00,'����ȼ�վ��ŵ��ڲ���Ϣ');
insert into t_book values
(t_bookid_sq.nextval,'�嵤������','������','��ѩ������',76.00,'���Ǽ�¼�嵤��ս��');
