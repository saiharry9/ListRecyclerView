package com.rama.listview.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "daily_sleep_quality_table")
data class SleepNight(
    @PrimaryKey(autoGenerate = true)
    var nightId: Long = 0L,

    val sleep:Int = 1
)