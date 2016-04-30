package com.fun.hearthstonekillcalculatorv20.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fun.hearthstonekillcalculatorv20.R;
import com.fun.hearthstonekillcalculatorv20.model.FishMen;

import java.util.List;

/**
 * Created by HZF on 2016/4/28.
 */
public class FishAdapter extends BaseAdapter {

    private Context context;
    private List<FishMen> mDatas;

    public FishAdapter(Context context, List<FishMen> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FishHolder fishHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_fish, null);
            fishHolder = new FishHolder();
            fishHolder.detailBluegillWarrior = (TextView) convertView.findViewById(R.id.tv_detail_bluegillWarrior);
            fishHolder.detailMurlocWarleader = (TextView) convertView.findViewById(R.id.tv_detail_murlocWarleader);
            fishHolder.detailOldMurkEye = (TextView) convertView.findViewById(R.id.tv_detail_oldMurkEye);
            fishHolder.detailTotal = (TextView) convertView.findViewById(R.id.tv_detail_total);
            convertView.setTag(fishHolder);
        } else {
            fishHolder = (FishHolder) convertView.getTag();
        }
        FishMen fishMen = mDatas.get(position);
        String textOfDetailBluegillWarrior = "共" + fishMen.getReBirthBluegillWarrior() + "个，每个" + fishMen.getEachBluegillWarrior();
        String textOfDetailOldMurkEye = "共" + fishMen.getReBirthOldMurkEye() + "个，每个" + fishMen.getEachOldMurkEye();
        String textOfDetailMurlocWarleader = "共" + fishMen.getReBirthMurlocWarleader() + "个";
        fishHolder.detailBluegillWarrior.setText(textOfDetailBluegillWarrior);
        fishHolder.detailMurlocWarleader.setText(textOfDetailMurlocWarleader);
        fishHolder.detailOldMurkEye.setText(textOfDetailOldMurkEye);
        fishHolder.detailTotal.setText(fishMen.getTotal() + "");
        return convertView;
    }

    class FishHolder {
        TextView detailBluegillWarrior;
        TextView detailMurlocWarleader;
        TextView detailOldMurkEye;
        TextView detailTotal;
    }
}
