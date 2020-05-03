CREATE TABLE CUSTOMER(
	username VARCHAR2(20) NOT NULL,
	password VARCHAR2(20) NOT NULL,
	email VARCHAR(20) NOT NULL CHECK(REGEXP_LIKE(email, '[A-Z0-9._%-]+@[A-Z0-9._%-]+\.[A-Z]{2,4}')),
	birthDate DATE NOT NULL,
	address VARCHAR2(80) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY(username)
	);
CREATE TABLE SUPPLIER(
	username VARCHAR2(20) NOT NULL,
	password VARCHAR2(20) NOT NULL,
	email VARCHAR(20) NOT NULL,
	birthDate DATE NOT NULL,
	balance INTEGER NOT NULL,
	CONSTRAINT supplier_pk PRIMARY KEY(username)
);

CREATE TABLE BOOK(
	id INTEGER NOT NULL,
	title VARCHAR2(20) NOT NULL,
	publisher VARCHAR2(30) NOT NULL,
	year DATE,
	pic BLOB,

	CONSTRAINT book_pk PRIMARY KEY(id)
);

CREATE SEQUENCE BOOK_SEQ;

CREATE OR REPLACE TRIGGER BOOK_TRG 
BEFORE INSERT ON BOOK
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT BOOK_SEQ.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

CREATE TABLE AUTHOR(
	book_id INTEGER NOT NULL,
	author VARCHAR2(30) NOT NULL,
	CONSTRAINT auths_pk PRIMARY KEY(book_id,author),
	CONSTRAINT auths_fk
		FOREIGN KEY(book_id)
		REFERENCES BOOK(id)
		ON DELETE CASCADE 
);
CREATE TABLE GENRE(
	book_id INTEGER NOT NULL,
	genre VARCHAR2(30) NOT NULL,
	CONSTRAINT genre_pk PRIMARY KEY(book_id,genre),
	CONSTRAINT genre_fk
		FOREIGN KEY(book_id)
		REFERENCES BOOK(id)
		ON DELETE CASCADE
);
CREATE TABLE STORE(
	address VARCHAR2(80) NOT NULL,
	profit INTEGER NOT NULL,
	name VARCHAR2(40) NOT NULL,

	CONSTRAINT store_pk PRIMARY KEY(address)
);

CREATE TABLE COMPANY(
	tax_number INTEGER NOT NULL,
	profit INTEGER NOT NULL,
	name varchar2(60) NOT NULL,

	CONSTRAINT company_pk PRIMARY KEY(tax_number)
);

CREATE TABLE PURCHASE(
	customer VARCHAR2(20) NOT NULL,
	book_id INTEGER NOT NULL,
	amount INTEGER NOT NULL,
	purchase_time TIMESTAMP NOT NULL,
	address VARCHAR2(80) NOT NULL,
	delivery NUMBER(1) NOT NULL,

	CONSTRAINT purchase_pk PRIMARY KEY(customer,purchase_time,book_id),
	CONSTRAINT purchase_fk1 FOREIGN KEY(customer) REFERENCES CUSTOMER(username) ON DELETE CASCADE,
	CONSTRAINT purchase_fk2 FOREIGN KEY(book_id) REFERENCES BOOK(id) ON DELETE CASCADE,
	CONSTRAINT purchase_fk3 FOREIGN KEY(address) REFERENCES STORE(address) ON DELETE CASCADE
);

CREATE TABLE SUPPLY(
	id INTEGER NOT NULL,
	supplier_username VARCHAR2(20) NOT NULL,
	store_address VARCHAR2(80) NOT NULL,
	supply_date TIMESTAMP NOT NULL,

	CONSTRAINT supply_pk PRIMARY KEY(id),
	CONSTRAINT supply_fk1 FOREIGN KEY(supplier_username) REFERENCES SUPPLIER(username) ON DELETE CASCADE,
	CONSTRAINT supply_fk2 FOREIGN KEY(store_address) REFERENCES STORE(address) ON DELETE CASCADE
);

CREATE SEQUENCE SUPPLY_SEQ;

CREATE OR REPLACE TRIGGER SUPPLY_TRG 
BEFORE INSERT ON SUPPLY
FOR EACH ROW
WHEN (new.id IS NULL)
BEGIN
  SELECT SUPPLY_SEQ.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/

CREATE TABLE PACKAGE(
	supply_id INTEGER NOT NULL,
	book_id INTEGER NOT NULL,
	amount INTEGER NOT NULL,

	CONSTRAINT package_pk PRIMARY KEY(supply_id,book_id),
	CONSTRAINT package_fk1 FOREIGN KEY(supply_id) REFERENCES SUPPLY(id) ON DELETE CASCADE,
	CONSTRAINT package_fk2 FOREIGN KEY(book_id) REFERENCES BOOK(id) ON DELETE CASCADE
);

CREATE TABLE PRICE(
	book_id INTEGER NOT NULL,
	wholesale INTEGER NOT NULL,
	sale INTEGER NOT NULL,
	store_address VARCHAR2(80) NOT NULL,

	CONSTRAINT price_pk PRIMARY KEY(book_id,store_address),
	CONSTRAINT price_fk1 FOREIGN KEY(book_id) REFERENCES BOOK(id) ON DELETE CASCADE,
	CONSTRAINT price_fk2 FOREIGN KEY(store_address) REFERENCES STORE(address) ON DELETE CASCADE
);

CREATE TABLE STOCK(
	store_address VARCHAR2(80) NOT NULL,
	book_id INTEGER NOT NULL,
	amount INTEGER NOT NULL,

	CONSTRAINT stock_pk PRIMARY KEY(store_address,book_id),
	CONSTRAINT stock_fk1 FOREIGN KEY(book_id) REFERENCES BOOK(id) ON DELETE CASCADE,
	CONSTRAINT stock_fk2 FOREIGN KEY(store_address) REFERENCES STORE(address) ON DELETE CASCADE
);

CREATE TABLE CONTRACT(
	supplier_username VARCHAR2(20) NOT NULL,
	company_tax INTEGER NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,

	CONSTRAINT contract_pk PRIMARY KEY(supplier_username,company_tax),
	CONSTRAINT contract_fk1 FOREIGN KEY(supplier_username) REFERENCES SUPPLIER(username) ON DELETE CASCADE,
	CONSTRAINT contract_fk2 FOREIGN KEY(company_tax) REFERENCES COMPANY(tax_number) ON DELETE CASCADE
);

CREATE OR REPLACE TRIGGER CUST_EMAIL
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
DECLARE
    EXIST number;
BEGIN
    SELECT COUNT(*) INTO EXIST FROM customer
    WHERE customer.email=:NEW.email;
    IF (EXIST != 0) THEN
        RAISE_APPLICATION_ERROR(-20010,'Email already used!');
    END IF;
END;

CREATE OR REPLACE TRIGGER SUPP_EMAIL
BEFORE INSERT ON SUPPLIER
FOR EACH ROW
DECLARE
    EXIST number;
BEGIN
    SELECT COUNT(*) INTO EXIST FROM supplier
    WHERE supplier.email=:NEW.email;
    IF (EXIST != 0) THEN
        RAISE_APPLICATION_ERROR(-20010,'Email already used!');
    END IF;
END;

CREATE OR REPLACE TRIGGER null_pic
BEFORE INSERT ON BOOK
FOR EACH ROW
DECLARE
    pict BOOK.pic%type;
BEGIN
    IF :NEW.pic is null THEN
        SELECT pic INTO pict FROM BOOK where id = 2;
        :NEW.pic := pict;
    END IF;
END;

create or replace function cheapest
(id IN BOOK.id%type)
return varchar2
is
    res STORE.address%type;
begin
    SELECT STORE_ADDRESS INTO res FROM PRICE WHERE book_id = id AND sale = (SELECT MIN(sale) FROM PRICE WHERE book_id=id) AND ROWNUM =1;
    return res;
end;

create or replace function totalInStore
(store_ IN STORE.address%type)
return integer
is
    sum_ integer;
begin
    SELECT SUM(amount) into sum_ FROM STOCK WHERE store_address=store_;
    return sum_;
end;


create or replace procedure renewContract
	(supp in contract.supplier_username%type,comp in contract.company_tax%type, start_ in contract.start_date%type)
as  
begin
	UPDATE CONTRACT SET start_date=start_, end_date=add_months(start_,12) WHERE supplier_username=supp AND company_tax=comp;
end;