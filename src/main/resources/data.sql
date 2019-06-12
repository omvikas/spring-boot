Insert INTO user (user_id,active,email,last_name,fname,password) values (1,1,'om@admin.com','mishra','om','$2a$10$uZJjTwytwKTKALKPzGsbDeV6EkQa.OLjHD8rrOUsnnx4.8D5hDXT6');
Insert INTO role values (1,'ADMIN');
Insert INTO user_role values (1,1);
--Pass is 'demo'
Insert INTO user (user_id,active,email,last_name,fname,password) values (2,1,'om@subscriber.com','mishra','om','$2a$10$uZJjTwytwKTKALKPzGsbDeV6EkQa.OLjHD8rrOUsnnx4.8D5hDXT6');
Insert INTO role values (2,'SUBSCRIBER');
Insert INTO user_role values (2,2);
