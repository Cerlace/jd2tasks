SELECT anim.animal_id, anim.animal_name, 'Yes' as adopted
FROM animals as anim
         INNER JOIN adoptions as adopt on anim.animal_id = adopt.animal_id
UNION
SELECT anim.animal_id, anim.animal_name, 'No' as adopted
FROM animals as anim
         LEFT JOIN adoptions as adopt on anim.animal_id = adopt.animal_id
WHERE adopt.animal_id IS NULL
ORDER BY animal_id;

# Второй вариант без объединения таблиц:
SELECT animal_id,
       animal_name,
       CASE
           WHEN shelter_id IS NULL THEN 'Yes'
           ELSE 'No'
           END AS 'adopted'
FROM animals;