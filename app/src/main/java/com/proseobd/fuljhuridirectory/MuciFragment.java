package com.proseobd.fuljhuridirectory;

import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.MuciAdapter;
import com.proseobd.fuljhuridirectory.base.BaseListFragment;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.datamodels.MuciData;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MuciFragment extends BaseListFragment {
    private MuciAdapter muciAdapter;
    private List<MuciData> muciDataList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_muci;
    }

    @Override
    protected void initAdapter() {
        muciAdapter = new MuciAdapter(requireActivity().getLayoutInflater(), muciDataList);
        recyclerView.setAdapter(muciAdapter);
    }

    @Override
    protected void handleSearch(String query) {
        muciAdapter.getFilter().filter(query);
    }

    @Override
    protected void loadData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/Muci/view.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    muciDataList.clear();

                    for (int x = 0; x < response.length(); x++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(x);
                            MuciData muciData = new MuciData();
                            muciData.setName(jsonObject.getString("name"));
                            muciData.setOwner(jsonObject.getString("owner"));
                            muciData.setAddress(jsonObject.getString("address"));
                            muciData.setMobile(jsonObject.getString("mobile"));
                            muciData.setEmail(jsonObject.getString("email"));
                            muciData.setProfileImage(jsonObject.getString("profileImage"));
                            muciDataList.add(muciData);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    muciAdapter.notifyDataSetChanged();
                },
                error -> DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!"));

        requestQueue.add(jsonArrayRequest);
    }
}
