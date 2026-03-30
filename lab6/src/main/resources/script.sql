create table genres (
   id   serial primary key,
   name varchar(100) not null
);

create table movies (
   id           serial primary key,
   title        varchar(255) not null,
   release_date date,
   duration     integer,
   score        float,
   genre_id     integer
      references genres ( id )
);

create table actors (
   id   serial primary key,
   name varchar(255) not null
);

create table movie_actors (
   movie_id integer
      references movies ( id ),
   actor_id integer
      references actors ( id ),
   primary key ( movie_id,
                 actor_id )
);