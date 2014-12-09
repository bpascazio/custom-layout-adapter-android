package edu.pace.pclc.customlayoutadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sscsis on 12/8/14.
 */
public class CustomArrayAdapter extends ArrayAdapter<Post> {

    private Context context;
    private Post[] posts;

    public CustomArrayAdapter(Context context, Post[] posts)
    {
        super(context, R.layout.post_layout, posts);
        this.context = context;
        this.posts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View postView = inflater.inflate(R.layout.post_layout, parent, false);

        ImageView imageView = (ImageView)postView.findViewById(R.id.postImage);
        DownloadImageTask myTask = new DownloadImageTask(imageView);
        myTask.execute("http://www.themusehotel.com/design/images/930-481/nyc-skyline.jpg");

        TextView postSomething = (TextView)postView.findViewById(R.id.posterName);
        postSomething.setText(""+position);


        return postView;

    }
}

