create table publisher(
	id int4 constraint publisher_id_pk primary key not null,
	publisher_name varchar,
	thumbnail varchar,
	cover_photo varchar,
	description varchar,
	established_date Date
);

insert into publisher(id, publisher_name, thumbnail, cover_photo, description, established_date)
values(1, 'Sony Interactive Entertainment', 'https://avatars.cloudflare.steamstatic.com/40a85b52747a78b26e393e3f9e58f319194b1b33_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/40425349/c263d17394502cedbf90373599eb2706ca84074d.png','PlayStation Studios is home to the development of Sony Interactive Entertainment’s own outstanding and immersive games, including some of the most popular and critically acclaimed titles in entertainment history.', '1993-11-16'),
(2, 'Capcom', 'https://avatars.cloudflare.steamstatic.com/6b62a91eb5a093261d8831d1908717bab0d687e9_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33273264/4256bc824357bb34aa4e2f7f11df9a62633d286f.png',null, '1979-05-30'),
(3, 'Ubisoft','https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33075774/6f635e1eeae42b293705087fc040e77116ed365a.png','Ubisoft is a creator of worlds, committed to enriching players'' lives with original and memorable gaming experiences.', '1986-03-28'),
(4, 'Electronic Arts', 'https://avatars.cloudflare.steamstatic.com/618cc2a46fad78ed1259df505c2de5bb4d806532_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/36135791/b42c79819a407c68f5b12a0028a2a8871bec6c7c.png',null, '1982-05-27'),
(5, 'KOEI TECMO', 'https://avatars.cloudflare.steamstatic.com/f76177141df41c80109df7c0df81f303a933a44c_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33016879/c0a3a3a256b1c8c0023cfce1a0fe900abb4cd64a.png',null, '2009-01-14'),
(6, 'CD PROJEKT RED', 'https://avatars.cloudflare.steamstatic.com/4f1187c11ad41f8aa58b9109efd52c2f8bca9918_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/32989758/b05e42588fee27abeb63080593125642b63cf219.jpg','CD PROJEKT RED is a development studio founded in 2002. Our mission is to tell emotional stories riddled with meaningful choices and consequences, as well as featuring characters gamers can truly connect with.', '2002-01-01'),
(7, 'Rockstar Games', 'https://avatars.cloudflare.steamstatic.com/d83a1786f23929deb5f20326f128bbc13a9a1e85_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1541443/fb4af705f9b9e9d14640e48258d6ee11b8ad15a6.jpg',null, '1988-12-01'),
(8, 'Bandai Namco Entertainment', 'https://avatars.cloudflare.steamstatic.com/97ea9619ba3076b8549c1484bef9308a67f0c64d_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33042543/22343df6affaa7a2657500d398024aed36ec2cba.png','Bandai Namco exists to share dreams, fun and inspiration with people around the world. Do you wish to enjoy every single day to the fullest? What we want is for people like you to always have a reason to smile.', '2006-03-31'),
(9, 'Quantic Dream', 'https://avatars.cloudflare.steamstatic.com/baf1dce75db2d5bfb0f5e14dd2183c4cb61911f7_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/37700027/df452cd72626e4abc7fa73f6d641a5ce65cd2d19.jpg','Quantic Dream is an award-winning French video game developer and publisher founded to create AAA games with a focus on emotional, interactive storytelling and innovation in narrative.', '1997-05-02'),
(10, 'Square Enix', 'https://avatars.cloudflare.steamstatic.com/2fe0615e013c887e87dd230e8268afdd15416f12_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1012195/52ab50f3f89e6188291c848fe7d4a45c86415d0a.jpg', null, '2003-04-01'),
(11, 'From Software', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Fromsoftware_logo.svg/220px-Fromsoftware_logo.svg.png', 'https://wallpaperaccess.com/full/2651906.jpg',null, '1986-11-01'),
(12, 'Activision', 'https://avatars.cloudflare.steamstatic.com/751c4faad6133699315ca7d4ae03293cd3abbe49_full.jpg', 'https://cdn.akamai.steamstatic.com/steam/apps/1938090/page_bg_generated_v6b.jpg?t=1683652297','Founded in 1979, Activision continues to disrupt the world of entertainment with its extensive roster of epic blockbuster games.', '1979-10-01');


create table developer(
	id int4 constraint developer_id_pk primary key not null,
	developer_name varchar,
	thumbnail varchar,
	cover_photo varchar,
	description varchar,
	established_date Date
);

insert into developer(id, developer_name, thumbnail, cover_photo, description, established_date) 
values(1, 'Santa Monica Studio', 'https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Santa_Monica_Studio.svg/220px-Santa_Monica_Studio.svg.png', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnDTkdA38Qi_7RLtj2283fRSJxLHxvX6FdZg&usqp=CAU',null, '1999-01-01'),
(2, 'Capcom', 'https://avatars.cloudflare.steamstatic.com/6b62a91eb5a093261d8831d1908717bab0d687e9_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33273264/4256bc824357bb34aa4e2f7f11df9a62633d286f.png',null, '1979-05-30'),
(3, 'Ubisoft','https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33075774/6f635e1eeae42b293705087fc040e77116ed365a.png','Ubisoft is a creator of worlds, committed to enriching players'' lives with original and memorable gaming experiences.', '1986-03-28'),
(4, 'Electronic Arts', 'https://avatars.cloudflare.steamstatic.com/618cc2a46fad78ed1259df505c2de5bb4d806532_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/36135791/b42c79819a407c68f5b12a0028a2a8871bec6c7c.png', null, '1982-05-27'),
(5, 'KOEI TECMO', 'https://avatars.cloudflare.steamstatic.com/f76177141df41c80109df7c0df81f303a933a44c_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33016879/c0a3a3a256b1c8c0023cfce1a0fe900abb4cd64a.png', null, '2009-01-14'),
(6, 'CD PROJEKT RED', 'https://avatars.cloudflare.steamstatic.com/4f1187c11ad41f8aa58b9109efd52c2f8bca9918_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/32989758/b05e42588fee27abeb63080593125642b63cf219.jpg','CD PROJEKT RED is a development studio founded in 2002. Our mission is to tell emotional stories riddled with meaningful choices and consequences, as well as featuring characters gamers can truly connect with.', '2002-01-01'),
(7, 'Rockstar Games', 'https://avatars.cloudflare.steamstatic.com/d83a1786f23929deb5f20326f128bbc13a9a1e85_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1541443/fb4af705f9b9e9d14640e48258d6ee11b8ad15a6.jpg', null, '1988-12-01'),
(8, 'Bandai Namco Entertainment', 'https://avatars.cloudflare.steamstatic.com/97ea9619ba3076b8549c1484bef9308a67f0c64d_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33042543/22343df6affaa7a2657500d398024aed36ec2cba.png', 'Bandai Namco exists to share dreams, fun and inspiration with people around the world. Do you wish to enjoy every single day to the fullest? What we want is for people like you to always have a reason to smile.', '2006-03-31'),
(9, 'Quantic Dream', 'https://avatars.cloudflare.steamstatic.com/baf1dce75db2d5bfb0f5e14dd2183c4cb61911f7_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/37700027/df452cd72626e4abc7fa73f6d641a5ce65cd2d19.jpg', 'Quantic Dream is an award-winning French video game developer and publisher founded to create AAA games with a focus on emotional, interactive storytelling and innovation in narrative.', '1997-05-02'),
(10, 'SEGA', 'https://avatars.cloudflare.steamstatic.com/93aafaeb1ee958cc14bb78344df71c92d9734980_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/32528477/75c893bdb19f4785094b30c98cc90f8fc69546b9.png','“To be this good takes AGES”', '1960-03-06'),
(11, 'Blizzard Entertainment, Inc.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Blizzard_Entertainment_Logo_2015.svg/220px-Blizzard_Entertainment_Logo_2015.svg.png', 'https://static.wikia.nocookie.net/diablo/images/a/af/BlizzardEnt.jpg/revision/latest?cb=20080703111353','At Blizzard Entertainment, we pour our hearts and souls into everything we create. We embrace our core values every day so that we can continue creating epic entertainment experiences for all our players. It doesn’t matter who you are or where you’re located—if you’re a member of our evolving and vibrant community, working with us at one of our offices around the globe, or taking a piece of Blizzard with you into space—you’re welcome here.', '1991-02-01'),
(12, 'Square Enix', 'https://avatars.cloudflare.steamstatic.com/2fe0615e013c887e87dd230e8268afdd15416f12_full.jpg', 'https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1012195/52ab50f3f89e6188291c848fe7d4a45c86415d0a.jpg', null, '2003-04-01'),
(13, 'From Software', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Fromsoftware_logo.svg/220px-Fromsoftware_logo.svg.png', 'https://wallpaperaccess.com/full/2651906.jpg', null, '1986-11-01'),
(14, 'Guerrilla Games', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/17/Guerrilla_logo.svg/220px-Guerrilla_logo.svg.png', 'https://www.guerrilla-games.com/media/OG/gg-games-og-image-1200x628.jpg', 'Guerrilla is one of Europe''s leading game companies and a wholly-owned subsidiary of Sony Interactive Entertainment Europe. We started in 2003, and have pushed the boundaries of technical and artistic excellence in our games ever since.', '2000-01-01'),
(15, 'Naughty Dog', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Naughty_Dog.svg/220px-Naughty_Dog.svg.png', 'https://s3.amazonaws.com/nd.images/uploads/blog_default-red.png', 'Established in 1984, Naughty Dog is one of the most successful and prolific game development studios in the world and a flagship first-party studio within PlayStation Studios. From creating the iconic Crash Bandicoot and Jak and Daxter series to modern franchises like Uncharted and The Last of Us, Naughty Dog is responsible for some of the most critically acclaimed and commercially successful games on Sony’s PlayStation platforms. Through its use of cutting-edge technology and evocative, character-driven storytelling, Naughty Dog has received hundreds of industry and media awards, while developing a passionate fan base of millions of players around the globe.','1984-01-01'),
(16, 'Insomniac Games', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Insomniac_Games_logo.svg/220px-Insomniac_Games_logo.svg.png', 'https://twistedvoxel.com/wp-content/uploads/2022/05/insomniac-Games.png', 'To create games that have a positive and lasting influence on people’s lives.','1994-02-28'),
(17, 'Bioware', 'https://avatars.cloudflare.steamstatic.com/00d6df183d7b4eb8ac84a60a1f1a708b40dfcce9_full.jpg', 'https://static0.gamerantimages.com/wordpress/wp-content/uploads/2022/07/bioware-games-jade-empire-knights-of-the-old-republic-anthem.jpg', 'Creating worlds of adventure, conflict and companionship that inspire you to become the hero of your story.', '1995-02-01'),
(18, 'Respawn Entertainment', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Respawn_Logo.png/220px-Respawn_Logo.png', 'https://static.wikia.nocookie.net/starwars/images/7/72/Respawn_logo.jpg/revision/latest?cb=20190410014944', 'We create incredible gameplay experiences.', '2010-04-12'),
(19, 'Treyarch', 'https://upload.wikimedia.org/wikipedia/en/thumb/7/7a/Treyarch_logo.svg/330px-Treyarch_logo.svg.png', 'https://www.gamespot.com/a/uploads/original/1179/11799911/2800388-treyarch.jpg', 'DEVELOPING GAMES SINCE 1996, TREYARCH IS HOME TO THE INDUSTRY''S BEST AND BRIGHTEST TALENT.','1996-01-01'),
(20, 'Radical Entertainment', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Radical_Entertainment_logo.svg/330px-Radical_Entertainment_logo.svg.png', 'https://i0.wp.com/xboxera.com/wp-content/uploads/2022/02/Radical-Entertainment.png?fit=1920%2C1080&ssl=1', NULL, '1991-09-01'),
(21, 'Infinity Ward', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Infinity_Ward.svg/330px-Infinity_Ward.svg.png', 'https://www.callofduty.com/content/dam/atvi/callofduty/cod-touchui/blog/hero/mwii/MWII-001-IW-INTRO-TOUT.jpg', 'TOGETHER, WE''VE CRAFTED A LEGENDARY FRANCHISE THAT TRANSFORMED A GENREEXPLORE', '2002-05-01');

--create table user_role(
--	id int4 constraint userRole_id_pk primary key not null,
--	role_name varchar
--);
--
--insert into user_role
--values(1, 'user'),
--(2, 'admin');

create table user_info(
	id int4 constraint user_id_pk primary key not null,
	first_name varchar,
	last_name varchar,
	user_password varchar,
	email varchar,
	telephone_num varchar,
	address varchar,
	dob Date,
	gender varchar,
	profile_img varchar,
	balance numeric(7,2),
	registered_date Date,
	active boolean
);

--insert into user_info(id, first_name, last_name, user_password, email, telephone_num, address, dob, gender, profile_img, balance, user_role, active)
--values(1, 'Pepito', 'Cours', 'SlFsVmVK', 'pcours0@buzzfeed.com', '277-432-4462', '418 Katie Court', '1972-01-15', 'Male', 'https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(2, 'Mala', 'Longforth', 'RGJFYlBwRg==', 'mlongforth1@china.com.cn', '659-648-8888', '49 Vidon Place', '1971-06-10', 'Female', 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(3, 'Benjamin', 'Raspin', 'b2k3dTVnRmhKaHJZ', 'braspin2@state.tx.us', '134-274-3255', '3 Kenwood Trail', '1969-01-27', 'Male', 'https://as2.ftcdn.net/v2/jpg/03/64/21/11/1000_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg', 10000, 'USER', true),
--(4, 'Eleanora', 'Mc Caughan', 'MEk0WngzaVU=', 'emccaughan3@tiny.cc', '925-879-8502', '927 Armistice Point', '1977-09-16', 'Female', 'https://images.pexels.com/photos/634021/pexels-photo-634021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(5, 'Cross', 'Rawes', 'MEk0WngzaVU=', 'crawes4@ucsd.edu', '326-298-1898', '104 Dexter Point', '1932-09-30', 'Male', 'https://images.pexels.com/photos/2589653/pexels-photo-2589653.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(6, 'Addison', 'Blaylock', 'eVlySHo5', 'ablaylock5@phpbb.com', '668-215-6778', '472 Russell Drive', '1993-02-27', 'Male', 'https://images.pexels.com/photos/428361/pexels-photo-428361.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(7, 'Benton', 'Pocknoll', 'dWR2YXZwNkg=', 'bpocknoll6@typepad.com', '520-164-6847', '2120 Washington Court', '1985-06-15','Male', 'https://images.pexels.com/photos/1462980/pexels-photo-1462980.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(8, 'Faunie', 'Kirtland', 'dlVJQzQ0YXhIdQ==', 'fkirtland7@furl.net', '627-957-7220', '6635 Buell Crossing', '1931-07-26', 'Female', 'https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(9, 'Marie-jeanne', 'Romei', 'Nm1ncEhSU2JlQXE=', 'mromei8@moonfruit.com', '286-211-0645', '85432 Stephen Alley', '1959-09-11', 'Female', 'https://images.pexels.com/photos/1858175/pexels-photo-1858175.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(10, 'Reynard', 'Ansteys', 'dTdZa2dVT2M=', 'ransteys9@ucoz.com', '792-341-0273', '517 Pawling Center', '1974-07-02', 'Male', 'https://images.pexels.com/photos/3785079/pexels-photo-3785079.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(11, 'Emily', 'Limeburn', 'aXZ4a1ljeDJL', 'elimeburna@moonfruit.com', '222-686-0489', '13 Meadow Ridge Junction', '1942-03-13', 'Female', 'https://images.pexels.com/photos/3958866/pexels-photo-3958866.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(12,'Wylma','Lillgard','Mk1ESlUwWUY5MmJC','wlillgardb@chronoengine.com','802-409-4899','021 Glacier Hill Terrace','1937-07-02','Female', 'https://images.pexels.com/photos/4992382/pexels-photo-4992382.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(13,'Dee','Tollfree','xnQFiVQRxV','dtollfreec@sciencedaily.com','713-202-6315','590 Everett Street','1970-08-13','Female', 'https://images.pexels.com/photos/1860368/pexels-photo-1860368.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(14,'Susie','Ballin','eG5RRmlWUVJ4Vg==','sballind@digg.com','297-923-0089','38 Basil Avenue','1993-12-01','Female', 'https://images.pexels.com/photos/6950769/pexels-photo-6950769.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(15,'Wilmette','Layne','frxSR0','wlaynee@state.gov','875-113-6511','21683 Lindbergh Court','1931-11-27','Female', 'https://images.pexels.com/photos/1914877/pexels-photo-1914877.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(16,'Felicle','Winspar','ZnJ4U1Iw','fwinsparf@redcross.org','751-934-5761','78 Manitowish Circle','1949-11-29','Female', 'https://media.istockphoto.com/id/1370426275/photo/portrait-of-middle-aged-woman-with-ginger-hair.jpg?s=612x612&w=0&k=20&c=gdEulh7b2F0_1xFuJeoD7bEoiw2oaxZ_9VRw21j5MUI=', 10000, 'USER', true),
--(17,'Eldridge','Feast','zrImlZkT','efeastg@instagram.com','543-471-8206','2132 Vahlen Circle','1986-10-09','Male', 'https://images.pexels.com/photos/34534/people-peoples-homeless-male.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(18,'Edy','Ofield','enJJbWxaa1Q=','eofieldh@cocolog-nifty.com','592-216-7132','5387 Charing Cross Point','1954-04-15','Female', 'https://images.pexels.com/photos/4116988/pexels-photo-4116988.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(19,'Morton','Minghella','MUtweklE','mminghellai@nhs.uk','222-241-1513','74 Blackbird Center','1999-02-28','Male', 'https://images.pexels.com/photos/810775/pexels-photo-810775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(20,'Laurence','Mooney','8116Oifsp2Ll','lmooneyj@vistaprint.com','203-843-3920','4 Porter Junction','1962-10-19','Male', 'https://images.pexels.com/photos/1451162/pexels-photo-1451162.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(21,'Myrna','Kowalski','ODExNk9pZnNwMkxs','mkowalskik@quantcast.com','229-955-0371','77 Ridgeview Crossing','1987-04-10','Female', 'https://images.pexels.com/photos/5951543/pexels-photo-5951543.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(22,'Yolanthe','MacDearmont','ioYDxV','ymacdearmontl@theguardian.com','657-643-1026','56972 Karstens Avenue','1973-06-05','Female', 'https://images.pexels.com/photos/3764119/pexels-photo-3764119.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(23,'Finn','Ferrillo','aW9ZRHhW','fferrillom@histats.com','647-489-2623','72 Melby Court','1959-08-13','Male', 'https://images.pexels.com/photos/947639/pexels-photo-947639.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, 'USER', true),
--(24,'Nelia','Crisford','WjRVUXdHUmRL','ncrisfordn@com.com','454-496-2875','37 Carioca Alley','1935-12-06','Female', 'https://images.pexels.com/photos/2761798/pexels-photo-2761798.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, 'USER', true),
--(25,'Hoang', 'Vu', 'MTIzNDU2Nzg5', 'hoangvu@gmail.com', '045678912','69 Hang Chuoi', '1995-12-09','Male',  null, 10000, 'ADMIN', true);

insert into user_info(id, first_name, last_name, username, user_password, email, telephone_num, address, dob, gender, profile_img, balance, registered_date, active)
values(1, 'Pepito', 'Cours', 'pepitocours','SlFsVmVK', 'pcours0@buzzfeed.com', '277-432-4462', '418 Katie Court', '1972-01-15', 'Male', 'https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2001-03-04',true),
(2, 'Mala', 'Longforth', 'malalongforth','RGJFYlBwRg==', 'mlongforth1@china.com.cn', '659-648-8888', '49 Vidon Place', '1971-06-10', 'Female', 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2000-05-13',true),
(3, 'Benjamin', 'Raspin', 'benjaminraspin','b2k3dTVnRmhKaHJZ', 'braspin2@state.tx.us', '134-274-3255', '3 Kenwood Trail', '1969-01-27', 'Male', 'https://as2.ftcdn.net/v2/jpg/03/64/21/11/1000_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg', 10000, '2002-11-22',true),
(4, 'Eleanora', 'Mc Caughan', 'eleanoracaughan','MEk0WngzaVU=', 'emccaughan3@tiny.cc', '925-879-8502', '927 Armistice Point', '1977-09-16', 'Female', 'https://images.pexels.com/photos/634021/pexels-photo-634021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2000-01-19',true),
(5, 'Cross', 'Rawes', 'crossrawes','MEk0WngzaVU=', 'crawes4@ucsd.edu', '326-298-1898', '104 Dexter Point', '1932-09-30', 'Male', 'https://images.pexels.com/photos/2589653/pexels-photo-2589653.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2003-07-11',true),
(6, 'Addison', 'Blaylock', 'addisonblaylock','eVlySHo5', 'ablaylock5@phpbb.com', '668-215-6778', '472 Russell Drive', '1993-02-27', 'Male', 'https://images.pexels.com/photos/428361/pexels-photo-428361.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2001-08-03',true),
(7, 'Benton', 'Pocknoll', 'bentonpocknoll','dWR2YXZwNkg=', 'bpocknoll6@typepad.com', '520-164-6847', '2120 Washington Court', '1985-06-15','Male', 'https://images.pexels.com/photos/1462980/pexels-photo-1462980.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2002-10-30',true),
(8, 'Faunie', 'Kirtland', 'fauniekirtland','dlVJQzQ0YXhIdQ==', 'fkirtland7@furl.net', '627-957-7220', '6635 Buell Crossing', '1931-07-26', 'Female', 'https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2004-02-19',true),
(9, 'Marie-jeanne', 'Romei', 'mariejeanneromei','Nm1ncEhSU2JlQXE=', 'mromei8@moonfruit.com', '286-211-0645', '85432 Stephen Alley', '1959-09-11', 'Female', 'https://images.pexels.com/photos/1858175/pexels-photo-1858175.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2000-05-15',true),
(10, 'Reynard', 'Ansteys', 'reynardansteys','dTdZa2dVT2M=', 'ransteys9@ucoz.com', '792-341-0273', '517 Pawling Center', '1974-07-02', 'Male', 'https://images.pexels.com/photos/3785079/pexels-photo-3785079.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2002-12-03',true),
(11, 'Emily', 'Limeburn', 'emilylimeburn','aXZ4a1ljeDJL', 'elimeburna@moonfruit.com', '222-686-0489', '13 Meadow Ridge Junction', '1942-03-13', 'Female', 'https://images.pexels.com/photos/3958866/pexels-photo-3958866.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2001-08-27',true),
(12,'Wylma','Lillgard', 'wylmalillgard','Mk1ESlUwWUY5MmJC','wlillgardb@chronoengine.com','802-409-4899','021 Glacier Hill Terrace','1937-07-02','Female', 'https://images.pexels.com/photos/4992382/pexels-photo-4992382.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2005-07-14',true),
(13,'Dee','Tollfree', 'deetollfree','xnQFiVQRxV','dtollfreec@sciencedaily.com','713-202-6315','590 Everett Street','1970-08-13','Female', 'https://images.pexels.com/photos/1860368/pexels-photo-1860368.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2004-06-16',true),
(14,'Susie','Ballin', 'susieballin','eG5RRmlWUVJ4Vg==','sballind@digg.com','297-923-0089','38 Basil Avenue','1993-12-01','Female', 'https://images.pexels.com/photos/6950769/pexels-photo-6950769.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2003-09-24',true),
(15,'Wilmette','Layne', 'wilmettelayne','frxSR0','wlaynee@state.gov','875-113-6511','21683 Lindbergh Court','1931-11-27','Female', 'https://images.pexels.com/photos/1914877/pexels-photo-1914877.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '1999-04-05',true),
(16,'Felicle','Winspar', 'feliclewinspar','ZnJ4U1Iw','fwinsparf@redcross.org','751-934-5761','78 Manitowish Circle','1949-11-29','Female', 'https://media.istockphoto.com/id/1370426275/photo/portrait-of-middle-aged-woman-with-ginger-hair.jpg?s=612x612&w=0&k=20&c=gdEulh7b2F0_1xFuJeoD7bEoiw2oaxZ_9VRw21j5MUI=', 10000, '2011-03-19',true),
(17,'Eldridge','Feast', 'eldridgefeast','zrImlZkT','efeastg@instagram.com','543-471-8206','2132 Vahlen Circle','1986-10-09','Male', 'https://images.pexels.com/photos/34534/people-peoples-homeless-male.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2010-10-10',true),
(18,'Edy','Ofield', 'edyofield','enJJbWxaa1Q=','eofieldh@cocolog-nifty.com','592-216-7132','5387 Charing Cross Point','1954-04-15','Female', 'https://images.pexels.com/photos/4116988/pexels-photo-4116988.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2012-05-04',true),
(19,'Morton','Minghella', 'mortonminghella','MUtweklE','mminghellai@nhs.uk','222-241-1513','74 Blackbird Center','1999-02-28','Male', 'https://images.pexels.com/photos/810775/pexels-photo-810775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2015-08-28',true),
(20,'Laurence','Mooney', 'laurencemooney','8116Oifsp2Ll','lmooneyj@vistaprint.com','203-843-3920','4 Porter Junction','1962-10-19','Male', 'https://images.pexels.com/photos/1451162/pexels-photo-1451162.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2011-01-29',true),
(21,'Myrna','Kowalski', 'myrnakowalski','ODExNk9pZnNwMkxs','mkowalskik@quantcast.com','229-955-0371','77 Ridgeview Crossing','1987-04-10','Female', 'https://images.pexels.com/photos/5951543/pexels-photo-5951543.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2016-05-21',true),
(22,'Yolanthe','MacDearmont', 'yolanthemacdearmont','ioYDxV','ymacdearmontl@theguardian.com','657-643-1026','56972 Karstens Avenue','1973-06-05','Female', 'https://images.pexels.com/photos/3764119/pexels-photo-3764119.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2012-12-25',true),
(23,'Finn','Ferrillo', 'finnferrillo','aW9ZRHhW','fferrillom@histats.com','647-489-2623','72 Melby Court','1959-08-13','Male', 'https://images.pexels.com/photos/947639/pexels-photo-947639.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 10000, '2013-04-19',true),
(24,'Nelia','Crisford', 'neliacrisford','WjRVUXdHUmRL','ncrisfordn@com.com','454-496-2875','37 Carioca Alley','1935-12-06','Female', 'https://images.pexels.com/photos/2761798/pexels-photo-2761798.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load', 10000, '2015-07-27',true),
(25,'Hoang', 'Vu', 'hoangvu', 'MTIzNDU2Nzg5', 'hoangvu@gmail.com', '045678912','69 Hang Chuoi', '1995-12-09','Male',  null, 10000, '2023-03-13',true);


create table game_image(
	id int constraint gameImage_id_pk primary key not null,
	game_id int,
	image_link varchar,
	constraint gameImage_game_fk foreign key(game_id) references game(id)
);

insert into game_image(id, game_id, image_link)
values(1, 1, 'https://oyster.ignimgs.com/mediawiki/apis.ign.com/uncharted-4/c/c8/10_TheTwelveTowers_01.jpg'),
(2, 1, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1659420/ss_a1816dd536122dd740043c2b9440136503904215.1920x1080.jpg?t=1672777947'),
(3, 1, ' https://images.fpt.shop/unsafe/filters:quality(90)/fptshop.com.vn/uploads/images/tin-tuc/149709/Originals/18091357154041%20f.jpg'),
(4, 2, 'https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2018%2F12%2Fgod-of-war-2018-2000.jpg&q=60'),
(5, 2, 'https://gamek.mediacdn.vn/133514250583805952/2021/9/13/photo-1-1631509649707187539248.jpg'),
(6, 2, 'https://cdn.vox-cdn.com/thumbor/aUT1f87v_ylNloorzykySRudgTs=/0x0:1894x1061/1200x675/filters:focal(796x380:1098x682)/cdn.vox-cdn.com/uploads/chorus_image/image/59356329/My_Great_Capture_Screenshot_2018_04_02_13_17_17.0.png'),
(7, 3, 'https://gamingtrend.com/wp-content/uploads/2020/08/youtube-thumb-1.jpg'),
(8, 3, 'https://www.trustedreviews.com/wp-content/uploads/sites/54/2015/10/horizons-6-1-1.jpg'),
(9, 3, 'https://assets1.ignimgs.com/2017/02/19/horizonzerodawn-1280-1487544580639_160w.jpg?width=1280'),
(10, 4, 'https://d1lss44hh2trtw.cloudfront.net/assets/article/2023/03/29/the-last-of-us-part-1-screenshot_feature.jpg'),
(11, 4, 'https://cdn.mos.cms.futurecdn.net/F39y9wwLUA3exsUdsQ48TG.jpg'),
(12, 4, 'https://imgix.bustle.com/uploads/image/2022/8/30/b2131db1-23c2-4f9b-8b8d-7205f3e0dfe1-39cfa7cf-d780-4938-a892-62893f3c9a5e-tlou1-9.jpeg?w=1200&h=630&fit=crop&crop=faces&fm=jpg'),
(13, 5, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1817070/ss_dfba6f2477bfa42be69ddfdffbd421d3943d20bf.1920x1080.jpg?t=1673999865'),
(14, 5, 'https://m.economictimes.com/thumb/msid-93539140,width-1200,height-900,resizemode-4,imgsize-50614/marvels-spider-man-remastered-is-finally-coming-to-pc-check-out-features-compatibility-release-date.jpg'),
(15, 5, 'https://elcomercio.pe/resizer/pqa7PD22SYNol04bcTnwtbYz_Yo=/1200x675/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/UN4QELBNTNB5JEX5TAMODBDUNA.jpeg'),
(16, 6, 'https://cdn.marvel.com/content/1x/msmmm_pc_teaser_holiday_review.jpg'),
(17, 6, 'https://cdn.marvel.com/content/1x/msmmm_pc_prepurchase_spidercat_legal.jpg'),
(18, 6, 'https://criticalhits.com.br/wp-content/uploads/2022/10/ae41e378c218909d9ae220f14dd513f41a684b49-910x512.webp'),
(19, 7, 'https://imgproxy4.tinhte.vn/SnESwIbnugRoIuEDBLYs_zZDg-c369cM71UcCfFu8Ko/w:600/plain/https://downsieutoc.com/wp-content/uploads/2019/03/Devil-May-Cry-5-Free-Download-2.jpg'),
(20, 7, 'https://cdn.tgdd.vn/GameApp/4/241082/Screentshots/devil-may-cry-5-tam-man-su-that-game-nhap-vai-nhat-ban-01-06-2021-3.jpg'),
(21, 7, 'https://game8.vn/media/202008/images/5-best-games-like-devil-may-cry.jpg'),
(22, 8, 'https://photo2.tinhte.vn/data/attachment-files/2022/06/6020342_Cover_RE.jpg'),
(23, 8, 'https://cdn.vox-cdn.com/uploads/chorus_asset/file/22497090/Resident_Evil_Village.jpg'),
(24, 8, 'https://img.phonandroid.com/2022/09/re-village-switch-cloud.jpg'),
(25, 9, 'https://i.pcmag.com/imagery/reviews/04vxluHbMx1lIU9IXTUDQry-3..v1569469944.jpg'),
(26, 9, 'https://cdn.akamai.steamstatic.com/steam/apps/742300/ss_b1449d9556d073825ea685245a59204f7249c587.1920x1080.jpg?t=1669873876'),
(27, 9, 'https://herogame.vn/ad-min/assets/js/libs/kcfinder/upload/images/Herogame_MegaMan11_03.jpg'),
(28, 10, 'https://cdn.tgdd.vn/GameApp/4/237211/Screentshots/monster-hunter-world-12-04-2021-4.jpg'),
(29, 10, 'https://cdn.mos.cms.futurecdn.net/cktziwMLuMkcv2CkqojB2k.jpg'),
(30, 10, 'https://m.media-amazon.com/images/M/MV5BNzEwNDFhODMtOGQ5NC00YmYwLTk3NTgtMDZkMjAyM2IwOGMyXkEyXkFqcGdeQXVyODg5MjUwNDY@._V1_.jpg'),
(31, 11, 'https://genk.mediacdn.vn/2016/d2-1481021847671.jpg'),
(32, 11, 'https://cdn.cloudflare.steamstatic.com/steam/apps/543460/ss_f11543d355d5e78a307b3256ae65d6f37371efed.1920x1080.jpg?t=1644282464'),
(33, 11, 'https://images.squarespace-cdn.com/content/v1/55ef0e29e4b099e22cdc9eea/1479309412001-6N7C1FZ892QNOK38BPDP/image-asset.jpeg'),
(34, 12, 'https://cdn.akamai.steamstatic.com/steam/apps/45760/ss_da00f2eb81e916929258bd8640705ad5c8c67ef8.1920x1080.jpg?t=1644283495'),
(35, 12, 'https://sm.ign.com/t/ign_latam/articlepage/u/ultra-stre/ultra-street-fighter-4-ps4-release-date-and-pricin_myza.1280.jpg'),
(36, 12, 'https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2014/05/22/1331653325744_2/die-besten-street-fighter-iv-duelle-aller-zeiten'),
(37, 13, 'https://cdn.tgdd.vn/GameApp/4/255518/Screentshots/tai-watch-dogs-2-sieu-pham-bom-tan-den-tu-nha-ubisoft-24-10-2021-1.jpg'),
(38, 13, 'https://www.rtlnieuws.nl/sites/default/files/content/images/2016/11/20/Watch-Dogs-2-4K-gameplay-1920x1080.jpg?itok=UMdOoDwI&width=2048&height=1152&impolicy=semi_dynamic'),
(39, 13, 'https://pliki.ppe.pl/storage/ad09e0f32bb299e81336/ad09e0f32bb299e81336-1600w.jpg'),
(40, 14, 'https://cdn.cloudflare.steamstatic.com/steam/apps/2208920/ss_103481084a59b34837113daf27c04679caf743f3.1920x1080.jpg?t=1671135934'),
(41, 14, 'https://ftw.usatoday.com/wp-content/uploads/sites/90/2021/12/ac-valhalla-dawn-of-ragnarok.jpg?w=1024&h=576&crop=1'),
(42, 14, 'https://preview.redd.it/5v2rq0da7t481.jpg?width=610&format=pjpg&auto=webp&s=ee35b7ffb23c9b139a8669ef196002019847a19e'),
(43, 15, 'https://static.wikia.nocookie.net/rainbowsix/images/6/69/651.jpg/revision/latest?cb=20191115144313'),
(44, 15, 'https://gamek.mediacdn.vn/133514250583805952/2020/3/6/photo-1-15834836824451583570575.jpg'),
(45, 15, 'https://cdn.siege.gg/img/articles/1301.23a8223.jpg'),
(46, 16, 'https://cdn.akamai.steamstatic.com/steam/apps/552520/ss_f5ee2fb899c32f4c627ee250949645e52161150b.1920x1080.jpg?t=1681229356'),
(47, 16, 'https://cdn.akamai.steamstatic.com/steam/apps/552520/ss_539a82bb6b1960c64fc13e88b079d85ffca77881.1920x1080.jpg?t=1681229356'),
(48, 16, 'https://s.isanook.com/ga/0/ud/201/1006753/01.jpg'),
(49, 17, 'https://cdn-img.thethao247.vn/storage/files/haibui/2022/09/30/tua-game-bong-da-fifa-23-chinh-thuc-ra-mat-195141.jpg'),
(50, 17, 'https://cdn.gametv.vn/news_media/image/FIFA-23-World-Cup-1_0x0_1675304326.png'),
(51, 17, 'https://staticg.sportskeeda.com/editor/2022/10/f32fd-16658531869499-1920.jpg'),
(52, 18, 'https://eu-images.contentstack.com/v3/assets/blt95b381df7c12c15d/blt0068f7ee85633ce7/63d17511b8ce4767e36b20c4/deadspaceremakefeatured.jpg?quality=80&format=jpg&width=828'),
(53, 18, 'https://cdn.mos.cms.futurecdn.net/Z3uRqREbWnnvvfhzTvASVh-1200-80.jpg'),
(54, 18, 'https://s2.glbimg.com/oiv-YQtwkEYHLafbqpwmlVxX11U=/0x0:3840x2160/924x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2022/E/E/gM3HSSQOi6zKAR1Dhb2A/cwcqmuhs.png'),
(55, 19, 'https://www.nme.com/wp-content/uploads/2021/04/Mass-Effect-Mako.jpg'),
(56, 19, 'https://i0.wp.com/d9n64ieh9hz8y.cloudfront.net/wp-content/uploads/20210527192949/mass-effect-1-legendary-edition-danh-gia-game-5.jpg?resize=800%2C450&ssl=1'),
(57, 19, 'https://hexus.net/media/uploaded/2020/11/81c1fb1c-ad07-4e5b-b9c0-89ecda7e0236.jpg'),
(58, 20, 'https://cdn.tgdd.vn/GameApp/4/244291/Screentshots/titanfall-2-28-06-2021-6.jpg'),
(59, 20, 'https://hiepsibaotap.com/wp-content/uploads/2019/10/apps.47068.65123785197113223.0191c6ed-9ff7-488b-b8cc-c338d3886461.jpg'),
(60, 20, 'https://www.digitaltrends.com/wp-content/uploads/2016/10/Titanfall-2-Review-0006.jpg?p=1'),
(61, 21, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1448440/ss_36a81a85d8f775a29d410d398c59686e81d0c303.1920x1080.jpg?t=1681280378'),
(62, 21, 'https://culturageek.com.ar/wp-content/uploads/2023/03/Wo-Long-Fallen-Dynasty-culturageek.com_.ar-1.jpg'),
(63, 21, 'https://adrenaline.com.br/uploads/chamadas/Wo_Long_Fallen_Dynasty_primeiro_trailer_de_historia.jpg'),
(64, 22, 'https://cdn.tgdd.vn/GameApp/4/274388/Screentshots/dynasty-warriors-9-empires-tiep-tuc-hanh-trinh-thong-11-03-2022-1.png'),
(65, 22, 'https://m.media-amazon.com/images/I/911p21GGxgL._AC_SL1500_.jpg'),
(66, 22, 'https://cdn.akamai.steamstatic.com/steam/apps/1341200/ss_a14de0a9b4cae52eb7f31c32387b9ec0b4cd90b1.1920x1080.jpg?t=1673512802'),
(67, 23, 'https://cdn.akamai.steamstatic.com/steam/apps/958260/ss_11e364968b9ab0681d436452d0865cc864ff9b71.1920x1080.jpg?t=1680773796'),
(68, 23, 'https://cdn.akamai.steamstatic.com/steam/apps/958260/ss_8ae7e7540e5a92caacb40780e4867ae1bfc55854.1920x1080.jpg?t=1680773796'),
(69, 23, 'https://gamefabrique.com/screenshots2/pc/dead-or-alive-extreme-venus-vacation-03.big.jpg'),
(70, 24, 'https://cdn.tgdd.vn/GameApp/4/255641/Screentshots/tai-dead-or-alive-6-mat-hon-voi-nhung-nhan-vat-cuc-hap-26-10-2021-2.png'),
(71, 24, 'https://haloshop.vn/image/catalog/blogs/dead-or-alive-6-game-doi-khang-toan-my-nu-xinh-dep/dead-or-alive-6-game-doi-khang-toan-my-nu-xinh-dep-8.jpg'),
(72, 24, 'https://cdn.tgdd.vn/GameApp/4/255641/Screentshots/tai-dead-or-alive-6-mat-hon-voi-nhung-nhan-vat-cuc-hap-26-10-2021-0.png'),
(73, 25, 'https://cdn.akamai.steamstatic.com/steam/apps/292030/ss_0901e64e9d4b8ebaea8348c194e7a3644d2d832d.1920x1080.jpg?t=1675178392'),
(74, 25, 'https://www.digitaltrends.com/wp-content/uploads/2015/06/The-Witcher-3-Wild-Hunt-Stag-Battle.jpg?p=1'),
(75, 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZYNAB7eqqPL5oNRmpyKNaGvUxpCCEZdYE4KVsPSG_C1xnQ42swDlwcSjif7_G8vWhOSA&usqp=CAU'),
(76, 26, 'https://images.gog-statics.com/c0d58028ae827a37a47a4ab77473bdeb27ec92c65093ea21ab468fe4bfda59db_product_card_v2_mobile_slider_639.jpg'),
(77, 26, 'https://www.cyberpunk.net/build/images/home3/screen-image-mercenary-e79283ec.jpg'),
(78, 26, 'https://leclaireur.fnac.com/wp-content/uploads/2022/01/cyberpunk-2077-1256x826.jpeg'),
(79, 27, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1284410/ss_2d17cc665fbab97cc96f43bead1a13ef73d3bb5b.1920x1080.jpg?t=1659615342'),
(80, 27, 'https://images.gog-statics.com/c16c9e9175c56fe59e0e5953379633192bc6b0b7f5eff2c69e5c3941b995a30c_product_card_v2_mobile_slider_639.jpg'),
(81, 27, 'https://i.ytimg.com/vi/h5Rqdzv9ZGY/maxresdefault.jpg'),
(82, 28, 'https://i.ytimg.com/vi/UK_tMhLyPy8/maxresdefault.jpg'),
(83, 28, 'https://gallery.poskota.co.id/storage/Foto/6wkBw7S8q9nKY7VCzXrD3L.jpg'),
(84, 28, 'https://www.lexpress.fr/resizer/PYxrKoyUgHrdoXPVGGEAq3RkeSw=/970x548/cloudfront-eu-central-1.images.arcpublishing.com/lexpress/XFOPQHFKEVCNRJ2VQTWUEA2LIE.jpg'),
(85, 29, 'https://static01.nyt.com/images/2018/11/25/opinion/25SUDERMAN/25SUDERMAN-videoSixteenByNineJumbo1600.jpg'),
(86, 29, 'https://www.pcworld.com/wp-content/uploads/2021/09/base-profile-screenshot-2019.11.05-14.21.01.04-100816901-orig.jpg?quality=50&strip=all'),
(87, 29, 'https://www.hollywoodreporter.com/wp-content/uploads/2018/10/red_dead_redemption_2_screengrab.jpg?w=1296'),
(88, 30, 'https://static01.nyt.com/images/2012/05/15/arts/PAYNE/PAYNE-superJumbo.jpg'),
(89, 30, 'https://images.ctfassets.net/wn7ipiv9ue5v/AbWN0aHIx0Lw7SCqYk535/bd5de6f45ea9d5acf2dfbf21edd72bb5/ss_8e2bb13d1078aa87d3121847049ccfcc093f578b.jpg'),
(90, 30, 'https://img.ibxk.com.br/2022/05/15/a-15022257355003.jpg?ims=328x'),
(91, 31, 'https://cdn.vox-cdn.com/thumbor/TCAmBK_Z-wk2gzPlAFzedLtn8Zc=/0x0:1920x1080/1200x800/filters:focal(807x387:1113x693)/cdn.vox-cdn.com/uploads/chorus_image/image/62572837/Soulcalibur_6_guide_7.0.jpg'),
(92, 31, 'https://static.bandainamcoent.eu/high/soulcalibur/soulcalibur-6/03-news/soulcalibur-6_community-faq.jpg'),
(93, 31, 'https://cdn.wccftech.com/wp-content/uploads/2018/10/rah_h_16_1537286236.png'),
(94, 32, 'https://gamek.mediacdn.vn/133514250583805952/2022/12/27/tekken-7-01-1670817381070-1670817381670388740213-1672056004397-16720560050081637539324-1672057510426-167205751054572944817-1672108380705-1672108380825261401599.jpg'),
(95, 32, 'https://assets1.ignimgs.com/2017/05/31/tekken7-1280-2-1496201471106_160w.jpg?width=1280'),
(96, 32, 'https://assets.altarofgaming.com/wp-content/uploads/2020/11/character-selection-screen-tekken-7.jpg'),
(97, 33, 'https://static.bandainamcoent.eu/high/one-piece/one-piece-odyssey/00-page-setup/OPOD_header_mobile_new.jpg'),
(98, 33, 'https://www.digitaltrends.com/wp-content/uploads/2022/12/A-screenshot-of-Luffy-in-battle-in-One-Piece-Odyssey..jpg?fit=720%2C405&p=1'),
(99, 33, 'https://www.digitaltrends.com/wp-content/uploads/2023/01/The-Straw-Hats-meeting-a-crab-mover-in-One-Piece-Odyssey..jpg?p=1'),
(100, 34, 'https://cdn.tgdd.vn/GameApp/4/240209/Screentshots/scarlet-nexus-24-05-2021-1.jpg'),
(101, 34, 'https://ecdn.game4v.com/g4v-content/uploads/2023/01/27170950/game4v-scarlet-nexus-01-1674814188-81.png'),
(102, 34, 'https://www.stargamers.nl/test/wp-content/uploads/2021/07/scarlet-nexus-4.jpg'),
(103, 35, 'https://www.digitaltrends.com/wp-content/uploads/2017/12/Detroit-Become-Human-Hands-On-Preview-828.jpg?resize=625%2C417&p=1'),
(104, 35, 'https://www.playstore.com/storage/images/gallery/product/25365/892x504/6-detroit-become-human.webp'),
(105, 35, 'https://hd2.tudocdn.net/763653?w=1200&h=675'),
(106, 36, 'https://m.media-amazon.com/images/M/MV5BMTQzOTU4NjI4Nl5BMl5BanBnXkFtZTgwMDYzNDc1MDE@._V1_.jpg'),
(107, 36, 'https://cdn.akamai.steamstatic.com/steam/apps/960990/ss_fe44ec0e7b3676465167715b388b6d6484e82ef0.1920x1080.jpg?t=1667468566'),
(108, 36, 'https://cdn.arstechnica.net/wp-content/uploads/2013/10/BEYOND_SCREEN_14.jpg'),
(109, 37, 'https://cdn.cloudflare.steamstatic.com/steam/apps/960910/ss_ae2b1381c68d8d909f02b9005ae97a2d818b4c93.1920x1080.jpg?t=1675271942'),
(110, 37, 'https://cdn.mos.cms.futurecdn.net/B5ANYXiNwfTMSLkjWUAq5J.jpg'),
(111, 37, 'https://cdn.cloudflare.steamstatic.com/steam/apps/960910/ss_f123d7bbd8c3e55ad42b3048be0d9685cab4bc6a.1920x1080.jpg?t=1675271942'),
(112, 38, 'https://cdn.akamai.steamstatic.com/steam/apps/1963210/ss_80603153a15f54ec617872c5a5ec5f63c1022b40.1920x1080.jpg?t=1680172058'),
(113, 38, 'https://cdn.akamai.steamstatic.com/steam/apps/1963210/ss_cae86f0a0a6f8b8dea5588f0b088ad823da1e1ed.1920x1080.jpg?t=1680172058'),
(114, 38, 'https://images.squarespace-cdn.com/content/v1/613ef8a0a3de987d28d14431/1666112471579-5BF1WMNBQUGWBGH64BBL/VALKYRIE+ELYSIUM_20221005102122.jpg'),
(115, 39, 'https://bizweb.dktcdn.net/100/452/569/products/a75c2fb1-3654-4277-a389-4e4449d2228a.jpg?v=1651131778970'),
(116, 39, 'https://venturebeat.com/wp-content/uploads/2020/04/aerith.jpg?fit=3341%2C1871&strip=all'),
(117, 39, 'https://oyster.ignimgs.com/mediawiki/apis.ign.com/final-fantasy-vii-remake/9/94/Final-Fantasy-VII-Remake-Tifa.jpg'),
(118, 40, 'https://images.nintendolife.com/88d4670d47aa0/octopath-traveler-ii.large.jpg'),
(119, 40, 'https://imageio.forbes.com/specials-images/imageserve/63f3294477272d12e2ed2989/0x0.jpg?format=jpg&width=1200'),
(120, 40, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1971650/ss_cd859f6ff08f678304dac0d8c36299b0a2f82a32.1920x1080.jpg?t=1679563605'),
(121, 41, 'https://cdn.cloudflare.steamstatic.com/steam/apps/374320/ss_12c4d9a3c04d6d340ffea9335441eb2ad84e0028.1920x1080.jpg?t=1671097812'),
(122, 41, 'https://s.yimg.com/ny/api/res/1.2/YZuYvHtLxInT6FJwqgGezQ--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/os/creatr-uploaded-images/2022-01/5a0909e0-7c5c-11ec-a79f-c2114d050d43'),
(123, 41, 'https://i.pcmag.com/imagery/reviews/05isLvYQj5GS0EuxqHnsSfW-3.fit_scale.size_760x427.v1569482291.jpg'),
(124, 42, 'https://www.videogameschronicle.com/files/2022/02/sds5.jpg'),
(125, 42, 'https://cdn.cloudflare.steamstatic.com/steam/apps/1245620/ss_e87a3e84890ab19f8995566e62762d5f8ed39315.1920x1080.jpg?t=1674441703'),
(126, 42, 'https://sm.ign.com/ign_it/preview/e/elden-ring/elden-ring-the-first-preview_gq54.jpg'),
(127, 43, 'https://cdn.akamai.steamstatic.com/steam/apps/42700/ss_e3ad24dd02143ffbbbf17467fde104b462c9120e.1920x1080.jpg?t=1654809667'),
(128, 43, 'https://cdn.akamai.steamstatic.com/steam/apps/42700/ss_f6e1e6377f0b41e34575dc9d73e62784b2395731.1920x1080.jpg?t=1654809667'),
(129, 43, 'https://cdn.akamai.steamstatic.com/steam/apps/42700/ss_775f7d3ef83669a70f9f008359f78177027fed21.1920x1080.jpg?t=1654809667'),
(130, 44, 'https://www.straight.com/files/v3/styles/gs_feature/public/2012/10/Prototype1.jpg?itok=Knxh6l08'),
(131, 44, 'https://m.media-amazon.com/images/M/MV5BZDY3ZmQ0MTYtOTFjOS00ZWZiLTk3MzAtNzY1MWEyNGNiOWRhXkEyXkFqcGdeQXVyNjcyNzkwMTc@._V1_.jpg'),
(132, 44, 'https://extralives.files.wordpress.com/2009/06/prototype_1.jpg'),
(133, 45, 'https://cdn.akamai.steamstatic.com/steam/apps/7940/0000002996.1920x1080.jpg?t=1678298739'),
(134, 45, 'https://cdn.cloudflare.steamstatic.com/steam/apps/7940/0000003000.1920x1080.jpg?t=1678298739'),
(135, 45, 'https://cdn.akamai.steamstatic.com/steam/apps/7940/0000002990.1920x1080.jpg?t=1678298739'),
(136, 46, 'https://i.kinja-img.com/gawker-media/image/upload/c_fit,f_auto,g_center,q_60,w_645/e3681f8adbccc9dbd923ffa04d88ede4.jpg'),
(137, 46, 'https://hiepsibaotap.com/wp-content/uploads/2023/04/resident-evil-4-remake-achievements-e1678692077105.jpg'),
(138, 46, 'https://www.videogameschronicle.com/files/2022/10/%E3%80%90RE4%E3%80%91_SS_33_GL.jpg');

create table game(
	id int constraint game_id_pk primary key not null,
	developer_id int,
	publisher_id int,
	game_name varchar,
	thumbnail varchar,
	description varchar,
	trailer varchar,
	released_date Date,
	system_req varchar,
	price numeric(4,2),
	constraint game_fk_dev_id foreign key(developer_id) references developer(id),
	constraint game_fk_pub_id foreign key(publisher_id) references publisher(id)
);

insert into Game(id, developer_id, publisher_id, game_name, thumbnail, description, trailer, released_date, system_req, price)
values(1, 1, 1, 'UNCHARTED™: Legacy of Thieves Collection', 'https://upload.wikimedia.org/wikipedia/en/1/1a/Uncharted_4_box_artwork.jpg', 'Play as Nathan Drake and Chloe Frazer in their own standalone adventures as they confront their pasts and forge their own legacies. This game includes the critically acclaimed single-player stories from both UNCHARTED 4: A Thief’s End and UNCHARTED: The Lost Legacy.', 'https://www.youtube.com/watch?v=F3Wl-OiZCO4', '2022-10-19', 'MINIMUM:
OS: Windows 10 64-bit
Processor: Intel i5-4430, AMD Ryzen 3 1200
Memory: 8 GB RAM
Graphics: NVIDIA GTX 960 (4 GB), AMD R9 290X (4 GB)
DirectX: Version 12
Storage: 126 GB available space', 59.99),
(2, 1, 1, 'God of War (2018)', 'https://upload.wikimedia.org/wikipedia/en/a/a7/God_of_War_4_cover.jpg', 'His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.','https://www.youtube.com/watch?v=HqQMh_tij0c', '2022-01-14', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bit
Processor: Intel i5-2500k (4 core 3.3 GHz) or AMD Ryzen 3 1200 (4 core 3.1 GHz)
Memory: 8 GB RAM
Graphics: NVIDIA GTX 960 (4 GB) or AMD R9 290X (4 GB)
DirectX: Version 11
Storage: 70 GB available space
Additional Notes: DirectX feature level 11_1 required', 59.99),
(3, 14, 1, 'Horizon Zero Dawn™ Complete Edition', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464', 'Experience Aloy’s legendary quest to unravel the mysteries of a future Earth ruled by Machines. Use devastating tactical attacks against your prey and explore a majestic open world in this award-winning action RPG!', 'https://www.youtube.com/watch?v=76O5KaJHEA0', '2020-08-07', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bits
Processor: Intel Core i5-2500K@3.3GHz or AMD FX 6300@3.5GHz
Memory: 8 GB RAM
Graphics: Nvidia GeForce GTX 780 (3 GB) or AMD Radeon R9 290 (4GB)
DirectX: Version 12
Storage: 100 GB available space', 29.99),
(4, 15, 1, 'The Last of Us™ Part I', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1680282721', 'Experience the emotional storytelling and unforgettable characters in The Last of Us™, winner of over 200 Game of the Year awards.', 'https://www.youtube.com/watch?v=CxVyuE2Nn_w', '20223-03-28', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 (Version 1909 or Newer)
Processor: AMD Ryzen 5 1500X, Intel Core i7-4770K
Memory: 16 GB RAM
Graphics: AMD Radeon RX 470 (4 GB), AMD Radeon RX 6500 XT (4 GB), NVIDIA GeForce GTX 970 (4 GB), NVIDIA GeForce GTX 1050 Ti (4 GB)
Storage: 100 GB available space
Additional Notes: SSD Recommended', 59.99),
(5, 16, 1, 'Marvel’s Spider-Man Remastered', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1817070/header.jpg?t=1673999865', 'In Marvel’s Spider-Man Remastered, the worlds of Peter Parker and Spider-Man collide in an original action-packed story. Play as an experienced Peter Parker, fighting big crime and iconic villains in Marvel’s New York.', 'https://www.youtube.com/watch?v=1E051WtpyWg', '2022-08-12','MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bit
Processor: Intel Core i3-4160, 3.6 GHz or AMD equivalent
Memory: 8 GB RAM
Graphics: NVIDIA GTX 950 or AMD Radeon RX 470
DirectX: Version 12
Storage: 75 GB available space',59.99),
(6, 16, 1, 'Marvel’s Spider-Man: Miles Morales', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1817190/header.jpg?t=1672784176', 'After the events of Marvel’s Spider-Man Remastered, teenage Miles Morales is adjusting to his new home while following in the footsteps of his mentor, Peter Parker, as a new Spider-Man.', 'https://www.youtube.com/watch?v=CMRBuagwRb4', '2022-11-18', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bit 1909
Processor: Intel Core i3-4160, 3.6 GHz or AMD equivalent
Memory: 8 GB RAM
Graphics: NVIDIA GTX 950 or AMD Radeon RX 470
DirectX: Version 12
Storage: 75 GB available space', 59.99 ),
(7, 2, 2, 'Devil May Cry 5', 'https://upload.wikimedia.org/wikipedia/en/c/cb/Devil_May_Cry_5.jpg', 'The ultimate Devil Hunter is back in style, in the game action fans have been waiting for.', 'https://www.youtube.com/watch?v=KMSGj9Y2T9Q', '2019-03-08', 'MINIMUM:
OS: WINDOWS® 7, 8.1, 10 (64-BIT Required)
Processor: Intel® Core™ i5-4460, AMD FX™-6300, or better
Memory: 8 GB RAM
Graphics: NVIDIA® GeForce® GTX 760 or AMD Radeon™ R7 260x with 2GB Video RAM, or better
DirectX: Version 11
Storage: 35 GB available space
Additional Notes: *Xinput support Controllers recommended *Internet connection required for game activation. (Network connectivity uses Steam® developed by Valve® Corporation.)', 39.99 ),
(8, 2, 2, 'Resident Evil Village', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1196590/header.jpg?t=1681094558', 'Experience survival horror like never before in the 8th major installment in the Resident Evil franchise - Resident Evil Village. With detailed graphics, intense first-person action and masterful storytelling, the terror has never felt more realistic.', 'https://www.youtube.com/watch?v=26tay8lMZW4','2021-05-7', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 (64 bit)
Processor: AMD Ryzen 3 1200 ／ Intel Core i5-7500
Memory: 8 GB RAM
Graphics: AMD Radeon RX 560 with 4GB VRAM ／ NVIDIA GeForce GTX 1050 Ti with 4GB VRAM
DirectX: Version 12
Additional Notes: Estimated performance (when set to Prioritize Performance): 1080p/60fps. ・Framerate might drop in graphics-intensive scenes. ・AMD Radeon RX 6700 XT or NVIDIA GeForce RTX 2060 required to support ray tracing.', 39.99 ),
(9, 2, 2, 'Mega Man 11', 'https://cdn.cloudflare.steamstatic.com/steam/apps/742300/header.jpg?t=1669873876', 'Mega Man is back! The newest entry in this iconic series blends classic, challenging 2D platforming action with a fresh new visual style. The new Double Gear system boosts Mega Man''s speed and power for a new twist to the satisfying gameplay the series is known for.', 'https://www.youtube.com/watch?v=3aSC5A726f0', '2018-10-03', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: OS: Windows 7, 8, 8.1, 10 (64-bit required)
Processor: Intel Core i5-3470 3.20GHz or AMD equivalent or better
Memory: 4 GB RAM
Graphics: GeForce GTX 650
DirectX: Version 11
Network: Broadband Internet connection
Sound Card: DirectSound (DirectX 9.0c or better)
Additional Notes: ・DirectX9.0c is also required ・Hardware specification target　Resolution: 1080P/60FPS　Display Mode: Windows Mode　Anti-aliasing: OFF', 29.99 ),
(10, 2, 2, 'Monster Hunter: World', 'https://cdn.cloudflare.steamstatic.com/steam/apps/582010/header.jpg?t=1661838392', 'Welcome to a new world! In Monster Hunter: World, the latest installment in the series, you can enjoy the ultimate hunting experience, using everything at your disposal to hunt monsters in a new world teeming with surprises and excitement.', 'https://www.youtube.com/watch?v=-0l0B7NDTAU', '2018-08-09', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: WINDOWS® 7, 8, 8.1, 10 (64-bit required)
Processor: Intel® Core™ i5 4460 or Core™ i3 9100F or AMD FX™-6300 or Ryzen™ 3 3200G
Memory: 8 GB RAM
Graphics: NVIDIA®GeForce®GTX 760 or GTX1050 or AMD Radeon™ R7 260x or RX 560
DirectX: Version 11
Network: Broadband Internet connection
Storage: 52 GB available space
Sound Card: DirectSound (DirectX® 9.0c or later)
Additional Notes: - These specs allow for the game to be played in 1080p/30fps with graphics settings at "Low". - 64-bit processor and operating system are required.', 39.99 ),
(11, 2, 2, 'Dead Rising 4', 'https://cdn.cloudflare.steamstatic.com/steam/apps/543460/header.jpg?t=1644282464', 'Dead Rising 4 marks the return of photojournalist Frank West in an all-new chapter of one of the most popular zombie game franchises of all time.', 'https://www.youtube.com/watch?v=GT3cb3f5pM0', '2017-03-04', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7 64-bit
Processor: Intel i5-2400 or AMD FX 6300
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 760 (2 GB) or AMD Radeon HD 7850 (2 GB)
DirectX: Version 11
Network: Broadband Internet connection
Storage: 50 GB available space
Sound Card: DX11-compatible sound card
Additional Notes: Not compatible with AMD CPUs that do not support SSE 4.1 multi-threading.', 19.99 ),
(12, 2, 2, 'Ultra Street Fighter® IV', 'https://cdn.cloudflare.steamstatic.com/steam/apps/45760/header.jpg?t=1644283495', 'The world’s greatest fighting game evolves to a whole new level with Ultra Street Fighter IV.', 'https://www.youtube.com/watch?v=d__QncYv3VU', '2014-08-07', 'MINIMUM
OS: Windows Vista
Processor: Intel Core 2 Duo 2.0 GHz or better
Memory: 1 GB RAM
Hard Disk Space: 12 GB free hard drive space
Video Card: NVIDIA GeForce 6600 or better (except NVIDIA GeForce 7300)
DirectX®: 9.0c or greater
Sound: DirectSound, DirectX9.0c Compatible Audio', 9.99 ),
(13, 3, 3, 'Watch_Dogs® 2', 'https://cdn.cloudflare.steamstatic.com/steam/apps/447040/header.jpg?t=1680017909', 'Welcome to San Francisco. Play as Marcus, a brilliant young hacker, and join the most notorious hacker group, DedSec. Your objective: execute the biggest hack of history.', 'https://www.youtube.com/watch?v=2GIVVsTKTLg', '2016-11-28', 'MINIMUM:
OS: Originally released for Windows 7, the game can be played on Windows 10 and Windows 11 OS
Processor: Intel Core i5 2400s @ 2.5 GHz, AMD FX 6120 @ 3.5 GHz or better
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 660 with 2 GB VRAM or AMD Radeon HD 7870, with 2 GB VRAM or better - See supported List*
Network: Broadband Internet connection
Storage: 27 GB available space
Sound Card: DirectX compatible using the latest drivers
Additional Notes: Minimum specs above for 720p , 30+ FPS, Low graphic settings // Periphericals: Microsoft Xbox One Controller, DUALSHOCK® 4 Controller, Windows-compatible keyboard, mouse, optional controller / Multiplayer: 256 kbps or faster broadband connection / Note: This product supports 64-bit operating systems only. Laptop versions of these cards may work, but are not officially supported. For the most up-to-date requirement listings, please visit the FAQ on our support website at support.ubi.com. High speed internet access and a valid Ubisoft account are required to activate the game after installation, to authenticate your system and continue gameplay after any re-activation, access online features, play online or unlock exclusive content. Game contains EasyAntiCheat (https://www.easyanticheat.net/) anti-cheat technology and Denuvo (https://www.denuvo.com/) anti-tamper technology.', 39.99 ),
(14, 3, 3, 'Assassin''s Creed Valhalla', 'https://cdn.cloudflare.steamstatic.com/steam/apps/2208920/header.jpg?t=1671135934', 'Become a legendary Viking on a quest for glory. Raid your enemies, grow your settlement, and build your political power.', 'https://www.youtube.com/watch?v=rKjUAWlbTJk', '2022-12-07', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 (versions 64 bits uniquement)
Processor: AMD Ryzen 3 1200 3.1 GHz / Intel Core i5-4460 3.2 GHz
Memory: 8 GB RAM
Graphics: AMD R9 380 /NVIDIA GeForce GTX 960
DirectX: Version 12
Storage: 160 GB available space', 19.99 ),
(15, 3, 3, 'Tom Clancy''s Rainbow Six® Siege', 'https://cdn.cloudflare.steamstatic.com/steam/apps/359550/header.jpg?t=1680010421', 'Tom Clancy''s Rainbow Six® Siege is an elite, tactical team-based shooter where superior planning and execution triumph.', 'https://www.youtube.com/watch?v=6wlvYh0h63k', '2015-12-02', 'MINIMUM:
OS: Originally released for Windows 7, the game can be played on Windows 10 and Windows 11 OS
Processor: Intel Core i3 560 @ 3.3 GHz or AMD Phenom II X4 945 @ 3.0 GHz
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 460 or AMD Radeon HD 5870 (DirectX-11 compliant with 1GB of VRAM)
Network: Broadband Internet connection
Storage: 61 GB available space
Sound Card: DirectX® 9.0c compatible sound card with latest drivers
Additional Notes: SUPPORTED VIDEO CARDS AT TIME OF RELEASE: GeForce GTX 460 or better, GTX 560 or better, GTX 650 or better, GTX 750 or better, or any card from the GT900 and Titan Series, Radeon HD5870 or better, HD6870 or better, HD7770 or better, R7 260X or better, or any card from the R-300 series and Fury X. Laptop models of these cards may work but are not supported. These chipsets are the only ones that will run this game. Additional chipsets may be supported after release. For an up-to-date list of supported chipsets, please visit the FAQ for this game on our support website: http://support.ubi.com. Game contains FairFight (https://www.gameblocks.com/products) and BattleEye (https://www.battleye.com/) anti-cheat technology.', 15.99 ),
(16, 3, 3, 'Far Cry® 5', 'https://cdn.cloudflare.steamstatic.com/steam/apps/552520/header.jpg?t=1681229356', 'Discover the open world of Hope County, Montana, besieged by a fanatical doomsday cult. Dive into the action solo or two-player co-op in the story campaign, use a vast arsenal of weapons and allies, and free Hope County from Joseph Seed and his cult.', 'https://www.youtube.com/watch?v=Kdaoe4hbMso','2018-03-27', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 8.1, Windows 10 (64-bit versions only)
Processor: Intel Core i5-2400 @ 3.1 GHz or AMD FX-6300 @ 3.5 GHz or equivalent
Memory: 8 GB RAM
Graphics: NVIDIA GeForce GTX 670 or AMD R9 270 (2GB VRAM with Shader Model 5.0 or better)
DirectX: Version 9.0c
Network: Broadband Internet connection
Storage: 40 GB available space
Additional Notes: Game contains EasyAntiCheat (https://www.easyanticheat.net/) anti-cheat technology, and Denuvo (https://www.denuvo.com/) and VMProtect (http://vmpsoft.com/support/user-manual/introduction/what-is-vmprotect/) anti-tamper technology.', 49.99 ),
(17, 4, 4, 'EA SPORTS™ FIFA 23', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1811260/header.jpg?t=1679504733', 'FIFA 23 brings The World’s Game to the pitch, with HyperMotion2 Technology, men’s and women’s FIFA World Cup™coming during the season, women’s club teams, cross-play features*, and more.', 'https://www.youtube.com/watch?v=o3V-GvvzjE4', '2022-09-29', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bit
Processor: Intel Core i5 6600k or AMD Ryzen 5 1600
Memory: 8 GB RAM
Graphics: NVIDIA GeForce GTX 1050 Ti or AMD Radeon RX 570
DirectX: Version 12
Network: Broadband Internet connection
Storage: 100 GB available space', 49.99 ),
(18, 4, 4, 'Dead Space', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1693980/header.jpg?t=1678446810', 'The sci-fi survival-horror classic returns, completely rebuilt to offer an even more immersive experience — including visual, audio, and gameplay improvements — while staying faithful to the original game’s thrilling vision.', 'https://www.youtube.com/watch?v=cTDJNZ9cK1w', '2023-01-27', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Window 10 64-bit +
Processor: Ryzen 5 2600x, Core i5 8600
Memory: 16 GB RAM
Graphics: AMD RX 5700, GTX 1070
DirectX: Version 12
Network: Broadband Internet connection
Storage: 50 GB available space
Additional Notes: 50GB SATA SSD', 39.99 ),
(19, 17, 4, 'Mass Effect™ Legendary Edition', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1328670/header.jpg?t=1669773470', 'The Mass Effect™ Legendary Edition includes single-player base content and over 40 DLC from the highly acclaimed Mass Effect, Mass Effect 2, and Mass Effect 3 games, including promo weapons, armors, and packs — remastered and optimized for 4K Ultra HD.', 'https://www.youtube.com/watch?v=n8i53TtQ6IQ', '2021-05-14', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: 64-bit Windows 10
Processor: Intel Core i5 3570 or AMD FX-8350
Memory: 8 GB RAM
Graphics: GPU: NVIDIA GTX 760, AMD Radeon 7970 / R9280X GPU RAM: 2 GB Video Memory
DirectX: Version 11
Storage: 120 GB available space', 49.99 ),
(20, 18, 4, 'Titanfall® 2', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1237970/header.jpg?t=1668565264', 'Respawn Entertainment gives you the most advanced titan technology in its new, single player campaign & multiplayer experience. Combine & conquer with new titans & pilots, deadlier weapons, & customization and progression systems that help you and your titan flow as one unstoppable killing force.', 'https://www.youtube.com/watch?v=VqeMjHmL9eg', '2016-10-28', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Win 7/8/8.1/10 64bit
Processor: Intel Core i3-6300t or equivalent [4 or more hardware threads]
Memory: 8 GB RAM
Graphics: NVIDIA Geforce GTX 660 2GB or AMD Radeon HD 7850 2GB
DirectX: Version 11
Storage: 45 GB available space', 34.99 ),
(21, 5, 5, 'Wo Long: Fallen Dynasty', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1448440/header.jpg?t=1681876809', 'A new dark fantasy Three Kingdoms action RPG from Team NINJA, the developers of Nioh.', 'https://www.youtube.com/watch?v=SWRcZN4jMW8', '2023-03-03', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows® 10, Windows® 11, 64bit
Processor: Intel® Core™ i5-8400、AMD Ryzen™ 5 3400G
Memory: 8 GB RAM
Graphics: GeForce GTX 1650 4GB、Radeon RX 570 4GB
DirectX: Version 12
Network: Broadband Internet connection
Storage: 60 GB available space
Sound Card: 16 bit stereo, 48kHz WAVE file can be played
Additional Notes: HDD、720P、30FPS', 49.99 ),
(22, 5, 5, 'DYNASTY WARRIORS 9', 'https://cdn.cloudflare.steamstatic.com/steam/apps/730310/header.jpg?t=1673510123', 'Experience the thrill of one versus thousands in an all new open world setting with DYNASTY WARRIORS 9! Travel through Ancient China depicted on a single, vast, open-world map, master the new State Combo System, and watch the Three Kingdoms story unfold through a cast of 90 playable characters!', 'https://www.youtube.com/watch?v=y_0IznfyIT4', '2018-02-13', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64bit
Processor: Core i5 2400 or over
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 660 or over
DirectX: Version 11
Network: Broadband Internet connection
Storage: 50 GB available space
Sound Card: 16 bit stereo, 48KHz WAVE file can be played', 14.99 ),
(23, 5, 5, 'DEAD OR ALIVE Xtreme Venus Vacation', 'https://cdn.cloudflare.steamstatic.com/steam/apps/958260/header.jpg?t=1680773796', 'In Koei Tecmo Games'' DEAD OR ALIVE Xtreme Venus Vacation, players support the girls from the DEAD OR ALIVE series as they compete with each other in the Venus Festival - a festival of beauty and strength.', 'https://www.youtube.com/watch?v=RhK2zpSz4pQ', '2019-03-26', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows® 10 64bit
Processor: *With video card: Intel Celeron E3400 *Without video card: Intel Core i3-3220
Memory: 2 GB RAM
Graphics: *With video card: NVIDIA GeForce GT 630 2GB *Without video card: on board GPU (Intel Graphics 2500)
DirectX: Version 11
Network: Broadband Internet connection
Storage: 10 GB available space
Sound Card: DirectX 9.0c over', 0.00 ),
(24, 5, 5, 'DEAD OR ALIVE 6', 'https://cdn.cloudflare.steamstatic.com/steam/apps/838380/header.jpg?t=1659084195', 'DEAD OR ALIVE 6 is fast-paced 3D fighting game, produced by Koei Tecmo Games, featuring stunning graphics and multi-tiered stages that create a truly entertaining competitive experience.', 'https://www.youtube.com/watch?v=ecYRKkc6GGI', '2019-03-01', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 （64bit）
Processor: Intel Core i5-4690 or over
Memory: 8 GB RAM
Graphics: NVIDIA GeForce GTX 770
DirectX: Version 11
Network: Broadband Internet connection
Storage: 50 GB available space
Sound Card: DirectX 11 or over', 19.99 ),
(25, 6, 6, 'The Witcher® 3: Wild Hunt', 'https://cdn.cloudflare.steamstatic.com/steam/apps/292030/header.jpg?t=1675178392', 'You are Geralt of Rivia, mercenary monster slayer. Before you stands a war-torn, monster-infested continent you can explore at will. Your current contract? Tracking down Ciri — the Child of Prophecy, a living weapon that can alter the shape of the world.', 'https://www.youtube.com/watch?v=1-l29HlKkXU', '2015-05-18', 'MINIMUM:
OS: 64-bit Windows 7, 64-bit Windows 8 (8.1)
Processor: Intel CPU Core i5-2500K 3.3GHz / AMD A10-5800K APU (3.8GHz)
Memory: 6 GB RAM
Graphics: Nvidia GPU GeForce GTX 660 / AMD GPU Radeon HD 7870
DirectX: Version 11
Storage: 50 GB available space', 5.99 ),
(26, 6, 6, 'Cyberpunk 2077', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1091500/header.jpg?t=1680026109', 'Cyberpunk 2077 is an open-world, action-adventure RPG set in the dark future of Night City — a dangerous megalopolis obsessed with power, glamor, and ceaseless body modification.', 'https://www.youtube.com/watch?v=qIcTM8WXFjk', '2020-12-10', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10
Processor: Intel Core i5-3570K or AMD FX-8310
Memory: 8 GB RAM
Graphics: NVIDIA GeForce GTX 970 or AMD Radeon RX 470
DirectX: Version 12
Storage: 70 GB available space
Additional Notes: In this game you will encounter a variety of visual effects that may provide seizures or loss of consciousness in a minority of people. If you or someone you know experiences any of the above symptoms while playing, stop and seek medical attention immediately.', 19.99 ),
(27, 6, 6, 'GWENT: The Witcher Card Game', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1284410/header.jpg?t=1659615342', 'Command mighty Witcher-world heroes in epic online PvP card battles!', 'https://www.youtube.com/watch?v=5yu7FVZOyAo', '2020-05-19', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: 7/8/8.1/10 (64 bit)
Processor: Intel Celeron G1820 | AMD A4-7300
Memory: 4 GB RAM
Graphics: NVIDIA GeForce GT 730 | Radeon R7 240', 0.00 ),
(28, 7, 7, 'Grand Theft Auto V', 'https://cdn.cloudflare.steamstatic.com/steam/apps/271590/header.jpg?t=1678296348', 'Grand Theft Auto V for PC offers players the option to explore the award-winning world of Los Santos and Blaine County in resolutions of up to 4k and beyond, as well as the chance to experience the game running at 60 frames per second.', 'https://www.youtube.com/watch?v=3DBrG2YjqQA', '2015-04-14', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1
Processor: Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz
Memory: 4 GB RAM
Graphics: NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)
Storage: 72 GB available space
Sound Card: 100% DirectX 10 compatible', 11.99 ),
(29, 7, 7, 'Red Dead Redemption 2', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1174180/header.jpg?t=1671485009', 'Winner of over 175 Game of the Year Awards and recipient of over 250 perfect scores, RDR2 is the epic tale of outlaw Arthur Morgan and the infamous Van der Linde gang, on the run across America at the dawn of the modern age.', 'https://www.youtube.com/watch?v=SXvQ1nK4oxk', '2019-12-06', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 - April 2018 Update (v1803)
Processor: Intel® Core™ i7-4770K / AMD Ryzen 5 1500X
Memory: 12 GB RAM
Graphics: Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB
Network: Broadband Internet connection
Storage: 150 GB available space
Sound Card: Direct X Compatible', 49.99 ),
(30, 7, 7, 'Max Payne 3','https://cdn.cloudflare.steamstatic.com/steam/apps/204100/header.jpg?t=1619108680', 'No longer a New York City cop, Max Payne moves to São Paulo to protect a wealthy family in an effort to finally escape his troubled past.', 'https://www.youtube.com/watch?v=q6a8t3zL70A', '2012-06-01', 'OS: Windows 7 64-Bit Service Pack 1
Processor: Intel Dual Core 2.4 GHZ - i7 3930K 6 Core x 3.06 GHZ / AMD Dual Core 2.6 GHZ - FX-8150 8 Core x 3.6 GHZ
Memory: 2GB - 16GB RAM
Hard Drive: 35GB of free HDD Space
Graphics: NVIDIA® 8600 GT 512MB VRAM – NVIDIA® GeForce® GTX 680 2GB VRAM / Radeon HD 3400 512MB VRAM - Radeon HD 7970 3GB VRAM
Sound Card: 100% Direct X 9.0 compatible – Direct X 9.0 compatible supporting Dolby Digital Live', 12.99 ),
(31, 8, 8, 'SOULCALIBUR VI', 'https://cdn.cloudflare.steamstatic.com/steam/apps/544750/header.jpg?t=1646956219', 'Bring more than your fists to the fight! Featuring all-new battle mechanics and characters, SOULCALIBUR VI marks a new era of the historic franchise. Welcome back to the stage of history!', 'https://www.youtube.com/watch?v=kOq5dVigDGU', '2018-10-19', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7, 8.1, 10 (64-bit)
Processor: Intel Core i3-4160 @ 3.60GHz or equivalent
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 1050
DirectX: Version 11
Storage: 20 GB available space
Sound Card: DirectX compatible soundcard or onboard chipset', 49.99 ),
(32, 8, 8, 'TEKKEN 7', 'https://cdn.cloudflare.steamstatic.com/steam/apps/389730/header.jpg?t=1676876387', 'Discover the epic conclusion of the long-time clan warfare between members of the Mishima family. Powered by Unreal Engine 4, the legendary fighting game franchise fights back with stunning story-driven cinematic battles and intense duels that can be enjoyed with friends and rivals.', 'https://www.youtube.com/watch?v=1V-_q3SKh5w', '2017-06-02', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7/8/10 (64-bit OS required)
Processor: Intel Core i3-4160 @ 3.60GHz or equivalent
Memory: 6 GB RAM
Graphics: NVIDIA GeForce GTX 660 2GB, GTX 750Ti 2GB, or equivalent
DirectX: Version 11
Network: Broadband Internet connection
Storage: 60 GB available space
Sound Card: DirectX compatible soundcard or onboard chipset', 34.99 ),
(33, 8, 8, 'ONE PIECE ODYSSEY', 'https://cdn.cloudflare.steamstatic.com/steam/apps/814000/header.jpg?t=1681424388', 'A brand new RPG set in the world of the popular anime, ONE PIECE! Play as members of the Straw Hat Crew in a fantastic adventure set in the ONE PIECE world!', 'https://www.youtube.com/watch?v=4LsSM7xlfCg', '2023-01-13', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 64-bit
Processor: Intel Core i5-6600 or AMD Ryzen 5 2400G
Memory: 8 GB RAM
Graphics: GeForce GTX 780 or Radeon R9 290X
DirectX: Version 11
Storage: 35 GB available space
Additional Notes: Estimated performance: 1080p/60fps with graphics settings at "Low". Framerate might drop in graphics-intensive scenes. - 64-bit processor and operating system are required.', 29.99 ),
(34, 8, 8, 'SCARLET NEXUS', 'https://cdn.cloudflare.steamstatic.com/steam/apps/775500/header.jpg?t=1680224698', 'Choose between Yuito and Kasane, elite psionics each armed with a talent in psychokinesis and their own reason to fight. Complete both of their stories to unlock all the mysteries of a Brain Punk future caught between technology and psychic abilities.', 'https://www.youtube.com/watch?v=k1kI09X8L9Y', '2021-06-25', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10
Processor: Intel Core i5-3470 | AMD FX-8350
Memory: 6 GB RAM
Graphics: Nvidia GeForce GTX 760, 2 GB | AMD Radeon HD 7970, 3 GB
DirectX: Version 11
Storage: 50 GB available space
Additional Notes: Estimated performance: 1080p/60fps with graphics settings at "Low". Framerate might drop in graphics-intensive scenes. - 64-bit processor and operating system are required.', 39.99  ),
(35, 9, 9, 'Detroit: Become Human', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1222140/header.jpg?t=1667468479', 'Detroit: Become Human puts the destiny of both mankind and androids in your hands, taking you to a near future where machines have become more intelligent than humans. Every choice you make affects the outcome of the game, with one of the most intricately branching narratives ever created.', 'https://www.youtube.com/watch?v=EtF_iOZokiQ', '2020-06-18', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 (64 bit)
Processor: Intel Core i5-2300 @ 2.8 GHz or AMD Ryzen 3 1200 @ 3.1GHz or AMD FX-8350 @ 4.2GHz
Memory: 8 GB RAM
Graphics: Nvidia GeForce GTX 780 or AMD HD 7950 with 3GB VRAM minimum (Support of Vulkan 1.1 required)
Storage: 55 GB available space',14.99 ),
(36, 9, 9, 'Beyond: Two Souls', 'https://cdn.cloudflare.steamstatic.com/steam/apps/960990/header.jpg?t=1667468566', 'A unique psychological action thriller delivered by A-list Hollywood performances by Elliot Page and Willem Dafoe, Beyond: Two Souls takes you on a thrilling journey across the globe as you play out the remarkable life of Jodie Holmes.', 'https://www.youtube.com/watch?v=uYxM0ULt2Js', '2020-06-18', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7 or later (64 bit)
Processor: Intel Core i5-4430 @ 3.0 GHz or AMD FX-6300 @ 3.5 GHz
Memory: 4 GB RAM
Graphics: Nvidia GeForce GTX 660 with 2GB VRAM or AMD Radeon HD 7870 with 2GB VRAM
DirectX: Version 11
Storage: 49 GB available space
Additional Notes: 720p, 30 FPS', 12.99 ),
(37, 9, 9, 'Heavy Rain', 'https://cdn.cloudflare.steamstatic.com/steam/apps/960910/header.jpg?t=1675271942', 'Experience a gripping psychological thriller filled with innumerable twists and turns. The hunt is on for a murderer known only as the Origami Killer. Four characters, each following their own leads, must take part in a desperate attempt to prevent the killer from claiming a new victim.', 'https://www.youtube.com/watch?v=e4NvqmZ_SiE', '2020-06-18', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7 or later (64 bit)
Processor: Intel Core i5-4430 @ 3.0 GHz or AMD FX-6300 @ 3.5 GHz
Memory: 4 GB RAM
Graphics: Nvidia GeForce GTX 660 with 2GB VRAM or AMD Radeon HD 7870 with 2GB VRAM
DirectX: Version 11
Storage: 35 GB available space
Additional Notes: 720p, 30 FPS', 12.99 ),
(38, 10, 10, 'VALKYRIE ELYSIUM', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1963210/header.jpg?t=1680172058', 'Long ago, Ragnarok—the End Times—loomed upon the realms. The All-Father Odin, with the last of his strength, created an emissary of redemption, Valkyrie; her sole task being the salvation of a doomed world.', 'https://www.youtube.com/watch?v=lJReDSNL4vc', '2022-11-11', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows® 10 / Windows® 11 64-bit
Processor: AMD Ryzen™ 3 1200 / Intel® Core™ i5-3330
Memory: 8 GB RAM
Graphics: AMD Radeon™ RX 560 / NVIDIA® GeForce® GTX 960
DirectX: Version 12
Storage: 25 GB available space
Additional Notes: 1280x720, Preset "Low", 30 FPS, VRAM 4GB required', 59.99 ),
(39, 10, 10, 'FINAL FANTASY VII REMAKE INTERGRADE', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1462040/header.jpg?t=1663767129', 'Cloud Strife, an ex-SOLDIER operative, descends on the mako-powered city of Midgar. The world of the timeless classic FINAL FANTASY VII is reborn, using cutting-edge graphics technology, a new battle system and an additional adventure featuring Yuffie Kisaragi.', 'https://www.youtube.com/watch?v=M4t1OFONu10', '2022-06-17', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows® 10 64-bit (ver. 2004 or later)
Processor: AMD FX-8350 / Intel® Core™ i5-3330
Memory: 8 GB RAM
Graphics: AMD Radeon™ RX 480 / NVIDIA® GeForce® GTX 780 / 3GB VRAM required
DirectX: Version 12
Storage: 100 GB available space
Additional Notes: Assuming a Resolution of 1920 x 1080', 69.99),
(40, 10, 10, 'OCTOPATH TRAVELER II', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1971650/header.jpg?t=1679563605','This game is a brand-new entry in the OCTOPATH TRAVELER series, the first installment of which was initially released in 2018 and sold over 3 million copies worldwide.', 'https://www.youtube.com/watch?v=XMpWElRyoxg', '2023-02-24', 'MINIMUM:
OS: Windows® 10 / 11 64-bit
Processor: AMD Ryzen™ 3 1200 / Intel® Core™ i3-6100
Memory: 8 GB RAM
Graphics: AMD Radeon™ RX 460 / NVIDIA® GeForce® GTX 750
DirectX: Version 12
Storage: 10 GB available space
Additional Notes: 60 FPS @ 1280x720, Preset "Low", 2GB VRAM required', 59.99),
(41, 11, 11, 'DARK SOULS™ III', 'https://cdn.cloudflare.steamstatic.com/steam/apps/374320/header.jpg?t=1671097812', 'Dark Souls continues to push the boundaries with the latest, ambitious chapter in the critically-acclaimed and genre-defining series. Prepare yourself and Embrace The Darkness!', 'https://www.youtube.com/watch?v=cWBwFhUv1-8', '2016-04-12', 'MINIMUM:
OS: Windows 7 SP1 64bit, Windows 8.1 64bit Windows 10 64bit
Processor: Intel Core i3-2100 / AMD® FX-6300
Memory: 4 GB RAM
Graphics: NVIDIA® GeForce GTX 750 Ti / ATI Radeon HD 7950
DirectX: Version 11
Network: Broadband Internet connection
Storage: 25 GB available space
Sound Card: DirectX 11 sound device
Additional Notes: Internet connection required for online play and product activation', 49.99),
(42, 11, 11, 'ELDEN RING', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1245620/header.jpg?t=1674441703', 'THE NEW FANTASY ACTION RPG. Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between.', 'https://www.youtube.com/watch?v=AKXiKBnzpBQ', '2022-02-25', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10
Processor: INTEL CORE I5-8400 or AMD RYZEN 3 3300X
Memory: 12 GB RAM
Graphics: NVIDIA GEFORCE GTX 1060 3 GB or AMD RADEON RX 580 4 GB
DirectX: Version 12
Storage: 60 GB available space
Sound Card: Windows Compatible Audio Device', 39.99),
(43, 19, 12, 'Call of Duty®: Black Ops', 'https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/b64dc899-42c9-4857-9bc9-50aacdfeb971/d32q883-e0bea33d-d7cb-4ddc-b212-fb797f7e7fe5.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2I2NGRjODk5LTQyYzktNDg1Ny05YmM5LTUwYWFjZGZlYjk3MVwvZDMycTg4My1lMGJlYTMzZC1kN2NiLTRkZGMtYjIxMi1mYjc5N2Y3ZTdmZTUuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.uTuNTQAjNdXNqUSVcLBGzDxz4S0R2aqeHw-XQ21o-TY', 'The biggest first-person action series of all time and the follow-up to critically acclaimed Call of Duty®: Modern Warfare 2 returns with Call of Duty®: Black Ops.', 'https://www.youtube.com/watch?v=OPTOVQFRggI', '2010-11-09', 'OS: Windows® Vista / XP / 7
Processor: Intel® Core™2 Duo E6600 or AMD Phenom™ X3 8750 or better
Memory: 2GB
Graphics: Shader 3.0 or better 256MB NVIDIA® GeForce® 8600GT / ATI Radeon® X1950Pro or better
DirectX®: DirectX® 9.0c
Hard Drive: 12GB*
Sound: DirectX® 9.0c-compatible',42.99),
(44, 20, 12, 'Prototype™', 'https://cdn.cloudflare.steamstatic.com/steam/apps/10150/header.jpg?t=1655760765', 'You are the Prototype, Alex Mercer, a man without memory armed with amazing shape-shifting abilities, hunting your way to the heart of the conspiracy which created you; making those responsible pay. Fast & Deadly Shape-Shifting Combat: Reconfigure your body to the situation at hand.', 'https://www.youtube.com/watch?v=gQoMELyEYFQ', '2009-06-10', 'OS: Windows® XP (with Service Pack 3) or Windows Vista®
Processor: Intel® Core™2 Duo 2.6 GHz or AMD Athlon™ 64 X2 4000+ or better
Memory: Vista 2 GB RAM / XP 1 GB RAM
Graphics: All NVIDIA® GeForce® 7800 GT 256 MB and better chipsets. All ATI Radeon™ X1800 256 MB and better chipsets
DirectX®: Microsoft DirectX 9.0c
Hard Drive: 8GB of free hard drive space
Sound: DirectX® 9.0c compliant sound card',22.99),
(45, 21, 12, 'Call of Duty® 4: Modern Warfare® (2007)', 'https://cdn.cloudflare.steamstatic.com/steam/apps/7940/header.jpg?t=1678298739', 'The new action-thriller from the award-winning team at Infinity Ward, the creators of the Call of Duty® series, delivers the most intense and cinematic action experience ever.', 'https://www.youtube.com/watch?v=LhuIjNSg7Gg', '2007-11-12', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 7 64-Bit or later
Processor: Intel Core i3-3225 @ 3.30GHz or equivalent
Memory: 8 GB RAM
Graphics: NVIDIA GeForce GTX 660 2GB / AMD Radeon HD 7850 2GB
DirectX: Version 11
Network: Broadband Internet connection
Sound Card: DirectX 11 Compatible', 22.99),
(46, 2, 2, 'Resident Evil 4', 'https://cdn.cloudflare.steamstatic.com/steam/apps/2050650/header.jpg?t=1680840402', 'Survival is just the beginning. Six years have passed since the biological disaster in Raccoon City. Leon S. Kennedy, one of the survivors, tracks the president''s kidnapped daughter to a secluded European village, where there is something terribly wrong with the locals.', 'https://www.youtube.com/watch?v=j5Xv2lM9wes', '2023-04-23', 'MINIMUM:
Requires a 64-bit processor and operating system
OS: Windows 10 (64 bit)
Processor: AMD Ryzen 3 1200 / Intel Core i5-7500
Memory: 8 GB RAM
Graphics: AMD Radeon RX 560 with 4GB VRAM / NVIDIA GeForce GTX 1050 Ti with 4GB VRAM
DirectX: Version 12
Network: Broadband Internet connection
Additional Notes: Estimated performance (when set to Prioritize Performance): 1080p/45fps. ・Framerate might drop in graphics-intensive scenes. ・AMD Radeon RX 6700 XT or NVIDIA GeForce RTX 2060 required to support ray tracing.', 59.99);

create table genre(
	id int constraint genre_id_pk primary key not null,
	genre_name varchar
);

insert into genre(id, genre_name)
values(1, 'Action'),
(2, 'Role-Playing'),
(3, 'Strategy'),
(4, 'Adventure'),
(5, 'Simulation'),
(6, 'Sports & Racing'),
(7, 'Horror'),
(8, 'Adult');

create table sub_genre(
	id int constraint sub_genre_id_pk primary key not null,
	sub_genre_name varchar,
	genre_id int,
	constraint sub_genre_fk_genre_id foreign key (genre_id) references genre(id)
);

insert into sub_genre(id, sub_genre_name, genre_id)
values(1, 'Arcade & Rhythm', 1),
(2, 'Fighting & Martial Arts', 1),
(3, 'First-Person Shooter', 1),
(4, 'Hack & Slash', 1),
(5, 'Platformer & Runner', 1),
(6, 'Third-Person Shooter', 1),
(7, 'Action RPG', 2),
(8, 'Adventure RPG', 2),
(9, 'JRPG', 2),
(10, 'Party-Based', 2),
(11, 'Rogue-Like', 2),
(12, 'Strategy RPG', 2),
(13, 'Turn-Based', 2),
(14, 'Card & Board', 3),
(15, 'City & Settlement', 3),
(16, 'Grand & 4x', 3),
(17, 'Military', 3),
(18, 'Real-Time Strategy', 3),
(19, 'Tower Defense', 3),
(20, 'Turn-Based Strategy', 3),
(21, 'Adventure RPG', 4),
(22, 'Casual', 4),
(23, 'Hidden Object', 4),
(24, 'Metroidvania', 4),
(25, 'Puzzle', 4),
(26, 'Story-Rich', 4),
(27, 'Visual Novel', 4),
(28, 'Building & Automation', 5),
(29, 'Dating', 5),
(30, 'Farming & Crafting', 5),
(31, 'Hobby & Job', 5),
(32, 'Life & Immersive', 5),
(33, 'Sandbox & Physics', 5),
(34, 'Space & Flight', 5),
(35, 'All Sports', 6),
(36, 'Fishing & Hunting', 6),
(37, 'Individual Sports', 6),
(38, 'Racing', 6),
(39, 'Racing Sim', 6),
(40, 'Sports Sim', 6),
(41, 'Team Sports', 6),
(42, 'Survival Horror', 7),
(43, 'Hentai', 8),
(44, 'Sexual Content', 8),
(45, 'Nudity', 8),
(46, 'Language', 8);

create table game_genre(
	id int,
	game_id int,
	genre_id int,
	constraint game_genre_fk_game_id foreign key (game_id) references game(id),
	constraint game_genre_fk_genre_id foreign key (genre_id) references genre(id)
);

insert into game_genre(id, game_id, genre_id) 
values(1, 1, 1),
(2, 1, 4),
(3, 2, 1),
(4, 2, 4),
(5, 3, 2),
(6, 3, 4),
(7, 4, 1),
(8, 4, 4),
(9, 5, 1),
(10, 6, 1),
(11, 6, 4),
(12, 7, 1),
(13, 8, 7),
(14, 9, 1),
(15, 10, 1),
(16, 10, 2),
(17, 11, 1),
(18, 12, 1),
(19, 13, 1),
(20, 13, 4),
(21, 14, 1),
(22, 14, 2),
(23, 14, 4),
(24, 15, 1),
(25, 16, 1),
(26, 17, 6),
(27, 18, 1),
(28, 18, 7),
(29, 19, 1),
(30, 19, 2),
(31, 19, 4),
(32, 20, 1),
(33, 21, 1),
(34, 21, 2),
(35, 22, 1),
(36, 23, 8),
(37, 24, 1),
(38, 25, 1),
(39, 25, 2),
(40, 25, 4),
(41, 25, 8),
(42, 26, 1),
(43, 26, 4),
(44, 27, 2),
(45, 27, 3),
(46, 28, 1),
(47, 28, 8),
(48, 29, 1),
(49, 29, 4),
(50, 29, 8),
(51, 30, 1),
(52, 31, 1),
(53, 32, 1),
(54, 33, 1),
(55, 34, 1),
(56, 34, 4),
(57, 35, 5),
(58, 35, 8),
(59, 36, 5),
(60, 36, 8),
(61, 37, 5),
(62, 37, 8),
(63, 38, 1),
(64, 38, 2),
(65, 38, 4),
(67, 39, 1),
(68, 40, 4),
(69, 41, 1),
(70, 41, 2),
(71, 41, 4),
(72, 42, 1),
(73, 42, 2),
(74, 42, 4),
(75, 43, 1),
(76, 44, 1),
(77, 44, 8),
(78, 45, 1),
(79, 46, 1),
(80, 46, 4),
(81, 46, 7);

create table game_sub_genre(
	id int,
	game_id int,
	sub_genre_id int,
	constraint game_genre_fk_game_id foreign key (game_id) references game(id),
	constraint game_genre_fk_sub_genre_id foreign key (sub_genre_id) references sub_genre(id)
);

insert into game_sub_genre(id, game_id, sub_genre_id) 
values(1, 1, 26),
(2, 2, 26),
(3, 4, 26),
(4, 7, 4),
(5, 8, 42),
(6, 9, 5),
(7, 12, 1),
(8, 13, 6),
(9, 14, 7),
(10, 14, 8),
(11, 15, 3),
(12, 15, 17),
(13, 16, 3),
(14, 18, 6),
(15, 18, 42),
(16, 19, 6),
(17, 19, 7),
(18, 19, 8),
(19, 19, 26),
(20, 20, 3),
(21, 21, 7),
(22, 22, 4),
(23, 23, 43),
(24, 23, 44),
(25, 24, 2),
(26, 25, 7),
(27, 25, 8),
(28, 25, 26),
(29, 25, 44),
(30, 25, 45),
(31, 26, 3),
(32, 26, 7),
(33, 26, 8),
(34, 26, 26),
(35, 27, 14),
(36, 28, 26),
(37, 28, 45),
(38, 28, 46),
(39, 29, 6),
(40, 29, 7),
(41, 29, 26),
(42, 30, 6),
(43, 31, 1),
(44, 31, 2),
(45, 32, 1),
(46, 32, 2),
(47, 33, 2),
(48, 33, 7),
(49, 34, 7),
(50, 34, 8),
(51, 35, 26),
(52, 35, 32),
(53, 35, 46),
(54, 36, 26),
(55, 36, 32),
(56, 36, 46),
(57, 37, 26),
(58, 37, 32),
(59, 37, 46),
(60, 38, 7),
(61, 38, 8),
(62, 38, 9),
(63, 39, 7),
(64, 40, 8),
(65, 40, 9),
(66, 40, 26),
(67, 41, 7),
(68, 41, 8),
(69, 42, 7),
(70, 42, 8),
(71, 43, 3),
(72, 44, 4),
(73, 44, 46),
(74, 45, 3),
(75, 46, 6);

create table game_comment(
	id int constraint game_comment_id_pk primary key not null,
	user_id int,
	game_id int,
	comment_content varchar,
	comment_date date,
	constraint game_comment_fk_user_id foreign key(user_id) references user_info(id),
	constraint game_comment_fk_game_id foreign key(game_id) references game(id)
);

insert into game_comment(id, user_id, game_id, comment_content, comment_date)
values(1, 1, 1, 'Game is good.', '2023-04-22'),
(2, 1, 2, 'Game is great', '2023-03-26'),
(3, 1, 3, 'Game is awesome!', '2023-02-27'),
(4, 2, 4, 'Game sucks!', '2023-03-17'),
(5, 1, 21, 'What a Dark Souls rip-off!', '2023-01-10'),
(6, 2, 10, 'Game is hard!', '2023-01-01'),
(7, 2, 14, 'Assassin''s Creed has lost its way', '2023-01-29'),
(8, 2, 3, 'Good port from the PS4.', '2023-03-15'),
(9, 2, 41, 'PRAISE THE SUN!', '2023-02-09'),
(10, 3, 23, 'I play this game for the plot.', '2023-04-04'),
(11, 3, 20, 'The last great game from EA.', '2023-02-27'),
(12, 3, 9, 'What is this, 2D Dark Souls??!', '2023-02-15'),
(13, 3, 26, 'John Wick if he had a cyber arm.', '2023-05-01'),
(14, 4, 28, 'Look ma I''m robbing a bank!', '2023-01-07'),
(15, 4, 1, 'The best focking game I''ve ever played!', '2023-04-14'),
(16, 4, 5, 'Why does this guy look like every Spider-Man actor combine?', '2023-01-02'),
(17, 4, 3, 'I got to fight giant mechanical dinosaurs, 10/10.', '2023-03-10'),
(18, 5, 4, 'The worst port Naughty Dog has ever made!', '2023-05-09'),
(19, 5, 2, 'BOIIIIIIIIIIIIIIIIIIIIIIII', '2023-01-28'),
(20, 5, 39, 'I bought this just to see Aerith got donut in 4k.', '2023-04-16'),
(21, 5, 7, 'I FEEL MOTIVATED', '2023-01-13'),
(22, 5, 46, 'LEON YOU MUST CONTINUE THE REDFIELD BLOODLINE!', '2023-03-06'),
(23, 6, 8, 'CHOKE ME HARDER MAMA DIMITRESCU!', '2023-04-21'),
(24, 6, 11, 'Barb wire baseball bat go brrrrrr', '2023-01-18'),
(25, 6, 33, 'GOMU GOMU NO EAT SH*T **********', '2023-04-13'),
(26, 6, 29, 'I came here to play video game, not to feel depressed wtf Rockstar??!', '2023-03-03'),
(27, 7, 3, 'Aloy''s dad literally went out to buy milk and never came back.', '2023-01-01'),
(28, 7, 21, 'PARRY THIS YOU F**KING CASUAL!', '2023-01-07'),
(29, 7, 13, 'Buy the game expecting to watch dogs. No dog in the game, 0/10.', '2023-01-05'),
(30, 7, 22, 'Dong Zhou literally got NTR by his adopted son.', '2023-02-22'),
(31, 7, 32, 'I smash random buttons with Eddy Gordo and win. Definitely would Eddy Gordo again.', '2023-05-22'),
(32, 8, 25, 'TEAM TRISS FTW!', '2023-03-06'),
(33, 8, 37, 'Who let the onion-cutting ninjas in??!', '2023-02-08'),
(34, 8, 27, 'There''s a kingdom need saving and here I am playing Gwent with Ciri.', '2023-01-24'),
(35, 8, 30, 'SLOW MO BULLETS GO BRRRRRRRRRRRR', '2023-04-16'),
(36, 9, 2, 'Dont be sorry, be better boi.', '2023-02-26'),
(37, 9, 1, 'Nathan please give me your seed.', '2023-03-27'),
(38, 9, 23, 'A Dead or Alive game without fighting, weird.', '2023-03-04'),
(39, 10, 35, 'ChatGPT if they went sentient.', '2023-03-30'),
(40, 10, 36, 'Ooooooo scary.', '2023-01-26'),
(41, 10, 16, 'Typically American dream.', '2023-05-06'),
(42, 11, 41, '^#$%#$%%$&%^*%^&%^&**!#$#', '2023-02-07'),
(43, 11, 31, 'Ivy can penetrate me with her sword anytime.', '2023-01-15'),
(44, 11, 40, 'Somehow a 2D game is better than all these 3D AAA games.', '2023-03-31'),
(45, 12, 14, 'How is a Viking also an assassin??!', '2023-01-15'),
(46, 12, 4, 'The last of us? More the like the last of my pc after it finishes compiling these textures.', '2023-01-05'),
(47, 12, 17, 'Stop feeding us the same game every year EA.', '2023-02-22'),
(48, 13, 34, 'Unexpected good game.', '2023-03-29'),
(49, 13, 39, 'Sephiroth looks like he can be my sugar daddy.', '2023-02-13'),
(50, 13, 25, 'TEAM YENNEFER!', '2023-05-05'),
(51, 14, 19, 'My name is commander Shepard, and this is my favorite store on the Citadel.', '2023-02-04'),
(52, 14, 18, 'Changing pants simulator.', '2023-03-24'),
(53, 14, 9, 'Easy game.', '2023-01-18'),
(54, 15, 46, 'Ashley is no longer useless.', '2023-04-30'),
(55, 15, 25, 'The jiggling physics in this game is weird.', '2023-03-13'),
(56, 15, 10, 'A gun in ancient history time? Count me in.', '2023-03-31'),
(57, 15, 30, 'Max no longer has hair, 0 hair/10.', '2023-02-25'),
(58, 16, 34, 'Like.', '2023-01-16'),
(59, 16, 6, 'No uncle Ben, no aunt May, just Miles being a chad.', '2023-04-10'),
(60, 16, 20, 'RESPAWN MAKE TITAN FALL 3 PLEASE!!!!!', '2023-02-13'),
(61, 16, 35, 'This game gave me anxiety, now I''m afraid im gonna make Alexa mad and at night she will choke me to death with a pillow.', '2023-03-11'),
(62, 17, 46, 'SUPLEX CITY', '2023-02-18'),
(63, 17, 8, 'If i got put into a castle with a THICC AF mama and her 3 vampire daughters, i wouldn''t complain.', '2023-03-11'),
(64, 17, 18, 'Isaac Clarke looks like Adam Sandler now and I''m not okay with it.', '2023-03-28'),
(65, 18, 22, 'Loudsy PC port, poor customization.', '2023-01-16'),
(66, 18, 36, 'I have to consult a therapist after finishing this game.', '2023-03-03'),
(67, 18, 7, 'Vergil best dad.', '2023-04-10'),
(68, 19, 26, 'BRING BACK JACKIE RIGHT NOW', '2023-04-24'),
(69, 19, 8, 'I must go to the gym at this very moment to look like Chris Redfield.', '2023-02-12'),
(70, 19, 38, 'Weeb game', '2023-02-25'),
(71, 20, 28, 'Trevor looks like my long lost father.', '2023-02-07'),
(72, 20, 9, 'Go back to 2D Mega Man please.', '2023-02-19'),
(73, 20, 45, 'Game nhái phi phai.', '2023-02-22'),
(74, 21, 44, 'Spider-Man on crack.', '2023-01-29'),
(75, 22, 17, 'Better than PES.', '2023-01-07'),
(76, 22, 29, 'PC gaming at its peak.', '2023-04-06'),
(77, 22, 42, 'If you kill the turtle pope you''re a terrible person.', '2023-05-01'),
(78, 22, 21, 'Why does the bad guy keep licking himself', '2023-03-03'),
(79, 23, 7, 'Why does Dante keep looking better the more he age', '2023-02-05'),
(80, 23, 31, 'Vordo is a creep.', '2023-01-14'),
(81, 23, 33, 'Zorro got lost again.', '2023-01-03'),
(82, 23, 15, 'No nuke, 0/10.', '2023-04-09'),
(83, 24, 1, 'Please don''t reboot the Uncharted series.', '2023-02-26'),
(84, 24, 4, 'Technical issues make this game completely unplayble.', '2023-01-26'),
(85, 24, 14, 'Hey at least we can cosplay Thor by wielding his hammer.', '2023-03-26'),
(86, 18, 13, 'HACKERMAN', '2023-01-21'),
(87, 19, 46, 'Press X to struggle.', '2023-02-10'),
(88, 21, 39, 'Cloud in a dress is my wet dream.', '2023-04-02'),
(89, 21, 16, 'How can a guy have too many nukes and the US government still lets him live??!', '2023-02-23');


create table rating(
	id int, 
	user_id int,
	game_id int,
	rating int,
	constraint rating_fk_user_id foreign key(user_id) references user_info(id),
	constraint rating_fk_game_id foreign key(game_id) references game(id)
);

insert into rating(id, user_id, game_id, rating)
values(1, 12,20,5),
(2, 7,39,2),
(3, 5,34,4),
(4, 2,10,3),
(5, 20,3,5),
(6, 5,3,3),
(7, 11,35,2),
(8, 8,28,5),
(9, 20,16,1),
(10, 17,5,1),
(11, 23,22,2),
(12, 11,16,3),
(13, 14,37,1),
(14, 9,12,4),
(15, 4,20,5),
(16, 2,36,3),
(17, 11,12,1),
(18, 7,16,3),
(19, 8,30,2),
(20, 14,35,4),
(21, 4,41,1),
(22, 15,6,5),
(23, 17,30,4),
(24, 14,28,2),
(25, 22,17,2),
(26, 24,23,1),
(27, 15,1,3),
(28, 5,17,4),
(29, 19,41,1),
(30, 15,30,4),
(31, 5,41,2),
(32, 15,32,5),
(33, 17,39,1),
(34, 6,2,5),
(35, 6,11,1),
(36, 12,22,4),
(37, 9,36,2),
(38, 11,41,5),
(39, 24,15,3),
(40, 12,12,4),
(41, 12,6,3),
(42, 5,30,4),
(43, 7,46,3),
(44, 9,10,4),
(45, 12,5,3),
(46, 1,42,5),
(47, 17,2,2),
(48, 2,22,1),
(49, 14,4,3),
(50, 2,43,2),
(51, 17,20,3),
(52, 11,1,4),
(53, 9,21,4),
(54, 23,8,4),
(55, 11,9,3),
(56, 19,10,2),
(57, 21,24,2),
(58, 14,11,1),
(59, 4,34,1),
(60, 15,40,1),
(61, 1,1,5),
(62, 14,41,1),
(63, 2,9,2),
(64, 11,40,2),
(65, 10,18,4),
(66, 10,26,3),
(67, 7,27,3),
(68, 7,35,2),
(69, 4,4,5),
(70, 16,41,1),
(71, 14,4,5),
(72, 14,32,3);

create table receipt(
	id int constraint receipt_id primary key not null,
	user_id int,
	receipt_date Date,
	constraint receipt_fk_user_id foreign key(user_id) references user_info(id)
);

insert into receipt(id, user_id, receipt_date)
values(1, 1, '2007-09-01'),
(2, 1, '2008-06-24'),
(3, 2, '2017-09-11'),
(4, 2, '2012-05-22'),
(5, 2, '2014-08-31'),
(6, 3, '2010-04-03'),
(7, 3, '2011-07-28'),
(8, 3, '2017-02-15'),
(9, 4, '2020-09-13'),
(10, 4, '2018-06-30'),
(11, 4, '2017-08-08'),
(12, 5, '2015-04-21'),
(13, 5, '2013-11-01'),
(14, 5, '2012-12-03'),
(15, 6, '2017-10-18'),
(16, 6, '2017-10-18'),
(17, 6, '2018-09-14'),
(18, 7, '2015-01-21'),
(19, 7, '2016-07-09'),
(20, 7, '2016-07-09'),
(21, 8, '2017-05-01'),
(22, 8, '2017-05-01'),
(23, 8, '2019-08-16'),
(24, 9, '2022-12-18'),
(25, 9, '2014-05-13'),
(26, 9, '2013-07-25'),
(27, 10, '2015-10-31'),
(28, 10, '2011-08-26'),
(29, 10, '2012-09-18'),
(30, 11, '2019-09-21'),
(31, 11, '2016-06-17'),
(32, 11, '2017-05-30'),
(33, 12, '2018-07-17'),
(34, 12, '2009-11-11'),
(35, 12, '2009-11-11'),
(36, 13, '2011-07-07'),
(37, 13, '2015-09-25'),
(38, 13, '2015-09-25'),
(39, 14, '2017-05-01'),
(40, 14, '2018-06-17'),
(41, 14, '2019-04-01'),
(42, 15, '2019-04-01'),
(43, 15, '2020-03-16'),
(44, 15, '2020-03-21'),
(45, 16, '2018-02-06'),
(46, 16, '2018-02-06'),
(47, 16, '2019-07-14'),
(48, 17, '2007-12-25'),
(49, 17, '2009-09-30'),
(50, 17, '2009-09-30'),
(51, 18, '2009-09-30'),
(52, 18, '2011-05-06'),
(53, 18, '2012-06-19'),
(54, 19, '2015-08-30'),
(55, 19, '2015-08-30'),
(56, 19, '2016-11-20'),
(57, 20, '2016-11-20'),
(58, 20, '2017-12-01'),
(59, 21, '2009-05-29'),
(60, 21, '2013-06-17'),
(61, 21, '2013-06-17'),
(62, 22, '2016-09-25'),
(63, 22, '2016-09-25'),
(64, 22, '2017-11-05'),
(65, 23, '2018-08-16'),
(66, 23, '2018-08-16'),
(67, 23, '2019-11-30'),
(68, 24, '2020-08-28'),
(69, 24, '2021-11-14'),
(70, 24, '2021-12-16'),
(71, 1, '2009-11-21'),
(72, 20, '2018-04-13');

create table receipt_details(
	id int,
	receipt_id int,
	game_id int,
	constraint receipt_details_fk_game_id foreign key(game_id) references game(id),
	constraint receipt_details_fk_receipt_id foreign key(receipt_id) references receipt(id),
);

insert into receipt_details(id, receipt_id, game_code_id)
values(1, 59,21),
(2, 12,19),
(3, 23,16),
(4, 54,22),
(5, 25,15),
(6, 50,3),
(7, 8,1),
(8, 68,11),
(9, 26,19),
(10, 52,6),
(11, 56,1),
(12, 57,2),
(13, 11,9),
(14, 15,19),
(15, 59,21),
(16, 36,7),
(17, 69,11),
(18, 14,20),
(19, 39,2),
(20, 6,17),
(21, 22,11),
(22, 68,22),
(23, 39,18),
(24, 55,24),
(25, 10,15),
(26, 47,13),
(27, 20,5),
(28, 14,8),
(29, 41,23),
(30, 37,10),
(31, 5,18),
(32, 56,6),
(33, 3,3),
(34, 34,14),
(35, 38,5),
(36, 61,23),
(37, 66,14),
(38, 40,22),
(39, 68,16),
(40, 60,13),
(41, 58,7),
(42, 26,23),
(43, 53,4),
(44, 19,3),
(45, 27,5),
(46, 9,8),
(47, 12,14),
(48, 34,14),
(49, 46,8),
(50, 34,4),
(51, 32,20),
(52, 15,4),
(53, 32,5),
(54, 65,15),
(55, 7,7),
(56, 35,22),
(57, 41,8),
(58, 41,22),
(59, 22,9),
(60, 53,15),
(61, 57,8),
(62, 14,1),
(63, 42,14),
(64, 53,12),
(65, 18,24),
(66, 57,2),
(67, 44,20),
(68, 64,19),
(69, 41,2),
(70, 5,5),
(71, 4,20),
(72, 62,6),
(73, 58,20),
(74, 60,16),
(75, 61,24),
(76, 34,7),
(77, 35,4),
(78, 20,10),
(79, 28,21),
(80, 66,3),
(81, 58,21),
(82, 56,5),
(83, 38,24),
(84, 36,9),
(85, 36,2),
(86, 30,13),
(87, 3,19),
(88, 14,10),
(89, 62,24),
(90, 24,16),
(91, 49,6),
(92, 7,16),
(93, 4,5),
(94, 46,21),
(95, 63,24),
(96, 3,16),
(97, 59,5),
(98, 13,7),
(99, 23,21),
(100, 63,10),
(101, 41,9);

insert into receipt_details(id, receipt_id, game_id)  
values(102, 70, 26);

select g.game_name, g2.image_link 
from game g join game_image g2 on g.id = g2.game_id;

insert into user_role_assignment(id, assigned_date, "role", modified_date, user_id)
values(1, '2023-03-13', 'ROLE_USER', null, 1),
(2, '2023-03-13', 'ROLE_USER', null, 2),
(3, '2023-03-13', 'ROLE_USER', null, 3),
(4, '2023-03-13', 'ROLE_USER', null, 4),
(5, '2023-03-13', 'ROLE_USER', null, 5),
(6, '2023-03-13', 'ROLE_USER', null, 6),
(7, '2023-03-13', 'ROLE_USER', null, 7),
(8, '2023-03-13', 'ROLE_USER', null, 8),
(9, '2023-03-13', 'ROLE_USER', null, 9),
(10, '2023-03-13', 'ROLE_USER', null, 10),
(11, '2023-03-13', 'ROLE_USER', null, 11),
(12, '2023-03-13', 'ROLE_USER', null, 12),
(13, '2023-03-13', 'ROLE_USER', null, 13),
(14, '2023-03-13', 'ROLE_USER', null, 14),
(15, '2023-03-13', 'ROLE_USER', null, 15),
(16, '2023-03-13', 'ROLE_USER', null, 16),
(17, '2023-03-13', 'ROLE_USER', null, 17),
(18, '2023-03-13', 'ROLE_USER', null, 18),
(19, '2023-03-13', 'ROLE_USER', null, 19),
(20, '2023-03-13', 'ROLE_USER', null, 20),
(21, '2023-03-13', 'ROLE_USER', null, 21),
(22, '2023-03-13', 'ROLE_USER', null, 22),
(23, '2023-03-13', 'ROLE_USER', null, 23),
(24, '2023-03-13', 'ROLE_USER', null, 24),
(25, '2023-03-13', 'ROLE_USER', null, 25),
(26, '2023-03-13', 'ROLE_ADMIN', null, 25);

select g
from game g join receipt_details rd on g.id = rd.game_id 
join receipt r on r.id = rd.receipt_id 
join user_info ui on ui.id = r.user_id 
where ui.id = 2;

select g
from game g join receipt_details rd on g.id = rd.game_id 
join receipt r on r.id = rd.receipt_id 
join user_info ui on ui.id = r.user_id 
where ui.username like '%orth%';

--Custom queries
--1/ List of games that have rating between x-y, releasedDate from A to B.
select g, max(r.rating) 
from game g join rating r on r.game_id = g.id 
group by g.id, r.rating 
having g.released_date between '2022-01-01' and '2023-01-01'
and r.rating between 3 and 4;

select tmp.game_id, tmp.rating, tmp.id, tmp.user_id from 
(select g.id as "game_id", g.game_name as "game_name", ui.id as "user_id" , max(r.rating) rating, r.id
from game g join rating r on r.game_id = g.id 
join user_info ui on ui.id = r.user_id 
group by g.id, r.rating, r.id, ui.id 
HAVING r.rating between 3 and 4
and g.released_date between '2022-01-01' and '2023-01-01') tmp
group by tmp.game_id, tmp.id, tmp.user_id;

--2/ Find games based on Developer, Publisher, Genre, SubGenre and Game name (LIKE).

--3/ Revenue from date A to date B.
select r.receipt_date, count(g.id) as "Game sold", sum(g.price) as "Revenue per day"
from game g join receipt_details rd ON g.id = rd.game_id 
join receipt r on r.id = rd.receipt_id
group by r.receipt_date
having r.receipt_date between '2020-01-01' and '2023-01-01';

--4/ List of top-seller Games from date A to date B
select "CopiesSold".id, "CopiesSold".game_name, count("CopiesSold"."Copies sold") as "Total sales"
from
(select g.id, g.game_name, count(rd.game_id) as "Copies sold" 
from game g join receipt_details rd on g.id = rd.game_id 
join receipt r on r.id = rd.receipt_id 
group by g.id, r.receipt_date  
having r.receipt_date between '2020-01-01' and '2023-01-01'
order by g.id) as "CopiesSold"
group by "CopiesSold".id, "CopiesSold".game_name
order by "Total sales" desc
limit 5;

select g.id, g.game_name, count(rd.game_id) as "Copies sold"
from game g join receipt_details rd on g.id = rd.game_id
group by g.id
order by g.id;

--5/ List of worst-seller Games from date A to date B
select "CopiesSold".id, "CopiesSold".game_name, count("CopiesSold"."Copies sold") as "Total sales"
from
(select g.id, g.game_name, count(rd.game_id) as "Copies sold" 
from game g join receipt_details rd on g.id = rd.game_id 
join receipt r on r.id = rd.receipt_id 
group by g.id, r.receipt_date  
having r.receipt_date between '2020-01-01' and '2023-01-01'
order by g.id) as "CopiesSold"
group by "CopiesSold".id, "CopiesSold".game_name
order by "Total sales" asc
limit 5;

--6/ List of registered user by month
select extract (month from ui.registered_date ) as "Month", count(ui.id) as "Number of registered users"
from user_info ui
group by "Month"
having extract (month from ui.registered_date ) = 4;