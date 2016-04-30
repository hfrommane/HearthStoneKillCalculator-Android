package com.fun.hearthstonekillcalculatorv20.fishmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.fun.hearthstonekillcalculatorv20.R;
import com.fun.hearthstonekillcalculatorv20.adapter.FishAdapter;
import com.fun.hearthstonekillcalculatorv20.model.FishMen;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by HZF on 2016/4/27.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    private List<FishMen> fishMenList;

    @Bind(R.id.lv_fish)
    ListView lvFish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        fishMenList = (List<FishMen>) bundle.getSerializable("fishMen");
        Collections.sort(fishMenList, new Comparator<FishMen>() {
            @Override
            public int compare(FishMen lhs, FishMen rhs) {
                return lhs.getTotal().compareTo(rhs.getTotal());
            }
        });
        lvFish.setAdapter(new FishAdapter(this, fishMenList));
    }
}
