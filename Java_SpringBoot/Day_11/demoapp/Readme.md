### utlis:
- [CSVFileReader](./src/main/java/com/example/demoapp/utlis/CSVFileReader.java)
- [ExcelFileReader](./src/main/java/com/example/demoapp/utlis/ExcelFileReader.java)
- [JsonFileReader](./src/main/java/com/example/demoapp/utlis/JsonFileReader.java)
### database:
- [InitDB](./src/main/java/com/example/demoapp/database/InitDB.java)

### Dependency:
- Thư viện gson (file Json):
```ruby
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```
- Thư viện OpenCSV (file CSV):
```ruby
<dependency>
	<groupId>com.opencsv</groupId>
	<artifactId>opencsv</artifactId>
	<version>5.5.2</version>
</dependency>
```
- Thư viện Apache POI (file xlsx):
```ruby
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi</artifactId>
	<version>5.2.3</version>
</dependency>
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi-ooxml</artifactId>
	<version>5.2.3</version>
</dependency>
```