package com.example.contactsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 1)
public abstract class contactDatabase extends RoomDatabase{

    public abstract contactDAO getContactDAO();

    // Singleton Pattern (single instance of database)
    private static contactDatabase dbInstance;

    public static synchronized contactDatabase getInstance(Context context){

        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            contactDatabase.class,
                            "contacts_db").
                    fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }




}
