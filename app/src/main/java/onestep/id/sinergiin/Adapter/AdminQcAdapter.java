package onestep.id.sinergiin.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import onestep.id.sinergiin.AppController;
import onestep.id.sinergiin.Model.mAdminQc;
import onestep.id.sinergiin.R;

public class AdminQcAdapter extends BaseAdapter {
    private Activity activity;
    private List<mAdminQc> list;
    private LayoutInflater inflater;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public AdminQcAdapter(Activity activity, List<mAdminQc> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(activity,R.layout.list_admin_qc,null);
        mAdminQc m = list.get(position);
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_admin_qc, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView img = (NetworkImageView) view.findViewById(R.id.iv_produk);
        TextView txtProduk = (TextView) view.findViewById(R.id.tv_produk);
        TextView txtDate = (TextView) view.findViewById(R.id.tv_date);

        txtProduk.setText(m.getTitle());
        txtDate.setText(m.getDate());
        img.setImageUrl(m.getImg(), imageLoader);
        view.setTag(m.getId());
        return view;
    }
}
