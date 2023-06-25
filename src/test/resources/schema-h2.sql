-- public.developer definition

-- Drop table

-- DROP TABLE public.developer;

CREATE TABLE public.developer (
	id IDENTITY NOT NULL,
	cover_photo varchar(1000) NULL,
	description varchar(1000) NULL,
	established_date date NULL,
	developer_name varchar(255) NULL,
	thumbnail varchar(1000) NULL,
	CONSTRAINT developer_pkey PRIMARY KEY (id)
);


-- public.genre definition

-- Drop table

-- DROP TABLE public.genre;

CREATE TABLE public.genre (
	id IDENTITY NOT NULL,
	genre_name varchar(500) NULL,
	CONSTRAINT genre_pkey PRIMARY KEY (id)
);


-- public.publisher definition

-- Drop table

-- DROP TABLE public.publisher;

CREATE TABLE public.publisher (
	id IDENTITY NOT NULL,
	cover_photo varchar(1000) NULL,
	description varchar(1000) NULL,
	established_date date NULL,
	publisher_name varchar(255) NULL,
	thumbnail varchar(1000) NULL,
	CONSTRAINT publisher_pkey PRIMARY KEY (id)
);


-- public.user_info definition

-- Drop table

-- DROP TABLE public.user_info;

CREATE TABLE public.user_info (
	id IDENTITY NOT NULL,
	active bool NULL,
	address varchar(2000) NULL,
	balance numeric(20, 2) NULL,
	dob date NULL,
	email varchar(1000) NULL,
	first_name varchar(500) NULL,
	gender varchar(255) NULL,
	last_name varchar(500) NULL,
	user_password varchar(1000) NULL,
	profile_img varchar(5000) NULL,
	registered_date date NULL,
	telephone_num varchar(255) NULL,
	username varchar(500) NULL,
	CONSTRAINT user_info_pkey PRIMARY KEY (id)
);


-- public.game definition

-- Drop table

-- DROP TABLE public.game;

CREATE TABLE public.game (
	id IDENTITY NOT NULL,
	description varchar(3000) NULL,
	game_name varchar(2000) NULL,
	price numeric(4, 2) NULL,
	released_date date NULL,
	system_req varchar(5000) NULL,
	thumbnail varchar(2000) NULL,
	trailer varchar(3000) NULL,
	developer_id int4 NULL,
	publisher_id int4 NULL,
	CONSTRAINT game_pkey PRIMARY KEY (id),
	CONSTRAINT fkgpenvlwr21y1g95uq6lv8of0u FOREIGN KEY (developer_id) REFERENCES public.developer(id),
	CONSTRAINT fkrkratxa6tso6uahpbd5w9ghay FOREIGN KEY (publisher_id) REFERENCES public.publisher(id)
);


-- public.game_code definition

-- Drop table

-- DROP TABLE public.game_code;

CREATE TABLE public.game_code (
	id IDENTITY NOT NULL,
	game_code varchar(255) NULL,
	status varchar(255) NULL,
	game_id int4 NULL,
	CONSTRAINT game_code_pkey PRIMARY KEY (id),
	CONSTRAINT uk_qnhrcwbg9evuljxmais7nc7ok UNIQUE (game_code),
	CONSTRAINT fklcdevsgdbpt5bmilbmfdi4crv FOREIGN KEY (game_id) REFERENCES public.game(id)
);


-- public.game_comment definition

-- Drop table

-- DROP TABLE public.game_comment;

CREATE TABLE public.game_comment (
	id IDENTITY NOT NULL,
	comment_content varchar(3000) NULL,
	comment_date date NULL,
	game_id int4 NULL,
	user_id int4 NULL,
	CONSTRAINT game_comment_pkey PRIMARY KEY (id),
	CONSTRAINT fka12awbtj2h6ryodqreqli7k1e FOREIGN KEY (game_id) REFERENCES public.game(id),
	CONSTRAINT fkexqci9bxbhis0htlsb8w13j8j FOREIGN KEY (user_id) REFERENCES public.user_info(id)
);


-- public.game_genre definition

-- Drop table

-- DROP TABLE public.game_genre;

CREATE TABLE public.game_genre (
	id IDENTITY NOT NULL,
	game_id int4 NULL,
	genre_id int4 NULL,
	CONSTRAINT game_genre_pkey PRIMARY KEY (id),
	CONSTRAINT fkfgiexxwmferkxqbwbjs989ea9 FOREIGN KEY (genre_id) REFERENCES public.genre(id),
	CONSTRAINT fkj47t9lfhtj14lsg346bo3vujv FOREIGN KEY (game_id) REFERENCES public.game(id)
);


-- public.game_image definition

-- Drop table

-- DROP TABLE public.game_image;

CREATE TABLE public.game_image (
	id IDENTITY NOT NULL,
	image_link varchar(255) NULL,
	game_id int4 NULL,
	CONSTRAINT game_image_pkey PRIMARY KEY (id),
	CONSTRAINT fk55g08nttj1l2ecmbuvl8ttle9 FOREIGN KEY (game_id) REFERENCES public.game(id)
);


-- public.rating definition

-- Drop table

-- DROP TABLE public.rating;

CREATE TABLE public.rating (
	id IDENTITY NOT NULL,
	rating int4 NULL,
	game_id int4 NULL,
	user_id int4 NULL,
	CONSTRAINT rating_pkey PRIMARY KEY (id),
	CONSTRAINT fke6hcuecfdtxu1f7i332ahiu6y FOREIGN KEY (user_id) REFERENCES public.user_info(id),
	CONSTRAINT fkhotxgrgtrin4xcto6n1j4a946 FOREIGN KEY (game_id) REFERENCES public.game(id)
);


-- public.receipt definition

-- Drop table

-- DROP TABLE public.receipt;

CREATE TABLE public.receipt (
	id IDENTITY NOT NULL,
	receipt_date date NULL,
	user_id int4 NULL,
	CONSTRAINT receipt_pkey PRIMARY KEY (id),
	CONSTRAINT fknsitn2khc8yqsk8pvhfocl3wv FOREIGN KEY (user_id) REFERENCES public.user_info(id)
);


-- public.receipt_details definition

-- Drop table

-- DROP TABLE public.receipt_details;

CREATE TABLE public.receipt_details (
	id IDENTITY NOT NULL,
	game_price numeric(4, 2) NULL,
	game_code_id int4 NULL,
	receipt_id int4 NULL,
	CONSTRAINT receipt_details_pkey PRIMARY KEY (id),
	CONSTRAINT fkirugk8blqnuf6pi9ehbxm0euy FOREIGN KEY (game_code_id) REFERENCES public.game_code(id),
	CONSTRAINT fkpkdffw2hifmlrufrfhj5oavl0 FOREIGN KEY (receipt_id) REFERENCES public.receipt(id)
);


-- public.sub_genre definition

-- Drop table

-- DROP TABLE public.sub_genre;

CREATE TABLE public.sub_genre (
	id IDENTITY NOT NULL,
	sub_genre_name varchar(500) NULL,
	genre_id int4 NULL,
	CONSTRAINT sub_genre_pkey PRIMARY KEY (id),
	CONSTRAINT fkbrog1qyg4wbwdxshs151obma9 FOREIGN KEY (genre_id) REFERENCES public.genre(id)
);


-- public.user_role_assignment definition

-- Drop table

-- DROP TABLE public.user_role_assignment;

CREATE TABLE public.user_role_assignment (
	id IDENTITY NOT NULL,
	assigned_date timestamp NULL,
	"role" varchar(255) NULL,
	modified_date timestamp NULL,
	user_id int4 NULL,
	CONSTRAINT user_role_assignment_pkey PRIMARY KEY (id),
	CONSTRAINT fk4wib9qcx27t1dje0oq8pst08k FOREIGN KEY (user_id) REFERENCES public.user_info(id)
);


-- public.game_sub_genre definition

-- Drop table

-- DROP TABLE public.game_sub_genre;

CREATE TABLE public.game_sub_genre (
	id IDENTITY NOT NULL,
	game_id int4 NULL,
	sub_genre_id int4 NULL,
	CONSTRAINT game_sub_genre_pkey PRIMARY KEY (id),
	CONSTRAINT fk334e4qvpr90wo92chhxtgbhu5 FOREIGN KEY (sub_genre_id) REFERENCES public.sub_genre(id),
	CONSTRAINT fkxujp56edrrrfjgnykg34vj70 FOREIGN KEY (game_id) REFERENCES public.game(id)
);