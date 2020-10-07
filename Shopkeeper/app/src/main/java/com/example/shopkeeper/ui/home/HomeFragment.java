package com.example.shopkeeper.ui.home;

import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.shopkeeper.FamilyMem;
import com.example.shopkeeper.PopUp;
import com.example.shopkeeper.R;
import com.example.shopkeeper.RetrofitClient;
import com.example.shopkeeper.ui.models.Allocated;
import com.example.shopkeeper.ui.models.Transfer_Model;
import com.example.shopkeeper.ui.models.user_Stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.shopkeeper.RetrofitClient.getInstance;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
            Button search,checkout;
            TextView g_tag,name,name1;
    RecyclerView dataList;
    SearchView search_bt;
    Allocated a1;

    LinearLayout linearLayout,linearLayout1;
    String s1;

    ArrayList<Model> al;
    int x;
    AdapterForHome adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        name = root.findViewById(R.id.name_l1);
        name1 = root.findViewById(R.id.name_for_l1);
        linearLayout = root.findViewById(R.id.linearLayoutforname);
        linearLayout1 = root.findViewById(R.id.linearLayoutforindex);
        dataList = root.findViewById(R.id.recyclerViewforHome);
        checkout = root.findViewById(R.id.checkout);

        search = root.findViewById(R.id.search);
        search_bt=root.findViewById(R.id.searchView);
        g_tag = root.findViewById(R.id.grant_tag);
        g_tag.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);
        linearLayout1.setVisibility(View.INVISIBLE);
        checkout.setVisibility(View.INVISIBLE);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g_tag.setVisibility(View.VISIBLE);
               checkout.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout1.setVisibility(View.VISIBLE);

                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getContext(), FamilyMem.class);
                        i.putExtra("ration_id",Integer.parseInt(s1));
                        startActivity(i);
                    }
                });
                name1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getContext(), FamilyMem.class);
                        i.putExtra("ration_id",Integer.parseInt(s1));
                        startActivity(i);
                    }
                });

                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getContext(), FamilyMem.class);
                        i.putExtra("ration_id",Integer.parseInt(s1));
                        startActivity(i);
                    }
                });

                al = new ArrayList<>();
                s1=search_bt.getQuery().toString();
    Toast.makeText(getContext(),s1,Toast.LENGTH_LONG).show();
//                x=0;

              Call<Allocated> call=RetrofitClient.getInstance().getApi().get_allocated(Integer.parseInt(s1));
                call.enqueue(new Callback<Allocated>() {
                    @Override
                    public void onResponse(Call<Allocated> call, Response<Allocated> response) {
                        a1=response.body();
                            x=a1.getAllocated();
                            name1.setText(a1.getName());


                            Call<List<user_Stock>> call2=RetrofitClient.getInstance().getApi().get_user_stock(2,Integer.parseInt(s1));
                            call2.enqueue(new Callback<List<user_Stock>>() {
                                @Override
                                public void onResponse(Call<List<user_Stock>> call, Response<List<user_Stock>> response) {
                                    List<user_Stock> l1=response.body();
                                    for(user_Stock p:l1)
                                    {
                                        al.add(new Model(p,x,0));
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<user_Stock>> call, Throwable t) {

                                }
                            });






                    }

                    @Override
                    public void onFailure(Call<Allocated> call, Throwable t) {
Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

//                al.add(new Model("Rise",1,1));
//                al.add(new Model("Rise",1,1));
//                al.add(new Model("Rise",1,1));
//
//                al.add(new Model("Rise",1,1));
//                al.add(new Model("Rise",1,1));
//                al.add(new Model("Rise",1,1));



                adapter = new AdapterForHome(getContext(),al);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                dataList.setLayoutManager(gridLayoutManager);
                dataList.setAdapter(adapter);


                checkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      int n=  dataList.getAdapter().getItemCount();
                      String mob=a1.getPhn();
                      Toast.makeText(getContext(),mob,Toast.LENGTH_LONG).show();
//                        dataList.getAdapter().notifyDataSetChanged();
                   AdapterForHome ah=(AdapterForHome)dataList.getAdapter();
                  ArrayList<Model> al=ah.data;
//                 n= al.get(0).getRequirement();
//                 String s2=String.valueOf(al.get(1).getRequirement());
//                      Toast.makeText(getContext(),n+" "+s2,Toast.LENGTH_LONG).show();
                    ArrayList<Transfer_Model> al2=new ArrayList<>();

                    for(Model m1:al)
                    {
                        al2.add(new Transfer_Model(m1.getU1().getId(),m1.getU1().getItem_id().getItem_name(),m1.getRequirement(),m1.getU1().getItem_id().getPrice()));
                    }



                      Intent i=new Intent(getContext(),PopUp.class);
                      Bundle bundle=new Bundle();
                      bundle.putSerializable("arrayList",(Serializable) al2);
                      i.putExtra("bundle",bundle);
                      i.putExtra("mobile_no",mob);
                      i.putExtra("ration_id",Integer.parseInt(s1));

                      startActivity(i);
//                      al.get
//                      i.putExtra()


//                      AdapterForHome a= dataList.getAdapter();
//                        startActivity(new Intent(getContext(), PopUp.class));
                    }
                });
            }
        });



        return root;
    }
}
