package com.fun.hearthstonekillcalculatorv20.fishmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fun.hearthstonekillcalculatorv20.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by asus on 2016/1/29.
 */
public class FishMenActivity extends AppCompatActivity {

    private int numOfFishMen;//鱼人总数

    /*
    蓝腮战士
     */
    private int numOfBluegillWarrior = 0;
    @ViewInject(R.id.bluegill_warrior_sub)
    private Button bluegillWarriorSub;
    @ViewInject(R.id.bluegill_warrior_tv)
    private TextView bluegillWarriorTv;
    @ViewInject(R.id.bluegill_warrior_add)
    private Button bluegillWarriorAdd;

    /*
    鱼人领军
     */
    private int numOfMurlocWarleader = 0;
    @ViewInject(R.id.murloc_warleader_sub)
    private Button murlocWarleaderSub;
    @ViewInject(R.id.murloc_warleader_tv)
    private TextView murlocWarleaderTv;
    @ViewInject(R.id.murloc_warleader_add)
    private Button murlocWarleaderAdd;

    /*
    老瞎眼
     */
    private int numOfOldMurkEye = 0;
    @ViewInject(R.id.old_murk_eye_sub)
    private Button oldMurkEyeSub;
    @ViewInject(R.id.old_murk_eye_tv)
    private TextView oldMurkEyeTv;
    @ViewInject(R.id.old_murk_eye_add)
    private Button oldMurkEyeAdd;

    @ViewInject(R.id.calculator)
    private Button calculator; //点击计算

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_men);

        x.view().inject(this);

        /****************************** 蓝腮战士相关 **********************************/
        bluegillWarriorSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfBluegillWarrior > 0) {
                    numOfBluegillWarrior--;
                    numOfFishMen--;
                    bluegillWarriorTv.setText(numOfBluegillWarrior + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，不能再少了哦！", Toast.LENGTH_LONG).show();
                }
            }
        });
        bluegillWarriorAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfBluegillWarrior < 4) {
                    numOfBluegillWarrior++;
                    numOfFishMen++;
                    bluegillWarriorTv.setText(numOfBluegillWarrior + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，最多4个哦！", Toast.LENGTH_LONG).show();
                }
            }
        });

        /****************************** 鱼人领军相关 **********************************/
        murlocWarleaderSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfMurlocWarleader > 0) {
                    numOfMurlocWarleader--;
                    numOfFishMen--;
                    murlocWarleaderTv.setText(numOfMurlocWarleader + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，不能再少了哦！", Toast.LENGTH_LONG).show();
                }
            }
        });
        murlocWarleaderAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfMurlocWarleader < 4) {
                    numOfMurlocWarleader++;
                    numOfFishMen++;
                    murlocWarleaderTv.setText(numOfMurlocWarleader + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，最多4个哦！", Toast.LENGTH_LONG).show();
                }
            }
        });

        /****************************** 老瞎眼相关 **********************************/
        oldMurkEyeSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfOldMurkEye > 0) {
                    numOfOldMurkEye--;
                    numOfFishMen--;
                    oldMurkEyeTv.setText(numOfOldMurkEye + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，不能再少了哦！", Toast.LENGTH_LONG).show();
                }
            }
        });
        oldMurkEyeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOfOldMurkEye < 2) {
                    numOfOldMurkEye++;
                    numOfFishMen++;
                    oldMurkEyeTv.setText(numOfOldMurkEye + "");
                } else {
                    Toast.makeText(getApplicationContext(), "亲，最多2个哦！", Toast.LENGTH_LONG).show();
                }
            }
        });

        /****************************** 斩杀值相关 **********************************/
        calculator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (numOfFishMen > 7) {
                    Intent intent = new Intent(FishMenActivity.this, MoreSevenActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("numOfFishMen", numOfFishMen);
                    bundle.putInt("numOfBluegillWarrior", numOfBluegillWarrior);
                    bundle.putInt("numOfMurlocWarleader", numOfMurlocWarleader);
                    bundle.putInt("numOfOldMurkEye", numOfOldMurkEye);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(FishMenActivity.this, LessSevenActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("numOfFishMen", numOfFishMen);
                    bundle.putInt("numOfBluegillWarrior", numOfBluegillWarrior);
                    bundle.putInt("numOfMurlocWarleader", numOfMurlocWarleader);
                    bundle.putInt("numOfOldMurkEye", numOfOldMurkEye);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

}
