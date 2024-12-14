package com.proseobd.fuljhuridirectory;

import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proseobd.fuljhuridirectory.adapters.WorkshopAdapter;
import com.proseobd.fuljhuridirectory.base.BaseListFragment;
import com.proseobd.fuljhuridirectory.controllers.DialogUtils;
import com.proseobd.fuljhuridirectory.datamodels.WorkshopData;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class WorkshopFragment extends BaseListFragment {
    private WorkshopAdapter workshopAdapter;
    private List<WorkshopData> workshopDataList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_workshop;
    }

    @Override
    protected void initAdapter() {
        workshopAdapter = new WorkshopAdapter(requireActivity().getLayoutInflater(), workshopDataList);
        recyclerView.setAdapter(workshopAdapter);
    }

    @Override
    protected void handleSearch(String query) {
        workshopAdapter.getFilter().filter(query);
    }

    @Override
    protected void loadData() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
        progressBar.setVisibility(View.VISIBLE);

        String url = "https://proseobd.com/apps/fuljhuridirectory/Workshop/view.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                response -> {
                    progressBar.setVisibility(View.GONE);
                    workshopDataList.clear();

                    for (int x = 0; x < response.length(); x++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(x);
                            WorkshopData data = new WorkshopData();
                            data.setName(jsonObject.getString("name"));
                            data.setOwner(jsonObject.getString("owner"));
                            data.setAddress(jsonObject.getString("address"));
                            data.setMobile(jsonObject.getString("mobile"));
                            data.setEmail(jsonObject.getString("email"));
                            data.setProfileImage(jsonObject.getString("profileImage"));
                            workshopDataList.add(data);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    workshopAdapter.notifyDataSetChanged();
                },
                error -> DialogUtils.showAlertDialog(getActivity(), "সতর্ক বার্তা", "সার্ভার এরর!"));

        requestQueue.add(jsonArrayRequest);
    }
}