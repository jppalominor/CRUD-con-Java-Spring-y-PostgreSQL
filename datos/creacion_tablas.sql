create table autobuses (
	id serial not null
		constraint autobuses_pk primary key,
	placa varchar(7) not null,
	modelo int not null	
	);
	
comment on table autobuses is 'Listado de autobuses';
comment on column autobuses.id is 'Id del autobus';
comment on column autobuses.placa is 'Placa del autobus';
comment on column autobuses.modelo is 'Modelo del autobus';

create table cargadores (
	id serial not null
		constraint cargadores_pk primary key
);

comment on table cargadores is 'Listado de cargadores';
comment on column cargadores.id is 'Id del cargador';


create table horarios (
	hora int not null
		constraint horarios_pk primary key
);

comment on table horarios is 'Horarios de operación';
comment on column horarios.hora is 'Hora del día';

create table horario_cargadores (
	hora_id int not null
		constraint id_hora_fk references horarios,
	cargador_id int not null
		constraint id_cargador_fk references cargadores,
	autobus_id int not null
		constraint id_autobus_fk references autobuses
);
comment on table horario_cargadores is 'Programacion uso de cargadores';
comment on column horario_cargadores.hora_id is 'Hora del día';
comment on column horario_cargadores.cargador_id is 'Id del cargador';
comment on column horario_cargadores.autobus_id is 'Id del autobus';

create table horario_autobuses (
	autobus_id int not null
		constraint horario_autobus_pk references autobuses,
	hora_id int not null
		constraint horario_autobus_hora_pk references horarios
);
comment on table horario_autobuses is 'Programacion de autobuses';
comment on column horario_autobuses.autobus_id is 'Id del autobus';
comment on column horario_autobuses.hora_id is 'Hora del día';