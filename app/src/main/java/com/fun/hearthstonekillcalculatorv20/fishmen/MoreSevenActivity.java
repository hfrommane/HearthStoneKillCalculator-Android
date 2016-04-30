package com.fun.hearthstonekillcalculatorv20.fishmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.fun.hearthstonekillcalculatorv20.R;
import com.fun.hearthstonekillcalculatorv20.model.FishMen;
import com.fun.hearthstonekillcalculatorv20.utils.Combination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HZF on 2016/4/26.
 */
public class MoreSevenActivity extends AppCompatActivity {

    private static final String TAG = MoreSevenActivity.class.getSimpleName();

    private int numOfFishMen;
    private int numOfBluegillWarrior;
    private int numOfMurlocWarleader;
    private int numOfOldMurkEye;
    private List<Integer> kill;
    private int minimum;
    private double count;
    private double percentage;
    private List<FishMen> fishMen;

    @Bind(R.id.tv_numOfFishMen)
    TextView tvNumOfFishMen;
    @Bind(R.id.tv_numOfBluegillWarrior)
    TextView tvNumOfBluegillWarrior;
    @Bind(R.id.tv_numOfMurlocWarleader)
    TextView tvNumOfMurlocWarleader;
    @Bind(R.id.tv_numOfOldMurkEye)
    TextView tvNumOfOldMurkEye;
    @Bind(R.id.tv_kill)
    TextView tvKill;
    @Bind(R.id.tv_probability)
    TextView tvProbability;
    @Bind(R.id.bt_detail)
    Button btDetail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_more);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        numOfFishMen = intent.getIntExtra("numOfFishMen", 0);
        numOfBluegillWarrior = intent.getIntExtra("numOfBluegillWarrior", 0);
        numOfMurlocWarleader = intent.getIntExtra("numOfMurlocWarleader", 0);
        numOfOldMurkEye = intent.getIntExtra("numOfOldMurkEye", 0);

        caculateKill();

        initView();
    }

    private void caculateKill() {
        int[] num = new int[numOfFishMen];
        int m = 7;
        for (int i = 0; i < numOfBluegillWarrior; i++) {
            num[i] = i;
        }
        for (int i = 0; i < numOfMurlocWarleader; i++) {
            num[numOfBluegillWarrior + i] = i + 4;
        }
        for (int i = 0; i < numOfOldMurkEye; i++) {
            num[numOfBluegillWarrior + numOfMurlocWarleader + i] = i + 8;
        }
        List<List<String>> listOfFishmen = new ArrayList<>();

        List list = Combination.combine(num, m);
        for (int i = 0; i < list.size(); i++) {
            int[] a = (int[]) list.get(i);
            List<String> fishmen = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                //System.out.print(a[j] + "\t");
                if (a[j] == 0 || a[j] == 1 || a[j] == 2 || a[j] == 3) {
                    fishmen.add("b");
                }
                if (a[j] == 4 || a[j] == 5 || a[j] == 6 || a[j] == 7) {
                    fishmen.add("l");
                }
                if (a[j] == 8 || a[j] == 9) {
                    fishmen.add("o");
                }
            }
            listOfFishmen.add(fishmen);
        }

        kill = new ArrayList();
        fishMen = new ArrayList<>();
        for (int i = 0; i < listOfFishmen.size(); i++) {
            caculateKillForEach(listOfFishmen.get(i));
        }

        int[] killArray = new int[kill.size()];
        for (int i = 0; i < killArray.length; i++) {
            killArray[i] = kill.get(i);
        }
        Arrays.sort(killArray);
        minimum = killArray[0];
        for (int i = 0; i < killArray.length; i++) {
            if (minimum == killArray[i]) {
                count++;
            }
        }

        double killArrayLength = killArray.length;
        percentage = Math.round(count / killArrayLength * 100);
    }

    private void caculateKillForEach(List<String> listOfOneFishmen) {
        int reBirthBluegillWarrior = 0;
        int reBirthMurlocWarleader = 0;
        int reBirthOldMurkEye = 0;

        for (int i = 0; i < listOfOneFishmen.size(); i++) {
            String fishName = listOfOneFishmen.get(i);
            if ("b".equals(fishName)) {
                reBirthBluegillWarrior++;
            } else if ("l".equals(fishName)) {
                reBirthMurlocWarleader++;
            } else if ("o".equals(fishName)) {
                reBirthOldMurkEye++;
            }
        }

        int total;
        int eachBluegillWarrior;
        int kiiOfBluegillWarrior;
        int eachOldMurkEye;
        int killOfOldMurkEye;

        eachBluegillWarrior = reBirthBluegillWarrior == 0 ? 0 : 2 + reBirthMurlocWarleader * 2;
        kiiOfBluegillWarrior = eachBluegillWarrior * reBirthBluegillWarrior;
        eachOldMurkEye = reBirthOldMurkEye == 0 ? 0 : 2 + reBirthMurlocWarleader * 2 + 7 - 1;
        killOfOldMurkEye = (eachOldMurkEye) * reBirthOldMurkEye;

        total = kiiOfBluegillWarrior + killOfOldMurkEye;
        kill.add(total);

        FishMen fish = new FishMen();
        fish.setReBirthBluegillWarrior(reBirthBluegillWarrior);
        fish.setReBirthMurlocWarleader(reBirthMurlocWarleader);
        fish.setReBirthOldMurkEye(reBirthOldMurkEye);
        fish.setEachBluegillWarrior(eachBluegillWarrior);
        fish.setEachOldMurkEye(eachOldMurkEye);
        fish.setTotal(total);
        fishMen.add(fish);
    }

    private void initView() {
        tvNumOfFishMen.setText(String.valueOf(numOfFishMen));
        tvNumOfBluegillWarrior.setText(String.valueOf(numOfBluegillWarrior));
        tvNumOfMurlocWarleader.setText(String.valueOf(numOfMurlocWarleader));
        tvNumOfOldMurkEye.setText(String.valueOf(numOfOldMurkEye));
        tvKill.setText(String.valueOf(minimum));
        tvProbability.setText(percentage + "%");
    }

    @OnClick(R.id.bt_detail)
    public void onClick() {
        Intent intent = new Intent(MoreSevenActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("fishMen", (Serializable) fishMen);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
