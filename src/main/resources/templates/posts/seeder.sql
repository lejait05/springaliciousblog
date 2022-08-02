use springblog_db;

insert into post (id, title, body) VALUE
    (1, 'The Last Straw','One day the camel just had enough. That was the day that the last straw was put on the camels back.'),
    (2, 'I Want to Be Free!!!!','Please help me. I want to be free. I am tired of being locked in this place some call home. I call it HELL. There is no way out. There is no way in. How did I even get here? I just want to be free.'),
    (3, 'Trying Again', 'One day i will try again . One day i will get it right. will it be today?');

insert into users(id, username, email,password) VALUE
    (1,'bob','bob@123','hello'),
    (2,'admin','lineishagibson@gmail.com','$2a$12$5uEPkAEW08T2x0dGnUJXDuL.zdQb7YnbpjcEt9vIycrqxfCHYoDEK'),
    (3,'jack','jack@email.com','$2a$12$lGma5xwVu9/aD8fu58TqY.Ha0GKdBUULqrEPd0FGeutzHbrEb552');
