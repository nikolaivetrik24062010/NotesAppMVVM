package com.example.notesappmvvm.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesappmvvm.database.room.dao.NoteRoomDao
import com.example.notesappmvvm.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppRomDatabase : RoomDatabase() {
    abstract fun getRoomDao(): NoteRoomDao

    companion object {
        @Volatile
        private var INSTANCE: AppRomDatabase? = null

        fun getInstance(context: Context): AppRomDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRomDatabase::class.java,
                    "notes_database",
                ).build()
                INSTANCE as AppRomDatabase
            } else INSTANCE as AppRomDatabase
        }
    }
}