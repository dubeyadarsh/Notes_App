package com.example.newsapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Onconcflict is used to store only unique data
    suspend fun insert(note: Note) //Suspend is coroutine used to perform task in background
    @Delete
    suspend fun delete(note: Note)
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>
}