@file:Include("util-http.kts")
@file:Include("util-file.kts")
@file:Include("util-git.kts")
@file:Include("util-config.kts")


fun retrieveInput(day: Int, sessionId: String): String? {
    val url = "https://adventofcode.com/2020/day/$day/input"
    return get(url, sessionId)
}

fun writeInput(folderName: String, input: String) {
    writeToFile(
        "$folderName/input.txt",
        input
    )
}

fun loadInput(day: Int, folderName: String) {
    println("""
        
        #####################
        ### INPUT LOADING ###
        #####################
        
    """.trimIndent())

    println("# Retrieve input from AOC site")
    val input = retrieveInput(currentDateDay, loadSessionId())

    if (input == null) {
        println("Input was empty; no file was written")
    } else {
        println("# Write input")
        println("Writing input for day $currentDateDay into file")
        writeInput(folderName, input)

        println("Commit input for day $currentDateDay")
        commitInput(currentDateDay)
    }
}

