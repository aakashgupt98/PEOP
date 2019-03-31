package aakashgupt98.navifragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Project_list_Adapter extends RecyclerView.Adapter<Project_list_Adapter.MyViewHolder> {

    private List<Project_list_Feeds> feedsList;
    private Context context;
    private LayoutInflater inflater;

    public Project_list_Adapter(List<Project_list_Feeds> feedsList) {

        this.context = context;
        this.feedsList = feedsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.project_list_layout, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Project_list_Feeds feeds = feedsList.get(position);
        //Pass the values of feeds object to Views
        holder.title.setText(feeds.getFeedName());
        holder.content.setText(feeds.getContent());
       // holder.imageview.setImageUrl(feeds.getImgURL(), NetworkController.getInstance(context).getImageLoader());
        holder.date.setText(feeds.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                context.startActivity(new Intent(context, ProjectDetailActivity.class)
//                        .putExtra("title", feedsList.get(position).getFeedName())
//                        .putExtra("date", feedsList.get(position).getDate())
//                        .putExtra("image",  feedsList.get(position).getImgURL())
//                        .putExtra("content", feedsList.get(position).getContent())
//                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView content, title,date;
        //private NetworkImageView imageview;
        //private ProgressBar ratingbar;

        public MyViewHolder(View itemView) {
            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.title_news);
//            content = (TextView) itemView.findViewById(R.id.content_news);
//            date = (TextView) itemView.findViewById(R.id.date_news);

        }
    }

}