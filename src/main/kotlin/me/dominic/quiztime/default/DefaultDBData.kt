package me.dominic.quiztime.default

import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.repository.QuestionRepository

class DefaultDBData(
    private val questionRepository: QuestionRepository
) {

    fun loadDefaultQuestions(): Int {
        val questions: MutableList<Question> = mutableListOf()
        questions.add(Question(
            question = "Welche Farbe kommt raus, wenn man Rot und Blau mischt?",
            answers = mapOf(
                "Violett" to true,
                "Grün" to false,
                "Orange" to false,
                "Schwarz" to false
            )
        ))
        questions.add(Question(
            question = "Wie viele Kontinente gibt es?",
            answers = mapOf(
                "7" to true,
                "5" to false,
                "6" to false,
                "8" to false
            )
        ))
        questions.add(Question(
            question = "Wer malte die Mona Lisa?",
            answers = mapOf(
                "Leonardo da Vinci" to true,
                "Michelangelo" to false,
                "Raffael" to false,
                "Vincent van Gogh" to false
            )
        ))
        questions.add(Question(
            question = "Was ist die Hauptstadt von Frankreich?",
            answers = mapOf(
                "Paris" to true,
                "Berlin" to false,
                "Rom" to false,
                "Madrid" to false
            )
        ))
        questions.add(Question(
            question = "Welches ist das größte Tier der Welt?",
            answers = mapOf(
                "Blauwal" to true,
                "Afrikanischer Elefant" to false,
                "Giraffe" to false,
                "Weißer Hai" to false
            )
        ))
        questions.add(Question(
            question = "In welchem Jahr begann der Zweite Weltkrieg?",
            answers = mapOf(
                "1939" to true,
                "1914" to false,
                "1941" to false,
                "1945" to false
            )
        ))
        questions.add(Question(
            question = "Welches Element hat das chemische Symbol 'O'?",
            answers = mapOf(
                "Sauerstoff" to true,
                "Gold" to false,
                "Eisen" to false,
                "Kohlenstoff" to false
            )
        ))
        questions.add(Question(
            question = "Wie viele Planeten hat unser Sonnensystem (Stand 2023)?",
            answers = mapOf(
                "Acht" to true,
                "Neun" to false,
                "Sieben" to false,
                "Zehn" to false
            )
        ))
        questions.add(Question(
            question = "Welcher Ozean liegt zwischen Amerika und Europa?",
            answers = mapOf(
                "Atlantischer Ozean" to true,
                "Pazifischer Ozean" to false,
                "Indischer Ozean" to false,
                "Arktischer Ozean" to false
            )
        ))
        questions.add(Question(
            question = "Wer schrieb das Theaterstück 'Romeo und Julia'?",
            answers = mapOf(
                "William Shakespeare" to true,
                "Jane Austen" to false,
                "Charles Dickens" to false,
                "Mark Twain" to false
            )
        ))
        questions.add(Question(
            question = "Welcher Planet ist der Sonne am nächsten?",
            answers = mapOf(
                "Merkur" to true,
                "Venus" to false,
                "Mars" to false,
                "Erde" to false
            )
        ))

        questions.add(Question(
            question = "Wer malte die Mona Lisa?",
            answers = mapOf(
                "Leonardo da Vinci" to true,
                "Pablo Picasso" to false,
                "Vincent van Gogh" to false,
                "Michelangelo" to false
            )
        ))

        questions.add(Question(
            question = "Wie viele Bundesländer hat Deutschland?",
            answers = mapOf(
                "16" to true,
                "14" to false,
                "17" to false,
                "15" to false
            )
        ))

        questions.add(Question(
            question = "Was ist die Hauptstadt von Australien?",
            answers = mapOf(
                "Canberra" to true,
                "Sydney" to false,
                "Melbourne" to false,
                "Perth" to false
            )
        ))

        questions.add(Question(
            question = "Welches chemische Element hat das Symbol 'O'?",
            answers = mapOf(
                "Sauerstoff" to true,
                "Gold" to false,
                "Wasserstoff" to false,
                "Osmium" to false
            )
        ))

        questions.add(Question(
            question = "In welchem Jahr fiel die Berliner Mauer?",
            answers = mapOf(
                "1989" to true,
                "1990" to false,
                "1987" to false,
                "1991" to false
            )
        ))

        questions.add(Question(
            question = "Welches ist das höchste Gebirge der Welt?",
            answers = mapOf(
                "Himalaya" to true,
                "Anden" to false,
                "Rocky Mountains" to false,
                "Alpen" to false
            )
        ))
        questions.add(Question(
            question = "Welches Land ist bekannt für Kängurus?",
            answers = mapOf(
                "Australien" to true,
                "Südafrika" to false,
                "Argentinien" to false,
                "Indien" to false
            )
        ))
        questions.add(Question(
            question = "Wer entwickelte die Relativitätstheorie?",
            answers = mapOf(
                "Albert Einstein" to true,
                "Isaac Newton" to false,
                "Galileo Galilei" to false,
                "Stephen Hawking" to false
            )
        ))
        questions.add(Question(
            question = "Welches ist das längste Fluss der Welt?",
            answers = mapOf(
                "Amazonas" to true,
                "Nil" to false,
                "Jangtsekiang" to false,
                "Mississippi" to false
            )
        ))
        questions.add(Question(
            question = "Welches Metall ist der Hauptbestandteil von Stahl?",
            answers = mapOf(
                "Eisen" to true,
                "Kupfer" to false,
                "Aluminium" to false,
                "Zink" to false
            )
        ))
        questions.add(Question(
            question = "Welches ist die Hauptstadt der Vereinigten Staaten von Amerika?",
            answers = mapOf(
                "Washington, D.C." to true,
                "New York City" to false,
                "Los Angeles" to false,
                "Chicago" to false
            )
        ))
        questions.add(Question(
            question = "Welches ist das chemische Symbol für Wasser?",
            answers = mapOf(
                "H₂O" to true,
                "CO₂" to false,
                "NaCl" to false,
                "O₂" to false
            )
        ))
        questions.add(Question(
            question = "Welcher Planet wird auch der 'Rote Planet' genannt?",
            answers = mapOf(
                "Mars" to true,
                "Jupiter" to false,
                "Venus" to false,
                "Saturn" to false
            )
        ))
        questions.add(Question(
            question = "Welches berühmte Gemälde zeigt eine Frau mit einem geheimnisvollen Lächeln?",
            answers = mapOf(
                "Mona Lisa" to true,
                "Das Mädchen mit dem Perlenohrring" to false,
                "Die Sternennacht" to false,
                "Der Schrei" to false
            )
        ))

        questions.add(Question(
            question = "Wie heißt der längste Fluss der Welt?",
            answers = mapOf(
                "Nil" to true,
                "Amazonas" to false,
                "Mississippi" to false,
                "Jangtsekiang" to false
            )
        ))

        questions.add(Question(
            question = "Welches Land hat die größte Bevölkerung?",
            answers = mapOf(
                "China" to true,
                "Indien" to false,
                "USA" to false,
                "Indonesien" to false
            )
        ))

        questions.add(Question(
            question = "Wie viele Zähne hat ein erwachsener Mensch normalerweise?",
            answers = mapOf(
                "32" to true,
                "28" to false,
                "30" to false,
                "36" to false
            )
        ))

        questions.add(Question(
            question = "Wie viele Planeten hat unser Sonnensystem?",
            answers = mapOf(
                "8" to true,
                "9" to false,
                "7" to false,
                "10" to false
            )
        ))

        questions.add(Question(
            question = "Wer schrieb 'Faust'?",
            answers = mapOf(
                "Johann Wolfgang von Goethe" to true,
                "Friedrich Schiller" to false,
                "Heinrich Heine" to false,
                "Thomas Mann" to false
            )
        ))

        questions.add(Question(
            question = "Wie heißt das größte Säugetier der Welt?",
            answers = mapOf(
                "Blauwal" to true,
                "Elefant" to false,
                "Giraffe" to false,
                "Pottwal" to false
            )
        ))

        questions.add(Question(
            question = "Welche Stadt wird auch 'Die ewige Stadt' genannt?",
            answers = mapOf(
                "Rom" to true,
                "Athen" to false,
                "Jerusalem" to false,
                "Kairo" to false
            )
        ))

        questions.add(Question(
            question = "Wie viele Minuten hat eine Stunde?",
            answers = mapOf(
                "60" to true,
                "100" to false,
                "30" to false,
                "90" to false
            )
        ))


        questionRepository.saveAll(questions)
        return questions.size
    }
}