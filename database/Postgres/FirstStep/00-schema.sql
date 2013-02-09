
drop table if exists GENRE cascade;
drop table if exists ALBUM cascade;

drop sequence if exists SEQ_GENRE;
drop sequence if exists SEQ_ALBUM;

create sequence SEQ_GENRE start with 100 increment by 1;
create sequence SEQ_ALBUM start with 100 increment by 1;

CREATE TABLE GENRE(
	id numeric DEFAULT NEXTVAL('SEQ_GENRE'),
	name varchar(64) not null,
	description varchar(1024),
	constraint PK_GENRE primary key (id)
);

CREATE TABLE ALBUM(
	id numeric NOT NULL DEFAULT NEXTVAL('SEQ_ALBUM'),
	genre_id numeric NOT NULL,
	title varchar(160) NOT NULL,
	constraint PK_ALBUM primary key (id),
	constraint FK1_ALBUM foreign key (genre_id) references GENRE(id) on delete cascade
);
