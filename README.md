#### Запуск тестов
```bash
gradle test
```
Параллальный запуск тестов (цифрой указывается количество потоков)
```bash
gradle test -Dthreads=2
```
#### Необходимо добавить файл credentials.properties в директорию проекта \src\test\resources\config 
Структура файла:
```bash
email=
wrongemail=
password=
token=
```
Тесты: <br>
Web IU: <br>
- Открываем https://mail.ru/ и проверям title 
- Открываем https://mail.ru/, входим в почту с использованием email и password, отправляем письмо и проверяем, что письмо отправлено <br>

API: <br>
- Входим в почту с использованием API запроса (позитивный)
- Входим в почту с использованием API запроса (негативный)
