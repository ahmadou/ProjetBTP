CREATE TABLE `btp2014`.`adm_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identifiant` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `date_creation` DATETIME NULL,
  PRIMARY KEY (`id`))
COMMENT = 'table des utilisateurs';

CREATE TABLE `btp2014`.`adm_roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libelle` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'L ensemble des roles possibles pour un utilisateur';


CREATE TABLE `btp2014`.`adm_users_roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `btp2014`.`adm_users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `btp2014`.`adm_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);