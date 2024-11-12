SELECT a.animal_id, a.animal_name, a.species, s.shelter_name
FROM animals as a
         LEFT JOIN shelters as s on s.shelter_id = a.shelter_id;