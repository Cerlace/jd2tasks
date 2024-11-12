package cerlace.strategies.impl;

import cerlace.dto.LearnStage;
import cerlace.strategies.StudyStrategy;

/**
 * Класс {@code StrategyTypeThree} является классом, реализующим
 * стратегию обучения {@code StudyStrategy}.
 * Содержит в себе код, для создания альтернативной стратегии обучения.
 */
public class StrategyTypeThree extends StudyStrategy {
    private static final int STUDY_TIME_MULTIPLIER = 3;

    /**
     * Конструктор вызывает конструктор предка {@code StudyStrategy},
     * и передает в качестве параметра константу {@link #STUDY_TIME_MULTIPLIER},
     * содержащую множитель времени обучения.
     */
    public StrategyTypeThree() {
        super(STUDY_TIME_MULTIPLIER);
    }

    @Override
    public String toString() {
        return "Только практика";
    }

    @Override
    protected void addLearnStages() {
        learnStages.add(LearnStage.PRACTICE);
    }
}
