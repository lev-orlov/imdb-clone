insert into user_account (id, login, password)
    values (1, 'admin@admin.ad', '$2a$08$jygv5kLQ9XSdZU93EikAFOzmzeyHCkPNY6OKxxAfYi6/77wL5LdOW');

insert into user_role (user_id, authorities)
    values (1, 'USER'), (1, 'ADMIN');
