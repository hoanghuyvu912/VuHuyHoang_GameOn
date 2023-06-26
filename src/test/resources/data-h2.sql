INSERT INTO developer (cover_photo,description,established_date,developer_name,thumbnail) VALUES
	 ('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnDTkdA38Qi_7RLtj2283fRSJxLHxvX6FdZg&usqp=CAU',NULL,'1999-01-01','Santa Monica Studio','https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Santa_Monica_Studio.svg/220px-Santa_Monica_Studio.svg.png'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33273264/4256bc824357bb34aa4e2f7f11df9a62633d286f.png',NULL,'1979-05-30','Capcom','https://avatars.cloudflare.steamstatic.com/6b62a91eb5a093261d8831d1908717bab0d687e9_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33075774/6f635e1eeae42b293705087fc040e77116ed365a.png','Ubisoft is a creator of worlds, committed to enriching players'' lives with original and memorable gaming experiences.','1986-03-28','Ubisoft','https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg');

INSERT INTO user_info (active,address,balance,dob,email,first_name,gender,last_name,user_password,profile_img,registered_date,telephone_num,username) VALUES
	 (true,'2120 Washington Court',10000.00,'1985-06-15','bpocknoll6@typepad.com','Benton','Male','Pocknoll','dWR2YXZwNkg=','https://images.pexels.com/photos/1462980/pexels-photo-1462980.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','2002-10-30','520-164-6847','bentonpocknoll'),
	 (true,'6635 Buell Crossing',10000.00,'1931-07-26','fkirtland7@furl.net','Faunie','Female','Kirtland','dlVJQzQ0YXhIdQ==','https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','2004-02-19','627-957-7220','fauniekirtland'),
	 (true,'517 Pawling Center',10000.00,'1974-07-02','ransteys9@ucoz.com','Reynard','Male','Ansteys','dTdZa2dVT2M=','https://images.pexels.com/photos/3785079/pexels-photo-3785079.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','2002-12-03','792-341-0273','reynardansteys'),
	 (true,'590 Everett Street',10000.00,'1970-08-13','dtollfreec@sciencedaily.com','Dee','Female','Tollfree','xnQFiVQRxV','https://images.pexels.com/photos/1860368/pexels-photo-1860368.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load','2004-06-16','713-202-6315','deetollfree'),
	 (true,'38 Basil Avenue',10000.00,'1993-12-01','sballind@digg.com','Susie','Female','Ballin','eG5RRmlWUVJ4Vg==','https://images.pexels.com/photos/6950769/pexels-photo-6950769.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load','2003-09-24','297-923-0089','susieballin'),
	 (true,'21683 Lindbergh Court',10000.00,'1931-11-27','wlaynee@state.gov','Wilmette','Female','Layne','frxSR0','https://images.pexels.com/photos/1914877/pexels-photo-1914877.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load','1999-04-05','875-113-6511','wilmettelayne'),
	 (true,'78 Manitowish Circle',10000.00,'1949-11-29','fwinsparf@redcross.org','Felicle','Female','Winspar','ZnJ4U1Iw','https://media.istockphoto.com/id/1370426275/photo/portrait-of-middle-aged-woman-with-ginger-hair.jpg?s=612x612&w=0&k=20&c=gdEulh7b2F0_1xFuJeoD7bEoiw2oaxZ_9VRw21j5MUI=','2011-03-19','751-934-5761','feliclewinspar'),
	 (true,'2132 Vahlen Circle',10000.00,'1986-10-09','efeastg@instagram.com','Eldridge','Male','Feast','zrImlZkT','https://images.pexels.com/photos/34534/people-peoples-homeless-male.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','2010-10-10','543-471-8206','eldridgefeast'),
	 (true,'5387 Charing Cross Point',10000.00,'1954-04-15','eofieldh@cocolog-nifty.com','Edy','Female','Ofield','enJJbWxaa1Q=','https://images.pexels.com/photos/4116988/pexels-photo-4116988.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load','2012-05-04','592-216-7132','edyofield'),
	 (true,'74 Blackbird Center',10000.00,'1999-02-28','mminghellai@nhs.uk','Morton','Male','Minghella','MUtweklE','https://images.pexels.com/photos/810775/pexels-photo-810775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','2015-08-28','222-241-1513','mortonminghella');

INSERT INTO user_role_assignment (assigned_date,role,modified_date,user_id) VALUES
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,1),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,2),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,3),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,4),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,5),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,6),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,7),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,8),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,9),
	 ('2023-03-13 00:00:00','ROLE_USER',NULL,10);



INSERT INTO genre (genre_name) VALUES
	 ('Action'),
	 ('Role-Playing'),
	 ('Strategy'),
	 ('Adventure'),
	 ('Simulation'),
	 ('Sports & Racing'),
	 ('Horror'),
	 ('Adult');


--
INSERT INTO publisher (cover_photo,description,established_date,publisher_name,thumbnail) VALUES
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/40425349/c263d17394502cedbf90373599eb2706ca84074d.png','PlayStation Studios is home to the development of Sony Interactive Entertainment’s own outstanding and immersive games, including some of the most popular and critically acclaimed titles in entertainment history.','1993-11-16','Sony Interactive Entertainment','https://avatars.cloudflare.steamstatic.com/40a85b52747a78b26e393e3f9e58f319194b1b33_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33273264/4256bc824357bb34aa4e2f7f11df9a62633d286f.png',NULL,'1979-05-30','Capcom','https://avatars.cloudflare.steamstatic.com/6b62a91eb5a093261d8831d1908717bab0d687e9_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33075774/6f635e1eeae42b293705087fc040e77116ed365a.png','Ubisoft is a creator of worlds, committed to enriching players'' lives with original and memorable gaming experiences.','1986-03-28','Ubisoft','https://avatars.cloudflare.steamstatic.com/2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/36135791/b42c79819a407c68f5b12a0028a2a8871bec6c7c.png',NULL,'1982-05-27','Electronic Arts','https://avatars.cloudflare.steamstatic.com/618cc2a46fad78ed1259df505c2de5bb4d806532_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33016879/c0a3a3a256b1c8c0023cfce1a0fe900abb4cd64a.png',NULL,'2009-01-14','KOEI TECMO','https://avatars.cloudflare.steamstatic.com/f76177141df41c80109df7c0df81f303a933a44c_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/32989758/b05e42588fee27abeb63080593125642b63cf219.jpg','CD PROJEKT RED is a development studio founded in 2002. Our mission is to tell emotional stories riddled with meaningful choices and consequences, as well as featuring characters gamers can truly connect with.','2002-01-01','CD PROJEKT RED','https://avatars.cloudflare.steamstatic.com/4f1187c11ad41f8aa58b9109efd52c2f8bca9918_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1541443/fb4af705f9b9e9d14640e48258d6ee11b8ad15a6.jpg',NULL,'1988-12-01','Rockstar Games','https://avatars.cloudflare.steamstatic.com/d83a1786f23929deb5f20326f128bbc13a9a1e85_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/33042543/22343df6affaa7a2657500d398024aed36ec2cba.png','Bandai Namco exists to share dreams, fun and inspiration with people around the world. Do you wish to enjoy every single day to the fullest? What we want is for people like you to always have a reason to smile.','2006-03-31','Bandai Namco Entertainment','https://avatars.cloudflare.steamstatic.com/97ea9619ba3076b8549c1484bef9308a67f0c64d_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/37700027/df452cd72626e4abc7fa73f6d641a5ce65cd2d19.jpg','Quantic Dream is an award-winning French video game developer and publisher founded to create AAA games with a focus on emotional, interactive storytelling and innovation in narrative.','1997-05-02','Quantic Dream','https://avatars.cloudflare.steamstatic.com/baf1dce75db2d5bfb0f5e14dd2183c4cb61911f7_full.jpg'),
	 ('https://cdn.akamai.steamstatic.com/steamcommunity/public/images/clans/1012195/52ab50f3f89e6188291c848fe7d4a45c86415d0a.jpg',NULL,'2003-04-01','Square Enix','https://avatars.cloudflare.steamstatic.com/2fe0615e013c887e87dd230e8268afdd15416f12_full.jpg');

INSERT INTO game (description, game_name, price, released_date, system_req, thumbnail, trailer, developer_id, publisher_id)
VALUES ('Play as Nathan Drake and Chloe Frazer in their own standalone adventures as they confront their pasts and forge their own legacies. This game includes the critically acclaimed single-player stories from both UNCHARTED 4: A Thief’s End and UNCHARTED: The Lost Legacy.', 'UNCHARTED™: Legacy of Thieves Collection', 59.99, '2022-10-19', 'MINIMUM: OS: Windows 10 64-bit Processor: Intel i5-4430, AMD Ryzen 3 1200 Memory: 8 GB RAM Graphics: NVIDIA GTX 960 (4 GB), AMD R9 290X (4 GB) DirectX: Version 12 Storage: 126 GB available space', 'https://upload.wikimedia.org/wikipedia/en/1/1a/Uncharted_4_box_artwork.jpg', 'https://www.youtube.com/watch?v=F3Wl-OiZCO4', 1, 1),
('His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.', 'God of War (2018)', 59.99, '2022-01-14', 'MINIMUM:Requires a 64-bit processor and operating systemOS: Windows 10 64-bitProcessor: Intel i5-2500k (4 core 3.3 GHz) or AMD Ryzen 3 1200 (4 core 3.1 GHz)Memory: 8 GB RAMGraphics: NVIDIA GTX 960 (4 GB) or AMD R9 290X (4 GB) DirectX: Version 11 Storage: 70 GB available space Additional Notes: DirectX feature level 11_1 required', 'https://upload.wikimedia.org/wikipedia/en/a/a7/God_of_War_4_cover.jpg', 'https://www.youtube.com/watch?v=HqQMh_tij0c', 1, 2),
('Experience Aloy’s legendary quest to unravel the mysteries of a future Earth ruled by Machines. Use devastating tactical attacks against your prey and explore a majestic open world in this award-winning action RPG!', 'Horizon Zero Dawn™ Complete Edition', 29.99, '2020-08-07', 'MINIMUM:Requires a 64-bit processor and operating systemOS: Windows 10 64-bitsProcessor: Intel Core i5-2500K@3.3GHz or AMD FX 6300@3.5GHzMemory: 8 GB RAMGraphics: Nvidia GeForce GTX 780 (3 GB) or AMD Radeon R9 290 (4GB)DirectX: Version 12Storage: 100 GB available space', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1151640/header.jpg?t=1667297464', 'https://www.youtube.com/watch?v=76O5KaJHEA0', 2, 3),
('Experience the emotional storytelling and unforgettable characters in The Last of Us™, winner of over 200 Game of the Year awards.', 'The Last of Us™ Part I', 59.99, '2023-03-28', 'MINIMUM:Requires a 64-bit processor and operating systemOS: Windows 10 (Version 1909 or Newer)Processor: AMD Ryzen 5 1500X, Intel Core i7-4770KMemory: 16 GB RAMGraphics: AMD Radeon RX 470 (4 GB), AMD Radeon RX 6500 XT (4 GB), NVIDIA GeForce GTX 970 (4 GB), NVIDIA GeForce GTX 1050 Ti (4 GB)Storage: 100 GB available spaceAdditional Notes: SSD Recommended', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1680282721', 'https://www.youtube.com/watch?v=CxVyuE2Nn_w', 3, 4);

INSERT INTO game_image (image_link,game_id) VALUES
	 ('https://oyster.ignimgs.com/mediawiki/apis.ign.com/uncharted-4/c/c8/10_TheTwelveTowers_01.jpg',1),
	 ('https://cdn.cloudflare.steamstatic.com/steam/apps/1659420/ss_a1816dd536122dd740043c2b9440136503904215.1920x1080.jpg?t=1672777947',2),
	 (' https://images.fpt.shop/unsafe/filters:quality(90)/fptshop.com.vn/uploads/images/tin-tuc/149709/Originals/18091357154041%20f.jpg',3),
	 ('https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2018%2F12%2Fgod-of-war-2018-2000.jpg&q=60',4);

 INSERT INTO game_genre (game_id,genre_id) VALUES (1,1),(1,4),(2,1);

INSERT INTO rating (rating,game_id,user_id)
 VALUES (5,1,1);
--
INSERT INTO receipt (receipt_date,user_id) VALUES
	 ('2023-06-19',1),
	 ('2023-06-20',2),
	 ('2023-06-21',3),
	 ('2023-06-22',3);

INSERT INTO game_code (game_code,status,game_id) VALUES
	 ('zxcvbn456QWEsR','Available',1),
	 ('asdfgh789ZXCVf','Available',1),
	 ('123456abcQWERf','Available',1),
	 ('123456EfghfghR','Available',2),
	 ('12abcQWEhhfghR','Available',2),
	 ('3456bcQWERfghf','Available',2),
	 ('16abcdfghfQWER','Available',3),
	 ('4dfgh56abcQWER','Available',3),
	 ('123cQasdfsdWER','Available',3),
	 ('mvnvc67NHYsLOd','Available',2);
--
INSERT INTO receipt_details (game_price,game_code_id,receipt_id) VALUES
	 (59.99,1,1),
	 (59.99,2,2),
	 (59.99,3,3),
	 (59.99,4,2);

INSERT INTO sub_genre (sub_genre_name,genre_id) VALUES
	 ('Arcade & Rhythm',1),
	 ('Fighting & Martial Arts',1),
	 ('First-Person Shooter',1),
	 ('Hack & Slash',1),
	 ('Platformer & Runner',1),
	 ('Third-Person Shooter',1),
	 ('Action RPG',2),
	 ('Adventure RPG',2),
	 ('JRPG',2),
	 ('Party-Based',2);

