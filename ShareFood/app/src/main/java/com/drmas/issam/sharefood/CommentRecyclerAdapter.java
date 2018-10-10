package com.drmas.issam.sharefood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by drmas on 11/04/2018.
 */

public class CommentRecyclerAdapter  extends RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder>{

    public List<Comments> commentsList;
    public Context context;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    private final static int FADE_DURATION = 1000;

    public CommentRecyclerAdapter(List<Comments> commentsList){
        this.commentsList = commentsList;

    }

    @Override
    public CommentRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.comment_list, parent, false );
        context = parent.getContext();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        return new CommentRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentRecyclerAdapter.ViewHolder holder, final int position) {

        holder.setIsRecyclable( false );

        long date = commentsList.get( position ).getTimestamp().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat( " dd MMM yyyy  h:mm" );
        final String dataString = sdf.format( date );
        holder.setUserComment( dataString );

        String message_comment = commentsList.get( position ).getMessage();
        holder.setMessageComment( message_comment );

        String user_id = commentsList.get( position ).getUser_id();
        firebaseFirestore.collection( "Users" ).document(user_id).get().addOnCompleteListener( new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()){

                    String userName = task.getResult().getString( "name" );
                    String userImage = task.getResult().getString( "image" );

                    holder.setUserData( userName, userImage );

                } else {

                    /// Error
                }

            }
        });

        holder.setAnimation(holder.itemView);


    }

    @Override
    public int getItemCount() {

        if(commentsList != null) {

            return commentsList.size();

        } else {

            return 0;

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView userNameComment, DataComment, txtMessageComment;
        private CircleImageView imageComment;

        public ViewHolder(View itemView) {
            super( itemView );
            mView = itemView;
        }

        public void setUserData(String name, String image){

            userNameComment = mView.findViewById( R.id.txtNameComment);
            imageComment = mView.findViewById( R.id.imgUserComment);

            userNameComment.setText( name );

            RequestOptions placeholder = new RequestOptions();
            // placeholder.placeholder( R.drawable.avatar );
            Glide.with( context ).applyDefaultRequestOptions( placeholder ).load( image ).into( imageComment );

        }

        public void setUserComment(String time){
            DataComment = mView.findViewById( R.id.txtDateComment);
            DataComment.setText( time );
        }

        private void setMessageComment(String comment){

            txtMessageComment = mView.findViewById( R.id.txtMessage_Comment );
            txtMessageComment.setText( comment );
        }

        public void setAnimation(View view){

            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

    }
}
