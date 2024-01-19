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
-- II part
CREATE TABLE lieu(
    id SERIAL PRIMARY KEY,
    nom_lieu TEXT
);

CREATE TABLE voiture(
    id SERIAL PRIMARY KEY,
    nombre_place INT,
    nombre_porte INT,
    kilometrage DOUBLE PRECISION,
    id_marque INT,
    id_modele INT,
    id_energie INT,
    id_categorie INT,
    id_vitesse INT,
    FOREIGN KEY (id_marque) REFERENCES marque(id),
    FOREIGN KEY (id_modele) REFERENCES modele(id),
    FOREIGN KEY (id_energie) REFERENCES type_energie(id),
    FOREIGN KEY (id_categorie) REFERENCES categorie(id),
    FOREIGN KEY (id_vitesse) REFERENCES boite_vitesse(id)
);

CREATE TABLE annonce(
    id SERIAL PRIMARY KEY,
    date_heure TIMESTAMP,
    titre TEXT,
    description TEXT,
    prix_vente DOUBLE PRECISION,
    lieu INT,
    proprietaire TEXT NOT NULL,
    id_voiture INT,
    etat INT,
    status INT,
    FOREIGN KEY (lieu) REFERENCES lieu(id),
    FOREIGN KEY (id_voiture) REFERENCES voiture(id)
);

CREATE TABLE details_annonce(
    id SERIAL PRIMARY KEY,
    id_annonce INT,
    image1 BYTEA,
    image2 BYTEA,
    image3 BYTEA,
    image4 BYTEA,
    FOREIGN KEY (id_annonce) REFERENCES annonce (id)
);

CREATE TABLE validation_annonce(
    date_heure_validation TIMESTAMP,
    id_admin INT,
    id_annonce INT,
    FOREIGN KEY (id_annonce) REFERENCES annonce (id),
    FOREIGN KEY (id_admin) REFERENCES admin(id)
);

CREATE TABLE favori_annonce(
    id SERIAL PRIMARY KEY,
    id_annonce INT,
    id_utilisateur TEXT NOT NULL,
    FOREIGN KEY (id_annonce) REFERENCES annonce (id)
);