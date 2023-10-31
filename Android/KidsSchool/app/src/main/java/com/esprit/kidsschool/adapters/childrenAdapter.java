package com.esprit.kidsschool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.esprit.kidsschool.R;
import com.esprit.kidsschool.entities.Children;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by Habib on 09/12/2016.
 */

public class childrenAdapter extends ArrayAdapter<Children> {

    Context context;
    int resource;

    public childrenAdapter(Context context, int resource, ArrayList<Children> childrens) {
        super(context, resource, childrens);
        this.context = context;
        this.resource = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        ChildrenHolder holder = new ChildrenHolder();
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);

            holder.tvNom = (TextView) view.findViewById(R.id.tv_children_nom);
            holder.tvAvancement = (TextView) view.findViewById(R.id.tv_children_avancement);
            holder.tvNote = (TextView) view.findViewById(R.id.tv_children_note);
            holder.imgChildren = (ImageView) view.findViewById(R.id.img_children);
            view.setTag(holder);
        }
        else{
            holder = (ChildrenHolder) view.getTag();
        }

        holder.tvNom.setText(getItem(position).getNom());
        holder.tvAvancement.setText("");
        holder.tvNote.setText("Latest exam : "+getItem(position).getNote()+" / 30");
        System.out.println(getItem(position).getPhoto());
        if(getItem(position).getPhoto()!=null) {
            Picasso.with(context).load(getItem(position).getPhoto()).into(holder.imgChildren);
        }
        return view;
    }

    class ChildrenHolder {
        TextView tvNom;
        TextView tvAvancement;
        TextView tvNote;
        ImageView imgChildren;
    }

}
