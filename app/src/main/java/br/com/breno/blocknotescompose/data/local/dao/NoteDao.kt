package br.com.breno.blocknotescompose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import br.com.breno.blocknotescompose.data.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = IGNORE)
    suspend fun insertNote(note: NoteModel): Long

    @Query("SELECT * FROM noteList")
    suspend fun getAllNotes(): List<NoteModel>
}