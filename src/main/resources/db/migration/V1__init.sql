create table PAYMENT_ACCOUNT (
    id serial not null primary key,
    cancelled_at timestamp,
    created_at timestamp,
    updated_at timestamp,
    payment_type bigint not null
);

create table PAYMENT_REGISTER (
    id serial not null primary key,
    charged_value decimal(19,2),
    status integer,
    payment_register_id bigint
);

create table PAYMENT_TYPE (
   dtype varchar(31) not null,
   id serial not null primary key
);

create table PLAN (
    id serial not null primary key,
    created_at timestamp,
    description varchar(255),
    name varchar(255),
    price decimal(19,2),
    trial_period integer
);

create table SUBSCRIPTION (
    id serial not null primary key,
    cancelled_at timestamp,
    created_at timestamp,
    status integer,
    updated_at timestamp,
    payment_account_id bigint not null,
    plan_id bigint not null
);

alter table PAYMENT_ACCOUNT
   add constraint UK_78d9etl38bfeh5kmlci73e24o unique (payment_type);

alter table SUBSCRIPTION
   add constraint UK_tcvdferykde38qvw4udsddxl4 unique (payment_account_id);

alter table PAYMENT_ACCOUNT
   add constraint FKphi6t8ylnwquh4qchxirv4s1
   foreign key (payment_type)
   references payment_type;

alter table PAYMENT_REGISTER
   add constraint FK1wa4knmyncppg98nc2kqfjxir
   foreign key (payment_register_id)
   references payment_account;

alter table SUBSCRIPTION
   add constraint FKilip5xpi4yg5isyjunbwk3egk
   foreign key (payment_account_id)
   references payment_account;

alter table SUBSCRIPTION
   add constraint FK8lkqdq029r91j37wwfkc4k5ci
   foreign key (plan_id)
   references plan;
