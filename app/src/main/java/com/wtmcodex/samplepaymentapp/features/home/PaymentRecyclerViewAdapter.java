package com.wtmcodex.samplepaymentapp.features.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wtmcodex.samplepaymentapp.R;
import com.wtmcodex.samplepaymentapp.databinding.PaymentCardViewItemBinding;

import java.util.ArrayList;
import java.util.List;

public class PaymentRecyclerViewAdapter extends RecyclerView.Adapter<PaymentRecyclerViewAdapter.PaymentViewHolder> {
    private OnItemClickedListener onItemClickedListener;
    private List<PaymentViewItem> viewItems = new ArrayList<PaymentViewItem>();

    PaymentRecyclerViewAdapter(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public void setViewItems(List<PaymentViewItem> viewItems) {
        this.viewItems = viewItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return viewItems.size();
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentViewHolder(PaymentCardViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        PaymentViewItem viewItem = viewItems.get(position);
        holder.bind(viewItem);
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {
        private PaymentCardViewItemBinding itemBinding;

        PaymentViewHolder(PaymentCardViewItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(PaymentViewItem viewItem) {
            itemBinding.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickedListener != null) {
                        onItemClickedListener.onItemClicked(viewItem);
                    }
                }
            });

            itemBinding.tvTitle.setText(viewItem.getTitle());
            Glide.with(itemBinding.ivImage.getContext())
                    .load(viewItem.getLogoUrl())
                    .placeholder(R.drawable.placeholder)
                    .into(itemBinding.ivImage);

        }
    }

    public interface OnItemClickedListener {
        void onItemClicked(PaymentViewItem item);
    }
}
