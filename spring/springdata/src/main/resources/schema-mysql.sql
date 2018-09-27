
CREATE TABLE IF NOT EXISTS Hotel(
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(36) NOT NULL,
  address varchar(256) NOT NULL,
  PRIMARY KEY (id),
  INDEX hotelid_index (id)
)DEFAULT CHARSET=utf;

CREATE TABLE IF NOT EXISTS HotelBooking(
  id bigint NOT NULL AUTO_INCREMENT,
  hotelId bigint NOT NULL,
  fromDate date NOT NULL,
  toDate date NOT NULL,
  numberOfPeople int(4) NOT NULL DEFAULT '1',
  bookerId bigint NOT NULL,
  PRIMARY KEY (id),
  INDEX hotelid_index (id)
)DEFAULT CHARSET=utf;