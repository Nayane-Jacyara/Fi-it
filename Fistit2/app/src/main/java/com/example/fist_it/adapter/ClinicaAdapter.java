package com.example.fist_it.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fist_it.R;
import com.example.fist_it.entity.Clinica;

import java.util.ArrayList;

/*public class ClinicaAdapter extends BaseAdapter {
    private ArrayList<Clinica> clinics;
    private LayoutInflater inflater;

    public ClinicaAdapter(Context context, ArrayList<Clinica> clinics) {
        this.clinics = clinics;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return clinics.size();
    }

    @Override
    public Object getItem(int position) {
        return clinics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_home, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.text_view_nome); // Coloca o ID correto
            holder.address = convertView.findViewById(R.id.text_view_endereco); // Coloca o ID correto
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Clinica clinic = clinics.get(position);
        holder.name.setText(clinic.getNome());
        holder.address.setText(clinic.getCidade());

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView address;
    }
}
*/