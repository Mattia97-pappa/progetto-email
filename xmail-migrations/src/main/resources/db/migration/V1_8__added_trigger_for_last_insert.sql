CREATE  FUNCTION set_last_insert_and_last_update_fun()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.last_insert := NOW();
    NEW.last_update := NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE trigger set_last_insert_and_last_update
    BEFORE INSERT ON customers
    FOR EACH ROW
    EXECUTE FUNCTION set_last_insert_and_last_update_fun();