# Protestant Church Calendar (Library)

A simple library for calculating and managing dates in the Protestant church calendar.

# Features
This library calculates the dates for the following key days in the Protestant liturgical year. Both English and Korean are supported via resource bundles.

| Liturgical Day            | Korean Name (절기명)       |
|---------------------------|---------------------------|
| First Sunday of Advent    | 대림절 첫째 주일          |
| Christmas Day             | 성탄절                   |
| Epiphany                  | 주현절                   |
| Transfiguration Sunday    | 산상변모주일             |
| Ash Wednesday             | 재의 수요일              |
| Palm Sunday               | 종려 주일                |
| Maundy Thursday           | 세족 목요일              |
| Good Friday               | 성금요일                 |
| Easter Sunday             | 부활절                   |
| Pentecost                 | 성령강림절               |
| Trinity Sunday            | 삼위일체주일             |
| Reformation Day           | 종교개혁 기념일          |
| Christ the King           | 왕이신 그리스도 주일      |

## Usage

This project is intended to be used as a library in other Java projects.

### Adding to your project

#### Gradle

Add the following to your `build.gradle` file:

```groovy
repositories {
    mavenCentral() // Or your preferred repository if published there
}

dependencies {
    implementation 'com.jc.protestantcalendar:protestant-church-calendar:1.0.0' // Replace with actual group, artifact, version
}
```

#### Maven

Add the following to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.jc.protestantcalendar</groupId>
    <artifactId>protestant-church-calendar</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Example Usage (Java - using Interfaces)

```java
// Instantiate services
com.jc.protestantcalendar.LiturgicalCalculator calculator = new com.jc.protestantcalendar.LiturgicalCalculator(ResourceBundle.getBundle("messages", Locale.ENGLISH));
com.jc.protestantcalendar.ILiturgicalCalendarService calendarService = new com.jc.protestantcalendar.LiturgicalCalendarService(calculator);

// Get liturgical week for a specific date
calendarService.getLiturgicalWeekFor(LocalDate.now());

// Get upcoming feasts
calendarService.getUpcomingFeasts(LocalDate.now(), 5);
```
## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
