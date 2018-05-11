    package com.example.asusnb.travelsurvivalunit;

    /**
     * __Note Class___
     * @author _____
     * @version __11.05.2018__
     */

    public class Note {

            public static final String TABLE_NAME = "notes";

            public static final String COLUMN_ID = "id";
            public static final String COLUMN_NOTE = "note";
            public static final String COLUMN_TIMESTAMP = "timestamp";

            private int id;
            private String note;
            private String timestamp;


            // Create table SQL query
            public static final String CREATE_TABLE =
                    "CREATE TABLE " + TABLE_NAME + "("
                            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + COLUMN_NOTE + " TEXT,"
                            + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                            + ")";

            public Note() {
            }

            public Note(int id, String note, String timestamp) {
                this.id = id;
                this.note = note;
                this.timestamp = timestamp;
            }

        /**
         * Gets note's id
         * @return id
         */
            public int getId() {
                return id;
            }

        /**
         * Gets note
         * @return note
         */
            public String getNote() {
                return note;
            }

        /**
         * Sets note to given note
         * @param note
         */
            public void setNote(String note) {
                this.note = note;
            }

        /**
         * Gets timestamp
         * @return timestamp
         */
            public String getTimestamp() {
                return timestamp;
            }


        /**
         * Sets id to given id
         * @param id
         */
            public void setId(int id) {
                this.id = id;
            }

        /**
         * Sets timestamp to given timestamp
         * @param timestamp
         */
            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }
        }
