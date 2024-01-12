DROP DATABASE voiture;

CREATE DATABASE voiture;

\c voiture;

CREATE TABLE marque(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(30)
);

CREATE TABLE type_energie(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(30)
);

CREATE TABLE boite_vitesse(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(30)
);

CREATE TABLE categorie(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(30)
);

CREATE TABLE modele(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(30),
    idmarque int,
    FOREIGN KEY (idmarque) REFERENCES marque(id)
);

CREATE OR REPLACE VIEW v_modele AS 
SELECT m.nom as modele,m.id as idmodele,ma.id as idmarque,ma.nom as marque FROM modele AS m 
JOIN marque AS ma ON m.idmarque = ma.id;

CREATE TABLE caracteristique_modele(
    id_modele INT,
    id_categorie INT,
    id_type_vitesse INT,
    id_energie INT,
    FOREIGN KEY (id_modele) REFERENCES modele(id),
    FOREIGN KEY (id_categorie) REFERENCES categorie(id),
    FOREIGN KEY (id_type_vitesse) REFERENCES boite_vitesse(id),
    FOREIGN KEY (id_energie) REFERENCES type_energie(id)
);

CREATE TABLE admin (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50),
    isadmin int 
);


