1. Склонировать репозиторий
2. Проверить, что на портах 5432, 8080, 9090, 3000 ничего не работает
3. docker-compose up
4. Зайти в grafana http://localhost:3000. логин: admin пароль: admin. Поменять пароль по умолчанию на свой.
5. У нас будет 3 дашборда, создадим их. Перейти в раздел Dashboards->import dashboard. id дашбордов 4701 (jvm), 9628(
   postgres), 6083 (hikari cp). В datasource указать http://prometheus:9090
6. В application.yml поменять размер connection-pool и запустить нагрузочные тесты. В графане посмотреть, какой RPS
   может выдержать сервис с заданными настройками

Запуск нагрузочных скриптов
Windows (PowerShell)
`$env:K6_WEB_DASHBOARD = "true"; $env:K6_WEB_DASHBOARD_EXPORT = "html-report.html"; $env:K6_WEB_DASHBOARD_OPEN="true"; k6 run <script_name>.js`
Linux (Bash)
`K6_WEB_DASHBOARD=true K6_WEB_DASHBOARD_EXPORT=html-report.html K6_WEB_DASHBOARD_OPEN=true k6 run <script_name>.js`