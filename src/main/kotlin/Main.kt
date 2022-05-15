import Utils.Companion.checkInputData
import Utils.Companion.keyboardInput
import workingWithDocument.PersonalDataGeneratorInDoc

var numberOfRecords = 0

fun main(){

    if (keyboardInput()) {

        if(checkInputData(numberOfRecords)) {

            val personalDataGeneratorInDoc = PersonalDataGeneratorInDoc()
            val document = personalDataGeneratorInDoc.createDocument()
            val table = personalDataGeneratorInDoc.createTable()

            try {
                personalDataGeneratorInDoc.openDocument(document)

                personalDataGeneratorInDoc.fillingTable(table)

                personalDataGeneratorInDoc.addTableToDoc(document, table)

                personalDataGeneratorInDoc.closeDocument(document)

                personalDataGeneratorInDoc.outputFinalMessage()
            }
            catch (e:Exception){
                println("Ошибка в работе приложения: $e")
            }
        }

        else println("\nОшибка ввода:\nМинимальное число записей - 1; Максимальное число записей - 30")
    }

    else println("Повторите запуск с корректными входными данными")
}