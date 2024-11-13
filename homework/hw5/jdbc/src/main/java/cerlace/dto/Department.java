package cerlace.dto;

/**
 * Класс {@code Department} является классом, передающим информацию
 * об рабочем отделе. Содержит в себе поле {@link #title},
 * содержащие название отдела.
 */
public enum Department {
    SALES("Отдел продаж"),
    MARKETING("Отдел маркетинга"),
    DEVELOPMENT("Отдел разработки"),
    TESTING("Отдел тестирования"),
    MANAGЕMENT("Отдел руководства"),
    HUMAN_RESOURCES("Отдел кадров");

    private final String title;

    Department(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
