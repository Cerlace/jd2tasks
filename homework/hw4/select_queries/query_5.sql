SELECT s.shelter_name, COUNT(a.animal_id) as animal_count
FROM shelters as s
         LEFT JOIN animals as a on s.shelter_id = a.shelter_id
GROUP BY s.shelter_id;