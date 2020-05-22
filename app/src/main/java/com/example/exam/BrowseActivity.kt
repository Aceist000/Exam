package com.example.exam

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_browse.*
import org.json.JSONException
import org.json.JSONObject


class BrowseActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val posts = ArrayList<WallModel.Movies>()
    private lateinit var  adapter:BrowseActivityHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        init()
    }

    private fun init() {
        auth = FirebaseAuth.getInstance()

        BrowseMovies.layoutManager = LinearLayoutManager(this)
        adapter =  BrowseActivityHandler(posts)
        BrowseMovies.adapter = adapter
        val model:WallModel = Gson().fromJson(json,WallModel::class.java)
        posts.addAll(model.movies)
        adapter.notifyDataSetChanged()
    }


    private val json = "{\n" +
            "   \"genres\":[\n" +
            "      \"Comedy\",\n" +
            "      \"Fantasy\",\n" +
            "      \"Crime\",\n" +
            "      \"Drama\",\n" +
            "      \"Music\",\n" +
            "      \"Adventure\",\n" +
            "      \"History\",\n" +
            "      \"Thriller\",\n" +
            "      \"Animation\",\n" +
            "      \"Family\",\n" +
            "      \"Mystery\",\n" +
            "      \"Biography\",\n" +
            "      \"Action\",\n" +
            "      \"Film-Noir\",\n" +
            "      \"Romance\",\n" +
            "      \"Sci-Fi\",\n" +
            "      \"War\",\n" +
            "      \"Western\",\n" +
            "      \"Horror\",\n" +
            "      \"Musical\",\n" +
            "      \"Sport\"\n" +
            "   ],\n" +
            "   \"movies\":[\n" +
            "      {\n" +
            "         \"id\":1,\n" +
            "         \"title\":\"Beetlejuice\",\n" +
            "         \"year\":\"1988\",\n" +
            "         \"runtime\":\"92\",\n" +
            "         \"genres\":[\n" +
            "            \"Comedy\",\n" +
            "            \"Fantasy\"\n" +
            "         ],\n" +
            "         \"director\":\"Tim Burton\",\n" +
            "         \"actors\":\"Alec Baldwin, Geena Davis, Annie McEnroe, Maurice Page\",\n" +
            "         \"plot\":\"A couple of recently deceased ghosts contract the services of a \\\"bio-exorcist\\\" in order to remove the obnoxious new owners of their house.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":2,\n" +
            "         \"title\":\"The Cotton Club\",\n" +
            "         \"year\":\"1984\",\n" +
            "         \"runtime\":\"127\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\",\n" +
            "            \"Music\"\n" +
            "         ],\n" +
            "         \"director\":\"Francis Ford Coppola\",\n" +
            "         \"actors\":\"Richard Gere, Gregory Hines, Diane Lane, Lonette McKee\",\n" +
            "         \"plot\":\"The Cotton Club was a famous night club in Harlem. The story follows the people that visited the club, those that ran it, and is peppered with the Jazz music that made it so famous.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":3,\n" +
            "         \"title\":\"The Shawshank Redemption\",\n" +
            "         \"year\":\"1994\",\n" +
            "         \"runtime\":\"142\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Frank Darabont\",\n" +
            "         \"actors\":\"Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler\",\n" +
            "         \"plot\":\"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":4,\n" +
            "         \"title\":\"Crocodile Dundee\",\n" +
            "         \"year\":\"1986\",\n" +
            "         \"runtime\":\"97\",\n" +
            "         \"genres\":[\n" +
            "            \"Adventure\",\n" +
            "            \"Comedy\"\n" +
            "         ],\n" +
            "         \"director\":\"Peter Faiman\",\n" +
            "         \"actors\":\"Paul Hogan, Linda Kozlowski, John Meillon, David Gulpilil\",\n" +
            "         \"plot\":\"An American reporter goes to the Australian outback to meet an eccentric crocodile poacher and invites him to New York City.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg0MTU1MTg4NF5BMl5BanBnXkFtZTgwMDgzNzYxMTE@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":5,\n" +
            "         \"title\":\"Valkyrie\",\n" +
            "         \"year\":\"2008\",\n" +
            "         \"runtime\":\"121\",\n" +
            "         \"genres\":[\n" +
            "            \"Drama\",\n" +
            "            \"History\",\n" +
            "            \"Thriller\"\n" +
            "         ],\n" +
            "         \"director\":\"Bryan Singer\",\n" +
            "         \"actors\":\"Tom Cruise, Kenneth Branagh, Bill Nighy, Tom Wilkinson\",\n" +
            "         \"plot\":\"A dramatization of the 20 July assassination and political coup plot by desperate renegade German Army officers against Hitler during World War II.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMTg3Njc2ODEyN15BMl5BanBnXkFtZTcwNTAwMzc3NA@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":6,\n" +
            "         \"title\":\"Ratatouille\",\n" +
            "         \"year\":\"2007\",\n" +
            "         \"runtime\":\"111\",\n" +
            "         \"genres\":[\n" +
            "            \"Animation\",\n" +
            "            \"Comedy\",\n" +
            "            \"Family\"\n" +
            "         ],\n" +
            "         \"director\":\"Brad Bird, Jan Pinkava\",\n" +
            "         \"actors\":\"Patton Oswalt, Ian Holm, Lou Romano, Brian Dennehy\",\n" +
            "         \"plot\":\"A rat who can cook makes an unusual alliance with a young kitchen worker at a famous restaurant.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":7,\n" +
            "         \"title\":\"City of God\",\n" +
            "         \"year\":\"2002\",\n" +
            "         \"runtime\":\"130\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Fernando Meirelles, Kátia Lund\",\n" +
            "         \"actors\":\"Alexandre Rodrigues, Leandro Firmino, Phellipe Haagensen, Douglas Silva\",\n" +
            "         \"plot\":\"Two boys growing up in a violent neighborhood of Rio de Janeiro take different paths: one becomes a photographer, the other a drug dealer.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA4ODQ3ODkzNV5BMl5BanBnXkFtZTYwOTc4NDI3._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":8,\n" +
            "         \"title\":\"Memento\",\n" +
            "         \"year\":\"2000\",\n" +
            "         \"runtime\":\"113\",\n" +
            "         \"genres\":[\n" +
            "            \"Mystery\",\n" +
            "            \"Thriller\"\n" +
            "         ],\n" +
            "         \"director\":\"Christopher Nolan\",\n" +
            "         \"actors\":\"Guy Pearce, Carrie-Anne Moss, Joe Pantoliano, Mark Boone Junior\",\n" +
            "         \"plot\":\"A man juggles searching for his wife's murderer and keeping his short-term memory loss from being an obstacle.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNThiYjM3MzktMDg3Yy00ZWQ3LTk3YWEtN2M0YmNmNWEwYTE3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":9,\n" +
            "         \"title\":\"The Intouchables\",\n" +
            "         \"year\":\"2011\",\n" +
            "         \"runtime\":\"112\",\n" +
            "         \"genres\":[\n" +
            "            \"Biography\",\n" +
            "            \"Comedy\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Olivier Nakache, Eric Toledano\",\n" +
            "         \"actors\":\"François Cluzet, Omar Sy, Anne Le Ny, Audrey Fleurot\",\n" +
            "         \"plot\":\"After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":10,\n" +
            "         \"title\":\"Stardust\",\n" +
            "         \"year\":\"2007\",\n" +
            "         \"runtime\":\"127\",\n" +
            "         \"genres\":[\n" +
            "            \"Adventure\",\n" +
            "            \"Family\",\n" +
            "            \"Fantasy\"\n" +
            "         ],\n" +
            "         \"director\":\"Matthew Vaughn\",\n" +
            "         \"actors\":\"Ian McKellen, Bimbo Hart, Alastair MacIntosh, David Kelly\",\n" +
            "         \"plot\":\"In a countryside town bordering on a magical land, a young man makes a promise to his beloved that he'll retrieve a fallen star by venturing into the magical realm.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjkyMTE1OTYwNF5BMl5BanBnXkFtZTcwMDIxODYzMw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":11,\n" +
            "         \"title\":\"Apocalypto\",\n" +
            "         \"year\":\"2006\",\n" +
            "         \"runtime\":\"139\",\n" +
            "         \"genres\":[\n" +
            "            \"Action\",\n" +
            "            \"Adventure\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Mel Gibson\",\n" +
            "         \"actors\":\"Rudy Youngblood, Dalia Hernández, Jonathan Brewer, Morris Birdyellowhead\",\n" +
            "         \"plot\":\"As the Mayan kingdom faces its decline, the rulers insist the key to prosperity is to build more temples and offer human sacrifices. Jaguar Paw, a young man captured for sacrifice, flees to avoid his fate.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNTM1NjYyNTY5OV5BMl5BanBnXkFtZTcwMjgwNTMzMQ@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":12,\n" +
            "         \"title\":\"Taxi Driver\",\n" +
            "         \"year\":\"1976\",\n" +
            "         \"runtime\":\"113\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Martin Scorsese\",\n" +
            "         \"actors\":\"Diahnne Abbott, Frank Adu, Victor Argo, Gino Ardito\",\n" +
            "         \"plot\":\"A mentally unstable Vietnam War veteran works as a night-time taxi driver in New York City where the perceived decadence and sleaze feeds his urge for violent action, attempting to save a preadolescent prostitute in the process.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNGQxNDgzZWQtZTNjNi00M2RkLWExZmEtNmE1NjEyZDEwMzA5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":13,\n" +
            "         \"title\":\"No Country for Old Men\",\n" +
            "         \"year\":\"2007\",\n" +
            "         \"runtime\":\"122\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\",\n" +
            "            \"Thriller\"\n" +
            "         ],\n" +
            "         \"director\":\"Ethan Coen, Joel Coen\",\n" +
            "         \"actors\":\"Tommy Lee Jones, Javier Bardem, Josh Brolin, Woody Harrelson\",\n" +
            "         \"plot\":\"Violence and mayhem ensue after a hunter stumbles upon a drug deal gone wrong and more than two million dollars in cash near the Rio Grande.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5Njk3MjM4OV5BMl5BanBnXkFtZTcwMTc5MTE1MQ@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":14,\n" +
            "         \"title\":\"Planet 51\",\n" +
            "         \"year\":\"2009\",\n" +
            "         \"runtime\":\"91\",\n" +
            "         \"genres\":[\n" +
            "            \"Animation\",\n" +
            "            \"Adventure\",\n" +
            "            \"Comedy\"\n" +
            "         ],\n" +
            "         \"director\":\"Jorge Blanco, Javier Abad, Marcos Martínez\",\n" +
            "         \"actors\":\"Jessica Biel, John Cleese, Gary Oldman, Dwayne Johnson\",\n" +
            "         \"plot\":\"An alien civilization is invaded by Astronaut Chuck Baker, who believes that the planet was uninhabited. Wanted by the military, Baker must get back to his ship before it goes into orbit without him.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMTUyOTAyNTA5Ml5BMl5BanBnXkFtZTcwODU2OTM0Mg@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":15,\n" +
            "         \"title\":\"Looper\",\n" +
            "         \"year\":\"2012\",\n" +
            "         \"runtime\":\"119\",\n" +
            "         \"genres\":[\n" +
            "            \"Action\",\n" +
            "            \"Crime\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Rian Johnson\",\n" +
            "         \"actors\":\"Joseph Gordon-Levitt, Bruce Willis, Emily Blunt, Paul Dano\",\n" +
            "         \"plot\":\"In 2074, when the mob wants to get rid of someone, the target is sent into the past, where a hired gun awaits - someone like Joe - who one day learns the mob wants to 'close the loop' by sending back Joe's future self for assassination.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMTY3NTY0MjEwNV5BMl5BanBnXkFtZTcwNTE3NDA1OA@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":16,\n" +
            "         \"title\":\"Corpse Bride\",\n" +
            "         \"year\":\"2005\",\n" +
            "         \"runtime\":\"77\",\n" +
            "         \"genres\":[\n" +
            "            \"Animation\",\n" +
            "            \"Drama\",\n" +
            "            \"Family\"\n" +
            "         ],\n" +
            "         \"director\":\"Tim Burton, Mike Johnson\",\n" +
            "         \"actors\":\"Johnny Depp, Helena Bonham Carter, Emily Watson, Tracey Ullman\",\n" +
            "         \"plot\":\"When a shy groom practices his wedding vows in the inadvertent presence of a deceased young woman, she rises from the grave assuming he has married her.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMTk1MTY1NjU4MF5BMl5BanBnXkFtZTcwNjIzMTEzMw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":17,\n" +
            "         \"title\":\"The Third Man\",\n" +
            "         \"year\":\"1949\",\n" +
            "         \"runtime\":\"93\",\n" +
            "         \"genres\":[\n" +
            "            \"Film-Noir\",\n" +
            "            \"Mystery\",\n" +
            "            \"Thriller\"\n" +
            "         ],\n" +
            "         \"director\":\"Carol Reed\",\n" +
            "         \"actors\":\"Joseph Cotten, Alida Valli, Orson Welles, Trevor Howard\",\n" +
            "         \"plot\":\"Pulp novelist Holly Martins travels to shadowy, postwar Vienna, only to find himself investigating the mysterious death of an old friend, Harry Lime.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMwNzMzMTQ0Ml5BMl5BanBnXkFtZTgwNjExMzUwNjE@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":18,\n" +
            "         \"title\":\"The Beach\",\n" +
            "         \"year\":\"2000\",\n" +
            "         \"runtime\":\"119\",\n" +
            "         \"genres\":[\n" +
            "            \"Adventure\",\n" +
            "            \"Drama\",\n" +
            "            \"Romance\"\n" +
            "         ],\n" +
            "         \"director\":\"Danny Boyle\",\n" +
            "         \"actors\":\"Leonardo DiCaprio, Daniel York, Patcharawan Patarakijjanon, Virginie Ledoyen\",\n" +
            "         \"plot\":\"Twenty-something Richard travels to Thailand and finds himself in possession of a strange map. Rumours state that it leads to a solitary beach paradise, a tropical bliss - excited and intrigued, he sets out to find it.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BN2ViYTFiZmUtOTIxZi00YzIxLWEyMzUtYjQwZGNjMjNhY2IwXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":19,\n" +
            "         \"title\":\"Scarface\",\n" +
            "         \"year\":\"1983\",\n" +
            "         \"runtime\":\"170\",\n" +
            "         \"genres\":[\n" +
            "            \"Crime\",\n" +
            "            \"Drama\"\n" +
            "         ],\n" +
            "         \"director\":\"Brian De Palma\",\n" +
            "         \"actors\":\"Al Pacino, Steven Bauer, Michelle Pfeiffer, Mary Elizabeth Mastrantonio\",\n" +
            "         \"plot\":\"In Miami in 1980, a determined Cuban immigrant takes over a drug cartel and succumbs to greed.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAzOTM4MzEwNl5BMl5BanBnXkFtZTgwMzU1OTc1MDE@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":20,\n" +
            "         \"title\":\"Sid and Nancy\",\n" +
            "         \"year\":\"1986\",\n" +
            "         \"runtime\":\"112\",\n" +
            "         \"genres\":[\n" +
            "            \"Biography\",\n" +
            "            \"Drama\",\n" +
            "            \"Music\"\n" +
            "         ],\n" +
            "         \"director\":\"Alex Cox\",\n" +
            "         \"actors\":\"Gary Oldman, Chloe Webb, David Hayman, Debby Bishop\",\n" +
            "         \"plot\":\"Morbid biographical story of Sid Vicious, bassist with British punk group the Sex Pistols, and his girlfriend Nancy Spungen. When the Sex Pistols break up after their fateful US tour, ...\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjExNjA5NzY4M15BMl5BanBnXkFtZTcwNjQ2NzI5NA@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":21,\n" +
            "         \"title\":\"Black Swan\",\n" +
            "         \"year\":\"2010\",\n" +
            "         \"runtime\":\"108\",\n" +
            "         \"genres\":[\n" +
            "            \"Drama\",\n" +
            "            \"Thriller\"\n" +
            "         ],\n" +
            "         \"director\":\"Darren Aronofsky\",\n" +
            "         \"actors\":\"Natalie Portman, Mila Kunis, Vincent Cassel, Barbara Hershey\",\n" +
            "         \"plot\":\"A committed dancer wins the lead role in a production of Tchaikovsky's \\\"Swan Lake\\\" only to find herself struggling to maintain her sanity.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BNzY2NzI4OTE5MF5BMl5BanBnXkFtZTcwMjMyNDY4Mw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":22,\n" +
            "         \"title\":\"Inception\",\n" +
            "         \"year\":\"2010\",\n" +
            "         \"runtime\":\"148\",\n" +
            "         \"genres\":[\n" +
            "            \"Action\",\n" +
            "            \"Adventure\",\n" +
            "            \"Sci-Fi\"\n" +
            "         ],\n" +
            "         \"director\":\"Christopher Nolan\",\n" +
            "         \"actors\":\"Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy\",\n" +
            "         \"plot\":\"A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":23,\n" +
            "         \"title\":\"The Deer Hunter\",\n" +
            "         \"year\":\"1978\",\n" +
            "         \"runtime\":\"183\",\n" +
            "         \"genres\":[\n" +
            "            \"Drama\",\n" +
            "            \"War\"\n" +
            "         ],\n" +
            "         \"director\":\"Michael Cimino\",\n" +
            "         \"actors\":\"Robert De Niro, John Cazale, John Savage, Christopher Walken\",\n" +
            "         \"plot\":\"An in-depth examination of the ways in which the U.S. Vietnam War impacts and disrupts the lives of people in a small industrial town in Pennsylvania.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYzYmRmZTQtYjk2NS00MDdlLTkxMDAtMTE2YTM2ZmNlMTBkXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":24,\n" +
            "         \"title\":\"Chasing Amy\",\n" +
            "         \"year\":\"1997\",\n" +
            "         \"runtime\":\"113\",\n" +
            "         \"genres\":[\n" +
            "            \"Comedy\",\n" +
            "            \"Drama\",\n" +
            "            \"Romance\"\n" +
            "         ],\n" +
            "         \"director\":\"Kevin Smith\",\n" +
            "         \"actors\":\"Ethan Suplee, Ben Affleck, Scott Mosier, Jason Lee\",\n" +
            "         \"plot\":\"Holden and Banky are comic book artists. Everything's going good for them until they meet Alyssa, also a comic book artist. Holden falls for her, but his hopes are crushed when he finds out she's gay.\",\n" +
            "         \"posterUrl\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BZDM3MTg2MGUtZDM0MC00NzMwLWE5NjItOWFjNjA2M2I4YzgxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"id\":25,\n" +
            "         \"title\":\"Django Unchained\",\n" +
            "         \"year\":\"2012\",\n" +
            "         \"runtime\":\"165\",\n" +
            "         \"genres\":[\n" +
            "            \"Drama\",\n" +
            "            \"Western\"\n" +
            "         ],\n" +
            "         \"director\":\"Quentin Tarantino\",\n" +
            "         \"actors\":\"Jamie Foxx, Christoph Waltz, Leonardo DiCaprio, Kerry Washington\",\n" +
            "         \"plot\":\"With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.\",\n" +
            "         \"posterUrl\":\"http://ia.media-imdb.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_SX300.jpg\"\n" +
            "       }\n" +
            "   ]\n" +
            "}"

}