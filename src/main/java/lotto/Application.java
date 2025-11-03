package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            runApplication();
        } catch (IllegalArgumentException e) {
            // [ERROR] 메시지 출력 후 프로그램 종료
            System.out.println(e.getMessage());
        }
    }

    private static void runApplication() {
        LottoResult lr = inputPurchaseAmount();

        Lotto lotto = inputWinningNumbers();

        int bonus = inputBonusNumber(lotto);

        Match match = new Match(lr, bonus, lotto);
        match.match();
    }

    private static LottoResult inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int buyLotto;
        try {
            buyLotto = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(staticWord.ERROR.getValue() + "유효하지 않은 숫자 형식입니다. (구입금액)");
        }
        return new LottoResult(buyLotto);
    }

    private static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return new Lotto(parseWinningNumbers());
    }

    private static List<Integer> parseWinningNumbers() {
        String winNumber = Console.readLine();
        String[] split = winNumber.split(",");
        List<Integer> winNumbers = new ArrayList<>();

        try {
            for (String s : split) {
                winNumbers.add(Integer.parseInt(s.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(staticWord.ERROR.getValue() + "당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
        }
        return winNumbers;
    }

    private static int inputBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus;
        try {
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(staticWord.ERROR.getValue() + "유효하지 않은 숫자 형식입니다. (보너스 번호)");
        }

        validateBonus(lotto, bonus);
        return bonus;
    }

    private static void validateBonus(Lotto lotto, int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(staticWord.ERROR.getValue() + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(staticWord.ERROR.getValue() + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}