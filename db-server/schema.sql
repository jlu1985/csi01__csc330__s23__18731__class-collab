drop table if exists OrderItems;
drop table if exists Orders;

create table Orders (
    orderId     UUID primary key,
    description VARCHAR(5000),
    total       NUMERIC(9, 3),
    createDateTime TIMESTAMP default CURRENT_TIMESTAMP
);


create table OrderItems(
    orderItemId UUID primary key,
    orderId UUID,
    description VARCHAR(5000),
    price NUMERIC(9,3),
    tax NUMERIC(9,3),
    createDateTime TIMESTAMP default CURRENT_TIMESTAMP
);

alter table OrderItems
    add constraint FK__ORDER_ITEMS__ORDERS__ORDERID
        FOREIGN KEY (orderId) references Orders(orderId);
