package id.niandev.karvie;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AbangAzmi on 11/14/2015.
 */
public class ItemController extends RecyclerView.ViewHolder implements View.OnClickListener {

    //Variable
    CardView cardItemLayout;
    ImageView icon; // Picture
    TextView title;
    TextView subTitle;

    public ItemController(View itemView) {
        super(itemView);

        //Set id
        cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);

        //Tambahan untuk id Picture
        icon = (ImageView)itemView.findViewById(R.id.icon_item);

        //id Text
        title = (TextView) itemView.findViewById(R.id.listitem_name);
        subTitle = (TextView) itemView.findViewById(R.id.listitem_subname);

        //onClick
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //tampilkan toas ketika click
        Toast.makeText(v.getContext(),
                String.format("Position %d", getAdapterPosition()),
                Toast.LENGTH_SHORT).show();
    }

}