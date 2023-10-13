--Procedimientos almacenados

create or replace function f_programar_autobus(p_hora int, p_autobus int)
returns void language plpgsql AS 
$$
BEGIN
insert into horario_autobuses
 values (p_autobus,p_hora);
END
$$;

create or replace function f_programar_cargador(p_hora int, p_cargador int, p_autobus int)
returns void language plpgsql AS 
$$
BEGIN
insert into horario_cargadores
 values (p_hora,p_cargador,p_autobus);
END
$$;
