     package com.example.asusnb.travelsurvivalunit;

     public interface UniversalData {
          Integer[] myAvatarsId = { R.drawable.avatar1, R.drawable.avatar2};

          final int TRANSPORTATION = 0;
          final int ACCODOMATION = 1;
          final int RESTAURANT = 2;
          final int SHOPPING = 3;
          final int DAILY = 4;
          final int EMERGENCY = 5;
          final String[][] CATEGORIES = {{"Transportation","Ulaşım"},{"Accomodation","Konaklama"},{"Restaurant","Restoran"}
                  ,{"Shopping","Alış-veriş"},{"Daily","Günlük"},{"Emergency","Acil"}};

          final String[][] English= { {"Where is the bus stop", "How can I go to..."}, {"Do you have any room for tonight?", "Is breakfast included?"} };
          final String[][] Turkish =  { {"Otobüs durağı nerede?", "...'ya nasıl gidebilirim?"}, {"Bu akşam için odanız var mı?", "Kahvaltı dahil mi?"}};

     }
