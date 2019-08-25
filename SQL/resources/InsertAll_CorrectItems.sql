drop table if exists grocery_list.correct_items cascade;
CREATE TABLE grocery_list.correct_items (ID INT(5) NOT NULL AUTO_INCREMENT, Item VARCHAR(45) NOT NULL, PRIMARY KEY (ID), UNIQUE INDEX Item_UNIQUE (Item ASC) VISIBLE);
insert into grocery_list.correct_items(Item) values('Milk');
insert into grocery_list.correct_items(Item) values('Apple');
insert into grocery_list.correct_items(Item) values('Meat');