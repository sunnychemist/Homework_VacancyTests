# Автотесты для сайта
### https://www.rabota.ru/

___
## Используемые технологии и инструменты
![Intelij_IDEA](img/icons/Intelij_IDEA.png)![Java](img/icons/Java.png)![Selenide](img/icons/Selenide.png)![Selenoid](img/icons/Selenoid.png)![Gradle](img/icons/Gradle.png)![JUnit5](img/icons/JUnit5.png)![Allure Report](img/icons/Allure_Report.png)![AllureTestOps](img/icons/AllureTestOps.png)![Github](img/icons/Github.png)![Jenkins](img/icons/Jenkins.png)![Rest-Assured](img/icons/Rest-Assured.png)![Telegram](img/icons/Telegram.png)![Jira](img/icons/Jira.png)
___

## Для запуска автотестов используется Jenkins.

##### Примеры готовых сборок можно посмотреть [по ссылке](https://jenkins.autotests.cloud/job/daria_kuchumova_9_diploma/)

### Используемые параметры по умолчанию

![Jenkins](./img/Jenkins.png)

* browser (default chrome)
* browserVersion (default 91.0)
* remoteUrl (url address from selenoid or grid)
* threads (number of threads)
* environment
* browserSize (default 1920x1080)

Run tests with filled remote.properties:

```bash
gradle clean test
```

Run tests with not filled remote.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:

```bash
allure serve build/allure-results
```

___
## Оповещение о результатах прохождения тестов происходит через бот в телеграм

#### После прохождения всех тестов, приходит отчет в канал в телеграме:
![Telegram](img/Telegrambot.png)

___

## Анализ результатов

Более подробно с результатми тестов (шаги, скриншоты, видео прохождения теста, page source и browser console log) можно ознакомиться:
* В Jenkins через Allure Reports (перейти по ссылке в отчете телеграм)
* В Allure TestOps.
___

## Анализ результатов в Jenkins через Allure Reports
![Allure](img/AllureReport.png)
![Allure](img/AllureReport2.png)
___

## Анализ результатов в Allure TestOps

![Allure TestOps](./img/AllureTestOps1.png)
![Allure TestOps](./img/AllureTestOps2.png)

---
## Добавлена интеграция с Jira, где можно посмотреть запускаемые кейсы и их результаты.

Перейти в Jira можно [по ссылке](https://jira.autotests.cloud/projects/HOMEWORK/issues/HOMEWORK-347?filter=allopenissues)

![Jira](./img/jira.png)

---


### Видео прохождения теста, взятое из среды выполнения (из Selenoid)

![video](./img/Video.gif)