package com.drmas.issam.sharefood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;

import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by drmas on 01/04/2018.
 */

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder> {

    public List<Posts> postsList;
    public Context context;

    private final static int FADE_DURATION = 1000;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    public PostsRecyclerAdapter(List<Posts> postsList){

        this.postsList = postsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.sangle_list, parent, false );
        context = parent.getContext();

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        return new ViewHolder( view );
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.setIsRecyclable( false );

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder( context );
        alertDialog.setView( View.INVISIBLE );

        final String postId = postsList.get( position ).PostId;
        final String currentUserId = firebaseAuth.getCurrentUser().getUid();

        final String desc_data = postsList.get( position ).getDesc();
        holder.setDescText( desc_data );

        String image_url = postsList.get( position ).getImage_url();
        holder.setImagePost( image_url );

        String user_id = postsList.get( position ).getUser_id();
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

        long date = postsList.get( position ).getTimestamp().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat( " dd MMM yyyy  h:mm" );
        final String dataString = sdf.format( date );
        holder.setTime( dataString );

        // Get Likes count
        firebaseFirestore.collection( "Posts/" + postId + "/Likes" ).addSnapshotListener( new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {

                if (!queryDocumentSnapshots.isEmpty()){

                    int count = queryDocumentSnapshots.size();
                    holder.updateLikesCount( count );

                } else {

                    holder.updateLikesCount( 0 );
                }

            }
        });

        // Get Likes
        firebaseFirestore.collection( "Posts/" + postId + "/Likes" ).document(currentUserId).addSnapshotListener( new EventListener<DocumentSnapshot>() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {


                if(documentSnapshot.exists()){

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder.likeBtn.setImageDrawable(context.getDrawable(R.mipmap.action_licke_icon_red));
                    }

                } else {

                    holder.likeBtn.setImageDrawable(context.getDrawable(R.mipmap.action_like_icon_gray));

                }


            }
        });


            // Likes Features
        holder.likeBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseFirestore.collection( "Posts/" + postId + "/Likes" ).document(currentUserId).get().addOnCompleteListener( new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (!task.getResult().exists()){

                            Map<String, Object> likeMap = new HashMap<>();
                            likeMap.put( "timestamp", FieldValue.serverTimestamp());

                            firebaseFirestore.collection( "Posts/" + postId + "/Likes" ).document(currentUserId).set(likeMap);

                        } else {

                            firebaseFirestore.collection( "Posts/" + postId + "/Likes" ).document(currentUserId).delete();

                        }

                    }
                });

            }
        });

        holder.commentBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent commentIntent = new Intent(context, CommentActivity.class);
                commentIntent.putExtra( "comment_post_id", postId );
                context.startActivity(commentIntent);
            }
        });



        // Get Comments count
        firebaseFirestore.collection( "Posts/" + postId + "/Comments" ).addSnapshotListener( new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {

                if (!queryDocumentSnapshots.isEmpty()){

                    int count = queryDocumentSnapshots.size();
                    holder.updateCommentCount( count );

                } else {

                    holder.updateCommentCount( 0 );
                }

            }
        });

       holder.setAnimation(holder.itemView);
       holder.setScaleAnimation(holder.itemView);

        holder.postImageView.setOnLongClickListener( new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {


               alertDialog.setTitle( "Options" );
               alertDialog.setMessage( "Are you sure, You want to delete it" );
               alertDialog.setPositiveButton( "delete", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       firebaseFirestore.collection( "Posts" ).document( postId ).delete();
                       Toast.makeText( context, "Post delete", Toast.LENGTH_SHORT ).show();
                       Intent mainIntent = new Intent(context, MainActivity.class);
                       context.startActivity( mainIntent );
                   }
               });

               alertDialog.setNegativeButton( "cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                       dialog.dismiss();
                   }
               });

               final AlertDialog alert = alertDialog.create();
               alert.show();


               return false;
           }
       });


    } /// end holder

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View mView;
        private TextView descView, timeView, userName, txtLikeCount, TextComment;

        private ImageView postImageView;
        private CircleImageView userImage;

        private ImageButton likeBtn;
        private ImageButton commentBtn;

        public ViewHolder(View itemView) {
            super( itemView );
            mView = itemView;

            likeBtn = mView.findViewById( R.id.likeBtn );
            commentBtn = mView.findViewById( R.id.comment_Btn );

        }

        public void setDescText(String desc){
            descView = mView.findViewById( R.id.txtDescPost );
            descView.setText( desc );
        }

        public void setImagePost(String ImagePost){
            postImageView = mView.findViewById( R.id.imagePost );

            RequestOptions placeholder = new RequestOptions();
            //placeholder.placeholder( R.drawable.image_post );
            Glide.with( context ).applyDefaultRequestOptions( placeholder ).load( ImagePost ).into( postImageView );
        }

        public void setTime(String time){
            timeView = mView.findViewById( R.id.txtDatePost );
            timeView.setText( time );
        }

        public void setUserData(String name, String image){

            userName = mView.findViewById( R.id.txtNamePost);
            userImage = mView.findViewById( R.id.imgUserPost);

            userName.setText( name );

            RequestOptions placeholder = new RequestOptions();
           // placeholder.placeholder( R.drawable.avatar );
            Glide.with( context ).applyDefaultRequestOptions( placeholder ).load( image ).into( userImage );

        }

        public void updateLikesCount(int count){
            txtLikeCount = mView.findViewById( R.id.TextLikeCount );
            txtLikeCount.setText( count + " Likes" );
        }

        public void updateCommentCount(int count){
            TextComment = mView.findViewById( R.id.TextComment );
            TextComment.setText( count + " Comments" );
        }

        public void setAnimation(View view){

            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

        private void setScaleAnimation(View view) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }

        public void deletePost(){

        }



    }
}
