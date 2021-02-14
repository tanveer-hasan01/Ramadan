package com.example.ramadan;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolde> {

    ArrayList<Model_Data>data;
    Context context;

    public AdapterData(ArrayList<Model_Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterData.ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ramadan_list,parent,false);

        return new ViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.ViewHolde holder, int position) {




       if (data.get(position).getId().equals("1")){

            holder.date.setText("১ম রমজান");

        }
        else if (data.get(position).getId().equals("2")){
            holder.date.setText("২য় রমজান");

        }
       else if (data.get(position).getId().equals("3")){

            holder.date.setText("৩য় রমজান");
        }
       else {
            holder.date.setText(data.get(position).getId()+" তম রমজান");

        }

       if (data.get(position).getCategory().equals("rohmot"))
       {
           holder.category.setText("রহমত");
       }

       holder.seheri.setText("  সেহেরি : "+data.get(position).getSeheri());
       holder.iftari.setText("  ইফতার :  "+data.get(position).getIftar());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {

        TextView date,seheri,iftari,category;

        public ViewHolde(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.th_ramjan);
            seheri=itemView.findViewById(R.id.seheri);
            iftari=itemView.findViewById(R.id.iftari);
            category=itemView.findViewById(R.id.category);

        }
    }
}
