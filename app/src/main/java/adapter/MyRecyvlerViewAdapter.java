package adapter;

/**
 * Created by Priya on 9/7/2015.
 */
import java.util.ArrayList;
import java.util.Objects;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.priyasindkar.recyclerviewdemo.R;

import model.DataObject;

public class MyRecyvlerViewAdapter extends RecyclerView.Adapter<MyRecyvlerViewAdapter.ViewHolder> {
    private ArrayList<DataObject> mDataset;
    static int VIEW_TYPE;
    public Context _ctx;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }


    public class ListViewHolder extends ViewHolder{
        public TextView txtHeader, txtfooter;

        public ListViewHolder ( View itemView ) {
            super ( itemView );
            txtHeader = (TextView) itemView.findViewById(R.id.textView);
            txtfooter = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    public class GridViewHolder extends ViewHolder{
        public TextView txtHeader1;
        public ImageView img;

        public GridViewHolder ( View itemView ) {
            super ( itemView );
            txtHeader1 = (TextView) itemView.findViewById(R.id.textView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    public class ThirdViewHolder extends ViewHolder{
        public TextView txtHeader1;
        public ImageView img, img1;

        public ThirdViewHolder ( View itemView ) {
            super ( itemView );
            txtHeader1 = (TextView) itemView.findViewById(R.id.textView);
            img = (ImageView) itemView.findViewById(R.id.img);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
        }
    }


    @Override
    public int getItemViewType(int position) {
        /*if (mDataset.get(position) instanceof DataObject) {
            return 0;
        } else if (mDataset.get(position) instanceof String) {
            return 1;
        }*/

        if(mDataset.get(position).getmType() == 0) {
            return 0;
        } else if (mDataset.get(position).getmType() == 1){
            return 1;
        } else if (mDataset.get(position).getmType() == 2){
            return 2;
        }
/*
        if(VIEW_TYPE == 0) {
            return 0;
        } else if(VIEW_TYPE == 1) {
            return 1;
        } else if (VIEW_TYPE == 2) {
            return 2;
        }*/

        return -1;
    }

    public void add(int position, DataObject item) {

        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(DataObject item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void setType(int type){
        VIEW_TYPE = type;
    }

    public MyRecyvlerViewAdapter(Context ctx,ArrayList<DataObject> myDataset) {
        this._ctx = ctx;
        mDataset = myDataset;
    }

    @Override
    public MyRecyvlerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        ViewHolder vh;

        LayoutInflater mInflater = LayoutInflater.from (parent.getContext());
        switch (viewType) {

            case 0:
                ViewGroup viewgroup1 = ( ViewGroup ) mInflater.inflate ( R.layout.item, parent, false );
                ListViewHolder listHolder = new ListViewHolder (viewgroup1);
                return listHolder;
            case 1:
                ViewGroup viewgroup2 = ( ViewGroup ) mInflater.inflate ( R.layout.item_grid, parent, false );
                GridViewHolder gridHolder = new GridViewHolder (viewgroup2);
                return gridHolder;

            case 2:
                ViewGroup viewgroup3 = ( ViewGroup ) mInflater.inflate ( R.layout.item_three, parent, false );
                ThirdViewHolder thirdHolder = new ThirdViewHolder (viewgroup3);
                return thirdHolder;

            default:
                ViewGroup viewgroup4 = ( ViewGroup ) mInflater.inflate ( R.layout.item, parent, false );
                GridViewHolder gridHolder1 = new GridViewHolder (viewgroup4);
                return gridHolder1;
        }

    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final DataObject name = (DataObject) mDataset.get(position);

        switch (viewHolder.getItemViewType () ) {
            case 0:
                ListViewHolder listHolder = ( ListViewHolder ) viewHolder;


                listHolder.txtHeader.setText(name.getmText1());
                listHolder.txtfooter.setText(name.getmText2());



                break;
            case 1:
                GridViewHolder groupViewHolder = ( GridViewHolder ) viewHolder;

                groupViewHolder.txtHeader1.setText(name.getmText1());

                break;

            case 2:
                Log.e("thrid", "thirsd");
                ThirdViewHolder thirdViewHolder = ( ThirdViewHolder ) viewHolder;
                thirdViewHolder.txtHeader1.setText(name.getmText1());
                break;

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}