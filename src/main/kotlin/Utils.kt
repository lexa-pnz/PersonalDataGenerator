import Constants.FONT_FILENAME
import Constants.FONT_SIZE
import Constants.FORMAT_DATE
import com.itextpdf.text.Font
import com.itextpdf.text.pdf.BaseFont
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Utils {

    companion object {

        fun keyboardInput(): Boolean {

            print("Сгенерировать данные для n человек: ")
            return try {
                numberOfRecords = readLine()!!.toInt()
                return true
            } catch (e: Exception){
                println("\nОшибка ввода: $e")
                return false
            }
        }

        fun checkInputData(inputData: Int): Boolean{

            return inputData in 1..30
        }

        fun fontSettings(): Font {

            val bf = BaseFont.createFont(FONT_FILENAME, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
            return Font(bf, FONT_SIZE, Font.NORMAL)
        }

        fun formattedDateOfBirth(randomEpochDay: LocalDate): String {

            val formatter = DateTimeFormatter
                .ofPattern(FORMAT_DATE)

            return randomEpochDay.format(formatter)
        }

        fun ageCalculation(yearOfBirth: LocalDate?): Int{

            val yearOfBirth: Int? = yearOfBirth?.year
            val currentYear: Int = LocalDate.now().year

            return currentYear - yearOfBirth!!
        }

        fun getFilePath(fileName: String): String {

            return Paths.get(fileName).toAbsolutePath().toString()
        }

    }
}