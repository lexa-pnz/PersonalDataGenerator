package workingWithPersonalData

import com.itextpdf.text.Font
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import numberOfRecords

class CreateTable {

    internal fun addTableHeader(table: PdfPTable, font: Font) {
            FillingTable.headingsList.forEach { columnTitle: String? ->
                val header = PdfPCell()
                header.borderWidth = 2f
                header.phrase = Phrase(columnTitle, font)
                header.horizontalAlignment = 1

                table.addCell(header)
            }
    }

    internal fun addRows(table: PdfPTable, data: MutableList<Map<String, String>>, font: Font) {
        for(line in 0 until numberOfRecords){
            val peopleInfo = data[line].toMap()

            peopleInfo.values.forEach{ column: String? ->
                table.addCell(Phrase(column.toString(), font))
            }
        }
    }

}
