package cerlace.strategies;

import cerlace.dto.LearnStage;
import cerlace.utils.RounderUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Абстрактный класс {@code StudyStrategy} является классом, реализующим
 * логику обучения. Построен по паттерну "стратегия", наследники данного класса
 * являются реализациями стратегий обучения.
 * Содержит в себе поле {@link #studyTimeMultiplier}, обозначающее множитель
 * времени обучения и {@link #learnStages}, содержащее стадии обучения.
 */
public abstract class StudyStrategy {
    private final int studyTimeMultiplier;
    protected final List<LearnStage> learnStages = new ArrayList<>();

    /**
     * Конструктор создает объект стратегии обучения, задает множитель времени обучения
     * {@link #studyTimeMultiplier} и выполняет метод {@link #addLearnStages()}.
     *
     * @param studyTimeMultiplier множитель времени обучения.
     */
    public StudyStrategy(int studyTimeMultiplier) {
        this.studyTimeMultiplier = studyTimeMultiplier;
        addLearnStages();
    }

    /**
     * Метод считает время, затраченное на каждую стадию обучения,
     * и добавляет результаты в {@code Map<LearnStage, Double>}
     *
     * @param hoursToLearn базовое время на полное освоение навыка;
     * @param talent       талант изучающего;
     * @return {@code Map<LearnStage, Double>}, которая содержит
     * данные о времени, затраченном на каждую стадию.
     */
    public Map<LearnStage, Double> study(double hoursToLearn, double talent) {
        int stagesCount = learnStages.size();
        double timeForStage = hoursToLearn * studyTimeMultiplier / talent / stagesCount;

        Map<LearnStage, Double> learnTimeMap = new HashMap<>();
        for (LearnStage stage : learnStages) {
            learnTimeMap.put(stage, RounderUtil.round(timeForStage, 2));
        }
        return learnTimeMap;
    }

    /**
     * Метод, необходимый для инициализации объекта {@code StudyStrategy}.
     * Реализация этого метода ДОЛЖНА добавлять в {@link #learnStages} хотя
     * бы один объект {@code LearnStage}.
     */
    protected abstract void addLearnStages();
}
