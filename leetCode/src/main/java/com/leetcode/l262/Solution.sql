SELECT  t.Request_at AS 'Day' ,
ROUND(Count(IF(t.Status like 'cancelled%',1,null))/ Count(*),2) AS 'Cancellation Rate'  

FROM Trips t where t.Request_at between '2013-10-01' and '2013-10-03'
and t.Client_Id IN (SELECT Users_Id FROM Users where Banned ='No')
GROUP BY t.Request_at

# SELECT  t.Request_at , Count(IF(t.Status like 'cancelled%',1,null)) AS cancelledCount,count(*) AS totalCount  FROM Trips t
# GROUP BY t.Request_at

# SELECT t.Request_at,count(IF(t.Status like 'cancelled%',1,null)) AS 'Cancellation Rate'  ,count(*) 
# FROM Trips t where t.Request_at between '2013-10-01' and '2013-10-03'
# and t.Client_Id IN (SELECT Users_Id FROM Users where Banned ='No')
# GROUP BY t.Request_at
