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
    private fun createReleaseNote(version: String?, s: String) {
        val releaseNote = s.replace("{{tag}}", version ?: "")
        val releaseNoteFile = File("${project.basedir}/RELEASE_NOTE_${version}.md")
        releaseNoteFile.writeText(releaseNote)
    }

    override fun execute() {
        log.info("Generating release note")
        log.info("Looking for release note template in $template")
        if (template?.exists() == true) {
            log.info("Found release note template")
            log.info("Generating release note for ${project.version}")
            val version = shellRunner.runShell("git --version")
            log.info("Git version $version")
            createReleaseNote(project.version, template?.readText() ?: "")
        } else {
            log.error("Release note template not found")
        }
    }


}