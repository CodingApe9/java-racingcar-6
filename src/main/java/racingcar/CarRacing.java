package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarRacing {
    private final List<Car> cars;
    private final int iterationNumBer;

    public CarRacing(List<Car> cars, int iterationNumBer) {
        this.cars = cars;
        this.iterationNumBer = iterationNumBer;
    }

    private List<Car> getChampionCars() {
        Integer maxLocation = cars.stream()
                .map(Car::getLocation)
                .max(Integer::compare)
                .get();

        List<Car> championCars = cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();

        return championCars;
    }

    private void progressOneStep() {
        for (Car car : cars) {
            if (isCarMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
