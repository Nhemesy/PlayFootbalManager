package com.pedrodavidlp.footballmanager.data;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pedrodavidlp.footballmanager.domain.model.Player;
import com.pedrodavidlp.footballmanager.domain.repository.PlayersRepo;

import java.util.List;

/**
 * Created by PedroDavidLP on 14/9/16.
 */
public class PlayersRepository implements PlayersRepo {
    FirebaseDatabase database;
    DatabaseReference reference;

    public PlayersRepository() {
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("message");
    }

    @Override
    public void add(Player player) {
        reference.setValue(player);
    }

    @Override
    public List<Player> getAll() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Player value=dataSnapshot.getValue(Player.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return null;
    }
}