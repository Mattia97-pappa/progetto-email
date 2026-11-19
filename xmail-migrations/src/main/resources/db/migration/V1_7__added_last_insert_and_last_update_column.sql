ALTER TABLE customers
ADD COLUMN  last_insert TIMESTAMP;

ALTER TABLE customers
    ADD COLUMN  last_update TIMESTAMP;

UPDATE customers
SET last_insert = '2026-11-19 19:10:25-07',
    last_update ='2026-11-19 19:10:25-07'
    where last_insert is null and last_update is null;

CREATE  FUNCTION set_last_update_date_update()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.last_update := NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE trigger update_last_update_date_after_update
    BEFORE UPDATE ON customers
    FOR EACH ROW
    EXECUTE FUNCTION set_last_update_date_update();