package com.example.notesappmvvm.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesappmvvm.database.room.dao.NoteRoomDao
import com.example.notesappmvvm.model.Note
import com.example.notesappmvvm.utils.Constants.Keys.NOTE_DATABASE

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
                    NOTE_DATABASE,
                ).build()
                INSTANCE as AppRomDatabase
            } else INSTANCE as AppRomDatabase
        }
    }
}