CREATE OR REPLACE VIEW v_modele AS 
SELECT m.nom AS modele,m.id AS idmodele,ma.id AS idmarque,ma.nom AS marque FROM modele AS m 
JOIN marque AS ma ON m.idmarque = ma.id;
-- recherche multi annonce : nom-marque-modele-type_energie-boite_vitesse-lieu-prix(min-max)-kilometrage-(min-max)-date_annonce
CREATE OR REPLACE VIEW v_annonce AS 
SELECT a.id as idannonce,a.titre AS nom,a.description,a.proprietaire,a.id_voiture,a.lieu AS idlieu,a.etat,m.nom AS marque,mo.nom AS modele,t.designation AS type_energie,b.designation AS boite_vitesse,l.nom_lieu AS lieu,a.prix_vente AS prix,v.kilometrage,a.date_heure
FROM annonce AS a
JOIN voiture AS v ON a.id_voiture = v.id
JOIN lieu AS l ON a.lieu = l.id
JOIN marque AS m ON v.id_marque = m.id
JOIN modele AS mo ON v.id_modele = mo.id
JOIN type_energie AS t ON v.id_energie = t.id
JOIN boite_vitesse AS b ON v.id_vitesse = b.id;