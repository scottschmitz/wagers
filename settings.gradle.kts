pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            url = uri("https://maven.pkg.github.com/michiganlabs/hoverboard")
            credentials {
                val gitHubHoverboardUsername: String? by settings
                val gitHubHoverboardPassword: String? by settings

                username = gitHubHoverboardUsername ?: System.getenv("GITHUB_USERNAME")
                password = gitHubHoverboardPassword ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

rootProject.name = "Wagers"
include(":app")
