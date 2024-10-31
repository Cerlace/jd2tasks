package cerlace.strategies.impl;

import cerlace.dto.LearnStage;
import cerlace.strategies.StudyStrategy;

/**
 * Класс {@code StrategyTypeOne} является классом, реализующим
 * стратегию обучения {@code StudyStrategy}.
 * Содержит в себе код, для создания альтернативной стратегии обучения.
 */
public class StrategyTypeOne extends StudyStrategy {
    private static final int STUDY_TIME_MULTIPLIER = 1;

    /**
     * Конструктор вызывает конструктор предка {@code StudyStrategy},
     * и передает в качестве параметра константу {@link #STUDY_TIME_MULTIPLIER},
     * содержащую множитель времени обучения.
     */
    public StrategyTypeOne() {
        super(STUDY_TIME_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Разборы, практика и лекции";
    }

    @Override
    protected void addLearnStages() {
        learnStages.add(LearnStage.ANALISE);
        learnStages.add(LearnStage.PRACTICE);
        learnStages.add(LearnStage.LECTURE);
    }
}
