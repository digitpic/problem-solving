SELECT member_id, member_name, gender, to_char(date_of_birth, 'YYYY-MM-DD') AS date_of_birth
FROM member_profile
WHERE gender = 'W' AND to_char(date_of_birth, 'MM')=03 AND tlno IS NOT NULL
ORDER BY member_id ASC;