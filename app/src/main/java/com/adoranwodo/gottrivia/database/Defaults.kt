package com.adoranwodo.gottrivia.database

import com.adoranwodo.gottrivia.model.Question

const val DATABASE_NAME = "GotTriviaQuiz.db"

const val QUESTION_TABLE_NAME = "questions"
const val SCORE_TABLE_NAME = "scores"

val appQuestions = arrayListOf<Question>(
    Question( question = "Daenerys Targaryen hatched her dragon eggs in a ", difficulty = "Easy", optionA = "Fireplace",
        optionB = "Funeral pyre", optionC = "Burning forest", answer = "Funeral pyre"),
    Question(question = "Valar Morghulis is usually responded with ", difficulty = "Hard", optionA = "Valar Bohnaris",
        optionB = "Valar Rohaires", optionC = "Valar Dohaeris", answer = "Valar Dohaeris"),
    Question(question = "What can put out wildfire", difficulty = "Hard", optionA = "Sand",
        optionB = "Water", optionC = "Dragon's blood", answer = "Sand"),
    Question(question = "What substance is capable of defeating whitewalkers", difficulty = "Easy", optionA = "Dragon Stone",
        optionB = "Valyrian Steel", optionC = "Wildfire", answer = "Valyrian Steel"),
    Question(question = "How many times has Beric Dondarrion been brought back to life", difficulty = "Hard", optionA = "Five",
        optionB = "Seven", optionC = "Six", answer = "Six"),
    Question(question = "Which Stark family direwolf was killed in retaliation for an attack on Price Joffery", difficulty = "Medium",
        optionA = "Lady", optionB = "Nymeria", optionC = "Ghost", answer = "Lady"),
    Question(question = "Arya's punishment for stealing from the many-face god was", difficulty = "Easy",
        optionA = "Losing Needle", optionB = "Hunger", optionC = "Blindness", answer = "Blindness"),
    Question(question = "This character said 'Its nothing' right before he died", difficulty = "Hard",
        optionA = "Tywin Lannister", optionB = "King Joffrey", optionC = "Renly Baratheon", answer = "King Joffrey"),
    Question(question = "The name of King Tommen's favorite cat is", difficulty = "Medium",
        optionA = "Battle Pus", optionB = "Little Lion", optionC = "Ser Pounce", answer = "Ser Pounce"),
    Question(question = "What's the name of Ned Stark's greatsword", difficulty = "Medium",
        optionA = "Ice", optionB = "Northguard", optionC = "Widow's Wall", answer = "Ice"),
    Question(question = "Who shoots the flaming arrow that destroy's Stannis fleet in Blackwater Bay", difficulty = "Hard",
        optionA = "King Joffrey", optionB = "Jaime Lannister", optionC = "Bronn", answer = "Bronn"),
    Question(question = "Prince Oberyn Martell is nicknamed the Red Viper because of his combat and ", difficulty = "Medium",
        optionA = "Killings", optionB = "Ruby colored armor", optionC = "Knowledge of poisons", answer = "Knowledge of poisons"),
    Question(question = "The Night King was created using a dagger made of ", difficulty = "Easy",
        optionA = "Blue Ice", optionB = "Dragonglass", optionC = "Valyrian Steel", answer = "Dragonglass"),
    Question(question = "How many arrows does Ramsay Bolton let loose at Rickon Stark ", difficulty = "Medium",
        optionA = "Two", optionB = "Three", optionC = "Four", answer = "Four"),
    Question(question = "Who created the secret tunnel in the sewers under Casterly Rock ", difficulty = "Hard",
        optionA = "Varys", optionB = "Tyrion Lannister", optionC = "Lord Baelish", answer = "Tyrion Lannister"),
    Question(question = "What's Sansa Stark's favorite thing to eat ", difficulty = "Easy",
        optionA = "Honey cake", optionB = "Strawberry pie", optionC = "Lemon cake", answer = "Lemon cake"),
    Question(question = "Dead creatures revived by white walkers are known as ", difficulty = "Easy",
        optionA = "Walkers", optionB = "Wights", optionC = "Dead", answer = "Wights"),
    Question(question = "Who was Lord Commander of the Kingsguard at the beginning of Game of Thrones ", difficulty = "Easy",
        optionA = "Ser Jaime Lannister", optionB = "Ser Jeor Mormont", optionC = "Ser Barristan Selmy", answer = "Ser Barristan Selmy"),
    Question(question = "Who was Margaery Tyrell's first husband ", difficulty = "Easy",
        optionA = "Renly Baratheon", optionB = "Tommen Baratheon", optionC = "Joffrey Baratheon", answer = "Renly Baratheon"),
    Question(question = "How many times has Sansa Stark been married", difficulty = "Easy",
        optionA = "Once", optionB = "Twice", optionC = "Three times", answer = "Twice"),
    Question(question = "Who is the ruler of the Iron Islands at the beginning of Game of Thrones", difficulty = "Easy",
        optionA = "Yara Greyjoy", optionB = "Aeron Greyjoy", optionC = "Balon Greyjoy", answer = "Balon Greyjoy"),
    Question(question = "Who is the mad king's first born son", difficulty = "Easy",
        optionA = "Rhaegal Targaryen", optionB = "Rhaegar Targaryen", optionC = "Viserys Targaryen", answer = "Rhaegar Targaryen"),
    Question(question = "Who delivered the fatal blow to Robb Stark", difficulty = "Medium",
        optionA = "Walder Frey", optionB = "Roose Bolton", optionC = "Alliser Thorne", answer = "Roose Bolton"),
    Question(question = "Grey Worm and Missandei became allies of Daenaerys Targaryen after she liberated the slaves of which city", difficulty = "Easy",
        optionA = "Yunkai", optionB = "Astapor", optionC = "Meeren", answer = "Astapor"),
    Question(question = "What is the name of the royal executioner who beheaded Ned Stark for treason", difficulty = "Medium",
        optionA = "Walder Frey", optionB = "Roose Bolton", optionC = "Alliser Thorne", answer = "Roose Bolton")

)