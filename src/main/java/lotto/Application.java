package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Error.ERROR;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("구매액을 입력해주세요:");
            int buyLotto =Integer.parseInt(Console.readLine());
            validateBuy(buyLotto);
            System.out.println("당첨 번호를 입력해주세요");
            List<Integer> winNumbers = winN();
            System.out.println("보너스 번호를 입력하세요");
            int bonus = Integer.parseInt(Console.readLine());
            Lotto lotto = new Lotto(winNumbers);
            LottoResult lr=new LottoResult(buyLotto,lotto,bonus);
            lr.run();




        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 형식입니다.", e);

        } catch (IllegalArgumentException e) {

            throw e;

        }
    }
    private static void validateBuy(int buyLotto) {
        if((double)buyLotto%1000!=0){
            throw new IllegalArgumentException(ERROR+"구매금액은 1000원 단위여야 합니다");
        }
    }

    private static List<Integer> winN() {
        String winNumber = Console.readLine();
        String[] split = winNumber.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String s : split) {
            winNumbers.add(Integer.parseInt(s));
        }
        return winNumbers;
    }
}
