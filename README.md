# README
## Counter API

## Candidate Information

| Name     | Tharaka Dhananjaya Manawardhana |
|------    |---------------------------------|
| E-mail   | manawardhana@gmail.com          |
| Mobile # | +61 (0) 466070547               |

## Prerequisites
- Oracle JDK 1.8.0
- Apache maven 3.3

## How To Run
- Make sure above pre-requisites are satisfied
- Clone the project
- Execute the following command
```bash
mvn clean spring-boot-run
```

### Query word frequency
```bash
$curl http://localhost:9000/counter-api/search  -d'{"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw" -H "Content-Type: application/json" -X POST
```
### Download top words CSV
(Substitute {limit} by appropriate integer value)

```bash
$curl http://localhost:9000/counter-api/top/{limit} -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw" -H "Content-Type: application/json"
```
### Paragraph resource
```bash
$curl http://localhost:9000/counter-api/sampleParagraph -v -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw"
```

## Following points have been purposely omited
- Logging
- Integration Tests
- Removing credentials from source control

## Structure

```
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── inteliment
    │   │           └── counter
    │   │               ├── config
    │   │               │   └── CounterApiConfig.java
    │   │               ├── controller
    │   │               │   ├── CounterApiController.java
    │   │               │   └── ParagraphController.java
    │   │               ├── CounterApiApplication.java
    │   │               ├── model
    │   │               │   └── WordFrequency.java
    │   │               ├── proxy
    │   │               │   └── ParagraphProxy.java
    │   │               ├── service
    │   │               │   ├── SearchServiceImpl.java
    │   │               │   └── SearchService.java
    │   │               └── util
    │   │                   ├── StringSearchUtil.java
    │   │                   └── WordFrequencyJsonSerializer.java
    │   └── resources
    │       ├── application.properties
    │       └── paragraph.txt
    └── test
        ├── java
        │   └── com
        │       └── inteliment
        │           └── counter
        │               └── util
        │                   └── StringSearchUtilTest.java
        └── resources
```