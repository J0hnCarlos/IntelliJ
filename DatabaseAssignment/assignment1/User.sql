DROP TABLE friendsRequest CASCADE CONSTRAINTS;
DROP TABLE friendsWith CASCADE CONSTRAINTS;
DROP TABLE likes CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE post CASCADE CONSTRAINTS;

CREATE TABLE friendsRequest (
 memberRequesterEmail VARCHAR2(100) NOT NULL,
 memberRecepientEmail VARCHAR2(100) NOT NULL,
 requestDate DATE,
 requestStatus VARCHAR2(5)
);

ALTER TABLE friendsRequest ADD CONSTRAINT friendsRequest_pk PRIMARY KEY ( memberRequesterEmail,
 memberRecepientEmail );
 
CREATE TABLE friendsWith (
 memberOneEmail VARCHAR2(100) NOT NULL,
 memberTwoEmail VARCHAR2(100) NOT NULL,
 startDate DATE
);

ALTER TABLE friendsWith ADD CONSTRAINT friendWith_pk PRIMARY KEY ( memberOneEmail,
 memberTwoEmail );
CREATE TABLE likes (
 email VARCHAR2(100) NOT NULL,
 postID INTEGER NOT NULL
);

ALTER TABLE likes ADD CONSTRAINT likes_pk PRIMARY KEY ( email,
 postID );
 
CREATE TABLE member (
 email VARCHAR2(100) NOT NULL,
 fullName VARCHAR2(200),
 screenName VARCHAR2(100),
 dateOfBirth DATE,
 gender VARCHAR2(10),
 status VARCHAR2(20),
 location VARCHAR2(100),
 visibility VARCHAR2(15)
);

ALTER TABLE member ADD CONSTRAINT memberpk PRIMARY KEY ( email );
CREATE TABLE post (
 postID INTEGER NOT NULL,
 postTimestamp TIMESTAMP,
 body CLOB,
 parentPostID INTEGER,
 email VARCHAR2(100) NOT NULL
);

ALTER TABLE post ADD CONSTRAINT post_pk PRIMARY KEY ( postID );

ALTER TABLE friendsRequest
 ADD CONSTRAINT friendsRequest_member_fk FOREIGN KEY ( memberRequesterEmail )
 REFERENCES member ( email );
 
ALTER TABLE friendsRequest
 ADD CONSTRAINT friendsRequest_member_fkv1 FOREIGN KEY ( memberRecepientEmail )
 REFERENCES member ( email );
 
ALTER TABLE friendsWith
 ADD CONSTRAINT friendWith_member_fk FOREIGN KEY ( memberOneEmail )
 REFERENCES member ( email );
 
ALTER TABLE friendsWith
 ADD CONSTRAINT friendWith_member_fkv1 FOREIGN KEY ( memberTwoEmail )
 REFERENCES member ( email );
 
ALTER TABLE likes
 ADD CONSTRAINT likes_member_fk FOREIGN KEY ( email )
 REFERENCES member ( email );
 
ALTER TABLE likes
 ADD CONSTRAINT likes_post_fk FOREIGN KEY ( postID )
 REFERENCES post ( postid );
 
ALTER TABLE post
 ADD CONSTRAINT post_member_fk FOREIGN KEY ( email )
 REFERENCES member ( email );
 
ALTER TABLE post
 ADD CONSTRAINT post_post_fk FOREIGN KEY ( parentPostID )
 REFERENCES post ( postID );