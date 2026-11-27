ALTER TABLE advertising_typology
    ADD COLUMN active BOOLEAN DEFAULT TRUE NOT NULL,
ADD COLUMN  last_insert TIMESTAMP,
ADD COLUMN  last_update TIMESTAMP;

UPDATE advertising_typology
SET last_insert = '2026-11-19 19:10:25-07',
    last_update ='2026-11-19 19:10:25-07'
where last_insert is null
  and last_update is null;

CREATE trigger update_last_update_date_after_update
    BEFORE UPDATE
    ON advertising_typology
    FOR EACH ROW
    EXECUTE FUNCTION set_last_update_date_update();


CREATE trigger set_last_insert_and_last_update
    BEFORE INSERT
    ON advertising_typology
    FOR EACH ROW
    EXECUTE FUNCTION set_last_insert_and_last_update_fun();



ALTER TABLE advertising_campaign
ADD COLUMN  last_insert TIMESTAMP,
ADD COLUMN  last_update TIMESTAMP;


UPDATE advertising_campaign
SET last_insert = '2026-11-19 19:10:25-07',
    last_update ='2026-11-19 19:10:25-07'
where last_insert is null
  and last_update is null;

CREATE trigger update_last_update_date_after_update
    BEFORE UPDATE
    ON advertising_campaign
    FOR EACH ROW
    EXECUTE FUNCTION set_last_update_date_update();


CREATE trigger set_last_insert_and_last_update
    BEFORE INSERT
    ON advertising_campaign
    FOR EACH ROW
    EXECUTE FUNCTION set_last_insert_and_last_update_fun();