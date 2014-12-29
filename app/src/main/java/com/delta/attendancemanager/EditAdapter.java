package com.delta.attendancemanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by S on 12/28/2014.
 */
public class EditAdapter extends RecyclerView.Adapter<EditAdapter.EditViewHolder> {

    private List<EditCardInfo> attendanceList;

    public EditAdapter(List<EditCardInfo> contactList) {
        this.attendanceList = contactList;
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    @Override
    public void onBindViewHolder(final EditViewHolder attendanceviewholder, final int i)
    {
        final EditCardInfo eci = attendanceList.get(i);
        attendanceviewholder.subject.setText(eci.coursename);
        attendanceviewholder.date.setText(eci.classdate);
        attendanceviewholder.time.setText(eci.classtime);
        if(eci.attendance.equals(true))
        {
            attendanceviewholder.mark.setText("PRESENT");
            attendanceviewholder.change.setText("Mark as Absent");
        }
        else
        {
            attendanceviewholder.mark.setText("ABSENT");
            attendanceviewholder.change.setText("Mark as Present");
        }
        attendanceviewholder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(eci.attendance.equals(true))
                    {
                        eci.attendance = false;
                        attendanceviewholder.mark.setText("ABSENT");
                        attendanceviewholder.change.setText("Mark as Present");
                    }
                    else
                    {
                        eci.attendance = true;
                        attendanceviewholder.mark.setText("PRESENT");
                        attendanceviewholder.change.setText("Mark as Absent");
                    }
            }
        });

    }

    @Override
    public EditViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.layout_editcard, viewGroup, false);

        return new EditViewHolder(itemView);
    }

    public class EditViewHolder extends RecyclerView.ViewHolder {

        protected TextView subject;
        protected TextView date;
        protected TextView time;
        protected TextView mark;
        protected Button change;

        public EditViewHolder(View v)
        {
            super(v);
            subject = (TextView) v.findViewById(R.id.subjectcard);
            date = (TextView) v.findViewById(R.id.datecard);
            time = (TextView) v.findViewById(R.id.timecard);
            mark = (TextView) v.findViewById(R.id.mark);
            change = (Button) v.findViewById(R.id.changebutton);
        }

    }

}
