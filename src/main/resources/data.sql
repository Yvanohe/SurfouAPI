-- Insert into role :
Insert into role (name) values ('ADMIN');
Insert into role (name) values ('USER');

-- Insert into user_account:
Insert into user_account (username, password, email, role_id) values ('admin','Pa$$w0rd','y.lubac@gmail.com',1);
Insert into user_account (username, password, email, role_id) values ('toto','titi','toto@titi.com',2);

-- Insert into spot_type
Insert into spot_type (name, description) values ('beach', 'classic sand beach');
Insert into spot_type (name, description) values ('lagoon', 'very safe lagoon (impossible to drift offshore');

-- Insert into activity_description
insert into activity_description (name, description) values ('kitesurf', 'the sport or pastime of riding on a modified surfboard while holding on to a specially designed kite, using the wind for propulsion.');
insert into activity_description (name, description) values ('windsurf', 'the sport or activity of riding on water on a sailboard.');

--Insert into spot 
insert into spot (name, city, geom,  comment, official, creator_user_id, type_id) VALUES ('Treompan', 'Ploudalmézeau', 'POINT(-4.6642385116123 48.5705177216782)', 'Large beach with several car parks to the west. When there''s a swell, the spot is mainly used by windsurfers, but there are also a few kitesurfers.', true, 1, 1);
insert into spot (name, city, geom,  comment, official, creator_user_id, type_id) VALUES ('Dunes de Saint-Marguerite', 'Landéda', 'POINT(-4.6059105723447 48.5948373405776)', 'The ideal place to start kitesurfing. At high tide a basin fills up, giving you a large area to stand on. \nLarge car park.', false, 2, 1);

-- Insert into weather_condition
insert into weather_condition (min_wind_direction, max_wind_direction, min_wind_force, max_wind_force, max_tide_height, min_wave_direction, max_wave_direction, min_wave_period, max_wave_period) values (270,90,13,35,2,315,0,12,20);
insert into weather_condition (min_wind_direction, max_wind_direction, min_wind_force, max_wind_force, max_tide_height, min_wave_direction, max_wave_direction, min_wave_period, max_wave_period) values (250,180,13,30,2,315,0,12,18);

--Insert into nautical_activity
INSERT INTO nautical_activity (spot_id, weather_conditions_id,activity_id, name, official) VALUES (1, 1, 1,'kitsurf trepompan',true);
INSERT INTO nautical_activity (spot_id, weather_conditions_id,activity_id, name, official) VALUES (2, 2, 1,'dunes', false);
INSERT INTO nautical_activity (spot_id, weather_conditions_id,activity_id, name, official) VALUES (1, 1, 2,'windsurf trepompan',true);

-- insert into users_spots_bookmarked
insert into users_spots_bookmarked (id_spot, id_user) values (1,1);
insert into users_spots_bookmarked (id_spot, id_user) values (1,2);
insert into users_spots_bookmarked (id_spot, id_user) values (2,2);