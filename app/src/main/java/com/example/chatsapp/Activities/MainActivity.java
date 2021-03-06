package com.example.chatsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chatsapp.R;
import com.example.chatsapp.Adapters.UsersAdapter;
import com.example.chatsapp.databinding.ActivityMainBinding;
import com.example.chatsapp.Models.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
     FirebaseDatabase database;
     ArrayList<user> users;
     UsersAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance();
        users = new ArrayList<>();
        usersAdapter = new UsersAdapter(this,users);
        //binding.Recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.Recyclerview.setAdapter(usersAdapter);
        database.getReference().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    user userr = snapshot1.getValue(user.class);
                    users.add(userr);
                }
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public boolean onOptionsItemSelecetd(@NonNull MenuItem item){
        switch(item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "you clicked on settings", Toast.LENGTH_SHORT).show();
            case R.id.search:
                Toast.makeText(this, "you clicked on groups", Toast.LENGTH_SHORT).show();
            case R.id.invite:
                Toast.makeText(this, "you clicked on invite", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
  public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return super.onCreateOptionsMenu(menu);
  }
}