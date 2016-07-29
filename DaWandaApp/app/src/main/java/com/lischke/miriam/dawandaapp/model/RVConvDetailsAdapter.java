package com.lischke.miriam.dawandaapp.model;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lischke.miriam.dawandaapp.R;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConvContext;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbMessageDetails;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbUser;

import java.util.List;

/**
 * Created by Miriam on 22.07.2016.
 */
public class RVConvDetailsAdapter extends RecyclerView.Adapter<RVConvDetailsAdapter.ConversationViewHolder>{

    private  Context context;
    List<DbMessageDetails> messagesList;
    List<DbConvContext> convconList;
    List<DbUser> userList;

    public RVConvDetailsAdapter(Context context, List<DbMessageDetails>  mList, List<DbConvContext> cList, List<DbUser> uList){

        this.context = context;
        this.messagesList = mList;
        this.convconList = cList;
        this.userList = uList;
        Log.d("RVConvDetailsAdapter","Created ADAPTER");
    }



    @Override
    public RVConvDetailsAdapter.ConversationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = null;
        int reciver = messagesList.get(viewType).getReceiver();
        int sender = messagesList.get(viewType).getSender();
        int me = convconList.get(viewType).getMe();

        if (me == sender){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conv_details_item_me, viewGroup, false);
        }
        else if(me == reciver){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.conv_details_item_you, viewGroup, false);
        }

        ConversationViewHolder cvh = new ConversationViewHolder(v);
        return cvh;
    }




    @Override
    public void onBindViewHolder(RVConvDetailsAdapter.ConversationViewHolder holder, int position) {

        DbMessageDetails message = messagesList.get(position);

//        DbUser sender = userList.get(0);
        DbConvContext convContext = convconList.get(position);

        Log.d("OnBind","Size: "+messagesList.size()+" Position: "+position);

//        "http:" + sender.getAvatar()
//        Picasso.with(context).load(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.senderPhoto);

        if(messagesList.get(position).getReceiver() == convContext.getMe()){

            holder.senderName.setText(convContext.getUser());
            holder.conversationText.setText(message.getText());
        }else {

            holder.senderName.setText(convContext.getMe());
            holder.conversationText.setText(message.getText());

        }
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

        public ConversationViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv_l);
            senderPhoto = (ImageView) itemView.findViewById(R.id.sender_photo1);
            senderName = (TextView) itemView.findViewById(R.id.sender_name1);
            conversationText = (TextView) itemView.findViewById(R.id.conversation_text1);

        }
    }
}
