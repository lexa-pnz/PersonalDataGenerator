package workingWithPersonalData

import Constants.GENDER_MAN
import Constants.GENDER_WOMAN
import creatingPersonalData.PersonalData.cityList
import creatingPersonalData.PersonalData.genderList
import creatingPersonalData.PersonalData.womanNameList
import creatingPersonalData.PersonalData.womanPatronymicList
import creatingPersonalData.PersonalData.womanSurnameList
import creatingPersonalData.PersonalData.manNameList
import creatingPersonalData.PersonalData.manPatronymicList
import creatingPersonalData.PersonalData.manSurnameList
import creatingPersonalData.PersonalData.regionList
import creatingPersonalData.PersonalData.streetList
import creatingPersonalData.RandomPersonalData.Companion.randomData
import creatingPersonalData.RandomPersonalData.Companion.randomDateOfBirth
import creatingPersonalData.RandomPersonalData.Companion.randomFlatNumber
import creatingPersonalData.RandomPersonalData.Companion.randomGender
import creatingPersonalData.RandomPersonalData.Companion.randomHouseNumber
import creatingPersonalData.RandomPersonalData.Companion.randomPostCode
import Utils.Companion.ageCalculation
import Utils.Companion.formattedDateOfBirth
import numberOfRecords

class FillingTable {

    companion object {

        val headingsList = listOf("Имя", "Фамилия", "Отчество", "Возраст", "Пол", "Дата рождения", "Место рождения", "Индекс", "Страна", "Область", "Город", "Улица", "Дом", "Квартира")

        private val bodyList = mutableListOf<Map<String, String>>()

        private fun fillingRowsOfTable(i:Int) : Map<String, String> {

            val bodyOfTableList = mutableMapOf<String, String>()
            val gender = randomGender()
            val randomCityAndRegion = randomData(cityList.size)
            val dateOfBirth = randomDateOfBirth()

            if (gender == genderList[GENDER_MAN]){
                bodyOfTableList["name"] = manNameList[randomData(manNameList.size)]
                bodyOfTableList["surname"] = manSurnameList[randomData(manSurnameList.size)]
                bodyOfTableList["patronymic"] = manPatronymicList[randomData(manPatronymicList.size)]
            }
            else if (gender == genderList[GENDER_WOMAN]){
                bodyOfTableList["name"] = womanNameList[randomData(womanNameList.size)]
                bodyOfTableList["surname"] = womanSurnameList[randomData(womanSurnameList.size)]
                bodyOfTableList["patronymic"] = womanPatronymicList[randomData(womanPatronymicList.size)]
            }

            bodyOfTableList["age"] = ageCalculation(dateOfBirth).toString()
            bodyOfTableList["gender"] = gender.toString()
            bodyOfTableList["dateOfBirth"] = formattedDateOfBirth(dateOfBirth!!)
            bodyOfTableList["placeOfBirth"] = cityList[randomCityAndRegion]
            bodyOfTableList["postalCode"] = randomPostCode().toString()
            bodyOfTableList["country"] = "Россия"
            bodyOfTableList["region"] = regionList[randomCityAndRegion]
            bodyOfTableList["city"] = cityList[randomCityAndRegion]
            bodyOfTableList["street"] = streetList[randomData(streetList.size)]
            bodyOfTableList["house"] = randomHouseNumber().toString()
            bodyOfTableList["flat"] = randomFlatNumber().toString()

            return bodyOfTableList
        }

        fun fillingBodyOfTable(): MutableList<Map<String, String>> {
            for(i in 0 until numberOfRecords) {
                bodyList.add(fillingRowsOfTable(i))
            }

            return bodyList
        }

    }
}