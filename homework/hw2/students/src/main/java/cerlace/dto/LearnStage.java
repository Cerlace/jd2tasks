package cerlace.dto;

/**
 * Класс {@code LearnStage} является классом, передающим информацию
 * об стадии обучения. Содержит в себе поле {@link #title},
 * содержащие название стадии обучения.
 */
public enum LearnStage {
    ANALISE("Разборы"),
    PRACTICE("Практические занятия"),
    LECTURE("Лекции");

    private final String title;

    LearnStage(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
