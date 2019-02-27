package org.development.aihd.adapters.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import org.development.aihd.R;
import org.development.aihd.model.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Rodney on 27/03/2018.
 */

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyViewHolder>
        implements Filterable {

    private List<Report> reportList;
    private List<Report> reportListFiltered;
    private ReportsAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, date;
        private ImageView thumbnail;

        private MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            date = view.findViewById(R.id.date);
            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onReportSelected(reportListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }


    public ReportAdapter(Context context, List<Report> reportList, ReportsAdapterListener listener) {
        this.listener = listener;
        this.reportList = reportList;
        this.reportListFiltered = reportList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_report, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Report report = reportListFiltered.get(position);
        holder.name.setText(report.getName());
        holder.date.setText(report.getDate());
        byte[] imgByte = report.getImage();
        Bitmap bitImageReport = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);

        holder.thumbnail.setImageBitmap(bitImageReport);
    }

    @Override
    public int getItemCount() {
        return reportListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    reportListFiltered = reportList;
                } else {
                    List<Report> filteredList = new ArrayList<>();
                    for (Report row : reportList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getName().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    reportListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = reportListFiltered;
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                reportListFiltered = (ArrayList<Report>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ReportsAdapterListener {
        void onReportSelected(Report report);
    }
}
