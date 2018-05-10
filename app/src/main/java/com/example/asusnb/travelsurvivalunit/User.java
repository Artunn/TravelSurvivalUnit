    package com.example.asusnb.travelsurvivalunit;
    import java.util.ArrayList;

    //package com.example.asusnb.travelsurvivalunit;
    import java.util.ArrayList;
    import android.content.Context;
    import java.util.List;

    public class User implements UniversalData {

        int id;
        public User currentUser;
        String username;
        String password;
        String homeCountry;
        String name;
        String surname;
        Integer avatarId;
        int count;
        //ArrayList<String> favourites;
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

        public User( String username, String password, String homeCountry, String name, String surname,String motherLanguage, String targetLanguage, String destination,  Context context)
        {
            this.username = username;
            this.password = password;
            this.homeCountry = homeCountry;
            this.name = name;
            this.surname = surname;
            avatarId = myAvatarsId[count];
            count = 0;
            //favourites = new ArrayList<String>();
            this.motherLanguage = motherLanguage;
            this.targetLanguage = targetLanguage;
            this.destination = destination;
            ndbh = new NoteDataBaseHelper( context );

        }

        public User ( int id, String username, String password, String homeCountry, String name, String surname,String motherLanguage, String targetLanguage, String destination, Context context ){
            this.id = id;
            this.username = username;
            this.password = password;
            this.homeCountry = homeCountry;
            this.name = name;
            this.surname = surname;
            avatarId = myAvatarsId[count];
            count = 0;
            //favourites = new ArrayList<String>();
            this.motherLanguage = motherLanguage;
            this.targetLanguage = targetLanguage;
            this.destination = destination;
            ndbh = new NoteDataBaseHelper(context);
        }


        public void setId(int id){ this.id = id; }
        public int getId(){ return id; }
        public void setUsername( String username )
        {
            this.username = username;
        }

        public String getUsername() { return username; }

        public void setPassword ( String password) { this.password = password; }

        public String getPassword() { return password; }

        public void setHomeCountry (String homeCountry)
        {
            this.homeCountry = homeCountry;
        }

        public String getHomeCountry() { return homeCountry; }

        public void setName( String name )
        {
            this.name = name;
        }

        public String getName() { return name; }

        public void setSurname( String surname)
        {
            this.surname = surname;
        }

        public String getSurname() { return surname; }

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

        public Integer getAvatar()
        {
            return avatarId;
        }

        public void setAvatar(Integer avatarId)
        {
            this.avatarId = avatarId;
        }

        public int getCount() {
            return count;
        }

        public void setCount( int count )
        {
            this.count = count;
        }

        public void increaseCount()
        {
            count++;
        }

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

        public void setTargetLanguage( String l )
        {
            targetLanguage = l;
        }

        public String getTargetLanguage(){

            return targetLanguage;
        }

        public void setDestination ( String cityDestination )
        {
            this.destination = cityDestination;
        }

        public String getDestination()
        {
            return destination;
        }


        public void setMotherLanguage ( String motherLanguage )
        {
            this.motherLanguage =  motherLanguage;
        }

        public String getMotherLanguage ()
        {
            return motherLanguage;
        }

        public long addNote( String note )
        {
            return ndbh.insertNote(note);
        }

        public Note getNote( long id )
        {
            return ndbh.getNote(id);
        }

        public List getAllNotes()
        {
            return ndbh.getAllNotes();
        }

        public int updateNote(Note note)
        {
            return ndbh.updateNote(note);
        }

        public void deleteNote(Note note)
        {
            ndbh.deleteNote(note);
        }

        public NoteDataBaseHelper getNoteDataBaseHelper()
        {
            return ndbh;
        }

        public void setCurrentUser(User user){
            currentUser = user;
        }

        public User getCurrentUser(){
            return currentUser;
        }

    }
