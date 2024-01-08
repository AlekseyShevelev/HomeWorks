### Компиляция:
javac -sourcepath ./src/main/java -d ./out src/main/java/sample/Main.java

### Запуск:
java -classpath ./out sample.Main

### Создание документации:
javadoc -d docs -sourcepath ./src/main/java -cp ./out -subpackages sample regular