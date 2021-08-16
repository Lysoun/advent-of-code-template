import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

@file:Include("util-git.kts")

        /**
         * Returns true if folder was created
         */
fun createFolder(day: Int): String {
    println("Try creating folder for day $day")
    val folderName = "day$day"

    if (File(folderName).exists()) {
        println("Folder was not created because it already existed")
    } else {
        println("Create folder $folderName")
        Files.createDirectory(Paths.get(folderName))
    }
    return folderName
}

fun createPart1File(folderName: String): Boolean {
    println("Try creating part 1 file in folder $folderName")
    val templatePath = Paths.get("scripts/templates/solution_template.ml")
    val part1FileName = "${folderName}/part1.ml"

    if (File(part1FileName).exists()) {
        println("Part 1 file was not created because it already existed")
        return false
    }

    Files.copy(templatePath, Paths.get(part1FileName))
    return true
}

val currentDateDay = LocalDate.now().dayOfMonth

val folderName = createFolder(currentDateDay)
val part1FileCreated = createPart1File(folderName)
if (part1FileCreated) {
    println("Commit files for day $currentDateDay")
    commitDaySolutionsInit(currentDateDay)
}