package itsj.proyectoinnovacion.Fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.gson.Gson;

import itsj.proyectoinnovacion.Adapters.FeedAdapter;
import itsj.proyectoinnovacion.Common.HTTPDataHandler;
import itsj.proyectoinnovacion.POJOS.RSSObject;
import itsj.proyectoinnovacion.R;

public class FragmentNoticias extends Fragment {

    RecyclerView recyclerView;
    RSSObject rssObject;

    //private String RSS_link = "https://www.informador.mx/rss/economia.xml";
    //private String RSS_toJson_APi = "https://api.rss2json.com/v1/api.json?rss_url=";
    private String RSS_link = "https://www.jornada.com.mx/rss/economia.xml?v=1";
    private String RSS_toJson_APi = "https://api.rss2json.com/v1/api.json?rss_url=";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewNoticias);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        loadRSS();
    }

    private void loadRSS() {
        AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(getActivity());

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Please Wait...");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.getHTTPDataHandler(strings[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                rssObject = new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject, getActivity().getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        StringBuilder url_get_data = new StringBuilder(RSS_toJson_APi);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_noticias, container, false);
        return rootView;
    }
}
