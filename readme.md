настройки url, user, password -   
 [src/main/resources/test.properties]
***
для запуска тестовго класса
`mvn -Dtest=TestDemoqa test`
***
для запуска сценариев

+ Сценарий 1
`mvn -Dtest=TestDemoqa#testEmptyProfileCollection test`
+ Сценарий 2
`mvn -Dtest=TestDemoqa#testCheckCountBooks test`
+ Сценарий 3
`mvn -Dtest=TestDemoqa#testCheckDeleteBooks test`


