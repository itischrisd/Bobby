INSERT INTO PUBLIC.AVAILABLE_PRODUCT_MATERIAL (NAME)
VALUES
    ('Drewno'),
    ('Metal'),
    ('Plastik'),
    ('Szkło'),
    ('Ceramika'),
    ('Beton'),
    ('Aluminium');

INSERT INTO PUBLIC.BRAND (COUNTRY, NAME)
VALUES
    ('USA', 'Craftsman'),
    ('Niemcy', 'Bosch'),
    ('Japonia', 'Makita'),
    ('Chiny', 'DeWalt'),
    ('Francja', 'Legrand');

INSERT INTO PUBLIC.CATEGORY (NAME, DESCRIPTION)
VALUES
    ('Narzędzia elektryczne', 'Elektryczne i akumulatorowe narzędzia'),
    ('Narzędzia ręczne', 'Ręczne narzędzia i akcesoria'),
    ('Materiały budowlane', 'Materiały do budowy i remontu'),
    ('Farby', 'Różne rodzaje farb i powłok'),
    ('Oświetlenie', 'Oświetlenie wewnętrzne i zewnętrzne');

INSERT INTO PUBLIC.POSITION (NAME)
VALUES
    ('Kierownik sklepu'),
    ('Sprzedawca'),
    ('Magazynier'),
    ('Kasjer'),
    ('Przedstawiciel obsługi klienta');

INSERT INTO PUBLIC.ADDRESS (APARTMENT_NUMBER, CITY, HOUSE_NUMBER, POST_OFFICE, POSTAL_CODE, STREET)
VALUES
    ('10A', 'Warszawa', '100', 'Warszawa Centralna', '00-001', 'Aleje Jerozolimskie'),
    (NULL, 'Kraków', '220', 'Kraków Główny', '30-001', 'Floriańska'),
    ('33C', 'Katowice', '330', NULL, '40-001', 'Mariacka'),
    ('44D', 'Wrocław', '440', NULL, '50-001', 'Rynek'),
    (NULL, 'Poznań', '550', NULL, '60-001', 'Święty Marcin'),
    (NULL, 'Łódź', '101', 'Łódź Centralna', '90-001', 'Piotrkowska'),
    ('12A', 'Gdańsk', '202', NULL, '80-001', 'Długa'),
    ('23B', 'Szczecin', '303', NULL, '70-001', 'Niepodległości'),
    (NULL, 'Bydgoszcz', '404', 'Bydgoszcz Główna', '85-001', 'Dworcowa'),
    ('45D', 'Lublin', '505', NULL, '20-001', 'Krakowskie Przedmieście'),
    (NULL, 'Białystok', '606', NULL, '15-001', 'Lipowa'),
    ('67F', 'Gdynia', '707', 'Gdynia Główna', '81-001', 'Świętojańska'),
    (NULL, 'Częstochowa', '808', NULL, '42-001', 'Aleja Najświętszej Maryi Panny'),
    ('89H', 'Radom', '909', NULL, '26-001', 'Żeromskiego'),
    (NULL, 'Toruń', '1010', 'Toruń Główny', '87-001', 'Szeroka'),
    ('101J', 'Kielce', '111', NULL, '25-001', 'Sienkiewicza'),
    (NULL, 'Rzeszów', '222', 'Rzeszów Główny', '35-001', '3 Maja'),
    ('123L', 'Gliwice', '333', NULL, '44-001', 'Zwycięstwa'),
    (NULL, 'Zabrze', '444', 'Zabrze Główne', '41-001', 'Wolności'),
    ('145N', 'Olsztyn', '555', NULL, '10-001', 'Piłsudskiego'),
    (NULL, 'Bielsko-Biała', '666', 'Bielsko-Biała Główna', '43-001', '3 Maja'),
    ('167P', 'Rybnik', '777', NULL, '44-200', 'Kościuszki'),
    (NULL, 'Zielona Góra', '888', 'Zielona Góra Główna', '65-001', 'Bohaterów Westerplatte'),
    ('189R', 'Opole', '999', NULL, '45-001', 'Ozimska'),
    (NULL, 'Elbląg', '101', 'Elbląg Główny', '82-001', 'Grunwaldzka'),
    ('201T', 'Tychy', '202', NULL, '43-100', 'Towarowa'),
    (NULL, 'Płock', '303', 'Płock Główny', '09-400', 'Tumska'),
    ('223V', 'Wałbrzych', '404', NULL, '58-300', 'Główna'),
    (NULL, 'Włocławek', '505', 'Włocławek Główny', '87-800', 'Kościuszki'),
    ('245X', 'Tarnów', '606', NULL, '33-100', 'Wałowa');

INSERT INTO PUBLIC.EMPLOYEE (HIRE_DATE, IS_ELIGIBLE_FOR_GLASSES_REFUND, EMPLOYEE_NUMBER, POSITION_ID, NAME, SURNAME, PESEL, PHONE_NUMBER)
VALUES
    ('2023-01-01', TRUE, 'EMP1001', 1, 'Alicja', 'Nowak', '12345678901', '123-456-789'),
    ('2023-02-01', FALSE, 'EMP1002', 2, 'Robert', 'Wiśniewski', '23456789012', '852-963-741'),
    ('2023-03-01', null, 'EMP1003', 3, 'Karol', 'Kowalczyk', '34567890123', '741-852-963'),
    ('2023-04-01', null, 'EMP1004', 4, 'Dawid', 'Woźniak', '45678901234', '963-741-852'),
    ('2023-05-01', null, 'EMP1005', 5, 'Ewa', 'Kowalska', '56789012345', '852-963-741'),
    ('2023-06-01', FALSE, 'EMP1006', 1, 'Katarzyna', 'Nowak', '67890123456', '741-852-963'),
    ('2023-07-01', TRUE, 'EMP1007', 2, 'Piotr', 'Wiśniewski', '78901234567', '963-741-852'),
    ('2023-08-01', null, 'EMP1008', 3, 'Marek', 'Kowalczyk', '89012345678', '852-963-741'),
    ('2023-09-01', null, 'EMP1009', 4, 'Kamil', 'Woźniak', '90123456789', '741-852-963'),
    ('2023-10-01', null, 'EMP1010', 5, 'Klaudia', 'Kowalska', '01234567890', '963-741-852'),
    ('2023-11-01', TRUE, 'EMP1011', 1, 'Krzysztof', 'Nowak', '12345678901', '852-963-741'),
    ('2023-12-01', FALSE, 'EMP1012', 2, 'Marta', 'Wiśniewska', '23456789012', '741-852-963'),
    ('2024-01-01', null, 'EMP1013', 3, 'Kacper', 'Kowalczyk', '34567890123', '963-741-852'),
    ('2024-02-01', null, 'EMP1014', 4, 'Kornelia', 'Woźniak', '45678901234', '852-963-741'),
    ('2024-03-01', null, 'EMP1015', 5, 'Ksawery', 'Kowalski', '56789012345', '741-852-963');

INSERT INTO PUBLIC.EMPLOYEE_HARMFUL_FACTOR (EMPLOYEE_ID, HARMFUL_FACTORS)
VALUES
    (3, 'Podnoszenie ciężarów'),
    (4, 'Ekspozycja na pył'),
    (5, 'Ekspozycja na hałas'),
    (8, 'Ekspozycja na chemikalia'),
    (9, 'Powtarzalne ruchy'),
    (10, 'Praca w nocy'),
    (13, 'Praca w nocy'),
    (14, 'Praca w nocy'),
    (15, 'Praca w nocy');

INSERT INTO PUBLIC.FULL_TIME_EMPLOYEE (ID, SALARY)
VALUES
    (1, 5500.00),
    (2, 4800.00),
    (3, 5000.00),
    (4, 4500.00),
    (5, 4700.00);

INSERT INTO PUBLIC.CONTRACTOR (ID, CONTRACT_VALUE, PAYMENT_DATE, CONTRACT_DESCRIPTION)
VALUES
    (6, 5000.00, '2024-07-01', 'Renowacja sklepu'),
    (7, 7000.00, '2024-07-02', 'Instalacja nowych półek'),
    (8, 6000.00, '2024-07-03', 'Prace elektryczne'),
    (9, 8000.00, '2024-07-04', 'Modernizacja instalacji wodno-kanalizacyjnej'),
    (10, 5500.00, '2024-07-05', 'Malowanie i dekoracje');

INSERT INTO PUBLIC.INTERN (ID, INTERNSHIP_END_DATE)
VALUES
    (11, '2024-12-31'),
    (12, '2024-12-31'),
    (13, '2024-12-31'),
    (14, '2024-12-31'),
    (15, '2024-12-31');

INSERT INTO PUBLIC.PRODUCT (NET_PRICE, CATEGORY_ID, COLOR, NAME, DESCRIPTION)
VALUES
    (299.99, 3, 'Szary', 'Cement', 'Wysokiej jakości cement do budowy'),
    (19.99, 3, NULL, 'Deska drewniana', 'Drewno sosnowe o wysokiej wytrzymałości'),
    (49.99, 3, 'Biały', 'Gips', 'Gips budowlany do wyrównywania ścian'),
    (89.99, 3, 'Czerwony', 'Cegła', 'Cegła klinkierowa do budowy'),
    (149.99, 3, NULL, 'Płyta kartonowo-gipsowa', 'Płyta gipsowo-kartonowa o wysokiej wytrzymałości'),
    (499.99, 2, 'Biały', 'Pralka', 'Automatyczna pralka o dużej pojemności'),
    (199.99, 2, 'Srebrny', 'Lodówka', 'Lodówka energooszczędna z zamrażarką'),
    (99.99, 2, 'Czarny', 'Kuchenka mikrofalowa', 'Mikrofalówka z funkcją grilla'),
    (249.99, 2, NULL, 'Zmywarka', 'Zmywarka do naczyń z funkcją suszenia'),
    (149.99, 2, NULL, 'Odkurzacz', 'Odkurzacz bezworkowy o dużej mocy'),
    (299.99, 1, 'Żółty', 'Wiertarka udarowa', 'Wiertarka udarowa o dużej mocy'),
    (199.99, 1, 'Czerwony', 'Szlifierka kątowa', 'Szlifierka kątowa do precyzyjnych cięć'),
    (149.99, 1, NULL, 'Piła tarczowa', 'Piła tarczowa do cięcia drewna i metalu'),
    (99.99, 1, NULL, 'Wkrętarka', 'Wkrętarka akumulatorowa o dużej wytrzymałości'),
    (89.99, 1, 'Pomarańczowy', 'Lutownica', 'Lutownica elektryczna do precyzyjnych prac');

INSERT INTO PUBLIC.PRODUCT_MATERIAL (MATERIAL_ID, PRODUCT_ID)
VALUES
    (1, 1),
    (1, 2),
    (3, 2),
    (1, 3),
    (3, 3),
    (1, 4),
    (5, 5),
    (3, 5),
    (2, 6),
    (4, 6),
    (2, 7),
    (3, 7),
    (2, 8),
    (3, 8),
    (2, 9),
    (4, 9),
    (2, 10),
    (3, 10),
    (2, 11),
    (3, 11),
    (2, 12),
    (3, 12),
    (2, 13),
    (3, 13),
    (2, 14),
    (3, 14),
    (2, 15),
    (3, 15);

INSERT INTO PUBLIC.BUILDING_MATERIAL (PRODUCT_ID, UNIT)
VALUES
    (1, 'kg'),
    (2, 'szt.'),
    (3, 'kg'),
    (4, 'szt.'),
    (5, 'szt.');

INSERT INTO PUBLIC.HOUSEHOLD_EQUIPMENT (PRODUCT_ID, IS_FOR_SELF_ASSEMBLY)
VALUES
    (6, FALSE),
    (7, FALSE),
    (8, FALSE),
    (9, FALSE),
    (10, FALSE);

INSERT INTO PUBLIC.HOUSEHOLD_EQUIPMENT_CERTIFICATE (HOUSEHOLD_EQUIPMENT_ID, CERTIFICATES)
VALUES
    (1, 'UL'),
    (2, 'CE'),
    (3, 'ISO 9001'),
    (4, 'RoHS'),
    (5, 'FCC');

INSERT INTO PUBLIC.TOOL (PRODUCT_ID, POWER, VOLTAGE)
VALUES
    (11, 1500.0, 230.0),
    (12, 1200.0, 230.0),
    (13, 1000.0, 230.0),
    (14, 800.0, 230.0),
    (15, 60.0, 230.0);

INSERT INTO PUBLIC.TOOL_BRAND (BRAND_ID, TOOL_ID)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO PUBLIC.COMPANY (ADDRESS_ID, NAME, NIP)
VALUES
    (1, 'ToolMakers Inc.', '1234567890'),
    (2, 'Builders Choice', '0987654321'),
    (3, 'PaintPros', '1122334455'),
    (4, 'LightBright', '6677889900'),
    (5, 'HandyWorks', '5544332211'),
    (6, 'HomeFix', '9988776655'),
    (7, 'ToolMasters', '5566778899'),
    (8, 'Builders Best', '2233445566'),
    (9, 'PaintWorks', '7788990011'),
    (10, 'LightWorks', '9900112233');

INSERT INTO PUBLIC.SUPPLIER (ID, BANK_ACCOUNT_NUMBER, PHONE_NUMBER)
VALUES
    (1, '1234567890123456', '123-456-789'),
    (2, '2345678901234567', '987-654-321'),
    (3, '3456789012345678', '456-789-123'),
    (4, '4567890123456789', '321-654-987'),
    (5, '5678901234567890', '789-123-456');

INSERT INTO PUBLIC.CORPORATE_CLIENT (ID, EMAIL, REGON)
VALUES
    (6, 'kontakt@toolmakers.com', '123123123'),
    (7, 'info@builderschoice.com', '321321321'),
    (8, 'wsparcie@paintpros.com', '456456456'),
    (9, 'sprzedaz@lightbright.com', '789789789'),
    (10, 'serwis@handyworks.com', '987987987');

INSERT INTO PUBLIC.INDIVIDUAL_CLIENT (ADDRESS_ID, EMAIL, FIRST_NAME, LAST_NAME)
VALUES
    (11, 'jan.kowalski@example.com', 'Jan', 'Kowalski'),
    (12, 'anna.nowak@example.com', 'Anna', 'Nowak'),
    (13, 'piotr.zielinski@example.com', 'Piotr', 'Zieliński'),
    (14, 'magda.wisniewska@example.com', 'Magda', 'Wiśniewska'),
    (15, 'adam.kaczmarek@example.com', 'Adam', 'Kaczmarek'),
    (16, 'ewa.kowalczyk@example.com', 'Ewa', 'Kowalczyk'),
    (17, 'robert.lewandowski@example.com', 'Robert', 'Lewandowski'),
    (18, 'karolina.nowicka@example.com', 'Karolina', 'Nowicka'),
    (19, 'michal.zalewski@example.com', 'Michał', 'Zalewski'),
    (20, 'marcin.kwiatkowski@example.com', 'Marcin', 'Kwiatkowski'),
    (21, 'alicja.kos@example.com', 'Alicja', 'Kos'),
    (22, 'kamil.maj@example.com', 'Kamil', 'Maj'),
    (23, 'dawid.kolodziej@example.com', 'Dawid', 'Kołodziej'),
    (24, 'barbara.adamska@example.com', 'Barbara', 'Adamska'),
    (25, 'krystyna.zak@example.com', 'Krystyna', 'Żak');

INSERT INTO PUBLIC.GUEST_CLIENT (INDIVIDUAL_CLIENT_ID, PHONE_NUMBER)
VALUES
    (1, '123-456-789'),
    (2, '987-654-321'),
    (3, '456-789-123'),
    (4, '321-654-987'),
    (5, '789-123-456');

INSERT INTO PUBLIC.REGISTERED_CLIENT (INDIVIDUAL_CLIENT_ID, LOGIN, PASSWORD)
VALUES
    (6, 'ewa_kowalczyk', 'haslo123'),
    (7, 'robert_lewandowski', 'mojehaslo'),
    (8, 'karolina_nowicka', 'pass1234'),
    (9, 'michal_zalewski', 'tajnehaslo'),
    (10, 'marcin_kwiatkowski', 'marcin1234');

INSERT INTO PUBLIC.REGULAR_CLIENT (INDIVIDUAL_CLIENT_ID, CARD_PIN, DISCOUNT, CARD_NUMBER)
VALUES
    (11, '1234', 5.0, '1111222233334444'),
    (12, '5678', 10.0, '5555666677778888'),
    (13, '9101', 15.0, '9999000011112222'),
    (14, '1213', 20.0, '3333444455556666'),
    (15, '1415', 25.0, '7777888899990000');

INSERT INTO PUBLIC.ORDERS (ORDER_DATE, PLANNED_DELIVERY_DATE, SHIPPING_COST, ADDRESS_ID, CLIENT_ID, CORPORATE_CLIENT_ID, COMMENTS, STATUS)
VALUES
    ('2024-06-10', '2024-06-15', 20.50, 26, 1, NULL, 'Pilne', 'PLACED'),
    ('2024-06-11', '2024-06-16', 25.75, 27, NULL, 6, 'Ostrożnie', 'IN_PROGRESS'),
    ('2024-06-12', '2024-06-17', 18.25, 28, 2, NULL, 'Zostawić przed drzwiami', 'SHIPPED'),
    ('2024-06-13', '2024-06-18', 22.00, 29, NULL, 7, 'Zapakować na prezent', 'DELIVERED'),
    ('2024-06-14', '2024-06-19', 15.50, 30, 3, NULL, 'Dostarczyć przed południem', 'PAID');

INSERT INTO PUBLIC.ORDER_ELEMENT (ORDER_ID, PRODUCT_ID, QUANTITY)
VALUES
    (3, 1, 2),
    (4, 2, 5),
    (5, 3, 10),
    (6, 4, 3),
    (7, 5, 7);

INSERT INTO PUBLIC.INVOICE (ISSUE_DATE, NET_VALUE, PAYMENT_DATE, COMPANY_ID, ORDER_ID, NUMBER)
VALUES
    ('2024-06-10', 150.00, '2024-06-20', 1, null, 'INV001'),
    ('2024-06-11', 200.00, '2024-06-21', 2, null, 'INV002'),
    ('2024-06-12', 180.00, '2024-06-22', 3, null, 'INV003'),
    ('2024-06-13', 220.00, '2024-06-23', 4, null, 'INV004'),
    ('2024-06-14', 250.00, '2024-06-24', 5, null, 'INV005');

INSERT INTO PUBLIC.SERVICE (EXPECTED_TIME, IS_DONE_OFFSITE, NAME, DESCRIPTION)
VALUES
    (90, TRUE, 'Instalacja', 'Profesjonalne usługi instalacyjne do domu i ogrodu'),
    (120, FALSE, 'Naprawa', 'Usługi naprawy uszkodzonych narzędzi i sprzętu'),
    (60, TRUE, 'Konsultacja', 'Eksperckie konsultacje w zakresie projektów domowych'),
    (180, FALSE, 'Projektowanie', 'Usługi projektowania wnętrz i zewnętrznych'),
    (45, TRUE, 'Dostawa', 'Szybkie i niezawodne usługi dostawy'),
    (5, FALSE, 'Przycięcie płyty wiórowej', 'Przycięcie płyty wiórowej na wymiar');

INSERT INTO PUBLIC.RESERVATION (PLANNED_START_DATE, SUBMISSION_DATE, CORPORATE_CLIENT_ID, EMPLOYEE_ID, INDIVIDUAL_CLIENT_ID, NUMBER, STATUS)
VALUES
    ('2024-07-10', '2024-06-10', 6, 1, null, 'RES001', 'SUBMITTED'),
    ('2024-07-11', '2024-06-11', 7, 2, null, 'RES002', 'CONFIRMED'),
    ('2024-07-12', '2024-06-12', null, 3, 8, 'RES003', 'ASSIGNED_TO_EMPLOYEE'),
    ('2024-07-13', '2024-06-13', null, 4, 9, 'RES004', 'COMPLETED'),
    ('2024-07-14', '2024-06-14', null, 5, 10, 'RES005', 'CANCELLED');

INSERT INTO PUBLIC.RESERVATION_SERVICE (RESERVATION_ID, SERVICE_ID)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO PUBLIC.OFFER (PRODUCT_ID, SUPPLIER_ID, MINIMUM_QUANTITY, PRICE)
VALUES
    (1, 1, 10, 749.99),
    (2, 2, 20, 45.99),
    (3, 3, 30, 10.99),
    (4, 4, 15, 28.99),
    (5, 5, 25, 55.99);