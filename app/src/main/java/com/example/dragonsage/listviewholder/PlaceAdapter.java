package com.example.dragonsage.listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DragonSage on 10/3/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId;
    Place mData[] = null;

    public PlaceAdapter(Context context, int resource, Place[] data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlaceHolder holder = null;

        //if we don't have a row view to reuse
        if (row==null){

            // create a new view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlaceHolder();

            holder.nameView = (TextView)row.findViewById(R.id.nameTextView);
            holder.zipView = (TextView)row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView)row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else {
            //Otherwise use an existing one
            holder = (PlaceHolder)row.getTag();
        }

        //Getting data from the Array
        Place place = mData[position];

        //SetUp and Reuse the same Listener for each row
        holder.imageView.setOnClickListener(popUpListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);

        //Setting the view to reflect the data we need to display
        holder.nameView.setTag(place.mNameOfPlace);
        holder.zipView.setTag(String.valueOf(place.mZipCode));

        //for getting the image
        int resID = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resID);

        // returning the row view (as this is called getView)
        return row;
    }

    View.OnClickListener popUpListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Integer viewPosition = (Integer) view.getTag();
            Place p = mData[viewPosition];
            Toast.makeText(mContext, p.mPopup, Toast.LENGTH_SHORT).show();

        }
    };

    public static class PlaceHolder{

        TextView nameView;
        TextView zipView;
        ImageView imageView;

    }

}

