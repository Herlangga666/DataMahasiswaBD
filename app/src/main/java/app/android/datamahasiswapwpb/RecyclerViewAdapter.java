package app.android.datamahasiswapwpb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> {

    Context ctx;
    List<Mahasiswa> mahasiswa;
    OnUserClickListener listener;

    public RecyclerViewAdapter(Context ctx, List<Mahasiswa> mahasiswa , OnUserClickListener listener) {
        this.ctx = ctx;
        this.mahasiswa = mahasiswa;
        this.listener = listener;
    }

    public interface OnUserClickListener{
        void onUserClick(Mahasiswa current);
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list,parent,false);
        UserViewHolder userViewHolder = new UserViewHolder(v);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.UserViewHolder holder, final int position) {
        final Mahasiswa person = mahasiswa.get(position);
        holder.txtNama.setText(person.getNama());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailMahasiswa.class);
                String id = person.getId()+"";
                intent.putExtra("id",id);
                intent.putExtra("nama",person.getNama());
                intent.putExtra("tgl",person.getTgl_lahir());
                intent.putExtra("jenkel",person.getJenkel());
                intent.putExtra("alamat",person.getAlamat());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswa.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView txtNama;
        CardView cardView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
            cardView = itemView.findViewById(R.id.card);
        }
    }

}
