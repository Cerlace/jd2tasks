CREATE TABLE IF NOT EXISTS shelters
(
    shelter_id   int auto_increment
        primary key,
    shelter_name varchar(255) not null,
    location     varchar(255) null
);

CREATE TABLE IF NOT EXISTS animals
(
    animal_id   int auto_increment
        primary key,
    animal_name varchar(255) null,
    species     varchar(255) not null,
    shelter_id  int          null,
    constraint animals_shelters_fk
        foreign key (shelter_id) references shelters (shelter_id)
);

CREATE TABLE IF NOT EXISTS adoptions
(
    adoption_id   int auto_increment
        primary key,
    animal_id     int          not null,
    adopter_name  varchar(255) not null,
    adoption_date date         not null,
    constraint adoptions_animals_fk
        foreign key (animal_id) references animals (animal_id)
);

