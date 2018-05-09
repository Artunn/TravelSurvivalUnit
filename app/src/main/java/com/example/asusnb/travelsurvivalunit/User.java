    package com.example.asusnb.travelsurvivalunit;
    import java.util.ArrayList;

    public class User implements UniversalData {


        String username;
        String password;
        String homeCountry;
        String name;
        String surname;
        Integer avatarId;
        int count;
        ArrayList<String> favourites;
        Language motherLanguage;
        Language targetLanguage;
        City destination;
        //int backround;
        //int count2;


        //Language motherLanguage;

        public User( String username, String password, String homeCountry, String name, String surname,Language motherLanguage, Language targetLanguage, City destination )
        {
            this.username = username;
            this.password = password;
            this.homeCountry = homeCountry;
            this.name = name;
            this.surname = surname;
            avatarId = myAvatarsId[count];
            count = 0;
            favourites = new ArrayList<String>();
            this.motherLanguage = motherLanguage;
            this.targetLanguage = targetLanguage;
            this.destination = destination;

        }



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

        public void addToFavourites ( String str )
        {
            favourites.add(str);
        }

        public ArrayList<String> getFavourites()
        {
            return favourites;
        }

        public void setTargetLanguage( Language l )
        {
            targetLanguage = l;
        }

        public Language getTargetLanguage(){

            return targetLanguage;
        }

        public void setDestination ( City destination)
        {
            this.destination = destination;
        }

        public City getDestination()
        {
            return destination;
        }


        public void setMotherLanguage ( Language motherLanguage )
        {
            this.motherLanguage =  motherLanguage;
        }

        public Language getMotherLanguage ()
        {
            return motherLanguage;
        }

    }
