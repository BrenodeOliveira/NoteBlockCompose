package br.com.breno.blocknotescompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteList")
data class NoteModel(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "subtitle") val subtitle: String = "",
)
