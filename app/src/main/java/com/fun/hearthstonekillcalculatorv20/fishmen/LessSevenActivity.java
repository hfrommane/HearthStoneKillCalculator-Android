package com.fun.hearthstonekillcalculatorv20.fishmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fun.hearthstonekillcalculatorv20.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HZF on 2016/4/26.
 */
public class LessSevenActivity extends AppCompatActivity {

    private static final String TAG = LessSevenActivity.class.getSimpleName();

    private int numOfFishMen;
    private int numOfBluegillWarrior;
    private int numOfMurlocWarleader;
    private int numOfOldMurkEye;

    //总斩杀值
    private int killAll;
    //每个蓝腮战士的斩杀值
    private int eachBluegillWarrior;
    private int kiiOfBluegillWarrior;
    //每个老瞎眼的斩杀值
    private int eachOldMurkEye;
    private int killOfOldMurkEye;

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
    @Bind(R.id.tv_killOfBluegillWarrior)
    TextView tvKillOfBluegillWarrior;
    @Bind(R.id.tv_killOfOldMurkEye)
    TextView tvKillOfOldMurkEye;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_less);
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
        if (numOfBluegillWarrior > 0) {
            eachBluegillWarrior = 2 + numOfMurlocWarleader * 2;
        } else {
            eachBluegillWarrior = 0;
        }
        kiiOfBluegillWarrior = eachBluegillWarrior * numOfBluegillWarrior;

        if (numOfOldMurkEye > 0) {
            eachOldMurkEye = 2 + numOfMurlocWarleader * 2 + numOfFishMen - 1;
        } else {
            eachOldMurkEye = 0;
        }
        killOfOldMurkEye = (eachOldMurkEye) * numOfOldMurkEye;

        killAll = kiiOfBluegillWarrior + killOfOldMurkEye;
    }

    private void initView() {
        tvNumOfFishMen.setText(String.valueOf(numOfFishMen));
        tvNumOfBluegillWarrior.setText(String.valueOf(numOfBluegillWarrior));
        tvNumOfMurlocWarleader.setText(String.valueOf(numOfMurlocWarleader));
        tvNumOfOldMurkEye.setText(String.valueOf(numOfOldMurkEye));
        tvKill.setText(String.valueOf(killAll));
        tvKillOfBluegillWarrior.setText(String.valueOf(eachBluegillWarrior));
        tvKillOfOldMurkEye.setText(String.valueOf(eachOldMurkEye));
    }
}
