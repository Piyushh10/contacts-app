package com.example.contactsmanagerapp;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contacts contact;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitBtnClicked(View view){
        if (contact.getName() == null || contact.getPhoneno() ==null){
            Toast.makeText(context, "Fields Cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context,MainActivity.class);

            Contacts c = new Contacts(
                    contact.getName(),
                    contact.getPhoneno()
            );

            myViewModel.addNewContact(c);

            context.startActivity(i);

        }
    }
}
