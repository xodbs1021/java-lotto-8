package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.staticWord.ERROR;

public class LottoResult {
    private final int number; // 로또 구매 개수
    protected List<List<Integer>> numbers;

    public LottoResult(int buyLotto) {
        validateBuy(buyLotto);
        this.number = buyLotto / 1000;
        this.numbers = resultPick();

        printPurchasedLottos();
    }

    public int getLottoCount() {
        return number;
    }

    private void printPurchasedLottos() {
        System.out.println(number + "개를 구매했습니다.");
        print(numbers);
    }

    private static void validateBuy(int buyLotto) {
        if (buyLotto < 1000 || buyLotto % 1000 != 0) {
            throw new IllegalArgumentException(ERROR.getValue() + "구매금액은 1000원 이상의 단위여야 합니다.");
        }
    }

    private List<List<Integer>> resultPick() {
        List<List<Integer>> array = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            List<Integer> mutableNumbers = new ArrayList<>(randomNumbers);

            mutableNumbers.sort(Integer::compareTo);

            array.add(mutableNumbers);
        }
        return array;
    }

    private void print(List<List<Integer>> array) {
        for (List<Integer> integers : array) {
            System.out.println(integers);
        }
        System.out.println();
    }

}