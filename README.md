[한국어](#개신교-교회력) | [English](#Protestant-Church-Calendar)

# 개신교 교회력

개신교 교회력의 주요 절기 날짜를 계산하고 관리할 수 있는 간단한 자바 라이브러리입니다.

# 주요 기능
이 라이브러리는 개신교 교회력의 주요 절기 날짜를 계산합니다. 리소스 번들을 통해 영어와 한국어를 모두 지원합니다.

| 영어 절기명               | 한국어 절기명             |
|---------------------------|---------------------------|
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
| First Sunday of Advent    | 대림절 첫째 주일          |
| Christmas Day             | 성탄절                   |

## 사용법

이 프로젝트는 다른 자바 프로젝트에서 라이브러리로 사용하도록 설계되었습니다.

### 프로젝트에 추가하기

#### Gradle
`build.gradle` 파일에 원하는 방식으로 의존성을 추가해주세요.

```groovy
dependencies {
    implementation 'com.jc.protestantcalendar:protestant-church-calendar:1.0.0' 
}
```

#### Maven

`pom.xml` 파일에 원하는 방식으로 의존성을 추가해주세요.

```xml
<dependencies>
    <dependency>
        <groupId>com.jc.protestantcalendar</groupId>
            <artifactId>protestant-church-calendar</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### 예제 코드 (Java - 인터페이스 사용)

```java
// 서비스 인스턴스 생성
com.jc.protestantcalendar.LiturgicalCalculator calculator = new com.jc.protestantcalendar.LiturgicalCalculator(ResourceBundle.getBundle("messages", Locale.KOREAN));
com.jc.protestantcalendar.ILiturgicalCalendarService calendarService = new com.jc.protestantcalendar.LiturgicalCalendarService(calculator);

// 2025년 교회력 절기 계산
calendarService.calculate(2025);
// 주현절: 2025-01-06, 산상변모주일: 2025-03-02, 재의 수요일: 2025-03-05, 종려 주일: 2025-04-13, 세족 목요일: 2025-04-17, 성금요일: 2025-04-18, 부활절: 2025-04-20, 성령강림절: 2025-06-08, 삼위일체주일: 2025-06-15, 종교개혁 기념일: 2025-10-31, 왕이신 그리스도 주일: 2025-11-23, 대림절 첫째 주일: 2025-11-30, 성탄절: 2025-12-25

// 특정 날짜의 교회력 주간 확인
calendarService.getLiturgicalWeekFor(LocalDate.now());
// 삼위일체주일 이후 네 번째 주간 등

// 다가오는 절기 확인
calendarService.getUpcomingFeasts(LocalDate.now(), 5);
// 종교개혁 기념일: 2025-10-31, 왕이신 그리스도 주일: 2025-11-23, 대림절 첫째 주일: 2025-11-30, 성탄절: 2025-12-25
```

## 라이선스

이 프로젝트는 Apache License 2.0으로 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참고하세요.


# Protestant-Church-Calendar

A simple library for calculating and managing dates in the Protestant church calendar.

# Features
This library calculates the dates for the following key days in the Protestant liturgical year. Both English and Korean are supported via resource bundles.

| Liturgical Day            | Korean Name (절기명)       |
|---------------------------|---------------------------|
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
| First Sunday of Advent    | 대림절 첫째 주일          |
| Christmas Day             | 성탄절                   |

## Usage

This project is intended to be used as a library in other Java projects.

### Adding to your project

#### Gradle
Add the dependency to your build.gradle in any way you prefer:

```groovy
dependencies {
    implementation 'com.jc.protestantcalendar:protestant-church-calendar:1.0.0' 
}
```

#### Maven
Add the dependency to your pom.xml in any way you prefer:

```xml
<dependencies>
    <dependency>
        <groupId>com.jc.protestantcalendar</groupId>
        <artifactId>protestant-church-calendar</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Example Usage (Java - using Interfaces)

```java
// Instantiate services
com.jc.protestantcalendar.LiturgicalCalculator calculator = new com.jc.protestantcalendar.LiturgicalCalculator(ResourceBundle.getBundle("messages", Locale.ENGLISH));
com.jc.protestantcalendar.ILiturgicalCalendarService calendarService = new com.jc.protestantcalendar.LiturgicalCalendarService(calculator);

// Calculate the liturgical calendar for the year 2025.
calendarService.calculate(2025);
// Epiphany: 2025-01-06, Transfiguration Sunday: 2025-03-02, Ash Wednesday: 2025-03-05, Palm Sunday: 2025-04-13, Maundy Thursday: 2025-04-17, Good Friday: 2025-04-18, Easter Sunday: 2025-04-20, Pentecost: 2025-06-08, Trinity Sunday: 2025-06-15, Reformation Day: 2025-10-31, Christ the King: 2025-11-23, First Sunday of Advent: 2025-11-30, Christmas Day: 2025-12-25

// Get liturgical week for a specific date
calendarService.getLiturgicalWeekFor(LocalDate.now());
// Trinity Sunday after The Fourth Sunday week

// Get upcoming feasts
        calendarService.getUpcomingFeasts(LocalDate.now(), 5);
// Reformation Day: 2025-10-31, Christ the King: 2025-11-23, First Sunday of Advent: 2025-11-30, Christmas Day: 2025-12-25
```
## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
