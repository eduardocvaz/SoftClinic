--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1 (Ubuntu 14.1-1.pgdg21.04+1)
-- Dumped by pg_dump version 14.1 (Ubuntu 14.1-1.pgdg21.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: SoftClinic; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SoftClinic" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'pt_BR.UTF-8';


ALTER DATABASE "SoftClinic" OWNER TO postgres;

\connect "SoftClinic"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: administrador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.administrador (
    nome character varying(15) NOT NULL,
    sobrenome character varying(15) NOT NULL,
    cpf character varying(45) NOT NULL,
    data_nascimento timestamp(0) without time zone NOT NULL,
    telefone character varying(15) NOT NULL,
    sexo character varying(1),
    numeroctps integer
);


ALTER TABLE public.administrador OWNER TO postgres;

--
-- Name: atendente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atendente (
    nome character varying(15) NOT NULL,
    sobrenome character varying(15) NOT NULL,
    cpf character varying(45) NOT NULL,
    data_nascimento timestamp(0) without time zone NOT NULL,
    telefone character varying(15) NOT NULL,
    sexo character varying(1),
    numeroctps integer
);


ALTER TABLE public.atendente OWNER TO postgres;

--
-- Name: consulta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consulta (
    atendente_cpf character varying(45) NOT NULL,
    idconsulta integer NOT NULL,
    horario time(0) without time zone,
    dia date,
    medico_cpf character varying(45) NOT NULL,
    paciente_cpf character varying(45) NOT NULL
);


ALTER TABLE public.consulta OWNER TO postgres;

--
-- Name: consulta_idconsulta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consulta_idconsulta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consulta_idconsulta_seq OWNER TO postgres;

--
-- Name: consulta_idconsulta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consulta_idconsulta_seq OWNED BY public.consulta.idconsulta;


--
-- Name: exame; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exame (
    idexame integer NOT NULL,
    resultado character varying(500),
    tipo character varying(45),
    sigiloso boolean
);


ALTER TABLE public.exame OWNER TO postgres;

--
-- Name: exame_idexame_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exame_idexame_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exame_idexame_seq OWNER TO postgres;

--
-- Name: exame_idexame_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exame_idexame_seq OWNED BY public.exame.idexame;


--
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    nome character varying(15) NOT NULL,
    sobrenome character varying(15) NOT NULL,
    cpf character varying(45) NOT NULL,
    data_nascimento timestamp(0) without time zone NOT NULL,
    telefone character varying(15) NOT NULL,
    sexo character varying(1),
    cr character varying(10),
    especialidade character varying(45),
    numeroctps integer
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    nome character varying(15) NOT NULL,
    sobrenome character varying(15) NOT NULL,
    cpf character varying(45) NOT NULL,
    data_nascimento timestamp(0) without time zone NOT NULL,
    telefone character varying(15) NOT NULL,
    sexo character varying(1)
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- Name: paciente_alergia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente_alergia (
    tipo character varying(45),
    reacao character varying(45),
    causador character varying(45),
    nivel character varying(45),
    id_paciente_alergia integer NOT NULL
);


ALTER TABLE public.paciente_alergia OWNER TO postgres;

--
-- Name: paciente_alergia_id_paciente_alergia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_alergia_id_paciente_alergia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paciente_alergia_id_paciente_alergia_seq OWNER TO postgres;

--
-- Name: paciente_alergia_id_paciente_alergia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_alergia_id_paciente_alergia_seq OWNED BY public.paciente_alergia.id_paciente_alergia;


--
-- Name: prontuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prontuario (
    id integer NOT NULL,
    paciente_cpf character varying(45) NOT NULL,
    tiposanguineo character varying(45),
    observacao character varying(255),
    id_exame integer,
    id_paciente_alergia integer
);


ALTER TABLE public.prontuario OWNER TO postgres;

--
-- Name: prontuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prontuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prontuario_id_seq OWNER TO postgres;

--
-- Name: prontuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prontuario_id_seq OWNED BY public.prontuario.id;


--
-- Name: consulta idconsulta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta ALTER COLUMN idconsulta SET DEFAULT nextval('public.consulta_idconsulta_seq'::regclass);


--
-- Name: exame idexame; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exame ALTER COLUMN idexame SET DEFAULT nextval('public.exame_idexame_seq'::regclass);


--
-- Name: paciente_alergia id_paciente_alergia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente_alergia ALTER COLUMN id_paciente_alergia SET DEFAULT nextval('public.paciente_alergia_id_paciente_alergia_seq'::regclass);


--
-- Name: prontuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario ALTER COLUMN id SET DEFAULT nextval('public.prontuario_id_seq'::regclass);


--
-- Data for Name: administrador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.administrador (nome, sobrenome, cpf, data_nascimento, telefone, sexo, numeroctps) FROM stdin;
1111	2222	33336333333	2012-09-13 00:00:00	9999999999	F	11111
\.


--
-- Data for Name: atendente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atendente (nome, sobrenome, cpf, data_nascimento, telefone, sexo, numeroctps) FROM stdin;
1111	2222	33336333333	2012-09-13 00:00:00	99999999	F	11111
\.


--
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consulta (atendente_cpf, idconsulta, horario, dia, medico_cpf, paciente_cpf) FROM stdin;
33336333333	1	11:00:00	2012-09-13	11111111111	33336333333
33336333333	2	11:00:00	2012-09-13	11111111111	33336333333
\.


--
-- Data for Name: exame; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exame (idexame, resultado, tipo, sigiloso) FROM stdin;
0	BBBB	Teste	f
2	BBBB	Teste	f
3	BBBB	Teste	f
4	CCCC	222	t
\.


--
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (nome, sobrenome, cpf, data_nascimento, telefone, sexo, cr, especialidade, numeroctps) FROM stdin;
teste	do teste	11111111111	2012-09-13 00:00:00	9999999	F	1111	Clinico geral	1111
\.


--
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente (nome, sobrenome, cpf, data_nascimento, telefone, sexo) FROM stdin;
1111	2222	33336333333	2012-09-13 00:00:00	999999999	F
\.


--
-- Data for Name: paciente_alergia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente_alergia (tipo, reacao, causador, nivel, id_paciente_alergia) FROM stdin;
alergica	vermelhidão	cigarro	alto	1
alergica	vermelhidão	cigarro	alto	2
\.


--
-- Data for Name: prontuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prontuario (id, paciente_cpf, tiposanguineo, observacao, id_exame, id_paciente_alergia) FROM stdin;
1	33336333333	A+	Paciente gosta de um cigarrinho	2	1
3	33336333333	A+	Paciente gosta de um cigarrinho	\N	\N
4	33336333333	A+	Paciente gosta de um cigarrinho	\N	\N
5	33336333333	A+	Paciente gosta de um cigarrinho	2	1
\.


--
-- Name: consulta_idconsulta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consulta_idconsulta_seq', 2, true);


--
-- Name: exame_idexame_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exame_idexame_seq', 4, true);


--
-- Name: paciente_alergia_id_paciente_alergia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paciente_alergia_id_paciente_alergia_seq', 2, true);


--
-- Name: prontuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prontuario_id_seq', 5, true);


--
-- Name: administrador administrador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.administrador
    ADD CONSTRAINT administrador_pkey PRIMARY KEY (cpf);


--
-- Name: atendente atendente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atendente
    ADD CONSTRAINT atendente_pkey PRIMARY KEY (cpf);


--
-- Name: consulta consulta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (idconsulta);


--
-- Name: exame exame_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exame
    ADD CONSTRAINT exame_pkey PRIMARY KEY (idexame);


--
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (cpf);


--
-- Name: paciente_alergia paciente_alergia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente_alergia
    ADD CONSTRAINT paciente_alergia_pk PRIMARY KEY (id_paciente_alergia);


--
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (cpf);


--
-- Name: prontuario prontuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT prontuario_pkey PRIMARY KEY (id);


--
-- Name: paciente_alergia_id_paciente_alergia_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX paciente_alergia_id_paciente_alergia_uindex ON public.paciente_alergia USING btree (id_paciente_alergia);


--
-- Name: consulta fk_consulta_atendente1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT fk_consulta_atendente1 FOREIGN KEY (atendente_cpf) REFERENCES public.atendente(cpf);


--
-- Name: consulta fk_consulta_medico1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT fk_consulta_medico1 FOREIGN KEY (medico_cpf) REFERENCES public.medico(cpf);


--
-- Name: consulta fk_consulta_paciente1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT fk_consulta_paciente1 FOREIGN KEY (paciente_cpf) REFERENCES public.paciente(cpf);


--
-- Name: prontuario fk_prontuario_paciente1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT fk_prontuario_paciente1 FOREIGN KEY (paciente_cpf) REFERENCES public.paciente(cpf);


--
-- Name: prontuario prontuario_exame_idexame_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT prontuario_exame_idexame_fk FOREIGN KEY (id_exame) REFERENCES public.exame(idexame);


--
-- Name: prontuario prontuario_paciente_alergia_id_paciente_alergia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT prontuario_paciente_alergia_id_paciente_alergia_fk FOREIGN KEY (id_paciente_alergia) REFERENCES public.paciente_alergia(id_paciente_alergia);


--
-- PostgreSQL database dump complete
--

