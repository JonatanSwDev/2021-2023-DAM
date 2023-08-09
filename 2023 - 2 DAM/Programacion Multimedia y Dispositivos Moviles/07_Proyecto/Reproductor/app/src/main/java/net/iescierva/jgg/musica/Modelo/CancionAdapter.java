package net.iescierva.jgg.musica.Modelo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import net.iescierva.jgg.musica.Data.RepositorioCanciones;
import net.iescierva.jgg.musica.R;
import java.io.IOException;

public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.CancionViewHolder> {
    private final RepositorioCanciones canciones;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int posicion);
    }

    public CancionAdapter(Context context, RepositorioCanciones canciones) {
        this.context = context;
        this.canciones = canciones;
    }

    @NonNull
    @Override
    public CancionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.elemento_lista, parent, false);
        return new CancionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CancionViewHolder holder, int position) {
        Cancion cancion = canciones.get(position);

        // Tratamiento de imágenes
        try {
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(cancion.getPath());
            byte[] img = mmr.getEmbeddedPicture();
            if (img != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
                holder.foto.setImageBitmap(bitmap);
                mmr.release();
                mmr.close();
            } else {
                holder.foto.setImageResource(R.drawable.default_afterlife);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        holder.titulo.setText(cancion.getTitulo());
        String artistaEstilo = cancion.getArtista() + " - " + cancion.getEstilo();
        holder.album.setText(cancion.getDisco());

        holder.artista.setText(cancion.getArtista());

        holder.itemView.setOnClickListener(v -> {
            int posicion = holder.getAdapterPosition();
            onItemClickListener.onItemClick(posicion);
        });
    }

    @Override
    public int getItemCount() {
        return canciones.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class CancionViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView titulo;
        TextView album;
        TextView artista;

        public CancionViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.foto);
            titulo = itemView.findViewById(R.id.titulo);
            album = itemView.findViewById(R.id.album);
            artista = itemView.findViewById(R.id.artista);
        }
    }
}
