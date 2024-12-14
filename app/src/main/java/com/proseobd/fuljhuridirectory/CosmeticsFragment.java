package com.proseobd.fuljhuridirectory;

import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.CosmeticsAdapter;
import com.proseobd.fuljhuridirectory.base.BaseListFragment;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.datamodels.CosmeticsData;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CosmeticsFragment extends BaseListFragment {
    private CosmeticsAdapter cosmeticsAdapter;
    private List<CosmeticsData> cosmeticsDataList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cosmetics;
    }

    @Override
    protected void initAdapter() {
        cosmeticsAdapter = new CosmeticsAdapter(requireActivity().getLayoutInflater(), cosmeticsDataList);
        recyclerView.setAdapter(cosmeticsAdapter);
    }

    @Override
    protected void handleSearch(String query) {
        cosmeticsAdapter.getFilter().filter(query);
    }

    @Override
    protected void loadData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/Cosmetics/view.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    cosmeticsDataList.clear();

                    for (int x = 0; x < response.length(); x++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(x);
                            CosmeticsData data = new CosmeticsData();
                            data.setName(jsonObject.getString("name"));
                            data.setOwner(jsonObject.getString("owner"));
                            data.setAddress(jsonObject.getString("address"));
                            data.setMobile(jsonObject.getString("mobile"));
                            data.setEmail(jsonObject.getString("email"));
                            data.setProfileImage(jsonObject.getString("profileImage"));
                            cosmeticsDataList.add(data);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    cosmeticsAdapter.notifyDataSetChanged();
                },
                error -> DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!"));

        requestQueue.add(jsonArrayRequest);
    }
}