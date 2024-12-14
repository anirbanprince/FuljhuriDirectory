package com.proseobd.fuljhuridirectory;

import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.KamarAdapter;
import com.proseobd.fuljhuridirectory.base.BaseListFragment;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.datamodels.KamarData;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Kamar_kumarFragment extends BaseListFragment {
    private KamarAdapter kamarAdapter;
    private List<KamarData> kamarDataList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_kamar_kumar;
    }

    @Override
    protected void initAdapter() {
        kamarAdapter = new KamarAdapter(requireActivity().getLayoutInflater(), kamarDataList);
        recyclerView.setAdapter(kamarAdapter);
    }

    @Override
    protected void handleSearch(String query) {
        kamarAdapter.getFilter().filter(query);
    }

    @Override
    protected void loadData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/Kamar/view.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    kamarDataList.clear();

                    for (int x = 0; x < response.length(); x++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(x);
                            KamarData data = new KamarData();
                            data.setName(jsonObject.getString("name"));
                            data.setOwner(jsonObject.getString("owner"));
                            data.setAddress(jsonObject.getString("address"));
                            data.setMobile(jsonObject.getString("mobile"));
                            data.setEmail(jsonObject.getString("email"));
                            data.setProfileImage(jsonObject.getString("profileImage"));
                            kamarDataList.add(data);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    kamarAdapter.notifyDataSetChanged();
                },
                error -> DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!"));

        requestQueue.add(jsonArrayRequest);
    }
}