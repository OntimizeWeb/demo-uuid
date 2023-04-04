CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE locations (
    location_id uuid NOT NULL DEFAULT gen_random_uuid(),
    ref_parent_location_id uuid NULL,
    name varchar(255) NOT NULL,
    description varchar(255) NULL,
    down_date timestamp NULL,
    down_user varchar(255) NULL,
    CONSTRAINT pk_locations PRIMARY KEY (location_id)
);
ALTER TABLE locations ADD CONSTRAINT fk_locations_parent_id FOREIGN KEY (ref_parent_location_id) REFERENCES locations(location_id);

CREATE TABLE tags (
    tag_id uuid NOT NULL DEFAULT gen_random_uuid(),
    name varchar(255) NOT NULL,
    description varchar(255) NULL,
    down_date timestamp NULL,
    down_user varchar(255) NULL,
    CONSTRAINT pk_tags PRIMARY KEY (tag_id)
);

CREATE TABLE location_tags (
    location_tag_id uuid NOT NULL DEFAULT gen_random_uuid(),
    ref_tag_id uuid NOT NULL,
    ref_location_id uuid NOT NULL,
    value bigint NULL,
    down_date timestamp NULL,
    down_user varchar(255) NULL,
    UNIQUE (ref_location_id, value),
    CONSTRAINT pk_location_tags PRIMARY KEY (location_tag_id)
);
ALTER TABLE location_tags ADD CONSTRAINT fk_location_tags_tags FOREIGN KEY (ref_tag_id) REFERENCES tags(tag_id);
ALTER TABLE location_tags ADD CONSTRAINT fk_location_tags_locations FOREIGN KEY (ref_location_id) REFERENCES locations(location_id);
