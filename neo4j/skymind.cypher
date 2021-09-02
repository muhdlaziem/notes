CREATE (CNS: Company {name:'Skymind CNS', description:'Project based company'})
CREATE (XpressAI: Company {name:'Xpress AI', description:'Product based company'})
CREATE (DataEng: Department {name:'Data Engineering', description:'Doing data pipelining, ETL etc'})
CREATE (Laziem: Employee {name:'Laziem', title: 'Junior AI Engineer', started_in: 2020})
CREATE (Hazim: Employee {name:'Hazim', title: 'AI Software Engineer', started_in: 2020})
CREATE (Amer: Employee {name:'Amer', title: 'AI Engineer', started_in: 2021})
CREATE (Atikah: Employee {name:'Atikah', title: 'Assistant AI Engineer', started_in: 2021})
CREATE (Raliza: Employee {name:'Raliza', title: 'Junior AI Engineer', started_in: 2019})
CREATE (DrImran: Employee {name:'Dr Imran', title: 'Vice President of Engineering', started_in: 2021})
CREATE
(Laziem)-[:WORKS_IN]->(DataEng),
(Hazim)-[:WORKS_IN]->(DataEng),
(Amer)-[:WORKS_IN]->(DataEng),
(Atikah)-[:WORKS_IN]->(DataEng),
(Raliza)-[:WORKS_IN]->(DataEng),
(DrImran)-[:LEADS]->(DataEng),
(DataEng)-[:PART_OF]->(CNS),
(Laziem)-[:WORKED_IN]->(XpressAI),
(Hazim)-[:WORKED_IN]->(XpressAI),
(Amer)-[:WORKED_IN]->(XpressAI)

CREATE (task1: Task {name:'Neo4j 4W1h + CRUD', status:'in_progress'})
CREATE (task2: Task {name:"Streaming: Kafka Streams? Apache Storm? Structured Spark Streaming? (4W1h and Comparison)", status:'in_progress'})
CREATE (task3: Task {name:'Apache Nifi 4Wh1', status:'to_do'})
CREATE (task4: Task {name:'Apache Airflow', status:'to_do'})
CREATE (cns_general: Project {name:'CNS General Engineering Tasks', status:'on_going'})
CREATE
(Laziem)-[:WORKS_ON]->(task1),
(Laziem)-[:WORKS_ON]->(task2),
(Laziem)-[:WORKS_ON]->(task3),
(Laziem)-[:WORKS_ON]->(task4),
(task1)-[:IN]->(cns_general),
(task2)-[:IN]->(cns_general),
(task3)-[:IN]->(cns_general),
(task4)-[:IN]->(cns_general),
(cns_general)-[:BELONGS_TO]->(CNS)

CREATE (ekyc: Project {name:'EKYC HLA', status:'phase_4'})
CREATE (hla: Client {name:'HLA'})
CREATE (rex: Employee {name:'Kuok Hong Chan', title: 'Junior Deep Learning Engineer', started_in: 2020})
CREATE (task5: Task {name:'Palm Detection', status:'done'})
CREATE 
(rex)-[:WORKED_ON]->(task5),
(rex)-[:WORKS_IN]->(XpressAI),
(task5)-[:IN]->(ekyc),
(ekyc)-[:BELONGS_TO]->(XpressAI),
(ekyc)-[:BELONGS_TO]->(hla)

CREATE (Angie: Employee {name:'Angie Liew', title: 'Senior Project Manager', started_in: 2019})
CREATE (task6: Task {name:'Managing EKYC', status:'done'})
CREATE 
(Angie)-[:CONTACT_DIRECTLY]->(hla),
(Angie)-[:WORKED_ON]->(task6),
(task6)-[:IN]->(ekyc)
