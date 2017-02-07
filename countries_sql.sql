drop table if exists countries_data;

CREATE TABLE countries_data
(
id int(10) not null,
country CHAR(25),
phone_prefix char(7),
flag text(200),
population int(30),
capital_city CHAR(25),
geo_location text(200),
commentary text(350),
PRIMARY KEY (id)
)
ENGINE=InnoDB AUTO_INCREMENT=2;

INSERT INTO `countries_data` (`id`, `country`, `phone_prefix`, `flag`, `population`, `capital_city`, `geo_location`, `commentary`) VALUES
(1, 'Ireland', '+353', 'http://www.infoplease.com/spot/irishflag1.html', 3800000, 'Dublin', 'https://www.google.ie/maps/place/Dublin/@53.3239919,-6.5258808,10z/data=!3m1!4b1!4m5!3m4!1s0x48670e80ea27ac2f:0xa00c7a9973171a0!8m2!3d53.3498053!4d-6.2603097', 'Dublin, capital of the Republic of Ireland, is on Ireland’s east coast at the mouth of the River Liffey. Its historic buildings include Dublin Castle, dating to the 13th century, and imposing St Patrick’s Cathedral, founded in 1191. City parks include landscaped St Stephen’s Green and huge Phoenix Park, containing Dublin Zoo. The National Museum of Ireland explores Irish heritage and culture.');


select * from countries_data;