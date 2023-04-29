drop table if exists Orders;

create table Orders (
    orderId     UUID primary key,
    description VARCHAR(500),
    total       NUMERIC(9, 3),
    createDateTime TIMESTAMP default CURRENT_TIMESTAMP
);

drop table if exists OrderItems;
create table OrderItems(
    orderItemId UUID primary key,
    orderId UUID,
    description VARCHAR(500),
    price NUMERIC(9,3),
    tax NUMERIC(9,3),
    createDateTime TIMESTAMP default CURRENT_TIMESTAMP
);

alter table OrderItems
    add constraint FK__ORDER_ITEMS__ORDERS__ORDERID
        FOREIGN KEY (orderId) references Orders(orderId);
