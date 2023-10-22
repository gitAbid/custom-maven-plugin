package com.abid.release

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject
import java.io.File


@Mojo(name = "generate-release-note", defaultPhase = LifecyclePhase.COMPILE)
class GenerateReleaseNoteMojo : AbstractMojo() {

    @Parameter(defaultValue = "\${project.basedir}/.release-note-template.md")
    private var template: File? = null

    @Parameter(defaultValue = "\${project}", readonly = true)
    private lateinit var project: MavenProject

    private val shellRunner = ShellRunner()
    private fun createReleaseNote(version: String, map: Map<String, String>, template: String) {
        var releaseNote = template
        map.forEach { (k, v) ->
            releaseNote = releaseNote.replace("{{$k}}", v)
        }
        val releaseNoteFile = File("${project.basedir}/RELEASE_NOTE_${version}.md")
        releaseNoteFile.writeText(releaseNote)
    }

    override fun execute() {
        log.info("Generating release note")
        log.info("Looking for release note template in $template")
        if (template?.exists() == true) {
            log.info("Found release note template")
            log.info("Generating release note for ${project.version}")
            val versions = shellRunner.runShell(gitGetAllTags).split("\n")
            val previousVersion = versions.first().replace("\n", "")
            val currentVersion = versions.drop(1).first().replace("\n", "")
            log.info("Current Release version $currentVersion")
            log.info("Previous Release version $previousVersion")
            createReleaseNote(
                currentVersion, mapOf(
                    "current_version" to currentVersion,
                    "previous_version" to previousVersion
                ), template?.readText() ?: ""
            )
        } else {
            log.error("Release note template not found")
        }
    }


}