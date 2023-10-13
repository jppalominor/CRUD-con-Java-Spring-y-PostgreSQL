--Usamos postgres en docker y pgadmin, nos conectamos con el usuario 'postgres' y ejecutamos:

create database gestion_tpe;
create user usuario1 with encrypted password 'jp123';
grant connect on database gestio_tpe to usuario1;
grant usage, create on schema public to usuario1;
grant select, insert, update, delete on all tables in schema public to usuario1;
alter default privileges in schema public grant select, insert, update, delete on tables to usuario1;