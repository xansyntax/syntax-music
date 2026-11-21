package com.metrolist.music.utils

import android.content.Context
import android.content.SharedPreferences

object InnerTubeXPlayer {
    class AndroidPlayerConfigRepository(val preferences: SharedPreferences) {
        constructor(context: Context) : this(context.getSharedPreferences("innertubex_player_config", 0))
    }
}
