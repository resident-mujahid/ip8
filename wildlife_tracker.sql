--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: stephenemery
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    endangered character varying,
    health character varying,
    age character varying
);


ALTER TABLE animals OWNER TO stephenemery;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: stephenemery
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO stephenemery;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stephenemery
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: stephenemery
--

CREATE TABLE sightings (
    id integer NOT NULL,
    ranger_name character varying,
    location character varying,
    animal_id integer,
    "timestamp" timestamp without time zone
);


ALTER TABLE sightings OWNER TO stephenemery;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: stephenemery
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO stephenemery;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: stephenemery
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: stephenemery
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: stephenemery
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: stephenemery
--

COPY animals (id, name, endangered, health, age) FROM stdin;
1	Spotted Owl	yes	ill	newborn
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stephenemery
--

SELECT pg_catalog.setval('animals_id_seq', 1, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: stephenemery
--

COPY sightings (id, ranger_name, location, animal_id, "timestamp") FROM stdin;
1	Henry	Zone A	1	2016-09-30 17:40:33.58667
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: stephenemery
--

SELECT pg_catalog.setval('sightings_id_seq', 1, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: stephenemery
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: stephenemery
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: stephenemery
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM stephenemery;
GRANT ALL ON SCHEMA public TO stephenemery;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

