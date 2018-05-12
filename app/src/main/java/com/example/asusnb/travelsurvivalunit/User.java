package com.example.asusnb.travelsurvivalunit;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    /**
     * __User Class___
     * @author __Göksu Turan, Irmak Demir ___
     * @version __11.05.2018__
     */

    public class User implements UniversalData, Serializable {

    int id;
    public static User currentUser;
    String username;
    String email;
    String password;
    String homeCountry;
    String name;
    String surname;
    Integer avatarId;
    int count;
    ArrayList<String> favourites;
    String motherLanguage;
    String targetLanguage;
    String destination;
    NoteDataBaseHelper ndbh;
    
    //int background;
    //int count2;


    //Language motherLanguage;

    public User() {}

    public User( Context context )
    {
        ndbh = new NoteDataBaseHelper( context );
    }

    public User( String username, String password, String homeCountry, String name, String surname,
                 String motherLanguage, String targetLanguage, String destination,  Context context,
                 String email)
    {
        this.username = username;
        this.password = password;
        this.homeCountry = homeCountry;
        this.name = name;
        this.surname = surname;
        count = 0;
        avatarId = MY_AVATARS_ID[count];
        //favourites = new ArrayList<String>();
        this.motherLanguage = motherLanguage;
        this.targetLanguage = targetLanguage;
        this.destination = destination;
        this.email = email;
        ndbh = new NoteDataBaseHelper( context );

    }

    public User ( int id, String username, String password, String homeCountry, String name,
                  String surname,String motherLanguage, String targetLanguage, String destination,
                  Context context, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.homeCountry = homeCountry;
        this.name = name;
        this.surname = surname;
        count = 0;
        avatarId = MY_AVATARS_ID[count];
        //favourites = new ArrayList<String>();
        this.motherLanguage = motherLanguage;
        this.targetLanguage = targetLanguage;
        this.destination = destination;
        this.email = email;
        ndbh = new NoteDataBaseHelper(context);
    }

    /**
     * Sets User ID to given int id
     * @param  id ıd to set
     */
    public void setId(int id){ this.id = id; }

    /**
     * Gets User ID
     * @return id
     */
    public int getId(){ return id; }

    /**
     * Sets Username to given String username
     * @param  username username to set
     */
    public void setUsername( String username )
    {
        this.username = username;
    }

    /**
     * Gets username
     * return username
     */
    public String getUsername() { return username; }

    /**
     * Sets Password to given password
     * @param password password to set
     */
    public void setPassword ( String password) { this.password = password; }

    /**
     * Gets User's password
     * @return password
     */
    public String getPassword() { return password; }

    public void setEmail(String email) {this.email = email ;}

    /**
     * Sets the homeCountry of the user to given country
     * @param homeCountry home country to set
     */
    public void setHomeCountry (String homeCountry)
    {
        this.homeCountry = homeCountry;
    }

    /**
     * Gets the home country of the user
     * @return homeCountry
     */
    public String getHomeCountry() { return homeCountry; }

    /**
     * Sets user name to given name
     * @param name name to set
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * Gets the name of the user
     * @return name
     */
    public String getName() { return name; }

    /**
     * Sets user surname to given name
     * @param surname surname to set
     */
    public void setSurname( String surname)
    {
        this.surname = surname;
    }

    /**
     * Gets the surname of the user
     * @return surname
     */
    public String getSurname() { return surname; }

    /**
     * Sets avatar to  next image
     * @return avatarId
     */
    public int nextAvatar()
    {
        if ( count < MY_AVATARS_ID.length - 1 )
            count++;
        else
            count = 0;
        avatarId = MY_AVATARS_ID[count];

        return avatarId;
    }

    /**
     * Sets avatar to previous image
     * @return avatarId
     */
    public int previousAvatar()
    {
        if ( count > 0 )
            count--;
        else
            count = MY_AVATARS_ID.length - 1;
        avatarId = MY_AVATARS_ID[count];

        return avatarId;
    }

    /**
     * Gets the avatarId
     * @return avatarId
     */
    public Integer getAvatar()
    {
        return avatarId;
    }

    /**
     * Sets avatar to avatar with the given avatarId
     * @param avatarId avatar ID of next one
     */
    public void setAvatar(Integer avatarId)
    {
        this.avatarId = avatarId;
    }

    /**
     * Gets count for the avatar
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count to given count
     * @param count count to set
     */
    public void setCount( int count )
    {
        this.count = count;
    }

    /**
     * Increases count for avatar
     */
    public void increaseCount()
    {
        count++;
    }

    /**
     * Decrease count for avatar
     */
    public void decreaseCount()
    {
        count--;
    }

    //public void addToFavourites ( String str )
    //{
    //    favourites.add(str);
    //}


    //public ArrayList<String> getFavourites()
    //{
    //    return favourites;
    //}

    /**
     * Sets the targetLanguage for translation
     * @param language language to set target
     */
    public void setTargetLanguage( String language )
    {
        targetLanguage = language;
    }

    /**
     * Gets the target language
     * @return targetLanguage
     */
    public String getTargetLanguage(){

        return targetLanguage;
    }

    /**
     * Sets destination to given city
     * @param cityDestination destination city
     */
    public void setDestination ( String cityDestination )
    {
        this.destination = cityDestination;
    }

    /**
     * Gets destination
     * @return destination
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Sets User's motherLanguage to given language
     * @param motherLanguage mother language to set
     */
    public void setMotherLanguage ( String motherLanguage )
    {
        this.motherLanguage =  motherLanguage;
    }

    /**
     * Gets User's motherLanguage
     * @return motherLanguage
     */
    public String getMotherLanguage ()
    {
        return motherLanguage;
    }

    public String getEmail() {
        return email;
    }
    /**
     * Adds given note to the notes
     * @param note note to add
     * @return ndbh.insertNote(note)
     */
    public long addNote( String note )
    {
        return ndbh.insertNote(note);
    }

    /**
     * Gets the note with  given id
     * @param id id of note
     * @return ndbh.getNote(note), the note stored in database with given id
     */
    public Note getNote( long id )
    {
        return ndbh.getNote(id);
    }

    /**
     * Gets all the notes stored in database
     * @return ndbh.getAllNotes()
     */
    public List getAllNotes()
    {
        return ndbh.getAllNotes();
    }
    /**
     * Gets all the notes stored in database
     * @return ndbh.getAllNotes()
     */
    public int updateNote(Note note)
    {
        return ndbh.updateNote(note);
    }

    /**
     * Delete the notes stored in database
     * @param note note to delete
     */
    public void deleteNote(Note note)
    {
        ndbh.deleteNote(note);
    }

    /**
     * Gets the  NoteDataBaseHelper
     * @return ndbh
     */
    public NoteDataBaseHelper getNoteDataBaseHelper()
    {
        return ndbh;
    }
    /**
     * Sets the currentUser given user
     * @param user user to set
     */
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    /**
     * Gets the current user
     * @return currentUser
     */
    public User getCurrentUser(){
        return currentUser;
    }
}
