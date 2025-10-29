package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        validate3(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    //중복 있으면 튕구기
    private void validate2(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
        }

    }
    //값 벗어나면 튕구기
    private void validate3(List<Integer> numbers) {
        if(numbers.stream().anyMatch(number -> number < 1 || number > 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이에 있어야합니다.");
        }

    }

    // TODO: 추가 기능 구현
}
