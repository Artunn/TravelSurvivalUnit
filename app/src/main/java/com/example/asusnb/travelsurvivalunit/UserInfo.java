package com.example.asusnb.travelsurvivalunit;
import android.media.Image;
import java.util.ArrayList;
import android.view.View;
import android.widget.ImageView;

public class UserInfo implements UniversalData {

    User user;
    //Language targetLanguage;
    //City destination;
    Integer avatarId;
    //Collections favourites;
    //Image background;
    ArrayList<String> notes;
    int count;


    public UserInfo( String homeCountry, String username, String name, String surname )
    {
        User newUser = new User( homeCountry,  username,  name, surname);
        count = 0;
        avatarId = myAvatarsId[count];
        notes = new ArrayList<String>();
    }

    public int nextAvatar()
    {
        if ( count < myAvatarsId.length - 1 )
            count++;
        else
            count = 0;
        avatarId = myAvatarsId[count];

        return avatarId;
    }

    public int previousAvatar()
    {
        if ( count > 0 )
            count--;
        else
            count = myAvatarsId.length - 1;
        avatarId = myAvatarsId[count];

        return avatarId;
    }

    public void addToNotes ( String str )
    {
        notes.add(str);
    }

    public ArrayList<String> getNotes()
    {
        return notes;
    }

    public Integer getAvatar()
    {
        return avatarId;
    }

    //public void setBackground( int image )
    //public void addToFavourites ( String str )
    //public void setTargetLanguage( Language l )
    //public void set destination

}
