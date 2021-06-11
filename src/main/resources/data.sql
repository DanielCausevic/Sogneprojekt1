/*CREATE TABLE commune (
    name varchar(50) not null primary key

);

CREATE TABLE parish (
                        code int(50) not null,
                        name varchar(50) not null ,
                        commune varchar(50) not null,
                        infectionPressure int(2) not null,
                        startOfLockdown DATE not null,
                        foreign key(commune) references commune(name)
);

*/
INSERT INTO commune (NAME, AVERAGE_INFECTION_PRESSURE) VALUES ('Københavns Kommune', 0);
INSERT INTO commune (NAME, AVERAGE_INFECTION_PRESSURE) VALUES ('Frederikshavn Kommune', 0);
INSERT INTO parish (CODE, NAME, COMMUNE, INFECTION_PRESSURE, START_OF_LOCKDOWN) VALUES (7004, 'Sankt Andreas Sogn', 1, 2.7, '2021-05-05');
INSERT INTO parish (CODE, NAME, COMMUNE, INFECTION_PRESSURE, START_OF_LOCKDOWN) VALUES (7001, 'Vor Frue Sogn', 1, 1.2, null);
INSERT INTO parish (CODE, NAME, COMMUNE, INFECTION_PRESSURE, START_OF_LOCKDOWN) VALUES (9346, 'Sankt Petri Tyske Menighed', 1, 2.2, null);
INSERT INTO parish (CODE, NAME, COMMUNE, INFECTION_PRESSURE, START_OF_LOCKDOWN) VALUES (6116, 'Jerup Kirkedistrikt', 2, 3.2, '2021-06-11');
INSERT INTO parish (CODE, NAME, COMMUNE, INFECTION_PRESSURE, START_OF_LOCKDOWN) VALUES (8430, 'Elling Sogn', 2, 1.5, null);