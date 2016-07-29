package com.lischke.miriam.dawandaapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConvContext;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbMessageDetails;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbUser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Miriam on 22.07.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ConversationViewHolder>{

    private  Context context;
    List<DbMessageDetails> messagesList;
    List<DbUser> userList;
    List<DbConvContext> convconList;


    public RVAdapter(Context context, List<DbMessageDetails>  mList, List<DbUser> uList, List<DbConvContext> cList){

        this.context = context;
        this.messagesList = mList;
        this.userList = uList;
        this.convconList = cList;

        Log.d("RVAdapter","Created ADAPTER");
    }



    @Override
    public RVAdapter.ConversationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;

        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ConversationViewHolder cvh = new ConversationViewHolder(v);
        return cvh;
    }




    @Override
    public void onBindViewHolder(RVAdapter.ConversationViewHolder holder, int position) {

        DbMessageDetails message = messagesList.get(position);
        DbUser sender = userList.get(position);


        Log.d("OnBind","Size: "+messagesList.size());

        Picasso.with(context).load("http:" + sender.getAvatar())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.senderPhoto);

        holder.senderName.setText(sender.getUsername());
//        holder.conversationId.setText(convconList.get(position).getOrder());
        holder.conversationText.setText(message.getText());
        holder.cv.setId(convconList.get(position).getOrder());


    }




    @Override
    public int getItemCount() {
        return messagesList.size();
    }



    public class ConversationViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public ImageView senderPhoto;
        public TextView senderName;
        public TextView conversationText;
        public TextView conversationId;

        public ConversationViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv_l);
            senderPhoto = (ImageView) itemView.findViewById(R.id.sender_photo1);
            senderName = (TextView) itemView.findViewById(R.id.sender_name1);
            conversationText = (TextView) itemView.findViewById(R.id.conversation_text1);
            conversationId = (TextView) itemView.findViewById(R.id.conversation_id);

//            cv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    ConversationsActivity.bruecke(cv.getId());
//                }
//            });

        }
    }
}
