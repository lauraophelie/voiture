-- Marque --
INSERT INTO marque VALUES (default,'Mercedes');
INSERT INTO marque VALUES (default,'Audi');
INSERT INTO marque VALUES (default,'Tesla');
INSERT INTO marque VALUES (default,'Citroen');
-- type energie --
INSERT INTO type_energie VALUES (default,'gasoil');
INSERT INTO type_energie VALUES (default,'super sans plomb');
INSERT INTO type_energie VALUES (default,'electricite');
INSERT INTO type_energie VALUES (default,'premium');
-- categorie --
INSERT INTO categorie VALUES (default,'sport');
-- boite de vitesse --
INSERT INTO boite_vitesse VALUES (default,'4 vitesses avant');
INSERT INTO boite_vitesse VALUES (default,'5 vitesses avant');
INSERT INTO boite_vitesse VALUES (default,'automatique');
-- modele --
INSERT INTO modele VALUES (default,'classe S',1);
INSERT INTO modele VALUES (default,'R8',2);
INSERT INTO modele VALUES (default,'F100D',3);
INSERT INTO modele VALUES (default,'C4',4);
-- admin --
INSERT INTO admin VALUES (default,'admin','admin','0',1);
INSERT INTO admin VALUES (default,'user','user','1',0);
-- lieu --
INSERT INTO lieu VALUES (default,'Ankorondrano');
INSERT INTO lieu VALUES (default,'Andoharanofotsy');
-- voiture --
INSERT INTO voiture VALUES (default,5,5,240,1,1,2,1,2);
-- annonce --
INSERT INTO annonce VALUES (default,'2023-12-12 12:07:15','Vente mercedes','voiture legere',50000,2,'Teddy',1,0,0);

select * from admin;
select * from marque;
select * from type_energie;
select * from boite_vitesse;
select * from modele;
select * from v_modele;

INSERT INTO caracteristique_modele(id_modele, id_categorie, id_type_vitesse, id_energie) VALUES
                                (1, 1, 1, 1),
                                (1, 1, 2, 1),
                                (1, 1, 3, 2);

