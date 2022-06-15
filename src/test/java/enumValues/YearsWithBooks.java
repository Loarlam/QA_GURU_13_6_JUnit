package enumValues;

public enum YearsWithBooks {
    FIRST_BOOK("2020","Истоки морали. В поисках человеческого у приматов"),
    SECOND_BOOK("2021","Что такое наука и как она работает");

    private String year;
    private String description;

    YearsWithBooks(String book, String description) {
        this.year = book;
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }
}
