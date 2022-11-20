package com.example.collegeadminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeadminapp.R;
import com.example.collegeadminapp.faculty.AddTeachers;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateTeacher extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDept, mechDept, phyDept, chemDept;
    private LinearLayout csNoData, mechNoData, phyNoData, chemNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;


    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);


        csDept = findViewById(R.id.csDept);
        mechDept = findViewById(R.id.mechDept);
        phyDept = findViewById(R.id.phyDept);
        chemDept = findViewById(R.id.chemDept);

        csNoData = findViewById(R.id.csNoData);
        mechNoData = findViewById(R.id.mechNoData);
        phyNoData = findViewById(R.id.phyNoData);
        chemNoData = findViewById(R.id.chemNoData);
        
        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        
        csDept();
        mechDept();
        phyDept();
        chemDept();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateTeacher.this, AddTeacher.class));
            }
        });
    }

    private void csDept() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDept.setVisibility(View.GONE);

                }
                else{
                    csNoData.setVisibility(View.GONE);
                    csDept.setVisibility(View.VISIBLE);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherData data = snap.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDept.setHasFixedSize(true);
                    csDept.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list1, UpdateTeacher.this, "Computer Science");
                    csDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechDept() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechDept.setVisibility(View.GONE);

                }
                else{
                    mechNoData.setVisibility(View.GONE);
                    mechDept.setVisibility(View.VISIBLE);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherData data = snap.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mechDept.setHasFixedSize(true);
                    mechDept.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list2, UpdateTeacher.this, "Mechanical");
                    mechDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void phyDept() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    phyNoData.setVisibility(View.VISIBLE);
                    phyDept.setVisibility(View.GONE);

                }
                else{
                    phyNoData.setVisibility(View.GONE);
                    phyDept.setVisibility(View.VISIBLE);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherData data = snap.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    phyDept.setHasFixedSize(true);
                    phyDept.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list3, UpdateTeacher.this, "Physics");
                    phyDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemDept() {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    chemNoData.setVisibility(View.VISIBLE);
                    chemDept.setVisibility(View.GONE);

                }
                else{
                    chemNoData.setVisibility(View.GONE);
                    chemDept.setVisibility(View.VISIBLE);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherData data = snap.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chemDept.setHasFixedSize(true);
                    chemDept.setLayoutManager(new LinearLayoutManager(UpdateTeacher.this));
                    adapter = new TeacherAdapter(list4, UpdateTeacher.this, "Chemistry");
                    chemDept.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateTeacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}