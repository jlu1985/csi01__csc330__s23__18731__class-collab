insert into orders (orderId, description, total)
values (UUID(), 'pizza one', 9.23);

insert into ORDERITEMS (orderitemid, orderid, description, price, tax)
select
    UUID(), orderid , 'pepponi', 8.93, 1.2 from orders where DESCRIPTION='pizza one';

insert into ORDERITEMS (orderitemid, orderid, description, price, tax)
select
    UUID(), orderid , 'cheese', 8.93, 1.2 from orders where DESCRIPTION='pizza one';

delete from ORDERITEMS;
delete from orders;

select * from orders;
select * from ORDERITEMS;