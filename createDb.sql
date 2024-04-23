CREATE DATABASE surfoudb
    WITH
    OWNER = "surfouAdmin"
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE EXTENSION postgis;