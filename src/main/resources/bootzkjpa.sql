/*
Navicat PGSQL Data Transfer

Source Server         : POSTGRES-Local
Source Server Version : 90602
Source Host           : localhost:5432
Source Database       : bootzkjpa
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90602
File Encoding         : 65001

Date: 2017-06-01 18:31:05
*/


-- ----------------------------
-- Sequence structure for actor_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."actor_seq";
CREATE SEQUENCE "public"."actor_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for city_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."city_seq";
CREATE SEQUENCE "public"."city_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for country_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."country_seq";
CREATE SEQUENCE "public"."country_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for cover_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."cover_seq";
CREATE SEQUENCE "public"."cover_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."cover_seq"', 1, true);

-- ----------------------------
-- Sequence structure for director_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."director_seq";
CREATE SEQUENCE "public"."director_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for genre_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."genre_seq";
CREATE SEQUENCE "public"."genre_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval('"public"."genre_seq"', 2, true);

-- ----------------------------
-- Sequence structure for hibernate_sequence
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."hibernate_sequence";
CREATE SEQUENCE "public"."hibernate_sequence"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for movie_file_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."movie_file_seq";
CREATE SEQUENCE "public"."movie_file_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."movie_file_seq"', 1, true);

-- ----------------------------
-- Sequence structure for movie_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."movie_seq";
CREATE SEQUENCE "public"."movie_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."movie_seq"', 1, true);

-- ----------------------------
-- Sequence structure for parameter_category_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."parameter_category_seq";
CREATE SEQUENCE "public"."parameter_category_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for parameter_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."parameter_seq";
CREATE SEQUENCE "public"."parameter_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for state_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."state_seq";
CREATE SEQUENCE "public"."state_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for user_role_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_role_seq";
CREATE SEQUENCE "public"."user_role_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for user_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_seq";
CREATE SEQUENCE "public"."user_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for writer_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."writer_seq";
CREATE SEQUENCE "public"."writer_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for mst_actor
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_actor";
CREATE TABLE "public"."mst_actor" (
"id" int8 NOT NULL,
"firstname" varchar(255) COLLATE "default",
"lastname" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_actor
-- ----------------------------

-- ----------------------------
-- Table structure for mst_city
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_city";
CREATE TABLE "public"."mst_city" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"stateid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_city
-- ----------------------------

-- ----------------------------
-- Table structure for mst_country
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_country";
CREATE TABLE "public"."mst_country" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_country
-- ----------------------------
INSERT INTO "public"."mst_country" VALUES ('1', 'ID', 'Indonesia');
INSERT INTO "public"."mst_country" VALUES ('2', 'AF', 'Afghanistan');
INSERT INTO "public"."mst_country" VALUES ('3', 'AX', 'Aland Islands');
INSERT INTO "public"."mst_country" VALUES ('4', 'AL', 'Albania');
INSERT INTO "public"."mst_country" VALUES ('5', 'DZ', 'Algeria');
INSERT INTO "public"."mst_country" VALUES ('6', 'AS', 'American Samoa');
INSERT INTO "public"."mst_country" VALUES ('7', 'AD', 'Andorra');
INSERT INTO "public"."mst_country" VALUES ('8', 'AO', 'Angola');
INSERT INTO "public"."mst_country" VALUES ('9', 'AI', 'Anguilla');
INSERT INTO "public"."mst_country" VALUES ('10', 'AQ', 'Antarctica');
INSERT INTO "public"."mst_country" VALUES ('11', 'AG', 'Antigua and Barbuda');
INSERT INTO "public"."mst_country" VALUES ('12', 'AR', 'Argentina');
INSERT INTO "public"."mst_country" VALUES ('13', 'AM', 'Armenia');
INSERT INTO "public"."mst_country" VALUES ('14', 'AW', 'Aruba');
INSERT INTO "public"."mst_country" VALUES ('15', 'AU', 'Australia');
INSERT INTO "public"."mst_country" VALUES ('16', 'AT', 'Austria');
INSERT INTO "public"."mst_country" VALUES ('17', 'AZ', 'Azerbaijan');
INSERT INTO "public"."mst_country" VALUES ('18', 'BS', 'Bahamas');
INSERT INTO "public"."mst_country" VALUES ('19', 'BH', 'Bahrain');
INSERT INTO "public"."mst_country" VALUES ('20', 'BD', 'Bangladesh');
INSERT INTO "public"."mst_country" VALUES ('21', 'BB', 'Barbados');
INSERT INTO "public"."mst_country" VALUES ('22', 'BY', 'Belarus');
INSERT INTO "public"."mst_country" VALUES ('23', 'BE', 'Belgium');
INSERT INTO "public"."mst_country" VALUES ('24', 'BZ', 'Belize');
INSERT INTO "public"."mst_country" VALUES ('25', 'BJ', 'Benin');
INSERT INTO "public"."mst_country" VALUES ('26', 'BM', 'Bermuda');
INSERT INTO "public"."mst_country" VALUES ('27', 'BT', 'Bhutan');
INSERT INTO "public"."mst_country" VALUES ('28', 'BO', 'Bolivia, Plurinational State of');
INSERT INTO "public"."mst_country" VALUES ('29', 'BA', 'Bosnia and Herzegovina');
INSERT INTO "public"."mst_country" VALUES ('30', 'BW', 'Botswana');
INSERT INTO "public"."mst_country" VALUES ('31', 'BV', 'Bouvet Island');
INSERT INTO "public"."mst_country" VALUES ('32', 'BR', 'Brazil');
INSERT INTO "public"."mst_country" VALUES ('33', 'IO', 'British Indian Ocean Territory');
INSERT INTO "public"."mst_country" VALUES ('34', 'BN', 'Brunei Darussalam');
INSERT INTO "public"."mst_country" VALUES ('35', 'BG', 'Bulgaria');
INSERT INTO "public"."mst_country" VALUES ('36', 'BF', 'Burkina Faso');
INSERT INTO "public"."mst_country" VALUES ('37', 'BI', 'Burundi');
INSERT INTO "public"."mst_country" VALUES ('38', 'KH', 'Cambodia');
INSERT INTO "public"."mst_country" VALUES ('39', 'CM', 'Cameroon');
INSERT INTO "public"."mst_country" VALUES ('40', 'CA', 'Canada');
INSERT INTO "public"."mst_country" VALUES ('41', 'CV', 'Cape Verde');
INSERT INTO "public"."mst_country" VALUES ('42', 'KY', 'Cayman Islands');
INSERT INTO "public"."mst_country" VALUES ('43', 'CF', 'Central African Republic');
INSERT INTO "public"."mst_country" VALUES ('44', 'TD', 'Chad');
INSERT INTO "public"."mst_country" VALUES ('45', 'CL', 'Chile');
INSERT INTO "public"."mst_country" VALUES ('46', 'CN', 'China');
INSERT INTO "public"."mst_country" VALUES ('47', 'CX', 'Christmas Island');
INSERT INTO "public"."mst_country" VALUES ('48', 'CC', 'Cocos (Keeling) Islands');
INSERT INTO "public"."mst_country" VALUES ('49', 'CO', 'Colombia');
INSERT INTO "public"."mst_country" VALUES ('50', 'KM', 'Comoros');
INSERT INTO "public"."mst_country" VALUES ('51', 'CG', 'Congo');
INSERT INTO "public"."mst_country" VALUES ('52', 'CD', 'Congo, the Democratic Republic of the');
INSERT INTO "public"."mst_country" VALUES ('53', 'CK', 'Cook Islands');
INSERT INTO "public"."mst_country" VALUES ('54', 'CR', 'Costa Rica');
INSERT INTO "public"."mst_country" VALUES ('55', 'HR', 'Croatia');
INSERT INTO "public"."mst_country" VALUES ('56', 'CU', 'Cuba');
INSERT INTO "public"."mst_country" VALUES ('57', 'CY', 'Cyprus');
INSERT INTO "public"."mst_country" VALUES ('58', 'CZ', 'Czech Republic');
INSERT INTO "public"."mst_country" VALUES ('59', 'DK', 'Denmark');
INSERT INTO "public"."mst_country" VALUES ('60', 'DJ', 'Djibouti');
INSERT INTO "public"."mst_country" VALUES ('61', 'DM', 'Dominica');
INSERT INTO "public"."mst_country" VALUES ('62', 'DO', 'Dominican Republic');
INSERT INTO "public"."mst_country" VALUES ('63', 'EC', 'Ecuador');
INSERT INTO "public"."mst_country" VALUES ('64', 'EG', 'Egypt');
INSERT INTO "public"."mst_country" VALUES ('65', 'SV', 'El Salvador');
INSERT INTO "public"."mst_country" VALUES ('66', 'GQ', 'Equatorial Guinea');
INSERT INTO "public"."mst_country" VALUES ('67', 'ER', 'Eritrea');
INSERT INTO "public"."mst_country" VALUES ('68', 'EE', 'Estonia');
INSERT INTO "public"."mst_country" VALUES ('69', 'ET', 'Ethiopia');
INSERT INTO "public"."mst_country" VALUES ('70', 'FK', 'Falkland Islands (Malvinas)');
INSERT INTO "public"."mst_country" VALUES ('71', 'FO', 'Faroe Islands');
INSERT INTO "public"."mst_country" VALUES ('72', 'FJ', 'Fiji');
INSERT INTO "public"."mst_country" VALUES ('73', 'FI', 'Finland');
INSERT INTO "public"."mst_country" VALUES ('74', 'FR', 'France');
INSERT INTO "public"."mst_country" VALUES ('75', 'GF', 'French Guiana');
INSERT INTO "public"."mst_country" VALUES ('76', 'TF', 'French Southern Territories');
INSERT INTO "public"."mst_country" VALUES ('77', 'GA', 'Gabon');
INSERT INTO "public"."mst_country" VALUES ('78', 'GM', 'Gambia');
INSERT INTO "public"."mst_country" VALUES ('79', 'GE', 'Georgia');
INSERT INTO "public"."mst_country" VALUES ('80', 'DE', 'Germany');
INSERT INTO "public"."mst_country" VALUES ('81', 'GH', 'Ghana');
INSERT INTO "public"."mst_country" VALUES ('82', 'GI', 'Gibraltar');
INSERT INTO "public"."mst_country" VALUES ('83', 'GR', 'Greece');
INSERT INTO "public"."mst_country" VALUES ('84', 'GL', 'Greenland');
INSERT INTO "public"."mst_country" VALUES ('85', 'GD', 'Grenada');
INSERT INTO "public"."mst_country" VALUES ('86', 'GP', 'Guadeloupe');
INSERT INTO "public"."mst_country" VALUES ('87', 'GU', 'Guam');
INSERT INTO "public"."mst_country" VALUES ('88', 'GT', 'Guatemala');
INSERT INTO "public"."mst_country" VALUES ('89', 'GG', 'Guernsey');
INSERT INTO "public"."mst_country" VALUES ('90', 'GN', 'Guinea');
INSERT INTO "public"."mst_country" VALUES ('91', 'GW', 'Guinea-Bissau');
INSERT INTO "public"."mst_country" VALUES ('92', 'GY', 'Guyana');
INSERT INTO "public"."mst_country" VALUES ('93', 'HT', 'Haiti');
INSERT INTO "public"."mst_country" VALUES ('94', 'HM', 'Heard Island and McDonald Islands');
INSERT INTO "public"."mst_country" VALUES ('95', 'HN', 'Honduras');
INSERT INTO "public"."mst_country" VALUES ('96', 'HK', 'Hong Kong');
INSERT INTO "public"."mst_country" VALUES ('97', 'HU', 'Hungary');
INSERT INTO "public"."mst_country" VALUES ('98', 'IS', 'Iceland');
INSERT INTO "public"."mst_country" VALUES ('99', 'IN', 'India');
INSERT INTO "public"."mst_country" VALUES ('100', 'IR', 'Iran, Islamic Republic of');
INSERT INTO "public"."mst_country" VALUES ('101', 'IQ', 'Iraq');
INSERT INTO "public"."mst_country" VALUES ('102', 'IE', 'Ireland');
INSERT INTO "public"."mst_country" VALUES ('103', 'IM', 'Isle of Man');
INSERT INTO "public"."mst_country" VALUES ('104', 'IL', 'Israel');
INSERT INTO "public"."mst_country" VALUES ('105', 'IT', 'Italy');
INSERT INTO "public"."mst_country" VALUES ('106', 'JM', 'Jamaica');
INSERT INTO "public"."mst_country" VALUES ('107', 'JP', 'Japan');
INSERT INTO "public"."mst_country" VALUES ('108', 'JE', 'Jersey');
INSERT INTO "public"."mst_country" VALUES ('109', 'JO', 'Jordan');
INSERT INTO "public"."mst_country" VALUES ('110', 'KZ', 'Kazakhstan');
INSERT INTO "public"."mst_country" VALUES ('111', 'KE', 'Kenya');
INSERT INTO "public"."mst_country" VALUES ('112', 'KI', 'Kiribati');
INSERT INTO "public"."mst_country" VALUES ('113', 'KW', 'Kuwait');
INSERT INTO "public"."mst_country" VALUES ('114', 'KG', 'Kyrgyzstan');
INSERT INTO "public"."mst_country" VALUES ('115', 'LA', 'Lao Peoples Democratic Republic');
INSERT INTO "public"."mst_country" VALUES ('116', 'LV', 'Latvia');
INSERT INTO "public"."mst_country" VALUES ('117', 'LB', 'Lebanon');
INSERT INTO "public"."mst_country" VALUES ('118', 'LS', 'Lesotho');
INSERT INTO "public"."mst_country" VALUES ('119', 'LR', 'Liberia');
INSERT INTO "public"."mst_country" VALUES ('120', 'LY', 'Libyan Arab Jamahiriya');
INSERT INTO "public"."mst_country" VALUES ('121', 'LI', 'Liechtenstein');
INSERT INTO "public"."mst_country" VALUES ('122', 'LT', 'Lithuania');
INSERT INTO "public"."mst_country" VALUES ('123', 'LU', 'Luxembourg');
INSERT INTO "public"."mst_country" VALUES ('124', 'MO', 'Macao');
INSERT INTO "public"."mst_country" VALUES ('125', 'MK', 'Macedonia, the former Yugoslav Republic of');
INSERT INTO "public"."mst_country" VALUES ('126', 'MG', 'Madagascar');
INSERT INTO "public"."mst_country" VALUES ('127', 'MW', 'Malawi');
INSERT INTO "public"."mst_country" VALUES ('128', 'MY', 'Malaysia');
INSERT INTO "public"."mst_country" VALUES ('129', 'MV', 'Maldives');
INSERT INTO "public"."mst_country" VALUES ('130', 'ML', 'Mali');
INSERT INTO "public"."mst_country" VALUES ('131', 'MT', 'Malta');
INSERT INTO "public"."mst_country" VALUES ('132', 'MH', 'Marshall Islands');
INSERT INTO "public"."mst_country" VALUES ('133', 'MQ', 'Martinique');
INSERT INTO "public"."mst_country" VALUES ('134', 'MR', 'Mauritania');
INSERT INTO "public"."mst_country" VALUES ('135', 'MU', 'Mauritius');
INSERT INTO "public"."mst_country" VALUES ('136', 'YT', 'Mayotte');
INSERT INTO "public"."mst_country" VALUES ('137', 'MX', 'Mexico');
INSERT INTO "public"."mst_country" VALUES ('138', 'FM', 'Micronesia, Federated States of');
INSERT INTO "public"."mst_country" VALUES ('139', 'MD', 'Moldova, Republic of');
INSERT INTO "public"."mst_country" VALUES ('140', 'MC', 'Monaco');
INSERT INTO "public"."mst_country" VALUES ('141', 'MN', 'Mongolia');
INSERT INTO "public"."mst_country" VALUES ('142', 'ME', 'Montenegro');
INSERT INTO "public"."mst_country" VALUES ('143', 'MS', 'Montserrat');
INSERT INTO "public"."mst_country" VALUES ('144', 'MA', 'Morocco');
INSERT INTO "public"."mst_country" VALUES ('145', 'MZ', 'Mozambique');
INSERT INTO "public"."mst_country" VALUES ('146', 'MM', 'Myanmar');
INSERT INTO "public"."mst_country" VALUES ('147', 'NA', 'Namibia');
INSERT INTO "public"."mst_country" VALUES ('148', 'NR', 'Nauru');
INSERT INTO "public"."mst_country" VALUES ('149', 'NP', 'Nepal');
INSERT INTO "public"."mst_country" VALUES ('150', 'NL', 'Netherlands');
INSERT INTO "public"."mst_country" VALUES ('151', 'AN', 'Netherlands Antilles');
INSERT INTO "public"."mst_country" VALUES ('152', 'NC', 'New Caledonia');
INSERT INTO "public"."mst_country" VALUES ('153', 'NZ', 'New Zealand');
INSERT INTO "public"."mst_country" VALUES ('154', 'NI', 'Nicaragua');
INSERT INTO "public"."mst_country" VALUES ('155', 'NE', 'Niger');
INSERT INTO "public"."mst_country" VALUES ('156', 'NG', 'Nigeria');
INSERT INTO "public"."mst_country" VALUES ('157', 'NU', 'Niue');
INSERT INTO "public"."mst_country" VALUES ('158', 'NF', 'Norfolk Island');
INSERT INTO "public"."mst_country" VALUES ('159', 'MP', 'Northern Mariana Islands');
INSERT INTO "public"."mst_country" VALUES ('160', 'NO', 'Norway');
INSERT INTO "public"."mst_country" VALUES ('161', 'OM', 'Oman');
INSERT INTO "public"."mst_country" VALUES ('162', 'PK', 'Pakistan');
INSERT INTO "public"."mst_country" VALUES ('163', 'PW', 'Palau');
INSERT INTO "public"."mst_country" VALUES ('164', 'PS', 'Palestinian Territory, Occupied');
INSERT INTO "public"."mst_country" VALUES ('165', 'PA', 'Panama');
INSERT INTO "public"."mst_country" VALUES ('166', 'PG', 'Papua New Guinea');
INSERT INTO "public"."mst_country" VALUES ('167', 'PY', 'Paraguay');
INSERT INTO "public"."mst_country" VALUES ('168', 'PE', 'Peru');
INSERT INTO "public"."mst_country" VALUES ('169', 'PH', 'Philippines');
INSERT INTO "public"."mst_country" VALUES ('170', 'PN', 'Pitcairn');
INSERT INTO "public"."mst_country" VALUES ('171', 'PL', 'Poland');
INSERT INTO "public"."mst_country" VALUES ('172', 'PT', 'Portugal');
INSERT INTO "public"."mst_country" VALUES ('173', 'PR', 'Puerto Rico');
INSERT INTO "public"."mst_country" VALUES ('174', 'QA', 'Qatar');
INSERT INTO "public"."mst_country" VALUES ('175', 'RE', 'Reunion');
INSERT INTO "public"."mst_country" VALUES ('176', 'RO', 'Romania');
INSERT INTO "public"."mst_country" VALUES ('177', 'RU', 'Russian Federation');
INSERT INTO "public"."mst_country" VALUES ('178', 'RW', 'Rwanda');
INSERT INTO "public"."mst_country" VALUES ('179', 'BL', 'Saint Barth¿lemy');
INSERT INTO "public"."mst_country" VALUES ('180', 'SH', 'Saint Helena, Ascension and Tristan da Cunha');
INSERT INTO "public"."mst_country" VALUES ('181', 'KN', 'Saint Kitts and Nevis');
INSERT INTO "public"."mst_country" VALUES ('182', 'LC', 'Saint Lucia');
INSERT INTO "public"."mst_country" VALUES ('183', 'MF', 'Saint Martin (French part)');
INSERT INTO "public"."mst_country" VALUES ('184', 'PM', 'Saint Pierre and Miquelon');
INSERT INTO "public"."mst_country" VALUES ('185', 'VC', 'Saint Vincent and the Grenadines');
INSERT INTO "public"."mst_country" VALUES ('186', 'WS', 'Samoa');
INSERT INTO "public"."mst_country" VALUES ('187', 'SM', 'San Marino');
INSERT INTO "public"."mst_country" VALUES ('188', 'ST', 'Sao Tome and Principe');
INSERT INTO "public"."mst_country" VALUES ('189', 'SA', 'Saudi Arabia');
INSERT INTO "public"."mst_country" VALUES ('190', 'SN', 'Senegal');
INSERT INTO "public"."mst_country" VALUES ('191', 'RS', 'Serbia');
INSERT INTO "public"."mst_country" VALUES ('192', 'SC', 'Seychelles');
INSERT INTO "public"."mst_country" VALUES ('193', 'SL', 'Sierra Leone');
INSERT INTO "public"."mst_country" VALUES ('194', 'SG', 'Singapore');
INSERT INTO "public"."mst_country" VALUES ('195', 'SK', 'Slovakia');
INSERT INTO "public"."mst_country" VALUES ('196', 'SI', 'Slovenia');
INSERT INTO "public"."mst_country" VALUES ('197', 'SB', 'Solomon Islands');
INSERT INTO "public"."mst_country" VALUES ('198', 'SO', 'Somalia');
INSERT INTO "public"."mst_country" VALUES ('199', 'ZA', 'South Africa');
INSERT INTO "public"."mst_country" VALUES ('200', 'ES', 'Spain');
INSERT INTO "public"."mst_country" VALUES ('201', 'LK', 'Sri Lanka');
INSERT INTO "public"."mst_country" VALUES ('202', 'SD', 'Sudan');
INSERT INTO "public"."mst_country" VALUES ('203', 'SR', 'Suriname');
INSERT INTO "public"."mst_country" VALUES ('204', 'SJ', 'Svalbard and Jan Mayen');
INSERT INTO "public"."mst_country" VALUES ('205', 'SZ', 'Swaziland');
INSERT INTO "public"."mst_country" VALUES ('206', 'SE', 'Sweden');
INSERT INTO "public"."mst_country" VALUES ('207', 'CH', 'Switzerland');
INSERT INTO "public"."mst_country" VALUES ('208', 'SY', 'Syrian Arab Republic');
INSERT INTO "public"."mst_country" VALUES ('209', 'TW', 'Taiwan, Province of China');
INSERT INTO "public"."mst_country" VALUES ('210', 'TJ', 'Tajikistan');
INSERT INTO "public"."mst_country" VALUES ('211', 'TZ', 'Tanzania, United Republic of');
INSERT INTO "public"."mst_country" VALUES ('212', 'TH', 'Thailand');
INSERT INTO "public"."mst_country" VALUES ('213', 'TL', 'Timor-Leste');
INSERT INTO "public"."mst_country" VALUES ('214', 'TG', 'Togo');
INSERT INTO "public"."mst_country" VALUES ('215', 'TK', 'Tokelau');
INSERT INTO "public"."mst_country" VALUES ('216', 'TO', 'Tonga');
INSERT INTO "public"."mst_country" VALUES ('217', 'TT', 'Trinidad and Tobago');
INSERT INTO "public"."mst_country" VALUES ('218', 'TN', 'Tunisia');
INSERT INTO "public"."mst_country" VALUES ('219', 'TR', 'Turkey');
INSERT INTO "public"."mst_country" VALUES ('220', 'TM', 'Turkmenistan');
INSERT INTO "public"."mst_country" VALUES ('221', 'TC', 'Turks and Caicos Islands');
INSERT INTO "public"."mst_country" VALUES ('222', 'TV', 'Tuvalu');
INSERT INTO "public"."mst_country" VALUES ('223', 'UG', 'Uganda');
INSERT INTO "public"."mst_country" VALUES ('224', 'UA', 'Ukraine');
INSERT INTO "public"."mst_country" VALUES ('225', 'AE', 'United Arab Emirates');
INSERT INTO "public"."mst_country" VALUES ('226', 'UK', 'United Kingdom');
INSERT INTO "public"."mst_country" VALUES ('227', 'US', 'United States');
INSERT INTO "public"."mst_country" VALUES ('228', 'UM', 'United States Minor Outlying Islands');
INSERT INTO "public"."mst_country" VALUES ('229', 'UY', 'Uruguay');
INSERT INTO "public"."mst_country" VALUES ('230', 'UZ', 'Uzbekistan');
INSERT INTO "public"."mst_country" VALUES ('231', 'VU', 'Vanuatu');
INSERT INTO "public"."mst_country" VALUES ('232', 'VE', 'Venezuela, Bolivarian Republic of');
INSERT INTO "public"."mst_country" VALUES ('233', 'VN', 'Viet Nam');
INSERT INTO "public"."mst_country" VALUES ('234', 'VG', 'Virgin Islands, British');
INSERT INTO "public"."mst_country" VALUES ('235', 'VI', 'Virgin Islands, U.S.');
INSERT INTO "public"."mst_country" VALUES ('236', 'WF', 'Wallis and Futuna');
INSERT INTO "public"."mst_country" VALUES ('237', 'EH', 'Western Sahara');
INSERT INTO "public"."mst_country" VALUES ('238', 'YE', 'Yemen');
INSERT INTO "public"."mst_country" VALUES ('239', 'ZM', 'Zambia');
INSERT INTO "public"."mst_country" VALUES ('240', 'ZW', 'Zimbabwe');
INSERT INTO "public"."mst_country" VALUES ('241', 'TP', 'East Timor');
INSERT INTO "public"."mst_country" VALUES ('242', 'CS', 'Former Czechoslovakia');
INSERT INTO "public"."mst_country" VALUES ('243', 'SU', 'Former USSR');
INSERT INTO "public"."mst_country" VALUES ('244', 'FX', 'France (European Territory)
');
INSERT INTO "public"."mst_country" VALUES ('245', 'GB', 'Great Britain
');
INSERT INTO "public"."mst_country" VALUES ('246', 'CI', 'Ivory Coast (Cote D''Ivoire)
');
INSERT INTO "public"."mst_country" VALUES ('247', 'KP', 'North Korea
');
INSERT INTO "public"."mst_country" VALUES ('248', 'PF', 'Polynesia (French)
');
INSERT INTO "public"."mst_country" VALUES ('249', 'GS', 'S. Georgia & S. Sandwich Isls.
');
INSERT INTO "public"."mst_country" VALUES ('250', 'KR', 'South Korea
');
INSERT INTO "public"."mst_country" VALUES ('251', 'VA', 'Vatican City State
');
INSERT INTO "public"."mst_country" VALUES ('252', 'YU', 'Yugoslavia
');
INSERT INTO "public"."mst_country" VALUES ('253', 'ZR', 'Zaire
');

-- ----------------------------
-- Table structure for mst_cover
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_cover";
CREATE TABLE "public"."mst_cover" (
"id" int8 NOT NULL,
"ext" varchar(255) COLLATE "default",
"filename" varchar(255) COLLATE "default",
"format" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_cover
-- ----------------------------
INSERT INTO "public"."mst_cover" VALUES ('1', 'png', 'a6e6c3ee-ef89-4394-a42b-6ad6fd054039Untitled', 'png', 'image/png');

-- ----------------------------
-- Table structure for mst_director
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_director";
CREATE TABLE "public"."mst_director" (
"id" int8 NOT NULL,
"firstname" varchar(255) COLLATE "default",
"lastname" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_director
-- ----------------------------

-- ----------------------------
-- Table structure for mst_genre
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_genre";
CREATE TABLE "public"."mst_genre" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"movieid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_genre
-- ----------------------------
INSERT INTO "public"."mst_genre" VALUES ('1', 'GN_DOCUMENTARY', 'Documentary', '1');
INSERT INTO "public"."mst_genre" VALUES ('2', 'GN_BIOGRAPHY', 'Biography', '1');

-- ----------------------------
-- Table structure for mst_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_menu";
CREATE TABLE "public"."mst_menu" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"orderno" int4,
"tabname" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"url" varchar(255) COLLATE "default",
"parentcode" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_menu
-- ----------------------------
INSERT INTO "public"."mst_menu" VALUES ('1', 'ROOT', '0', '', '', '', '');
INSERT INTO "public"."mst_menu" VALUES ('3', 'MAINTENANCE', '200000', '', 'Maintenance', '', 'ROOT');
INSERT INTO "public"."mst_menu" VALUES ('13', 'MOVIE', '201000', '', 'Movie', '', 'MAINTENANCE');
INSERT INTO "public"."mst_menu" VALUES ('14', 'MOVIE_CREATE', '201200', 'Movie - Create', 'Create', 'mtnc.movie.create.zul', 'MOVIE');

-- ----------------------------
-- Table structure for mst_movie
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_movie";
CREATE TABLE "public"."mst_movie" (
"id" int8 NOT NULL,
"actors" varchar(255) COLLATE "default",
"directors" varchar(255) COLLATE "default",
"filter" varchar(255) COLLATE "default",
"minute" int4,
"producers" varchar(255) COLLATE "default",
"production" varchar(255) COLLATE "default",
"rating" float8,
"releasedate" timestamp(6),
"releaseyear" varchar(255) COLLATE "default",
"synopsis" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default",
"trailer" varchar(255) COLLATE "default",
"writers" varchar(255) COLLATE "default",
"countryid" int8,
"coverid" int8,
"subtitleid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_movie
-- ----------------------------
INSERT INTO "public"."mst_movie" VALUES ('1', 'sdf', 'eqw', 'A_SU', '23', 'scsxc', 'ewq', '2', '2017-06-01 00:00:00', '2017', 'qwe', 'asd', 'dsa', 'wer', '1', '1', '1');

-- ----------------------------
-- Table structure for mst_movie_file
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_movie_file";
CREATE TABLE "public"."mst_movie_file" (
"id" int8 NOT NULL,
"filename" varchar(255) COLLATE "default",
"format" varchar(255) COLLATE "default",
"quality" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default",
"movieid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_movie_file
-- ----------------------------
INSERT INTO "public"."mst_movie_file" VALUES ('1', 'Create A Simple RESTful API With Golang', 'mp4', 'LOW', 'video/mp4', '1');

-- ----------------------------
-- Table structure for mst_parameter
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_parameter";
CREATE TABLE "public"."mst_parameter" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"value" varchar(255) COLLATE "default",
"categoryid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_parameter
-- ----------------------------
INSERT INTO "public"."mst_parameter" VALUES ('1', 'SUB_ID', 'Subtitle Indonesia', 'Indonesia', '2');
INSERT INTO "public"."mst_parameter" VALUES ('2', 'SUB_EN', 'Subtitle English', 'English', '2');
INSERT INTO "public"."mst_parameter" VALUES ('3', 'VID_IMG_NORMAL', 'Path cover image for videos (Normal size)', 'C:\pokti\cover\normal\', '1');
INSERT INTO "public"."mst_parameter" VALUES ('4', 'GN_ACTION', 'Action', 'Action', '3');
INSERT INTO "public"."mst_parameter" VALUES ('5', 'GN_ADVENTURE', 'Adventure', 'Adventure', '3');
INSERT INTO "public"."mst_parameter" VALUES ('6', 'GN_ANIMATION', 'Animation', 'Animation', '3');
INSERT INTO "public"."mst_parameter" VALUES ('7', 'GN_BIOGRAPHY', 'Biography', 'Biography', '3');
INSERT INTO "public"."mst_parameter" VALUES ('8', 'GN_COMEDY', 'Comedy', 'Comedy', '3');
INSERT INTO "public"."mst_parameter" VALUES ('9', 'GN_CRIME', 'Crime', 'Crime', '3');
INSERT INTO "public"."mst_parameter" VALUES ('10', 'GN_DOCUMENTARY', 'Documentary', 'Documentary', '3');
INSERT INTO "public"."mst_parameter" VALUES ('11', 'GN_DRAMA', 'Drama', 'Drama', '3');
INSERT INTO "public"."mst_parameter" VALUES ('12', 'GN_FAMILY', 'Family', 'Family', '3');
INSERT INTO "public"."mst_parameter" VALUES ('13', 'GN_FANTASY', 'Fantasy', 'Fantasy', '3');
INSERT INTO "public"."mst_parameter" VALUES ('14', 'GN_FILM_NOIR', 'Film-Noir', 'Film-Noir', '3');
INSERT INTO "public"."mst_parameter" VALUES ('15', 'GN_GAME_SHOW', 'Game-Show', 'Game-Show', '3');
INSERT INTO "public"."mst_parameter" VALUES ('16', 'GN_HISTORY', 'History', 'History', '3');
INSERT INTO "public"."mst_parameter" VALUES ('17', 'GN_HORROR', 'Horror', 'Horror', '3');
INSERT INTO "public"."mst_parameter" VALUES ('18', 'GN_MUSIC', 'Music', 'Music', '3');
INSERT INTO "public"."mst_parameter" VALUES ('19', 'GN_MUSICAL', 'Musical', 'Musical', '3');
INSERT INTO "public"."mst_parameter" VALUES ('20', 'GN_MYSTERY', 'Mystery', 'Mystery', '3');
INSERT INTO "public"."mst_parameter" VALUES ('21', 'GN_NEWS', 'News', 'News', '3');
INSERT INTO "public"."mst_parameter" VALUES ('22', 'GN_REALITY_TV', 'Reality-TV', 'Reality-TV', '3');
INSERT INTO "public"."mst_parameter" VALUES ('23', 'GN_ROMANCE', 'Romance', 'Romance', '3');
INSERT INTO "public"."mst_parameter" VALUES ('24', 'GN_SCI_FI', 'Sci-Fi', 'Sci-Fi', '3');
INSERT INTO "public"."mst_parameter" VALUES ('25', 'GN_SERIAL', 'Serial', 'Serial', '3');
INSERT INTO "public"."mst_parameter" VALUES ('26', 'GN_SPORT', 'Sport', 'Sport', '3');
INSERT INTO "public"."mst_parameter" VALUES ('27', 'GN_TALK_SHOW', 'Talk-Show', 'Talk-Show', '3');
INSERT INTO "public"."mst_parameter" VALUES ('28', 'GN_THRILLER', 'Thriller', 'Thriller', '3');
INSERT INTO "public"."mst_parameter" VALUES ('29', 'GN_WAR', 'War', 'War', '3');
INSERT INTO "public"."mst_parameter" VALUES ('30', 'GN_WESTERN', 'Western', 'Western', '3');
INSERT INTO "public"."mst_parameter" VALUES ('31', 'GN_ZOMBIES', 'Zombies', 'Zombies', '3');
INSERT INTO "public"."mst_parameter" VALUES ('32', 'VID_IMG_TINY', 'Path cover image for videos (Tiny size)', 'C:\pokti\cover\tiny\', '1');
INSERT INTO "public"."mst_parameter" VALUES ('33', 'VID_IMG_SMALL', 'Path cover image for videos (Small size)', 'C:\pokti\cover\small\', '1');
INSERT INTO "public"."mst_parameter" VALUES ('34', 'VID_IMG_MEDIUM', 'Path cover image for videos (Medium size)', 'C:\pokti\cover\medium\', '1');

-- ----------------------------
-- Table structure for mst_parameter_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_parameter_category";
CREATE TABLE "public"."mst_parameter_category" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_parameter_category
-- ----------------------------
INSERT INTO "public"."mst_parameter_category" VALUES ('1', 'IMAGE_PATH', 'Image Path', 'SYSTEM');
INSERT INTO "public"."mst_parameter_category" VALUES ('2', 'MOVIE_SUBTITLE', 'Subtitle', 'BUSINESS');
INSERT INTO "public"."mst_parameter_category" VALUES ('3', 'MOVIE_GENRE', 'Genre', 'BUSINESS');
INSERT INTO "public"."mst_parameter_category" VALUES ('4', 'VIDEO_PATH', 'Video Path', 'SYSTEM');

-- ----------------------------
-- Table structure for mst_state
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_state";
CREATE TABLE "public"."mst_state" (
"id" int8 NOT NULL,
"code" varchar(255) COLLATE "default",
"name" varchar(255) COLLATE "default",
"countryid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_state
-- ----------------------------

-- ----------------------------
-- Table structure for mst_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_user";
CREATE TABLE "public"."mst_user" (
"id" int8 NOT NULL,
"active" bool,
"banned" bool,
"bio" varchar(255) COLLATE "default",
"createdtime" timestamp(6),
"email" varchar(255) COLLATE "default",
"enabled" int4,
"firstname" varchar(255) COLLATE "default",
"gender" varchar(255) COLLATE "default",
"lastlogindate" timestamp(6),
"lastloginfailed" timestamp(6),
"lastname" varchar(255) COLLATE "default",
"locked" bool NOT NULL,
"loginattempt" int4,
"logindate" timestamp(6),
"logoutdate" timestamp(6),
"mobilephone" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default",
"remoteaddress" varchar(255) COLLATE "default",
"remotehost" varchar(255) COLLATE "default",
"session" varchar(255) COLLATE "default",
"special" bool,
"token" varchar(255) COLLATE "default",
"updatedtime" timestamp(6),
"username" varchar(255) COLLATE "default",
"uuid" varchar(255) COLLATE "default" NOT NULL,
"roleid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_user
-- ----------------------------
INSERT INTO "public"."mst_user" VALUES ('1', 't', 'f', '-', '2017-02-04 17:35:10', 'admin@gmail.com', '1', 'Admin', 'MALE', '2017-02-18 19:49:52', '2017-02-18 19:49:52', '-', 'f', '1', '2017-06-01 18:28:20.211', '2017-05-01 16:52:28.476', '08191123470', '$2a$10$jxZ70Ucxr4ByXH6Fh6n/JOBajP0r2jiFtH8ZV1IOU.rFUAfSw/eAC', '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', 'D1822890049D05D8B8DA7E43A8E71319', 't', 'example123', '2017-04-29 14:15:22', 'admin', '123', '1');

-- ----------------------------
-- Table structure for mst_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_user_role";
CREATE TABLE "public"."mst_user_role" (
"id" int8 NOT NULL,
"role" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_user_role
-- ----------------------------
INSERT INTO "public"."mst_user_role" VALUES ('1', 'ROLE_SUPER_ADMIN');
INSERT INTO "public"."mst_user_role" VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for mst_writer
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_writer";
CREATE TABLE "public"."mst_writer" (
"id" int8 NOT NULL,
"first_name" varchar(255) COLLATE "default",
"last_name" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_writer
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table mst_actor
-- ----------------------------
ALTER TABLE "public"."mst_actor" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_city
-- ----------------------------
ALTER TABLE "public"."mst_city" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_country
-- ----------------------------
ALTER TABLE "public"."mst_country" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_cover
-- ----------------------------
ALTER TABLE "public"."mst_cover" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_director
-- ----------------------------
ALTER TABLE "public"."mst_director" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_genre
-- ----------------------------
ALTER TABLE "public"."mst_genre" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table mst_menu
-- ----------------------------
ALTER TABLE "public"."mst_menu" ADD UNIQUE ("code");

-- ----------------------------
-- Primary Key structure for table mst_menu
-- ----------------------------
ALTER TABLE "public"."mst_menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table mst_movie
-- ----------------------------
ALTER TABLE "public"."mst_movie" ADD UNIQUE ("title");

-- ----------------------------
-- Primary Key structure for table mst_movie
-- ----------------------------
ALTER TABLE "public"."mst_movie" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_movie_file
-- ----------------------------
ALTER TABLE "public"."mst_movie_file" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_parameter
-- ----------------------------
ALTER TABLE "public"."mst_parameter" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_parameter_category
-- ----------------------------
ALTER TABLE "public"."mst_parameter_category" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_state
-- ----------------------------
ALTER TABLE "public"."mst_state" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table mst_user
-- ----------------------------
ALTER TABLE "public"."mst_user" ADD UNIQUE ("email");
ALTER TABLE "public"."mst_user" ADD UNIQUE ("username");
ALTER TABLE "public"."mst_user" ADD UNIQUE ("uuid");

-- ----------------------------
-- Primary Key structure for table mst_user
-- ----------------------------
ALTER TABLE "public"."mst_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_user_role
-- ----------------------------
ALTER TABLE "public"."mst_user_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mst_writer
-- ----------------------------
ALTER TABLE "public"."mst_writer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."mst_city"
-- ----------------------------
ALTER TABLE "public"."mst_city" ADD FOREIGN KEY ("stateid") REFERENCES "public"."mst_state" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_genre"
-- ----------------------------
ALTER TABLE "public"."mst_genre" ADD FOREIGN KEY ("movieid") REFERENCES "public"."mst_movie" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_movie"
-- ----------------------------
ALTER TABLE "public"."mst_movie" ADD FOREIGN KEY ("subtitleid") REFERENCES "public"."mst_parameter" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."mst_movie" ADD FOREIGN KEY ("countryid") REFERENCES "public"."mst_country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."mst_movie" ADD FOREIGN KEY ("coverid") REFERENCES "public"."mst_cover" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_movie_file"
-- ----------------------------
ALTER TABLE "public"."mst_movie_file" ADD FOREIGN KEY ("movieid") REFERENCES "public"."mst_movie" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_parameter"
-- ----------------------------
ALTER TABLE "public"."mst_parameter" ADD FOREIGN KEY ("categoryid") REFERENCES "public"."mst_parameter_category" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_state"
-- ----------------------------
ALTER TABLE "public"."mst_state" ADD FOREIGN KEY ("countryid") REFERENCES "public"."mst_country" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."mst_user"
-- ----------------------------
ALTER TABLE "public"."mst_user" ADD FOREIGN KEY ("roleid") REFERENCES "public"."mst_user_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
