package com.example.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TimeLineModel> timeLineModelList;
    private Context context;

    public TimeLineAdapter(List<TimeLineModel> timeLineModelList, Context context) {
        this.timeLineModelList = timeLineModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_day, parent, false);
//        return new RecyclerView.ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ((RecyclerView.ViewHolder) holder).textView.setText(timeLineModelList.get(position).getName());
//        ((ViewHolder) holder).textViewDescription.setText(timeLineModelList.get(position).getDescription());
//        ((ViewHolder)holder).textViewTime.setText(timeLineModelList.get(position).getTime());
//
//        if (timeLineModelList.get(position).getStatus().equals("inactive"))
//            ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_remove_circle_outline_black_24dp));
//        else
//            ((ViewHolder) holder).timelineView.setMarker(context.getDrawable(ic_check_circle_black_24dp));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    private class ViewHolder extends RecyclerView.ViewHolder {

//        TimelineView timelineView;
//        TextView textView, textViewDescription, textViewTime;
//
        ViewHolder(View itemView, int viewType) {
            super(itemView);
//            timelineView = itemView.findViewById(R.id.row_timeline_layout_time_marker);
//            textView = itemView.findViewById(R.id.row_timeline_layout_text_view_name);
//            textViewDescription = itemView.findViewById(R.id.row_timeline_layout_text_view_description);
//            textViewTime = itemView.findViewById(R.id.row_timeline_layout_text_view_time);
//
//            timelineView.initLine(viewType);
        }
    }
}
