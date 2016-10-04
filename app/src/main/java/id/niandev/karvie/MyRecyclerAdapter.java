package id.niandev.karvie;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AbangAzmi on 11/14/2015.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<ItemController> {

    Context context;
    List<String> versionModels;

    //Array tambahan untuk picture
    public static List<String> ic = new ArrayList<String>();

    //Text
    public static List<String> titleOs = new ArrayList<String>();
    public static List<String> osSubList = new ArrayList<String>();

    //Set List Items
    public void setCardList(Context context) {

        //Ambil nama picture dari array list_icon
        String[] icon = context.getResources().getStringArray(R.array.list_icon);

        //text
        String[] listArray = context.getResources().getStringArray(R.array.os_version);
        String[] subTitleArray = context.getResources().getStringArray(R.array.os_sub_version);
        for (int i = 0; i < listArray.length; ++i) {
            ic.add(icon[i]);
            titleOs.add(listArray[i]);
            osSubList.add(subTitleArray[i]);
        }
    }

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        setCardList(context);
    }

    public MyRecyclerAdapter(List<String> versionModels) {
        this.versionModels = versionModels;

    }

    @Override
    public ItemController onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle, viewGroup, false);
        ItemController viewHolder = new ItemController(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemController versionViewHolder, int i) {

        //Cari Picture di drawable sesuai nama dari array
        //lalu menyusunnya sesuai urutan dari atas ke bawah
        int listIcon = context.getResources().getIdentifier(String.valueOf(ic.get(i)),
                "drawable", context.getPackageName());
        versionViewHolder.icon.setImageResource(listIcon);

        versionViewHolder.title.setText(titleOs.get(i));
        versionViewHolder.subTitle.setText(osSubList.get(i));
    }

    @Override
    public int getItemCount() {

        return titleOs == null ? 0 : titleOs.size();
    }
}