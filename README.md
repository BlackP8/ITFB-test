Приветствую, уважаемый/ая ревьюер, в этом файле показан краткий алгоритм для запуска тестов проекта через консоль:
1. Необходимо скопировать путь к папке проекта.
2. Открыть командную строку.
3. Перейти в папку проекта при помощи команды cd <Путь к проекту>.
4. Запустить команду mvn clean test.
5. Для генерации отчета с помощью allure после выполнения теста выполнить команду:
   allure generate target/allure-results --clean