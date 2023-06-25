package com.example.quizapp.data

import com.example.quizapp.model.Options
import com.example.quizapp.model.Question

object DataSource {
    val mathematicsQuestions = listOf(
        Question(
            "What is the square root of 16?",
            Options("2", "4", "8", "16", "4")
        )
        ,
        Question(
            "What is the result of 3 + 7?",
            Options("7", "10", "12", "14", "10")
        )
        ,
        Question(
            "Solve for x: 2x + 5 = 13",
            Options("3", "4", "6", "9", "4")
        ),
        Question(
            "What is the value of pi (π) to two decimal places?",
            Options("3.14", "3.16", "3.18", "3.20", "3.14")
        ),
        Question(
            "If a triangle has angles measuring 30°, 60°, and 90°, what type of triangle is it?",
            Options("Equilateral", "Isosceles", "Scalene", "Right", "Right")
        ),
        Question(
            "What is the result of 5 multiplied by -3?",
            Options("-15", "-8", "15", "8", "-15")
        ),
        Question(
            "What is the value of log10(100)?",
            Options("0", "1", "2", "10", "2")
        ),
        Question(
            "What is the formula for the area of a circle?",
            Options("πr^2", "2πr", "πd", "2πd", "πr^2")
        ),
        Question(
            "What is the sum of the interior angles of a quadrilateral?",
            Options("180°", "360°", "450°", "540°", "360°")
        ),
        Question(
            "What is the result of 2 to the power of 5?",
            Options("8", "16", "24", "32", "32")
        )
    )

    val scienceQuestions = listOf(
        Question(
            "What is the process by which plants convert light energy into chemical energy?",
            Options("Photosynthesis", "Respiration", "Transpiration", "Fermentation", "Photosynthesis")
        ),
        Question(
            "What is the smallest unit of matter?",
            Options("Atom", "Molecule", "Cell", "Element", "Atom")
        )
        ,
        Question(
            "What is the force that pulls objects towards the center of the Earth?",
            Options("Gravity", "Magnetism", "Friction", "Inertia", "Gravity")
        ),
        Question(
            "Which gas makes up the majority of the Earth's atmosphere?",
            Options("Nitrogen", "Oxygen", "Carbon dioxide", "Argon", "Nitrogen")
        ),
        Question(
            "What is the basic unit of life?",
            Options("Cell", "Tissue", "Organ", "Organism", "Cell")
        ),
        Question(
            "What is the process by which an organism develops from a fertilized egg?",
            Options("Embryogenesis", "Metamorphosis", "Reproduction", "Development", "Embryogenesis")
        ),
        Question(
            "What is the study of heredity and variation in organisms?",
            Options("Genetics", "Ecology", "Evolution", "Anatomy", "Genetics")
        ),
        Question(
            "Which planet in our solar system is known as the Red Planet?",
            Options("Mars", "Jupiter", "Venus", "Saturn", "Mars")
        ),
        Question(
            "What is the process of changing from a liquid to a gas called?",
            Options("Evaporation", "Condensation", "Sublimation", "Melting", "Evaporation")
        ),
        Question(
            "What is the largest organ in the human body?",
            Options("Skin", "Heart", "Liver", "Brain", "Skin")
        )
    )
    val gkQuestions = listOf(
        Question(
            "Which planet is known as the Red Planet?",
            Options("Mars", "Jupiter", "Venus", "Saturn", "Mars")
        ),
        Question(
            "What is the capital city of France?",
            Options("Paris", "London", "Rome", "Berlin", "Paris")
        )
        ,
        Question(
            "Who painted the Mona Lisa?",
            Options("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", "Leonardo da Vinci")
        ),
        Question(
            "Which country is famous for the Taj Mahal?",
            Options("India", "China", "Egypt", "Brazil", "India")
        ),
        Question(
            "What is the currency of Japan?",
            Options("Yen", "Euro", "Dollar", "Pound", "Yen")
        ),
        Question(
            "Which ocean is the largest in the world?",
            Options("Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean")
        ),
        Question(
            "What is the national animal of Canada?",
            Options("Beaver", "Lion", "Kangaroo", "Bald Eagle", "Beaver")
        ),
        Question(
            "Who wrote the play 'Romeo and Juliet'?",
            Options("William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain", "William Shakespeare")
        ),
        Question(
            "Which famous scientist developed the theory of relativity?",
            Options("Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking", "Albert Einstein")
        ),
        Question(
            "Which country hosted the 2016 Summer Olympics?",
            Options("Brazil", "China", "United States", "Russia", "Brazil")
        )
    )
    val androidQuestions = listOf(
        Question(
            "What is an activity in Android?",
            Options("A user interface component", "A background service", "A database table", "A network request", "A user interface component")
        ),
        Question(
            "What is the purpose of an Intent in Android?",
            Options("To launch an activity", "To perform background computation", "To store data locally", "To handle network requests", "To launch an activity")
        ),
        Question(
            "What is the main programming language used for Android app development?",
            Options("Java", "C#", "Swift", "Python", "Java")
        ),
        Question(
            "What is the name of the layout file used to define the user interface of an Android activity?",
            Options(
                "XML layout file",
                "HTML layout file",
                "CSS layout file",
                "JSON layout file",
                "XML layout file"
            )
        ),
        Question(
            "What is an APK in the context of Android?",
            Options(
                "Android Package Kit",
                "Android Project Kernel",
                "Android Program Key",
                "Android Processor Kit",
                "Android Package Kit"
            )
        ),
        Question(
            "What is the purpose of the AndroidManifest.xml file?",
            Options(
                "To declare the app's components and permissions",
                "To store user preferences",
                "To define the app's layout",
                "To handle database operations",
                "To declare the app's components and permissions"
            )
        ),
        Question(
            "What is an AsyncTask in Android?",
            Options(
                "A class for performing background operations and publishing results on the UI thread",
                "A type of user interface component",
                "A database query operation",
                "A network communication library",
                "A class for performing background operations and publishing results on the UI thread"
            )
        ),
        Question(
            "What is the purpose of the RecyclerView in Android?",
            Options(
                "To efficiently display large lists or grids of data",
                "To handle user gestures and touch events",
                "To manage app permissions",
                "To handle network requests",
                "To efficiently display large lists or grids of data"
            )
        ),
        Question(
            "What is the purpose of the Android Emulator?",
            Options(
                "To run and test Android apps on a computer",
                "To optimize app performance",
                "To analyze app crashes",
                "To generate app release builds",
                "To run and test Android apps on a computer"
            )
        ),
        Question(
            "What is the recommended way to store persistent data in an Android app?",
            Options(
                "Using a SQLite database",
                "Using shared preferences",
                "Using internal storage",
                "Using cloud storage",
                "Using a SQLite database"
            )
        )
    )

}