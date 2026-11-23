CREATE table advertising_typology (

    typology_id SERIAL primary key,
    typology_name varchar(50),
    typology_description varchar(100)

);

INSERT INTO advertising_typology (typology_name, typology_description)
VALUES ('electric cars','advertising promotions for electric cars'),
       ('diesel car','advertising promotions for diesel cars');


CREATE TABLE advertising_campaign (

    advertising_id SERIAL primary key,
    advertising_uuid UUID NOT NULL,
    advertising_campaign_type int,
    advertising_campaign_name varchar(150),
    advertising_campaign_desc TEXT,
    advertising_campaign_start DATE,
    advertising_campaign_end DATE,

    CONSTRAINT fk_advertising_typology
    FOREIGN KEY (advertising_campaign_type)
    REFERENCES advertising_typology(typology_id)

);