import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

@file:Include("git-utils.kts")

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

fun createPart1File(folderName: String) {
    println("Create part 1 file in folder $folderName")
    val templatePath = Paths.get("scripts/templates/solution_template.ml")
    Files.copy(templatePath, Paths.get("${folderName}/part1.ml"))
}

val currentDateDay = LocalDate.now().dayOfMonth

val folderName = createFolder(currentDateDay)
createPart1File(folderName)
println("Commit files for day $currentDateDay")
commitDaySolutionsInit(currentDateDay)