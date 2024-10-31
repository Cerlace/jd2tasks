package cerlace.dto;

/**
 * Класс {@code Skill} являтся классом, передающим информацию
 * об навыке для изучения. Содержит в себе поле {@link #title},
 * содержащие название навыка, и поле {@link #hoursToLearn},
 * содержащее колличество часов для освоения навыка.
 */
public class Skill {
    private final String title;
    private final double hoursToLearn;

    /**
     * Конструктор создает объект навыка:
     *
     * @param title        название навыка;
     * @param hoursToLearn колличество часов для освоения навыка.
     */
    public Skill(String title, double hoursToLearn) {
        this.title = title;
        this.hoursToLearn = hoursToLearn;
    }

    @Override
    public String toString() {
        return String.format("Навык: %s, на освоение необходимо минимум %.2f часов.", title, hoursToLearn);
    }

    public String getTitle() {
        return title;
    }

    public double getHoursToLearn() {
        return hoursToLearn;
    }
}
