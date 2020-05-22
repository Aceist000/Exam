package com.example.exam

import com.google.gson.annotations.SerializedName

class WallModel {
    var movieGenre = ""
    var movies:ArrayList<Movies> = ArrayList()

    class Movies{
        var id = 0
        var title = ""
        var year = 0
        var runtime = 0
        var genres:ArrayList<Genres> = ArrayList()
        var director = ""
        var actors = ""
        var plot = ""
        var posterUrl = ""
    }
    class Genres{
        var genres = ""
    }


}