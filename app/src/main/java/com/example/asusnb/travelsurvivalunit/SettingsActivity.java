package com.example.asusnb.travelsurvivalunit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    User artun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_settings);
        artun = new User("artunn", "1234", "bursa", "artun", "cura", "English", "Turkish", "Turkey", null);

        TextView x = findViewById( R.id.textView7);
        x.setText("destination " + artun.destination);
    }
    public void optionTheme(View view) {
        String[] listItems = new String[] {"item1","item2"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.theme);
        builder.setSingleChoiceItems(listItems, -1,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.print("HELLO");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void changeAvatarNext(View view) {
        TextView text;
        ImageView david;
        int image;

        text = findViewById( R.id.textView);
        david = findViewById( R.id.avatarImage);
        //getDrawable( artun.changeAvatar());
        image = artun.nextAvatar();
        text.setText( image);
        david.setImageResource( image);
    }
    public void changeAvatarPrevious(View view) {
        TextView text;
        ImageView david;
        int image;

        text = findViewById( R.id.textView);
        david = findViewById( R.id.avatarImage);
        //getDrawable( artun.changeAvatar());
        image = artun.previousAvatar();
        text.setText( image);
        david.setImageResource( image);
    }
}