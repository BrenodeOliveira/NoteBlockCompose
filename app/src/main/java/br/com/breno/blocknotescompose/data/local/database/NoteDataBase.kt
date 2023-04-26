package br.com.breno.blocknotescompose.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.breno.blocknotescompose.data.local.dao.NoteDao
import br.com.breno.blocknotescompose.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        fun createDataBase(context: Context): NoteDataBase {
            return Room
                .databaseBuilder(context, NoteDataBase::class.java, "noteList.db").build()
        }
    }
}