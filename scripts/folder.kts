@file:Include("util-file.kts")

fun createDayFolder(day: Int): String {
    val folderName = "day$day"
    createFolder(folderName)
    return folderName
}