package com.example.usuario.icantfindjson.pojo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.icantfindjson.R;

import java.util.List;

/**
 * https://guides.codepath.com/android/using-the-recyclerview
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<Repo> repoList;

    private Context mContext;


    public RepositoryAdapter(Context context, List<Repo> repos) {
        repoList = repos;
        mContext = context;
    }
    public void setRepos(List<Repo> repos)
    {
        repoList=repos;
        notifyDataSetChanged();
    }

    private Context getContext() {
        return mContext;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = repoList.get(position);
        TextView textView1= holder.tvName;
        textView1.setText(repo.getName());
        TextView textView2= holder.txvDespcription;
        textView2.setText(repo.getDescription().toString());
        TextView textView3=holder.txvDate;
        textView3.setText(repo.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView txvDespcription;
        public TextView txvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textView1);
            txvDate = (TextView) itemView.findViewById(R.id.textView2);
            txvDespcription=(TextView) itemView.findViewById(R.id.textView3);
        }
    }
}