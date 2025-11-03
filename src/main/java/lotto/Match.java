package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.staticWord.*;

public class Match {
    private LottoResult result;
    private int bonus;
    private Lotto lotto;

    public Match(LottoResult lr, int bonus, Lotto lotto) {
        this.result = lr;
        this.bonus = bonus;
        this.lotto = lotto;
    }

