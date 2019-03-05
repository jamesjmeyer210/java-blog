USE jamesblog_db;

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE users;
TRUNCATE TABLE posts;
TRUNCATE TABLE tags;

INSERT INTO users (email, password, username)
VALUES ("9b0989da44-2970db@inbox.mailtrap.io", "password123", "admin");

INSERT INTO tags (name)
VALUES ("computer science"),
       ("programming"),
       ("software engineering"),
       ("Java"),
       ("C"),
       ("Javascript"),
       ("SQL"),
       ("MYSQL"),
       ("HTML"),
       ("CSS"),
       ("Rust");

INSERT INTO posts (user_id, title, content)
VALUES ("1", "Lorem ipsum dolor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer semper facilisis lorem vitae iaculis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sit amet arcu sed metus commodo porta. In nec finibus lacus, id tristique odio. Duis laoreet eu lorem ac euismod. Pellentesque vitae orci feugiat, feugiat nulla nec, molestie sapien. Aliquam maximus quam sit amet lacus pulvinar, sit amet varius lectus tempor. Morbi lobortis mattis leo, et tristique arcu blandit non. Vestibulum rutrum vulputate eros, vitae volutpat ante facilisis et. Integer et libero mattis, sagittis sem eu, tristique velit. Nullam vitae erat metus. Aenean facilisis enim eget orci aliquet, consequat finibus dui dapibus. Sed vitae tellus sapien. Suspendisse ultrices non neque vel commodo."),
       ("1", "Morbi pretium vehicula","Nam vulputate vehicula lacus eget luctus. Maecenas gravida nunc quis egestas mattis. Quisque consequat placerat ultrices. Vivamus sed suscipit diam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla eleifend nec ipsum ac imperdiet. Quisque odio est, varius at dignissim sed, euismod ac tortor. In hac habitasse platea dictumst. Aliquam porta, libero non tincidunt consectetur, justo diam faucibus lectus, at ullamcorper nisl metus id velit. Sed congue lectus non erat aliquet rutrum. Nullam commodo ultricies sagittis. Phasellus id nibh et nisi imperdiet volutpat et et nulla. In mattis, sem eu eleifend eleifend, purus diam pretium orci, in convallis neque lectus sit amet diam. Donec hendrerit pharetra neque, quis rhoncus metus imperdiet sit amet. Integer gravida tincidunt libero, a vehicula augue dignissim in. Donec vestibulum, orci id congue efficitur, arcu felis dignissim mauris, eu blandit mauris libero id nulla."),
       ("1", "Ipsum dolor sit amet","Donec volutpat sit amet neque quis fringilla. Duis cursus justo consectetur, pulvinar velit non, ornare lorem. Proin et ligula ac ligula hendrerit elementum. Maecenas finibus rhoncus justo eget feugiat. Sed congue turpis dignissim blandit sodales. Proin quam lorem, tempor sit amet nibh et, egestas semper ante. Curabitur sed dignissim lorem, id pulvinar libero. Suspendisse at odio id ante facilisis efficitur. Donec in enim dignissim, ultricies diam in, auctor odio."),
       ("1", "Praesent ornare","Aenean vitae est condimentum arcu maximus accumsan. Etiam finibus varius magna sed porttitor. Aenean condimentum dignissim massa quis porta. Aliquam erat volutpat. Praesent luctus, odio non pretium dapibus, elit felis aliquet libero, eu placerat augue libero sodales orci. Aliquam quis ligula velit. Sed convallis quis nisl id iaculis. Maecenas pellentesque, turpis vitae iaculis gravida, nisi metus pharetra nibh, eu eleifend dui leo vel enim. Integer nibh ipsum, suscipit sed velit sit amet, rutrum volutpat mi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae lacus semper, tincidunt ligula at, mollis erat. Duis mollis ipsum sed pretium elementum.");

INSERT INTO posts_tags (post_id, tag_id)
VALUES (1, 2),
       (1, 3),
       (1, 5),
       (2, 2),
       (2, 4),
       (2, 6),
       (3, 3),
       (3, 6),
       (3, 9),
       (4, 10),
       (4, 5);

SET FOREIGN_KEY_CHECKS = 1;