     package com.example.asusnb.travelsurvivalunit;

     public interface UniversalData {
         // avatars
         Integer[] MY_AVATARS_ID = { R.drawable.avatar1, R.drawable.avatar2 };


          // translation
          //int TRANSPORTATION = 0;
          //int ACCODOMATION = 1;
          //int RESTAURANT = 2;
          //int SHOPPING = 3;
          //int DAILY = 4;
          //int EMERGENCY = 5;
          String[][] CATEGORIES = {{"transportation","ulaşım"},{"accommodation","konaklama"},
                  {"restaurant","restoran"}
                  ,{"shopping","alış-veriş"},{"daily","günlük"},{"emergency","acil"}};
          String[][] English= { {"Where is the bus stop", "How can I go to..."}, {"Do you have any room for tonight?", "Is breakfast included?"} };
          String[][] Turkish =  { {"Otobüs durağı nerede?", "...'ya nasıl gidebilirim?"}, {"Bu akşam için odanız var mı?", "Kahvaltı dahil mi?"}};

          // cities

     }
