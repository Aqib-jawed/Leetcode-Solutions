# Write your MySQL query statement below
SELECT email from Person 
GROUP by email
HAVING COUNT(email) > 1;