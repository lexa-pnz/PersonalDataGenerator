package creatingPersonalData

import Constants.END_POST_CODE
import Constants.END_YEAR_OF_BIRTH
import Constants.GENDER_MAN
import Constants.GENDER_WOMAN
import Constants.MAX_FLAT_NUMBER
import Constants.MAX_HOUSE_NUMBER
import Constants.START_POST_CODE
import Constants.START_YEAR_OF_BIRTH
import creatingPersonalData.PersonalData.genderList
import java.time.LocalDate
import java.util.concurrent.ThreadLocalRandom

class RandomPersonalData {

    companion object {

        fun randomData(max: Int): Int{
            return (0 until max).random()
        }

        fun randomDateOfBirth(): LocalDate? {

            val startDate = LocalDate.of(START_YEAR_OF_BIRTH, 1, 1)
            val start = startDate.toEpochDay()
            val endDate = LocalDate.of(END_YEAR_OF_BIRTH, 1, 1)
            val end = endDate.toEpochDay()

            val randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().asLong

            return LocalDate.ofEpochDay(randomEpochDay)
        }

        fun randomGender(): String?{

            val i = (0 until genderList.size).random()
            return if (i == 0)
                genderList[GENDER_MAN]
            else
                genderList[GENDER_WOMAN]
        }

        fun randomPostCode(): Int{

            return (START_POST_CODE..END_POST_CODE).random()
        }

        fun randomHouseNumber(): Int{

            return (1..MAX_HOUSE_NUMBER).random()
        }


        fun randomFlatNumber(): Int{
            return (1..MAX_FLAT_NUMBER).random()
        }
    }
}