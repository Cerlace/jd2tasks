SELECT s.shelter_id, s.shelter_name, s.location, a.animal_name
FROM animals as a
         RIGHT JOIN shelters as s on s.shelter_id = a.shelter_id;