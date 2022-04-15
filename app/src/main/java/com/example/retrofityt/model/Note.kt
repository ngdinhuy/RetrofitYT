package com.example.retrofityt.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity
class Note(@ColumnInfo(name="title_col")var title:String="",
           @ColumnInfo(name = "description_col")var description:String="",
           @ColumnInfo(name = "imgPath") var imgPath:String=""
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id:Int=0
    override fun toString(): String {
        return title+" "+description+" "+id.toString()
    }
}