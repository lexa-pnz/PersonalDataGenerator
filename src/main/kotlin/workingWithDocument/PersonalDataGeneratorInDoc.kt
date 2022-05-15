package workingWithDocument

import Constants.DOC_NAME
import workingWithPersonalData.FillingTable.Companion.fillingBodyOfTable
import workingWithPersonalData.FillingTable.Companion.headingsList
import Utils.Companion.fontSettings
import Utils.Companion.getFilePath
import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import workingWithPersonalData.CreateTable
import java.io.FileOutputStream

class PersonalDataGeneratorInDoc : DocumentWorker {

    override fun createDocument(): Document {

        return Document(PageSize.A4.rotate())
    }

    override fun openDocument(document: Document) {

        PdfWriter.getInstance(document, FileOutputStream(DOC_NAME))
        document.open()
    }

    override fun createTable(): PdfPTable {
        return PdfPTable(headingsList.size)
    }

    override fun fillingTable(table: PdfPTable) {

        table.widthPercentage = 105f

        val createTable = CreateTable()

        createTable.addTableHeader(table, fontSettings())

        createTable.addRows(table, fillingBodyOfTable(), fontSettings())
    }

    override fun addTableToDoc(document: Document, table: PdfPTable) {

        document.add(table)
    }

    override fun closeDocument(document: Document) {

        document.close()
    }

    fun outputFinalMessage(){

        println("Файл создан. Путь: " + getFilePath(DOC_NAME))
    }

}