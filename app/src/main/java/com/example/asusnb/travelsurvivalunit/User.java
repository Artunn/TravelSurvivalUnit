    package com.example.asusnb.travelsurvivalunit;

    public class User implements UniversalData {

        String homeCountry;
        String username;
        String name;
        String surname;
        //Language motherLanguage;

        public User(String homeCountry, String username, String name, String surname )
        {
            this.homeCountry = homeCountry;
            this.username = username;
            this.name = name;
            this.surname = surname;
        }
        public User ()
        {
            homeCountry = null;
            username = null;
            name = null;
            surname = null;
        }

        public void setUsername( String username )
        {
            this.username = username;
        }

        public void setHomeCountry(String homeCountry)
        {
            this.homeCountry = homeCountry;
        }

        public void setName( String name )
        {
            this.name = name;
        }

        public void setSurname( String surname)
        {
            this.surname = surname;
        }

        //public void setMotherLanguage ( Language MotherLanguage )
    }
