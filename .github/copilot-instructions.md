## Repository summary

This is a small Maven Java project (artifactId: `excel2database`) that reads an Excel workbook (.xlsx) and maps sheets to MySQL tables using Apache POI and the MySQL JDBC driver. The program reads database/IO configuration from `config.properties` at the repository root.

## Big picture / data flow

- Input: Excel workbook (default path configured in `config.properties`, keys: `inputFile`/`outputFile`).
- Config: `config.properties` read with `com.iesvdc.dam.acceso.conexion.Config#getProperties`.
- Connection: `com.iesvdc.dam.acceso.conexion.Conexion#getConnection()` builds a JDBC URL from properties (`host`, `port`, `database`) and passes the `Properties` to `DriverManager.getConnection`.
- Processing: intended to be implemented in `com.iesvdc.dam.acceso.excelutil.ExcelReader` and orchestrated by `com.iesvdc.dam.acceso.Excel2Database`.
- Models: `com.iesvdc.dam.acceso.modelo.*` contains `WorkbookModel`, `TableModel`, `FieldModel`, and `FieldType` which capture the sheet→table and row→field mapping.

## Key files to inspect / change

- `pom.xml` — Maven configuration and dependencies (Apache POI, MySQL connector). Java 21 set as compile target.
- `config.properties` — runtime configuration (DB credentials, host/port, input/output file paths). See `Readme.md` for example properties.
- `src/main/java/com/iesvdc/dam/acceso/Excel2Database.java` — main entrypoint; currently only establishes DB connection.
- `src/main/java/com/iesvdc/dam/acceso/excelutil/ExcelReader.java` — placeholder for Excel parsing logic.
- `src/main/java/com/iesvdc/dam/acceso/conexion/` — `Config.java` and `Conexion.java` helpers for property loading and JDBC connection.
- `src/main/java/com/iesvdc/dam/acceso/modelo/` — domain models. `FieldType` includes helper `isNumeric()` that callers use to map numeric types.

## Project-specific conventions and patterns

- Config-first: code expects `config.properties` at the repository root and uses `Config.getProperties("config.properties")` directly (no DI or environment var fallback). When editing code, preserve this callsite or update all usages.
- JDBC URL construction: `Conexion.getConnection()` concatenates `host:port/database` and passes the entire `Properties` object to `DriverManager.getConnection(url, props)` so keys like `user`, `password`, and JDBC flags (e.g., `serverTimezone`) are expected to be present in `config.properties`.
- Excel → DB mapping: sheet name → table name; first row → column names; second row → column types (the README describes this). Implementations should populate `TableModel` and `FieldModel` accordingly.
- Minimal logging: project prints to stdout/stderr (System.out/err). Keep side effects simple and avoid large logging frameworks unless adding them project-wide.

## Build / test / run (developer workflows)

- Build with Maven (requires Java 21 installed):

  mvn -q -DskipTests package

- Run the program from target (example):

  java -cp target/excel2database-1.0-SNAPSHOT.jar com.iesvdc.dam.acceso.Excel2Database

  Note: `config.properties` must be present in the working directory when running; `Conexion` reads it via FileInputStream("config.properties").

- Run tests (uses JUnit 4):

  mvn -q test

## Integration / external dependencies

- Apache POI (poi, poi-ooxml) — used to read/write XLSX files. See `Readme.md` for examples of detecting numeric vs date cells and how to use `DateUtil.isCellDateFormatted`.
- MySQL Connector/J — driver is required at runtime. `Conexion` builds a plain JDBC URL (no SSL/query string parameters). Additional connection flags should be provided in `config.properties`.

## Small, concrete examples for AI edits

- To implement Excel parsing, follow the README example: use `WorkbookFactory.create(new File(inputFile))`, iterate sheets, treat sheet.getSheetName() as `TableModel.name`, read row 0 for field names and row 1 for type hints; map POI `CellType` to `FieldType` (see `FieldType` enum).
- When creating the JDBC connection keep the same behavior: read `host`, `port`, and `database` and build `jdbc:mysql://<host>:<port>/<database>` and pass the `Properties` object to `DriverManager.getConnection` (so `user` and `password` are read by the driver).

## Things NOT to change without broad edits

- Do not change how configuration is loaded (FileInputStream of `config.properties`) unless you update all call sites and update the README and tests.
- Do not change Java target/version in `pom.xml` without ensuring CI/dev machines support Java 21.

## Open issues / TODOs for contributors

- `ExcelReader` is empty — implement parsing and mapping to `modelo` classes.
- `WorkbookModel`, `TableModel`, and models are incomplete (no constructors/getters) — add immutable/POJO patterns consistent with small teaching projects.

---

If you'd like, I can: (1) implement `ExcelReader` skeleton that reads a workbook and populates `TableModel`/`FieldModel`, (2) add a sample `config.properties.example` and tests that assert parsing behavior. Which would you prefer next?  