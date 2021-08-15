import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate

/**
 * Returns true if folder was created
 */
fun createFolder(day: Int): Boolean {
    val folderName = "day${day}"

    if(File(folderName).exists()) {
        return false
    }

    Files.createDirectory(Paths.get(folderName))
    return true
}


val currentDateDay = LocalDate.now().dayOfMonth
createFolder(currentDateDay)