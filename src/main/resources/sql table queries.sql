CREATE TABLE yt_rest_user (address VARCHAR(45) NULL, city VARCHAR(45) NULL, email VARCHAR(45) NOT NULL, fName VARCHAR(45) NOT NULL, lName VARCHAR(45) NULL, locality VARCHAR(45) NULL, name VARCHAR(45) NOT NULL, password VARCHAR(45) NOT NULL, phone VARCHAR(45) NOT NULL, restaurants_owned VARCHAR(45) NULL, user_id INT NOT NULL, PRIMARY KEY (user_id)) ENGINE=MyISAM
;

CREATE TABLE yt_h_cusines (cusine_id INT NOT NULL, cusine_name VARCHAR(45) NULL, PRIMARY KEY (cusine_id)) ENGINE=MyISAM
;

CREATE TABLE yt_restaurants (acceptCC INT NOT NULL, active INT NOT NULL, address VARCHAR(100) NULL, avgCostForTwo INT NULL, city VARCHAR(45) NULL, cusines VARCHAR(20) NOT NULL, hasAC INT NOT NULL, hasWifi INT NOT NULL, isVeg INT NOT NULL, latitude VARCHAR(45) NULL, locality VARCHAR(45) NULL, longitude VARCHAR(45) NULL, name VARCHAR(150) NOT NULL, nfs_phone VARCHAR(15) NOT NULL, phones VARCHAR(100) NOT NULL, rest_createBy INT NOT NULL, rest_id BIGINT NOT NULL, timings VARCHAR(20) NOT NULL, PRIMARY KEY (rest_id)) ENGINE=MyISAM
;

CREATE TABLE betausers (email VARCHAR(100) NOT NULL, regDate DATETIME NOT NULL, regID INT NOT NULL, srefId VARCHAR(100) NULL, urefId VARCHAR(100) NULL, PRIMARY KEY (regID)) ENGINE=MyISAM
;

CREATE TABLE yt_rest_timings (CreatedBy INT NOT NULL, available_seats VARCHAR(45) NULL, reserve_time VARCHAR(45) NOT NULL, rest_id INT NOT NULL, time_of_day VARCHAR(45) NOT NULL, timing_id INT NOT NULL, total_seats VARCHAR(45) NULL, PRIMARY KEY (timing_id)) ENGINE=MyISAM
;

CREATE TABLE yt_rest_booking (bookingTime DATETIME NOT NULL, booking_id INT NOT NULL, booking_source_id VARCHAR(45) NULL, no_of_people VARCHAR(45) NULL, reserve_date DATE NOT NULL, rest_id INT NOT NULL, timing_id INT NOT NULL, PRIMARY KEY (booking_id)) ENGINE=MyISAM
;

ALTER TABLE yt_restaurants ADD FOREIGN KEY (rest_createBy) REFERENCES yt_rest_user (user_id)
;

ALTER TABLE yt_rest_timings ADD FOREIGN KEY (CreatedBy) REFERENCES yt_rest_user (user_id)
;

ALTER TABLE yt_rest_booking ADD FOREIGN KEY (timing_id) REFERENCES yt_rest_timings (timing_id)
;

CREATE TABLE AUTO_PK_SUPPORT (  TABLE_NAME CHAR(100) NOT NULL,  NEXT_ID BIGINT NOT NULL, UNIQUE (TABLE_NAME))
;

DELETE FROM AUTO_PK_SUPPORT WHERE TABLE_NAME IN ('betausers', 'yt_h_cusines', 'yt_rest_booking', 'yt_rest_timings', 'yt_rest_user', 'yt_restaurants')
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('betausers', 200)
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('yt_h_cusines', 200)
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('yt_rest_booking', 200)
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('yt_rest_timings', 200)
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('yt_rest_user', 200)
;

INSERT INTO AUTO_PK_SUPPORT (TABLE_NAME, NEXT_ID) VALUES ('yt_restaurants', 200)
;

