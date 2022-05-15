package workingWithDocument

import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfPTable

interface DocumentWorker {

    fun createDocument(): Document

    fun openDocument(document: Document)

    fun createTable() : PdfPTable

    fun fillingTable(table: PdfPTable)

    fun addTableToDoc(document: Document, table: PdfPTable)

    fun closeDocument(document: Document)
}