package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Admin_Order extends AppCompatActivity {
    Button BTNOBack;
    ListView Olistview;
    Context context;
    private DBHelper Dbhelper;
    private List<Order> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);

        context = this;

        Dbhelper = new DBHelper(this);
        Dbhelper.OpenDB();

        BTNOBack = findViewById(R.id.btnOback);
        Olistview = findViewById(R.id.OrderListC);

        productList = new ArrayList<>();
        productList = Dbhelper.ViewAllOrders();

        OrderAdapter adapter = new OrderAdapter(context, R.layout.list_order, productList);
        Olistview.setAdapter(adapter);

        BTNOBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Products = new Intent(Admin_Order.this, Admin_Home.class);
                startActivity(Products);
            }
        });
    }
}